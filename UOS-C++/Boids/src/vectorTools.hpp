//
//  vectorTools.hpp
//  boids_v2
//
//  Created by Tim-Luca on 02.12.19.
//

#ifndef vectorTools_hpp
#define vectorTools_hpp

#include <stdio.h>
#include <vector>

using namespace std;

vector<float> normalize(float a, float b, float maxValue);
vector<float> multiply(vector<float> v, float multiplier);
void applyForce(vector<float> &input, vector<float> forceVector, float weight);

#endif /* vectorTools_hpp */
