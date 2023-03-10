package br.com.systemfut.aplicacao.lista_de_funcionarios.fabrica_de_lista.implementacoes;

import br.com.systemfut.aplicacao.lista_de_funcionarios.ListaDeFuncionarios;
import br.com.systemfut.dominio.funcionarios.Funcionarios;
import br.com.systemfut.dominio.funcionarios.atletas_e_comissao.Jogadores;

public class JogadoresFabricaLista extends FabricaDeListaMetodos {
    ListaDeFuncionarios funcionarios;

    public JogadoresFabricaLista(FabricaDeListaMetodos proximo, ListaDeFuncionarios funcionarios) {
        super(proximo);
        this.funcionarios = funcionarios;
    }
    @Override
    protected void adicionaFuncionario(Funcionarios funcionario) {
        Jogadores jogador = (Jogadores) funcionario;
        this.funcionarios.getListaDeJogadores().add(jogador);
        this.funcionarios.getMapsDeJogador().put(jogador.getPosicao(),jogador.getNomeCompleto());
    }
    @Override
    protected void removeFuncionario(Funcionarios funcionario) {
        Jogadores jogador = (Jogadores) funcionario;
        this.funcionarios.getListaDeJogadores().remove(jogador);
        this.funcionarios.getMapsDeJogador().remove(jogador.getPosicao(),jogador.getNomeCompleto());
    }
    @Override
    protected boolean verificaClasse(Funcionarios funcionario) {
        return funcionario instanceof Jogadores;
    }
}
