//
//  conversation.cpp
//  1_1
//
//  Created by Mehmet-Ali Asar and Tim-Luca Lagmöller on 05.11.19.
//

#include "conversation.hpp"
#include "tools.hpp"
#include "appointment.hpp"

void placePhonecall() {
    print("Place phone call");
    insertLine();
    home();
}

void home() {
    if(validateQuestion("Are you at home?")) {
        insertLine();
        shareMeal();
    } else {
        print("Leave message");
        print("Wait for callback");
        insertLine();
        shareMeal();
    }
}

void shareMeal() {
    printPrefix("Ask", "Would you like to share the meal?");
    if(validateQuestion("What is the response?")){
        print("Dine together");
        insertLine();
        makeAppointment("Dine");
    } else {
        insertLine();
        enjoyHotBeverage();
    }
}

void enjoyHotBeverage() {
    printPrefix("Ask", "Do you enjoy hot beverage?");
    if(validateQuestion("What is the response?")){
        printPrefix("Ask", "Which type of beverage do you like? (Tea, Coffee, Cocoa)");
        string beverageType = input("What is the response?", true);
        bool validBeverage = false;
        string beverage = "";
        while(!validBeverage) {
            validBeverage = true;
            if (beverageType == "tea") {
                beverage = "Tea";
            } else if (beverageType == "coffee") {
                beverage = "Coffee";
            } else if (beverageType == "cocoa") {
                beverage = "Cocoa";
            } else {
                validBeverage = false;
                printPrefix("Say", "I don't know "+beverageType+". Could you pick something else?");
                beverageType = input("What is the response?", true);
            }
        }
        
        print("Have " + beverage);
        
        insertLine();
        makeAppointment("Drinking " + beverage);
    } else {
        insertLine();
        findCommonInterest();
    }
}

void findCommonInterest() {
    string chosenInterest = "";
    string interests[7];
    int interestsLength = sizeof(interests)/sizeof(*interests);
    
    for (int i = 0; interestsLength > i; ++i) {
        printPrefix("Say", "Recreational activity? Tell me one of your interests.");
        string interest = input("What is the response?");
        if(validateQuestion("Do I share that interest in "+interest+"?")) {
            chosenInterest = interest;
            break;
        } else {
            interests[i] = interest;
        }
    }
    if(chosenInterest == "") {
        insertLine();
        print("Choose least objectionable interest:");
        for (int i = 0; interestsLength > i; ++i) {
            print(to_string(i + 1) + ": " + interests[i]);
        }
        int index = validateNumber("Number: ", 1, interestsLength)-1;
        chosenInterest = interests[index];
    } else {
        printPrefix("Say", "Why don't we do "+chosenInterest+" together?");
    }
    print("Partake in "+chosenInterest);
    
    insertLine();
    makeAppointment(chosenInterest);
}

void makeAppointment(string eventTitle) {
    printPrefix("Ask", "Should we make an appointment?");
    if(validateQuestion("What is the response?")) {
        string date = input("At what date? (dd.mm.yyyy)");
        string time = input("At what time? (hh:mm:ss)");
        string newFriend = input("Name of new friend?");
        createAppointment(appointments, date, time, eventTitle, newFriend);
    }
    insertLine();
    beginFriendship();
}

void beginFriendship() {
    print("Begin Friendship!");
    insertLine();
}
