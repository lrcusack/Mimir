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

package mimir;

public abstract class PatternRule{
	//check returns true if the pattern is recognized, i.e. process is out of control
	public String name;
	public double ucl, cl, lcl, uwl, lwl, sigma, climit, wlimit;
	//public abstract PatternRule(double cl, double sigma, double clim, double wlim);
	//(this.cl,this.sigma,this.clim,this.wlim)
	public abstract boolean check(double value);
}
