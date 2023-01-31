package br.com.systemfut.main;

import br.com.systemfut.Clube.Clube;

import java.io.FileNotFoundException;

public class Principal {
    public static void main(String[] args) throws FileNotFoundException {
        var clube = new Clube("Matonense",
                31111266000135L,"Matonense Futebol Clube");
        clube.criaJogadoresPorCSV("jogadores",clube);
        clube.criaFuncionarioADMPorCSV("funcionariosADM",clube);
        clube.criaComissaoPorCSV("comissao",clube);
        clube.criaFuncionarioComumPorCSV("funcionariosComum",clube);
    }
}
