// InterfaceUsuario.java
package interfaceusuario;

import controller.CatalogoAnimes;
import model.Anime;
import sistema.SistemaBusca;

import java.util.List;
import java.util.Scanner;

public class InterfaceUsuario {
    private final CatalogoAnimes catalogo;
    private final Scanner scanner;

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

                case 3 -> {
                    System.out.print("Digite o nome do dublador: ");
                    String nomeElenco = scanner.nextLine();
                    List<Anime> animesDublador = SistemaBusca.buscarPorDublador(catalogo.getAnimes(), nomeElenco);
                    animesDublador.forEach(System.out::println);
                }

                case 4 -> {
                    System.out.print("Digite o nome do diretor: ");
                    String nomeDiretor = scanner.nextLine();
                    List<Anime> animesDiretor = SistemaBusca.buscarPorDiretor(catalogo.getAnimes(), nomeDiretor);
                    animesDiretor.forEach(System.out::println);
                }

                case 5 -> filtrarPorGenero();
                case 6 -> ordenarPorNota();
                case 7 -> exibirEstatisticas(catalogo);
                case 0 -> System.out.println("Encerrando...");
                default -> System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    private void exibirMenu() {
        System.out.println("\n===== Catálogo de Animes =====");
        System.out.println("1. Listar todos os animes");
        System.out.println("2. Buscar anime por nome");
        System.out.println("3. Buscar animes por dublador");
        System.out.println("4. Buscar animes por diretor");
        System.out.println("5. Filtrar animes por gênero");
        System.out.println("6. Ordenar animes por nota");
        System.out.println("7. Exibir estatísticas");

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

    public static void exibirEstatisticas(CatalogoAnimes catalogo) {
        List<Anime> animes = catalogo.getAnimes();

        System.out.println("\n===== ESTATÍSTICAS =====");

        System.out.println("Total de animes: " + animes.size());

        double media = 0;
        double maiorNota = Double.MIN_VALUE;
        double menorNota = Double.MAX_VALUE;
        String animeMaior = "", animeMenor = "";

        for (Anime a : animes) {
            double nota = a.getNota();
            media += nota;

            if (nota > maiorNota) {
                maiorNota = nota;
                animeMaior = a.getNome();
            }

            if (nota < menorNota) {
                menorNota = nota;
                animeMenor = a.getNome();
            }
        }

        if (!animes.isEmpty()) {
            media /= animes.size();
            System.out.printf("Média das notas: %.2f%n", media);
            System.out.println("Maior nota: " + animeMaior + " (" + maiorNota + ")");
            System.out.println("Menor nota: " + animeMenor + " (" + menorNota + ")");

            double mediaEpisodios = SistemaBusca.calcularMediaEpisodios(animes);
            System.out.printf("Média de episódios: %.2f%n", mediaEpisodios);
        }
    }




}
