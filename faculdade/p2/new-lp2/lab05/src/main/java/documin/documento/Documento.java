package documin.documento;

import documin.documento.elementos.Elemento;
import documin.documento.repositorios.RepositorioElementos;

import java.util.Objects;

/**
 * Classe que representa um documento com elementos.
 */
public class Documento {
    private final String titulo;
    private final RepositorioElementos repoElementos;
    private boolean linkavel;

    /**
     * Constrói um novo documento com o título e tamanho especificados.
     *
     * @param titulo  O título do documento
     * @param tamanho O tamanho máximo do repositório de elementos
     */
    public Documento(String titulo, int tamanho) {
        this.titulo = titulo;
        this.repoElementos = new RepositorioElementos(tamanho);
        this.linkavel = true;
    }

    /**
     * Constrói um novo documento com o título especificado.
     *
     * @param titulo O título do documento
     */
    public Documento(String titulo) {
        this.titulo = titulo;
        this.repoElementos = new RepositorioElementos();
        this.linkavel = true;
    }

    /**
     * Adiciona um elemento de texto ao documento.
     *
     * @param valor     O valor do texto
     * @param prioridade A prioridade do elemento
     * @return O ID do elemento adicionado
     */
    public int addTexto(String valor, int prioridade) {
        atingiuMaximo();
        return repoElementos.addTexto(valor, prioridade);
    }

    /**
     * Adiciona um elemento de título ao documento.
     *
     * @param valor     O valor do título
     * @param prioridade A prioridade do elemento
     * @param nivel     O nível do título
     * @param linkavel  Indica se o título é linkável
     * @return O ID do elemento adicionado
     */
    public int addTitulo(String valor, int prioridade, int nivel, boolean linkavel) {
        atingiuMaximo();
        return repoElementos.addTitulo(valor, prioridade, nivel, linkavel);
    }

    /**
     * Adiciona um elemento de lista ao documento.
     *
     * @param valorLista   O valor da lista
     * @param prioridade   A prioridade do elemento
     * @param separador    O separador dos itens da lista
     * @param charLista    O caractere de marcação da lista
     * @return O ID do elemento adicionado
     */
    public int addLista(String valorLista, int prioridade, String separador, String charLista) {
        atingiuMaximo();
        return repoElementos.addLista(valorLista, prioridade, separador, charLista);
    }

    /**
     * Adiciona um elemento de termos ao documento.
     *
     * @param valorTermos O valor dos termos
     * @param prioridade  A prioridade do elemento
     * @param separador   O separador dos termos
     * @param ordem       A ordem de classificação dos termos
     * @return O ID do elemento adicionado
     */
    public int addTermos(String valorTermos, int prioridade, String separador, String ordem) {
        atingiuMaximo();
        return repoElementos.addTermo(valorTermos, prioridade, separador, ordem);
    }

    /**
     * Adiciona um elemento de atalho ao documento.
     *
     * @param mediaPrioridade      A média da prioridade dos elementos referenciados pelo atalho
     * @param valor                O valor do atalho
     * @param repositorioElementos O repositório de elementos referenciados pelo atalho
     * @return O ID do elemento adicionado
     */
    public int addAtalho(int mediaPrioridade, String valor, RepositorioElementos repositorioElementos) {
        atingiuMaximo();
        return repoElementos.addAtalho(mediaPrioridade, valor, repositorioElementos);
    }

    /**
     * Obtém o título do documento.
     *
     * @return O título do documento
     */
    public String getTitulo() {
        return this.titulo;
    }

    /**
     * Obtém o elemento com o ID especificado.
     *
     * @param iD O ID do elemento
     * @return O elemento com o ID especificado
     */
    public Elemento getElemento(int iD) {
        return repoElementos.getElemento(iD);
    }

    /**
     * Obtém a média da prioridade dos elementos do documento.
     *
     * @return A média da prioridade dos elementos
     */
    public int getMediaPrioridade() {
        return repoElementos.getMediaPrioridade();
    }

    /**
     * Obtém a quantidade de elementos do documento.
     *
     * @return A quantidade de elementos
     */
    public int getQtdElementos() {
        return repoElementos.getQtdElementos();
    }

    /**
     * Move um elemento para cima na ordem do documento.
     *
     * @param elementoPosicao A posição do elemento
     */
    public void moveElementoAcima(int elementoPosicao) {
        repoElementos.mudaPosicaoElementosAcima(elementoPosicao);
    }

    /**
     * Move um elemento para baixo na ordem do documento.
     *
     * @param elementoPosicao A posição do elemento
     */
    public void moveElementoAbaixo(int elementoPosicao) {
        repoElementos.mudaPosicaoElementosAbaixo(elementoPosicao);
    }

    /**
     * Gera a representação completa de um elemento do documento.
     *
     * @param elementoPosicao A posição do elemento
     * @return A representação completa do elemento
     */
    public String gerarRepresentacaoCompleta(int elementoPosicao) {
        return repoElementos.getRepresentacaoCompleta(elementoPosicao);
    }

    /**
     * Gera a representação resumida de um elemento do documento.
     *
     * @param elementoPosicao A posição do elemento
     * @return A representação resumida do elemento
     */
    public String gerarRepresentacaoResumida(int elementoPosicao) {
        return repoElementos.getRepresentacaoResumida(elementoPosicao);
    }

    private void atingiuMaximo() {
        if (repoElementos.getQtdElementos() >= repoElementos.getQtdMaxElementos() && repoElementos.temMaximo()) {
            throw new IndexOutOfBoundsException("Tamanho Máximo de Elementos foi atingido!");
        }
    }

    /**
     * Obtém o repositório de elementos do documento.
     *
     * @return O repositório de elementos
     */
    public RepositorioElementos getRepoElementos() {
        return this.repoElementos;
    }

    /**
     * Verifica se o documento possui um elemento na posição especificada.
     *
     * @param posicao A posição do elemento
     * @return `true` se o documento possui o elemento, caso contrário `false`
     */
    public boolean temElemento(int posicao) {
        return repoElementos.temElemento(posicao);
    }

    /**
     * Remove o elemento na posição especificada.
     *
     * @param elementoPosicao A posição do elemento
     */
    public void removeElemento(int elementoPosicao) {
        repoElementos.removeElemento(elementoPosicao);
    }

    /**
     * Retorna uma representação do documento como um array de strings.
     *
     * @return Uma representação do documento como um array de strings
     */
    public String[] mostrarDocumento() {
        return null;
    }

    /**
     * Verifica se o documento é linkável.
     *
     * @return `true` se o documento é linkável, caso contrário `false`
     */
    public boolean isLinkavel() {
        return this.linkavel;
    }

    /**
     * Define se o documento é linkável ou não.
     *
     * @param linkavel Indica se o documento é linkável
     */
    public void setLinkavel(boolean linkavel) {
        this.linkavel = linkavel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Documento documento = (Documento) o;
        return Objects.equals(titulo, documento.titulo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titulo);
    }
}
