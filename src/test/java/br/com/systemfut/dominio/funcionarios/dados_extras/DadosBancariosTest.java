package br.com.systemfut.dominio.funcionarios.dados_extras;

import br.com.systemfut.dominio.funcionarios.atributos_Funcionarios.CPF;
import br.com.systemfut.dominio.funcionarios.dados_extras.atributos_dados_bancarios.GrupoDaDataDePagamento;
import br.com.systemfut.dominio.funcionarios.funcionarios_gerais.FuncionariosComum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DadosBancariosTest {
    FuncionariosComum funcionario;
    DadosBancarios bancarios;

    @BeforeEach
    public void iniciaDados(){
        bancarios = new DadosBancarios();
        funcionario = new FuncionariosComum("Maicon",
                new CPF("20434949027"), "Auxiliar de Limpeza Junior");
    }

    @Test
    public void TestaIntegracaoDeDadosBancariosComFuncionario(){
        funcionario.setDadosDoBanco(bancarios);
        funcionario.getDadosDoBanco().setBanco("Bradesco");
        String banco = funcionario.getDadosDoBanco().getBanco();
        assertEquals("Bradesco",banco);
    }
    @Test
    public void TestaAdicionarDataDePagamentoDoFuncionario(){
        bancarios.setDiaDoPagamento(GrupoDaDataDePagamento.GRUPO_1);
        assertEquals(5,bancarios.getDiaDoPagamento());
    }

}