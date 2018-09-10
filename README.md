# Experimento: Aplicação Java de monitoramento de luminosidade e temperatura usando Arduino + Javino

## Tecnologias Utitizadas:

*  Software
	*  Python 2.7
	*  PySerial 2.7
	*  Java SDK
	*  Arduino IDE
*  Bibliotecas
	*  Javino
	*  XChart
*  Hardware
	*  Arduino UNO
	*  Sensor de luminosidade
	*  Sensor de temperatura
	*  Capacitor
	*  Resistor
	*  Fios
	*  Breadboard

## Preparação em software
*  Instalação dos softwares.
*  Adicionar JARS de bibliotecas (XChart e Javino) ao código fonte da aplicação Java.
*  Adicionar .ZIP da dependência de biblioteca Javino ao código fonte da aplicação Arduino.

## Preparação em hardware
*  Conectar circuitos de acordo com a imagem abaixo
  ![alt text](https://github.com/eduardojandre/tempchart/blob/master/circuitov2.png)
  
  Retirado de https://learn.adafruit.com/tmp36-temperature-sensor/using-a-temp-sensor
*  Conectar Arduino ao computador pela porta USB (COM4)

## Procedimentos de hardware/software
*  Carregar script (arduino_codev2.ino) Arduino na placa através da IDE.
*  Adicionar capacitor ligado nos pinos RESET (positivo) e GND (negativo).
*  Abrir a aplicação Java e executar a classe principal (Main.java).

## Exemplo de execução
![alt text](https://github.com/eduardojandre/tempchart/blob/master/captura.png)



