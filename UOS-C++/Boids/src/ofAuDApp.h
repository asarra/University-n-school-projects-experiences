#pragma once
/**
 ** Algorithmen und Datenstrukturen
 ** OpenFrameWorks Applikations Klasse
 **
 ** Diese Klasse stellt eine Implementierung einer ofApp zur Verfügung,
 ** die mittels global definierter Funktionen realisiert wird.
 **
 ** Die globale Variable APP stellt einen Pointer auf die aktuell laufende
 ** App zur Verfügung.
 ** void setup() wird beim Start der App einmal ausgeführt.
 **
 ** void loop() wird anschließend fortlaufend ausgeführt.
 **
 ** Die Event Handler haben in der Defaultimplementierung keine Funktion.
 ** Sie können jedoch durch global definierte Funktionen gleichen Namens
 ** überladen werden, so dass die App auf Events reagieren kann.
 **
 ** (c) 2019 Michael Brinkmeier <mbrinkmeier@uni-osnabrueck.de>
 **/

#include "ofMain.h"

extern ofBaseApp *APP;	// Diese Variable soll als Konstante genutzt werden,
// die auf die aktuell laufende App verweist.


// Diese Operation startet eine App mit Fenster.
void startAuDApp(int width, int height);


/**
 ** Die AuD OpenFrameworks Applikation
 **
 ** Sie implementiert eine Reihe von grundlegenden Funktionen.
 **/
class ofAuDApp : public ofBaseApp{

public:
    void setup();
    void update();
    void draw();

    void keyPressed(int key);
    void keyReleased(int key);
    void mouseMoved(int x, int y );
    void mouseDragged(int x, int y, int button);
    void mousePressed(int x, int y, int button);
    void mouseReleased(int x, int y, int button);
    void mouseEntered(int x, int y);
    void mouseExited(int x, int y);
    void windowResized(int w, int h);
    void dragEvent(ofDragInfo dragInfo);
    void gotMessage(ofMessage msg);

};


// Die Standard Eventhandler können überschrieben werden
void setup();
void loop();
void update();
void keyPressed(int key);
void keyReleased(int key);
void mouseMoved(int x, int y );
void mouseDragged(int x, int y, int button);
void mousePressed(int x, int y, int button);
void mouseReleased(int x, int y, int button);
void mouseEntered(int x, int y);
void mouseExited(int x, int y);
void windowResized(int w, int h);
void dragEvent(ofDragInfo dragInfo);
void gotMessage(ofMessage msg);
