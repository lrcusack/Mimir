import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import PatternRecognition.*;

public class ControlChart{
	DescriptiveStatistics trainingData;
	String characteristic;
	double ucl, cl, lcl, sigma;
	PatternRule[] patterns;

	public ControlChart(String charName, double[] tSet){
		this.characteristic = charName;
		trainingData = new DescriptiveStatistics(tSet);
		this.cl = trainingData.getMean();
		this.sigma = trainingData.getStandardDeviation();
		this.ucl = this.cl + 3*this.sigma;
		this.lcl = this.cl - 3*this.sigma;
		this.patterns = buildDefaultPatterns(0,1);
	}

	public static void main(String[] args){
		double[] vals = new double[100];
		for(int ii=0;ii<100;ii++){
			vals[ii] = Math.random()*10;
		}
		ControlChart cc = new ControlChart("xbar", vals);
		/*System.out.println(
							"cl: "+ cc.cl + "\n"+
							"ucl: "+ cc.ucl + "\n"+
							"lcl: "+ cc.lcl + "\n"+
							"sigma: "+ cc.sigma + "\n"
							);*/

	}

	public PatternRule[] buildDefaultPatterns(double cl, double sigma){
		PatternRule[] rules = new PatternRule[8];

		rules[0] = new PatternRecognition.AltIncDec(cl);
		rules[1] = new PatternRecognition.ConstIncDec(cl);
		rules[2] = new PatternRecognition.OutsideTwoSigma(cl,sigma);
		rules[3] = new PatternRecognition.InsideOneSigma(cl,sigma);
		rules[4] = new PatternRecognition.OutsideLimits(cl,sigma);
		rules[5] = new PatternRecognition.OutsideOneSigma(cl,sigma);
		rules[6] = new PatternRecognition.OneSide(cl);
		rules[7] = new PatternRecognition.BetweenOneTwo(cl,sigma);	

		return rules;	
	}
}