package src;
/**
 * Classe que representa um cachorro e suas características
 */

public class Dog {

    private String nome;
    private String tutor;
    private int racao;

    private boolean restrito;
    private String restricao;

    public Dog(){
        nome = "";
        tutor = "";
        racao = 0;
        restrito = false;
        restricao = "";
    }
    public Dog(String nome, String tutor, int qtdRacao){
        this.nome = nome;
        this.tutor = tutor;
        this.racao = qtdRacao;
    }
    public int getRacao(){
        return this.racao;
    }
    public void setRestricao(String restricao){
        this.restrito = true;
        this.restricao = restricao;
    }
    public void setRacao(int racao){
        this.racao = racao;

    }    public boolean temRestricao(){
        return restrito;
    }
    public String getNome(){
        return this.nome;
    }
    public String getTutor(){
        return this.tutor;
    }
    public boolean equals(String nome, String tutor){
        return nome.equals(getNome()) && tutor.equals(getTutor());
    }


}

