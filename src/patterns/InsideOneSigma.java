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
public class InsideOneSigma extends PatternRule {
	//Fifteen points in a row within one-sigma limits
	int count;
	int n = 15;
	double cl;
	double sigma;
	public InsideOneSigma(double c, double s){
		this.cl = c;
		this.sigma = s;
		this.count=0;
		this.name = "Fifteen points in a row within one-sigma limits";
	}
	public boolean check(double value){
		if (Math.abs(value-cl) <= sigma){
			count++;
		} else {
			count = 0;
		}
		return (count>=n);
	}

}