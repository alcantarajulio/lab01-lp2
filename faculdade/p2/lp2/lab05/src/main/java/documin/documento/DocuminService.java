package documin.documento;
import javax.swing.text.Document;
import java.util.HashMap;

public class DocuminService {

    private final RepositorioDocumentos repoDocs;


    public DocuminService() {
        this.repoDocs = new RepositorioDocumentos();
    }

    public boolean criarDocumento(String titulo) {
        if (Util.verificaDocumentoExistente(titulo, repoDocs)) {
            repoDocs.addDocumento(titulo, new Documento(titulo));
            return true;
        }
        return false;
    }

    public boolean criarDocumento(String titulo, int tamanho) {
        Util.verificaValorInvalido(tamanho);
        if (!titulo.isBlank() && Util.verificaDocumentoExistente(titulo, repoDocs)) {
            repoDocs.addDocumento(titulo, new Documento(titulo, tamanho));
            return true;
        }
        return false;
    }

    public void removerDocumento(String titulo) {
        verificaExcecoes(titulo, repoDocs);
        repoDocs.removeDocumento(titulo);
    }

    public int contarElementos(String titulo) {
        verificaExcecoes(titulo, repoDocs);
        Documento doc = repoDocs.getDocumento(titulo);
        return doc.getQtdElementos();
    }

    public int criarTexto(String tituloDoc, String valor, int prioridade) {
        verificaExcecoes(tituloDoc, repoDocs);
        Documento doc = repoDocs.getDocumento(tituloDoc);
        return doc.addTexto(valor, prioridade);
    }

//    public int criarTitulo(String tituloDoc, String valor, int prioridade, int nivel, boolean linkavel) {
//        return prioridade;
//    }
//
//    public int criarLista(String tituloDoc, String valorLista, int prioridade, String separador, String charLista) {
//        return prioridade;
//    }
//
//    public int criarTermos(String tituloDoc, String valorTermos, int prioridade, String separador, String ordem) {
//        return prioridade;

//    }
    public void moverElementoParaCima(String tituloDoc, int elementoPosicao) {
        verificaExcecoes(tituloDoc, repoDocs);
        repoDocs.moveElementoAcima(tituloDoc, elementoPosicao);
    }
    public void moverElementoParaBaixo(String tituloDoc, int elementoPosicao){
        verificaExcecoes(tituloDoc, repoDocs);
        repoDocs.moveElementoAbaixo(tituloDoc, elementoPosicao);
    }

    public String gerarRepresentacaoCompleta(String tituloDoc, int elementoPosicao){
        verificaExcecoes(tituloDoc, repoDocs);
        Documento documento = repoDocs.getDocumento(tituloDoc);
        return repoDocs.gerarRepresentacaoCompleta(documento, elementoPosicao);
    }
    public String gerarRepresentacaoResumida(String tituloDoc, int elementoPosicao){
        verificaExcecoes(tituloDoc, repoDocs);
        Documento documento = repoDocs.getDocumento(tituloDoc);
       return repoDocs.gerarRepresentacaoResumida(documento, elementoPosicao);
    }
    private void verificaExcecoes(String titulo, RepositorioDocumentos repoDocs){
        Util.documentoExistente(titulo, repoDocs);
        Util.verificaTituloInvalido(titulo);
    }

    public boolean removerElemento(String tituloDoc, int elementoPosicao) {
        Util.documentoExistente(tituloDoc, repoDocs);
        Documento documento = repoDocs.getDocumento(tituloDoc);
        if (Util.elementoExistente(documento, elementoPosicao)) {
            documento.removeElemento(elementoPosicao);
            return true;
        }
        return false;
    }
}