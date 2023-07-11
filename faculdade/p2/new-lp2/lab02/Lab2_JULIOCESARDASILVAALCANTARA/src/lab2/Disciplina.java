
package lab2;

import java.util.Arrays;

/**
 * Representa uma disciplina do curso de computação, que contém informações como o nome da disciplina,
 * as notas dos alunos e o total de horas acumuladas.
 *
 * @author Júlio César da Silva Alcantara - 122110504
 *
 */
public class Disciplina {
    /**
     * Nome da disciplina na qual as notas serão atribuídas.
     */
    private String nomeDisciplina;
    /**
     * Array contendo as notas.
     */
    private double[] notas;
    /**
     * Array que contém os pesos a serem atribuídos as notas.
     */
    private int[] pesos;
    /**
     *  Total de horas acumuladas na disciplina.
     */
    private int horasEstudadas;
    /**
     * Cria uma nova instância da classe Disciplina com o nome da disciplina especificado.
     * @param nomeDisciplina o nome da disciplina.
     */
    public Disciplina(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
        this.notas = new double[4];
        this.horasEstudadas = 0;
    }

    /**
     * Cria uma nova instância da classe Disciplina que recebe a quantidade de notas que a disciplina tem.
     * CoISA - Implementações Bônus.
     *
     * @param nota
     */
    public Disciplina(String nomeDisciplina, int nota) {
        this.nomeDisciplina = nomeDisciplina;
        this.notas = new double[nota];
        this.horasEstudadas = 0;
    }

    /**
     * Construtor que atribui pesos de acordo com a nota.
     * CoISA - Implementações Bônus.
     * @param nomeDisciplina
     * @param nota
     * @param pesoNotas
     */
    public Disciplina(String nomeDisciplina, int nota, int[] pesoNotas) {
        this.nomeDisciplina = nomeDisciplina;
        this.notas = new double[nota];
        this.pesos = pesoNotas;
    }

    /**
     * Registra as horas acumuladas na disciplina.
     * @param horas as horas a serem adicionadas.
     */
    public void cadastraHoras(int horas) {
        horasEstudadas += horas;
    }
    /**
     * Registra uma nota para o aluno na disciplina.
     * @param nota o número da nota a ser registrada.
     * @param valorNota o valor da nota a ser registrada.
     */
    public void cadastraNota(int nota, double valorNota) {
        notas[nota - 1] = valorNota;
    }

    /**
     * Calcula a soma das notas do aluno na disciplina.
     * @return a soma das notas.
     */
    private double somarNotas() {
        double somaNotas = 0.0;
        for (double nota : notas) {
            somaNotas += nota;
        }
        return somaNotas;
    }

    /**
     * Calcula a média da nota com pesos caso exista, e a média aritmética caso contrário.
     *
     * @return a média entre as notas de acordo com o peso, ou sem o peso.
     */
    public double calculaMedia(){
        if (pesos != null){
            double somaNotas = 0.0;
            int somaPesos = 0;

            for (int i = 0; i < notas.length; i++) {
                somaNotas += notas[i] * pesos[i];
                somaPesos += pesos[i];
            }
            return somaNotas / somaPesos;
        }else{
            return somarNotas() / notas.length;
        }
    }

    /**
     * Calcula se o aluno foi aprovado na disciplina ou não.
     * @return true se o aluno foi aprovado, false caso contrário.
     */
    public boolean aprovado() {
        return (somarNotas() / notas.length) >= 7.0;
    }

    /**
     * Retorna uma representação em string da disciplina.
     * @return uma string que representa a disciplina.
     */
    @Override
    public String toString() {
        return nomeDisciplina + " " + horasEstudadas + " " + calculaMedia() + " " + Arrays.toString(notas);
    }
}


