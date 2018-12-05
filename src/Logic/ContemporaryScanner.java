package Logic;

import java.util.Scanner;

public class ContemporaryScanner implements Runnable {
	
	public boolean finish=false;
	public int last_output=-5;
	Scanner s=null;
	public ContemporaryScanner() {
		
		s = new Scanner(System.in);
	} 
	
	
	public void run(){
		while(!finish)
			if(s.hasNext())
		last_output=s.nextInt();
	}
	public void close() {
		finish=true;
		
		
	}

}
