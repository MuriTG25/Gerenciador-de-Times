package br.com.systemfut.dados_extras;

import br.com.systemfut.exception.InvalidNumberException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class SenhaDaAreaDeDadosMetodos {
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
            ),"Login e senha de Funcionario");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

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
