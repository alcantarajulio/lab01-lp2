package documin.documento;

import documin.documento.elementos.ElementoAbstract;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Util {

    public static void verificaValorInvalido(int tamanho){
        if (tamanho <= 0) {
            throw new IllegalArgumentException("Tamanho Inválido!");
        }
    }

    public static boolean verificaDocumentoExistente(String tituloDoc, RepositorioDocumentos repoDocs){
        return !repoDocs.temDocumento(tituloDoc);
    }

    public static void verificaTituloInvalido(String tituloDoc) {
        if(tituloDoc.isBlank()){
            throw new IllegalArgumentException("Título Inválido!");
        }
    }
    // mudar isso pra service, e usar a classe Optional(no repo).
    // Optional<Documento> ...;
    // https://www.geeksforgeeks.org/optional-orelsethrow-method-in-java-with-examples/

    public static void documentoExistente(String tituloDoc, RepositorioDocumentos repoDocs) {
        if (!repoDocs.temDocumento(tituloDoc)) {
            throw new NoSuchElementException("O documento não existe na base de dados!");
        }
    }

    public static boolean elementoExistente(Documento documento, int posicao){
        //throw new NoSuchElementException("O elemento não existe no documento!");
        return documento.temElemento(posicao);
    }
}
