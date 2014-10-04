package mimir.charts;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import mimir.patterns.*;

public class ControlChart{
	DescriptiveStatistics data;
	String characteristic;
	double ucl, cl, lcl, sigma;
	PatternRule[] patterns;

	public ControlChart(String charName, double[] tSet){
		this.characteristic = charName;
		this.data = new DescriptiveStatistics(tSet);
		this.cl = this.data.getMean();
		this.sigma = data.getStandardDeviation();
		this.ucl = this.cl + 3*this.sigma;
		this.lcl = this.cl - 3*this.sigma;
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
		return;
	}

	
	public void addDefaultPatterns(){
		this.patterns = new PatternRule[8];
		//System.out.println("Just Checking");
		this.patterns[0] = new AltIncDec(this.cl);
		this.patterns[1] = new ConstIncDec(this.cl);
		this.patterns[2] = new OutsideTwoSigma(this.cl,this.sigma);
		this.patterns[3] = new InsideOneSigma(this.cl,this.sigma);
		this.patterns[4] = new OutsideLimits(this.cl,this.sigma);
		this.patterns[5] = new OutsideOneSigma(this.cl,this.sigma);
		this.patterns[6] = new OneSide(this.cl);
		this.patterns[7] = new BetweenOneTwo(this.cl,this.sigma);	
	
		return;	
	}

	public boolean newValue(double value){
		//add value to data
		//iterate through patterns to catch signals
		//handle signals
	}

	public void addPattern(PatternRule p){

		return;
	}
	public void clearPatterns(){
		//empty patterns list
		return;
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