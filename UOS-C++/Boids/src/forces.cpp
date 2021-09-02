//
//  boidForces.cpp
//  boids_v2
//
//  Created by Tim-Luca on 02.12.19.
//

#include "forces.hpp"
#include <vector>
#include "speedboid.h"
#include "vectorTools.hpp"
#include "ofAuDApp.h"

using namespace std;

// Berechnet die Kohäsion, also die Anziehungskraft zum Mittelpunkt der nähesten Boids (basierend auf der Bachelor-Arbeit)
vector<float> cohesion(SpeedBoid &currentBoid, vector<SpeedBoid> boids, int minDistance, int maxDistance, float maxSpeed) {
    float posX = 0;
    float posY = 0;
    int count = 0;
    
    for(SpeedBoid boid : boids) {
        if(&currentBoid != &boid) {
            float distance = currentBoid.getDistanceToBoid(boid);
            if(distance > minDistance && distance < maxDistance) {
                posX += boid.getX();
                posY += boid.getY();
                ++count;
            }
        }
    }
    
    if(count == 0) {
        return vector<float> {0, 0};
    }
    
    posX /= count;
    posY /= count;
    posX -= currentBoid.getX();
    posY -= currentBoid.getY();
    
    vector<float> force = normalize(posX, posY, maxSpeed);
    return force;
}

// Berechnet die Angleichung der Richtung an die der nähesten Boids (basierend auf der Bachelor-Arbeit)
vector<float> alignment(SpeedBoid &currentBoid, vector<SpeedBoid> boids, int minDistance, int maxDistance, float maxSpeed) {
    float speedX = 0;
    float speedY = 0;
    int count = 0;
    
    for(SpeedBoid boid : boids) {
        if(&currentBoid != &boid) {
            float distance = currentBoid.getDistanceToBoid(boid);
            if(distance > minDistance && distance < maxDistance) {
                speedX += boid.getSpeedX();
                speedY += boid.getSpeedY();
                ++count;
            }
        }
    }
    
    if(count == 0) {
        return vector<float> {0, 0};
    }
    
    speedX /= count;
    speedY /= count;
    vector<float> force = normalize(speedX, speedY, maxSpeed);
    return force;
}

// Berechnet die Abstoßung der Boids untereinander, falls sie sich zu nahe kommen (basierend auf der Bachelor-Arbeit)
vector<float> separation(SpeedBoid &currentBoid, vector<SpeedBoid> boids, int minDistance, int maxDistance, float maxSpeed) {
    float posX = 0;
    float posY = 0;
    int count = 0;
    
    for(SpeedBoid boid : boids) {
        if(&currentBoid != &boid) {
            float distance = currentBoid.getDistanceToBoid(boid);
            if(distance > minDistance && distance < maxDistance) {
                posX += boid.getX();
                posY += boid.getY();
                ++count;
            }
        }
    }
    
    if(count == 0) {
        return vector<float> {0, 0};
    }
    posX /= count;
    posY /= count;
    
    posX -= currentBoid.getX();
    posY -= currentBoid.getY();
    
    vector<float> force = normalize(posX, posY, maxSpeed);
    
    // Der Richtungsvektor wird umgedreht, um eine abstoßende Wirkung zu erzielen
    return vector<float> {
        -force[0],
        -force[1]
    };
}

// Gibt einen Richtungsvektor zurück, der auf den nähesten Boid zielt
vector<float> closestBoid(SpeedBoid &currentBoid, vector<SpeedBoid> boids, float maxSpeed) {
    float minDistance = -1;
    int posX;
    int posY;
    
    for(SpeedBoid boid : boids) {
        if(&currentBoid != &boid) {
            float distance = currentBoid.getDistanceToBoid(boid);
            if(distance <= minDistance || minDistance == -1) {
                posX = boid.getX();
                posY = boid.getY();
                minDistance = distance;
            }
        }
    }
    
    posX -= currentBoid.getX();
    posY -= currentBoid.getY();
    
    vector<float> force = normalize(posX, posY, maxSpeed);
    
    
    return force;
}


// Funktioniert wie Seperation, nur in diesem Fall für den Hunter anstatt für nähesten Boids
vector<float> avoidHunter(SpeedBoid &currentBoid, SpeedBoid &hunter, int maxDistance, float maxSpeed) {
    float posX = 0;
    float posY = 0;
    int count = 0;
    float distance = currentBoid.getDistanceToBoid(hunter);
    if(distance < maxDistance) {
        posX += hunter.getX();
        posY += hunter.getY();
        ++count;
    }
    
    if(count == 0) {
        return vector<float> {0, 0};
    }
    
    posX -= currentBoid.getX();
    posY -= currentBoid.getY();
    
    vector<float> force = normalize(posX, posY, maxSpeed);
    
    // Der Richtungsvektor wird umgedreht, um eine abstoßende Wirkung zu erzielen
    return vector<float> {
        -force[0],
        -force[1]
    };
}
