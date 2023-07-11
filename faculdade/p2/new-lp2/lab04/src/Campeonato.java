package src;
import java.util.HashSet;

/**
 * Classe que representa um campeonato.
 */
public class Campeonato {
    private String nomeCampeonato;
    private HashSet<Time> timesCampeonato;
    private int qtdeMaxTimesCampeonato;
    private int qtdeAtualTimesCampeonato;

    /**
     * Instancia uma nova aposta, zerando os atributos
     */
    public Campeonato(){
        this.timesCampeonato = new HashSet<>();
        this.nomeCampeonato = "";
        this.qtdeMaxTimesCampeonato = 0;
        this.qtdeAtualTimesCampeonato = 0;
    }

    /**
     * Instancia uma nova aposta com os parâmetros recebidos
     *
     * @param nomeCampeonato Nome do campeonato
     * @param qtdeTimes      Quantidade máxima de times
     */
    public Campeonato(String nomeCampeonato, int qtdeTimes) {
        this.timesCampeonato = new HashSet<>();
        this.nomeCampeonato = nomeCampeonato;
        this.qtdeMaxTimesCampeonato = qtdeTimes;
    }

    /**
     * Adiciona time ao campeonato.
     *
     * @param time Time
     * @return Booleano indicando se foi adicionado ou não
     */
    public boolean adicionaTime(Time time) {
        boolean adicionado;
        if(getQtdeAtualTimesCampeonato() >= getQtdeMaxTimesCampeonato()){
            adicionado = false;
            throw new IllegalStateException("TODOS OS TIMES DESSE CAMPEONATO JÁ FORAM INCLUÍDOS!");
        }
        timesCampeonato.add(time);
        qtdeAtualTimesCampeonato++;
        adicionado = true;
        return adicionado;
    }

    /**
     * Verifica se o time participa do campeonato
     *
     * @param time o time
     * @return booleano com sucesso(true) ou insucesso(falso)
     */
    public boolean verificaTimeCampeonato(Time time){
        return timesCampeonato.contains(time);
    }

    /**
     * Nome do campeonato
     *
     * @return string com o nome do campeonato
     */
    public String getNomeCampeonato(){
        return this.nomeCampeonato;
    }

    /**
     * Quantidade máxima de times em um campeonato
     *
     * @return inteiro com a quantidade máxima de times
     */
    public int getQtdeMaxTimesCampeonato(){
        return this.qtdeMaxTimesCampeonato;
    }

    /**
     * Quantidade atual de times em um campeonato
     *
     * @return inteiro com a quantidade atual de times
     */
    public int getQtdeAtualTimesCampeonato(){
        return this.qtdeAtualTimesCampeonato;
    }

    @Override
    public int hashCode(){
        return getNomeCampeonato().hashCode();
    }

    @Override
    public String toString(){
        return "\n* " + getNomeCampeonato() + " - " + getQtdeAtualTimesCampeonato()+"/"+getQtdeMaxTimesCampeonato();
    }



}
