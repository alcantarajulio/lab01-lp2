package lab2;

/**
 * Classe que representa um registro de resumos de estudos.
 * Armazena os resumos por tema e limita a quantidade máxima de resumos armazenados.
 *
 * @author Júlio César da Silva Alcantara - 122110504
 */
public class RegistroResumos {
    /**
     * Quantidade de Resumos a serem registrados.
     */
    private int quantidadeDeResumos;
    /**
     * Array contendo o título dos resumos.
     */
    private String[] temas;
    /**
     *  Array contendo o conteúdo dos resumos.
     */
    private String[] conteudos;
    /**
     * indíce a ser acessado para conectar os títulos com os respectivos conteúdos.
     */
    private int index;

    /**
     * Construtor da classe RegistroResumos.
     * Inicializa um novo registro de resumos com a quantidade máxima de resumos especificada.
     *
     * @param numeroDeResumos Quantidade máxima de resumos a serem armazenados no registro.
     */
    public RegistroResumos(int numeroDeResumos) {
        this.quantidadeDeResumos = numeroDeResumos;
        this.conteudos = new String[quantidadeDeResumos];
        this.temas = new String[quantidadeDeResumos];
        this.index = 0;
    }

    /**
     * Adiciona um novo resumo ao registro.
     * Caso a quantidade máxima de resumos já tenha sido alcançada, o primeiro resumo adicionado é substituído.
     *
     * @param tema   O tema do resumo.
     * @param resumo O texto do resumo.
     */
    public void adiciona(String tema, String resumo) {
        if (index >= quantidadeDeResumos) {
            index = 0;
        }
        temas[index] = tema;
        conteudos[index] = resumo;
        index += 1;
    }

    /**
     * Retorna um array de Strings com todos os resumos cadastrados no registro.
     *
     * @return um array de Strings com todos os resumos cadastrados no registro.
     */
    public String[] pegaResumos() {
        String[] resumosCadastrados = new String[conta()];
        for (int i = 0; i < conta(); i++) {
            resumosCadastrados[i] = temas[i] + ": " + conteudos[i];
        }
        return resumosCadastrados;
    }

    /**
     * Retorna a quantidade de resumos cadastrados no registro.
     *
     * @return a quantidade de resumos cadastrados no registro.
     */
    public int conta() {
        int numeroDeResumos = 0;
        for (String titulo : temas) {
            if (titulo != null) {
                numeroDeResumos += 1;
            }
        }
        return numeroDeResumos;
    }

    /**
     * Retorna uma String contendo a quantidade e os títulos dos resumos cadastrados no registro.
     *
     * @return uma String contendo a quantidade e os títulos dos resumos cadastrados no registro.
     */
    public String imprimeResumos() {
        String quantidadeDeCadastrados = "- " + conta() + " resumo(s) cadastrado(s)\n";
        String titulosCadastrados = "- ";
        for (int i = 0; i < temas.length; i++) {
            if (temas[i] != null) {
                titulosCadastrados += temas[i];
                if (temas[i + 1] != null) {
                    titulosCadastrados += " | ";
                }
            } else {
                break;
            }
        }
        return quantidadeDeCadastrados + titulosCadastrados;
    }
    /**
     * Verifica se um resumo com o tema especificado já foi adicionado ao registro.
     *
     * @param tema O tema do resumo a ser verificado.
     * @return true se um resumo com o tema especificado já foi adicionado, false caso contrário.
     */
    public boolean temResumo(String tema) {
        for (String resumo : temas) {
            if (resumo.equals(tema)) {
                return true;
            } else {
                break;
            }
        }
        return false;
    }
}
