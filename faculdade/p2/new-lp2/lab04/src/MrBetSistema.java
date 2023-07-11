package src;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.NoSuchElementException;

/**
 * Classe que delega as funcionalidades do sistema MR Bet.
 *
 * @author Júlio César da Silva Alcantara 122110504
 */
public class MrBetSistema {

    private final HashMap<String, Time> times;
    private final HashMap<String, Campeonato> campeonatos;
    private final ArrayList<Aposta> apostas;

    /**
     * Instancia a classe do zero, inicializando as coleções.
     */
    public MrBetSistema() {
        times = new HashMap<>();
        campeonatos = new HashMap<>();
        apostas = new ArrayList<>();
    }

    /**
     * Recupera o time pelo código identificador
     *
     * @param identificador do time
     * @return objeto do time
     */
    public Time recuperaTime(String identificador){
        if (!times.containsKey(identificador)){
            throw new NoSuchElementException("TIME NÃO EXISTE!");
        }
        return times.get(identificador);
    }
    private Campeonato recuperaCampeonato(String nomeCampeonato){
        if (!campeonatos.containsKey(nomeCampeonato)){
            throw new NoSuchElementException("CAMPEONATO NÃO EXISTE!");
        }
        return campeonatos.get(nomeCampeonato);
    }

    /**
     * Retorna o toString formatado com as informações do
     *
     * @param identificador do time
     * @return string com identificador, nome e mascote do time.
     */
    public String retornaTime(String identificador){
        Time time = recuperaTime(identificador);
        return time.toString();
    }

    /**
     * Insere o time no sistema com o código, o nome e o mascote
     *
     * @param identificador codigo do time
     * @param nomeDoTime    nome do time
     * @param nomeDoMascote nome do mascote
     * @return string avisando que foi cadastrado com sucesso.
     */
    public String insereTime(String identificador, String nomeDoTime, String nomeDoMascote){
        if (identificador == null || identificador.isBlank()) {
            throw new IllegalArgumentException("ENTRADA INVÁLIDA");
        }
        if (times.containsKey(identificador)) {
            throw new IllegalArgumentException("TIME JÁ EXISTE");
        }
        Time time = new Time(identificador, nomeDoTime, nomeDoMascote);
        times.put(identificador, time);
        return "INCLUSÃO REALIZADA!";
    }

    /**
     * Adiciona o campeonato no sistema, contendo o nome e o número de participantes.
     *
     * @param nomeCampeonato O nome do campeonato.
     * @param qtdeParticipantes O número de participantes.
     * @return string avisando que foi cadastrado com sucesso.
     */
    public String adicionaCampeonato(String nomeCampeonato, int qtdeParticipantes){
        if (nomeCampeonato == null || nomeCampeonato.isBlank()) {
            throw new IllegalArgumentException("ENTRADA INVÁLIDA");
        }

        verificaCampeonatoExistente(nomeCampeonato);
        Campeonato campeonato = new Campeonato(nomeCampeonato, qtdeParticipantes);
        campeonatos.put(nomeCampeonato, campeonato);
        return "CAMPEONATO ADICIONADO!";
    }

    /**
     * Insere time ao campeonato.
     *
     * @param identificador  código identificador
     * @param nomeCampeonato Nome do campeonato
     * @return string avisando que foi cadastrado com sucesso.
     */
    public String insereTimeCampeonato(String identificador, String nomeCampeonato){
        Time time = recuperaTime(identificador);
        Campeonato campeonato = recuperaCampeonato(nomeCampeonato);
        campeonato.adicionaTime(time);
        time.setCampeonatosDeTime(campeonato);
        return "TIME INCLUÍDO NO CAMPEONATO!";
    }

    /**
     * Verifica se o time está no campeonato ou não.
     *
     * @param identificador  codigo identificador
     * @param nomeCampeonato Nome do campeonato
     * @return string avisando que verifica se houve sucesso.
     */
    public String recuperaTimeCampeonato(String identificador, String nomeCampeonato) {
        Time time = recuperaTime(identificador);
        Campeonato campeonato = recuperaCampeonato(nomeCampeonato);
        if (!campeonato.verificaTimeCampeonato(time)){
            throw new NoSuchElementException("O TIME NÃO ESTÁ NO CAMPEONATO!");
        }
        return "O TIME ESTÁ NO CAMPEONATO!";
    }

    /**
     * Exibe campeonatos que um time participa.
     *
     * @param identificador codigo identificador
     * @return string contendo os campeonatos do time.
     */
    public String exibeCampeonatosTime(String identificador){
        Time time = recuperaTime(identificador);
        StringBuilder retorno = new StringBuilder("Campeonatos do " + time.getNome() + ":");

        int quantidadeCampeonatosTime = time.getQtdeCampeonatos();
        if (quantidadeCampeonatosTime == 0){
            throw new IllegalArgumentException("O TIME NÃO ESTÁ EM NENHUM CAMPEONATO!");
        }
        for( Campeonato campeonato : time.getCampeonatosDeTime() ){
            retorno.append(campeonato.toString());
        }
        return retorno.toString();
    }

    /**
     * Cadastra uma aposta específica em uma coleção de apostas
     *
     * @param identificador  codigo identificador
     * @param nomeCampeonato nome do campeonato
     * @param colocacao      colocacao
     * @param valorAposta    valor da aposta
     * @return string avisando que verifica se houve sucesso.
     */
    public String cadastraAposta(String identificador,String nomeCampeonato,int colocacao, double valorAposta){
        Campeonato campeonato = recuperaCampeonato(nomeCampeonato);
        Time time = recuperaTime(identificador);
        int colocacaoMaxima = campeonato.getQtdeMaxTimesCampeonato();
        recuperaTimeCampeonato(identificador, nomeCampeonato);

        if(colocacao > colocacaoMaxima){
            throw new IllegalArgumentException("APOSTA NÃO REGISTRADA!");
        }
        Aposta aposta = new Aposta(time, campeonato, colocacao, valorAposta);
        apostas.add(aposta);
        return "APOSTA REGISTRADA!";
    }

    /**
     * Recupera as apostas cadastradas no sistema.
     *
     * @return apostas listadas em ordem numérica
     */
    public String recuperaAposta(){
        String retorno = "Apostas:\n";
        for(int i = 0; i < apostas.size(); i++){
            retorno += i + 1 + ". ";
            retorno += apostas.get(i).toString();
        }
        return retorno;
    }
    private boolean verificaCampeonatoExistente(String nomeCampeonato){
        for (Campeonato campeonato: campeonatos.values()){
            if (nomeCampeonato.equalsIgnoreCase(campeonato.getNomeCampeonato())){
                throw new IllegalArgumentException("CAMPEONATO JÁ EXISTE!");
            }
        }
        return false;
    }
}