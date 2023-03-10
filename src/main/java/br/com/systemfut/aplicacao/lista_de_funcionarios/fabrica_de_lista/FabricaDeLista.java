package br.com.systemfut.aplicacao.lista_de_funcionarios.fabrica_de_lista;

import br.com.systemfut.aplicacao.exception.ValorInvalidoException;
import br.com.systemfut.aplicacao.lista_de_funcionarios.ListaDeFuncionarios;
import br.com.systemfut.aplicacao.lista_de_funcionarios.fabrica_de_lista.implementacoes.*;
import br.com.systemfut.aplicacao.lista_de_funcionarios.implementacoes.*;
import br.com.systemfut.dominio.funcionarios.Funcionarios;
import br.com.systemfut.dominio.funcionarios.atletas_e_comissao.ComissaoTecnica;
import br.com.systemfut.dominio.funcionarios.atletas_e_comissao.Jogadores;
import br.com.systemfut.dominio.funcionarios.funcionarios_gerais.FuncionariosADM;
import br.com.systemfut.dominio.funcionarios.funcionarios_gerais.FuncionariosComum;

public class FabricaDeLista {
    ListaDeFuncionarios lista;

    public FabricaDeLista(ListaDeFuncionarios lista) {
        this.lista = lista;
    }

    public void adicionarFuncionarioNovo(Funcionarios funcionario){
        FabricaDeListaMetodos fabricaLista = new JogadoresFabricaLista
                (new ComissaoFabricaLista
                        (new FuncionariosADMFabricaLista
                                (new FuncionariosComumFabricaLista
                                        (new ClasseVaziaFabricaLista(),
                                                lista), lista), lista), lista);
        fabricaLista.adicionarFuncionarioNovo(funcionario);
    }
    public void removeFuncionarioNovo(Funcionarios funcionario){
        FabricaDeListaMetodos fabricaLista = new JogadoresFabricaLista
                (new ComissaoFabricaLista
                        (new FuncionariosADMFabricaLista
                                (new FuncionariosComumFabricaLista
                                        (new ClasseVaziaFabricaLista(),
                                                lista), lista), lista), lista);
        fabricaLista.removerFuncionarioNovo(funcionario);
    }
}
