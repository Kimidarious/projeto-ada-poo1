// SistemaBusca.java
package sistema;

import model.Anime;

import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class SistemaBusca {

    public static List<Anime> buscarPorNome(List<Anime> lista, String termo) {
        return lista.stream()
                .filter(anime -> anime.getNome().toLowerCase(Locale.ROOT)
                        .contains(termo.toLowerCase(Locale.ROOT)))
                .collect(Collectors.toList());
    }

    public static List<Anime> filtrarPorGenero(List<Anime> lista, String genero) {
        String generoBusca = genero.toLowerCase();
        return lista.stream()
                .filter(anime -> anime.getGenero() != null &&
                        anime.getGenero().toLowerCase().contains(generoBusca))
                .collect(Collectors.toList());
    }


    public static List<Anime> ordenarPorNota(List<Anime> lista) {
        return lista.stream()
                .sorted(Comparator.comparingDouble(Anime::getNota).reversed())
                .collect(Collectors.toList());
    }

    public static double calcularMediaEpisodios(List<Anime> lista) {
        return lista.stream()
                .mapToInt(Anime::getEpisodios)
                .average()
                .orElse(0);
    }

    public static List<Anime> buscarPorDublador(List<Anime> animes, String nomeDublador) {
        return animes.stream()
                .filter(anime -> anime.getElenco().stream()
                        .anyMatch(d -> d.getNome().toLowerCase().contains(nomeDublador.toLowerCase()))
                )
                .collect(Collectors.toList());
    }

    public static List<Anime> buscarPorDiretor(List<Anime> animes, String nomeDiretor) {
        return animes.stream()
                .filter(anime -> anime.getDiretor() != null &&
                        anime.getDiretor().getNome().toLowerCase().contains(nomeDiretor.toLowerCase())
                )
                .collect(Collectors.toList());
    }


}