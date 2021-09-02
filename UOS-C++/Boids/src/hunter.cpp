//
//  hunter.cpp
//  boids_v2
//
//  Created by Tim-Luca on 02.12.19.
//

#include "hunter.hpp"
#include <vector>
#include "speedboid.h"
using namespace std;

// Berechnet, ob Boids nah genug am Hunter sind, um entfernt zu werden, und entfernt diese
void killBoids(SpeedBoid &hunter, vector<SpeedBoid> &boids, int &boidCount, int maxRadius, float maxHunterSpeed, float maxSpeed, float &currentHunterSpeed) {
    for (int i = 0; i < boidCount; ++i) {
        // Überprüft die Distanz zu dem Boid
        if (hunter.getDistanceToBoid(boids[i]) < maxRadius) {
            //Boid wird entfernt
            boids.erase(boids.begin() + i);
            boidCount--;
            
            // Die Geschwindigkeit des Hunters wird erhöht
            if (currentHunterSpeed < maxHunterSpeed){
                currentHunterSpeed += 1;
            }
        }
    }
    
    // Wenn keine Boids mehr existieren, wird der Hunter außerhalb des Fensters gerendert (nicht mehr sichtbar)
    if(boidCount == 0) {
        hunter.setSpeed(0, 0);
        hunter.setPosition(-50, -50);
    }
}
