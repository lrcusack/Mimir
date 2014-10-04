package mimir.patterns;

public class AltIncDec implements PatternRule {
	//Fourteen points in a row alternating up and down
	int count;
	int n = 14;
	double last;
	boolean up;
	public AltIncDec(double cl){
		this.count = 0;
		this.last = cl;
		this.up = true;
	}
	public boolean check(double value){
		if (this.up){
			if(value<= this.last){
				this.count++;
				up = false;
			} else {
				this.count = 1;
			}
		} else {
			if(value > this.last){
				this.count++;
				up = true;
			} else {
				this.count = 1;
			}
		}
		this.last = value;
		if(count>=n) return true;
		else return false;
	}

}