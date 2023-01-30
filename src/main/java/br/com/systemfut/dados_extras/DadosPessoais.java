package br.com.systemfut.dados_extras;

import java.time.LocalDate;

public class DadosPessoais {
    private long RG;
    private String endereco;
    private short numeroEndereco;
    private String complemento;
    private String cidade;
    private String estado;
    private String paisOndeMora;
    private String estadoCivil;

    public long getRG() {
        return RG;
    }

    public void setRG(long rg) {
        if(rg >=100000000L && rg <=999999999L){
        this.RG = rg;
    }else{
            throw new ArithmeticException("Esse RG é inválido");
        }
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
    public String getEstadoCivil() {

        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {

        this.estadoCivil = estadoCivil;
    }

}
