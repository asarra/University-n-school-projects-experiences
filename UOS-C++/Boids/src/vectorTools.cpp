//
//  vectorTools.cpp
//  boids_v2
//
//  Created by Tim-Luca on 02.12.19.
//

#include "vectorTools.hpp"
#include <vector>
#include <math.h>

using namespace std;


// Umsetzung der Vektor-Normalisierung
vector<float> normalize(float a, float b, float maxValue) {
    if(a != 0 || b != 0) {
        float distance = sqrt(a*a + b*b);
        
        return vector<float> {
            (a / distance) * abs(maxValue),
            (b / distance) * abs(maxValue)
        };
    }
    
    return vector<float> {
        0,0
    };
}


// Die Kräfte des Boids werden auf den Input-Vektor gewichtet und addiert
void applyForce(vector<float> &input, vector<float> forceVector, float weight) {
    input[0] += forceVector[0] * weight;
    input[1] += forceVector[1] * weight;
}

// Multiplikation eines Vektors mit einer Zahl
vector<float> multiply(vector<float> v, float multiplier) {
    v[0] *= multiplier;
    v[1] *= multiplier;
    
    return v;
}
