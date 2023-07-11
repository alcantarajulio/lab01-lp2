
package documin.documento.repositorios;

import documin.documento.Documento;
import documin.documento.visoes.*;

import java.util.ArrayList;

/**
 * Este repositório gerencia as visões de documentos.
 */
public class RepositorioVisoes {

    private final ArrayList<VisaoInterface> visoes;

    /**
     * Cria uma instância de RepositorioVisoes.
     */
    public RepositorioVisoes() {
        this.visoes = new ArrayList<>();
    }

    /**
     * Gera uma visão completa com base no documento fornecido.
     *
     * @param doc o documento para o qual gerar a visão completa
     * @return o identificador da visão gerada
     */
    public int gerarVisaoCompleta(Documento doc) {
        VisaoInterface visao = new Completa(doc);
        visoes.add(visao);
        return visoes.size() - 1;
    }

    /**
     * Gera uma visão prioritária com base no documento fornecido e na prioridade especificada.
     *
     * @param doc o documento para o qual gerar a visão prioritária
     * @param prioridade a prioridade da visão prioritária
     * @return o identificador da visão gerada
     */
    public int gerarVisaoPrioritaria(Documento doc, int prioridade) {
        VisaoInterface visao = new Prioritaria(doc, prioridade);
        visoes.add(visao);
        return visoes.size() - 1;
    }

    /**
     * Gera uma visão resumida com base no documento fornecido.
     *
     * @param doc o documento para o qual gerar a visão resumida
     * @return o identificador da visão gerada
     */
    public int gerarVisaoResumida(Documento doc) {
        VisaoInterface visao = new Resumida(doc);
        visoes.add(visao);
        return visoes.size() - 1;
    }

    /**
     * Gera uma visão de títulos com base no documento fornecido.
     *
     * @param doc o documento para o qual gerar a visão de títulos
     * @return o identificador da visão gerada
     */
    public int gerarVisaoTitulos(Documento doc) {
        VisaoInterface visao = new Titulos(doc);
        visoes.add(visao);
        return visoes.size() - 1;
    }

    /**
     * Exibe a visão correspondente ao identificador fornecido.
     *
     * @param visaoID o identificador da visão a ser exibida
     * @return um array de strings contendo a representação da visão exibida
     */
    public String[] exibirVisao(int visaoID) {
        VisaoInterface visao = visoes.get(visaoID);
        return visao.gerarRepresentacao();
    }

}
