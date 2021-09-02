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

#ifndef AUDMAN_H
#define AUDMAN_H

#include "level.h"
#include <vector>
using namespace std;

class AuDMan {
// Die Attribute
private:
    int posX;       // Der Ort
    int posY;
    int points;     // Die bislang gesammelten Punkte
    Level *level;   // Der Level in dem sich die Figur bewegt

public:

    AuDMan();                   // Der Standardkonstruktor
    AuDMan(int x, int y);       // Ein Konstruktor, dem der Ort übergeben wird.

    void setLevel(Level *lvl);  // Versetzt die Figur in den jeweiligen Level
    
    vector<int> getPosition();
    void setPosition(int x, int y); // Setzt die Figur an eine bestimmte Position im Level
    void moveBy(int dx, int dy);    // Bewegt die Figur im Level
    void updatePoints(int relativePoints);
    void draw();                    // Zeichnet die Figur am aktuellen Ort
    int getPoints();                // Gibt zurück, wieviele Punkte bereits gesammelt wurden.
};

#endif // AUDMAN_H
