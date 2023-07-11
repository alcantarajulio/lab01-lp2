package documin.documento.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class DocuminControllerTest {

    DocuminController documinController = new DocuminController();
    Throwable exception;
    @BeforeEach
    void setUp() {
        documinController.criarDocumento("Principal", 4);
        documinController.criarTexto("Principal", "Esse é o texto principal.", 4);
        documinController.criarTitulo("Principal", "Esse é o título principal.", 4, 1,true);
        documinController.criarLista("Principal", "Essa / é / a / lista / principal",3 , "/", "-");
        documinController.criarTermos("Principal", "Esses / são / os / termos / principais", 2, "/", "NENHUM");
        documinController.criarDocumento("Meu Grimório");
    }

    @Test
    void criarDocumentoComTamanho() {
        //Cadastro somente com título — Sucesso
        assertTrue(documinController.criarDocumento("Como fazer Tapioca"));
        // Cadastro com título e tamanho — Sucesso
        assertTrue(documinController.criarDocumento("Como Fazer Bolo de Fubá", 4));
    }

    @Test
    void criarDocumentoInvalido(){
        // Cadastro com título já existente - Falha
        assertFalse(documinController.criarDocumento("Principal",15 ));
        // Documento com Título em Branco - Falha
        exception = assertThrows(IllegalArgumentException.class, () -> documinController.criarDocumento(" ", 3));
        assertEquals("Título Inválido!", exception.getMessage());
        // Documento com Título Null - Falha
        exception = assertThrows(NullPointerException.class, () -> documinController.criarDocumento(null, 3));
        assertEquals("Título Inválido!", exception.getMessage());
        // Documento com tamanho negativo.
        exception = assertThrows(IllegalArgumentException.class, () -> documinController.criarDocumento("Como construir uma cadeira", -5));
        assertEquals("Tamanho Inválido!", exception.getMessage());
        // Cadastro com tamanho zero.
        exception = assertThrows(IllegalArgumentException.class, () -> documinController.criarDocumento("Como brincar de massinha", 0));
        assertEquals("Tamanho Inválido!", exception.getMessage());
    }
    @Test
    void criarDocumentoSemTamanho() {
        //Cadastro somente com título — Sucesso
        assertTrue(documinController.criarDocumento("Como fazer Tapioca"));
        // Cadastro com título já existente - Falha
        assertFalse(documinController.criarDocumento("Como fazer Tapioca"));
        // Documento com Título em Branco - Falha
        exception = assertThrows(IllegalArgumentException.class, () -> documinController.criarDocumento(" "));
        assertEquals("Título Inválido!", exception.getMessage());
        // Documento com Título Null - Falha
        exception = assertThrows(NullPointerException.class, () -> documinController.criarDocumento(null));
        assertEquals("Título Inválido!", exception.getMessage());
    }

    @Test
    void contarElementos() {
        // Documento com 4 elementos do @BeforeEach - Sucesso.
        assertEquals(4,documinController.contarElementos("Principal"));
        // Documento sem elementos - Sucesso.
        documinController.criarDocumento("A vida dos papagaios.");
        assertEquals(0, documinController.contarElementos("A vida dos papagaios."));
        // Documento inexistente - Falha
        exception = assertThrows(NoSuchElementException.class, () -> documinController.contarElementos("Eu não existo!"));
        assertEquals("O documento não existe na base de dados!", exception.getMessage());
    }

    @Test
    void removerDocumento() {
        // Remoção de um documento inexistente - Falha.
        exception = assertThrows(NoSuchElementException.class, ()-> documinController.removerDocumento("Tresbien"));
        assertEquals("O documento não existe na base de dados!", exception.getMessage());
        // Remoção de um documento com título inválido - Falha.
        exception = assertThrows(IllegalArgumentException.class, ()-> documinController.removerDocumento(" "));
        assertEquals("Título Inválido!", exception.getMessage());
        // Remoção de um documento do @BeforeEach - Sucesso.
        documinController.removerDocumento("Principal");
        exception = assertThrows(NoSuchElementException.class, ()-> documinController.removerDocumento("Principal"));
        assertEquals("O documento não existe na base de dados!", exception.getMessage());
    }

    @Test
    void mostrarDocumento() {
        // Documento com título inválido - Falha
        exception = assertThrows(IllegalArgumentException.class, ()-> documinController.mostrarDocumento(" "));
        assertEquals("Título Inválido!", exception.getMessage());
        // Documento inexistente no banco de dados - Falha
        exception = assertThrows(NoSuchElementException.class, ()-> documinController.mostrarDocumento("Eu não existo!"));
        assertEquals("O documento não existe na base de dados!", exception.getMessage());
        // Documento existente - Sucesso.
        String[] mostraDoc =  documinController.mostrarDocumento("Principal");
        assertEquals("Esse é o texto principal.", mostraDoc[0]);
        assertEquals("1. Esse é o título principal.", mostraDoc[1]);
        assertEquals("Essa / é / a / lista / principal", mostraDoc[2]);
        assertEquals("Esses/são/os/termos/principais", mostraDoc[3]);
    }

    @Test
    void criarTexto() {
        // Documento com título inválido - Falha
        exception = assertThrows(IllegalArgumentException.class, ()-> documinController.criarTexto(" ", "Esse titulo não existe!", 1));
        assertEquals("Título Inválido!", exception.getMessage());
        // Documento inexistente no banco de dados - Falha
        exception = assertThrows(NoSuchElementException.class, ()-> documinController.criarTexto("Eu não existo!", "Isso vai dar problema...", 1));
        assertEquals("O documento não existe na base de dados!", exception.getMessage());
        // criar Elemento em um Documento que não suporta mais elementos - Falha

        exception = assertThrows(IndexOutOfBoundsException.class, ()-> documinController.criarTexto("Principal", "Isso vai dar problema...", 1));
        assertEquals("Tamanho Máximo de Elementos foi atingido!",exception.getMessage());

        // Elemento criado em um documento que já existe no @BeforeEach - Sucesso.
        assertEquals(0, documinController.criarTexto("Meu Grimório", "Anão > all", 3));
        assertEquals(1, documinController.criarTexto("Meu Grimório", "Eu concordo com os anões! especialmente os calvos!", 3));
    }

    @Test
    void criarTitulo() {
        // Documento com título inválido - Falha
        exception = assertThrows(IllegalArgumentException.class, ()-> documinController.criarTitulo(" ", "Esse titulo não existe!", 1, 1, false));
        assertEquals("Título Inválido!", exception.getMessage());
        // Documento inexistente no banco de dados - Falha
        exception = assertThrows(NoSuchElementException.class, ()-> documinController.criarTitulo("Eu não existo!", "Isso vai dar problema...", 1, 1, false));
        assertEquals("O documento não existe na base de dados!", exception.getMessage());
        // Elemento criado em um documento que já existe no @BeforeEach - Sucesso.
        assertEquals(0, documinController.criarTitulo("Meu Grimório", "Anão > all", 3, 1,true));
        assertEquals(1, documinController.criarTitulo("Meu Grimório", "Eu concordo com os anões! especialmente os calvos!", 3,2, false));
    }

    @Test
    void criarLista() {
        // Documento com título inválido - Falha
        exception = assertThrows(IllegalArgumentException.class, ()-> documinController.criarLista(" ", "Esse titulo não existe!", 1, "/", "-"));
        assertEquals("Título Inválido!", exception.getMessage());
        // Documento inexistente no banco de dados - Falha
        exception = assertThrows(NoSuchElementException.class, ()-> documinController.criarLista("Eu não existo!", "Esse titulo não existe!", 1, "/", "-"));
        assertEquals("O documento não existe na base de dados!", exception.getMessage());
        // Elemento criado em um documento que já existe no @BeforeEach - Sucesso.
        assertEquals(0, documinController.criarLista("Meu Grimório", "cura/bola de fogo/fusrodah", 5, "/", "-"));
        assertEquals(1, documinController.criarLista("Meu Grimório", "defender|atacar|curar", 4,"|",">"));
    }

    @Test
    void criarTermos() {
        // Documento com título inválido - Falha
        exception = assertThrows(IllegalArgumentException.class, ()-> documinController.criarTermos(" ", "Esse titulo não existe!", 1, "/", "NENHUM"));
        assertEquals("Título Inválido!", exception.getMessage());
        // Documento inexistente no banco de dados - Falha
        exception = assertThrows(NoSuchElementException.class, ()-> documinController.criarTermos("Eu não existo!", "Esse titulo não existe!", 1, "/", "NENHUM"));
        assertEquals("O documento não existe na base de dados!", exception.getMessage());
        // Prioridade inválida | 0 - Falha.
        exception = assertThrows(IllegalArgumentException.class, ()-> documinController.criarTermos("Principal", "Esse titulo não existe!", 0, "/", "NENHUM"));
        assertEquals("Tamanho Inválido!", exception.getMessage());
        // Prioridade inválida | prioridade negativa - Falha
        exception = assertThrows(IllegalArgumentException.class, ()-> documinController.criarTermos("Principal", "Esse titulo não existe!", -2, "/", "NENHUM"));
        assertEquals("Tamanho Inválido!", exception.getMessage());
        // Elemento criado em um documento que já existe no @BeforeEach - Sucesso.
        assertEquals(0, documinController.criarTermos("Meu Grimório", "cura/bola de fogo/fusrodah", 5, "/", "ALFABÉTICA"));
        assertEquals(1, documinController.criarTermos("Meu Grimório", "defender|atacar|curar", 4,"|","TAMANHO"));
    }
    @Test
    void criarAtalho(){
        assertEquals(0, documinController.criarAtalho("Meu Grimório", "Principal"));
        //testar excecoes
    }

    @Test
    void moverParaCima() {
        // Mover o documento inicial para cima - Sucesso.
        documinController.moverParaCima("Principal", 0);
        String[] mostraDoc =  documinController.mostrarDocumento("Principal");
        assertEquals("1. Esse é o título principal.", mostraDoc[0]);
        assertEquals("Esse é o texto principal.", mostraDoc[1]);
    }
    @Test
    void moverParaCimaNoUltimo(){
        // Mover o documento final para cima - Falha
        documinController.moverParaCima("Principal", 3);
        String[] mostraDoc =  documinController.mostrarDocumento("Principal");
        assertEquals("Essa / é / a / lista / principal", mostraDoc[2]);
        assertEquals("Esses/são/os/termos/principais", mostraDoc[3]);
    }

    @Test
    void moverParaBaixo() {
        // Mover o segundo documento para baixo - Sucesso.
        documinController.moverParaBaixo("Principal", 1);
        String[] mostraDoc =  documinController.mostrarDocumento("Principal");
        assertEquals("1. Esse é o título principal.", mostraDoc[0]);
        assertEquals("Esse é o texto principal.", mostraDoc[1]);

    }
    @Test
    void moverParaBaixoIndiceZero() {
        // Mover o documento inicial para baixo
        documinController.moverParaBaixo("Principal", 0);
        String[] mostraDoc =  documinController.mostrarDocumento("Principal");
        assertEquals("Esse é o texto principal.", mostraDoc[0]);
        assertEquals("1. Esse é o título principal.", mostraDoc[1]);
    }
    // Representações Completas de elementos
    @Test
    void pegarRepresentacaoCompletaTexto() {
        assertEquals("Esse é o texto principal.",documinController.pegarRepresentacaoCompleta("Principal", 0));
    }
    @Test
    void pegarRepresentacaoCompletaTitulo() {
        assertEquals("1. Esse é o título principal. -- 1-ESSEÉOTÍTULOPRINCIPAL.", documinController.pegarRepresentacaoCompleta("Principal", 1));
    }
    @Test
    void pegarRepresentacaoCompletaLista() {
        assertEquals(
                """
                        -Essa
                        -é
                        -a
                        -lista
                        -principal""",
                documinController.pegarRepresentacaoCompleta("Principal", 2)
        );
    }
    @Test
    void pegarRepresentacaoCompletaTermosSemOrdem() {
        documinController.criarTermos("Meu Grimório", "Baoba/arcebispo/diaspora/catastrofe", 4, "/", "NENHUM");
        assertEquals("Total termos: 4\n-Baoba,arcebispo,diaspora,catastrofe", documinController.pegarRepresentacaoCompleta("Meu Grimório", 0));
    }
    @Test
    void pegarRepresentacaoCompletaTermosAlfabeticamente() {
        documinController.criarTermos("Meu Grimório", "baoba/arcebispo/diaspora/catastrofe", 4, "/", "ALFABÉTICA");
        assertEquals("Total termos: 4\n-arcebispo,baoba,catastrofe,diaspora", documinController.pegarRepresentacaoCompleta("Meu Grimório", 0));
    }
    @Test
    void pegarRepresentacaoCompletaTermosNumericamente() {
        documinController.criarTermos("Meu Grimório", "baoba/arcebispo/diaspora/catastrofe", 4, "/", "TAMANHO");
        assertEquals("Total termos: 4\n-catastrofe,arcebispo,diaspora,baoba", documinController.pegarRepresentacaoCompleta("Meu Grimório", 0));
    }
    @Test
    void pegarRepresentacaoCompletaAtalhoDocumento() {
        documinController.criarTitulo("Meu Grimório", "Ficar de boa", 4, 1, true);
        documinController.criarTexto("Meu Grimório", "FIREBALL", 2);
        documinController.criarAtalho("Meu Grimório", "Principal");
        assertEquals("""
                Esse é o texto principal.
                1. Esse é o título principal. -- 1-ESSEÉOTÍTULOPRINCIPAL.
                """, documinController.pegarRepresentacaoCompleta("Meu Grimório",2));

    }
    // Representações Resumidas de elemento.
    @Test
    void pegarRepresentacaoResumidaTexto() {
        assertEquals("Esse é o texto principal.",documinController.pegarRepresentacaoResumida("Principal", 0));
    }
    @Test
    void pegarRepresentacaoResumidaTitulo() {
        assertEquals("1. Esse é o título principal.", documinController.pegarRepresentacaoResumida("Principal", 1));
    }
    @Test
    void pegarRepresentacaoResumidaLista() {
        assertEquals(
                "Essa / é / a / lista / principal", documinController.pegarRepresentacaoResumida("Principal", 2)
        );
    }
    @Test
    void pegarRepresentacaoResumidaTermosSemOrdem() {
        documinController.criarTermos("Meu Grimório", "Baoba/arcebispo/diaspora/catastrofe", 4, "/", "NENHUM");
        assertEquals("Baoba/arcebispo/diaspora/catastrofe", documinController.pegarRepresentacaoResumida("Meu Grimório", 0));
    }
    @Test
    void pegarRepresentacaoResumidaTermosAlfabeticamente() {
        documinController.criarTermos("Meu Grimório", "baoba/arcebispo/diaspora/catastrofe", 4, "/", "ALFABÉTICA");
        assertEquals("arcebispo/baoba/catastrofe/diaspora", documinController.pegarRepresentacaoResumida("Meu Grimório", 0));
    }
    @Test
    void pegarRepresentacaoResumidaTermosNumericamente() {
        documinController.criarTermos("Meu Grimório", "baoba/arcebispo/diaspora/catastrofe", 4, "/", "TAMANHO");
        assertEquals("catastrofe/arcebispo/diaspora/baoba", documinController.pegarRepresentacaoResumida("Meu Grimório", 0));
    }
    @Test
    void pegarRepresentacaoResumidaAtalhoDocumento() {
        documinController.criarTitulo("Meu Grimório", "Ficar de boa", 4, 1, true);
        documinController.criarTexto("Meu Grimório", "FIREBALL", 2);
        documinController.criarAtalho("Meu Grimório", "Principal");
        assertEquals("""         
        Esse é o texto principal.
        1. Esse é o título principal.
        """, documinController.pegarRepresentacaoResumida("Meu Grimório",2));
    }

    @Test
    void apagarElemento() {
        assertTrue(documinController.apagarElemento("Principal", 0));
    }
    @Test
    void apagarElementoInexistente(){
        assertFalse(documinController.apagarElemento("Principal", 5));
    }


    @Test
    void criarVisaoCompleta() {
        assertEquals(0, documinController.criarVisaoCompleta("Principal"));
        assertEquals(1, documinController.criarVisaoCompleta("Meu Grimório"));
    }
    @Test
    void criarVisaoResumida() {
        assertEquals(0, documinController.criarVisaoResumida("Principal"));
        assertEquals(1, documinController.criarVisaoResumida("Meu Grimório"));
    }

    @Test
    void criarVisaoPrioritaria() {
        assertEquals(0, documinController.criarVisaoPrioritaria("Principal", 4));
        assertEquals(1, documinController.criarVisaoPrioritaria("Meu Grimório", 2));
    }


    @Test
    void criarVisaoTitulo() {
        assertEquals(0, documinController.criarVisaoTitulo("Principal"));
        assertEquals(1, documinController.criarVisaoTitulo("Meu Grimório"));
    }

    @Test
    void criarVisaoInvalida(){
        exception = assertThrows(NoSuchElementException.class, ()-> documinController.criarVisaoCompleta("Não existo!"));
        assertEquals("O documento não existe na base de dados!", exception.getMessage());
    }
    @Test
    void exibirVisaoCompleta(){
        documinController.criarVisaoCompleta("Principal");
        String[] visoes = documinController.exibirVisao(0);
        assertEquals("Esse é o texto principal.", visoes[0]);
        assertEquals("1. Esse é o título principal. -- 1-ESSEÉOTÍTULOPRINCIPAL.", visoes[1]);
        assertEquals(
                """
                        -Essa
                        -é
                        -a
                        -lista
                        -principal""",
                visoes[2]);
        assertEquals("Total termos: 5\n-Esses,são,os,termos,principais", visoes[3]);

    }
    @Test
    void exibirVisaoResumida(){
        documinController.criarVisaoResumida("Principal");
        String[] visoes = documinController.exibirVisao(0);
        assertEquals("Esse é o texto principal.", visoes[0]);
        assertEquals("1. Esse é o título principal.", visoes[1]);
        assertEquals("Essa / é / a / lista / principal", visoes[2]);
        assertEquals("Esses/são/os/termos/principais", visoes[3]);
    }
    @Test
    void exibirVisaoTitulo() {
        documinController.criarVisaoTitulo("Principal");
        String[] visoes = documinController.exibirVisao(0);
        assertEquals("1. Esse é o título principal.", visoes[0]);
    }
    @Test
    void exibirVisaoPrioritaria(){
        documinController.criarVisaoPrioritaria("Principal", 4);
        String[] visoes = documinController.exibirVisao(0);
        assertEquals("Esse é o texto principal.", visoes[0]);
        assertEquals("1. Esse é o título principal. -- 1-ESSEÉOTÍTULOPRINCIPAL.", visoes[1]);
    }
}