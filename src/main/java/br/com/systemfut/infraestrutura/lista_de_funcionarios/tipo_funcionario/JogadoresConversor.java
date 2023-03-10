package br.com.systemfut.infraestrutura.lista_de_funcionarios.tipo_funcionario;

import br.com.systemfut.aplicacao.lista_de_funcionarios.ListaDeFuncionarios;
import br.com.systemfut.aplicacao.lista_de_funcionarios.implementacoes.JogadoresListaMetodos;
import br.com.systemfut.aplicacao.lista_de_funcionarios.fabrica_de_lista.FabricaDeLista;
import br.com.systemfut.dominio.funcionarios.atletas_e_comissao.Jogadores;
import br.com.systemfut.dominio.funcionarios.atributos_Funcionarios.CPF;

import java.util.ArrayList;
import java.util.List;
/**
 * Classe que faz a importacao e exportacao de lista de strings vinda
 * de um arquivo externo para uma lista de Jogadores
 * @author Murilo Bioni Caruso
 * @version 1.1
 * @since 2023
 */

public class JogadoresConversor implements ConversorDeFuncionario{
    ListaDeFuncionarios funcionarios;
    JogadoresListaMetodos jogadorMetodos;
    FabricaDeLista fabrica;

    public JogadoresConversor(ListaDeFuncionarios funcionarios) {
        this.funcionarios = funcionarios;
        jogadorMetodos = new JogadoresListaMetodos(this.funcionarios);
        fabrica = new FabricaDeLista(funcionarios);
    }

    @Override
    public void criaFuncionarioPeloImporte(List<String> listaDeStrings) {
        for (int i = 0; i < listaDeStrings.size(); i = i+3) {
            String nome = listaDeStrings.get(i);
            String CPF = listaDeStrings.get(i + 1);
            String posicao = listaDeStrings.get(i + 2);
            this.fabrica.adicionarFuncionarioNovo(new Jogadores(nome,new CPF(CPF),posicao));
        }
    }

    @Override
    public List<String[]> exportaFuncionariosParaList() {
        List<Jogadores> listaDeJogadores = this.funcionarios.getListaDeJogadores();
        List<String[]> linhas = new ArrayList<>();
        for (int i = 0; i < listaDeJogadores.size(); i++) {
            String nome = listaDeJogadores.get(i).getNomeCompleto();
            String cpf = listaDeJogadores.get(i).getCPF();
            String posicao = listaDeJogadores.get(i).getPosicao();
            linhas.add(new String[]{nome,cpf,posicao});
        }
        return linhas;
    }
}
