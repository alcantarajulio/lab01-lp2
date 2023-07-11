package documin.documento.elementos;

import java.util.HashMap;

public abstract class Elemento {
    protected HashMap<String, String> propriedades;
    protected int prioridade;
    protected String valor;

    /**
     * Cria um novo elemento.
     */
    public Elemento() {
        this.propriedades = new HashMap<>();
        this.prioridade = 0;
        this.valor = "";
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
     * Obtém o valor do elemento.
     *
     * @return o valor do elemento
     */
    public String getValor() {
        return this.valor;
    }

    /**
     * Gera a representação completa do elemento.
     *
     * @return a representação completa do elemento
     */
    public abstract String gerarRepresentacaoCompleta();

    /**
     * Gera a representação resumida do elemento.
     *
     * @return a representação resumida do elemento
     */
    public abstract String gerarRepresentacaoResumida();
}
