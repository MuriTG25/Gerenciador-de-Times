package br.com.systemfut.bonificacao;

public enum BonificacaoEnum {
    JOGADOR{
        @Override
        public double bonificacaoTituloPorCargo(){
            return 0.2;
        }

        @Override
        public double bonificacaoVitoriaPorCargo() {
            return 0.05;
        }
    },COMISSAO_TECNICA{
        @Override
        public double bonificacaoTituloPorCargo(){
            return 0.2;
        }
        @Override
        public double bonificacaoVitoriaPorCargo() {
            return 0.025;
        }
    },FUNCIONARIO_COMUM{
        @Override
        public double bonificacaoTituloPorCargo(){
            return 0.05;
        }
        @Override
        public double bonificacaoVitoriaPorCargo() {
            return 0.0;
        }
    },FUNCIONARIO_ADM{
        @Override
        public double bonificacaoTituloPorCargo(){
            return 0.1;
        }
        @Override
        public double bonificacaoVitoriaPorCargo() {
            return 0.0;
        }
    };

    public abstract double bonificacaoTituloPorCargo();
    public abstract double bonificacaoVitoriaPorCargo();
}
