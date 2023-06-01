package Test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import src.MrBetSistema;
import java.util.NoSuchElementException;
import static org.junit.jupiter.api.Assertions.*;

class TestMrBetSistema {

    MrBetSistema mrBetTest;

    @BeforeEach
    void setup(){
        this.mrBetTest = new MrBetSistema();
        mrBetTest.insereTime("250_PB", "NACIONAL DE PATOS", "CANÁRIO");
        mrBetTest.insereTime("252_PB", "SPORT LAGOA SECA", "CARNEIRO");
        mrBetTest.insereTime("002_RJ","CLUBE REGATAS DO FLAMENGO","URUBU");
        mrBetTest.insereTime("105_PB","SOCIEDADE RECREATIVA DE MONTEIRO (SOCREMO)","GAVIÃO");
        mrBetTest.adicionaCampeonato("Copa do Nordeste 2023", 2);
    }

    @Test
    void cadastraTime() {
        assertEquals("INCLUSÃO REALIZADA!", mrBetTest.insereTime("300_PB", "CAMPINENSE", "RAPOSA"));
        // parâmetros inválidos
        assertThrows(IllegalArgumentException.class, () -> mrBetTest.insereTime(null, "NACIONAL DE PATOS", "CANÁRIO"));
        assertThrows(IllegalArgumentException.class, () -> mrBetTest.insereTime("", "NACIONAL DE PATOS", "CANÁRIO"));
        // time já existente
        assertThrows(IllegalArgumentException.class, () -> mrBetTest.insereTime("300_PB", "CAMPINENSE", "RAPOSA"));
    }

    @Test
    void retornaTime() {
        assertEquals( "[250_PB] NACIONAL DE PATOS / CANÁRIO", mrBetTest.retornaTime("250_PB"));
        // time não existente
        assertThrows(NoSuchElementException.class, () -> mrBetTest.recuperaTime("100_PB"));
    }

    @Test
    void cadastraCampeonato() {
        assertEquals("CAMPEONATO ADICIONADO!", mrBetTest.adicionaCampeonato("Brasileirão Série A 2023", 20));
        // parâmetros inválidos
        assertThrows(IllegalArgumentException.class, () ->  mrBetTest.adicionaCampeonato(null, 20));
        assertThrows(IllegalArgumentException.class, () ->  mrBetTest.adicionaCampeonato("", 20));
        // campeonato já existe
        assertThrows(IllegalArgumentException.class, () -> mrBetTest.adicionaCampeonato("Brasileirão Série A 2023", 20));

    }

    @Test
    void cadastraTimeCampeonato() {
        mrBetTest.adicionaCampeonato("Brasileirão Série A 2023", 3);
        assertEquals("TIME INCLUÍDO NO CAMPEONATO!", mrBetTest.insereTimeCampeonato( "250_PB","Brasileirão Série A 2023"));
        assertEquals("TIME INCLUÍDO NO CAMPEONATO!", mrBetTest.insereTimeCampeonato("252_PB","Brasileirão Série A 2023"));
        // incluir time já cadastrado
        assertEquals("TIME INCLUÍDO NO CAMPEONATO!", mrBetTest.insereTimeCampeonato( "252_PB","Brasileirão Série A 2023"));
        // incluir time não cadastrado
        assertThrows(NoSuchElementException.class, () -> mrBetTest.insereTimeCampeonato("005_PB", "Brasileirão Série A 2023"));
        // incluir em campeonato não existente
        assertThrows(NoSuchElementException.class, () -> mrBetTest.insereTimeCampeonato("252_PB","Brasileirão Série D 2023"));
        // incluir time excedendo quantidade de participantes
        assertThrows(IllegalStateException.class, () -> mrBetTest.insereTimeCampeonato("105_PB","Brasileirão Série A 2023"));

    }

    @Test
    void recuperaTimeCampeonato() {
        mrBetTest.insereTimeCampeonato("250_PB","Copa do Nordeste 2023");
        assertEquals( "O TIME ESTÁ NO CAMPEONATO!",mrBetTest.recuperaTimeCampeonato("250_PB","Copa do Nordeste 2023"));
        assertThrows( NoSuchElementException.class, () -> mrBetTest.recuperaTimeCampeonato("252_PB", "Copa do Nordeste 2023"));
        // campeonato não existe
        assertThrows(NoSuchElementException.class, () -> mrBetTest.insereTimeCampeonato("as252_PB","Brasileirão série D 2023"));
        // time não existe
        assertThrows(NoSuchElementException.class, () -> mrBetTest.insereTimeCampeonato("Copa do Nordeste 2023", "005_PB"));
    }

    @Test
    void exibeCampeonatosTime() {
        String saidaEsperada = "Campeonatos do NACIONAL DE PATOS:\n" + "* Brasileirão 2023 - 1/3";
        mrBetTest.adicionaCampeonato("Brasileirão 2023", 3);
        mrBetTest.insereTimeCampeonato("250_PB","Brasileirão 2023");
        assertEquals(saidaEsperada, mrBetTest.exibeCampeonatosTime("250_PB"));
        // time não cadastrado
        assertThrows(NoSuchElementException.class, () -> mrBetTest.exibeCampeonatosTime("005_PB"));
    }

    @Test
    void apostaTime() {
        mrBetTest.insereTimeCampeonato("250_PB", "Copa do Nordeste 2023");
        mrBetTest.insereTimeCampeonato("252_PB", "Copa do Nordeste 2023");
        assertEquals("APOSTA REGISTRADA!", mrBetTest.cadastraAposta("250_PB", "Copa do Nordeste 2023", 1, 10.00));
        // colocação > quantidade de participantes do campeonato
        assertThrows(IllegalArgumentException.class, () -> mrBetTest.cadastraAposta("250_PB", "Copa do Nordeste 2023", 10, 10.00));
        // time não existe
        assertThrows(NoSuchElementException.class, () -> mrBetTest.cadastraAposta("005_PB", "Copa do Nordeste 2023", 10, 10.00));
        // campeonato não existe
        assertThrows(NoSuchElementException.class, () -> mrBetTest.cadastraAposta("250_PB" ,"Brasileirão série D 2023", 10, 10.00));
        // time não participa do campeonato
        assertThrows(NoSuchElementException.class, () -> mrBetTest.cadastraAposta("105_PB" ,"Copa do Nordeste 2023", 10, 10.00));
    }

    @Test
    void recuperaStatusApostas() {
        String saidaEsperada = """
                Apostas:
                1. [250_PB] NACIONAL DE PATOS / CANÁRIO
                Copa do Nordeste 2023
                1/2
                R$ 10.0""";
        mrBetTest.insereTimeCampeonato("250_PB","Copa do Nordeste 2023");
        mrBetTest.cadastraAposta("250_PB", "Copa do Nordeste 2023", 1, 10.00);
        assertEquals(saidaEsperada, mrBetTest.recuperaAposta());
    }

}