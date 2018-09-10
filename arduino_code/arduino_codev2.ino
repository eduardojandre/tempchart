#include <Javino.h>
Javino javino;

int tempSensor = A0;
int lightSensor = A1;

String msg = "";

double temperature = 0;
double lux = 0;

void setup() {
  // put your setup code here, to run once:
  pinMode(tempSensor, INPUT_PULLUP);
  pinMode(lightSensor, INPUT);

  Serial.begin (9600);

  analogReference(EXTERNAL);
}

void loop() {
  // put your main code here, to run repeatedly:
  temperature = (analogRead(tempSensor)*10)*0.00488759;
  lux = analogRead(lightSensor);
  
  if(javino.availablemsg()){
    msg = javino.getmsg();
    if(msg == "temp"){
      javino.sendmsg(String(temperature,2));
    } else if (msg == "lux"){
      javino.sendmsg(String(lux));
    }
  }
  
  /*
  Serial.println("temp "+String(temperature));
  Serial.println(lux);
  */
  delay(10);
}
