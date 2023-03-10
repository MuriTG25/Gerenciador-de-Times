package br.com.systemfut.infraestrutura.senha;

import br.com.systemfut.aplicacao.exception.ValorInvalidoException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class CriadorEAcessadorDeSenhasArquivoProperties implements AcessadorDaSenhaDaAreaDeDados {
    @Override
    public void setDadosDeLogin(String login, String senha) {
        try {
            Properties acesso = new Properties();
            acesso.setProperty("login", login);
            if (senha.length() < 6){
                throw new ValorInvalidoException("A senha tem que ter pelo menos 6 dígitos");
            }
            acesso.setProperty("senha", senha);
            acesso.setProperty("site", "systemfut.com.br");
            acesso.store(new FileWriter(login+".properties"
            ),"Login e senha de Funcionario");
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
