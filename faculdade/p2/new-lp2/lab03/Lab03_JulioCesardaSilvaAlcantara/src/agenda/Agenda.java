package agenda;

import java.util.ArrayList;

/**
 * Uma agenda que mantém uma lista de contatos com posições. Podem existir 100 contatos.
 *
 * @author Júlio Alcantara - 122110504
 *
 */
public class Agenda {

    private static final int TAMANHO_AGENDA = 100;
    private final Contato[] contatos;   //apenas uma simplificacao de contato;
    private final Contato[] favoritos;
    private int numContatos;
    /**
     * Cria uma agenda.
     */
    public Agenda() {
        this.contatos = new Contato[TAMANHO_AGENDA];
        this.favoritos = new Contato[TAMANHO_AGENDA / 10 ];
    }

    /**
     * Acessa a lista de contatos mantida.
     * @return O array de contatos.
     */
    public Contato[] getContatos() {
        return this.contatos.clone();
    }

    /**
     * Acessa os dados de um contato específico.
     * @param posicao Posição do contato na agenda.
     * @return Dados do contato. Null se não há contato na posição.
     */
    public Contato getContato(int posicao) {
        return contatos[posicao];
    }
    public Contato[] getFavoritos() {return this.favoritos.clone();}
    /**
     * Cadastra um contato numa posição. Um cadastro numa posição que já existe sobrescreve o anterior.
     * @param posicao Posição do contato.
     * @param nome Nome do contato.
     * @param sobrenome Sobrenome do contato.
     * @param telefone Telefone do contato.
     */
    public void cadastraContato(int posicao, String nome, String sobrenome, String telefone) {
        if (posicao > TAMANHO_AGENDA || posicao < 1) {
            throw new IndexOutOfBoundsException("POSIÇÃO INVÁLIDA");
        }
        if (!verificaContatoNulo(posicao - 1) && getContato(posicao - 1).equals(nome, sobrenome)) {
            throw new IllegalArgumentException("CONTATO JÁ CADASTRADO");
        }

        if (nome.isBlank()|| telefone.isBlank()){
            throw new IllegalArgumentException("CONTATO INVÁLIDO");
        }
        this.contatos[posicao - 1] = new Contato(nome, sobrenome, telefone);
    }
    /**
     * Retorna lista de contatos formatados da agenda.
     * @return lista de contatos
     */
    public String[] listaContatos() {
        ArrayList<String> listaContatos = new ArrayList<>();
        for (int i = 0; i < getContatos().length; i++) {
            if (!contatos[i].getNome().equals("")) {
                listaContatos.add(formataContato(i + 1, contatos[i]));
            }
        }
        String[] listaContato = listaContatos.toArray(new String[conta(getContatos())]);
        return listaContato;
    }
    public String[] listaFavoritos() {
        ArrayList<String> listaFavoritos = new ArrayList<>();
        for (int i = 0; i < getFavoritos().length; i++) {
            if (!favoritos[i].getNome().equals("")) {
                listaFavoritos.add(formataContato(i + 1, favoritos[i]));
            }
        }
        String[] listaFavorito = listaFavoritos.toArray(new String[conta(getFavoritos())]);
        return listaFavorito;
    }

    public String cadastraFavorito(Contato contato, int posicao, int contatoPosicao) {
        if (posicao > favoritos.length || posicao < 1) {
            throw new IndexOutOfBoundsException("POSIÇÃO INVÁLIDA");
        }
        if (contato.ehFavorito()) {
            throw new IllegalArgumentException("CONTATO JÁ É FAVORITO");
        }
        this.favoritos[posicao - 1] = getContato(contatoPosicao - 1);
        contatos[contatoPosicao - 1].favoritador();
        return "CONTATO FAVORITADO NA POSIÇÃO " + posicao + "!";
    }
    public void removerFavorito(int posicaoContato){
        if (posicaoContato > favoritos.length || posicaoContato < 1) {
            throw new IndexOutOfBoundsException("POSIÇÃO INVÁLIDA");
        }
        favoritos[posicaoContato - 1].desfavoritador();
    }
    public Contato getFavorito(int posicao){
        return favoritos[posicao - 1];
    }
    /**
     * Conta a quantidade de contatos cadastrados
     *
     * @return o numero de contatos
     */
    private int conta(Contato[] lista) {
        for (Contato c : lista) {
            if (!c.getNome().equals("")) {
                numContatos++;
            }
        }
        return numContatos;
    }
    /**
     * Formata um contato para impressão na interface.
     *
     * @param posicao A posição do contato (que é exibida)
     * @param contato O contato a ser impresso.
     * @return A String formatada.
     */
    public static String formataContato(int posicao, Contato contato) {
        return posicao + " - " + contato.toString();
    }
    public boolean verificaContatoNulo(int posicao){
        return getContato(posicao) == null;
    }



}