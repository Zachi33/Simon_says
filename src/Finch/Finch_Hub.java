package Finch;

import java.util.ArrayList;


public class Finch_Hub {
	
	public static boolean anyVirtual=false;
	public static int finchCount=0;
	public static ArrayList<Finch_com> list = new ArrayList<Finch_com>();
	
public static void initialize(int quantity) throws Exception{
	for(int i=1;i<=quantity;i++) {
		finchCount++;
		list.add(new Finch_com(false,finchCount));
	}
}

public static void initializeVirtual(int quantity) {
	for(int i=1;i<=quantity;i++) {
		anyVirtual=true;
		finchCount++;
		list.add(new Finch_com(true,finchCount));
	}
} 

public static void byeFinches() {
	for(int a=0;a<list.size();a++) {
		if(!list.get(a).isVirtual) {list.get(a).byeFinch();}
		
	}
}

public static int ListenOne(int input) throws Exception{
	int out=-1;
	for(int a=0;a<list.size();a++) {
		if(list.get(a).listen(input)) {out=a+1;break;}
		
		
	}
	return out;
}


}
