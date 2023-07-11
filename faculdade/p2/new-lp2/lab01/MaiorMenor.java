import java.util.Scanner;
/* 
 * Laboratório de Programação II 
 *
 * Júlio César da Silva Alcantara - 122110504
 */
public class MaiorMenor {
	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	String primeiroNome = sc.nextLine();	
	String segundoNome = sc.nextLine();
	if (primeiroNome.length() == segundoNome.length()){
		System.out.println(primeiroNome);
		System.out.println(primeiroNome);
	}else if(primeiroNome.length() > segundoNome.length()) {
		System.out.println(segundoNome);
		System.out.println(primeiroNome);
	}
	sc.close();
	}
}
