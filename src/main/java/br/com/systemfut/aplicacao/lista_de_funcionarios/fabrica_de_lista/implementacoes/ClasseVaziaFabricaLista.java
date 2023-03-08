package br.com.systemfut.aplicacao.lista_de_funcionarios.fabrica_de_lista.implementacoes;

import br.com.systemfut.aplicacao.exception.ValorInvalidoException;
import br.com.systemfut.dominio.funcionarios.Funcionarios;

public class ClasseVaziaFabricaLista extends FabricaDeListaMetodos{
    public ClasseVaziaFabricaLista() {
        super(null);
    }

    @Override
    protected void adicionaFuncionario(Funcionarios funcionario) {
        throw new ValorInvalidoException("tipo de classe invalida");
    }

    @Override
    protected void removeFuncionario(Funcionarios funcionario) {
        throw new ValorInvalidoException("tipo de classe invalida");
    }

    @Override
    protected boolean verificaClasse(Funcionarios funcionario) {
        return false;
    }
}
