package br.com.systemfut.infraestrutura.lista_de_funcionarios.tipo_funcionario;

import br.com.systemfut.aplicacao.lista_de_funcionarios.ListaDeFuncionarios;
import br.com.systemfut.aplicacao.lista_de_funcionarios.implementacoes.ComissaoTecnicaListaMetodos;
import br.com.systemfut.aplicacao.lista_de_funcionarios.fabrica_de_lista.FabricaDeLista;
import br.com.systemfut.dominio.funcionarios.atletas_e_comissao.ComissaoTecnica;
import br.com.systemfut.dominio.funcionarios.atributos_Funcionarios.CPF;

import java.util.ArrayList;
import java.util.List;
/**
 * Classe que faz a importacao e exportacao de lista de strings vinda
 * de um arquivo externo para uma lista de Comissao Tecnica
 * @author Murilo Bioni Caruso
 * @version 1.1
 * @since 2023
 */
public class ComissaoTecnicaConversor implements ConversorDeFuncionario{
    ListaDeFuncionarios funcionarios;
    ComissaoTecnicaListaMetodos comissaoMetodos;
    FabricaDeLista fabrica;

    public ComissaoTecnicaConversor(ListaDeFuncionarios funcionarios) {
        this.funcionarios = funcionarios;
        comissaoMetodos = new ComissaoTecnicaListaMetodos(this.funcionarios);
        fabrica = new FabricaDeLista(this.funcionarios);
    }

    @Override
    public void criaFuncionarioPeloImporte(List<String> listaDeStrings) {
        for (int i = 0; i < listaDeStrings.size(); i = i+3) {
            String nome = listaDeStrings.get(i);
            String CPF = listaDeStrings.get(i + 1);
            String cargo = listaDeStrings.get(i + 2);
            this.fabrica.adicionarFuncionarioNovo(new ComissaoTecnica(nome,new CPF(CPF),cargo));
        }
    }

    @Override
    public List<String[]> exportaFuncionariosParaList() {
        List<ComissaoTecnica> listaDeComissaoTecnica = this.funcionarios.getListaDeComissaoTecnica();
        List<String[]> linhas = new ArrayList<>();
        for (int i = 0; i < listaDeComissaoTecnica.size(); i++) {
            String nome = listaDeComissaoTecnica.get(i).getNomeCompleto();
            String cpf = listaDeComissaoTecnica.get(i).getCPF();
            String posicao = listaDeComissaoTecnica.get(i).getCargo();
            linhas.add(new String[]{nome,cpf,posicao});
        }
        return linhas;
    }
}
