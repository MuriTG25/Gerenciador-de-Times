package br.com.systemfut.aplicacao.bonificacao;

import br.com.systemfut.aplicacao.bonificacao.valores.BonificacaoValores;
import br.com.systemfut.dominio.funcionarios.atletas_e_comissao.ComissaoTecnica;
import br.com.systemfut.dominio.funcionarios.atributos_Funcionarios.CPF;
import br.com.systemfut.dominio.funcionarios.funcionarios_gerais.FuncionariosADM;
import br.com.systemfut.dominio.funcionarios.funcionarios_gerais.FuncionariosComum;
import br.com.systemfut.dominio.funcionarios.atletas_e_comissao.Jogadores;
import br.com.systemfut.dominio.funcionarios.funcionarios_gerais.valores.FuncionariosSalarios;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BonificacaoTest {
    Bonificacao boni;
    @BeforeEach
    public void BoniTitueVito(){
        boni = new Bonificacao(new BigDecimal("3"),new BigDecimal("1"));
    }
    @Test
    public void TestaBonificacaoPorTituloDeJogadorBonus20PorCentoeVitoria5porCento() {
        BoniTitueVito();
        var maicon = new Jogadores("Maicon", new CPF("47624931044"),"Zagueiro");
        maicon.setSalario(new BigDecimal("10000.0"));
        var boniJogador = boni.BonificacaoPorTitulo(maicon, BonificacaoValores.JOGADOR);
        var bonivit = boni.BonificacaoPorVitoria(maicon, BonificacaoValores.JOGADOR);
        assertEquals(new BigDecimal("2000.00"), boniJogador);
        assertEquals(new BigDecimal("1500.00"), bonivit);
    }
    @Test
    public void TestaBonificacaoPorTituloDeComissaoTecnica20PorCentoeVitoria2e5porCento() {
        BoniTitueVito();
        var maicon = new ComissaoTecnica("Maicon", new CPF("47624931044"), "técnico");
        maicon.setSalario(new BigDecimal("5000.00"));
        var boniComissaoTecnica = boni.BonificacaoPorTitulo(maicon, BonificacaoValores.COMISSAO_TECNICA);
        var bonivit = boni.BonificacaoPorVitoria(maicon, BonificacaoValores.COMISSAO_TECNICA);
        assertEquals(new BigDecimal("1000.00"), boniComissaoTecnica);
        assertEquals(new BigDecimal("375.00"), bonivit);
    }
    @Test
    public void TestaBonificacaoPorTituloDeFuncionarioADM10PorCentoeNadaPorVitoria() {
        BoniTitueVito();
        var maicon = new FuncionariosADM("Maicon",  new CPF("47624931044"), "Gerente Junior");
        maicon.setSalario(FuncionariosSalarios.GERENTE_JUNIOR);
        var boniFuncionarioADM = boni.BonificacaoPorTitulo(maicon, BonificacaoValores.FUNCIONARIO_ADM);
        var bonivit = boni.BonificacaoPorVitoria(maicon, BonificacaoValores.FUNCIONARIO_ADM);
        assertEquals(new BigDecimal("350.00"), boniFuncionarioADM);
        assertEquals(new BigDecimal("0.00"), bonivit);
    }
    @Test
    public void TestaBonificacaoPorTituloDeFuncionarioComum5PorCentoeNadaPorVitoria() {
        BoniTitueVito();
        var maicon = new FuncionariosComum("Maicon",  new CPF("47624931044"),"Auxiliar de Limpeza Junior");
        maicon.setSalario(FuncionariosSalarios.LIMPEZA_JUNIOR);
        var boniJogador = boni.BonificacaoPorTitulo(maicon, BonificacaoValores.FUNCIONARIO_COMUM);
        var bonivit = boni.BonificacaoPorVitoria(maicon, BonificacaoValores.FUNCIONARIO_COMUM);
        assertEquals(new BigDecimal("55.00"), boniJogador);
        assertEquals(new BigDecimal("0.00"), bonivit);
    }
}