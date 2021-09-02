/**
 ** Algorithmen und Datenstrukturen
 ** OpenFrameworks App
 **
 ** <Beschreibung>
 **
 ** <Autoren>
 **/

#include "ofAuDApp.h"

float x=1024;
float y=720; //Damit später die Kreise etwas weiter oben stehen!
float start_radius=300;

int main( ){
    startAuDApp(x,y+48);
}

void setup(){}

void drawCenterCircles(float radius,bool lastShot){
    ofSetColor(0,255,255);
    ofDrawCircle(x/2,y/2,radius);
    ofDrawCircle(x/2,y/2,radius-30);
    if (lastShot){
        ofFill();
        ofDrawCircle(x/2,y/2,radius-30);
    }
}

void drawRightCircles(float radius){
    ofSetHexColor(0xF4225A);
    ofDrawCircle(x/2+(2*radius),y/2,radius);
    ofDrawCircle(x/2+(2*radius),y/2,radius-30);
}

void drawLeftCircles(float radius){
    ofSetHexColor(0xFF0081);
    ofDrawCircle(x/2-(2*radius),y/2,radius);
    ofDrawCircle(x/2-(2*radius),y/2,radius-30);
}

void drawBottomCircles(float radius){
    ofSetHexColor(0x8F2AA3);
    ofDrawCircle(x/2,y/2+(2*radius),radius);
    ofDrawCircle(x/2,y/2+(2*radius),radius-30);
}

void drawTopCircles(float radius){
    ofSetColor(100,30,200);
    ofDrawCircle(x/2,y/2-(2*radius),radius);
    ofDrawCircle(x/2,y/2-(2*radius),radius-30);
}

bool drawCircles(float radius_teiler,int tiefe){
    float radius=start_radius;
    radius=radius/radius_teiler;

    if(tiefe==0){
        drawRightCircles(radius);
        drawLeftCircles(radius);
        drawBottomCircles(radius);
        drawTopCircles(radius);

        drawCenterCircles(radius,true);
        return false;
    }

    else if(tiefe>=0){
        drawCenterCircles(radius,false);
        drawRightCircles(radius);
        drawLeftCircles(radius);
        drawBottomCircles(radius);
        drawTopCircles(radius);
        drawCircles(4.5*radius_teiler,tiefe-1);
        return true;
    }
    else{
        return false;
    }
}

void loop() {
    ofSetLineWidth(2);
    ofNoFill();
    drawCircles(3,3);

    ofNoFill();
    ofSetColor(0,255,255);
    ofDrawCircle(x/2,y/2,start_radius);
    ofDrawCircle(x/2,y/2,start_radius+30);
}
