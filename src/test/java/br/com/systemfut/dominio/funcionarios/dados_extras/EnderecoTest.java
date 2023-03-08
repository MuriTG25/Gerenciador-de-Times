package br.com.systemfut.dominio.funcionarios.dados_extras;

import br.com.systemfut.aplicacao.exception.ValorInvalidoException;
import br.com.systemfut.dominio.funcionarios.atletas_e_comissao.Jogadores;
import br.com.systemfut.dominio.funcionarios.atributos_Funcionarios.CPF;
import br.com.systemfut.dominio.funcionarios.dados_extras.Endereco;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EnderecoTest {
    Endereco endereco;
    Jogadores j1;
    @BeforeEach
    public void criacaoDeClasse(){
        endereco = new Endereco();
        j1 = new Jogadores("Lucas",
                new CPF("98004712002"),"Atacante");
    }
    @Test
    public void TestaIntegracaoComClasseDeFuncionarios(){
        j1.setEndereco(endereco);
        j1.getEndereco().setCidade("Salto");
        String cidade = j1.getEndereco().getCidade();
        assertEquals("Salto",cidade);
    }
    @Test
    public void TestaCepInvalidoComMenosDe8Digitos(){
        assertThrows(ValorInvalidoException.class,() ->endereco.setCEP(1234567));
    }
    @Test
    public void TestaCepValidoCom8Digitos(){
        endereco.setCEP(12345678);
        assertEquals(12345678,endereco.getCEP());
    }
    @Test
    public void TestaCepInvalidoComMaisDe8Digitos(){
        assertThrows(ValorInvalidoException.class,() ->endereco.setCEP(123456789));
    }
}