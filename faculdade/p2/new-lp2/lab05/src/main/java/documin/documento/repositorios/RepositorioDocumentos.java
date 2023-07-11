
package documin.documento.repositorios;

import documin.documento.Documento;

import java.util.HashMap;

public class RepositorioDocumentos {
    private final HashMap<String, Documento> documentos;

    /**
     * Cria um novo repositório de documentos.
     */
    public RepositorioDocumentos() {
        this.documentos = new HashMap<>();
    }

    /**
     * Adiciona um documento ao repositório.
     *
     * @param titulo o título do documento
     * @param documento o documento a ser adicionado
     */
    public void addDocumento(String titulo, Documento documento) {
        documentos.put(titulo, documento);
    }

    /**
     * Remove um documento do repositório.
     *
     * @param titulo o título do documento a ser removido
     * @return true se o documento foi removido com sucesso, false caso contrário
     */
    public boolean removeDocumento(String titulo) {
        documentos.remove(titulo);
        return true;
    }

    /**
     * Verifica se o repositório contém um documento com o título especificado.
     *
     * @param titulo o título do documento
     * @return true se o documento existir no repositório, false caso contrário
     */
    public boolean temDocumento(String titulo) {
        return documentos.containsKey(titulo);
    }

    /**
     * Obtém um documento do repositório com o título especificado.
     *
     * @param titulo o título do documento
     * @return o documento correspondente ao título especificado, ou null se não for encontrado
     */
    public Documento getDocumento(String titulo) {
        return documentos.get(titulo);
    }

    /**
     * Mostra o conteúdo do documento especificado.
     *
     * @param titulo o título do documento a ser exibido
     * @return um array de strings representando o conteúdo do documento
     */
    public String[] mostrarDocumento(String titulo) {
        Documento doc = documentos.get(titulo);
        return doc.mostrarDocumento();
    }

    /**
     * Move um elemento do documento para cima em relação à sua posição atual.
     *
     * @param tituloDoc o título do documento
     * @param elementoPosicao a posição do elemento a ser movido
     */
    public void moveElementoAcima(String tituloDoc, int elementoPosicao) {
        Documento doc = getDocumento(tituloDoc);
        doc.moveElementoAcima(elementoPosicao);
    }

    /**
     * Move um elemento do documento para baixo em relação à sua posição atual.
     *
     * @param tituloDoc o título do documento
     * @param elementoPosicao a posição do elemento a ser movido
     */
    public void moveElementoAbaixo(String tituloDoc, int elementoPosicao) {
        Documento doc = getDocumento(tituloDoc);
        doc.moveElementoAbaixo(elementoPosicao);
    }

    /**
     * Gera a representação completa de um elemento do documento.
     *
     * @param documento o documento
     * @param elementoPosicao a posição do elemento
     * @return a representação completa do elemento
     */
    public String gerarRepresentacaoCompleta(Documento documento, int elementoPosicao) {
        return documento.gerarRepresentacaoCompleta(elementoPosicao);
    }

    /**
     * Gera a representação resumida de um elemento do documento.
     *
     * @param documento o documento
     * @param elementoPosicao a posição do elemento
     * @return a representação resumida do elemento
     */
    public String gerarRepresentacaoResumida(Documento documento, int elementoPosicao) {
        return documento.gerarRepresentacaoResumida(elementoPosicao);
    }
}