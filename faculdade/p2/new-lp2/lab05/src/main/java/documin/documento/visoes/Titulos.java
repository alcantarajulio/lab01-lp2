package documin.documento.visoes;
import documin.documento.Documento;
import documin.documento.elementos.Elemento;
import documin.documento.elementos.Titulo;

import java.util.ArrayList;
/**
 * A classe Titulos é uma subclasse de Visao que representa uma visão dos títulos de um documento,
 * exibindo apenas os elementos do tipo Titulo.
 */

public class Titulos extends Visao {
    /**
     * Construtor da classe Titulos.
     *
     * @param doc O documento associado à visão dos títulos.
     */
    public Titulos(Documento doc) {
        super(doc);
    }

    /**
     * Gera a representação dos títulos do documento, exibindo apenas os elementos do tipo Titulo.
     *
     * @return Um array de strings contendo a representação resumida de cada título do documento.
     */
    @Override
    public String[] gerarRepresentacao() {
        ArrayList<String> visoes = new ArrayList<>();
        for (int i = 0; i < doc.getQtdElementos(); i++) {
            Elemento elemento = doc.getElemento(i);
            if (elemento instanceof Titulo) {
                visoes.add(doc.gerarRepresentacaoResumida(i));
            }
        }
        return visoes.toArray(new String[0]);
    }
}