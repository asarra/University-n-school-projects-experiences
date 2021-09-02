/**
 *  Diese Klasse enthält alle Informationen zu einem Level.
 **/

#include "level.h"
#include "ofAuDApp.h"

// Ein Beispiellevel
int level_1[20][20] = {
    { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
    { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
    { 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1 },
    { 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1 },
    { 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1 },
    { 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1 },
    { 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1 },
    { 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1 },
    { 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1 },
    { 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 0 },
    { 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1 },
    { 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1 },
    { 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1 },
    { 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1 },
    { 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1 },
    { 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1 },
    { 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1 },
    { 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1 },
    { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
    { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
   };


/**
 * Standardkonstruktor
 *
 * @brief Level::Level
 */
Level::Level() {
    width = 20;
    height = 20;
    size = 20;
    init();
}

/**
 * In diesem Konstruktor kann der Skalierungsfaktor verändert werden
 *
 * @brief Level::Level
 * @param s Skalierungsfaktor
 */
Level::Level(int s) {
    width = 20;
    height = 20;
    size = s;
    init();
}

/**
 * Initialisiert ein Level
 *
 * @brief Level::init
 */
void Level::init() {
   points = 0;
   for ( int row = 0; row < height; row=row+1 ) {
      for ( int column = 0; column < width; column=column+1 ) {
         field[column][row] = level_1[column][row];
         if ( field[column][row] == 0 ) {
             
             // Zu einer Wahrscheinlichkeit von 10% wird eine 10-Punkte-Münze erstellt (ID = 3)
             bool specialCoin = (rand() % 100) < 10;
             
             if(specialCoin) {
                 field[column][row] = 3;
                 points = points+10;
             } else {
                 field[column][row] = 2;
                 points = points+1;
             }
         }
      }
   }
}

/**
 * @brief Level::getField
 * @param x
 * @param y
 * @return
 */
int Level::getField(int x, int y) {
    return field[x][y];
}

/**
 * Setzt den Wert einer bestimmten Zelle
 *
 * @brief Level::setField
 * @param x x-Position
 * @param y y-Position
 * @param value 0 - Weg, 1 - Wand, 2 - Kreuzer
 */
void Level::setField(int x, int y, int value) {
    if ( (x>=0) && (x<width) && (y>=0) &&(y<height)) {
        field[x][y] = value;
    }
}

/**
 * Zeichnet das Level
 * Muss in loop() aufgerufen werden, damit das Level zu sehen ist.
 *
 * @brief Level::draw
 */
void Level::draw() {
    int row = 0;
    int column = 0;

    // Durchlaufe alle Einträge der Matrix field
    for ( row = 0; row < height; row = row+1 ) {
        for ( column = 0; column < width; column = column+1 ) {
            // Je nach wert, zeichne die entsprechende Komponente
            if ( field[column][row] == 1 ) {
                // Eine Wand
                ofSetColor(0,0,255);
                ofDrawRectangle(column*size,row*size,(column+1)*size,(row+1)*size);
            } else if ( field[column][row] == 2 ) {
                // Eine Sammelpunkt
                ofSetColor(0,0,0);
                ofDrawRectangle(column*size,row*size,(column+1)*size,(row+1)*size);
                ofSetColor(255,255,255);
                ofDrawCircle((0.5+column)*size, (0.5+row)*size,2);
            } else if ( field[column][row] == 3 ) {
                // Eine 10-Punkte-Münze
                ofSetColor(0,0,0);
                ofDrawRectangle(column*size,row*size,(column+1)*size,(row+1)*size);
                ofSetColor(255,255,255);
                ofDrawCircle((0.5+column)*size, (0.5+row)*size,1);
            } else {
                // Nix
                ofSetColor(0,0,0);
                ofDrawRectangle(column*size,row*size,(column+1)*size,(row+1)*size);
            }
        }
    }
}

/**
 * Gibt die Berite des Levels
 *
 * @brief Level::getWidth
 * @return Level-Breite
 */
int Level::getWidth() {
    return width;
}

/**
 * Gibt die Höhe des Levels
 *
 * @brief Level::getHeight
 * @return Level-Höhe
 */
int Level::getHeight() {
    return height;
}

/**
 * Gibt den Skalierungsfaktor des Levels
 *
 * @brief Level::getSize
 * @return Skalierungsfaktor
 */
int Level::getSize() {
    return size;
}

/**
 * Gibt die Punkte des Levels
 *
 * @brief Level::getNumberOfPoints
 * @return Punkte
 */
int Level::getNumberOfPoints() {
    return points;
}
