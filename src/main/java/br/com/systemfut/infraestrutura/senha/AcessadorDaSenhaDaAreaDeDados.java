package br.com.systemfut.infraestrutura.senha;

public interface AcessadorDaSenhaDaAreaDeDados extends CriadorDeSenhaDaAreaDeDados {
    public void acessaDadosDeLogin(String filename);
}
