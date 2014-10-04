package mimir.patterns;
public class OutsideLimits implements PatternRule {
	//One or more points outside of control limits
	double cl;
	double ucl;
	public OutsideLimits(double c, double s){
		this.cl = c;
		this.ucl = c + 3*s;
	}
	public boolean check(double value){
		return (Math.abs(value-cl) >= ucl);
	}
}