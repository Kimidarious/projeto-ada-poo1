// Main.java
import controller.CatalogoAnimes;
import controller.GerenciadorDados;
import interfaceusuario.InterfaceUsuario;

public class Main {
    public static void main(String[] args) {
        CatalogoAnimes catalogo = new CatalogoAnimes();
        GerenciadorDados gerenciador = new GerenciadorDados(catalogo);
        gerenciador.carregarDados("Exemplo.txt");
        InterfaceUsuario interfaceUsuario = new InterfaceUsuario(catalogo);
        interfaceUsuario.executar();
    }
}