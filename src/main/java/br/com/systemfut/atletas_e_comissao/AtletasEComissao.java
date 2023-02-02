package br.com.systemfut.atletas_e_comissao;

import br.com.systemfut.dados_extras.DadosBancarios;
import br.com.systemfut.dados_extras.DadosPessoais;
import br.com.systemfut.exception.InvalidNumberException;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public abstract sealed class AtletasEComissao permits Jogadores,ComissaoTecnica {
    private String nomeCompleto;
    private long CPF;
    protected double salario;
    private LocalDate dataDeAdmissao;
    private DadosBancarios dadosDoBanco;
    private DadosPessoais dadosPessoais;

    public AtletasEComissao(String nomeCompleto, long CPF) {
        this.nomeCompleto = nomeCompleto;
        if(CPF >=10000000000L && CPF <=99999999999L){
            this.CPF = CPF;
        }else{
            throw new InvalidNumberException("Esse CPF é inválido");
        }
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
    public abstract void setSalario(double salario);

    public String getDataDeAdmissao() {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return dataDeAdmissao.format(formato);
    }
    public Period tempoDeTrabalho(){
        LocalDate agora = LocalDate.now();
        return Period.between(this.dataDeAdmissao, agora);
    }

    public void setDataDeAdmissao(int dia, int mes, int ano) {
        this.dataDeAdmissao = LocalDate.of(ano,mes,dia);
    }
}

