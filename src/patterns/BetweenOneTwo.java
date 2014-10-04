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
public class BetweenOneTwo extends PatternRule {
	//Eight points in a row between the one-sigma and two-sigma limits
	double cl;
	double sigma;
	int count;
	int n = 8;
	public BetweenOneTwo(double c, double s){
		this.cl = c;
		this.sigma = s;
		this.count=0;
		this.name = "Eight points in a row between the one-sigma and two-sigma limits";
	}
	public boolean check(double value){
		if((Math.abs(value-this.cl)<= 2*sigma) && (Math.abs(value-this.cl)>=sigma)){
			count++;
		} else {
			count = 0;
		}
		return (count>=n);
	}

}
