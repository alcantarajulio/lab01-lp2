package src;

import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Carregando o menu...");
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");
        MrBetSistema mrbetsistema = new MrBetSistema();
        String escolha;

        while (true) {
            escolha = menu(scanner);
            if(escolha.isBlank()){
                throw new IOException("ENTRADA INVÁLIDA!");
            }
            comando(escolha ,mrbetsistema ,scanner);
        }
    }
    private static String menu(Scanner scanner){
        System.out.println(
                """
                        (M)inha inclusão de times
                        (R)Recuperar time
                        (.)Adicionar campeonato
                        (B)Bora incluir time em campeonato e Verificar se time está em campeonato
                        (E)Exibir campeonatos que o time participa
                        (T)Tentar a sorte e status
                        (!)Já pode fechar o programa!
                        Opção>\s""");
        return scanner.next().toUpperCase();
    }
    private static void comando(String escolha, MrBetSistema mrbetsistema, Scanner scanner) throws IOException {
        switch (escolha) {
            case "M" -> cadastrarTime(mrbetsistema, scanner);
            case "R" -> recuperarTime(mrbetsistema, scanner);
            case "." -> adicionarCampeonato(mrbetsistema, scanner);
            case "B" -> submenu(mrbetsistema, scanner);
            case "E" -> exibirCampeonatos(mrbetsistema, scanner);
            case "T" -> tentarSorte(mrbetsistema, scanner);
            case "!" -> saida();
            default -> System.err.println("Opção Inválida");
        }
    }
    private static void cadastrarTime(MrBetSistema mrbetsistema, Scanner scanner) {
        System.out.println("Código: ");
        String identificador = scanner.next();
        System.out.println("Nome: ");
        String nomeDoTime = scanner.next();
        System.out.println("Mascote: ");
        String nomeDoMascote = scanner.next();
        System.out.println(mrbetsistema.insereTime(identificador, nomeDoTime, nomeDoMascote));
    }
    private static void recuperarTime(MrBetSistema mrbetsistema, Scanner scanner){
        System.out.println("Código: ");
        String identificador = scanner.next();
        System.out.println(mrbetsistema.retornaTime(identificador));

    }
    private static void adicionarCampeonato(MrBetSistema mrbetsistema, Scanner scanner){
        System.out.println("Campeonato: ");
        String nomeCampeonato = scanner.next();
        System.out.println("Participantes: ");
        int qtdeMaxParticipantes = scanner.nextInt();
        System.out.println(mrbetsistema.adicionaCampeonato(nomeCampeonato, qtdeMaxParticipantes));

    }
    private static void submenu(MrBetSistema mrbetsistema, Scanner scanner) throws IOException {
        System.out.println("(I) Incluir time em campeonato ou (V) Verificar se time está em campeonato?\nOpção>");
        String escolha = scanner.next().toUpperCase();
        switch (escolha) {
            case "I" -> {
                System.out.println("Código: ");
                String identificador = scanner.next();
                System.out.println("Campeonato: ");
                String nomeCampeonato = scanner.next();
                System.out.println(mrbetsistema.insereTimeCampeonato(identificador, nomeCampeonato));
            }
            case "V" -> {
                System.out.println("Código: ");
                String identificador = scanner.next();
                System.out.println("Campeonato: ");
                String nomeCampeonato = scanner.next();
                System.out.println(mrbetsistema.recuperaTimeCampeonato(identificador, nomeCampeonato));
            }
            default ->throw new IOException("Opção Inválida");
        }
    }
    private static void exibirCampeonatos(MrBetSistema mrBetSistema, Scanner scanner){
        String identificador;
        System.out.print("Time: ");
        identificador = scanner.next();
        System.out.println(mrBetSistema.exibeCampeonatosTime(identificador));

    }
    private static void tentarSorte(MrBetSistema mrBetSistema, Scanner scanner){
            System.out.println("(A)Apostar ou (S)Status das Apostas?\nOpção>");
            String escolha = scanner.next().toUpperCase();
            switch (escolha) {
                case "A" -> {
                    System.out.println("Código: ");
                    String identificador = scanner.next();
                    System.out.println("Campeonato: ");
                    String campeonato = scanner.next();
                    System.out.println("Colocação: ");
                    int colocacao = scanner.nextInt();
                    System.out.println("Valor da Aposta: ");
                    double valorAposta = scanner.nextDouble();
                    System.out.println(mrBetSistema.cadastraAposta(identificador, campeonato, colocacao, valorAposta));
                }
                case "S" -> System.out.println(mrBetSistema.recuperaAposta());
                default -> System.err.println("Opção Inválida");
            }
        }
    private static void saida(){
        System.out.println("Por hoje é só pessoal!");
        System.exit(0);
    }
}