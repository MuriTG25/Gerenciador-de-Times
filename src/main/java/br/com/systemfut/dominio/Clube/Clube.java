package br.com.systemfut.dominio.Clube;

import br.com.systemfut.dominio.Clube.valores.CNPJ;

/**
 * Classe onde armazena os dados do clube
 * @author Murilo Bioni Caruso
 * @version 1.1
 * @since 2023
 */
public class Clube {

    private String nomeDoClube;
    private CNPJ CNPJ;
    private String razaoSocial;

    public Clube(String nomeDoClube, CNPJ CNPJ, String razaoSocial) {
        this.nomeDoClube = nomeDoClube;
        this.CNPJ = CNPJ;
        this.razaoSocial = razaoSocial;
    }

    public String getNomeDoClube() {
        return nomeDoClube;
    }

    public String getCNPJ() {
        return CNPJ.getCNPJ();
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }}
