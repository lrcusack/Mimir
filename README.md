## Synopsis

Mimir is a platform for quick and easy quality control chart creation and automated pattern recognition for out-of-control signals

## Motivation

Control charts are a clean way of visualizing a process's performance, and automated pattern recognition aids the user by detecting unusual or out of control behavior

## Installation

cd to the src directory, then bash build.sh

Packages are compiled as jars in the lib folder and example code can be found in the examples folder

## API Reference/Code Example


Custom patterns can be added, simply implement a class like the following:
```
public class myPattern implements PatternRule {
	...;
	public myPattern(...){
		...
	}
	public boolean check(double value){
		...;
		return (...);
	}
}
```
and make sure the check() function returns true if the pattern is matched. Then instantiate it and pass it to the chart with addPattern:
'''
myChartMethod(myVals)
	ControlChart myChart = new ControlChart("myCharacteristic", myVals);
	myChart.addDefaultPatterns(); // optional but recommended
	myChart.addPattern(new myPattern(...));
//...
```

## Tests

No tests have been developed yet, patterns still need to be tested.

## To Do

*Data stream - create a dynamic way to feed data to the ControlChart object. Ideally this could interface to files, live input from a console, or live tcp/udp data.
*Pattern LinkedList - control chart patterns currently are a static array, they need to be turned into a linked list so patterns can be added or removed
*Implementations:
  -addPattern
  -clearPatterns
*Make PatternRule an Abstract class, define some variables and some methods
  -signalString
  -handleSignal
*

## License

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program.  If not, see <http://www.gnu.org/licenses/>.

See GNU-GPL.txt for more details