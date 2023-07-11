/*
 * Laboratório de Programação 2 - Lab 1
 *
 * @author Júlio César da Silva Alcantara - 122110504
 */

import java.util.*;

public class Calculadora{
	
	public static void main(String[] args){
		
	Scanner sc = new Scanner(System.in);

	String operacao = sc.nextLine();
	
	if(operacao.equals("/") == false && operacao.equals("*") == false && operacao.equals("+") == false && operacao.equals("-") == false){
		System.out.println("ENTRADA INVALIDA");

	}else{	
		float x = sc.nextFloat();
		float y = sc.nextFloat();
		float z;	
	
		if (operacao.equals("/")){	
		
			if (y == 0){
				System.out.println("ERRO");
			}else{
				z = x / y;
				System.out.println("RESULTADO: " + z);	
			}
		}else if(operacao.equals("*")) {
			z = x * y;
			System.out.println("RESULTADO: " + z);
	
		}else if(operacao.equals("+")) {
			z = x + y;
			System.out.println("RESULTADO: " + z);
	
		}else if(operacao.equals("-")) {
			z = x - y;
			System.out.println("RESULTADO: " + z);
		}else if(operacao.equals("%")) {
			z = x % y;
			System.out.println("RESULTADO: " + z);
		
		}
	}
}


}

