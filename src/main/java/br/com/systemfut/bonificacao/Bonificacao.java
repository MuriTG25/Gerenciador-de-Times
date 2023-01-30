package br.com.systemfut.bonificacao;

import br.com.systemfut.atletas_e_comissao.AtletasEComissao;
import br.com.systemfut.funcionarios_gerais.FuncionariosGerais;

public class Bonificacao {
    private int vitorias;
    private int titulos;
        public double BonificacaoPorTitulo(FuncionariosGerais f,
                                           BonificacaoEnum bc, Bonificacao b){
            return f.getSalario()*bc.bonificacaoTituloPorCargo()*b.getTitulos();
        }
        public double BonificacaoPorVitoria(FuncionariosGerais f,
                                            BonificacaoEnum bc, Bonificacao b){
            return f.getSalario()*bc.bonificacaoVitoriaPorCargo()*b.getVitorias();
        }
    public double BonificacaoPorTituloAeC(AtletasEComissao f,
                                          BonificacaoEnum bc, Bonificacao b){
        return f.getSalario()*bc.bonificacaoTituloPorCargo()*b.getTitulos();
    }
    public double BonificacaoPorVitoriaAeC(AtletasEComissao f,
                                           BonificacaoEnum bc, Bonificacao b){
        return f.getSalario()*bc.bonificacaoVitoriaPorCargo()*b.getVitorias();
    }

    public int getVitorias() {
        return vitorias;
    }

    public void setVitorias(int vitorias) {
        this.vitorias = vitorias;
    }

    public int getTitulos() {
        return titulos;
    }

    public void setTitulos(int titulos) {
        this.titulos = titulos;
    }
}
