package documin.documento;

import documin.documento.elementos.ElementoAbstract;
import documin.documento.elementos.Texto;

import java.util.ArrayList;
import java.util.Collections;

public class RepositorioElementos {

    private final ArrayList<ElementoAbstract> elementos;
    private int qtdAtualElementos;
    private int qtdMaxElementos;

    public RepositorioElementos(int tamanhoMax) {
       this.elementos = new ArrayList<>(tamanhoMax);
       this.qtdAtualElementos = 0;
       this.qtdMaxElementos = tamanhoMax;
    }
    public RepositorioElementos() {
        this.elementos = new ArrayList<>();
    }
    public int getIndice(){
        return elementos.size() - 1;
    }

    public int addTexto(String valor, int prioridade){
        Texto texto = new Texto(valor, prioridade);
        this.elementos.add(texto);
        qtdAtualElementos++;
        return getIndice();
    }

    public int getQtdElementos(){
        return this.qtdAtualElementos;
    }

    public void mudaPosicaoElementosAcima(int elementoPosicao){
        //testar quando posicao é maior que o length/size
        if ((elementoPosicao != 0) || !(elementoPosicao == elementos.size())){
            Collections.swap(elementos, elementoPosicao, elementoPosicao + 1);
        }

    }
    public void mudaPosicaoElementosAbaixo(int elementoPosicao){
        if (elementoPosicao == 0 || elementoPosicao >= elementos.size()){
            return;
        }
        Collections.swap(elementos, elementoPosicao, elementoPosicao - 1);
    }

    public String getRepresentacaoCompleta(int elementoPosicao) {
        ElementoAbstract elem = elementos.get(elementoPosicao);
        return elem.gerarRepresentacaoCompleta();
    }
    public String getRepresentacaoResumida(int elementoPosicao) {
        ElementoAbstract elem = elementos.get(elementoPosicao);
        return elem.gerarRepresentacaoResumida();
    }
    public int getQtdMaxElementos() {
        return this.qtdMaxElementos;
    }

    public boolean temElemento(int posicao) {
        ElementoAbstract elemento = elementos.get(posicao);
        return elementos.contains(elemento);
    }

    public void removeElemento(int elementoPosicao) {
        elementos.remove(elementoPosicao);
    }
}
