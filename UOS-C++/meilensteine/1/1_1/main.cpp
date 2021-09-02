//
//  main.cpp
//  1_1
//
//  Created by Mehmet-Ali Asar and Tim-Luca Lagmöller on 05.11.19.
//

#include <iostream>
#include "appointment.hpp"
#include "menu.hpp"

using namespace std;

vector<vector<string>> appointments;

void appointmentMenu();

int main() {
    bool exit = false;
    string appointmentsFile = "appointments.txt";
    
    // Termine aus Datei lesen
    appointments = fileToAppointments(appointmentsFile);
    
    while(!exit) {
        exit = mainMenu();
        
        // Neue Termine abspeichern
        appointmentsToFile(appointments, appointmentsFile);
    }
    
    return 0;
}
