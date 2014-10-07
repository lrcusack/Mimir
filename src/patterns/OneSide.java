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

//broken
package mimir;
public class OneSide extends PatternRule {
	//A run of eight consecutive points on one side of the center line
	int count;
	boolean above;
	int n = 8;
	public OneSide(double cl, double sigma, double clim, double wlim){
		//System.out.println("Just Checking");
		this.cl = cl;
		this.count=0;
		this.above=true;
		this.name = "A run of eight consecutive points on one side of the center line";
	}
	public boolean check(double value){
		if(above && (value>=this.cl)){
			count++;
		} else if (!above && (value<=this.cl)){
			count++;
		} else {
			count = 1;
			above = !above;
		}
		return (count>=n);
	}
}