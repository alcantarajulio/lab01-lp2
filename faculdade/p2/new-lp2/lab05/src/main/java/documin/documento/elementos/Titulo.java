package documin.documento.elementos;

public class Titulo extends Elemento {
    private int nivel;
    private boolean linkavel;

    public Titulo(String valor, int prioridade, int nivel, boolean linkavel) {
        this.valor = valor;
        this.prioridade = prioridade;
        this.nivel = nivel;
        this.linkavel = linkavel;
    }

    /**
     * Gera a representação do título, podendo incluir informações adicionais se for linkável e completa.
     *
     * @param completa indica se a representação deve ser completa
     * @return a representação do título
     */
    private String gerarRepresentacao(boolean completa) {
        if (linkavel && completa) {
            return this.nivel + ". " + this.valor + " -- " + this.nivel + "-" + this.valor.replaceAll("\\s+", "").toUpperCase();
        }

        return nivel + ". " + valor;
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
     * Gera a representação completa do título.
     *
     * @return a representação completa do título
     */
    @Override
    public String gerarRepresentacaoCompleta() {
        return gerarRepresentacao(true);
    }

    /**
     * Gera a representação resumida do título.
     *
     * @return a representação resumida do título
     */
    @Override
    public String gerarRepresentacaoResumida() {
        return gerarRepresentacao(false);
    }
}

