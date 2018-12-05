package Finch;

import Logic.Color;
import Logic.Simon_says;
import edu.cmu.ri.createlab.terk.robot.finch.Finch;

public class Finch_input{
	
	public int number=-1;
	public Finch myf=null;
	public boolean isVirtual=false;
	public Finch_input(boolean isVirtuall,int number) {
		this.number=number;
		this.isVirtual=isVirtuall;
	if(isVirtual) {
		
	}
	else {
		myf=new Finch();
	}
}
public boolean listen(int input) throws Exception {
	boolean out=false;
	if(isVirtual) {
		out=(input==number);
		
	}
	else {
		out=myf.isTapped();
		if(out) {
			Color c=Simon_says.set[number-1];
			myf.setLED(c.r, c.g, c.b);
			Thread.sleep(20);
			myf.setLED(0,0,0);
		}
	}
	return out;
}
public void byeFinch() {
	myf.quit();
}
}
