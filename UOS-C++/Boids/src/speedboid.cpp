#include "speedboid.h"
#include "ofAuDApp.h"

/**
 * Standartkonstruktor
 *
 * @brief SpeedBoid::SpeedBoid
 */
SpeedBoid::SpeedBoid() {
    posX = 0;
    posY = 0;
    vx = 0;
    vy = 0;
    size = 10;
}

/**
 * Setzt den Boid auf eine bestimmte Position
 * @brief SpeedBoid::setPosition
 * @param x x-Koordinate
 * @param y y-Koordinate
 */
void SpeedBoid::setPosition(int x, int y) {
    posX = x;
    posY = y;
}

/**
 * Setzt die Geschwindigkeit des Boids
 * @brief SpeedBoid::setSpeed
 * @param x x-Anteil der Geschwindigkeit
 * @param y y-Anteil der Geschwindigkeit
 */
void SpeedBoid::setSpeed(int x, int y) {
    vx = x;
    vy = y;
}

/**
 * Zeichnet den Boid
 * @brief SpeedBoid::draw
 */
void SpeedBoid::draw(){
    ofSetColor(255,255,255);
    if((vx==0)&&(vy==0)){
        ofDrawCircle(posX,posY,size/4);
    } else {
        float dist = sqrt(vx*vx + vy*vy);
        float dirX = vx/dist;
        float dirY = vy/dist;
        float aX = posX + size*dirX;
        float aY = posY + size*dirY;
        float bX = posX - size/4*dirY;
        float bY = posY + size/4*dirX;
        float cX = posX + size/4*dirY;
        float cY = posY - size/4*dirX;
        ofDrawTriangle(aX,aY,bX,bY,cX,cY);
    }
}

/**
 * Bewegt den Boid entsprechend seiner Geschwindigkeit
 * @brief SpeedBoid::move
 */

void SpeedBoid::move() {
    //Damit die Boids innerhalb des Fensters bleiben!
    if (posX<=0||posX>=1024){ //außerhalb von X
        vx *= -1;
    }if (posY<=0||posY>=768){ //außerhalb von Y
        vy *= -1;
    }

    posX = posX + vx;
    posY = posY + vy;
}

//=====================   Getter und Setter   ============================

int SpeedBoid::getX() {
    return posX;
}


int SpeedBoid::getY() {
    return posY;
}

int SpeedBoid::getSpeedX() {
    return vx;
}

int SpeedBoid::getSpeedY() {
    return vy;
}
