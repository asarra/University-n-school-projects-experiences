#include "ofAuDApp.h"

ofBaseApp *APP = NULL;

extern void setup();
extern void loop();

void startAuDApp(int width, int height) {
    ofSetupOpenGL(width,height,OF_WINDOW);
    ofRunApp(new ofAuDApp());
}



int index = 0;

void ofAuDApp::setup(){
    APP = this;
    //background.load("./images/syn.jpg");
    /*myPlayer.load("./video/Braveoptimalbaleenwhale.mp4");
    myPlayer.setLoopState(OF_LOOP_NORMAL);
    myPlayer.setSpeed(9);*/

    //ofSetFrameRate(60);
    gifloader.load("./gif/syn2.gif");
    //ofEnableAlphaBlending();


    syn.load("./audio/syn.mp3");
    syn.play();
    ::setup();
}

void ofAuDApp::update(){
    //myPlayer.update();
    if (ofGetElapsedTimeMillis() % 3)
        {
            index++;
            if (index > gifloader.pages.size()-1) index = 0;
        }
    :: update();
}

void ofAuDApp::draw(){
    ofBackground(0);
    ofSetColor(255,255,255,255);
    //background.draw(12,12,1000,744);
    /*myPlayer.draw(12,12,1000,744);
    myPlayer.play();*/

    gifloader.pages[index].draw(6,6,1012, 756);
    ::loop();
}

void update() {};
