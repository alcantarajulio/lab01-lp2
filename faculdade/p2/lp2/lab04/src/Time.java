package src;

import java.util.ArrayList;

/**
 * Classe que representa um Time.
 *
 * @author Júlio César da Silva Alcantara - 122110504
 */
public class Time {
    private String identificador;
    private String nome;
    private String mascote;
    private ArrayList<Campeonato> campeonatosDeTime;
    private int qtdeCampeonatos;

    /**
     * Instancia um novo time, zerando os atributos
     */
    public Time() {
        this.identificador = "";
        this.nome = "";
        this.mascote = "";
        this.campeonatosDeTime = new ArrayList<>();
        this.qtdeCampeonatos = 0;
    }

    /**
     * Instancia um novo time com os parâmetros recebidos
     *
     * @param identificador the identificador
     * @param nome          the nome
     * @param mascote       the mascote
     */
    public Time(String identificador, String nome, String mascote) {
        this.identificador = identificador;
        this.nome = nome;
        this.mascote = mascote;
        this.campeonatosDeTime = new ArrayList<>();
        this.qtdeCampeonatos = 0;
    }

    public void setCampeonatosDeTime(Campeonato campeonato) {
        this.campeonatosDeTime.add(campeonato);
        qtdeCampeonatos++;
    }

    public String getIdentificador() {
        return identificador;
    }

    public ArrayList<Campeonato> getCampeonatosDeTime() {
        return campeonatosDeTime;
    }

    public int getQtdeCampeonatos() {
        return qtdeCampeonatos;
    }


    public String getNome(){
        return nome;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Time time = (Time) o;
        return getIdentificador().equals(time.getIdentificador());
    }
    @Override
    public int hashCode() {
        return getIdentificador().hashCode();
    }
    @Override
    public String toString() {
        return "[" + identificador + "] " + nome + " / " + mascote;
    }

}