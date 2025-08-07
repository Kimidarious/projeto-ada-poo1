import model.*;
import controller.*;
import java.time.LocalDate;


public class CatalogoExemplo {
    public static void carregarDadosExemplo(CatalogoAnimes catalogo) {

        // Estúdios
        Estudio ghibli = new Estudio("Studio Ghibli");
        Estudio toei = new Estudio("Toei Animation");
        Estudio madhouse = new Estudio("Madhouse");
        Estudio ufotable = new Estudio("Ufotable");
        Estudio bones = new Estudio("Bones");

        catalogo.adicionarEstudio(ghibli);
        catalogo.adicionarEstudio(toei);
        catalogo.adicionarEstudio(madhouse);
        catalogo.adicionarEstudio(ufotable);
        catalogo.adicionarEstudio(bones);

        // Diretores
        Diretor miyazaki = new Diretor("Hayao Miyazaki", "Japão", "Mestre da animação japonesa.", "Fantasia", "Ghibli", 50);
        Diretor araki = new Diretor("Tetsurou Araki", "Japão", "Diretor de Attack on Titan", "Ação", "Wit Studio", 20);
        Diretor hosoda = new Diretor("Mamoru Hosoda", "Japão", "Mistura ficção científica e emoção.", "Sci-Fi", "Madhouse", 25);

        catalogo.adicionarDiretor(miyazaki);
        catalogo.adicionarDiretor(araki);
        catalogo.adicionarDiretor(hosoda);

        // Dubladores
        Dublador megumi = new Dublador("Megumi Hayashibara", "Japonesa", "Famosa por vozes femininas icônicas.", "Feminina", "Estúdio A");
        megumi.adicionarPersonagemFamoso("Rei Ayanami");

        Dublador yuki = new Dublador("Yuki Kaji", "Japonês", "Voz do Eren em Attack on Titan", "Masculina", "Estúdio B");
        yuki.adicionarPersonagemFamoso("Eren Yeager");

        Dublador romi = new Dublador("Romi Park", "Japonesa", "Voz do Edward Elric", "Masculina", "Estúdio C");
        romi.adicionarPersonagemFamoso("Edward Elric");

        catalogo.adicionarDublador(megumi);
        catalogo.adicionarDublador(yuki);
        catalogo.adicionarDublador(romi);

        // Animes (10 exemplos)
        Anime chihiro = new Anime("A Viagem de Chihiro", LocalDate.of(2001, 7, 20), 19000000,
                "Uma garota entra em um mundo mágico para salvar seus pais.", "Fantasia", 1, ghibli);
        chihiro.setNota(9.5);

        Anime attackOnTitan = new Anime("Attack on Titan", LocalDate.of(2013, 4, 7), 3000000,
                "Humanidade vs Titãs num mundo brutal.", "Ação", 75, madhouse);
        attackOnTitan.setNota(9.0);

        Anime fullmetal = new Anime("Fullmetal Alchemist: Brotherhood", LocalDate.of(2009, 4, 5), 2500000,
                "Dois irmãos em busca da Pedra Filosofal.", "Aventura", 64, bones);
        fullmetal.setNota(9.2);

        Anime naruto = new Anime("Naruto", LocalDate.of(2002, 10, 3), 1000000,
                "Um ninja determinado quer ser Hokage.", "Aventura", 220, toei);
        naruto.setNota(8.5);

        Anime yourName = new Anime("Your Name", LocalDate.of(2016, 8, 26), 3000000,
                "Dois jovens trocam de corpo e tempo.", "Romance", 1, madhouse);
        yourName.setNota(8.9);

        Anime demonSlayer = new Anime("Demon Slayer", LocalDate.of(2019, 4, 6), 2000000,
                "Um jovem luta contra demônios após perder a família.", "Ação", 44, ufotable);
        demonSlayer.setNota(8.7);

        Anime spiritedAway = new Anime("Spirited Away", LocalDate.of(2001, 7, 20), 15000000,
                "Garota vai parar em mundo espiritual misterioso.", "Fantasia", 1, ghibli);
        spiritedAway.setNota(9.4);

        Anime bleach = new Anime("Bleach", LocalDate.of(2004, 10, 5), 1200000,
                "Ichigo é um Shinigami lutando contra Hollows.", "Ação", 366, toei);
        bleach.setNota(8.3);

        Anime deathNote = new Anime("Death Note", LocalDate.of(2006, 10, 3), 1800000,
                "Caderno da morte nas mãos erradas.", "Suspense", 37, madhouse);
        deathNote.setNota(9.1);

        Anime howl = new Anime("O Castelo Animado", LocalDate.of(2004, 11, 20), 14000000,
                "Jovem amaldiçoada encontra refúgio com mago excêntrico.", "Fantasia", 1, ghibli);
        howl.setNota(8.8);

        // Adicionar ao catálogo
        catalogo.adicionarFilme(chihiro);
        catalogo.adicionarFilme(attackOnTitan);
        catalogo.adicionarFilme(fullmetal);
        catalogo.adicionarFilme(naruto);
        catalogo.adicionarFilme(yourName);
        catalogo.adicionarFilme(demonSlayer);
        catalogo.adicionarFilme(spiritedAway);
        catalogo.adicionarFilme(bleach);
        catalogo.adicionarFilme(deathNote);
        catalogo.adicionarFilme(howl);

        // Associações (para alguns animes)
        catalogo.associarDiretorAoFilme(miyazaki, chihiro);
        catalogo.associarDiretorAoFilme(miyazaki, howl);
        catalogo.associarDiretorAoFilme(araki, attackOnTitan);
        catalogo.associarDiretorAoFilme(hosoda, yourName);

        catalogo.associarDubladorAoFilme(megumi, chihiro);
        catalogo.associarDubladorAoFilme(yuki, attackOnTitan);
        catalogo.associarDubladorAoFilme(romi, fullmetal);
    }
}
