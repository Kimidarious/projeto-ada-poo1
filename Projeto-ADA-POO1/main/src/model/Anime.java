package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe que representa um Anime no sistema do catálogo
 * Contém informações sobre o anime, diretor e elenco de dublagem
 * @Author Eliakim Simões
 * @version 1.0.0
 */
public class Anime {
    private String nome;
    private LocalDate dataLancamento;
    private double orcamento;
    private String descricao;
    private Diretor diretor;
    private List<Dublador> elenco;
    private String genero;
    private int episodios;
    private Estudio estudio;
    private String status;
    private double nota;

    public Anime(String nome, LocalDate dataLancamento, double orcamento,
                 String descricao, String genero, int episodios,
                 Estudio estudio) {
        this.nome = nome;
        this.dataLancamento = dataLancamento;
        this.orcamento = orcamento;
        this.descricao = descricao;
        this.genero = genero;
        this.episodios = episodios;
        this.estudio = estudio;
        this.elenco = new ArrayList<>();
        this.status = "Em exibição";
        this.nota = 0.0;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome != null && !nome.trim().isEmpty()) {
            this.nome = nome.trim();
        }
    }

    public LocalDate getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(LocalDate dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public double getOrcamento() {
        return orcamento;
    }

    public void setOrcamento(double orcamento) {
        if (orcamento >= 0) {
            this.orcamento = orcamento;
        }
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Diretor getDiretor() {
        return diretor;
    }

    public void setDiretor(Diretor diretor) {
        this.diretor = diretor;
    }

    public List<Dublador> getElenco() {
        return new ArrayList<>(elenco);
    }

    public void setElenco(List<Dublador> elenco) {
        this.elenco = elenco;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getEpisodios() {
        return episodios;
    }

    public void setEpisodios(int episodios) {
        if (episodios > 0) {
            this.episodios = episodios;
        }
    }

    public Estudio getEstudio() {
        return estudio;
    }

    public void setEstudio(Estudio estudio) {
        this.estudio = estudio;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        if (nota >= 0 && nota <= 10) {
            this.nota = nota;
        }
    }

    public void adicionarDublador(Dublador dublador) {
        if (dublador != null && !elenco.contains(dublador)) {
            elenco.add(dublador);
        }
    }

    public void removerDublador(Dublador dublador) {
        elenco.remove(dublador);
    }

    public boolean contemNome(String nome) {

        if (nome == null || nome.trim().isEmpty()) {
            return false;
        }
        return nome.toLowerCase()
                    .contains(nome.toLowerCase().trim());
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        StringBuilder sb = new StringBuilder();

        sb.append("=== ANIME ===\n");
        sb.append(String.format("Nome: %s\n", nome));
        sb.append(String.format("Gênero: %s\n", genero != null ? genero : "N/A" ));
        sb.append(String.format("Estúdio: %s\n", estudio != null ? estudio : "N/A" ));
        sb.append(String.format("Episódios: %d\n", episodios));
        sb.append(String.format("Data de Lançamento: %s\n",
                                dataLancamento != null ?
                                        dataLancamento.format(
                                                formatter) : "N/A" ));
        sb.append(String.format("Orcamento: R$ %.2f\n", orcamento));
        sb.append(String.format("Nota: %.1f/10\n", nota));

        if (diretor != null) {
            sb.append(String.format("Diretor: %s\n", diretor.getNome()));
        }

        if (!elenco.isEmpty()) {
            sb.append("\nElenco de Dublagem:\n");
            for (Dublador dublador : elenco) {
                sb.append(String.format(" - %s\n", dublador.getNome()));
            }
        }

        if (descricao != null && !descricao.trim().isEmpty()) {
            sb.append(String.format("Descrição: %s\n", descricao));
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Anime anime = (Anime) obj;
        return nome != null ? nome.equalsIgnoreCase(anime.nome) :
                                anime.nome == null;
    }

    @Override
    public int hashCode() {
        return nome != null ? nome.toLowerCase().hashCode() : 0;
    }
}
