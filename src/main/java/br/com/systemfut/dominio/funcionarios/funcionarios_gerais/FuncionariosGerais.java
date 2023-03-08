package br.com.systemfut.dominio.funcionarios.funcionarios_gerais;

import br.com.systemfut.aplicacao.reajuste.ReajusteService;
import br.com.systemfut.dominio.funcionarios.Funcionarios;
import br.com.systemfut.dominio.funcionarios.atributos_Funcionarios.CPF;
import br.com.systemfut.dominio.funcionarios.funcionarios_gerais.valores.FuncionariosSalarios;

import java.math.BigDecimal;
import java.time.LocalDate;

public abstract sealed class FuncionariosGerais extends Funcionarios permits FuncionariosComum, FuncionariosADM {

    protected BigDecimal salario;
    private LocalDate dataDoUltimoReajusteSalarial;

    public FuncionariosGerais(String nomeCompleto, CPF CPF) {
        super(nomeCompleto, CPF);
    }

    public BigDecimal getSalario() {
        return salario.setScale(2);
    }
    public void setSalario(FuncionariosSalarios c) {
        this.salario = c.pagamento();
        this.dataDoUltimoReajusteSalarial = LocalDate.now();
    }
    public LocalDate getDataDoUltimoReajuste() {
        return dataDoUltimoReajusteSalarial;
    }
    public void setDataDeReajusteSalarial(int dia, int mes, int ano) {
        this.dataDoUltimoReajusteSalarial = LocalDate.of(ano, mes, dia);
    }
    public void reajustaSalario(BigDecimal porcentagemAumento) {
        BigDecimal validacao = new ReajusteService().getNovoSalarioDoFuncionario(porcentagemAumento, this);
        BigDecimal novoValor = validacao.multiply(this.salario).add(this.salario);
        this.salario = novoValor;
        this.dataDoUltimoReajusteSalarial = LocalDate.now();
    }

}
