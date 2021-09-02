//
//  tools.cpp
//  1_1
//
//  Created by Mehmet-Ali Asar and Tim-Luca Lagmöller on 05.11.19.
//

#include "tools.hpp"
#include <algorithm>
#include <iostream>
using namespace std;

// Fügt zusätzliche Funktionen zu cout hinzu
// isInput: Am Anfang der nächsten Zeile wird ein '>' hinzugefügt
// prefix: Für den Wert 'Ask' und dem output 'Test' wird die Ausgabe zu 'Ask: "Test"'
void print(string output, bool isInput, string prefix) {
    if(prefix != "") {
        output = prefix+": \""+output+"\"";
    }
    cout << output << endl;
    if(isInput) {
        cout << ">";
    }
}

// Alternativer Aufruf von print
void print(string output, bool isInput) {
    print(output, isInput, "");
}

// Alternativer Aufruf von print
void print(string output) {
    print(output, false);
}

// Alternativer Aufruf von print
void printPrefix(string prefix, string output) {
    print(output, false, prefix);
}

// Gibt eine Trennlinie in der Konsole aus
void insertLine() {
    print("-----------------");
}

// Verbindet print bzw. cout mit cin, also zuerst Ausgabe - dann Eingabe
// lowerString: Die gesamte Eingabe wird kleingeschrieben
string input(string output, bool lowerString){
    string in = "";
    
    while (in == "") {
        print(output, true);
        getline(cin, in);
    }
    
    if(lowerString){
        transform(in.begin(), in.end(), in.begin(), ::tolower);
    }
    return in;
}

// Alternativer Aufruf von input
string input(string output){
    return input(output, false);
}

// Überprüft, ob eine Eingabe zu den folgenden Kategorien gehört:
// (yes, y, Yes, Y) => 1
// (no, n, No, N) => -1
// Sonstige Antworten => 0
int validate(string input) {
    if (input == "yes" || input == "y" || input == "Yes" || input == "Y") {
        return 1;
    } else if (input == "no" || input == "n" || input == "No" || input == "N") {
        return -1;
    } else {
        return 0;
    }
}

// Diese Funktion wird solange ausgeführt, bis eine valide Eingabe (!= 0) basierend auf der
// Funktion validate eingegeben wurde.
bool validateQuestion(string output) {
    int tempResult = 0;
    bool executed = false;
    while (tempResult == 0) {
        if(executed) {
            output = "Not a valid input. Try again.\n"+output;
        }
        tempResult = validate(input(output));
        executed = true;
    }
    return tempResult == 1;
}

// Diese Funktion wird solange ausgeführt, bis eine valide Nummer in dem Bereich von
// minRange bis maxRange(inklusiv) eingegeben wurde
int validateNumber(string output, int minRange, int maxRange) {
    while(true) {
        try {
            int number = stoi(input(output));
            if(minRange <= number && maxRange >= number) {
                return number;
            } else {
                print("Number is not in range, please try again!");
            }
        } catch (invalid_argument) {
            print("Not a number, please try again!");
        }
    }
}
