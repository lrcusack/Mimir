#!/bin/bash

javac -Xlint -d ../../bin -classpath ".;../../lib/commons-math3-3.3.jar;../../lib/mimir.patterns.jar;" ControlChart.java

#javac -d ../../bin -classpath ".;../../lib/commons-math3-3.3.jar;../../bin;" *.java