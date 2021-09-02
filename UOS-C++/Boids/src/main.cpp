/**
 ** Algorithmen und Datenstrukturen
 ** OpenFrameworks App
 **
 ** <Beschreibung>
 **
 ** <Autoren>
 **/

#include "ofAuDApp.h"
#include "speedboid.h"

int anzahl = 50;
SpeedBoid boids[50];

int align(SpeedBoid boids[50],SpeedBoid b[b_id],int b_id){
    int b_x=b.getX(),b_y=b.getY();
    int total_x,total_y,tx,ty,x,y,i;
    for(i=0;i<anzahl;i++){
        if (b_id!=i){
            total_x += boids[i].getX();
            total_y += boids[i].getY();
            cout << total_x << endl << total_y;
         }
    }
    tx=total_x;
    ty=total_y;
    total_x = total_x / i-1;
    total_y = total_y / i-1;
    x,y=((total_x - b_x) / 100),((total_y - b_y) / 100);
    return x,y;
}

int main(){
    startAuDApp(1024,768);
}


// Die Initialisierung
void setup() {
    for(int i=0;i<anzahl;i++){
        boids[i].setPosition(ofGetWindowWidth()/2,ofGetWindowHeight()/2);
        boids[i].setSpeed(ofRandom(-5,5),ofRandom(-5,5));
    }
}
// Die Hauptschleife
void loop() {
    int x,y;
    for(int i=0;i<anzahl;i++){
        boids[i].setSpeed(boids[i].getSpeedX(),boids[i].getSpeedY());
        boids[i].move();
        boids[i].setPosition(x,y=align(&boids[50],&boids[i],i));
        boids[i].draw();
    }
}
