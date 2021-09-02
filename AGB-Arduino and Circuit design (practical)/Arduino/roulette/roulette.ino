#define WARTEZEIT 40
#define OBERGRENZE 13
#define THRESHOLD 1000
int tasterPin=0, tasterWert=0;
int letzteZahl=1;
int pin[]={2,3,4,5,6,7,8,9,10,11,12,13};

void setup() {
randomSeed(analogRead(5));
for(int i=0;i<12;i++)
  pinMode(pin[i], OUTPUT);
}

void loop() {
  if(analogRead(tasterPin) > THRESHOLD)
    rouletteStart(random(1, OBERGRENZE));
}

void rouletteStart(int zahl){
  digitalWrite(letzteZahl+1, LOW);
  letzteZahl=zahl;
  int k=1;
  for(int i=0;i<6;i++){
    if(i>2)k++;
    for(int j = 0;j<12;j++){
      digitalWrite(pin[j], HIGH);}
    }
}
