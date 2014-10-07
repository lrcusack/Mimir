import mimir.charts.*;
import mimir.patterns.*;


public class ControlChartTester{
	public static void main(String[] args){
		double[] vals = new double[100];
		for(int ii=0;ii<100;ii++){
			vals[ii] = Math.random()*10;
		}
		ControlChart cc = new ControlChart("xbar", vals,3,2);
		cc.addDefaultPatterns();
		System.out.println(
							"cl: "+ cc.getCL() + "\n"+
							"ucl: "+ cc.getUCL() + "\n"+
							"lcl: "+ cc.getLCL() + "\n"+
							"sigma: "+ cc.getSigma() + "\n"
							);
		for(int ii=0; ii<10000;ii++){cc.newValue(Math.random()*10); cc.printSignals(); cc.clearSignals();}

		return;
	}
}