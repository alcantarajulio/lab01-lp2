package agenda;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Interface com menus texto para manipular uma agenda de contatos.
 *
 * @author Júlio Alcantara - 122110504
 *
 */
public class MainAgenda {

    public static void main(String[] args) {
        Agenda agenda = new Agenda();
        Contato contato = new Contato();
        System.out.println("Carregando agenda inicial");
        try {
            /*
             * Essa é a maneira de lidar com possíveis erros por falta do arquivo.
             */
            carregaAgenda("agenda_inicial.csv", agenda);
        } catch (FileNotFoundException e) {
            System.err.println("Arquivo não encontrado: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Erro lendo arquivo: " + e.getMessage());
        }

        Scanner scanner = new Scanner(System.in);
        String escolha = "";
        while (true) {
            escolha = menu(scanner);
            comando(escolha, agenda, scanner);
        }

    }

    /**
     * Exibe o menu e captura a escolha do/a usuário/a.
     *
     * @param scanner Para captura da opção do usuário.
     * @return O comando escolhido.
     */
    private static String menu(Scanner scanner) {
        System.out.println(
                "\n---\nMENU\n" +
                        "(C)adastrar Contato\n" +
                        "(L)istar Contatos\n" +
                        "(E)xibir Contato\n" +
                        "(F)avoritos\n"+
                        "(A)dicionar Favorito\n" +
                        "(R)emover Favorito\n" +
                        "(S)air\n" +
                        "\n" +
                        "Opção> ");
        return scanner.next().toUpperCase();
    }

    /**
     * Interpreta a opção escolhida por quem está usando o sistema.
     *
     * @param opcao   Opção digitada.
     * @param agenda  A agenda que estamos manipulando.
     * @param scanner Objeto scanner para o caso do comando precisar de mais input.
     */
    private static void comando(String opcao, Agenda agenda, Scanner scanner) {
        switch (opcao) {
            case "C":
                cadastraContato(agenda, scanner);
                break;
            case "L":
                listaContatos(agenda);
                break;
            case "E":
                exibeContato(agenda, scanner);
                break;
            case "F":
                exibeFavoritos(agenda, scanner);
                break;
            case "A":
                adicionarFavorito(agenda, scanner);
                break;
            case "R":
                removeFavorito(agenda, scanner);
                break;

            case "S":
                sai();
                break;
            default:
                System.out.println("OPÇÃO INVÁLIDA!");
        }
    }

    /**
     * Imprime lista de contatos da agenda.
     *
     * @param agenda A agenda sendo manipulada.
     */
    private static void listaContatos(Agenda agenda) {
        System.out.println("\nLista de contatos: ");
        String[] listaContatos = agenda.listaContatos();
        for (String s: listaContatos) {
            System.out.println(s);
        }
    }

    /**
     * Imprime os detalhes de um dos contatos da agenda.
     *
     * @param agenda A agenda.
     * @param scanner Scanner para capturar qual contato.
     */
    private static void exibeContato(Agenda agenda, Scanner scanner) {
        System.out.print("\nQual contato> ");
        int posicao = scanner.nextInt();
        Contato contato = agenda.getContato(posicao - 1);
        try {
            System.out.println(contato.toString());
        }catch(NullPointerException e){
            System.out.println("POSIÇÃO INVÁLIDA!");
        }
    }

    /**
     * Cadastra um contato na agenda.
     *
     * @param agenda A agenda.
     * @param scanner Scanner para pedir informações do contato.
     */
    private static void cadastraContato(Agenda agenda, Scanner scanner) {
        System.out.print("\nPosição na agenda> ");
        int posicao = scanner.nextInt();
        System.out.print("\nNome> ");
        String nome = scanner.next();
        System.out.print("\nSobrenome> ");
        String sobrenome = scanner.next();
        System.out.print("\nTelefone> ");
        String telefone = scanner.next();
        try{
        agenda.cadastraContato(posicao, nome, sobrenome, telefone);
        System.out.println("CONTATO CADASTRADO COM SUCESSO!");
        } catch (NoSuchElementException | IllegalArgumentException | NullPointerException | IndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }

    }
    public static void adicionarFavorito(Agenda agenda, Scanner scanner){
        System.out.print("\nContato> ");
        int contato = scanner.nextInt();
        System.out.print("\nPosicao> ");
        int posicao = scanner.nextInt();
        try {
            Contato favorito = agenda.getContato(contato - 1);
            System.out.println(agenda.cadastraFavorito(agenda.getContato(contato - 1), posicao, contato));
        }catch(NullPointerException e){
            System.out.println("POSIÇÃO INVÁLIDA!");
        }
    }

    /**
     * Mostra quais são os a
     * @param agenda
     * @param scanner
     */
    public static void exibeFavoritos(Agenda agenda, Scanner scanner) {
        System.out.println("\nLista de favoritos: ");
        Contato[] favoritos = agenda.getFavoritos();
        for (int i = 0; i < favoritos.length; i++) {
            if (favoritos[i] != null) {
                System.out.println(agenda.formataContato(i + 1, favoritos[i]));
            }
        }
    }

    /**
     * remove os favoritos do array de favoritos
     * @param agenda
     * @param scanner
     */
    public static void removeFavorito(Agenda agenda, Scanner scanner){
        System.out.println("\nContato> ");
        int posicao = scanner.nextInt();
        agenda.removerFavorito(posicao);
    }

    /**
     * Sai da aplicação.
     */
    private static void sai() {
        System.out.println("\nVlw flw o/");
        System.exit(0);
    }

    /**
     * Lê uma agenda de um arquivo csv.
     *
     * @param arquivoContatos O caminho para o arquivo.
     * @param agenda A agenda que deve ser populada com os dados.
     * @throws IOException Caso o arquivo não exista ou não possa ser lido.
     */
    private static void carregaAgenda(String arquivoContatos, Agenda agenda) throws FileNotFoundException, IOException {
        LeitorDeAgenda leitor = new LeitorDeAgenda();

        int carregados =  leitor.carregaContatos(arquivoContatos, agenda);
        System.out.println("Carregamos " + carregados + " registros.");
    }
}