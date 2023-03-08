package br.com.systemfut.aplicacao.lista_de_funcionarios.implementacoes;

import br.com.systemfut.dominio.funcionarios.Funcionarios;

import java.util.List;

public interface MetodosDaLista {
    void ordenaPorNome();
    void ordenaPorCargo();
    String buscapeloCargo(String cargo);


}
