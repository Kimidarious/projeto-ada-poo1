// Classe de Teste (pode ser TesteCatalogo.java)
import controller.CatalogoAnimes;
import controller.GerenciadorDados;

public class TesteCatalogo {
    public static void main(String[] args) {
        CatalogoAnimes catalogo = new CatalogoAnimes();
        CatalogoExemplo.carregarDadosExemplo(catalogo);
        GerenciadorDados gerenciador = new GerenciadorDados(catalogo);
        gerenciador.salvarDados("Exemplo.txt");
        catalogo.getAnimes().forEach(System.out::println);
    }
}