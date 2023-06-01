import java.util.Scanner;
/*
 * Laboratório de Programação II - P2
 *
 * @author Júlio César da Silva Alcantara - 122110504
 * 
 */

public class Wally {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	do {		
		String atual = "";
		String[] nomes = sc.nextLine().split(" ");
		
		for (int i = 0; i < nome.length; i++){	
			for (String nome : nomes){ 
				
				if (nome.length() == 5) {
					atual = nome;
				}
				else { 
					atual = "?";
					break;
					}	
			System.out.println(atual);
			}
		}
	}while(!atual.equals("wally"));
		
	
	}
}
