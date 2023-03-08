package br.com.systemfut.dominio.funcionarios;

import br.com.systemfut.dominio.funcionarios.atletas_e_comissao.Jogadores;
import br.com.systemfut.dominio.funcionarios.atributos_Funcionarios.CPF;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.DateTimeException;

import static org.junit.jupiter.api.Assertions.*;

class FuncionariosTest {
    Jogadores funcionario;
    @BeforeEach
    public void criaJogadorEClube() {
        funcionario = new Jogadores("Lucas",
                new CPF("30044943024"), "Atacante");
    }
    @Test
    public void TestaDataDeAdmisaoDoJogador(){
        funcionario.setDataDeAdmissao(25,04,2016);
        String dataDeAdmissao = funcionario.getDataDeAdmissao();
        assertEquals("25/04/2016",dataDeAdmissao);
        String tempoDeTrabalho = funcionario.tempoDeTrabalho().toString();
        assertEquals("P6Y10M3D",tempoDeTrabalho);
    }
    @Test
    public void TestaDatasInvalidasDeDiaMesEDia2902ForaDeAnoBissexto(){
        assertThrows(DateTimeException.class,() -> funcionario.setDataDeAdmissao(33,06,2020));
        assertThrows(DateTimeException.class,() -> funcionario.setDataDeAdmissao(30,13,2020));
        assertThrows(DateTimeException.class,() -> funcionario.setDataDeAdmissao(29,02,2021));
    }

}