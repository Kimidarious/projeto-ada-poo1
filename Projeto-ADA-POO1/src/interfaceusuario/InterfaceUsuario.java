// InterfaceUsuario.java
package interfaceusuario;

import controller.CatalogoAnimes;
import model.Anime;
import sistema.SistemaBusca;

import java.util.List;
import java.util.Scanner;

public class InterfaceUsuario {
    private CatalogoAnimes catalogo;
    private Scanner scanner;

    public InterfaceUsuario(CatalogoAnimes catalogo) {
        this.catalogo = catalogo;
        this.scanner = new Scanner(System.in);
    }

    public void executar() {
        int opcao;
        do {
            exibirMenu();
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> listarAnimes();
                case 2 -> buscarAnimePorNome();
                case 3 -> filtrarPorGenero();
                case 4 -> ordenarPorNota();
                case 5 -> exibirEstatisticas();
                case 0 -> System.out.println("Encerrando...");
                default -> System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    private void exibirMenu() {
        System.out.println("\n===== Catálogo de Animes =====");
        System.out.println("1. Listar todos os animes");
        System.out.println("2. Buscar anime por nome");
        System.out.println("3. Filtrar animes por gênero");
        System.out.println("4. Ordenar animes por nota");
        System.out.println("5. Exibir estatísticas");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private void listarAnimes() {
        List<Anime> lista = catalogo.getAnimes();
        lista.forEach(System.out::println);
    }

    private void buscarAnimePorNome() {
        System.out.print("Digite o nome do anime: ");
        String nome = scanner.nextLine();
        List<Anime> resultados = SistemaBusca.buscarPorNome(catalogo.getAnimes(), nome);
        resultados.forEach(System.out::println);
    }

    private void filtrarPorGenero() {
        System.out.print("Digite o gênero: ");
        String genero = scanner.nextLine();
        List<Anime> filtrados = SistemaBusca.filtrarPorGenero(catalogo.getAnimes(), genero);
        filtrados.forEach(System.out::println);
    }

    private void ordenarPorNota() {
        List<Anime> ordenados = SistemaBusca.ordenarPorNota(catalogo.getAnimes());
        ordenados.forEach(System.out::println);
    }

    private void exibirEstatisticas() {
        double mediaEpisodios = SistemaBusca.calcularMediaEpisodios(catalogo.getAnimes());
        System.out.printf("Média de episódios: %.2f\n", mediaEpisodios);
    }
}
