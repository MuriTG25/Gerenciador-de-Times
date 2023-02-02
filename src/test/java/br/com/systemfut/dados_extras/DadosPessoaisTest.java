package br.com.systemfut.dados_extras;

import br.com.systemfut.exception.InvalidNumberException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.DateTimeException;

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
        Assertions.assertThrows(InvalidNumberException.class,() -> pessoal.setRG(12345678L));
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
        Assertions.assertThrows(InvalidNumberException.class,() -> pessoal.setRG(12345678901L));
    }
    @Test
    public void TestaDataDeNascimentoEIdade(){
        criacaoDeClasse();
        pessoal.setDataDeNascimento(20,01,1992);
        String dataDeNascimento = pessoal.getDataDeNascimento();
        assertEquals("20/01/1992",dataDeNascimento);
        int idade = pessoal.getIdade();
        assertEquals(31,idade);
        pessoal.setDataDeNascimento(25,12,1992);
        int idade2 = pessoal.getIdade();
        assertEquals(30,idade2);
        pessoal.setDataDeNascimento(25,12,2015);
        int idade3 = pessoal.getIdade();
        assertEquals(7,idade3);
    }
    @Test
    public void TestaDatasInvalidasDeDiaMesEDia2902ForaDeAnoBissexto(){
        criacaoDeClasse();
        assertThrows(DateTimeException.class,() -> pessoal.setDataDeNascimento(33,06,2020));
        assertThrows(DateTimeException.class,() -> pessoal.setDataDeNascimento(30,13,2020));
        assertThrows(DateTimeException.class,() -> pessoal.setDataDeNascimento(29,02,2021));
    }
}