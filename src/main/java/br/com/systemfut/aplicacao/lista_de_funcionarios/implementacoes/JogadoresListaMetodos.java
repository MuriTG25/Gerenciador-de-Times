package br.com.systemfut.aplicacao.lista_de_funcionarios.implementacoes;

import br.com.systemfut.aplicacao.lista_de_funcionarios.ListaDeFuncionarios;
import br.com.systemfut.dominio.funcionarios.Funcionarios;
import br.com.systemfut.dominio.funcionarios.atletas_e_comissao.Jogadores;

import java.util.Comparator;
import java.util.List;

public class JogadoresListaMetodos implements MetodosDaLista{
    ListaDeFuncionarios funcionarios;

    public JogadoresListaMetodos(ListaDeFuncionarios lista) {
        this.funcionarios = lista;
    }
    @Override
    public void ordenaPorNome() {
        this.funcionarios.getListaDeJogadores().sort(Comparator.comparing
                (Jogadores::getNomeCompleto));
    }

    @Override
    public void ordenaPorCargo() {
        this.funcionarios.getListaDeJogadores().sort(Comparator.comparing
                (Jogadores::getPosicao));
    }

    @Override
    public String buscapeloCargo(String cargo) {
        return this.funcionarios.getMapsDeJogador().get(cargo);
    }
}
