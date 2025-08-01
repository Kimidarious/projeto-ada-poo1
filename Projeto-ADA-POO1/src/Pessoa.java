/**
* Classe abstrata que representa uma pessoa no sistema de catálogo de animes
*Serve como base para Seiyuu (dublador) e Diretor, implementando atributos  e métodos comuns
* @author Eliakim Simões
 * @version 1.0.0
 */

public abstract class Pessoa {
    private String nome;
    private String nomeJapones;
    private String dataNascimento;
    private String nacionalidade;
    private String biografia;

    public Pessoa(String nome, String nomeJapones, String dataNascimento, String nacionalidade, String biografia) {
        this.nome = nome;
        this.nomeJapones = nomeJapones;
        this.dataNascimento = dataNascimento;
        this.nacionalidade = nacionalidade;
        this.biografia = biografia;
    }

    public Pessoa(String nome, String dataNascimento) {
        this(nome, "", dataNascimento, "", "");
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeJapones() {
        return nomeJapones;
    }

    public void setNomeJapones(String nomeJapones) {
        this.nomeJapones = nomeJapones;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
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
     * para retornar o tipo especifico de pessoa (Seiyuu, Diretor, etc)
     * @return tipo de pessoa
     */
    public abstract String getTipo();

    /**
     * Método abstrato para exibir informações especificas da pessoa
     * Implementação varia de acordo com o tipo(Seiyuu, diretor)
     * @return informações especificas formatadas
     */
    public abstract String getInformacoesEspecificas();

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nome: ").append(nome);
        if (!nomeJapones.isEmpty()) {
            sb.append(" (").append(nomeJapones).append(")");
        }
        sb.append("\nData de nascimento: ").append(dataNascimento)
          .append("\nNacionalidade: ").append(nacionalidade)
          .append("\nBiografia: ").append(biografia)
          .append("\n").append(getInformacoesEspecificas());
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Pessoa pessoa = (Pessoa) obj;
        return nome.equalsIgnoreCase(pessoa.nome) &&
                dataNascimento.equalsIgnoreCase(pessoa.dataNascimento);
    }

    @Override
    public int hashCode() {
        return nome.toLowerCase().hashCode() + dataNascimento.hashCode();
    }
}
