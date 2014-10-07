#!/bin/bash

cd patterns
bash build-patterns.sh

cd ../chart
bash build-chart.sh

cd ../test
bash build-test.sh

cd ..