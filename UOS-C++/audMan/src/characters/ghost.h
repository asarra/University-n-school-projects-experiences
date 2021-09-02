/**
 ** Algorithmen und Datenstrukturen
 ** OpenFrameworks App
 **
 ** Die Spielfigur für AuD-Man.
 **
 ** Ein Objekt dieser Klasse repräsentiert eine vom Nutzer
 ** steuerbare Figur, die Punkte aufsammelt.
 **
 ** Michael Brinkmeier <mbrinkmeier@uni-osnabrueck.de>
 **/

#ifndef GHOST_H
#define GHOST_H

#include "level.h"
#include "audman.h"

class Ghost {
    // Die Attribute
    private:
        int posX;
        int posY;
        int update;
        bool huntPlayer;
        int targetX;
        int targetY;
        bool pointsUpdated;
        AuDMan *player;
        Level *level;
        
    public:
        
        Ghost(AuDMan *p);                // Der Standardkonstruktor
        Ghost(AuDMan *p, int x, int y); // Ein Konstruktor, dem der Ort übergeben wird.
        void setLevel(Level *lvl);      // Versetzt die Figur in den jeweiligen Level
        void setPosition(int x, int y); // Setzt die Figur an eine bestimmte Position im Level
        void moveBy(int dx, int dy);    // Bewegt die Figur im Level
        void draw();                    // Zeichnet die Figur am aktuellen Ort
};

#endif // GHOST_H
