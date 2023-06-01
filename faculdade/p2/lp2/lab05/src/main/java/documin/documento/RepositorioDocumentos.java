package documin.documento;

import java.util.HashMap;

public class RepositorioDocumentos {
    private final HashMap<String, Documento> documentos;

    public RepositorioDocumentos() {
        this.documentos = new HashMap<>();
    }

    public void addDocumento(String titulo, Documento documento) {
        documentos.put(titulo, documento);
    }
    public void removeDocumento(String titulo){
        documentos.remove(titulo);
    }
    public boolean temDocumento(String titulo){
        return documentos.containsKey(titulo);
    }
    public Documento getDocumento(String titulo){
        return documentos.get(titulo);
    }

    public void moveElementoAcima(String tituloDoc, int elementoPosicao) {
        Documento doc = getDocumento(tituloDoc);
        doc.moveElementoAcima(elementoPosicao);
    }
    public void moveElementoAbaixo(String tituloDoc, int elementoPosicao) {
        Documento doc = getDocumento(tituloDoc);
        doc.moveElementoAbaixo(elementoPosicao);
    }

    public String gerarRepresentacaoCompleta(Documento documento, int elementoPosicao) {
        return documento.gerarRepresentacaoCompleta(elementoPosicao);
    }
    public String gerarRepresentacaoResumida(Documento documento, int elementoPosicao) {
        return documento.gerarRepresentacaoResumida(elementoPosicao);
    }
}
