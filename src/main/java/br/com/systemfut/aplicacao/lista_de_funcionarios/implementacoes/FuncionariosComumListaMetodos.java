package br.com.systemfut.aplicacao.lista_de_funcionarios.implementacoes;

import br.com.systemfut.aplicacao.lista_de_funcionarios.ListaDeFuncionarios;
import br.com.systemfut.dominio.funcionarios.funcionarios_gerais.FuncionariosComum;
import java.util.Comparator;

public class FuncionariosComumListaMetodos implements MetodosDaLista {
    ListaDeFuncionarios funcionarios;

    public FuncionariosComumListaMetodos(ListaDeFuncionarios lista) {
        this.funcionarios = lista;
    }

    @Override
    public void ordenaPorNome() {
        this.funcionarios.getListaDeFuncionariosComum().sort(Comparator.comparing
                (FuncionariosComum::getNomeCompleto));
    }

    @Override
    public void ordenaPorCargo() {
        this.funcionarios.getListaDeFuncionariosComum().sort(Comparator.comparing
                (FuncionariosComum::getCargo));
    }

    @Override
    public String buscapeloCargo(String cargo) {
        return this.funcionarios.getMapsDeFuncionariosComum().get(cargo);
    }

}
