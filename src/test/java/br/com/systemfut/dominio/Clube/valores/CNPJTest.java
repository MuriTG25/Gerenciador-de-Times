package br.com.systemfut.dominio.Clube.valores;

import br.com.systemfut.aplicacao.exception.ValorInvalidoException;
import br.com.systemfut.dominio.funcionarios.atributos_Funcionarios.CPF;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CNPJTest {
    @Test
    public void TestaCNPJValido(){
        CNPJ cnpj = new CNPJ("60340818000185");
        assertEquals("60340818000185",cnpj.getCNPJ());
    }
    @Test
    public void TestaCNPJInvalidoComMenosDe14Digitos(){
        assertThrows(ValorInvalidoException.class,() -> new CPF("6034081800018"));
    }
    @Test
    public void TestaCNPJInvalidoCom14DigitosRepetidos(){
        assertThrows(ValorInvalidoException.class,() -> new CPF("11111111111111"));
    }
    @Test
    public void TestaCNPJInvalidoCom14DigitosENumerosInvalidos(){
        assertThrows(ValorInvalidoException.class,() -> new CPF("12345678901234"));
    }
    @Test
    public void TestaCNPJInvalidoComMaisDe14Digitos(){
        assertThrows(ValorInvalidoException.class,() -> new CPF("123456789012345"));
    }
}