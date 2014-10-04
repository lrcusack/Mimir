#!/bin/bash

cd patterns
bash build-patterns-jar.sh

cd ../chart
bash build-chart.sh

cd ..