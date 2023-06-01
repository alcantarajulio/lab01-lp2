package documin.documento.elementos;

public class Texto extends ElementoAbstract{

    public Texto(String valor, int prioridade) {
        this.valor = valor;
        this.prioridade = prioridade;
    }

   @Override
    public int getPrioridade(){
        return this.prioridade;
   }
   @Override
    public String gerarRepresentacaoCompleta(){
        return this.valor;
   }
   @Override
    public String gerarRepresentacaoResumida(){
        return this.valor;
   }
}
