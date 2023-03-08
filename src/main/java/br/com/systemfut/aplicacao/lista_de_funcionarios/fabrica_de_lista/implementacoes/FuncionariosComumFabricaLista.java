package br.com.systemfut.aplicacao.lista_de_funcionarios.fabrica_de_lista.implementacoes;

import br.com.systemfut.aplicacao.lista_de_funcionarios.ListaDeFuncionarios;
import br.com.systemfut.dominio.funcionarios.Funcionarios;
import br.com.systemfut.dominio.funcionarios.funcionarios_gerais.FuncionariosComum;

public class FuncionariosComumFabricaLista extends FabricaDeListaMetodos {
    ListaDeFuncionarios funcionarios;

    public FuncionariosComumFabricaLista(FabricaDeListaMetodos proximo, ListaDeFuncionarios funcionarios) {
        super(proximo);
        this.funcionarios = funcionarios;
    }

    @Override
    protected void adicionaFuncionario(Funcionarios funcionario) {
        FuncionariosComum comum = (FuncionariosComum) funcionario;
        this.funcionarios.getListaDeFuncionariosComum().add(comum);
        this.funcionarios.getMapsDeFuncionariosComum().put(comum.getCargo(),comum.getNomeCompleto());
    }

    @Override
    protected void removeFuncionario(Funcionarios funcionario) {
        FuncionariosComum comum = (FuncionariosComum) funcionario;
        this.funcionarios.getListaDeFuncionariosComum().remove(comum);
        this.funcionarios.getMapsDeFuncionariosComum().remove(comum.getCargo(),comum.getNomeCompleto());
    }

    @Override
    protected boolean verificaClasse(Funcionarios funcionario) {
        return funcionario instanceof FuncionariosComum;
    }
}
