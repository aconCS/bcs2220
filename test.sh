#!/bin/bash
find src/main/java -name "*.java" > sources.txt
find src/test/java -name "*.java" >> sources.txt

javac -d out -cp "libraries/junit-platform-console-standalone-6.0.3.jar:." @sources.txt

java -jar "libraries/junit-platform-console-standalone-6.0.3.jar" execute \
  --classpath out \
  --select-class WorldStateTest \
  --details tree