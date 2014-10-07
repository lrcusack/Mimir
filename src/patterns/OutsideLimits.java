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
public class OutsideLimits extends PatternRule {
	//One or more points outside of control limits

	public OutsideLimits(double cl, double sigma, double clim, double wlim){
		this.cl = cl;
		this.ucl = this.cl + clim*sigma;
		this.lcl = this.cl - clim*sigma;
		this.name = "One or more points outside of control limits";
	}
	public boolean check(double value){
		return (value >= this.ucl || value <= this.lcl);
	}
}