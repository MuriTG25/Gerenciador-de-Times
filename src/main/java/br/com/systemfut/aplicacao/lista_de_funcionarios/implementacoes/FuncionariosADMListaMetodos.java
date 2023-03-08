package br.com.systemfut.aplicacao.lista_de_funcionarios.implementacoes;

import br.com.systemfut.aplicacao.lista_de_funcionarios.ListaDeFuncionarios;
import br.com.systemfut.dominio.funcionarios.funcionarios_gerais.FuncionariosADM;
import br.com.systemfut.dominio.funcionarios.funcionarios_gerais.FuncionariosGerais;

import java.util.Comparator;
import java.util.List;

public class FuncionariosADMListaMetodos implements MetodosDaLista{
    ListaDeFuncionarios funcionarios;

    public FuncionariosADMListaMetodos(ListaDeFuncionarios funcionarios) {
        this.funcionarios = funcionarios;
    }
    @Override
    public void ordenaPorNome() {
        this.funcionarios.getListaDeFuncionariosADM().sort(Comparator.comparing(FuncionariosGerais::getNomeCompleto));
    }
    @Override
    public void ordenaPorCargo() {
        this.funcionarios.getListaDeFuncionariosADM().sort(Comparator.comparing(FuncionariosADM::getCargo));
    }

    @Override
    public String buscapeloCargo(String cargo) {
        return this.funcionarios.getMapsDeFuncionariosADM().get(cargo);
    }
}
