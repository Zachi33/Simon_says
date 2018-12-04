package Logic;

import Finch.Finch_Hub;
import edu.cmu.ri.createlab.terk.robot.finch.Finch;

public class Simon_says {
public static void main(String args[]) throws Exception {
	Finch f1=new Finch();
	while(f1.isTapped()) {
		Thread.sleep(100);
	}
	while(!f1.isTapped()) {
		Thread.sleep(100);
	}
	
	f1.setLED(10, 255, 0);
	Thread.sleep(1000);
	boolean b =false;
	System.out.println("TAPNOM! XD");
	while(!b) {
		Thread.sleep(100);
		b = System.in.read()==(int)'b'||f1.isTapped();
	}
	
	Finch f2=new Finch();
	Thread.sleep(4000);
	f2=f1;
	
	f1.setLED(100, 25, 0);
	Thread.sleep(1000);
	System.out.println("TAPNOM! XD"); 
	while(!f1.isTapped()) {
		Thread.sleep(100);
	}
	
	
	System.out.println("TAPNOM! XD");
	f1.setLED(10, 255, 250);
	Thread.sleep(300);
	f1.quit();
	
	
	
	//Finch_Hub.initialize(4);
	//Sequence.initialize();
}
}
