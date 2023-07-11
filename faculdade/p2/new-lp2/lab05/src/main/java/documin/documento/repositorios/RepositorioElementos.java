package documin.documento.repositorios;

import documin.documento.elementos.*;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Este repositório gerencia os elementos de um documento.
 */
public class RepositorioElementos {

    private final ArrayList<Elemento> elementos;
    private int qtdAtualElementos;
    private int qtdMaxElementos;
    private int mediaPrioridade;
    private boolean temMaximo;

    /**
     * Cria uma instância de RepositorioElementos com um tamanho máximo especificado.
     *
     * @param tamanhoMax o tamanho máximo de elementos permitidos no repositório
     */
    public RepositorioElementos(int tamanhoMax) {
        this.elementos = new ArrayList<>(tamanhoMax);
        this.qtdAtualElementos = 0;
        this.qtdMaxElementos = tamanhoMax;
        this.temMaximo = true;
    }

    /**
     * Cria uma instância de RepositorioElementos sem limite máximo de tamanho.
     */
    public RepositorioElementos() {
        this.elementos = new ArrayList<>();
        this.temMaximo = false;
    }

    /**
     * Obtém o índice do último elemento adicionado.
     *
     * @return o índice do último elemento adicionado
     */
    public int getIndice() {
        return elementos.size() - 1;
    }

    /**
     * Adiciona um elemento de texto ao repositório.
     *
     * @param valor o valor do texto
     * @param prioridade a prioridade do texto
     * @return o índice do elemento adicionado
     */
    public int addTexto(String valor, int prioridade) {
        Elemento texto = new Texto(valor, prioridade);
        this.elementos.add(texto);
        qtdAtualElementos++;
        return getIndice();
    }

    /**
     * Adiciona um elemento de título ao repositório.
     *
     * @param valor o valor do título
     * @param prioridade a prioridade do título
     * @param nivel o nível do título
     * @param linkavel indica se o título é linkável
     * @return o índice do elemento adicionado
     */
    public int addTitulo(String valor, int prioridade, int nivel, boolean linkavel) {
        Elemento titulo = new Titulo(valor, prioridade, nivel, linkavel);
        this.elementos.add(titulo);
        qtdAtualElementos++;
        return getIndice();
    }

    /**
     * Adiciona um elemento de lista ao repositório.
     *
     * @param valorLista o valor da lista
     * @param prioridade a prioridade da lista
     * @param separador o separador da lista
     * @param charLista o caractere da lista
     * @return o índice do elemento adicionado
     */
    public int addLista(String valorLista, int prioridade, String separador, String charLista) {
        Elemento lista = new Lista(valorLista, prioridade, separador, charLista);
        this.elementos.add(lista);
        qtdAtualElementos++;
        return getIndice();
    }

    /**
     * Adiciona um elemento de termo ao repositório.
     *
     * @param valorTermos o valor do termo
     * @param prioridade a prioridade do termo
     * @param separador o separador do termo
     * @param ordem a ordem do termo
     * @return o índice do elemento adicionado
     */
    public int addTermo(String valorTermos, int prioridade, String separador, String ordem) {
        Elemento termo = new Termo(valorTermos, prioridade, separador, ordem);
        this.elementos.add(termo);
        qtdAtualElementos++;
        return getIndice();
    }

    /**
     * Adiciona um elemento de atalho a outro documento ao repositório.
     *
     * @param mediaPrioridade a média de prioridade do atalho
     * @param valor o valor do atalho
     * @param repositorioElementos o repositório de elementos do documento de destino
     * @return o índice do elemento adicionado
     */
    public int addAtalho(int mediaPrioridade, String valor, RepositorioElementos repositorioElementos) {
        Elemento atalhoDoc = new AtalhoDocumento(mediaPrioridade, valor, repositorioElementos);
        this.elementos.add(atalhoDoc);
        qtdAtualElementos++;
        return getIndice();
    }

    /**
     * Obtém a quantidade de elementos no repositório.
     *
     * @return a quantidade de elementos no repositório
     */
    public int getQtdElementos() {
        return this.qtdAtualElementos;
    }

    /**
     * Move um elemento para cima em relação à sua posição atual.
     *
     * @param elementoPosicao a posição do elemento a ser movido
     */
    public void mudaPosicaoElementosAcima(int elementoPosicao) {
        if (elementoPosicao < elementos.size() - 1) {
            Collections.swap(elementos, elementoPosicao, elementoPosicao + 1);
        }
    }

    /**
     * Move um elemento para baixo em relação à sua posição atual.
     *
     * @param elementoPosicao a posição do elemento a ser movido
     */
    public void mudaPosicaoElementosAbaixo(int elementoPosicao) {
        if (0 < elementoPosicao && elementoPosicao <= elementos.size()) {
            Collections.swap(elementos, elementoPosicao, elementoPosicao - 1);
        }
    }

    /**
     * Obtém a representação completa de um elemento no repositório.
     *
     * @param elementoPosicao a posição do elemento
     * @return a representação completa do elemento
     */
    public String getRepresentacaoCompleta(int elementoPosicao) {
        Elemento elem = elementos.get(elementoPosicao);
        return elem.gerarRepresentacaoCompleta();
    }

    /**
     * Obtém o elemento na posição especificada.
     *
     * @param i a posição do elemento
     * @return o elemento na posição especificada
     */
    public Elemento getElemento(int i) {
        return elementos.get(i);
    }

    /**
     * Obtém a representação resumida de um elemento no repositório.
     *
     * @param elementoPosicao a posição do elemento
     * @return a representação resumida do elemento
     */
    public String getRepresentacaoResumida(int elementoPosicao) {
        Elemento elem = elementos.get(elementoPosicao);
        return elem.gerarRepresentacaoResumida();
    }

    /**
     * Obtém a quantidade máxima de elementos permitidos no repositório.
     *
     * @return a quantidade máxima de elementos permitidos
     */
    public int getQtdMaxElementos() {
        return this.qtdMaxElementos;
    }

    /**
     * Obtém a quantidade atual de elementos no repositório.
     *
     * @return a quantidade atual de elementos
     */
    public int getQtdAtualElementos() {
        return this.qtdAtualElementos;
    }

    /**
     * Calcula a média de prioridade dos elementos no repositório.
     *
     * @return a média de prioridade dos elementos
     */
    public int getMediaPrioridade() {
        calculaMedia();
        return this.mediaPrioridade;
    }

    /**
     * Verifica se um elemento existe na posição especificada.
     *
     * @param posicao a posição do elemento
     * @return true se o elemento existir, false caso contrário
     */
    public boolean temElemento(int posicao) {
        Elemento elemento = elementos.get(posicao);
        return elementos.contains(elemento);
    }

    /**
     * Calcula a média de prioridade dos elementos.
     */
    private void calculaMedia() {
        int somaPrioridade = 0;
        for (Elemento elemento : elementos) {
            somaPrioridade += elemento.getPrioridade();
        }
        mediaPrioridade = somaPrioridade / getQtdElementos();
    }

    /**
     * Remove um elemento do repositório.
     *
     * @param elementoPosicao a posição do elemento a ser removido
     */
    public void removeElemento(int elementoPosicao) {
        elementos.remove(elementoPosicao);
    }

    /**
     * Verifica se há um limite máximo de elementos no repositório.
     *
     * @return true se houver um limite máximo, false caso contrário
     */
    public boolean temMaximo() {
        return this.temMaximo;
    }
}
