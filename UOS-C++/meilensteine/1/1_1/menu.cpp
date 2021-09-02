//
//  menu.cpp
//  1_1
//
//  Created by Mehmet-Ali Asar and Tim-Luca Lagmöller on 05.11.19.
//

#include "menu.hpp"
#include "tools.hpp"
#include "conversation.hpp"
#include "appointment.hpp"

// Hier wird das Hauptmenü mit den Optionen und Auswahlmöglichkeiten definiert
bool mainMenu() {
    print("Options:\n1: Start new phone call\n2: Appointment Options\n3: Exit");
    int choice = validateNumber("Choice:", 1, 3);
    insertLine();
    switch (choice) {
        case 1:
            placePhonecall();
            break;
        
        case 2:
            appointmentMenu();
            break;
            
        default:
            print("Bye!");
            return true;
    }
    return false;
}

// Hier wird das Menü für Termine mit den Optionen und Auswahlmöglichkeiten definiert
void appointmentMenu() {
    print("Options:\n1: List appointments\n2: Delete one appointment\n3: Delete all appointments\n4: Back to main menu");
    int choice = validateNumber("Choice:", 1, 4);
    insertLine();
    switch (choice) {
        case 1:
            if(appointments.size() > 0) {
                printAppointments(appointments);
            } else {
                print("You don't have any appointments planned.");
            }
            break;
            
        case 2:
            if(appointments.size() > 0) {
                printAppointments(appointments);
                deleteAppointment(appointments, validateNumber("Which appointment? (enter id)", 1, appointments.size()) - 1, false);
                print("Appointment deleted");
            } else {
                print("No appointments to delete");
            }
            break;
            
        case 3:
            deleteAppointment(appointments, -1, true);
            print("All appointments deleted");
            
        default:
            print("Back to main menu");
            break;
    }
    insertLine();
}
