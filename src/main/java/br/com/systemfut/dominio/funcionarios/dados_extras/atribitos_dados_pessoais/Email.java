package br.com.systemfut.dominio.funcionarios.dados_extras.atribitos_dados_pessoais;

import br.com.systemfut.aplicacao.exception.ValorInvalidoException;

public class Email {
    private String endereco;

    public Email(String endereco) {
        if (endereco == null || !endereco.matches("^[a-zA-Z0-9._]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")){
            throw new ValorInvalidoException("email invalido");
        }
        this.endereco = endereco;
    }
    public String getEnderecoEMail() {
        return endereco;
    }
}
