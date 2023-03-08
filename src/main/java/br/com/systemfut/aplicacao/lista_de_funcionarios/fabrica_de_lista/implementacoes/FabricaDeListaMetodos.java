package br.com.systemfut.aplicacao.lista_de_funcionarios.fabrica_de_lista.implementacoes;

import br.com.systemfut.dominio.funcionarios.Funcionarios;

public abstract class FabricaDeListaMetodos {
    FabricaDeListaMetodos proximo;

    public FabricaDeListaMetodos(FabricaDeListaMetodos proximo) {
        this.proximo = proximo;
    }

    protected abstract void adicionaFuncionario(Funcionarios funcionario);
    protected abstract void removeFuncionario(Funcionarios funcionario);
    protected abstract boolean verificaClasse(Funcionarios funcionario);

    public void adicionarFuncionarioNovo(Funcionarios funcionario){
        if(verificaClasse(funcionario)){
            adicionaFuncionario(funcionario);
        } else {
            this.proximo.adicionarFuncionarioNovo(funcionario);
        }
    }
    public void removerFuncionarioNovo(Funcionarios funcionario){
        if(verificaClasse(funcionario)){
            removeFuncionario(funcionario);
        } else {
            this.proximo.removerFuncionarioNovo(funcionario);
        }
    }
}
