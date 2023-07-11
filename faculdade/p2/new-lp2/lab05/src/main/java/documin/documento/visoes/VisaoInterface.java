package documin.documento.visoes;

/**
 * A interface VisaoInterface define o contrato para uma visão de um documento.
 * As classes que implementam essa interface devem fornecer a implementação do método gerarRepresentacao(),
 * que retorna a representação da visão do documento.
 */

public interface VisaoInterface {
    /**
     * Gera a representação da visão do documento.
     *
     * @return Um array de strings contendo a representação da visão do documento.
     */
    String[] gerarRepresentacao();
}
