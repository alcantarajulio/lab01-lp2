package documin.documento;
import java.util.Objects;

public class Documento {
    private final String titulo;
    private final RepositorioElementos repoElementos;

    public Documento(String titulo, int tamanho){
        this.titulo = titulo;
        this.repoElementos = new RepositorioElementos(tamanho);
    }
    public Documento(String titulo){
        this.titulo = titulo;
        this.repoElementos = new RepositorioElementos();
    }

    public int addTexto(String valor, int prioridade){
        if (atingiuMaximo()){
            throw new IndexOutOfBoundsException("Tamanho Máximo de Elementos foi atingido!");
        }
        return repoElementos.addTexto(valor, prioridade);
    }
    public int getQtdElementos(){
        return repoElementos.getQtdElementos();
    }
    public void moveElementoAcima(int elementoPosicao){
        repoElementos.mudaPosicaoElementosAcima(elementoPosicao);
    }
    public void moveElementoAbaixo(int elementoPosicao) {
        repoElementos.mudaPosicaoElementosAbaixo(elementoPosicao);
    }
    public String gerarRepresentacaoCompleta(int elementoPosicao){
        return repoElementos.getRepresentacaoCompleta(elementoPosicao);
    }
    public String gerarRepresentacaoResumida(int elementoPosicao){
        return repoElementos.getRepresentacaoResumida(elementoPosicao);
    }
    private boolean atingiuMaximo(){
        return repoElementos.getQtdElementos() >= repoElementos.getQtdMaxElementos();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Documento documento = (Documento) o;
        return Objects.equals(titulo, documento.titulo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titulo);
    }

    public boolean temElemento(int posicao) {
       return repoElementos.temElemento(posicao);
    }

    public void removeElemento(int elementoPosicao) {
        repoElementos.removeElemento(elementoPosicao);
    }

}
