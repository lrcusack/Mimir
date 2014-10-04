package mimir.patterns;

public interface PatternRule{
	//check returns true if the pattern is recognized, i.e. process is out of control
	public boolean check(double value);
}
