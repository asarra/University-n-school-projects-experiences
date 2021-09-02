//
//  appointment.hpp
//  1_1
//
//  Created by Mehmet-Ali Asar and Tim-Luca Lagmöller on 05.11.19.
//

#ifndef appointment_hpp
#define appointment_hpp

#include <iostream>
#include <vector>

using namespace std;

void createAppointment(vector<vector<string>> &appointments, string date, string time, string eventTitle, string newFriend);

void printAppointments(vector<vector<string>> &appointments);

void deleteAppointment(vector<vector<string>> &appointments, int index, bool all);

string appointmentsToString(vector<vector<string>> &appointments);

void appointmentsToFile(vector<vector<string>> &appointments, string filename);

vector<vector<string>> fileToAppointments(string filename);

#endif /* appointment_hpp */
