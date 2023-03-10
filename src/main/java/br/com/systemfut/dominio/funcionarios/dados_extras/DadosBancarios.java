package br.com.systemfut.dominio.funcionarios.dados_extras;

import br.com.systemfut.dominio.funcionarios.dados_extras.atributos_dados_bancarios.GrupoDaDataDePagamento;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Classe para armazenar os dados bancarios do Funcionario
 *
 * @author Murilo Bioni Caruso
 * @version 1.1
 * @since 2023
 */

public class DadosBancarios {
    private String banco;
    private int agencia;
    private Long conta;
    private String pix;
    private int diaDoPagamento;

    public int getDiaDoPagamento() {
        return diaDoPagamento;
    }
    public void setDiaDoPagamento(GrupoDaDataDePagamento grupo) {
        this.diaDoPagamento = grupo.getDiaDePagamento();
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
    public Long getConta() {
        return conta;
    }
    public void setConta(Long conta) {
        this.conta = conta;
    }
    public String getPix() {
        return pix;
    }
    public void setPix(String pix) {
        this.pix = pix;
    }
}
