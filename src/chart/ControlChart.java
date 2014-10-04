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


package mimir.charts;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import java.util.LinkedList;
import java.util.ListIterator;
import mimir.patterns.*;

public class ControlChart{
	DescriptiveStatistics data;
	String characteristic;
	double ucl, cl, lcl, sigma;
	LinkedList<PatternRule> patterns;
	LinkedList<String> signals;

	public ControlChart(String charName, double[] tSet){
		this.characteristic = charName;
		this.data = new DescriptiveStatistics(tSet);
		this.cl = this.data.getMean();
		this.sigma = data.getStandardDeviation();
		this.ucl = this.cl + 3*this.sigma;
		this.lcl = this.cl - 3*this.sigma;
		this.patterns = new LinkedList<PatternRule>();
		this.signals = new LinkedList<String>();
	}

	public static void main(String[] args){
		double[] vals = new double[100];
		for(int ii=0;ii<100;ii++){
			vals[ii] = Math.random()*10;
		}
		ControlChart cc = new ControlChart("xbar", vals);
		cc.addDefaultPatterns();
		System.out.println(
							"cl: "+ cc.cl + "\n"+
							"ucl: "+ cc.ucl + "\n"+
							"lcl: "+ cc.lcl + "\n"+
							"sigma: "+ cc.sigma + "\n"
							);
		cc.newValue(8); cc.printSignals(); cc.clearSignals();
		cc.newValue(8); cc.printSignals(); cc.clearSignals();
		cc.newValue(8); cc.printSignals(); cc.clearSignals();
		cc.newValue(8); cc.printSignals(); cc.clearSignals();
		cc.newValue(8); cc.printSignals(); cc.clearSignals();
		cc.newValue(2); cc.printSignals(); cc.clearSignals();
		cc.newValue(2); cc.printSignals(); cc.clearSignals();
		cc.newValue(2); cc.printSignals(); cc.clearSignals();
		cc.newValue(2); cc.printSignals(); cc.clearSignals();
		cc.newValue(2); cc.printSignals(); cc.clearSignals();
		cc.newValue(2); cc.printSignals(); cc.clearSignals();
		cc.newValue(5); cc.printSignals(); cc.clearSignals();
		cc.newValue(5); cc.printSignals(); cc.clearSignals();
		cc.newValue(5); cc.printSignals(); cc.clearSignals();
		cc.newValue(5); cc.printSignals(); cc.clearSignals();
		cc.newValue(5); cc.printSignals(); cc.clearSignals();
		cc.newValue(5); cc.printSignals(); cc.clearSignals();
		cc.newValue(5); cc.printSignals(); cc.clearSignals();
		return;
	}

	
	public void addDefaultPatterns(){
		//System.out.println("Just Checking");
		this.patterns.add(new AltIncDec(this.cl));
		this.patterns.add(new ConstIncDec(this.cl));
		this.patterns.add(new OutsideTwoSigma(this.cl,this.sigma));
		this.patterns.add(new InsideOneSigma(this.cl,this.sigma));
		this.patterns.add(new OutsideLimits(this.cl,this.sigma));
		this.patterns.add(new OutsideOneSigma(this.cl,this.sigma));
		this.patterns.add(new OneSide(this.cl));
		this.patterns.add(new BetweenOneTwo(this.cl,this.sigma));	
	
		return;	
	}

	public void newValue(double value){
		//add value to data
		this.data.addValue(value);
		System.out.println("Added Value: "+value+" to dataset");
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
	public void setCL(double c){
		this.cl = c;
		return;
	}
	public void reset(double[] newData){
		this.data = new DescriptiveStatistics(newData);
		this.cl = this.data.getMean();
		this.sigma = this.data.getStandardDeviation();
		this.ucl = this.cl + 3*this.sigma;
		this.lcl = this.cl - 3*this.sigma;
		return;
	}
	public void reset(){
		this.cl = this.data.getMean();
		this.sigma = this.data.getStandardDeviation();
		this.ucl = this.cl + 3*this.sigma;
		this.lcl = this.cl - 3*this.sigma;
		return;
	}
}