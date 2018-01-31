package Service;

public class Operation {

	public static double calcul(double a,double b,String operation){
		
		if (operation.equals("addition")){
			return a+b;
		}
		if (operation.equals("division")){
			return a/b;
		}
		if (operation.equals("multiplication")){
			return a*b;
		}
		
		throw new ArithmeticException(); 
		
	}
	
}
