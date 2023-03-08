package br.com.systemfut.aplicacao.lista_de_funcionarios.implementacoes;

import br.com.systemfut.aplicacao.lista_de_funcionarios.ListaDeFuncionarios;
import br.com.systemfut.dominio.funcionarios.atletas_e_comissao.ComissaoTecnica;

import java.util.Comparator;
import java.util.List;

public class ComissaoTecnicaListaMetodos implements MetodosDaLista {
    ListaDeFuncionarios funcionarios;

    public ComissaoTecnicaListaMetodos(ListaDeFuncionarios lista) {
        this.funcionarios = lista;
    }
    @Override
    public void ordenaPorNome() {
        this.funcionarios.getListaDeComissaoTecnica().sort(Comparator.comparing
                (ComissaoTecnica::getNomeCompleto));
    }
    @Override
    public void ordenaPorCargo() {
        this.funcionarios.getListaDeComissaoTecnica().sort(Comparator.comparing
                (ComissaoTecnica::getCargo));
    }

    @Override
    public String buscapeloCargo(String cargo) {
        return this.funcionarios.getMapsDeComissao().get(cargo);
    }

}
