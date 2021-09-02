#pragma once

#include "ofMain.h"
#include "ofxGif.h"

extern ofBaseApp *APP;

void startAuDApp(int width, int height);

class ofAuDApp : public ofBaseApp{

public:
    void setup();
    void update();
    void draw();
    ofSoundPlayer syn;
    /*ofImage background;
    ofVideoPlayer myPlayer;*/
    ofxGIF::fiGifLoader gifloader;

};


// Die Standard Eventhandler können überschrieben werden
void __attribute__((weak)) update();
