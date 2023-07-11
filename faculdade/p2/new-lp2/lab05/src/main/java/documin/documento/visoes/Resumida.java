package documin.documento.visoes;

import documin.documento.Documento;

import java.util.ArrayList;
/**
 * A classe Resumida é uma subclasse de Visao que representa uma visão resumida de um documento,
 * exibindo uma representação resumida de cada elemento.
 */

public class Resumida extends Visao {
    /**
     * Construtor da classe Resumida.
     *
     * @param doc O documento associado à visão resumida.
     */
    public Resumida(Documento doc) {
        super(doc);
    }

    /**
     * Gera a representação resumida do documento, exibindo uma representação resumida de cada elemento.
     *
     * @return Um array de strings contendo a representação resumida de cada elemento do documento.
     */
    @Override
    public String[] gerarRepresentacao() {
        ArrayList<String> visoes = new ArrayList<>();
        for (int i = 0; i < doc.getQtdElementos(); i++) {
            visoes.add(doc.gerarRepresentacaoResumida(i));
        }
        return visoes.toArray(new String[0]);
    }
}
