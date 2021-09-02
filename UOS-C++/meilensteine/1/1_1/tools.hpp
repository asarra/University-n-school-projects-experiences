//
//  tools.hpp
//  1_1
//
//  Created by Mehmet-Ali Asar and Tim-Luca Lagmöller on 05.11.19.
//

#ifndef tools_hpp
#define tools_hpp

#include <stdio.h>
#include <iostream>

using namespace std;

void print(string output, bool isInput, string prefix);

void print(string output, bool isInput);

void print(string output);

void printPrefix(string prefix, string output);

void insertLine();

string input(string output, bool lowerString);

string input(string output);

int validate(string output);

bool validateQuestion(string output);

int validateNumber(string output, int minRange, int maxRange);


#endif /* tools_hpp */
