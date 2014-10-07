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
public class OutsideOneSigma extends PatternRule {
	//Four of five consecutive points beyond the one-sigma limits but still inside of control limits
	int nextIndex;
	boolean[] five;

	public OutsideOneSigma(double cl, double sigma, double clim, double wlim){
		this.cl = cl;
		this.sigma = sigma;
		this.nextIndex = 0;
		this.five = new boolean[5];
		this.name = "Four of five consecutive points beyond the one-sigma limits but still inside of control limits";
	}

	public boolean check(double value){
		five[nextIndex] = (Math.abs(value-cl)>=sigma && Math.abs(value-cl)<=3*sigma);
		nextIndex = (nextIndex + 1) % 5;
		int count=0;
		for(int ii=0; ii<5; ii++){
			if(five[ii]) count++;
		}
		return (count>=4);
	}

}