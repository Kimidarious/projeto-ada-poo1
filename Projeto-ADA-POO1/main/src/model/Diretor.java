package model;

import java.util.ArrayList;
import java.util.List;

public class Diretor extends Pessoa {
    private String estilo;
    private List<String> premios;
    private String estudioPrincipal;
    private int anosExperiencia;

    public Diretor(String nome, String nacionalidade,
                   String biografia, String estilo,
                   String estudioPrincipal, int anosExperiencia) {
        super(nome, nacionalidade, biografia);
        this.estilo = estilo;
        this.premios = new ArrayList<>();
        this.estudioPrincipal = estudioPrincipal;
        this.anosExperiencia = anosExperiencia;
    }

    public String getEstilo() {
        return estilo;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }

    public List<String> getPremios() {
        return new ArrayList<>(premios);
    }

    public void setPremios(List<String> premios) {
        this.premios = premios;
    }

    public String getEstudioPrincipal() {
        return estudioPrincipal;
    }

    public void setEstudioPrincipal(String estudioPrincipal) {
        this.estudioPrincipal = estudioPrincipal;
    }

    public int getAnosExperiencia() {
        return anosExperiencia;
    }

    public void setAnosExperiencia(int anosExperiencia) {
        if (anosExperiencia >= 0){
            this.anosExperiencia = anosExperiencia;
        }
    }

    public void adicionarPremio(String premio) {
        if (premio != null && !premio.trim().isEmpty()) {
            premios.add(premio.trim());
        }
    }

    public void removerPremio(String premio) {
        premios.remove(premio);
    }

    /**
     * Implementação do método abstrato da classe pai
     *
     * @return papel especifico da pessoa
     */
    @Override
    public String getPapel() {
        return "Diretor de Anime";
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(String.format("\nEstilo do anime: %s", estilo !=
                                    null ? estilo : "N/A"));
        sb.append(String.format("\nEstúdio Principal: %s",
                                    estudioPrincipal != null ?
                                            estudioPrincipal :"N/A"));
        sb.append(String.format("\nExperiência: %d anos", anosExperiencia));

        if (!premios.isEmpty()) {
            sb.append("\nPremios:");
            sb.append(String.join(", ", premios));
        }
        return sb.toString();
    }
}
