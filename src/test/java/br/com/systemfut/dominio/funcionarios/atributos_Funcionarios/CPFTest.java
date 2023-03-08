package br.com.systemfut.dominio.funcionarios.atributos_Funcionarios;

import br.com.systemfut.aplicacao.exception.ValorInvalidoException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CPFTest {
    @Test
    public void TestaCPFValido(){
        CPF cpf = new CPF("15297655870");
        assertEquals("15297655870",cpf.imprimeCPF());
    }
    @Test
    public void TestaCPFInvalidoComMenosDe11Digitos(){
        assertThrows(ValorInvalidoException.class,() -> new CPF("1234567890"));
    }
    @Test
    public void TestaCPFInvalidoCom11DigitosRepetidos(){
        assertThrows(ValorInvalidoException.class,() -> new CPF("11111111111"));
    }
    @Test
    public void TestaCPFInvalidoCom11DigitosENumerosInvalidos(){
        assertThrows(ValorInvalidoException.class,() -> new CPF("12345678901"));
    }
    @Test
    public void TestaCPFInvalidoComMaisDe11Digitos(){
        assertThrows(ValorInvalidoException.class,() -> new CPF("123456789012"));
    }

}