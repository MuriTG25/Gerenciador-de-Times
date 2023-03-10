package br.com.systemfut.aplicacao.lista_de_funcionarios;

import br.com.systemfut.dominio.funcionarios.Funcionarios;
import br.com.systemfut.dominio.funcionarios.atletas_e_comissao.ComissaoTecnica;
import br.com.systemfut.dominio.funcionarios.atletas_e_comissao.Jogadores;
import br.com.systemfut.dominio.funcionarios.funcionarios_gerais.FuncionariosADM;
import br.com.systemfut.dominio.funcionarios.funcionarios_gerais.FuncionariosComum;
import br.com.systemfut.aplicacao.lista_de_funcionarios.implementacoes.MetodosDaLista;

import java.util.*;
/**
 * Classe para organizar a lista de funcionarios
 * @author Murilo Bioni Caruso
 * @version 1.1
 * @since 2023
 */

public class ListaDeFuncionarios {
    private LinkedList<Jogadores> listaDeJogadores = new LinkedList<>();
    private LinkedList<ComissaoTecnica> listaDeComissaoTecnica = new LinkedList<>();
    private ArrayList<FuncionariosADM> listaDeFuncionariosADM = new ArrayList<>();
    private ArrayList<FuncionariosComum> listaDeFuncionariosComum = new ArrayList<>();
    private LinkedHashMap<String,String> buscaJogadorPorPosicao = new LinkedHashMap<>();
    private LinkedHashMap<String,String> buscaComissaoPorCargo = new LinkedHashMap<>();
    private HashMap<String,String> buscaADMPorCargo = new HashMap<>();
    private HashMap<String,String> buscaComumPorCargo = new HashMap<>();

    public List<Jogadores> getListaDeJogadores() {
        return listaDeJogadores;
    }
    public List<ComissaoTecnica> getListaDeComissaoTecnica() {
        return listaDeComissaoTecnica ;
    }
    public List<FuncionariosADM> getListaDeFuncionariosADM() {
        return listaDeFuncionariosADM ;
    }
    public List<FuncionariosComum> getListaDeFuncionariosComum() {
        return listaDeFuncionariosComum;
    }
    public Map<String, String> getMapsDeJogador() {
        return buscaJogadorPorPosicao;
    }
    public Map<String, String> getMapsDeComissao() {
        return buscaComissaoPorCargo;
    }
    //Métodos de HashMap ADM
    public Map<String, String> getMapsDeFuncionariosADM() {
        return buscaADMPorCargo;
    }
    //Métodos de HashMap Comum
    public Map<String, String> getMapsDeFuncionariosComum() {
        return buscaComumPorCargo;
    }
    public void ordenaListaFuncionariosPorNome(MetodosDaLista tipoFuncionario){
        tipoFuncionario.ordenaPorNome();
    }
    public void ordenaListaFuncionariosPorCargo(MetodosDaLista tipoFuncionario){
        tipoFuncionario.ordenaPorCargo();
    }
    public String procuraFuncionarioPeloCargo(String cargo,MetodosDaLista tipoFuncionario){
        return tipoFuncionario.buscapeloCargo(cargo);
    }
}
