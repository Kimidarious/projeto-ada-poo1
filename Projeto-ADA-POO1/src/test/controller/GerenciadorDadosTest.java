package controller;

import model.Anime;
import model.Dublador;
import model.Estudio;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class GerenciadorDadosTest {

    @Test
    void salvarDados() {
        CatalogoAnimes catalogo =  new CatalogoAnimes();
        GerenciadorDados gerenciador = new GerenciadorDados(catalogo);
        gerenciador.salvarDados("teste.txt");

        File arquivo = new File("teste.txt");
        assertTrue(arquivo.exists(), "O arquivo não foi criado.");
    }

    @Test
    void carregarDados() {
        // cria catálogo
        CatalogoAnimes catalogo =  new CatalogoAnimes();
        GerenciadorDados gerenciador = new GerenciadorDados(catalogo);

        // cria dados
        Estudio TMS = new Estudio("TMS");
        Anime akira = new Anime("Akira", LocalDate.of(1988,7,16),700000000,
                "primeira animação japonesa a ser exibida em cinemas brasileiros como um filme mainstream",
                "ficção científica",1);
        Dublador dublador = new Dublador("Wendel Bezerra", "brasileiro", "", "",
                "Álamo");
        Dublador seiyu = new Dublador("Mitsuo Iwata", "japonês", "", "",
                "");

        catalogo.adicionarAnime(akira);
        catalogo.adicionarEstudio(TMS);
        catalogo.adicionarDublador(dublador);
        catalogo.adicionarDublador(seiyu);
        gerenciador.salvarDados("teste.txt");

        //cria catálogo carregado
        CatalogoAnimes catalogo2 = new CatalogoAnimes();
        GerenciadorDados gerenciador2 = new GerenciadorDados(catalogo2);
        gerenciador2.carregarDados("teste.txt");

        assertEquals(catalogo2.getAnimes(),catalogo.getAnimes(), "animes não carregados.");
        assertEquals(catalogo2.getDiretores(),catalogo.getDiretores(), "diretores não carregados.");
        assertEquals(catalogo2.getDubladores(),catalogo.getDubladores(), "dubladores não carregados.");
        assertEquals(catalogo2.getSeiyus(),catalogo.getSeiyus(), "seiyus não carregados.");
        assertEquals(catalogo2.getEstudios().toString(),catalogo.getEstudios().toString(), "estudios não carregados.");
    }

    @AfterEach
    void limpar() {
        new File("teste.txt").delete();
    }
}