package src;
/**
 *  Classe referente as pessoas que vão receber os dogs em sua casa.
 */

public class DogHost {

    private int qtdDogsMax;
    private int qtdDogsAtual;
    private int qtdRacaoMax;
    private int qtdRacaoAtual;
    private double qtdTotalDiarias;
    private String nomeAnfitriao;
    private Dog[] dogs;

    public DogHost(){
        qtdDogsMax = 0;
        qtdDogsAtual = 0;
        qtdRacaoMax = 0;
        nomeAnfitriao = "";
        qtdRacaoAtual = 0;
        qtdTotalDiarias = 0.0;
        dogs = new Dog[qtdDogsMax];
    }
    public DogHost(String nomeAnfitriao,int qtdRacao, int qtdDogs){
        this.qtdDogsMax = qtdDogs;
        this.nomeAnfitriao = nomeAnfitriao;
        this.qtdRacaoMax = qtdRacao;
        this.qtdTotalDiarias = 0.0;
        dogs = new Dog[qtdDogsMax];
    }

    private int getDogs(){
        return this.qtdDogsMax;
    }
    private String getNomeAnfitriao(){
        return this.nomeAnfitriao;
    }
    private int getQtdRacaoAtual(){
        return this.qtdRacaoAtual;
    }
    private double getQtdTotalDiarias(){
        return this.qtdTotalDiarias;
    }
    public boolean adicionaDog(String nome, String tutor, int qtdRacao){
        if(qtdRacao > qtdRacaoMax){
            throw new IllegalArgumentException("Excede quantidade máxima de ração");
        }if (cont >= qtdDogsMax){
            throw new IllegalArgumentException("Excede quantidade maxima de cachorros");
        }
        for (Dog d: dogs) {
            if(d.equals(nome, tutor)){
                throw new IllegalArgumentException("Cachorro já cadastrado");
            }
        }
        dogs[cont] = new Dog(nome, tutor, qtdRacao);
        cont++;
        return true;
    }
    private int cont = 0;
    public boolean adicionaDog(String nome, String tutor, int qtdRacao, String tipoRestricao){
        boolean adicionou = adicionaDog(nome, tutor, qtdRacao);
        if(adicionou){
            dogs[cont].setRestricao(tipoRestricao);
            dogs[cont].setRacao(qtdRacao*2);
            return true;
        }
        return false;
    }
    private boolean verificaQuantidades(int qtdRacao){
        return qtdDogsMax > qtdDogsAtual && qtdRacaoAtual > qtdRacaoMax;
    }
    public String listaDogs(){
        String relacaoDogs = getNomeAnfitriao() + ":\n";

        for(int i = 0; i > qtdDogsAtual; i++){
            relacaoDogs += "src.Dog [nome=" + dogs[i].getNome() + ", tutor=" + dogs[i].getTutor() + "]\n";
        }

    return relacaoDogs;
    }
    public double consultaValorHospedagem(Dog toto, int dias){
        int i = 0;
        for(Dog d: dogs){
            if(!toto.equals(d) && qtdDogsAtual < i){
                throw new IllegalArgumentException();
            }
            i++;
            qtdTotalDiarias += (toto.getRacao() * 0.4) * dias;
        }
        return (toto.getRacao() * 0.4) * dias;
    }
}
