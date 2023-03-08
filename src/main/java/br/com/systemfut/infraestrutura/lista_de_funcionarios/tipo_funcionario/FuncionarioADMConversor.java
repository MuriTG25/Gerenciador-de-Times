package br.com.systemfut.infraestrutura.lista_de_funcionarios.tipo_funcionario;

import br.com.systemfut.aplicacao.lista_de_funcionarios.ListaDeFuncionarios;
import br.com.systemfut.aplicacao.lista_de_funcionarios.implementacoes.FuncionariosADMListaMetodos;
import br.com.systemfut.aplicacao.lista_de_funcionarios.fabrica_de_lista.FabricaDeLista;
import br.com.systemfut.dominio.funcionarios.atributos_Funcionarios.CPF;
import br.com.systemfut.dominio.funcionarios.funcionarios_gerais.FuncionariosADM;

import java.util.ArrayList;
import java.util.List;
/**
 * Classe que faz a importacao e exportacao de lista de strings vinda
 * de um arquivo externo para uma lista de Funcionarios Administrativos
 * @author Murilo Bioni Caruso
 * @version 1.1
 * @since 2023
 */

public class FuncionarioADMConversor implements ConversorDeFuncionario{
    ListaDeFuncionarios funcionarios;
    FuncionariosADMListaMetodos admLista;
    FabricaDeLista fabrica;

    public FuncionarioADMConversor(ListaDeFuncionarios funcionarios) {
        this.funcionarios = funcionarios;
        admLista = new FuncionariosADMListaMetodos(this.funcionarios);
        fabrica = new FabricaDeLista(funcionarios);
    }

    @Override
    public void criaFuncionarioPeloImporte(List<String> listaDeStrings) {
        for (int i = 0; i < listaDeStrings.size(); i = i+3) {
            String nome = listaDeStrings.get(i);
            String CPF = listaDeStrings.get(i + 1);
            String cargo = listaDeStrings.get(i + 2);
            this.fabrica.adicionarFuncionarioNovo(new FuncionariosADM(nome,new CPF(CPF),cargo));
        }
    }

    @Override
    public List<String[]> exportaFuncionariosParaList() {
        List<FuncionariosADM> listaDeFuncionariosADM = this.funcionarios.getListaDeFuncionariosADM();
        List<String[]> linhas = new ArrayList<>();
        for (int i = 0; i < listaDeFuncionariosADM.size(); i++) {
            String nome = listaDeFuncionariosADM.get(i).getNomeCompleto();
            String cpf = listaDeFuncionariosADM.get(i).getCPF();
            String posicao = listaDeFuncionariosADM.get(i).getCargo();
            linhas.add(new String[]{nome,cpf,posicao});
        }
        return linhas;
    }
}
