package documin;

import documin.documento.DocuminService;
public class Facade {

    private DocuminService documinService;
    public Facade(){
        this.documinService = new DocuminService();
    }
    public boolean criarDocumento(String titulo){
        return documinService.criarDocumento(titulo);
    }
    public boolean criarDocumento(String titulo, int tamanho){
        return documinService.criarDocumento(titulo, tamanho);
    }
    public int contarElementos(String titulo){
        return documinService.contarElementos(titulo);
    }
    public void removerDocumento(String titulo){
        documinService.removerDocumento(titulo);
    }
//    public String[] mostrarDocumento(String titulo){
//        return new String[0];
//    }

    public int criarTexto(String tituloDoc, String valor, int prioridade){
        return documinService.criarTexto(tituloDoc, valor, prioridade);
    }
//    public int criarTitulo(String tituloDoc, String valor, int prioridade, int nivel, boolean linkavel){
//        return prioridade;
//    }
//    public int criarLista(String tituloDoc, String valorLista, int prioridade, String separador, String charLista){
//        return prioridade;
//    }
//    public int criarTermos(String tituloDoc, String valorTermos, int prioridade, String separador, String ordem){
//        return prioridade;
//    }
    public void moverParaCima(String tituloDoc, int elementoPosicao){
        documinService.moverElementoParaCima(tituloDoc, elementoPosicao);
    }
    public void moverParaBaixo(String tituloDoc, int elementoPosicao){
        documinService.moverElementoParaBaixo(tituloDoc, elementoPosicao);
    }
    public String pegarRepresentacaoCompleta(String tituloDoc, int elementoPosicao){ return documinService.gerarRepresentacaoCompleta(tituloDoc, elementoPosicao);}
    public String pegarRepresentacaoResumida(String tituloDoc, int elementoPosicao){return documinService.gerarRepresentacaoResumida(tituloDoc, elementoPosicao);}

    public boolean apagarElemento(String tituloDoc, int elementoPosicao){
        return documinService.removerElemento(tituloDoc, elementoPosicao);
    }
//    public int criarAtalho(String tituloDoc, String tituloDocReferenciado){}
//    public int criarVisaoCompleta(String tituloDoc)
//    public int criarVisaoResumida(String tituloDoc)
//    public int criarVisaoPrioritaria(String tituloDoc, int prioridade)
//    public int criarVisaoTitulo(String tituloDoc)
//    public String[] exibirVisao(int visaoId)
}
