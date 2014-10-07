#!/bin/bash

javac -Xlint -d ../../bin/test -classpath ".;../../lib/commons-math3-3.3.jar;../../lib/mimir.patterns.jar;../../lib/mimir.charts.jar" ControlChartTester.java

#javac -d ../../bin -classpath ".;../../lib/commons-math3-3.3.jar;../../bin;" *.java