package controller;

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

    // Métodos de cadastro
    public void adicionarFilme(Anime anime) {
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

    public void associarEstudioAoFilme(Estudio estudio, Anime anime){
        if (animes.contains(anime) && estudios.contains(estudio)) {
            anime.setEstudio(estudio);
        }
    }
}

