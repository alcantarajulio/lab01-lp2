package lab2;

/**
 * Implementação do CoISA Bônus com melhorias de algumas classes e criação de outras novas.
 *
 * @author Júlio César da Silva Alcantara - 122110504
 */
public class CoisaBonus {
    public static void main(String[] args){
        controlarDisciplina();
        System.out.println("-----");
        registrarDescanso();
        System.out.println("-----");

    }
    private static void controlarDisciplina() {
        int[] pesos = {6,4};
        Disciplina prog2 = new Disciplina("PROGRAMAÇÃO 2", 2, pesos);
        prog2.cadastraHoras(4);
        prog2.cadastraNota(1, 8.0);
        prog2.cadastraNota(2, 7.0);
        System.out.println(prog2.calculaMedia());
        System.out.println(prog2);
    }
    private static void registrarDescanso() {
        Descanso descanso = new Descanso();
        System.out.println(descanso.getStatusGeral());
        descanso.defineHorasDescanso(30);
        descanso.defineNumeroSemanas(1);
        descanso.atribuirEmoticon("*_*");
        System.out.println(descanso.getStatusGeral());
        descanso.defineHorasDescanso(26);
        descanso.defineNumeroSemanas(2);
    }

}
