package src;

/**
 * Classe representando a Aposta.
 *
 * @author Júlio César da Silva Alcantara - 12211054
 */
public class Aposta{

    private Time time;
    private int colocacao;
    private Campeonato campeonato;
    private double valorAposta;

    /**
     * Instancia uma nova aposta com os parâmetros recebidos
     *
     * @param time        Time
     * @param campeonato  Campeonato
     * @param colocacao   Colocação
     * @param valorAposta Valor da aposta
     */
    public Aposta(Time time, Campeonato campeonato, int colocacao, double valorAposta) {
        this.time = time;
        this.campeonato = campeonato;
        this.colocacao = colocacao;
        this.valorAposta = valorAposta;
    }

    @Override
    public String toString() {
        return time.toString() + "\n" + campeonato.getNomeCampeonato() + "\n" + campeonato.getQtdeAtualTimesCampeonato() + "/" + campeonato.getQtdeMaxTimesCampeonato() + "\nR$ " + valorAposta;
    }
}