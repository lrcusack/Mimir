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

// #### Verified ####
package mimir.patterns;
public class ConstIncDec extends PatternRule {
	//Six points in a row steadily increasing or decreasing
	int count;
	int n = 6;
	double last;
	boolean up;
	public ConstIncDec(double cl){
		this.count = 0;
		this.last = cl;
		this.up = true;
		this.name = "Six points in a row steadily increasing or decreasing";
	}
	public boolean check(double value){
		if (this.up){
			if(value > this.last){
				this.count++;
			} else {
				this.count = 1;
				up = false;
			}
		} else {
			if(value<=this.last){
				this.count++;
			} else {
				this.count = 1;
				up = true;
			}
		}
		this.last = value;
		if(count>=n) return true;
		else return false;
	}

}