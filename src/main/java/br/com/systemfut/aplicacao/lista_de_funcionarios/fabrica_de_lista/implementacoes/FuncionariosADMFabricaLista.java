package br.com.systemfut.aplicacao.lista_de_funcionarios.fabrica_de_lista.implementacoes;

import br.com.systemfut.aplicacao.lista_de_funcionarios.ListaDeFuncionarios;
import br.com.systemfut.dominio.funcionarios.Funcionarios;
import br.com.systemfut.dominio.funcionarios.funcionarios_gerais.FuncionariosADM;

public class FuncionariosADMFabricaLista extends FabricaDeListaMetodos {
    ListaDeFuncionarios funcionarios;

    public FuncionariosADMFabricaLista(FabricaDeListaMetodos proximo, ListaDeFuncionarios funcionarios) {
        super(proximo);
        this.funcionarios = funcionarios;
    }

    @Override
    protected void adicionaFuncionario(Funcionarios funcionario) {
        FuncionariosADM adm = (FuncionariosADM) funcionario;
        this.funcionarios.getListaDeFuncionariosADM().add(adm);
        this.funcionarios.getMapsDeFuncionariosADM().put(adm.getCargo(),adm.getNomeCompleto());
    }
    @Override
    protected void removeFuncionario(Funcionarios funcionario) {
        FuncionariosADM adm = (FuncionariosADM) funcionario;
        this.funcionarios.getListaDeFuncionariosADM().remove(adm);
        this.funcionarios.getMapsDeFuncionariosADM().remove(adm.getCargo(),adm.getNomeCompleto());
    }

    @Override
    protected boolean verificaClasse(Funcionarios funcionario) {
        return funcionario instanceof FuncionariosADM;
    }
}
