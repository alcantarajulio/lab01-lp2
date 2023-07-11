package documin;

import documin.documento.controller.DocuminController;

public class Facade {
    DocuminController documinController;
    public Facade(){
        this.documinController = new DocuminController();
    }

    // Métodos relacionados a Documento.
    public boolean criarDocumento(String titulo){
        return documinController.criarDocumento(titulo);
    }
    public boolean criarDocumento(String titulo, int tamanho){
        return documinController.criarDocumento(titulo, tamanho);
    }
    public int contarElementos(String titulo){
        return documinController.contarElementos(titulo);
    }
    public void removerDocumento(String titulo){
        documinController.removerDocumento(titulo);
    }
    public String[] exibirDocumento(String titulo){
        return documinController.mostrarDocumento(titulo);
    }

    // Métodos relacionados a um Elemento.
    public int criarTexto(String tituloDoc, String valor, int prioridade){
        return documinController.criarTexto(tituloDoc, valor, prioridade);
    }
    public int criarTitulo(String tituloDoc, String valor, int prioridade, int nivel, boolean linkavel){
        return documinController.criarTitulo(tituloDoc, valor, prioridade, nivel, linkavel);
    }
    public int criarLista(String tituloDoc, String valorLista, int prioridade, String separador, String charLista){
        return documinController.criarLista(tituloDoc, valorLista, prioridade, separador, charLista);
    }
    public int criarTermos(String tituloDoc, String valorTermos, int prioridade, String separador, String ordem){
        return documinController.criarTermos(tituloDoc, valorTermos, prioridade, separador,ordem);
    }
    public void moverParaCima(String tituloDoc, int elementoPosicao){
        documinController.moverParaCima(tituloDoc, elementoPosicao);
    }
    public void moverParaBaixo(String tituloDoc, int elementoPosicao){
        documinController.moverParaBaixo(tituloDoc, elementoPosicao);
    }
    public String pegarRepresentacaoCompleta(String tituloDoc, int elementoPosicao){
        return documinController.pegarRepresentacaoCompleta(tituloDoc, elementoPosicao);}
    public String pegarRepresentacaoResumida(String tituloDoc, int elementoPosicao){
        return documinController.pegarRepresentacaoResumida(tituloDoc, elementoPosicao);}
    public boolean apagarElemento(String tituloDoc, int elementoPosicao){
        return documinController.apagarElemento(tituloDoc, elementoPosicao);
    }
    public int criarAtalho(String tituloDoc, String tituloDocReferenciado){
        return documinController.criarAtalho(tituloDoc, tituloDocReferenciado);
    }
    // Métodos relacionados a Visão
    public int criarVisaoCompleta(String tituloDoc){
        return documinController.criarVisaoCompleta(tituloDoc);
    }
    public int criarVisaoResumida(String tituloDoc){
         return documinController.criarVisaoResumida(tituloDoc);
    }
    public int criarVisaoPrioritaria(String tituloDoc, int prioridade){
        return documinController.criarVisaoPrioritaria(tituloDoc, prioridade);
    }
    public int criarVisaoTitulo(String tituloDoc){
       return documinController.criarVisaoTitulo(tituloDoc);
    }
    public String[] exibirVisao(int visaoId){
        return documinController.exibirVisao(visaoId);
    }
}
