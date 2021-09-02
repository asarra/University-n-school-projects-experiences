/**
 ** Algorithmen und Datenstrukturen
 ** OpenFrameworks App
 **
 ** Dies ist eine Implementierung einer einfachen Variante eines
 ** Spieleklassikers. Dabei verwenden wir Klassen und Objekte.
 **
 ** Michael Brinkmeier <mbrinkmeier@uni-osnabrueck.de>
 **/

#include "ofAuDApp.h"
#include "level.h"
#include "characters/audman.h"
#include "characters/ghost.h"
#include "characters/wolf.hpp"

//=== Die globalen Variablen =============================================

AuDMan *audMan;
Ghost *ghost;
Level *level;
Wolf *wolf;

//========================================================================

int main( ) {
    // Initialisierung der einzelnen Klassen
    level = new Level(20);
    audMan = new AuDMan();
    ghost = new Ghost(audMan);
    wolf = new Wolf(audMan);
    
    // Level wird den verschiedenen Objekten hinzugefügt
    audMan->setLevel(level);
    ghost->setLevel(level);
    wolf->setLevel(level);

    startAuDApp(level->getWidth()*level->getSize(),level->getWidth()*level->getSize());
}

//========================================================================

// Die Initialisierung
void setup() {
    level->init();
    
    // Die Anfangsposition wird gesetzt
    audMan->setPosition(1,1);
    ghost->setPosition(10,1);
    wolf->setPosition(19,5);
}

//========================================================================

// Die Hauptschleife
void loop() {
    // Alle Änderungen der Objekte passieren hier
    // Hier werden sie neu "gemalt"
    level->draw();
    audMan->draw();
    ghost->draw();
    wolf->draw();
}

//=========================================================================

// Der Eventhandler für die Pfeiltasten
void keyPressed(int key) {
    if ( key == OF_KEY_RIGHT ) {
        audMan->moveBy(1,0);
    } else if ( key == OF_KEY_LEFT ) {
        audMan->moveBy(-1,0);
    } else if ( key == OF_KEY_UP ) {
        audMan->moveBy(0,-1);
    } else if ( key == OF_KEY_DOWN ) {
        audMan->moveBy(0,1);
    }
}
