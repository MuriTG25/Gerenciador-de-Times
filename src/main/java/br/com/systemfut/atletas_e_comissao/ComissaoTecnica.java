package br.com.systemfut.atletas_e_comissao;

import br.com.systemfut.dados_extras.SenhaDaAreaDeDados;
import br.com.systemfut.dados_extras.SenhaDaAreaDeDadosMetodos;
import br.com.systemfut.exception.InvalidNumberException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
/**
 * Classe para organizar a Comissão Tecnica
 * @author Murilo Bioni Caruso
 * @version 1.0
 * @since 2023
 */
public final class ComissaoTecnica extends AtletasEComissao implements SenhaDaAreaDeDados {
    public ComissaoTecnica(String nomeCompleto, long CPF, String cargo) {
        super(nomeCompleto, CPF);
        this.cargo = cargo;
        this.senha = new SenhaDaAreaDeDadosMetodos();
    }

    private String cargo;
    private SenhaDaAreaDeDadosMetodos senha;

    public String getCargo() {
        return cargo;
    }
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    @Override
    public void setSalario(double s) {
        if (s >= 2000.0&& s <=20000.0 ){
            this.salario = s;
        } else {
            throw new InvalidNumberException(
                    "O salário não deve ser menor que 2000 e nem maior que 20000");
        }
    }
    @Override
    public String toString() {
        return "[Nome: "+this.getNomeCompleto()+" / CPF: "+
                this.getCPF()+" / Cargo: "+this.getCargo()+"]";
    }

    @Override
    public void setDadosDeLogin(String login, String senha) {
        this.senha.setDadosDeLogin(login,senha);
    }

    @Override
    public void acessaDadosDeLogin(String filename) {
        this.senha.acessaDadosDeLogin(filename);
    }
}
