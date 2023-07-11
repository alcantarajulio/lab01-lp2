package documin.documento.elementos;

import documin.documento.repositorios.RepositorioElementos;

public class AtalhoDocumento extends Elemento {

    private RepositorioElementos repositorioElementos;

    /**
     * Cria um novo atalho para um documento.
     *
     * @param mediaPrioridades a média das prioridades dos elementos do documento
     * @param id               o identificador do atalho
     * @param repoElementos    o repositório de elementos do documento
     */
    public AtalhoDocumento(int mediaPrioridades, String id, RepositorioElementos repoElementos) {
        this.prioridade = mediaPrioridades;
        this.valor = id;
        this.repositorioElementos = repoElementos;
    }

    /**
     * Gera a representação completa do atalho, exibindo apenas elementos com prioridade igual ou maior que 4.
     *
     * @return a representação completa do atalho
     */
    @Override
    public String gerarRepresentacaoCompleta() {
        StringBuilder retorno = new StringBuilder();
        for (int i = 0; i < repositorioElementos.getQtdElementos(); i++) {
            Elemento elemento = repositorioElementos.getElemento(i);
            if (elemento.getPrioridade() >= 4) {
                retorno.append(elemento.gerarRepresentacaoCompleta()).append("\n");
            }
        }
        return retorno.toString();
    }

    /**
     * Gera a representação resumida do atalho, exibindo apenas elementos com prioridade igual a 4 ou 5.
     *
     * @return a representação resumida do atalho
     */
    @Override
    public String gerarRepresentacaoResumida() {
        StringBuilder retorno = new StringBuilder();
        for (int i = 0; i < repositorioElementos.getQtdElementos(); i++) {
            Elemento elemento = repositorioElementos.getElemento(i);
            if (elemento.getPrioridade() >= 4) {
                retorno.append(elemento.gerarRepresentacaoResumida()).append("\n");
            }
        }
        return retorno.toString();
    }
}