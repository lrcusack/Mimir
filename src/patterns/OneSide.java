package mimir.patterns;
public class OneSide implements PatternRule {
	//A run of eight consecutive points on one side of the center line
	double cl;
	int count;
	boolean above;
	int n = 8;
	public OneSide(double c){
		//System.out.println("Just Checking");
		this.cl = c;
		this.count=0;
		this.above=true;
	}
	public boolean check(double value){
		if(above && (value>=this.cl)){
			count++;
		} else if (!above && (value<=this.cl)){
			count++;
		} else {
			count = 1;
			above = !above;
		}
		return (count>=n);
	}
}