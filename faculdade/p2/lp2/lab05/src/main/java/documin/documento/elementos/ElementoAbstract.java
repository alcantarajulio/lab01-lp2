package documin.documento.elementos;

import java.util.ArrayList;

public abstract class ElementoAbstract {
    // Strings que representam propriedades particulares de cada elemento
    protected ArrayList<String> propriedades;
    // int entre 1-5
    protected int prioridade;
    // string com os dados desse elemento
    protected String valor;

//    public ElementoAbstract(){
//
//    }
    public ArrayList<String> getPropriedades() {
        return propriedades;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public String getValor() {
        return valor;
    }
    public abstract String gerarRepresentacaoCompleta();
    public abstract String gerarRepresentacaoResumida();
}
