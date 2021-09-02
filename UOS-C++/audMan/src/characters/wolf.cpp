//
//  Ghost.cpp
//  Ghost_2
//
//  Created by Tim-Luca on 18.11.19.
//

#include "wolf.hpp"
#include "audman.h"
#include "ofAuDApp.h"
#include "level.h"
#include <vector>
using namespace std;

/**
 * Der Standardkonstruktor.
 *
 * @brief Wolf::Wolf
 */
Wolf::Wolf(AuDMan *p) {
    player = p;
    posX = 0;
    posY = 0;
    dir = 0;
    update = 0;
}

/**
 * Mit diesem Konstruktor setzt man die Position.
 *
 * @brief Wolf::Wolf
 * @param x
 * @param y
 */
Wolf::Wolf(AuDMan *p, int x, int y) {
    player = p;
    posX = x;
    posY = y;
    dir = 0;
    update = 0;
}

/**
 * Setzt die Figur in den Level und setzt die Punkte auf 0.
 *
 * @brief Wolf::setLevel
 * @param lvl
 */
void Wolf::setLevel(Level *lvl) {
    level = lvl;
}

/**
 * Setzt die Position der Figur im Level.
 *
 * @brief Ghost::setPosition
 * @param x
 * @param y
 */
void Wolf::setPosition(int x, int y) {
    posX = x;
    posY = y;
}

// Wandlet die Richtungs-ID in eine Richtung mit dem Format (x,y) um
vector<int> Wolf::getDirection(int d) {
    if (d == 0) {
        return vector<int> {0,-1};
    } else if (d == 1) {
        return vector<int> {1,0};
    } else if (d == 2) {
        return vector<int> {0,1};
    } else if (d == 3) {
        return vector<int> {-1,0};
    }
    return vector<int> {0,0};
}

// Dreht die Richtung um (1->3 3->1 2->0 0->2)
int Wolf::reverseDirection(int d) {
    return (d+2) % 4;
}

// Gibt eine Mögliche Richtung zurück, in der keine Wand ist und die nicht die umgedrehte derzeitige Richtung ist
// Ansonsten wird -1 anstatt der Richtung zurückgegeben
int Wolf::getRandomPossibleDirection() {
    vector<int> possibleDirections = {};
    int reversedDirection = reverseDirection(dir);
    
    // Geht alle Richtungen bis auf die umgedrehte Richtung durch
    for (int i = 0; i < 4; ++i) {
        if (i != reversedDirection) {
            // Prüft, ob, wenn der Richtung gefolgt wird, das Feld eine Wand ist
            vector<int> direction = getDirection(i);
            
            int tmpPosX = (posX + direction[0] + level->getWidth()) % level->getWidth();
            int tmpPosY = (posY + direction[1] + level->getHeight()) % level->getHeight();
            
            if (level->getField(tmpPosX, tmpPosY) != 1) {
                // Ist dort keine Wand, ist es eine Möglichkeit und wird hinzugefügt
                possibleDirections.push_back(i);
            }
        }
    }
    if (possibleDirections.size() > 0) {
        // Eine zufällige Mögliche Richtung wird zurückgegeben
        return possibleDirections[int(ofRandom(0, possibleDirections.size()))];
    } else {
        return -1;
    }
}


/**
* Zeichne die Figur an der aktuellen Position.
* Muss in loop() aufgerufen werden, damit die Figur zu sehen ist.
*
* @brief Ghost::draw
*/
void Wolf::draw() {
    
    if(update == 10) {
        int nextDirection = getRandomPossibleDirection();
        
        // Wenn die Richtung -1 ist, wird sie umgedreht, aber der Wolf bewegt sich nicht
        if(nextDirection == -1) {
            dir = reverseDirection(dir);
        } else {
            dir = nextDirection;
            vector<int> direction = getDirection(dir);
            posX += direction[0];
            posY += direction[1];
        }
        
        posX = (posX + level->getWidth()) % level->getWidth();
        posY = (posY + level->getHeight()) % level->getHeight();
        
        update = 0;
    }
    ++update;
    
    // Wenn der Wolf auf den Spieler trift, wird dieser "gefressen" -> Das Programm wird beendet
    if(posX == player->getPosition()[0] && posY == player->getPosition()[1]) {
        ofExit();
    }
    
    ofSetColor(0,0,255);
    int groesse = level->getSize();
    ofDrawCircle((0.5+posX)*groesse,(0.5+posY)*groesse,groesse*0.4);
}

