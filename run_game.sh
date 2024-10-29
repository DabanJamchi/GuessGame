#!/bin/bash
echo "Dabans Guesser"
mkdir -p Daban_Jamchi_labb
cp *.java Daban_Jamchi_labb
cd Daban_Jamchi_labb
echo "Current directory: $(pwd)"
echo "Compiling..."
javac GuessingGame.java
echo "Running game..."
java GuessingGame
echo "Done"
rm *.class
ls
