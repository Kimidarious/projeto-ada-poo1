package controller;

import java.io.*;
import java.util.ArrayList;

import model.*;

public class GerenciadorDados {
    private final CatalogoAnimes catalogo;

    public GerenciadorDados(CatalogoAnimes catalogoAnimes){
        this.catalogo = catalogoAnimes;
    }

    public void salvarDados(String fileName){
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(catalogo.getAnimes());
            oos.writeObject(catalogo.getDubladores());
            oos.writeObject(catalogo.getSeiyus());
            oos.writeObject(catalogo.getDiretores());
            oos.writeObject(catalogo.getEstudios());
            System.out.println("Dados salvos com sucesso.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void carregarDados(String fileName) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            ArrayList<Anime> animes = (ArrayList<Anime>) ois.readObject();
            ArrayList<Dublador> dubladores = (ArrayList<Dublador>) ois.readObject();
            ArrayList<Dublador> seiyus = (ArrayList<Dublador>) ois.readObject();
            ArrayList<Diretor> diretores = (ArrayList<Diretor>) ois.readObject();
            ArrayList<Estudio> estudios = (ArrayList<Estudio>) ois.readObject();
            catalogo.carregarDados(animes, dubladores, seiyus, diretores, estudios);
            System.out.println("Dados carregados com sucesso.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        CatalogoAnimes catalogoAnimes = new CatalogoAnimes();
        GerenciadorDados gerenciador = new GerenciadorDados(catalogoAnimes);
        gerenciador.carregarDados("dados.txt");
        System.out.println(catalogoAnimes.getAnimes());
    }
}
