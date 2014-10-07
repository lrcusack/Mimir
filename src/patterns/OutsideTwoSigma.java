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
package mimir;
public class OutsideTwoSigma extends PatternRule {
	//Two of three consecutive points outside the two-sigma warning limits but still within control (3 sigma) limits
	int nextIndex;
	boolean[] three;

	public OutsideTwoSigma(double cl, double sigma, double clim, double wlim){
		this.cl = cl;
		this.sigma = sigma;
		this.nextIndex = 0;
		this.three = new boolean[3];
		this.name = "Two of three consecutive points outside the two-sigma warning limits but still within control (3 sigma) limits";
	}

	public boolean check(double value){
		three[nextIndex] = (Math.abs(value-this.cl)>=this.wlimit*sigma && Math.abs(value-this.cl)<=this.climit*sigma);
		nextIndex = (nextIndex + 1) % 3;
		return ((three[0]&&three[1]) || (three[1]&&three[2]) || (three[2]&&three[0]));
	}

}