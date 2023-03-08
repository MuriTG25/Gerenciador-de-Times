package br.com.systemfut.aplicacao.lista_de_funcionarios.fabrica_de_lista.implementacoes;

import br.com.systemfut.aplicacao.lista_de_funcionarios.ListaDeFuncionarios;
import br.com.systemfut.dominio.funcionarios.Funcionarios;
import br.com.systemfut.dominio.funcionarios.atletas_e_comissao.ComissaoTecnica;

public class ComissaoFabricaLista extends FabricaDeListaMetodos {
    ListaDeFuncionarios funcionarios;


    public ComissaoFabricaLista(FabricaDeListaMetodos proximo,ListaDeFuncionarios funcionarios) {
        super(proximo);
        this.funcionarios = funcionarios;
    }

    @Override
    protected void adicionaFuncionario(Funcionarios funcionario) {
        ComissaoTecnica comissao = (ComissaoTecnica) funcionario;
        this.funcionarios.getListaDeComissaoTecnica().add(comissao);
        this.funcionarios.getMapsDeComissao().put(comissao.getCargo(),comissao.getNomeCompleto());
    }
    @Override
    protected void removeFuncionario(Funcionarios funcionario) {
        ComissaoTecnica comissao = (ComissaoTecnica) funcionario;
        this.funcionarios.getListaDeComissaoTecnica().remove(comissao);
        this.funcionarios.getMapsDeComissao().remove(comissao.getCargo(),comissao.getNomeCompleto());
    }

    @Override
    protected boolean verificaClasse(Funcionarios funcionario) {
        return funcionario instanceof ComissaoTecnica;
    }
}
