package br.com.systemfut.dominio.funcionarios.dados_extras.atribitos_dados_pessoais;

import br.com.systemfut.aplicacao.exception.ValorInvalidoException;
import br.com.systemfut.dominio.funcionarios.atributos_Funcionarios.CPF;
import br.com.systemfut.dominio.funcionarios.funcionarios_gerais.FuncionariosComum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TelefoneTest {

    @Test
    public void TestaTelefoneValidoCom9digitos(){
        Telefone telefone = new Telefone("11", "975431555");
        assertEquals("11975431555",telefone.getTelefone());
    }
    @Test
    public void TestaTelefoneValidoCom8digitos(){
        Telefone telefone = new Telefone("11", "40213264");
        assertEquals("1140213264",telefone.getTelefone());
    }
    @Test
    public void TestaTelefoneInvalidoComValorVazio(){
        assertThrows(ValorInvalidoException.class, () -> new Telefone("", ""));
    }
    @Test
    public void TestaTelefoneInvalidoComDDDComMenosDe2Digitos(){
        assertThrows(ValorInvalidoException.class, () -> new Telefone("1", "40213264"));
    }
    @Test
    public void TestaTelefoneInvalidoComDDDComMaisDe2Digitos(){
        assertThrows(ValorInvalidoException.class, () -> new Telefone("111", "40213264"));
    }
    @Test
    public void TestaTelefoneInvalidoComNumeroComMenosDe8Digitos(){
        assertThrows(ValorInvalidoException.class, () -> new Telefone("111", "4021326"));
    }
    @Test
    public void TestaTelefoneInvalidoComNumeroComMaisDe9Digitos(){
        assertThrows(ValorInvalidoException.class, () -> new Telefone("111", "4021326445"));
    }
}