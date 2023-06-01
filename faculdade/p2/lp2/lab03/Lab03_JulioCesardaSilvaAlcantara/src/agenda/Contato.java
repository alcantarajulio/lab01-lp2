package agenda;

/**
 * Classe que carrega as características de um Contato
 *
 * @author Júlio Alcantara - 122110504
 */
public class Contato {
    private String nome;
    private String sobrenome;
    private String telefone;
    private boolean favorito;

    public Contato(){
        nome = "";
        sobrenome = "";
        telefone = "";
        favorito = false;
    }
    public Contato(String nome, String sobrenome, String telefone){
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.telefone = telefone;
    }
    public String getNome(){
        return this.nome;
    }
    public String getSobrenome(){
        return this.sobrenome;
    }

    public String getTelefone() {
        return telefone;
    }
    public boolean ehFavorito() {
        return favorito;
    }
    public void favoritador(){
        favorito = true;
    }
    public void desfavoritador(){
        favorito = false;
    }
    @Override
    public String toString(){
        if(favorito) {
            return "❤️ " + this.getNome() + " " + this.getSobrenome() + "\n" + this.getTelefone();
        }
        return this.getNome() + " " + this.getSobrenome() + "\n" + this.getTelefone();
    }
    public boolean equals(String nome, String sobrenome){
        return getNome().toLowerCase().equalsIgnoreCase(nome) && getSobrenome().toLowerCase().equalsIgnoreCase(sobrenome);
    }

}
