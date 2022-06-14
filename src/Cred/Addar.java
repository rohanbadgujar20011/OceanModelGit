package Cred;
import java.util.Arrays;

public class Addar {
	public static int a;
	static int []y=new int[100];

	public static int[] getA() {
		return y;
	}

	public static void setA(int a) {
	
		 y= Arrays.copyOf(y, y.length + 1);
		 y[y.length - 1] = a; 
		
	
		Addar.a = a;
	}

}
