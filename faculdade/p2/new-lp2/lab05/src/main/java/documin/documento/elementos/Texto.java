package documin.documento.elementos;

public class Texto extends Elemento {

    public Texto(String valor, int prioridade) {
        this.valor = valor;
        this.prioridade = prioridade;
    }

    /**
     * Obtém a prioridade do elemento.
     *
     * @return a prioridade do elemento
     */
    public int getPrioridade() {
        return this.prioridade;
    }

    /**
     * Gera a representação completa do texto.
     *
     * @return a representação completa do texto
     */
    @Override
    public String gerarRepresentacaoCompleta() {
        return this.getValor();
    }

    /**
     * Gera a representação resumida do texto.
     *
     * @return a representação resumida do texto
     */
    @Override
    public String gerarRepresentacaoResumida() {
        return this.getValor();
    }
}

