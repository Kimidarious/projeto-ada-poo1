package model;

import java.io.Serializable;
import java.time.format.DateTimeFormatter;

public class Estudio implements Serializable {

    private final String nome;

    public Estudio(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("=== Estudio ===\n");
        sb.append(String.format("Nome: %s\n", nome));

        return sb.toString();
    }
}
