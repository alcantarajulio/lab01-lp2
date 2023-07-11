package documin.documento.visoes;

import documin.documento.Documento;
/**
 * A classe abstrata Visao é uma implementação parcial da interface VisaoInterface,
 * fornecendo um campo protegido para armazenar o documento associado à visão.
 * As subclasses devem estender essa classe e implementar o método gerarRepresentacao().
 */

public abstract class Visao implements VisaoInterface {
    protected Documento doc;

    /**
     * Construtor da classe Visao.
     *
     * @param doc O documento associado à visão.
     */
    public Visao(Documento doc) {
        this.doc = doc;
    }
}
