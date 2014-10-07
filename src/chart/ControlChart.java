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

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import java.util.LinkedList;
import java.util.ListIterator;
import mimir.*;

public class ControlChart{
	DescriptiveStatistics data;
	String characteristic;
	double ucl, cl, lcl, uwl, lwl, sigma, climit, wlimit;
	LinkedList<PatternRule> patterns;
	LinkedList<String> signals;

	public ControlChart(String charName, double[] tSet, double climit, double wlimit){
		this.patterns = new LinkedList<PatternRule>();
		this.signals = new LinkedList<String>();
		this.reset(charName,tSet,climit,wlimit);
	}

	//public static void main(String[] args){}
	
	public void addDefaultPatterns(){
		//System.out.println("Just Checking");
		this.patterns.add(new AltIncDec		  (this.cl,this.sigma,this.climit,this.wlimit));
		this.patterns.add(new ConstIncDec	  (this.cl,this.sigma,this.climit,this.wlimit));
		this.patterns.add(new OutsideTwoSigma (this.cl,this.sigma,this.climit,this.wlimit));
		this.patterns.add(new InsideOneSigma  (this.cl,this.sigma,this.climit,this.wlimit));
		this.patterns.add(new OutsideLimits	  (this.cl,this.sigma,this.climit,this.wlimit));
		this.patterns.add(new OutsideOneSigma (this.cl,this.sigma,this.climit,this.wlimit));
		this.patterns.add(new OneSide		  (this.cl,this.sigma,this.climit,this.wlimit));
		this.patterns.add(new BetweenOneW	  (this.cl,this.sigma,this.climit,this.wlimit));	
  
		return;	
	}
	public void newValue(double value){
		//add value to data
		this.data.addValue(value);
		//System.out.println("Added Value: "+value+" to dataset");
		//iterate through patterns to catch signals
		ListIterator<PatternRule> patternChecker = this.patterns.listIterator(0);
		while(patternChecker.hasNext()){
			PatternRule p = patternChecker.next();
			//System.out.println("Checking for: " + p.name);
			boolean flag = p.check(value);
			if (flag){
				this.signals.add(p.name);
				//System.out.println(" -- caught flag -- ");
			} 
		}
		//handle signals in other scope
		return;
	}
	public void addPattern(PatternRule p){
		this.patterns.add(p);
		return;
	}
	public void clearPatterns(){
		//empty patterns list
		this.patterns.clear();
		return;
	}
	public void clearSignals(){
		//empty signals list
		this.signals.clear();
		return;
	}
	public void printSignals(){
		ListIterator<String> flagChecker = this.signals.listIterator(0);
		while(flagChecker.hasNext()){
			System.out.println(flagChecker.next());
		}
	}
	public void setUCL(double u){
		this.ucl = u;
		return;
	}
	public void setLCL(double l){
		this.lcl = l;
		return;
	}
	public void setUWL(double u){
		this.uwl = u;
		return;
	}
	public void setLWL(double l){
		this.lwl = l;
		return;
	}
	public void setCL(double c){
		this.cl = c;
		return;
	}
	public double getUCL(){

		return this.ucl;
	}
	public double getLCL(){

		return this.lcl;
	}
	public double getUWL(){

		return this.uwl;
	}
	public double getLWL(){

		return this.lwl;
	}
	public double getCL(){

		return this.cl;
	}
	public double getSigma(){

		return this.sigma;
	}
	public void dataReset(double[] newData){
		this.data = new DescriptiveStatistics(newData);
		this.statsReset();
		return;
	}
	public void statsReset(){
		this.cl = this.data.getMean();
		this.sigma = this.data.getStandardDeviation();
		this.ucl = this.cl + this.climit*this.sigma;
		this.lcl = this.cl - this.climit*this.sigma;
		this.uwl = this.cl + this.wlimit*this.sigma;
		this.lwl = this.cl - this.wlimit*this.sigma;
		return;
	}
	public void reset(String charName, double[] tSet, double climit,double wlimit){
		this.characteristic = charName;
		this.dataReset(tSet);
		this.climit = climit;
		this.wlimit = wlimit;
		this.clearSignals();
		this.clearPatterns();
	}
}