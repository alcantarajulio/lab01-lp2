package documin.documento.elementos;

import java.util.*;

public class Termo extends Elemento {
    private final String separador;
    private final String ordem;
    private int qtdTermos;
    private String[] termos;

    /**
     * Cria um novo elemento de termo.
     *
     * @param valorTermos o valor dos termos
     * @param prioridade  a prioridade do elemento
     * @param separador   o separador utilizado para dividir os termos
     * @param ordem       a ordem dos termos (ALFABÉTICA, TAMANHO ou NENHUM)
     */
    public Termo(String valorTermos, int prioridade, String separador, String ordem) {
        this.valor = valorTermos;
        this.prioridade = prioridade;
        this.separador = separador;
        this.ordem = ordem;
        this.termos = valor.split(separador);
    }

    /**
     * Ordena os termos com base na ordem especificada.
     */
    private void sorteador() {
        switch (ordem) {
            case "ALFABÉTICA" -> Arrays.sort(termos, String::compareToIgnoreCase);
            case "TAMANHO" -> Arrays.sort(termos, Comparator.comparingInt(String::length).reversed());
            case "NENHUM" -> {
            }
            default -> throw new IllegalStateException("Ordem inexistente!" + ordem);
        }
    }

    /**
     * Monta a representação completa dos termos.
     *
     * @return a representação completa dos termos
     */
    private String montaRepresentacao() {
        StringBuilder resultado = new StringBuilder();
        sorteador();
        for (String termo : termos) {
            resultado.append(termo.trim()).append(",");
        }
        String representacaoCompleta = resultado.toString();
        return representacaoCompleta.substring(0, resultado.length() - 1);
    }

    /**
     * Obtém a quantidade de termos.
     *
     * @return a quantidade de termos
     */
    private int getQtdTermos() {
        this.qtdTermos = termos.length;
        return this.qtdTermos;
    }

    /**
     * Obtém a prioridade do elemento.
     *
     * @return a prioridade do elemento
     */
    @Override
    public int getPrioridade() {
        return this.prioridade;
    }

    /**
     * Gera a representação completa dos termos.
     *
     * @return a representação completa dos termos
     */
    @Override
    public String gerarRepresentacaoCompleta() {
        return "Total termos: " + getQtdTermos() + "\n-" + montaRepresentacao();
    }

    /**
     * Gera a representação resumida dos termos.
     *
     * @return a representação resumida dos termos
     */
    @Override
    public String gerarRepresentacaoResumida() {
        sorteador();
        StringBuilder resultado = new StringBuilder();
        for (String termo : termos) {
            resultado.append(termo.trim()).append(separador);
        }
        String representacaoCompleta = resultado.toString();
        return representacaoCompleta.substring(0, resultado.length() - 1);
    }
}