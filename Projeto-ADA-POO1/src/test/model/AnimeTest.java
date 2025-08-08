package model;

import util.*;
import controller.CatalogoAnimes;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class AnimeTest {

    @Test
    void getNome(){
        CatalogoAnimes catalogo = TesteCatalogo.gerarCatalogoExemplo();
        Anime anime = catalogo.getAnimes().getFirst();
        assertEquals("A Viagem de Chihiro", anime.getNome());
    }

    @Test
    void setNome(){
        Anime akira = new Anime("", LocalDate.of(1988,7,16),700000000,
                "primeira animação japonesa a ser exibida em cinemas brasileiros como um filme mainstream",
                "ficção científica",1);
        akira.setNome("Akira");
        assertEquals("Akira", akira.getNome());
    }

    @Test
    void getDataLancamento(){
        CatalogoAnimes catalogo = TesteCatalogo.gerarCatalogoExemplo();
        Anime anime = catalogo.getAnimes().getFirst();
        assertEquals(LocalDate.of(2001,7,20), anime.getDataLancamento());
    }

    @Test
    void setDataLancamento(){
        Anime akira = new Anime("Akira", LocalDate.now(),700000000,
                "primeira animação japonesa a ser exibida em cinemas brasileiros como um filme mainstream",
                "ficção científica",1);
        LocalDate dataLancamento = LocalDate.of(1988,7,16);
        akira.setDataLancamento(dataLancamento);
        assertEquals(dataLancamento, akira.getDataLancamento());
    }

    @Test
    void getOrcamento(){
        CatalogoAnimes catalogo = TesteCatalogo.gerarCatalogoExemplo();
        Anime anime = catalogo.getAnimes().getFirst();
        assertEquals(19000000,  anime.getOrcamento());
    }

    @Test
    void setOrcamento(){
        Anime akira = new Anime("Akira", LocalDate.now(),700000000,
                "primeira animação japonesa a ser exibida em cinemas brasileiros como um filme mainstream",
                "ficção científica",1);
        Double orcamento = 700000000.00;
        akira.setOrcamento(orcamento);
        assertEquals(orcamento, akira.getOrcamento());
    }

    @Test
    void getDescricao(){
        CatalogoAnimes catalogo = TesteCatalogo.gerarCatalogoExemplo();
        Anime anime = catalogo.getAnimes().getFirst();
        String descricao = "Uma garota entra em um mundo mágico para salvar seus pais.";
        assertEquals(descricao, anime.getDescricao());
    }

    @Test
    void setDescricao(){
        String texto = "primeira animação japonesa a ser exibida em cinemas brasileiros como um filme mainstream";
        Anime akira = new Anime("Akira", LocalDate.now(),700000000,
                "",
                "ficção científica",1);
        akira.setDescricao(texto);
        assertEquals(texto, akira.getDescricao());
    }
}
