#define zeit 50                                                            
#define stopp 10
#define start 500                                                          

int pin [] = {2,3,4,5,6,7,8,9,10,11,12,13};                                 
int tasterPin = A3, tasterWert = 0;                                        
int letzteZahl = 1;

void setup () {
randomSeed(analogRead(2));
for(int i = 0; i <12; i++)
pinMode(pin[i], OUTPUT);
}void loop(){
if(analogRead(tasterPin) > start)                                         
gameStart(random(1,stopp));
}void gameStart(int zahl){                                                
digitalWrite(letzteZahl + 1,LOW);
letzteZahl = zahl;
int k = 1;
for(int i = 0; i < 6; i++){
if(i > 2) k++;
for(int j = 0; j < 12; j++){
digitalWrite(pin[j], HIGH);
if((i == 5)&&(j + 1 == zahl)) break;
delay(zeit * k);
digitalWrite(pin[j], LOW);
}
}
}                                                    
