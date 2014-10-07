#!/bin/bash

javac -Xlint -d ../../bin -classpath ".;../../lib/commons-math3-3.3.jar;../../bin/;" ControlChart.java

#jar cf0  ../../lib/mimir.charts.jar -C ../../bin/ mimir/charts

#javac -d ../../bin -classpath ".;../../lib/commons-math3-3.3.jar;../../bin;" *.java