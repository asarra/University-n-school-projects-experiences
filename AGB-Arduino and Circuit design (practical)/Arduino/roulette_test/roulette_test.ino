#define zeit 30                                                            // Blinkgeschwindigkeit
#define stopp 10
#define start 500                                                          // Programm Start

int pin [] = {3,4,5,6,7,8,9,10,11,12};                                     // LED Pin Ausgänge
int tasterPin = 0, tasterWert = 0;                                         // Taster Pin
int letzteZahl = 1;

void setup () {
  randomSeed(analogRead(0));
  for(int i = 0; i <10; i++)
    pinMode(pin[i], OUTPUT);}
void loop(){
  if(analogRead(tasterPin) > start)                                         // Taster auslesen
    gameStart(random(1,stopp));}
void gameStart(int zahl){                                                 // roulette Start
  digitalWrite(letzteZahl + 1,LOW);
  letzteZahl = zahl;
  int k = 1;
  for(int i = 0; i < 6; i++){
    if(i > 2) k++;
      for(int j = 0; j < 10; j++){
        digitalWrite(pin[j], HIGH);
        if((i == 5)&&(j + 1 == zahl)) break;
        delay(zeit * k);
        digitalWrite(pin[j], LOW);
}}}                                                                            // Ende und Neustart  
