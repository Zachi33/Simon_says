package Logic;


import Finch.Finch_Hub;
//import edu.cmu.ri.createlab.terk.robot.finch.Finch;

public class Simon_says {
	
	public static Color[] set;
	static Thread s=null;
	public static ContemporaryScanner scan=null;
	
	public static void main(String args[]) throws Exception {
	

	Finch_Hub.initializeVirtual(1);
	Finch_Hub.initialize(1);
	initializeScanner();
	setColors();
	Sequance.initialize();

	do {
	Sequance.update();
	Sequance.Show();
	}while(Sequance.check());
	
	
	System.out.println("Score: "+ Sequance.seqence.size());
	exit();
	

	
}
	public static void initializeScanner() {

		scan = new ContemporaryScanner();
		s = new Thread(scan,"scan");
		s.start();
	}
	public static void exit() {
		Finch_Hub.byeFinches();
		System.exit(0);
	}
	static void setColors() {
		set = new Color[5];
		set[0]=new Color(255,0,0,1);
		set[1]=new Color(0,255,0,2);
		set[2]=new Color(0,0,255,3);
		set[3]=new Color(255,255,0,4);
		set[4]=new Color(255,255,255,5);
	}
	public static int receiveONEinput()throws Exception {
		int output=-1;
		int input=-1;
		while(output==-1){
			
			input=scan.last_output;	
			output=Finch_Hub.ListenOne(input);
			Thread.sleep(100);
		}
		scan.last_output=-1;
		return output;
	}
}
