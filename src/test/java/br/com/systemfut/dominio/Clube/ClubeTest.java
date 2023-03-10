package br.com.systemfut.dominio.Clube;

import br.com.systemfut.aplicacao.exception.ValorInvalidoException;
import br.com.systemfut.dominio.Clube.valores.CNPJ;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClubeTest {

    @Test
    public void TestaIntegracaoComAClasseDeCNPJ(){
        var c1 = new Clube("Matonense",
                new CNPJ("60340818000185"),"Matonense Futebol Clube");
        var cnpj = c1.getCNPJ();
        assertEquals("60340818000185",cnpj);
    }
}