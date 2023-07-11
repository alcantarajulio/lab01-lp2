package documin.documento.visoes;

import documin.documento.Documento;
import documin.documento.elementos.Elemento;

import java.util.ArrayList;

/**
 * A classe Prioritaria é uma subclasse de Visao que representa uma visão prioritária de um documento,
 * exibindo apenas os elementos com prioridade igual ou superior a uma determinada prioridade.
 */

public class Prioritaria extends Visao {
    private final int prioridade;

    /**
     * Construtor da classe Prioritaria.
     *
     * @param doc        O documento associado à visão prioritária.
     * @param prioridade A prioridade mínima dos elementos a serem exibidos.
     */
    public Prioritaria(Documento doc, int prioridade) {
        super(doc);
        this.prioridade = prioridade;
    }

    /**
     * Gera a representação prioritária do documento, exibindo apenas os elementos com prioridade igual ou superior
     * à prioridade especificada.
     *
     * @return Um array de strings contendo a representação dos elementos prioritários do documento.
     */
    @Override
    public String[] gerarRepresentacao() {
        ArrayList<String> visoes = new ArrayList<>();
        for (int i = 0; i < doc.getQtdElementos(); i++) {
            Elemento elemento = doc.getElemento(i);
            if (elemento.getPrioridade() >= prioridade) {
                visoes.add(doc.gerarRepresentacaoCompleta(i));
            }
        }
        return visoes.toArray(new String[0]);
    }
}
