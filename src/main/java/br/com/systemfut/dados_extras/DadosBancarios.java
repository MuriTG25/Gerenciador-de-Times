package br.com.systemfut.dados_extras;

import java.time.LocalDate;
import java.time.LocalTime;

public class DadosBancarios {
    private String banco;
    private int agencia;
    private int conta;
    private String pix;
    private int diaDoPagamento;

    public int getDiaDoPagamento() {

        return diaDoPagamento;
    }

    public void setDiaDoPagamento(int diaDoPagamento) {

        this.diaDoPagamento = diaDoPagamento;
    }

    public String getBanco() {

        return banco;
    }

    public void setBanco(String banco) {

        this.banco = banco;
    }

    public int getAgencia() {

        return agencia;
    }

    public void setAgencia(int agencia) {

        this.agencia = agencia;
    }

    public int getConta() {

        return conta;
    }

    public void setConta(int conta) {

        this.conta = conta;
    }

    public String getPix() {

        return pix;
    }

    public void setPix(String pix) {

        this.pix = pix;
    }
}
