package br.com.systemfut.dominio.funcionarios;

import br.com.systemfut.dominio.funcionarios.dados_extras.DadosBancarios;
import br.com.systemfut.dominio.funcionarios.dados_extras.DadosPessoais;
import br.com.systemfut.dominio.funcionarios.dados_extras.Endereco;
import br.com.systemfut.dominio.funcionarios.atributos_Funcionarios.CPF;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public abstract class Funcionarios {
    private String nomeCompleto;
    private CPF CPF;
    private LocalDate dataDeAdmissao;
    private DadosBancarios dadosDoBanco;
    private DadosPessoais dadosPessoais;
    private Endereco endereco;
    public Funcionarios(String nomeCompleto, CPF CPF) {
        this.nomeCompleto = nomeCompleto;
        this.CPF = CPF;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }
    public String getCPF() {
        return CPF.imprimeCPF();
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

    public Endereco getEndereco() {
        return endereco;
    }
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
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
