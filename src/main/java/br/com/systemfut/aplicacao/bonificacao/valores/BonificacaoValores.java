package br.com.systemfut.aplicacao.bonificacao.valores;

import java.math.BigDecimal;

public enum BonificacaoValores {
    JOGADOR(new BigDecimal("0.2"),new BigDecimal("0.05")),COMISSAO_TECNICA(
            new BigDecimal("0.2"),new BigDecimal("0.025"))
    ,FUNCIONARIO_COMUM(new BigDecimal("0.05"),BigDecimal.ZERO),FUNCIONARIO_ADM(
            new BigDecimal("0.1"),BigDecimal.ZERO);
    private BigDecimal bonusPorTitulo;
    private BigDecimal bonusPorVitoria;

    BonificacaoValores(BigDecimal bonusPorTitulo, BigDecimal bonusPorVitoria) {
        this.bonusPorTitulo = bonusPorTitulo;
        this.bonusPorVitoria = bonusPorVitoria;
    }

    public BigDecimal bonificacaoTituloPorCargo(){
        return this.bonusPorTitulo;
    };
    public BigDecimal bonificacaoVitoriaPorCargo(){
        return this.bonusPorVitoria;
    };
}
