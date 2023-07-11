package documin.documento.controller;

import documin.documento.Documento;
import documin.documento.services.DocumentoService;
import documin.documento.services.VisaoService;

/**
 * Controlador principal do sistema que vai delegar as funções.
 */
public class DocuminController {

    private final DocumentoService documentoService;
    private final VisaoService visaoService;

    /**
     * COnstrutor da classe DocuminController.
     * Instancia os services de documento e visão.
     */
    public DocuminController() {
        this.documentoService = new DocumentoService();
        this.visaoService = new VisaoService();
    }

    /**
     * Criar documento que não tem tamanho máximo.
     *
     * @param titulo Título do documento.
     * @return true quando é criado, e false quando não é criado.
     */
    public boolean criarDocumento(String titulo) {
        return documentoService.criarDocumento(titulo);
    }

    /**
     * Criar documento que tem tamanho máximo.
     *
     * @param titulo Título do documento.
     * @param tamanho Tamanho do documento.
     * @return true quando é criado, e false quando não é criado.
     */
    public boolean criarDocumento(String titulo, int tamanho) {
        return documentoService.criarDocumento(titulo, tamanho);
    }

    /**
     * Contar elementos em um documento.
     *
     * @param titulo Título do documento.
     * @return Quantidade de elementos no documento.
     */
    public int contarElementos(String titulo) {
        return documentoService.contarElementos(titulo);
    }

    /**
     * Remover documento.
     *
     * @param titulo Título do documento.
     */
    public void removerDocumento(String titulo) {
        documentoService.removerDocumento(titulo);
    }

    /**
     * Mostrar um array com os elementos existentes no documento.
     *
     * @param titulo Título do documento.
     * @return String[] com os elementos presentes no documento.
     */
    public String[] mostrarDocumento(String titulo) {
        return documentoService.mostrarDocumento(titulo);
    }


    /**
     *
     * Cria um elemento do tipo texto em um documento.
     * @param tituloDoc  Título do documento.
     * @param valor      Valor do elemento.
     * @param prioridade Prioridade desse elemento.
     * @return posição que o elemento foi cadastrado.
     */
    public int criarTexto(String tituloDoc, String valor, int prioridade) {
        return documentoService.criarTexto(tituloDoc, valor, prioridade);
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
        return documentoService.criarTitulo(tituloDoc, valor, prioridade, nivel, linkavel);
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
        return documentoService.criarLista(tituloDoc, valorLista, prioridade, separador, charLista);
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
     */
    public int criarTermos(String tituloDoc, String valorTermos, int prioridade, String separador, String ordem) {
        return documentoService.criarTermos(tituloDoc, valorTermos, prioridade, separador, ordem);
    }

    /**
     * Mover elemento para cima em um documento.
     *
     * @param tituloDoc       Título do documento.
     * @param elementoPosicao Posição do elemento que vai "subir".
     */
    public void moverParaCima(String tituloDoc, int elementoPosicao) {
        documentoService.moverElementoParaCima(tituloDoc, elementoPosicao);
    }

    /**
     * Mover elemento para baixo em um documento.
     *
     * @param tituloDoc       Título do documento.
     * @param elementoPosicao Posição do elemento que vai "descer".
     */
    public void moverParaBaixo(String tituloDoc, int elementoPosicao) {
        documentoService.moverElementoParaBaixo(tituloDoc, elementoPosicao);
    }

    /**
     * Pegar representacao completa do elemento na posição.
     *
     * @param tituloDoc       Título do documento.
     * @param elementoPosicao Posição do elemento.
     * @return A representação completa do elemento.
     */
    public String pegarRepresentacaoCompleta(String tituloDoc, int elementoPosicao) {
        return documentoService.gerarRepresentacaoCompleta(tituloDoc, elementoPosicao);
    }

    /**
     * Pegar a representação resumida do elemento na posição.
     *
     * @param tituloDoc       Título do documento
     * @param elementoPosicao Posição do elemento.
     * @return A representação resumida do elemento.
     */
    public String pegarRepresentacaoResumida(String tituloDoc, int elementoPosicao) {
        return documentoService.gerarRepresentacaoResumida(tituloDoc, elementoPosicao);
    }

    /**
     * Apaga o elemento na posição.
     *
     * @param tituloDoc       Título do documento
     * @param elementoPosicao Posição do elemento.
     * @return true se for removido com sucesso, e false caso contrário
     */
    public boolean apagarElemento(String tituloDoc, int elementoPosicao) {
        return documentoService.removerElemento(tituloDoc, elementoPosicao);
    }

    /**
     * Cria um elemento do tipo atalho que faz referência a um documento.
     *
     * @param tituloDoc             Título do documento.
     * @param tituloDocReferenciado Título do documento referenciado.
     * @return posição que o elemento foi cadastrado.
     */
    public int criarAtalho(String tituloDoc, String tituloDocReferenciado) {
        return documentoService.criarAtalho(tituloDoc, tituloDocReferenciado);
    }

    /**
     * Cria visão completa de um documento.
     *
     * @param tituloDoc Título do documento.
     * @return posição da visão.
     */
    public int criarVisaoCompleta(String tituloDoc) {
        Documento doc = documentoService.getDocumento(tituloDoc);
        return visaoService.criarVisaoCompleta(doc);
    }

    /**
     * Cria visão resumida de um documento.
     *
     * @param tituloDoc Título do documento.
     * @return posição da visão.
     */
    public int criarVisaoResumida(String tituloDoc) {
        Documento doc = documentoService.getDocumento(tituloDoc);
        return visaoService.criarVisaoResumida(doc);
    }

    /**
     * Cria visão prioritaria de um documento.
     *
     * @param tituloDoc Título do documento.
     * @return posição da visão.
     */

    public int criarVisaoPrioritaria(String tituloDoc, int prioridade) {
        Documento doc = documentoService.getDocumento(tituloDoc);
        return visaoService.criarVisaoPrioritaria(doc, prioridade);
    }

    /**
     * Cria visão prioritaria de um documento.
     *
     * @param tituloDoc Título do documento.
     * @return posição da visão.
     */
    public int criarVisaoTitulo(String tituloDoc) {
        Documento doc = documentoService.getDocumento(tituloDoc);
        return visaoService.criarVisaoTitulos(doc);
    }

    /**
     * Exibe a visão no índice .
     *
     * @param visaoId Identificador da visão.
     * @return Array com os elementos que compõe uma visão
     */
    public String[] exibirVisao(int visaoId) {
        return visaoService.exibirVisao(visaoId);
    }
}
