package br.com.systemfut.dados_extras;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DadosPessoaisTest {
    DadosPessoais pessoal;
    @BeforeEach
    public void criacaoDeClasse(){
        pessoal = new DadosPessoais();
    }
    @Test
    public void VerificaRGcomMenosDe9digitos(){
        criacaoDeClasse();
        Assertions.assertThrows(ArithmeticException.class,() -> pessoal.setRG(12345678L));
    }
    @Test
    public void VerificaRGValidocom9digitos(){
        criacaoDeClasse();
        pessoal.setRG(497571345L);
        var rg = pessoal.getRG();
        Assertions.assertEquals(497571345L,rg);
    }
    @Test
    public void VerificaRGcomMaisDe9digitos(){
        criacaoDeClasse();
        Assertions.assertThrows(ArithmeticException.class,() -> pessoal.setRG(12345678901L));
    }
}