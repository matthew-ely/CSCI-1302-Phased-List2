#!/bin/bash
javac -d bin -cp bin:phase2.jar src/BaseStringList.java
javac -d bin -cp bin:phase2.jar src/ArrayStringList.java
javac -d bin -cp bin:phase2.jar src/LinkedStringList.java
javac -d bin -cp bin:phase2.jar src/Driver.java
java -cp bin:phase2.jar Driver
