//
//  boidForces.hpp
//  boids_v2
//
//  Created by Tim-Luca on 02.12.19.
//

#ifndef forces_hpp
#define forces_hpp

#include <stdio.h>
#include <vector>
#include "speedboid.h"
using namespace std;

vector<float> cohesion(SpeedBoid &currentBoid, vector<SpeedBoid> boids, int minDistance, int maxDistance, float maxSpeed);
vector<float> alignment(SpeedBoid &currentBoid, vector<SpeedBoid> boids, int minDistance, int maxDistance, float maxSpeed);
vector<float> separation(SpeedBoid &currentBoid, vector<SpeedBoid> boids, int minDistance, int maxDistance, float maxSpeed);
vector<float> closestBoid(SpeedBoid &currentBoid, vector<SpeedBoid> boids, float maxSpeed);
vector<float> avoidHunter(SpeedBoid &currentBoid, SpeedBoid &hunter, int maxDistance, float maxSpeed);
vector<float> wind(SpeedBoid &currentBoid, float maxSpeed);
#endif /* forces_hpp */
