package br.com.systemfut.bonificacao;

import br.com.systemfut.atletas_e_comissao.ComissaoTecnica;
import br.com.systemfut.funcionarios_gerais.FuncionariosADM;
import br.com.systemfut.funcionarios_gerais.FuncionariosComum;
import br.com.systemfut.atletas_e_comissao.Jogadores;
import br.com.systemfut.funcionarios_gerais.SalarioDeFuncionarios;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BonificacaoTest {
    Bonificacao boni;
    @BeforeEach
    public void BoniTitueVito(){
        boni = new Bonificacao();
        boni.setTitulos(1);
        boni.setVitorias(3);
    }
    @Test
    public void TestaBonificacaoPorTituloDeJogadorBonus20PorCentoeVitoria5porCento() {
        BoniTitueVito();
        var maicon = new Jogadores("Maicon", 32456789043L,"Zagueiro");
        maicon.setSalario(10000.0);
        var boniJogador = boni.BonificacaoPorTituloAeC(maicon, BonificacaoEnum.JOGADOR,boni);
        var bonivit = boni.BonificacaoPorVitoriaAeC(maicon, BonificacaoEnum.JOGADOR,boni);
        assertEquals(2000, boniJogador);
        assertEquals(1500, bonivit);
    }
    @Test
    public void TestaBonificacaoPorTituloDeComissaoTecnica20PorCentoeVitoria2e5porCento() {
        BoniTitueVito();
        var maicon = new ComissaoTecnica("Maicon", 32456789043L, "técnico");
        maicon.setSalario(5000.0);
        var boniComissaoTecnica = boni.BonificacaoPorTituloAeC(maicon, BonificacaoEnum.COMISSAO_TECNICA,boni);
        var bonivit = boni.BonificacaoPorVitoriaAeC(maicon, BonificacaoEnum.COMISSAO_TECNICA,boni);
        assertEquals(1000, boniComissaoTecnica);
        assertEquals(375, bonivit);
    }
    @Test
    public void TestaBonificacaoPorTituloDeFuncionarioADM10PorCentoeNadaPorVitoria() {
        BoniTitueVito();
        var maicon = new FuncionariosADM("Maicon", 32456789043L, "Gerente Junior");
        maicon.setSalario(SalarioDeFuncionarios.GERENTE_JUNIOR);
        var boniFuncionarioADM = boni.BonificacaoPorTitulo(maicon, BonificacaoEnum.FUNCIONARIO_ADM,boni);
        var bonivit = boni.BonificacaoPorVitoria(maicon, BonificacaoEnum.FUNCIONARIO_ADM,boni);
        assertEquals(350, boniFuncionarioADM);
        assertEquals(0, bonivit);
    }
    @Test
    public void TestaBonificacaoPorTituloDeFuncionarioComum5PorCentoeNadaPorVitoria() {
        BoniTitueVito();
        var maicon = new FuncionariosComum("Maicon", 32456789043L,"Auxiliar de Limpeza Junior");
        maicon.setSalario(SalarioDeFuncionarios.LIMPEZA_JUNIOR);
        var boniJogador = boni.BonificacaoPorTitulo(maicon, BonificacaoEnum.FUNCIONARIO_COMUM,boni);
        var bonivit = boni.BonificacaoPorVitoria(maicon, BonificacaoEnum.FUNCIONARIO_COMUM,boni);
        assertEquals(55, boniJogador);
        assertEquals(0, bonivit);
    }

}