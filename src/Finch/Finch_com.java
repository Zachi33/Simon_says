package Finch;


import Logic.Color;
import Logic.Simon_says;

public class Finch_com {

	public Finch_input input=null;
	public boolean clicked=false;
	public boolean glows=false;
	public int number=-1;
	public boolean isVirtual=true;
	public Finch_com(boolean isVirtual,int number) {
		this.number=number;
		this.isVirtual=isVirtual;
		input=new Finch_input(isVirtual,number);
		}
	public boolean listen(int in) throws Exception {return input.listen(in);}
	public void byeFinch() {input.byeFinch();}
	public void light() throws Exception{
		if(isVirtual) {
			System.out.print("Virtual Finch number");
			System.out.print(number);
			System.out.println(" is ON!");
			Thread.sleep(1000);
			System.out.println("**********");
		}
		else {
			System.out.print("Existing Finch number");
			System.out.print(number);
			System.out.println(" is ON!");
			Color c=Simon_says.set[number-1];
			input.myf.setLED(c.r, c.g, c.b);
			Thread.sleep(1000);
			input.myf.setLED(0,0,0);
			System.out.println("**********");
		}
	}
}
