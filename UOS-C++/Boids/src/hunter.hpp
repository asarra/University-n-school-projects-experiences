//
//  hunter.hpp
//  boids_v2
//
//  Created by Tim-Luca on 02.12.19.
//

#ifndef hunter_hpp
#define hunter_hpp

#include <stdio.h>
#include <vector>
#include "speedboid.h"
using namespace std;

void killBoids(SpeedBoid &hunter, vector<SpeedBoid> &boids, int &boidCount, int maxRadius, float maxHunterSpeed, float maxSpeed, float &currentHunterSpeed);

#endif /* hunter_hpp */
