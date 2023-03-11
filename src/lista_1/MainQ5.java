package lista_1;

import java.io.File;
import java.util.Scanner;

public class MainQ5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File entradas = new File("entradas_q5.txt");
		try {
			Scanner input = new Scanner(entradas);
			while(input.hasNext()) {
				String numberString = input.next();
				
				System.out.println();
				System.out.println(numberString);
				
				
				normalizeNumber(Double.valueOf(numberString.replaceAll(",", ".")), Integer.valueOf(args[0]) , Integer.valueOf(args[1]), Integer.valueOf(args[2])); //definidos conforme o comando
				
			}
		}catch(Exception error) {
			error.printStackTrace();
		}
			
	}
	public static void normalizeNumber(double number, int max,int min,int length) {
		int current = 0;
		double temp = number;
		if((int)temp != 0) { /// trazer pra tras
			
			 toFrontMantica(temp, max,length);
			
		}else { /// trazer pra frente
			 toBackMantica(temp, min,length);
			
		}
		System.out.println();
	
	}
	public static void toFrontMantica(double number, int max,int length) {
		double temp = number;
		int current = 0;
		while(0 != (int)temp && current != max) {
			temp = number / Math.pow(10, ++current); 
		}
		if((int)temp != 0) {
			System.out.println("Numero maximo de expoente insuficiente");
		}
		System.out.printf("%."+length+"f * 10^%d", temp,current);
	}
	public static void toBackMantica(double number, int min,int length) {
		double temp = number;
		int current = 0;
		while(0 == (int)(temp*10) && current != min) {
			temp = number / Math.pow(10, --current);
			
		}
		if(0 == (int)(temp*10)) {
			System.out.println("Numero minimo de expoente insuficiente");
		}
		System.out.printf("%."+length+"f * 10^%d", temp,current);
	}

}