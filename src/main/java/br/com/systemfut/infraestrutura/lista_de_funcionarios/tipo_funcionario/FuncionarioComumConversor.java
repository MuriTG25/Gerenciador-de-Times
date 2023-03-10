package br.com.systemfut.infraestrutura.lista_de_funcionarios.tipo_funcionario;

import br.com.systemfut.aplicacao.lista_de_funcionarios.ListaDeFuncionarios;
import br.com.systemfut.aplicacao.lista_de_funcionarios.implementacoes.FuncionariosComumListaMetodos;
import br.com.systemfut.aplicacao.lista_de_funcionarios.fabrica_de_lista.FabricaDeLista;
import br.com.systemfut.dominio.funcionarios.atributos_Funcionarios.CPF;
import br.com.systemfut.dominio.funcionarios.funcionarios_gerais.FuncionariosComum;

import java.util.ArrayList;
import java.util.List;
/**
 * Classe que faz a importacao e exportacao de lista de strings vinda
 * de um arquivo externo para uma lista de Funcionarios Comum
 * @author Murilo Bioni Caruso
 * @version 1.1
 * @since 2023
 */
public class FuncionarioComumConversor implements ConversorDeFuncionario{
    ListaDeFuncionarios funcionarios;
    FuncionariosComumListaMetodos comumListaMetodos;
    FabricaDeLista fabrica;

    public FuncionarioComumConversor(ListaDeFuncionarios funcionarios) {
        this.funcionarios = funcionarios;
        comumListaMetodos = new FuncionariosComumListaMetodos(this.funcionarios);
        fabrica = new FabricaDeLista(funcionarios);
    }

    @Override
    public void criaFuncionarioPeloImporte(List<String> listaDeStrings) {
        for (int i = 0; i < listaDeStrings.size(); i = i+3) {
            String nome = listaDeStrings.get(i);
            String CPF = listaDeStrings.get(i + 1);
            String cargo = listaDeStrings.get(i + 2);
            this.fabrica.adicionarFuncionarioNovo(new FuncionariosComum(nome,new CPF(CPF),cargo));
        }
    }

    @Override
    public List<String[]> exportaFuncionariosParaList() {
        List<FuncionariosComum> listaDeFuncionarios = this.funcionarios.getListaDeFuncionariosComum();
        List<String[]> linhas = new ArrayList<>();
        for (int i = 0; i < listaDeFuncionarios.size(); i++) {
            String nome = listaDeFuncionarios.get(i).getNomeCompleto();
            String cpf = listaDeFuncionarios.get(i).getCPF();
            String posicao = listaDeFuncionarios.get(i).getCargo();
            linhas.add(new String[]{nome,cpf,posicao});
        }
        return linhas;
    }
}
