//2-Way motor control

int motorPin1 =  5;    // One motor wire connected to digital pin 5
int motorPin2 =  6;    // One motor wire connected to digital pin 6
int motorPin10 =  10;    // One motor wire connected to digital pin 5
int motorPin11 =  11;    // One motor wire connected to digital pin 6

// The setup() method runs once, when the sketch starts

void setup()   {                
  // initialize the digital pins as an output:
  pinMode(motorPin1, OUTPUT); 
  pinMode(motorPin2, OUTPUT);  
  pinMode(motorPin10, OUTPUT); 
  pinMode(motorPin11, OUTPUT);  
}

// the loop() method runs over and over again,
// as long as the Arduino has power
void loop()                     
{
  rotateRight(255, 500);
  rotateLeft(255, 1500);
  rotateRight10(255, 500);
  rotateLeft10(255, 1500);

}

void rotateLeft(int speedOfRotate, int length){
  analogWrite(motorPin1, speedOfRotate); //rotates motor
  digitalWrite(motorPin2, LOW);    // set the Pin motorPin2 LOW
  delay(length); //waits
  digitalWrite(motorPin1, LOW);    // set the Pin motorPin1 LOW
}

void rotateRight(int speedOfRotate, int length){
  analogWrite(motorPin2, speedOfRotate); //rotates motor
  digitalWrite(motorPin1, LOW);    // set the Pin motorPin1 LOW
  delay(length); //waits
  digitalWrite(motorPin2, LOW);    // set the Pin motorPin2 LOW
}

void rotateLeft10(int speedOfRotate, int length){
  analogWrite(motorPin10, speedOfRotate); //rotates motor
  digitalWrite(motorPin11, LOW);    // set the Pin motorPin2 LOW
  delay(length); //waits
  digitalWrite(motorPin10, LOW);    // set the Pin motorPin1 LOW
}

void rotateRight10(int speedOfRotate, int length){
  analogWrite(motorPin11, speedOfRotate); //rotates motor
  digitalWrite(motorPin10, LOW);    // set the Pin motorPin1 LOW
  delay(length); //waits
  digitalWrite(motorPin11, LOW);    // set the Pin motorPin2 LOW
}
