package Logic;

import java.util.ArrayList;
import Finch.Finch_Hub;

public class Sequance {
	
	public static ArrayList<Step> seqence=null;
	public static void initialize() {
		
		
		seqence=new ArrayList<Step>();
		//seqence.add(new Step(Simon_says.set[getRandom(Finch_Hub.finchCount)]));
		
	}
	public static void update() {
		seqence.add(new Step(Simon_says.set[getRandom(Finch_Hub.finchCount)]));
	}
	
	public static void Show() throws Exception {
		for(int q=0;q<seqence.size();q++) {
			Finch_Hub.list.get(seqence.get(q).c.finch-1).light();
			
		}
		
	} 
	
	public static boolean check() throws Exception {
		
		/*/
		 * x false: mistake
		 * x true: correct sequence
		 */
		boolean x=true;
		for(int q=0;q<seqence.size();q++) {
			if(Simon_says.receiveONEinput()!=seqence.get(q).c.finch) {
				x=false;break;
			}
			
		}
		return x;
	} 
	
	public static int getRandom(int upto) {
		int a=(int)(Math.random()*1000*Math.random());
		return a%upto;
	}
}
