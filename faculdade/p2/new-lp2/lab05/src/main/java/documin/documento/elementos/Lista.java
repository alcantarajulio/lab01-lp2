package documin.documento.elementos;

public class Lista extends Elemento {
    private final String separador;
    private final String charLista;

    /**
     * Cria um novo elemento de lista.
     *
     * @param valorLista o valor da lista
     * @param prioridade a prioridade da lista
     * @param separador  o separador utilizado para dividir os itens da lista
     * @param charLista  o caractere utilizado para representar cada item da lista
     */
    public Lista(String valorLista, int prioridade, String separador, String charLista) {
        this.valor = valorLista;
        this.prioridade = prioridade;
        this.separador = separador;
        this.charLista = charLista;
    }

    /**
     * Separa os itens da lista utilizando o separador e adiciona o caractere da lista.
     *
     * @return a representação completa da lista
     */
    private String separaChar() {
        String[] lista = valor.split(separador);
        StringBuilder resultado = new StringBuilder();
        for (String palavra : lista) {
            resultado.append(charLista);
            resultado.append(palavra.trim()).append("\n");
        }
        String representacaoCompleta = resultado.toString();
        return representacaoCompleta.substring(0, resultado.length() - 1);
    }

    @Override
    public int getPrioridade() {
        return this.prioridade;
    }

    @Override
    public String gerarRepresentacaoCompleta() {
        return separaChar();
    }

    @Override
    public String gerarRepresentacaoResumida() {
        return this.valor;
    }
}