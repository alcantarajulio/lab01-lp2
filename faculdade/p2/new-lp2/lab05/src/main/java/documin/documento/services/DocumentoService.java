package documin.documento.services;
import documin.documento.Documento;
import documin.documento.repositorios.RepositorioDocumentos;
import documin.documento.repositorios.RepositorioElementos;

import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * Classe responsável por a lógica principal e gerenciamento do documento e elementos.
 */
public class DocumentoService {

    private final RepositorioDocumentos repoDocs;

    /**
     * Instancia um novo DocumentoService com um repositório de documentos.
     */
    public DocumentoService() {
        this.repoDocs = new RepositorioDocumentos();
    }

    public Documento getDocumento(String tituloDoc){
        verificaDocumentoExistente(tituloDoc);
        verificaTituloInvalido(tituloDoc);
        return repoDocs.getDocumento(tituloDoc);
    }

    /**
     * Criar documento que não tem tamanho máximo.
     *
     * @param titulo Título do documento.
     * @return true quando é criado, e false quando não é criado.
     * @throws IllegalArgumentException se o documento tiver um título inválido
     * @throws NoSuchElementException   se o documento já existir.
     */
    public boolean criarDocumento(String titulo) {
        verificaTituloInvalido(titulo);
        if (!repoDocs.temDocumento(titulo)) {
            repoDocs.addDocumento(titulo, new Documento(titulo));
            return true;
        }
        return false;
    }


    /**
     * Criar documento que tem tamanho máximo.
     *
     * @param titulo Título do documento.
     * @param tamanho Tamanho do documento.
     * @return true quando é criado, e false quando não é criado.
     *
     * @throws IllegalArgumentException se o documento tiver um título inválido.
     * @throws IllegalArgumentException se o tamanho for inválido(menor ou igual a zero).
     */
    public boolean criarDocumento(String titulo, int tamanho) {
        verificaTituloInvalido(titulo);
        verificaValorInvalido(tamanho);
        if (!repoDocs.temDocumento(titulo)){
            repoDocs.addDocumento(titulo, new Documento(titulo, tamanho));
            return true;
        }
        return false;
    }

    /**
     * Remover documento.
     *
     * @param titulo Título do documento.
     *
     * @throws IllegalArgumentException se o documento tiver um título inválido.
     * @throws NoSuchElementException se o documento não estiver no sistema.
     */
    public void removerDocumento(String titulo) {
        verificaTituloInvalido(titulo);
        verificaDocumentoExistente(titulo);
        repoDocs.removeDocumento(titulo);
    }
    /**
     * Contar elementos em um documento.
     *
     * @param titulo Título do documento.
     * @return Quantidade de elementos no documento.
     * @throws IllegalArgumentException se o documento tiver um título inválido.
     * @throws NoSuchElementException se o documento não estiver no sistema.
     */
    public int contarElementos(String titulo) {
        verificaDocumentoExistente(titulo);
        verificaTituloInvalido(titulo);
        Documento doc = repoDocs.getDocumento(titulo);
        return doc.getQtdElementos();
    }

    /**
     * Mostrar um array com os elementos existentes no documento.
     *
     * @param titulo Título do documento.
     * @return String[] com os elementos presentes no documento.
     * @throws IllegalArgumentException se o documento tiver um título inválido.
     * @throws NoSuchElementException se o documento não estiver no sistema.
     */
    public String[] mostrarDocumento(String titulo) {
        verificaTituloInvalido(titulo);
        verificaDocumentoExistente(titulo);
        Documento doc = repoDocs.getDocumento(titulo);
        ArrayList<String> visoes = new ArrayList<>();
        int i = 0;
        while (i < doc.getQtdElementos()) {
            visoes.add(doc.gerarRepresentacaoResumida(i));
            i++;
        }
        return visoes.toArray(new String[visoes.size()]);
    }

    /**
     *
     * Cria um elemento do tipo texto em um documento.
     * @param tituloDoc  Título do documento.
     * @param valor      Valor do elemento.
     * @param prioridade Prioridade desse elemento.
     * @return posição que o elemento foi cadastrado.
     * @throws IllegalArgumentException se o documento tiver um título inválido.
     * @throws NoSuchElementException se o documento não estiver no sistema.
     * @throws IllegalArgumentException se o tamanho for inválido(menor ou igual a zero).
     */

    public int criarTexto(String tituloDoc, String valor, int prioridade) {
        verificaTituloInvalido(tituloDoc);
        verificaDocumentoExistente(tituloDoc);
        verificaValorInvalido(prioridade);
        Documento doc = repoDocs.getDocumento(tituloDoc);
        return doc.addTexto(valor, prioridade);
    }
    /**
     * Cria um elemento do tipo título em um documento.
     *
     * @param tituloDoc  Título do documento.
     * @param valor      Valor do elemento
     * @param prioridade Prioridade desse elemento.
     * @param nivel      Nível do título.
     * @param linkavel   Indica se é possível que seja linkado ou não.
     * @return           posição que o elemento foi cadastrado.

     */
    public int criarTitulo(String tituloDoc, String valor, int prioridade, int nivel, boolean linkavel) {
        verificaTituloInvalido(tituloDoc);
        verificaDocumentoExistente(tituloDoc);
        verificaValorInvalido(prioridade);
        Documento doc = repoDocs.getDocumento(tituloDoc);
        return doc.addTitulo(valor, prioridade, nivel, linkavel);
    }


    /**
     * Cria um elemento do tipo Lista em um documento.
     *
     * @param tituloDoc  Título do documento.
     * @param valorLista Valor do elemento.
     * @param prioridade Prioridade desse elemento.
     * @param separador  Caractere que vai ser separado na lista
     * @param charLista  Caractere que vai separar a lista
     * @return           posição que o elemento foi cadastrado.
     */
    public int criarLista(String tituloDoc, String valorLista, int prioridade, String separador, String charLista) {
        verificaValorInvalido(prioridade);
        verificaTituloInvalido(tituloDoc);
        verificaDocumentoExistente(tituloDoc);
        Documento doc = repoDocs.getDocumento(tituloDoc);
        return doc.addLista(valorLista, prioridade, separador, charLista);
    }
    /**
     * Cria um elemento do tipo Termo em um documento.
     *
     * @param tituloDoc   Título do documento.
     * @param valorTermos Valor do elemento.
     * @param prioridade  Prioridade desse elemento.
     * @param separador   Caractere que vai ser separado na lista.
     * @param ordem       Ordenação dos termos: ALFABÉTICA, TAMANHO e NENHUM.
     * @return            posição que o elemento foi cadastrado.
     **/
    public int criarTermos(String tituloDoc, String valorTermos, int prioridade, String separador, String ordem) {
        verificaValorInvalido(prioridade);
        verificaTituloInvalido(tituloDoc);
        verificaDocumentoExistente(tituloDoc);
        Documento doc = repoDocs.getDocumento(tituloDoc);
        return doc.addTermos(valorTermos, prioridade, separador, ordem);
    }


    /**
     * Cria um elemento do tipo atalho que se refere a um documento.
     *
     * @param tituloDoc             Título do documento.
     * @param tituloDocReferenciado Título do documento referenciado.
     * @return posição que o elemento foi cadastrado.
     */
    public int criarAtalho(String tituloDoc, String tituloDocReferenciado) {
        verificaTituloInvalido(tituloDoc);
        verificaTituloInvalido(tituloDoc);
        verificaDocumentoExistente(tituloDoc);
        verificaDocumentoExistente(tituloDocReferenciado);
        Documento doc = repoDocs.getDocumento(tituloDoc);
        if (!doc.isLinkavel()){
            throw new IllegalStateException("Não é possível adicionar um atalho a esse documento!");
        }
        Documento atalhoDoc = repoDocs.getDocumento(tituloDocReferenciado);
        atalhoDoc.setLinkavel(false);
        doc.setLinkavel(false);
        String valor = atalhoDoc.getTitulo();
        int prioridade = atalhoDoc.getMediaPrioridade();
        RepositorioElementos repoElementos = atalhoDoc.getRepoElementos();
        return doc.addAtalho(prioridade, valor, repoElementos);
    }

    /**
     * Mover elemento para cima em um documento.
     *
     * @param tituloDoc       Título do documento.
     * @param elementoPosicao Posição do elemento que vai "subir".
     **/
    public void moverElementoParaCima(String tituloDoc, int elementoPosicao) {
        verificaTituloInvalido(tituloDoc);
        verificaDocumentoExistente(tituloDoc);
        verificaElementoExistente(tituloDoc, elementoPosicao);

        repoDocs.moveElementoAcima(tituloDoc, elementoPosicao);
    }

    /**
     * Mover elemento para baixo em um documento.
     *
     * @param tituloDoc       Título do documento.
     * @param elementoPosicao Posição do elemento que vai "descer".
     */
    public void moverElementoParaBaixo(String tituloDoc, int elementoPosicao){
        verificaTituloInvalido(tituloDoc);
        verificaDocumentoExistente(tituloDoc);
        verificaElementoExistente(tituloDoc, elementoPosicao);

        repoDocs.moveElementoAbaixo(tituloDoc, elementoPosicao);
    }

    /**
     * Pegar representacao completa do elemento na posição.
     *
     * @param tituloDoc       Título do documento.
     * @param elementoPosicao Posição do elemento.
     * @return A representação completa do elemento.
     */
    public String gerarRepresentacaoCompleta(String tituloDoc, int elementoPosicao){
        verificaTituloInvalido(tituloDoc);
        verificaDocumentoExistente(tituloDoc);
        verificaElementoExistente(tituloDoc, elementoPosicao);

        Documento documento = repoDocs.getDocumento(tituloDoc);
        return repoDocs.gerarRepresentacaoCompleta(documento, elementoPosicao);
    }
    /**
     * Pegar a representação resumida do elemento na posição.
     *
     * @param tituloDoc       Título do documento
     * @param elementoPosicao Posição do elemento.
     * @return A representação resumida do elemento.
     **/
    public String gerarRepresentacaoResumida(String tituloDoc, int elementoPosicao){
        verificaTituloInvalido(tituloDoc);
        verificaDocumentoExistente(tituloDoc);
        verificaElementoExistente(tituloDoc, elementoPosicao);

        Documento documento = repoDocs.getDocumento(tituloDoc);
        return repoDocs.gerarRepresentacaoResumida(documento, elementoPosicao);
    }
    /**
     * Remove um elemento de um documento.
     *
     * @param tituloDoc o título do documento do qual remover o elemento
     * @param elementoPosicao a posição do elemento a ser removido
     * @return true se o elemento for removido com sucesso, false caso contrário
     * @throws IndexOutOfBoundsException se a posição do elemento estiver fora dos limites válidos
     * @throws NoSuchElementException se o documento não existir ou o elemento não for encontrado
     * @throws IllegalArgumentException se o título do documento for inválido
     */
    public boolean removerElemento(String tituloDoc, int elementoPosicao) {
        try {
            verificaTituloInvalido(tituloDoc);
            verificaDocumentoExistente(tituloDoc);
            verificaElementoExistente(tituloDoc, elementoPosicao);
        } catch (IndexOutOfBoundsException | NoSuchElementException | IllegalArgumentException exception) {
            return false;
        }
        Documento documento = repoDocs.getDocumento(tituloDoc);
        documento.removeElemento(elementoPosicao);
        return true;
    }

    /**
     * Verifica se um valor é válido.
     *
     * @param tamanho o valor a ser verificado
     * @throws IllegalArgumentException se o tamanho for menor ou igual a zero
     */
    public void verificaValorInvalido(int tamanho) {
        if (tamanho <= 0) {
            throw new IllegalArgumentException("Tamanho Inválido!");
        }
    }

    /**
     * Verifica se um título de documento é válido.
     *
     * @param titulo o título a ser verificado
     * @throws NullPointerException se o título for nulo
     * @throws IllegalArgumentException se o título for vazio
     */
    public void verificaTituloInvalido(String titulo) {
        if (titulo == null) {
            throw new NullPointerException("Título Inválido!");
        } else if (titulo.isBlank()) {
            throw new IllegalArgumentException("Título Inválido!");
        }
    }

    /**
     * Verifica se um documento existe na base de dados.
     *
     * @param titulo o título do documento a ser verificado
     * @throws NoSuchElementException se o documento não existir na base de dados
     */
    private void verificaDocumentoExistente(String titulo) {
        if (!repoDocs.temDocumento(titulo)) {
            throw new NoSuchElementException("O documento não existe na base de dados!");
        }
    }

    /**
     * Verifica se um elemento existe em um documento.
     *
     * @param tituloDoc o título do documento no qual verificar a existência do elemento
     * @param posicao a posição do elemento a ser verificado
     * @throws NoSuchElementException se o elemento não existir no documento
     */
    private void verificaElementoExistente(String tituloDoc, int posicao) {
        Documento documento = repoDocs.getDocumento(tituloDoc);
        if (!documento.temElemento(posicao)) {
            throw new NoSuchElementException("O elemento não existe no documento!");
        }
    }
}

