#define ABSTAND 500
const int taster=12;
boolean buttonPressed=false;
//Ampel 1
#define ROT 2
#define GELB 1
#define GRUEN 0

//Ampel 2
#define ROT1 5
#define GELB1 4
#define GRUEN1 3

//Ampel 3
#define ROT2 8
#define GELB2 7
#define GRUEN2 6

//Ampel 4
#define ROT3 11
#define GELB3 10
#define GRUEN3 9


void setup() {
  //Ampel 1
  pinMode(ROT,OUTPUT);
  pinMode(GELB,OUTPUT);
  pinMode(GRUEN,OUTPUT);

  //Ampel 2
  pinMode(ROT1,OUTPUT);
  pinMode(GELB1,OUTPUT);
  pinMode(GRUEN1,OUTPUT);

  //Ampel 3
  pinMode(ROT2,OUTPUT);
  pinMode(GELB2,OUTPUT);
  pinMode(GRUEN2,OUTPUT);

  //Ampel 4
  pinMode(ROT3,OUTPUT);
  pinMode(GELB3,OUTPUT);
  pinMode(GRUEN3,OUTPUT);

pinMode(taster, INPUT);
}

void loop() {

//buttonPressed=digitalRead(taster);
if(buttonPressed==HIGH){  
  digitalWrite(ROT,HIGH);
  delay(ABSTAND*10);
  digitalWrite(ROT,LOW);
  delay(ABSTAND);
    
  digitalWrite(ROT1,HIGH);
  delay(ABSTAND*10);
  digitalWrite(ROT1,LOW);
  delay(ABSTAND);

  digitalWrite(ROT2,HIGH);
  delay(ABSTAND*10);
  digitalWrite(ROT2,LOW);
  delay(ABSTAND);

  digitalWrite(ROT3,HIGH);
  delay(ABSTAND*10);
  digitalWrite(ROT3,LOW);
  delay(ABSTAND);
  }
 else if(buttonPressed==LOW){    

  //Ampel 1
  digitalWrite(GRUEN,HIGH);
  delay(ABSTAND*2);
  digitalWrite(GRUEN,LOW);
  delay(ABSTAND);
  
  digitalWrite(GELB,HIGH);
  delay(ABSTAND*10);
  digitalWrite(GELB,LOW);
  delay(ABSTAND);
  
  digitalWrite(ROT,HIGH);
  delay(ABSTAND*10);
  digitalWrite(ROT,LOW);
  delay(ABSTAND);


  //Ampel 2
  digitalWrite(GRUEN1,HIGH);
  delay(ABSTAND*10);
  digitalWrite(GRUEN1,LOW);
  delay(ABSTAND);
  
  digitalWrite(GELB1,HIGH);
  delay(ABSTAND);
  digitalWrite(GELB1,LOW);
  delay(ABSTAND);

  digitalWrite(ROT1,HIGH);
  delay(ABSTAND*10);
  digitalWrite(ROT1,LOW);
  delay(ABSTAND);


  //Ampel 3
  digitalWrite(GRUEN2,HIGH);
  delay(ABSTAND*10);
  digitalWrite(GRUEN2,LOW);
  delay(ABSTAND);
  
  digitalWrite(GELB2,HIGH);
  delay(ABSTAND);
  digitalWrite(GELB2,LOW);
  delay(ABSTAND);

  digitalWrite(ROT2,HIGH);
  delay(ABSTAND*10);
  digitalWrite(ROT2,LOW);
  delay(ABSTAND);


  //Ampel 4
  digitalWrite(GRUEN3,HIGH);
  delay(ABSTAND*10);
  digitalWrite(GRUEN3,LOW);
  delay(ABSTAND);
  
  digitalWrite(GELB3,HIGH);
  delay(ABSTAND);
  digitalWrite(GELB3,LOW);
  delay(ABSTAND);

  digitalWrite(ROT3,HIGH);
  delay(ABSTAND*10);
  digitalWrite(ROT3,LOW);
  delay(ABSTAND);
}
}
