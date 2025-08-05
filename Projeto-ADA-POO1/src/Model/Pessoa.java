package Model;

import java.time.LocalDate;

/**
* Classe abstrata que representa uma pessoa no sistema de catálogo de animes
*Serve como base para Seiyuu (dublador) e Diretor, implementando atributos  e métodos comuns
* @author Eliakim Simões
 * @version 1.0.0
 */

public abstract class Pessoa {
    private String nome;
    private String nacionalidade;
    private String biografia;

    public Pessoa(String nome, String nacionalidade, String biografia) {
        this.nome = nome;
        this.nacionalidade = nacionalidade;
        this.biografia = biografia;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome != null || !nome.trim().isEmpty()) {
            this.nome = nome.trim();
        }
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    /**
     * Método abstrato que deve ser implementado pelas classes filhas
     * para retornar o papel especifico de pessoa no anime
     * @return String descrevendo o pessoal da pessoa
     */
    public abstract String getPapel();

    @Override
    public String toString() {
        return String.format("%s  - %s (%s)",
                             nome,
                             getPapel(),
                             nacionalidade != null ? nacionalidade : "N/A";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Pessoa pessoa = (Pessoa) obj;
        return nome != null ? nome.equalsIgnoreCase(pessoa.nome) :
                                pessoa.nome == null;
    }

    @Override
    public int hashCode() {
        return nome != null ? nome.toLowerCase().hashCode() : 0;
    }
}
