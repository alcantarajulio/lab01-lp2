import java.util.Scanner;

/*
 * Laboratório de Programação 2 - Lab 1
 * 
 * @author Júlio César da Silva Alcantara - 122110504 
 */

public class DobroTriplo {
	public static void main(String[] args) {
	
	int y;
	int z;
	Scanner sc = new Scanner(System.in);
	int x = sc.nextInt();

	y = x * 2;
	z = x * 3;
	
	System.out.println("dobro: " + y + ", triplo: " + z);
	}
}

