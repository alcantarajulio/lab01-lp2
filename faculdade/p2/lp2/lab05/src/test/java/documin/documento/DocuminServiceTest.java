package documin.documento;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class DocuminServiceTest {
    // Testar null || blank

    private final DocuminService documinService = new DocuminService();
    private Throwable exception;
    @BeforeEach
    void setUp() {
        documinService.criarDocumento("Tarefas", 3);
        documinService.criarTexto("Tarefas", "-> Construir uma casa", 5);
    }

    @Test
    void criarDocumento() {
        //Cadastro somente com título — Sucesso
        assertTrue(documinService.criarDocumento("Como fazer Tapioca"));
        // Cadastro com título e tamanho — Sucesso
        assertTrue(documinService.criarDocumento("Como Fazer Bolo de Fubá", 4));
        // Cadastro com título já existente - Falha
        assertFalse(documinService.criarDocumento("Como Fazer Bolo de Fubá",15 ));
        // Documento com Título em Branco - Falha
        assertFalse(documinService.criarDocumento("", 3));
    }
    @Test
    void criarDocumentoComTamanhoInvalido(){
        //Cadastro com tamanho negativo - Exceção
        exception = assertThrows(IllegalArgumentException.class, () -> documinService.criarDocumento("Como construir uma cadeira", -5));
        assertEquals("Tamanho Inválido!", exception.getMessage());

        // Cadastro com tamanho zero.
        exception = assertThrows(IllegalArgumentException.class, () -> documinService.criarDocumento("Como brincar de massinha", 0));
        assertEquals("Tamanho Inválido!", exception.getMessage());
    }
    @Test
    void removerDocumento(){
        documinService.removerDocumento("Tarefas");
        exception = assertThrows(NoSuchElementException.class, () -> documinService.removerDocumento("Tarefas"));
        assertEquals("O documento não existe na base de dados!", exception.getMessage());
    }
    @Test
    void contarElementos() {
        documinService.criarTexto("Tarefas", "Viver é bom", 2);
        documinService.criarTexto("Tarefas", "Sonhar é bom", 3);
        assertEquals(3, documinService.contarElementos("Tarefas"));
    }
    @Test
    void criarTexto() {
        // Textos criados normalmente em um documento que já existe - Sucesso
        assertEquals(1, documinService.criarTexto("Tarefas", "-> Completar Bingo", 5));
        assertEquals(2, documinService.criarTexto("Tarefas", "-> Tapiocaria da Tânia", 4));

        // Texto criado em um documento que não existe - Falha
        exception = assertThrows(NoSuchElementException.class, () -> documinService.criarTexto("Receitas", "Bolos de cenoura e afins",2));
        assertEquals("O documento não existe na base de dados!", exception.getMessage());

        //Texto criado em um documento na capacidade máxima - Falha
        exception = assertThrows(IndexOutOfBoundsException.class, () -> documinService.criarTexto("Tarefas", "-> Construir um novo mundo", 4));
        assertEquals("Tamanho Máximo de Elementos foi atingido!",exception.getMessage());
    }
//    @Test
//    void moverElementoAcima(){
//        documentoController.criarTexto("Receitas Online", "Bolo de Milho e Tapiocas", 2);
//        ElementoAbstract elemento = documentoController.getElemento();
//
//        assertEquals();
//
//    }
    @Test
    void gerarRepresentacaoCompletaTexto(){
        //Pegar representação completa de um Elemento - Sucesso
        assertEquals("-> Construir uma casa", documinService.gerarRepresentacaoCompleta("Tarefas", 0));
        //Pegar representação completa de um elemento que não existe- Falha
        assertEquals("-> Construir uma casa", documinService.gerarRepresentacaoCompleta("Tarefas", 2));
        //Pegar representação completa de um elemente onde o documento não exisste

    }

}