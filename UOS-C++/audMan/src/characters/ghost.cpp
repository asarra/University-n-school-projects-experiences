//
//  Ghost.cpp
//  Ghost_2
//
//  Created by Tim-Luca on 18.11.19.
//

#include "ghost.h"
#include "audman.h"
#include "ofAuDApp.h"
#include "level.h"
#include <vector>
using namespace std;

/**
 * Der Standardkonstruktor.
 *
 * @brief Ghost::Ghost
 */
Ghost::Ghost(AuDMan *p) {
    player = p;
    posX = 0;
    posY = 0;
    update = 0;
    huntPlayer = false;
    pointsUpdated = false;
}

/**
 * Mit diesem Konstruktor setzt man die Position.
 *
 * @brief Ghost::Ghost
 * @param x
 * @param y
 */
Ghost::Ghost(AuDMan *p, int x, int y) {
    posX = x;
    posY = y;
    update = 0;
    huntPlayer = false;
    pointsUpdated = false;
}

/**
 * Setzt die Figur in den Level und initialisiert das erste Ziel
 *
 * @brief Ghost::setLevel
 * @param lvl
 */
void Ghost::setLevel(Level *lvl) {
    level = lvl;
    targetX = int(ofRandom(0, level->getWidth()));
    targetY = int(ofRandom(0, level->getHeight()));
}

/**
 * Setzt die Position der Figur im Level.
 *
 * @brief Ghost::setPosition
 * @param x
 * @param y
 */
void Ghost::setPosition(int x, int y) {
    posX = x;
    posY = y;
}


/**
 * Zeichne die Figur an der aktuellen Position.
 * Muss in loop() aufgerufen werden, damit die Figur zu sehen ist.
 *
 * @brief Ghost::draw
 */
void Ghost::draw() {
    // Das Ziel wird auf den Spieler gesetzt, wenn er gejagt werden soll
    if(huntPlayer) {
        targetX = player->getPosition()[0];
        targetY = player->getPosition()[1];
    }
    
    // Die Richtung zum Ziel wird berechnet
    float deltaX = (targetX - posX);
    float deltaY = (targetY - posY);
    
    // Die Richtung wird in eine Bewegung für den Geist gewandelt
    // Mögliche Kombinationen: (0,1),(0,-1),(1,0),(-1,0)
    int movementX = 0;
    int movementY = 0;
    if(abs(deltaX) >= abs(deltaY)) {
        if(deltaX > 0) {
            movementX = 1;
        } else if (deltaX < 0){
            movementX = -1;
        }
    } else {
        if(deltaY > 0) {
            movementY = 1;
        } else if (deltaY < 0){
            movementY = -1;
        }
    }
    
    // Neue Position wird angewendet, mit Verzögerung, damit sich der Geist nicht zu schnell bewegt
    if (update == 10) {
        update = 0;
        posX += movementX;
        posY += movementY;
    }
    update++;
    
    // Wenn der Geist sein Ziel erreicht hat
    if (targetX == posX && targetY == posY) {
        if(huntPlayer) {
            if(!pointsUpdated) {
                //Dem Spieler werden 4 Punkte abgezogen
                player->updatePoints(-4);
                pointsUpdated = true;
            }
            
            // Neues zufälliges Ziel wird festgelegt, Modus wechselt auf Zufall
            huntPlayer = false;
            targetX = int(ofRandom(0, level->getWidth()));
            targetY = int(ofRandom(0, level->getHeight()));
        } else {
            // Modus wechselt auf Spieler-Verfolgung
            huntPlayer = true;
        }
    } else {
        pointsUpdated = false;
    }
    
    int groesse = level->getSize();
    ofSetColor(255,0,0);
    ofDrawCircle((0.5+posX)*groesse,(0.5+posY)*groesse,groesse*0.4);
}

