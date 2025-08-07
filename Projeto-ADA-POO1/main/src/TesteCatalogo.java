// Classe de Teste (pode ser TesteCatalogo.java)
import controller.CatalogoAnimes;
import controller.GerenciadorDados;

public class TesteCatalogo {
    public static void main(String[] args) {
        CatalogoAnimes catalogo = new CatalogoAnimes();
        GerenciadorDados.carregarDadosExemplo(catalogo);
        catalogo.getAnimes().forEach(System.out::println);
    }
}