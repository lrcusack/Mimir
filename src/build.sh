#!/bin/bash

cd patterns
bash build-patterns.sh

cd ../chart
bash build-chart.sh

cd ..
jar cf0  ../lib/mimir.jar -C ../bin/ mimir/

cd ./test
bash build-test.sh

