package util;
// Classe de Teste (pode ser TesteCatalogo.java)
import controller.CatalogoAnimes;
import controller.GerenciadorDados;

public class TesteCatalogo {
    public static CatalogoAnimes gerarCatalogoExemplo() {
        CatalogoAnimes catalogo = new CatalogoAnimes();
        CatalogoExemplo.carregarDadosExemplo(catalogo);
        GerenciadorDados gerenciador = new GerenciadorDados(catalogo);
        gerenciador.salvarDados("Exemplo.txt");
        return catalogo;
    }

    public static void main(String[] args) {
        CatalogoAnimes catalogo = gerarCatalogoExemplo();
        catalogo.getAnimes().forEach(System.out::println);
    }
}