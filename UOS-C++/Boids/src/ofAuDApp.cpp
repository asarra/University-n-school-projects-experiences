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

#include "ofAuDApp.h"


ofBaseApp *APP = NULL;

// Die externen operationen setup und loop müssen
// an anderer Stelle implementiert werden.
extern void setup();
extern void loop();

// Diese Operation startet eine App mit Fenster.
void startAuDApp(int width, int height) {
    // Bereite den Grafik Kontext mit der gegebenen Auflösung in einem Fenster vor.
    ofSetupOpenGL(width,height,OF_WINDOW);

    // Starte die Applikation. Führe einmal setup() aus. Wiederhole anschließend
    // fortlaufend loop().
    ofRunApp(new ofAuDApp());
}


// Die Funktionen der App rufen die Standardhandler auf.
//--------------------------------------------------------------
void ofAuDApp::setup(){
    // Setze die Globale Variable app auf diese app.
    APP = this;

    // Führe setup() aus
    ::setup();
}

//--------------------------------------------------------------
void ofAuDApp::update(){
    :: update();
}

//--------------------------------------------------------------
void ofAuDApp::draw(){
    ::loop();
}

//--------------------------------------------------------------
void ofAuDApp::keyPressed(int key){
    ::keyPressed(key);
}

//--------------------------------------------------------------
void ofAuDApp::keyReleased(int key){
    ::keyReleased(key);
}

//--------------------------------------------------------------
void ofAuDApp::mouseMoved(int x, int y ){
    ::mouseMoved(x,y);
}

//--------------------------------------------------------------
void ofAuDApp::mouseDragged(int x, int y, int button){
    ::mouseDragged(x,y,button);
}

//--------------------------------------------------------------
void ofAuDApp::mousePressed(int x, int y, int button){
    ::mousePressed(x,y,button);
}

//--------------------------------------------------------------
void ofAuDApp::mouseReleased(int x, int y, int button){
    ::mouseReleased(x,y,button);
}

//--------------------------------------------------------------
void ofAuDApp::mouseEntered(int x, int y){
    ::mouseEntered(x,y);
}

//--------------------------------------------------------------
void ofAuDApp::mouseExited(int x, int y){
    ::mouseExited(x,y);
}

//--------------------------------------------------------------
void ofAuDApp::windowResized(int w, int h){
    ::windowResized(w,h);
}

//--------------------------------------------------------------
void ofAuDApp::gotMessage(ofMessage msg){
    ::gotMessage(msg);
}

//--------------------------------------------------------------
void ofAuDApp::dragEvent(ofDragInfo dragInfo){
    ::dragEvent(dragInfo);
}


// Die Standardhandler tuen nichts.
void setup() {};
void loop () {};
void update() {};
void keyPressed(int key) {};
void keyReleased(int key) {};
void mouseMoved(int x, int y ) {};
void mouseDragged(int x, int y, int button) {};
void mousePressed(int x, int y, int button) {};
void mouseReleased(int x, int y, int button) {};
void mouseEntered(int x, int y) {};
void mouseExited(int x, int y) {};
void windowResized(int w, int h) {};
void dragEvent(ofDragInfo dragInfo) {};
void gotMessage(ofMessage msg) {};


// Mache alles zu schwachen Symbolen
#pragma weak loop
#pragma weak setup
#pragma weak update
#pragma weak keyPressed
#pragma weak keyReleased
#pragma weak mouseMoved
#pragma weak mouseDragged
#pragma weak mouseReleased
#pragma weak mousePressed
#pragma weak mouseEntered
#pragma weak mouseExited
#pragma weak windowResized
#pragma weak dragEvent
#pragma weak gotMessage
