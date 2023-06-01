import java.util.Scanner;
/* 
 * Laboratório de Programação II
 *
 * @author Júlio César da Silva Alcantara - 122110504
 *
 */

public class Wally2 {
	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);

	String atual = "";
	String[] arrayNomes = sc.nextLine().split(" ");

	while (true) {		

		boolean temCinco = false;
		boolean printa = false;
	
		for (String nome : arrayNomes) {
			if (nome.length() == 5) {
				atual = nome;
				printa = true;
				temCinco = true;

			}else if(temCinco == false && nome.length() != 5){
				atual = "?";
				printa = true;
			}
		}
		if (atual.equals("wally")) {
			break;
		}	
		else if (printa == true){
			System.out.println(atual);
			arrayNomes = sc.nextLine().split(" ");
		}
		}
	
	}
}
