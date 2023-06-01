import java.util.Scanner;
import java.util.ArrayList;

/* 
 * Laboratório de Programação II - P2
 *
 * Júlio César da Silva Alcantara - 122110504
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

	int tamanhoArray = 0;
	int[] notas = new int[tamanhoArray]
	ArrayList<Integer> notas1 = new ArrayList<Integer>();
	
	
	String[] a = sc.nextLine().split(" ");

	while (true) {		
	
		if (a[0].equals("-")) {
			break;
		}
	
		notas1.add(Integer.parseInt(a[1]));
		a = sc.nextLine().split(" ");
	}

	for (int num : notas) {
		soma += num;			
		media = soma / notas.size();
		
		if (num >= 700) {
			acima += 1; 
		}else if (num < 700) {
			abaixo += 1;
		
		}if (num > maior) {
			maior = num;
		}if (num < menor) {
			menor = num;
		
		}
		
	}
	System.out.println("maior: " + maior);
	System.out.println("menor: " + menor);
	System.out.println("media: " + media);
	System.out.println("acima: " + acima);	
	System.out.println("abaixo: " + abaixo);


}
}
