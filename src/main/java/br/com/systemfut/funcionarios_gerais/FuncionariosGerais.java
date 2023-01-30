package br.com.systemfut.funcionarios_gerais;

import br.com.systemfut.dados_extras.DadosBancarios;
import br.com.systemfut.dados_extras.DadosPessoais;

public abstract sealed class FuncionariosGerais permits FuncionariosADM,FuncionariosComum {

    private String nomeCompleto;
    private long CPF;
    private double salario;
    private DadosBancarios dadosDoBanco;
    private DadosPessoais dadosPessoais;

    public FuncionariosGerais(String nomeCompleto, long CPF) {
        this.nomeCompleto = nomeCompleto;
        if(CPF >=10000000000L && CPF <=99999999999L){
            this.CPF = CPF;
        }else{
            throw new ArithmeticException("Esse CPF é inválido");
        };
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public long getCPF() {
        return CPF;
    }

    public DadosBancarios getDadosDoBanco() {
        return dadosDoBanco;
    }

    public void setDadosDoBanco(DadosBancarios dadosDoBanco) {

        this.dadosDoBanco = dadosDoBanco;
    }

    public DadosPessoais getDadosPessoais() {

        return dadosPessoais;
    }

    public void setDadosPessoais(DadosPessoais dadosPessoais) {

        this.dadosPessoais = dadosPessoais;
    }
    public double getSalario() {

        return salario;
    }
    public void setSalario(SalarioDeFuncionarios c) {

        this.salario = c.pagamento();
    }
}
