package lista_1;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		File entradas = new File("entradas_q4.txt");
		try {
			Scanner input = new Scanner(entradas);
			while (input.hasNext()) {

				String numberString = input.next();
				System.out.println("\n###############################################################\n");
				if (numberString.matches("\\([01]+\\)2")) {
					numberString = cleanBinaryString(numberString);
					System.out.printf("binario inteiro %s \n", numberString);
					System.out.println("em decimal inteiro: " + binaryToDecimal(numberString));

				} else if (numberString.matches("\\([01]+,[01]+\\)2")) {
					numberString = cleanBinaryString(numberString);
					System.out.printf("binario flutuante: %s \n", numberString);
					System.out.println(
							"em decimal flutuante: " + binaryToDecimal_Float(numberString.replaceAll(",", "")));

				} else if (numberString.matches("[0-9]+,[0-9]+")) {

					System.out.printf("decimal flutuante: %s \n", numberString);
					System.out.println("em binario flutuantes: "
							+ decimalToBininary_Float(Double.valueOf(numberString.replaceAll(",", "."))));

				} else {

					System.out.printf("decimal inteiro: %s\n", numberString);
					System.out.println("em binario inteiro: " + decimalToBininary(Integer.valueOf(numberString)));

				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static String decimalToBininary(int number) {
		StringBuilder binaryString = new StringBuilder();
		int i = 0;

		while (number != 0) {
			binaryString.append((number % 2));
			number /= 2;

		}
		if (binaryString.length() > 0)
			return binaryString.reverse().toString();
		return "0";
	}

	public static String decimalToBininary_Float(double number) {
		StringBuilder binaryString = new StringBuilder();

		
		  ArrayList<Double> founded = new ArrayList<>();
		  
		  int before = (int)number; 
		  number -= before;
		  binaryString.append(decimalToBininary(before)+".");
		  
		  founded.add(number);
		while (1 !=  number) {
			
			number *= 2;
			

			binaryString.append((int) number);

			if ((int) number == 1 && number - 1 != 0) {
				number -= 1;

			}
			if(founded.contains(number))
				break;
			else
				founded.add(number);

		}
		if (binaryString.length() > 0)
			return  binaryString.toString();
		return "0";
	}

	public static int binaryToDecimal(String binaryString) {
		int number = 0;
		int i = 0;

		binaryString = (new StringBuilder(binaryString)).reverse().toString();

		Iterator<String> iteratorBinaryString = Arrays.stream(binaryString.split("")).iterator();

		while (iteratorBinaryString.hasNext()) {

			number += Integer.valueOf(iteratorBinaryString.next()) * Math.pow(2, i++);

		

		}
		return number;
	}

	public static double binaryToDecimal_Float(String binaryString) {
		double number = 0;
		int i = -1;

		binaryString = (new StringBuilder(binaryString)).delete(0, 1).toString();

		Iterator<String> iteratorBinaryString = Arrays.stream(binaryString.split("")).iterator();

		while (iteratorBinaryString.hasNext()) {

			number += Integer.valueOf(iteratorBinaryString.next()) * Math.pow(2, i--);

		}
		return number;
	}

	public static String cleanBinaryString(String binaryString) {
		return binaryString.replaceAll("\\(", "").replaceAll("\\)2", "");
	}

}
