package controller;

import model.Anime;
import model.Diretor;
import model.Dublador;
import model.Estudio;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
class CatalogoAnimesTest {

    @Test
    void getAnimes() {
        Anime akira = new Anime("Akira", LocalDate.of(1988,7,16),700000000,
                "primeira animação japonesa a ser exibida em cinemas brasileiros como um filme mainstream",
                "ficção científica",1);
        CatalogoAnimes catalogoAnimes = new CatalogoAnimes();
        catalogoAnimes.adicionarAnime(akira);

        assertEquals(1, catalogoAnimes.getAnimes().size());
        assertEquals("Akira", catalogoAnimes.getAnimes().getFirst().getNome());
    }

    @Test
    void getDubladores() {
        Dublador dublador = new Dublador("Wendel Bezerra", "brasileiro", "", "",
                "Álamo");
        CatalogoAnimes catalogoAnimes = new CatalogoAnimes();
        catalogoAnimes.adicionarDublador(dublador);

        assertEquals(1, catalogoAnimes.getDubladores().size());
        assertEquals("Wendel Bezerra", catalogoAnimes.getDubladores().getFirst().getNome());
    }

    @Test
    void getSeiyus() {
        Dublador seiyu = new Dublador("Mitsuo Iwata", "japonês", "", "",
                "");
        CatalogoAnimes catalogoAnimes = new CatalogoAnimes();
        catalogoAnimes.adicionarSeiyu(seiyu);

        assertEquals(1, catalogoAnimes.getSeiyus().size());
        assertEquals("Mitsuo Iwata", catalogoAnimes.getSeiyus().getFirst().getNome());
    }

    @Test
    void getDiretores() {
        Diretor miyazaki = new Diretor("Hayao Miyazaki", "Japão", "Mestre da animação japonesa.", "Fantasia", "Ghibli", 50);
        CatalogoAnimes catalogoAnimes = new CatalogoAnimes();
        catalogoAnimes.adicionarDiretor(miyazaki);
        assertEquals(1, catalogoAnimes.getDiretores().size());
        assertEquals("Hayao Miyazaki", catalogoAnimes.getDiretores().getFirst().getNome());
    }

    @Test
    void getEstudios() {
        Estudio TMS = new Estudio("TMS");
        CatalogoAnimes catalogoAnimes = new CatalogoAnimes();
        catalogoAnimes.adicionarEstudio(TMS);
        assertEquals(1, catalogoAnimes.getEstudios().size());
        assertEquals("TMS", catalogoAnimes.getEstudios().getFirst().getNome());
    }

    @Test
    void adicionarAnime() {
        Anime akira = new Anime("Akira", LocalDate.of(1988,7,16),700000000,
                "primeira animação japonesa a ser exibida em cinemas brasileiros como um filme mainstream",
                "ficção científica",1);
        CatalogoAnimes catalogoAnimes = new CatalogoAnimes();
        catalogoAnimes.adicionarAnime(akira);
        catalogoAnimes.adicionarAnime(akira);

        assertEquals(1, catalogoAnimes.getAnimes().size());
        assertEquals("Akira", catalogoAnimes.getAnimes().getFirst().getNome());
    }

    @Test
    void adicionarDublador() {
        Dublador dublador = new Dublador("Wendel Bezerra", "brasileiro", "", "",
                "Álamo");
        CatalogoAnimes catalogoAnimes = new CatalogoAnimes();
        catalogoAnimes.adicionarDublador(dublador);
        catalogoAnimes.adicionarDublador(dublador);

        assertEquals(1, catalogoAnimes.getDubladores().size());
        assertEquals("Wendel Bezerra", catalogoAnimes.getDubladores().getFirst().getNome());
    }

    @Test
    void adicionarSeiyu() {
        Dublador seiyu = new Dublador("Mitsuo Iwata", "japonês", "", "",
                "");
        CatalogoAnimes catalogoAnimes = new CatalogoAnimes();
        catalogoAnimes.adicionarSeiyu(seiyu);
        catalogoAnimes.adicionarSeiyu(seiyu);

        assertEquals(1, catalogoAnimes.getSeiyus().size());
        assertEquals("Mitsuo Iwata", catalogoAnimes.getSeiyus().getFirst().getNome());
    }

    @Test
    void adicionarDiretor() {
        Diretor miyazaki = new Diretor("Hayao Miyazaki", "Japão", "Mestre da animação japonesa.", "Fantasia", "Ghibli", 50);
        CatalogoAnimes catalogoAnimes = new CatalogoAnimes();
        catalogoAnimes.adicionarDiretor(miyazaki);
        catalogoAnimes.adicionarDiretor(miyazaki);

        assertEquals(1, catalogoAnimes.getDiretores().size());
        assertEquals("Hayao Miyazaki", catalogoAnimes.getDiretores().getFirst().getNome());
    }

    @Test
    void adicionarEstudio() {
        Estudio TMS = new Estudio("TMS");
        CatalogoAnimes catalogoAnimes = new CatalogoAnimes();
        catalogoAnimes.adicionarEstudio(TMS);
        catalogoAnimes.adicionarEstudio(TMS);

        assertEquals(1, catalogoAnimes.getEstudios().size());
        assertEquals("TMS", catalogoAnimes.getEstudios().getFirst().getNome());
    }

    @Test
    void associarDubladorAoFilme() {
        Anime akira = new Anime("Akira", LocalDate.of(1988,7,16),700000000,
                "primeira animação japonesa a ser exibida em cinemas brasileiros como um filme mainstream",
                "ficção científica",1);
        Dublador dublador = new Dublador("Wendel Bezerra", "brasileiro", "", "",
                "Álamo");
        CatalogoAnimes catalogoAnimes = new CatalogoAnimes();

        catalogoAnimes.associarDubladorAoFilme(dublador, akira);
        assertFalse(akira.getElenco().contains(dublador));
        catalogoAnimes.adicionarAnime(akira);
        catalogoAnimes.adicionarDublador(dublador);
        catalogoAnimes.associarDubladorAoFilme(dublador, akira);
        assertTrue(akira.getElenco().contains(dublador));
    }

    @Test
    void associarSeiyuAoFilme() {
        Anime akira = new Anime("Akira", LocalDate.of(1988,7,16),700000000,
                "primeira animação japonesa a ser exibida em cinemas brasileiros como um filme mainstream",
                "ficção científica",1);
        Dublador seiyu = new Dublador("Mitsuo Iwata", "japonês", "", "",
                "");
        CatalogoAnimes catalogoAnimes = new CatalogoAnimes();

        catalogoAnimes.associarSeiyuAoFilme(seiyu, akira);
        assertFalse(akira.getElenco().contains(seiyu));
        catalogoAnimes.adicionarAnime(akira);
        catalogoAnimes.adicionarSeiyu(seiyu);
        catalogoAnimes.associarSeiyuAoFilme(seiyu, akira);
        assertTrue(akira.getElenco().contains(seiyu));
    }

    @Test
    void associarDiretorAoFilme() {
        Anime akira = new Anime("Akira", LocalDate.of(1988,7,16),700000000,
                "primeira animação japonesa a ser exibida em cinemas brasileiros como um filme mainstream",
                "ficção científica",1);
        Diretor diretor = new Diretor("Katsuhiro Otomo","","","","",52);
        CatalogoAnimes catalogoAnimes = new CatalogoAnimes();

        catalogoAnimes.associarDiretorAoFilme(diretor, akira);
        assertNull(akira.getDiretor());
        catalogoAnimes.adicionarAnime(akira);
        catalogoAnimes.adicionarDiretor(diretor);
        catalogoAnimes.associarDiretorAoFilme(diretor, akira);
        assertEquals(diretor, akira.getDiretor());

    }

    @Test
    void associarEstudioAoFilme() {
        Anime akira = new Anime("Akira", LocalDate.of(1988,7,16),700000000,
                "primeira animação japonesa a ser exibida em cinemas brasileiros como um filme mainstream",
                "ficção científica",1);
        Estudio TMS = new Estudio("TMS");
        CatalogoAnimes catalogoAnimes = new CatalogoAnimes();

        catalogoAnimes.associarEstudioAoFilme(TMS, akira);
        assertNull(akira.getEstudio());
        catalogoAnimes.adicionarEstudio(TMS);
        catalogoAnimes.adicionarAnime(akira);
        catalogoAnimes.associarEstudioAoFilme(TMS, akira);
        assertEquals(TMS, akira.getEstudio());
    }

    @Test
    void carregarDados() {
        ArrayList<Anime> animes = new ArrayList<>();
        ArrayList<Dublador> dubladores = new ArrayList<>();
        ArrayList<Dublador> seiyus = new ArrayList<>();
        ArrayList<Diretor> diretores = new ArrayList<>();
        ArrayList<Estudio> estudios = new ArrayList<>();

        Anime akira = new Anime("Akira", LocalDate.of(1988,7,16),700000000,
                "primeira animação japonesa a ser exibida em cinemas brasileiros como um filme mainstream",
                "ficção científica",1);
        Dublador dublador = new Dublador("Wendel Bezerra", "brasileiro", "", "",
                "Álamo");
        Dublador seiyu = new Dublador("Mitsuo Iwata", "japonês", "", "",
                "");
        Diretor diretor = new Diretor("Katsuhiro Otomo","","","","",52);
        Estudio TMS = new Estudio("TMS");

        animes.add(akira);
        dubladores.add(dublador);
        seiyus.add(seiyu);
        diretores.add(diretor);
        estudios.add(TMS);

        CatalogoAnimes catalogoAnimes = new CatalogoAnimes();
        catalogoAnimes.carregarDados(animes, dubladores, seiyus, diretores, estudios);

        assertEquals(animes, catalogoAnimes.getAnimes());
        assertEquals(dubladores, catalogoAnimes.getDubladores());
        assertEquals(seiyus, catalogoAnimes.getSeiyus());
        assertEquals(diretores, catalogoAnimes.getDiretores());
        assertEquals(estudios, catalogoAnimes.getEstudios());
    }
}