package br.com.systemfut.dominio.funcionarios.atletas_e_comissao;

import br.com.systemfut.dominio.funcionarios.Funcionarios;
import br.com.systemfut.dominio.funcionarios.atributos_Funcionarios.CPF;

import java.math.BigDecimal;

public abstract sealed class AtletasEComissao extends Funcionarios permits Jogadores,ComissaoTecnica {
    protected BigDecimal salario;

    public AtletasEComissao(String nomeCompleto, CPF CPF) {
        super(nomeCompleto, CPF);
    }
    public BigDecimal getSalario() {
        return salario.setScale(2);
    }
    public abstract void setSalario(BigDecimal salario);
}

