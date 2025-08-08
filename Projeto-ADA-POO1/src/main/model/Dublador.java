package model;

import java.util.ArrayList;
import java.util.List;

public class Dublador extends Pessoa {
    private String tipoVoz;
    private List<String> personagensFamosos;
    private String estudioDublagem;

    public Dublador(String nome, String nacionalidade, String biografia, String tipoVoz, String estudioDublagem) {
        super(nome, nacionalidade, biografia);
        this.tipoVoz = tipoVoz;
        this.personagensFamosos = new ArrayList<>();
        this.estudioDublagem = estudioDublagem;
    }

    public String getTipoVoz() {
        return tipoVoz;
    }

    public void setTipoVoz(String tipoVoz) {
        this.tipoVoz = tipoVoz;
    }

    public List<String> getPersonagensFamosos() {
        return new ArrayList<>(personagensFamosos);
    }

    public void setPersonagensFamosos(List<String> personagensFamosos) {
        this.personagensFamosos = personagensFamosos;
    }

    public String getEstudioDublagem() {
        return estudioDublagem;
    }

    public void setEstudioDublagem(String estudioDublagem) {
        this.estudioDublagem = estudioDublagem;
    }

    public void adicionarPersonagemFamoso(String personagem) {
        if (personagem != null && !personagem.trim().isEmpty()) {
            personagensFamosos.add(personagem.trim());
        }
    }

    public void removerPersonagemFamoso(String personagem) {
        personagensFamosos.remove(personagem);
    }

    @Override
    public String getPapel() {
        return "Ator de Dublagem";
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(String.format("\n\tTipo de voz: %s", tipoVoz != null ? tipoVoz : "N/A"));
        sb.append(String.format("\n\tEstúdio de dublagem: %s", estudioDublagem != null ? estudioDublagem : "N/A"));

        if (!personagensFamosos.isEmpty()) {
            sb.append("\n\tPersonagens famosos:");
            sb.append(String.join(", ", personagensFamosos));
        }
        return sb.toString();
    }
}
