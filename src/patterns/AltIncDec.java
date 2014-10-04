/*
Copyright (c) 2014

Author: Liam Cusack

This file is part of Mimir.

Mimir is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

Mimir is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with Mimir.  If not, see <http://www.gnu.org/licenses/>
*/

//#### Verified ####
package mimir.patterns;
public class AltIncDec extends PatternRule {
	//Fourteen points in a row alternating up and down
	int count;
	int n = 14;
	double last;
	boolean up;
	public AltIncDec(double cl){
		this.count = 0;
		this.last = cl;
		this.up = true;
		this.name = "Fourteen points in a row alternating up and down";
	}
	public boolean check(double value){
		if (this.up){
			if(value<= this.last){
				this.count++;
				up = false;
			} else {
				this.count = 1;
			}
		} else {
			if(value > this.last){
				this.count++;
				up = true;
			} else {
				this.count = 1;
			}
		}
		this.last = value;
		if(count>=n) return true;
		else return false;
	}

}