package controller;

import java.time.LocalDate;
import java.util.ArrayList;
import model.*;

public class CatalogoAnimes {
    private ArrayList<Anime> animes;
    private ArrayList<Dublador> dubladores;
    private ArrayList<Dublador> seiyus;
    private ArrayList<Diretor> diretores;
    private ArrayList<Estudio> estudios;

    public CatalogoAnimes() {
        animes = new ArrayList<>();
        dubladores = new ArrayList<>();
        seiyus = new ArrayList<>();
        diretores = new ArrayList<>();
        estudios = new ArrayList<>();
    }

    // Getters
    public ArrayList<Anime> getAnimes() {
        return animes;
    }

    public ArrayList<Dublador> getDubladores() {
        return dubladores;
    }

    public ArrayList<Dublador> getSeiyus() {
        return seiyus;
    }

    public ArrayList<Diretor> getDiretores() {
        return diretores;
    }

    public ArrayList<Estudio> getEstudios() {
        return estudios;
    }

    // Métodos de cadastro
    public void adicionarAnime  (Anime anime) {
        if (!animes.contains(anime)) {
            animes.add(anime);
        }
    }

    public void adicionarDublador(Dublador dublador) {
        if (!dubladores.contains(dublador)) {
            dubladores.add(dublador);
        }
    }

    public void adicionarSeiyu(Dublador seiyu) {
        if (!seiyus.contains(seiyu)) {
            seiyus.add(seiyu);
        }
    }

    public void adicionarDiretor(Diretor diretor) {
        if (!diretores.contains(diretor)) {
            diretores.add(diretor);
        }
    }

    public void adicionarEstudio(Estudio estudio) {
        if (!estudios.contains(estudio)) {
            estudios.add(estudio);
        }
    }

    // Associação
    public void associarDubladorAoFilme(Dublador dublador, Anime anime) {
        if (animes.contains(anime) && dubladores.contains(dublador)) {
            anime.adicionarDublador(dublador);
        }
    }

    public void associarSeiyuAoFilme(Dublador seiyu, Anime anime) {
        if (animes.contains(anime) && seiyus.contains(seiyu)) {
            anime.adicionarDublador(seiyu);
        }
    }

    public void associarDiretorAoFilme(Diretor diretor, Anime anime) {
        if (animes.contains(anime) && diretores.contains(diretor)) {
            anime.setDiretor(diretor);
        }
    }

    public void associarEstudioAoFilme(Estudio estudio, Anime anime) {
        if (animes.contains(anime) && estudios.contains(estudio)) {
            anime.setEstudio(estudio);
        }
    }

    // Carregar dados salvos pelo gerenciador de dados
    public void carregarDados(ArrayList<Anime> animes, ArrayList<Dublador> dubladores, ArrayList<Dublador> seiyus,
                              ArrayList<Diretor> diretores, ArrayList<Estudio> estudios){
        this.animes = animes;
        this.dubladores = dubladores;
        this.seiyus = seiyus;
        this.diretores = diretores;
        this.estudios = estudios;

    }

    public static void main(String[] args) {
        CatalogoAnimes catalogoAnimes = new CatalogoAnimes();
        Estudio TMS = new Estudio("TMS");

        Anime akira = new Anime("Akira", LocalDate.of(1988,7,16),700000000,
                "primeira animação japonesa a ser exibida em cinemas brasileiros como um filme mainstream",
                "ficção científica",1);
        catalogoAnimes.adicionarAnime(akira);
        catalogoAnimes.adicionarEstudio(TMS);

        Dublador dublador = new Dublador("Wendel Bezerra", "brasileiro", "", "",
                "Álamo");

        Dublador seiyu = new Dublador("Mitsuo Iwata", "japonês", "", "",
                "");

        catalogoAnimes.adicionarDublador(dublador);
        catalogoAnimes.adicionarDublador(seiyu);

        System.out.println(catalogoAnimes.getAnimes().toString());
        System.out.println(dublador.toString());


        catalogoAnimes.associarEstudioAoFilme(TMS, akira);
        catalogoAnimes.associarDubladorAoFilme(dublador, akira);
        catalogoAnimes.associarDubladorAoFilme(seiyu, akira);
        System.out.println(catalogoAnimes.getAnimes().toString());
        System.out.println(akira.getElenco());

        GerenciadorDados gerenciador = new GerenciadorDados(catalogoAnimes);
        gerenciador.salvarDados("dados.txt");
    }
}

