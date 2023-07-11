package documin.documento.services;

import documin.documento.Documento;
import documin.documento.repositorios.RepositorioVisoes;

/**
 * Esta classe fornece serviços para manipulação de visões de documentos.
 */
public class VisaoService {

    private final RepositorioVisoes repoVisoes;

    /**
     * Cria uma instância de VisaoService.
     */
    public VisaoService() {
        this.repoVisoes = new RepositorioVisoes();
    }

    /**
     * Cria uma visão completa com base no documento fornecido.
     *
     * @param doc o documento para o qual criar a visão completa
     * @return o identificador da visão criada
     */
    public int criarVisaoCompleta(Documento doc) {
        return repoVisoes.gerarVisaoCompleta(doc);
    }

    /**
     * Cria uma visão prioritária com base no documento fornecido e na prioridade especificada.
     *
     * @param doc o documento para o qual criar a visão prioritária
     * @param prioridade a prioridade da visão prioritária
     * @return o identificador da visão criada
     */
    public int criarVisaoPrioritaria(Documento doc, int prioridade) {
        return repoVisoes.gerarVisaoPrioritaria(doc, prioridade);
    }

    /**
     * Cria uma visão resumida com base no documento fornecido.
     *
     * @param doc o documento para o qual criar a visão resumida
     * @return o identificador da visão criada
     */
    public int criarVisaoResumida(Documento doc) {
        return repoVisoes.gerarVisaoResumida(doc);
    }

    /**
     * Cria uma visão de títulos com base no documento fornecido.
     *
     * @param doc o documento para o qual criar a visão de títulos
     * @return o identificador da visão criada
     */
    public int criarVisaoTitulos(Documento doc) {
        return repoVisoes.gerarVisaoTitulos(doc);
    }

    /**
     * Exibe a visão correspondente ao identificador fornecido.
     *
     * @param visaoId o identificador da visão a ser exibida
     * @return um array de strings contendo a visão exibida
     */
    public String[] exibirVisao(int visaoId) {
        return repoVisoes.exibirVisao(visaoId);
    }
}
