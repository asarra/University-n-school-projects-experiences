//
//  appointment.cpp
//  1_1
//
//  Created by Mehmet-Ali Asar and Tim-Luca Lagmöller on 05.11.19.
//

#include "appointment.hpp"
#include "tools.hpp"
#include <vector>
#include <iostream>
#include <sstream>
#include <fstream>

using namespace std;

void exportAppointmentToICalFile(vector<string> appointment){
    string filename = "appointment.ics";

    string date = appointment[0];
    string time = appointment[1];

    //Konvertierung des Datum-Formats: Bsp.: 12.12.2012->20121212
    stringstream formatted_date;
    
    //yyyy
    for(int i=0; i<=3; i++){
        formatted_date << date[6+i];
    }
    
    formatted_date << date[3] << date[4]; //mm
    formatted_date << date[0] << date[1]; //dd

    stringstream formatted_time;
    for(int i=0; i<=8; i++){
        if(time[i] != ':'){
            formatted_time << time[i];
        }
    }

    string formatted_end_time = formatted_time.str();
    formatted_end_time[5]=formatted_end_time[5]+1;

    ofstream outFile(filename);
    outFile << "BEGIN:VCALENDAR\nVERSION:2.0\nPRODID:ASAR&LAGMOELLER Software GmbH\nMETHOD:PUBLISH" << endl;
    outFile << "BEGIN:VTIMEZONE\nTZID:CET\nBEGIN:DAYLIGHT\nTZOFFSETFROM:+0100\nTZOFFSETTO:+0200\nTZNAME:Central European Summer Time"<< endl;
    outFile << "DTSTART:" << formatted_date.str() << "T" << formatted_time.str() << endl;
    outFile << "RRULE:FREQ=YEARLY;BYDAY=-1SU;BYMONTH=3\nEND:DAYLIGHT\nBEGIN:STANDARD\nTZOFFSETFROM:+0200\nTZOFFSETTO:+0100\nTZNAME:Central European Time" << endl;
    outFile << "DTSTART:" << formatted_date.str() << "T" << formatted_time.str() << endl;
    outFile << "RRULE:FREQ=YEARLY;BYDAY=-1SU;BYMONTH=10\nEND:STANDARD\nEND:VTIMEZONE" << endl;
    outFile << "BEGIN:VEVENT" << endl;
    outFile << "UID:11111111-1111-1111-1111-111111111111" << endl;
    outFile << "DTSTART:" << formatted_date.str() << "T" << formatted_time.str() << endl;
    outFile << "DTEND:" << formatted_date.str() << "T" << formatted_end_time << endl;
    outFile << "DTSTAMP:" << formatted_date.str() << "T" << formatted_time.str() << endl;
    outFile << "LOCATION:-\nSUMMARY:" << appointment[2] << " with " << appointment[3] << endl;
    outFile << "DESCRIPTION:" << appointment[2] << " with " << appointment[3] << " on " << appointment[0] << " at " << appointment[1] << endl;
    outFile << "CLASS:PUBLIC" << endl;
    outFile << "END:VEVENT\nEND:VCALENDAR";
    outFile.close();
}

// Ein neuer Termin wird dem Termin-Vector hinzugefügt
void createAppointment(vector<vector<string>> &appointments, string date, string time, string eventTitle, string newFriend) {
    vector<string> appointment = {date, time, eventTitle, newFriend};
    exportAppointmentToICalFile(appointment);
    print("Exported to ICal File!");
    appointments.push_back(appointment);
}

// Termin-Vector wird in einer lesbaren Form in der Konsole ausgegeben
void printAppointments(vector<vector<string>> &appointments) {
    for (int i = 0; i < appointments.size(); ++i) {
        auto appointment = appointments[i];
        print(to_string(i+1) + ": " + appointment[2] + " with " + appointment[3] + " at " + appointment[1] + " on " + appointment[0]);
    }
}

// Termin (entweder mit index oder alle, wenn bool all = true) werden aus Vector gelöscht
void deleteAppointment(vector<vector<string>> &appointments, int index, bool all) {
    if(all) {
        appointments.clear();
    } else {
        appointments.erase(appointments.begin() + index);
    }
}

// Datei mit Terminen (CSV) wird aus einem Vector generiert
void appointmentsToFile(vector<vector<string>> &appointments, string filename) {
    stringstream appointmentsStringStream;
    for (int i = 0; i < appointments.size(); ++i) {
        stringstream appointmentStringStream;
        for (int j = 0; j < appointments[i].size(); ++j) {
            if(j != 0) {
                appointmentsStringStream << ";";
            }
            appointmentsStringStream << appointments[i][j];
        }
        appointmentsStringStream << endl;
    }

    ofstream outFile(filename);
    outFile << appointmentsStringStream.str();
    outFile.close();
}

// Vector wird aus einer Datei mit Terminen (CSV) generiert
vector<vector<string>> fileToAppointments(string filename) {
    vector<vector<string>> appointments;
    vector<string> appointment;
    stringstream tempStringStream;
    
    ifstream inFile(filename);
    string line;
    
    if (inFile.is_open()) {
        while(getline(inFile,line)) {
            for (char c : line) {
                if (c == ';') {
                    appointment.push_back(tempStringStream.str());
                    tempStringStream = stringstream();
                } else {
                    tempStringStream << c;
                }
            }
            appointment.push_back(tempStringStream.str());
            tempStringStream = stringstream();
            appointments.push_back(appointment);
            appointment.clear();
        }
        inFile.close();
    }
    
    return appointments;
}
