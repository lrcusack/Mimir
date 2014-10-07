#!/bin/bash

javac -d ../../bin -classpath ".;" PatternRule.java

javac -d ../../bin -classpath ".;" *.java
#jar cf0  ../../lib/mimir.patterns.jar -C ../../bin/ mimir/patterns