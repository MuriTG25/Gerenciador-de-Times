package br.com.systemfut.funcionarios_gerais;

import br.com.systemfut.dados_extras.SenhaDaAreaDeDados;
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

    public FuncionariosADM(String nomeCompleto, long CPF, String cargo) {
        super(nomeCompleto, CPF);
        this.cargo = cargo;
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
        try {
            Properties acesso = new Properties();
            acesso.setProperty("login", login);
            if (senha.length() < 6){
                throw new InvalidNumberException("A senha tem que ter pelo menos 6 dígitos");
            }
            acesso.setProperty("senha", senha);
            acesso.setProperty("site", "systemfut.com.br");
            acesso.store(new FileWriter(login+".properties"
            ),"Login e senha do Funcionario: "
                    +this.getNomeCompleto()+" / Cargo: "+this.getCargo());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void acessaDadosDeLogin(String filename) {
        try {
            Properties acesso = new Properties();
            acesso.load(new FileReader(filename+".properties"));
            String login = acesso.getProperty("login");
            String senha = acesso.getProperty("senha");
            String site = acesso.getProperty("site");
            System.out.println(login+", "+senha+", "+site);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

