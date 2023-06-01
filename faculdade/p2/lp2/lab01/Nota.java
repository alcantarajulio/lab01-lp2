import java.util.Scanner;
import java.util.ArrayList;

/* 
 * Laboratório de Programação II - P2
 *
 * @author Júlio César da Silva Alcantara - 122110504
 *
 */

public class Nota {
	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	
	int maior = 0;
	int menor = 1000;
	int media = 0 ;
	int acima = 0;
	int abaixo = 0;
	int soma = 0;
	int lidos = 0;

	String[] a = sc.nextLine().split(" ");
	
	while (true) {		
		if (a[0].equals("-")) {
			break;
		}

		int notaAtual = Integer.parseInt(a[1]);
		
		soma += notaAtual;
		if (notaAtual >= 700) {
			acima += 1;
		}else if (notaAtual < 700) {
			abaixo += 1;
		}if (notaAtual > maior) {
			maior = notaAtual;
		}if (notaAtual < menor) {
			menor = notaAtual;
		}
		lidos += 1;
		
		a = sc.nextLine().split(" ");
	}

	media = soma / lidos;
		
	System.out.println("maior: " + maior);
	System.out.println("menor: " + menor);
	System.out.println("media: " + media);
	System.out.println("acima: " + acima);	
	System.out.println("abaixo: " + abaixo);


	}
}
