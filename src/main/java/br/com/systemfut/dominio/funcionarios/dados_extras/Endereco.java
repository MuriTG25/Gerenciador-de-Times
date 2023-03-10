package br.com.systemfut.dominio.funcionarios.dados_extras;

import br.com.systemfut.aplicacao.exception.ValorInvalidoException;

/**
 * Classe para armazenar os dados de endereco do Funcionario
 * @author Murilo Bioni Caruso
 * @version 1.1
 * @since 2023
 */
public class Endereco {
    private int CEP;
    private String endereco;
    private short numeroEndereco;
    private String complemento;
    private String cidade;
    private String estado;
    private String paisOndeMora;

    public int getCEP() {
        return CEP;
    }

    public void setCEP(int CEP) {
        if(CEP < 10000000 || CEP > 99999999){
            throw new ValorInvalidoException("Cep invalido");
        }
        this.CEP = CEP;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public short getNumeroEndereco() {
        return numeroEndereco;
    }

    public void setNumeroEndereco(short numeroEndereco) {
        this.numeroEndereco = numeroEndereco;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPaisOndeMora() {
        return paisOndeMora;
    }

    public void setPaisOndeMora(String paisOndeMora) {
        this.paisOndeMora = paisOndeMora;
    }
}
