package br.com.systemfut.aplicacao.bonificacao;

import br.com.systemfut.aplicacao.bonificacao.valores.BonificacaoValores;
import br.com.systemfut.dominio.funcionarios.InterfaceSalario;

import java.math.BigDecimal;

public class Bonificacao {
    private BigDecimal vitorias;
    private BigDecimal titulos;

    public Bonificacao(BigDecimal vitorias, BigDecimal titulos) {
        this.vitorias = vitorias;
        this.titulos = titulos;
    }

    public BigDecimal BonificacaoPorTitulo(InterfaceSalario funcionarios,
                                           BonificacaoValores porcentagem) {
        return (funcionarios.getSalario().multiply(porcentagem.bonificacaoTituloPorCargo()).
                multiply(this.getTitulos()).setScale(2));
    }

    public BigDecimal BonificacaoPorVitoria(InterfaceSalario funcionarios,
                                            BonificacaoValores porcentagem) {
        return (funcionarios.getSalario().multiply(porcentagem.bonificacaoVitoriaPorCargo()).
                multiply(this.getVitorias()).setScale(2));
    }

    public BigDecimal getVitorias() {
        return vitorias;
    }

    public void setVitorias(BigDecimal vitorias) {
        this.vitorias = vitorias;
    }

    public BigDecimal getTitulos() {
        return titulos;
    }

    public void setTitulos(BigDecimal titulos) {
        this.titulos = titulos;
    }
}
