package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EstudioTest {

    @Test
    void getNome() {
        Estudio TMS = new Estudio("TMS");
        assertEquals("TMS", TMS.getNome());
    }
}