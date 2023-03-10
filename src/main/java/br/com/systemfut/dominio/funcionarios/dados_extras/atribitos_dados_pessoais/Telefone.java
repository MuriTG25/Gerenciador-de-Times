package br.com.systemfut.dominio.funcionarios.dados_extras.atribitos_dados_pessoais;

import br.com.systemfut.aplicacao.exception.ValorInvalidoException;

public class Telefone {
    private String DDD;
    private String numero;

    public Telefone(String DDD, String numero) {
        if(DDD == null || numero == null){
            throw new ValorInvalidoException("DDD e Numero Sao obrigatórios!");
        }
        if (!DDD.matches("\\d{2}")){
            throw new ValorInvalidoException("DDD invalido!");
        }
        if (!numero.matches("\\d{8}|\\d{9}")){
            throw new ValorInvalidoException("Numero invalido!");
        }
        this.DDD = DDD;
        this.numero = numero;
    }
    public String getTelefone(){
        return DDD+numero;
    }

    public String getDDD() {
        return DDD;
    }

    public String getNumero() {
        return numero;
    }

    @Override
    public String toString() {
        if (numero.length() == 9) {
            return "(" + DDD + ")" + numero.substring(0, 5) + "-" + numero.substring(5, 9);
        }
        if (numero.length() == 8) {
            return "(" + DDD + ")" + numero.substring(0, 4) + "-" + numero.substring(4, 8);
        }
        else {
            throw new ValorInvalidoException("Numero invalido!");
        }
    }
}
