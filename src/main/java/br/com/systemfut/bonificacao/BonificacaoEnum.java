package br.com.systemfut.bonificacao;

public enum BonificacaoEnum {
    JOGADOR(0.2, 0.05),COMISSAO_TECNICA(0.2, 0.025)
    ,FUNCIONARIO_COMUM(0.05,0.0),FUNCIONARIO_ADM(0.1,0.0);
    private double bonusPorTitulo;
    private double bonusPorVitoria;

    BonificacaoEnum(double bonusPorTitulo, double bonusPorVitoria) {
        this.bonusPorTitulo = bonusPorTitulo;
        this.bonusPorVitoria = bonusPorVitoria;
    }

    public double bonificacaoTituloPorCargo(){
        return this.bonusPorTitulo;
    };
    public double bonificacaoVitoriaPorCargo(){
        return this.bonusPorVitoria;
    };
}
