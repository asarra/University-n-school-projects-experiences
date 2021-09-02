/**
 ** Algorithmen und Datenstrukturen
 ** OpenFrameworks App
 **
 ** <Beschreibung>
 **
 ** <Autoren>
 **/

#include "ofAuDApp.h"

//========================================================================

int main( ){
    // Mit dieser Anweisung wird ein Fenster in der angegebenen Größe
    // geöffnet und die App gestartet. Dabei wird im Grunde das folgende
    // Programm ausgeführt:
    //
    // setup();
    // while ( 1 == 1 ) {
    //    draw();
    // }
    //
    startAuDApp(1024,768);
}

//========================================================================

// Die Initialisierung
void setup() {
    // Diese Operation wird beim Start der Applikation einmal ausgeführt.
    ofSetBackgroundColor(0,0,0);
}

//========================================================================

// Die Hauptschleife
void loop() {
    // Diese Operation wird fortlaufend wiederholt.
    ofSetColor(255,0,0);
    ofDrawCircle(ofGetWidth()/2, ofGetHeight()/2, 100);
}
