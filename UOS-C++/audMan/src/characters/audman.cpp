//
//  audman.cpp
//  audman_2
//
//  Created by Tim-Luca on 18.11.19.
//

#include "audman.h"
#include "ofAuDApp.h"
#include "level.h"
#include <vector>
using namespace std;
/**
 * Der Standardkonstruktor.
 *
 * @brief AuDMan::AuDMan
 */
AuDMan::AuDMan() {
    posX = 0;
    posY = 0;
    points = 0;
}

/**
 * Mit diesem Konstruktor setzt man die Position.
 *
 * @brief AuDMan::AuDMan
 * @param x
 * @param y
 */
AuDMan::AuDMan(int x, int y) {
    posX = x;
    posY = y;
    points = 0;
}

/**
 * Setzt die Figur in den Level und setzt die Punkte auf 0.
 *
 * @brief AuDMan::setLevel
 * @param lvl
 */
void AuDMan::setLevel(Level *lvl) {
    level = lvl;
    points = 0;
}

// Gibt die Position der Figur als Vektor zurück
vector<int> AuDMan::getPosition() {
    vector<int> position = {posX, posY};
    return position;
}

/**
 * Setzt die Position der Figur im Level.
 *
 * @brief AuDMan::setPosition
 * @param x
 * @param y
 */
void AuDMan::setPosition(int x, int y) {
    posX = x;
    posY = y;
}

/**
 * Bewegt die Figur um die angegebenen Koordinaten.
 * Dabei werden die Punkte am neuen Ort "gefressen"
 *
 * @brief AuDMan::moveBy
 * @param dx
 * @param dy
 */
void AuDMan::moveBy(int dx, int dy) {
    int breite = level->getWidth();
    int hoehe = level->getHeight();

    // Nächste Position wird ermittelt
    int nextPosX = (posX + dx + breite) % breite;
    int nextPosY = (posY + dy + hoehe) % hoehe;
    
    // Kollisionsüberprüfung mit der Wand
    if (level->getField(nextPosX, nextPosY) != 1) {
        posX = nextPosX;
        posY = nextPosY;
    }

    // Neue Punkte werden aufaddiert, wenn sie "gefressen" wurden
    // 2 = Kreuzer, 3 = Taler
    if ( level->getField(posX,posY) == 2 ) {
        level->setField(posX,posY,0);
        points = points + 1;
    } else if ( level->getField(posX,posY) == 3 ) {
        level->setField(posX,posY,0);
        points = points + 10;
    }
}

// Die Punkteanzahl wird mit den relativen Punkten addiert, kann aber nicht unter 0 gehen
void AuDMan::updatePoints(int relativePoints) {
    points = points + relativePoints;
    
    if(points < 0) {
        points = 0;
    }
}


/**
 * Zeichne die Figur an der aktuellen Position.
 * Muss in loop() aufgerufen werden, damit die Figur zu sehen ist.
 *
 * @brief AuDMan::draw
 */
void AuDMan::draw() {
    int groesse = level->getSize();

    ofSetColor(255,255,127);
    ofDrawCircle((0.5+posX)*groesse,(0.5+posY)*groesse,groesse*0.4);

    ofSetColor(255,255,255);
    ofDrawBitmapString(points,5,ofGetHeight()-5);
}

