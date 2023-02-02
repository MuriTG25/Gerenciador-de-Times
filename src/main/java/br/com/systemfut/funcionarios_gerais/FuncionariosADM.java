package br.com.systemfut.funcionarios_gerais;

import br.com.systemfut.dados_extras.SenhaDaAreaDeDados;
import br.com.systemfut.dados_extras.SenhaDaAreaDeDadosMetodos;
import br.com.systemfut.exception.InvalidNumberException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
/**
 * Classe para organizar os Funcionarios Administrativos
 * @author Murilo Bioni Caruso
 * @version 1.0
 * @since 2023
 */
public final class FuncionariosADM extends FuncionariosGerais implements SenhaDaAreaDeDados {
    private String cargo;
    private SenhaDaAreaDeDadosMetodos senha;

    public FuncionariosADM(String nomeCompleto, long CPF, String cargo) {
        super(nomeCompleto, CPF);
        this.cargo = cargo;
        this.senha = new SenhaDaAreaDeDadosMetodos();
    }
    public String getCargo() {
        return cargo;
    }
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    @Override
    public String toString() {
        return "[Nome: " + this.getNomeCompleto() + " / CPF: " +
                this.getCPF() + " / Cargo: " + this.getCargo() + "]";
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

