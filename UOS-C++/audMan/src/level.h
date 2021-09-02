/**
 * Diese Klasse ist ein LEvel für AuD-Man
 *
 * @brief The Level class
 */

#ifndef LEVEL_H
#define LEVEL_H

class Level {

    // Die Attriobute
private:
    int size;           // Größe eines Feldes in Pixeln
    int width;          // Breite des LEvels in Feldern
    int height;         // Höhe des Levels in Feldern
    int field[20][20];  // Die Felder
    int points;         // Die Punkte, die im Level liegen

public:
    Level();        // Standardkonstruktor
    Level(int s);   // Dieser Konstruktor erhält die Größe

    void init();    // Setzte den Level zurück

    int getField(int x, int y);             // Gibt zurück, was sich auf dem Feld befindet
    void setField(int x, int y, int value); // Setzt das Objekt auf dem Feld
    void draw();                            // Zeichnet den Level

    int getWidth();                         // Gibt die Breite zurück
    int getHeight();                        // Gibt die Höhe zurück
    int getSize();                          // Gibt die Grösse eines Feldes zurück

    int getNumberOfPoints();                // Gibt die Anzahl der Punkte im Level am Anfang zurück
};

#endif // LEVEL_H
