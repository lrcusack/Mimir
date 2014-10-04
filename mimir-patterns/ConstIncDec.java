//package io.kd.lrcusack.mimir;

public class ConstIncDec implements PatternRule {
	//Six points in a row steadily increasing or decreasing
	int count;
	int n = 6;
	double last;
	boolean up;
	public ConstIncDec(double cl){
		this.count = 0;
		this.last = cl;
		this.up = true;
	}
	public boolean check(double value){
		if (this.up){
			if(value > this.last){
				this.count++;
			} else {
				this.count = 1;
				up = false;
			}
		} else {
			if(value<=this.last){
				this.count++;
			} else {
				this.count = 1;
				up = true;
			}
		}
		this.last = value;
		if(count>=n) return true;
		else return false;
	}

}