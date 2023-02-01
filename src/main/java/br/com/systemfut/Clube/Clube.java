package br.com.systemfut.Clube;

import br.com.systemfut.atletas_e_comissao.ComissaoTecnica;
import br.com.systemfut.atletas_e_comissao.Jogadores;
import br.com.systemfut.exception.InvalidNumberException;
import br.com.systemfut.funcionarios_gerais.FuncionariosADM;
import br.com.systemfut.funcionarios_gerais.FuncionariosComum;
import br.com.systemfut.funcionarios_gerais.FuncionariosGerais;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
/**
 * Classe para organizar a lista de funcionarios
 * @author Murilo Bioni Caruso
 * @version 1.0
 * @since 2023
 */
public class Clube {

    private String nomeDoClube;
    private long CNPJ;
    private String razaoSocial;
    private LinkedList<Jogadores> listaDeJogadores = new LinkedList<>();
    private LinkedList<ComissaoTecnica> listaDeComissaoTecnica = new LinkedList<>();
    private ArrayList<FuncionariosADM> listaDeFuncionariosADM = new ArrayList<>();
    private ArrayList<FuncionariosComum> listaDeFuncionariosComum = new ArrayList<>();
    private LinkedHashMap<String,String> buscaJogadorPorPosicao = new LinkedHashMap<>();
    private LinkedHashMap<String,String> buscaComissaoPorCargo = new LinkedHashMap<>();
    private HashMap<String,String> buscaADMPorCargo = new HashMap<>();
    private HashMap<String,String> buscaComumPorCargo = new HashMap<>();

    public Clube(String nomeDoClube, long CNPJ, String razaoSocial) {
        this.nomeDoClube = nomeDoClube;
        if(CNPJ >=10000000000000L && CNPJ <=99999999999999L){
            this.CNPJ = CNPJ;
        }else{
            throw new InvalidNumberException("Esse CNPJ é inválido");
        }
        this.razaoSocial = razaoSocial;
    }

    public String getNomeDoClube() {
        return nomeDoClube;
    }

    public long getCNPJ() {
        return CNPJ;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public LinkedHashMap<String, String> getBuscaJogadorPorPosicao() {
        return buscaJogadorPorPosicao;
    }

    //métodos de LinkedList de jogadores
    public void adicionaJogadores(Jogadores jogadores){
        this.listaDeJogadores.add(jogadores);
        this.buscaJogadorPorPosicao.put(jogadores.getPosicao(),jogadores.getNomeCompleto());
    }
    public void removeJogadores(Jogadores jogadores){
        this.listaDeJogadores.remove(jogadores);
        this.buscaJogadorPorPosicao.remove(jogadores.getPosicao(),jogadores.getNomeCompleto());
    }
    public List<Jogadores> getListaDeJogadores() {
        return Collections.unmodifiableList(listaDeJogadores) ;
    }
    public void ordenaListaJogadoresPorNome(){
        listaDeJogadores.sort(Comparator.comparing
                (Jogadores::getNomeCompleto));
    }
    public void ordenaListaJogadoresPorPosicao(){
        listaDeJogadores.sort(Comparator.comparing
                (Jogadores::getPosicao));
    }
    //métodos de LinkedList de comissão técnica
    public void adicionaComissaoTecnica(ComissaoTecnica comissao){
        this.listaDeComissaoTecnica.add(comissao);
        this.buscaComissaoPorCargo.put(comissao.getCargo(),comissao.getNomeCompleto());
    }
    public void removeComissaoTecnica(ComissaoTecnica comissao){
        this.listaDeComissaoTecnica.remove(comissao);
        this.buscaComissaoPorCargo.remove(comissao.getCargo(),comissao.getNomeCompleto());
    }
    public List<ComissaoTecnica> getListaDeComissaoTecnica() {
        return Collections.unmodifiableList(listaDeComissaoTecnica) ;
    }
    public void ordenaListaComissaoPorNome(){
        listaDeComissaoTecnica.sort(Comparator.comparing
                (ComissaoTecnica::getNomeCompleto));
    }
    public void ordenaListaComissaoPorCargo(){
        listaDeComissaoTecnica.sort(Comparator.comparing
                (ComissaoTecnica::getCargo));
    }
    //métodos de Arraylist de Funcionários ADM
    public void adicionaFuncionariosADM(FuncionariosADM adm){
        this.listaDeFuncionariosADM.add(adm);
        this.buscaADMPorCargo.put(adm.getCargo(),adm.getNomeCompleto());
    }
    public void removeFuncionariosADM(FuncionariosADM adm){
        this.listaDeFuncionariosADM.remove(adm);
        this.buscaADMPorCargo.remove(adm.getCargo(),adm.getNomeCompleto());
    }
    public List<FuncionariosADM> getListaDeFuncionariosADM() {
        return Collections.unmodifiableList(listaDeFuncionariosADM) ;
    }
    public void ordenaListaADMPorNome(){
        listaDeFuncionariosADM.sort(Comparator.comparing(FuncionariosGerais::getNomeCompleto));
    }
    public void ordenaListaADMPorCargo(){
        listaDeFuncionariosADM.sort((c1,c2)->
                c1.getCargo().compareTo(c2.getCargo()));
    }
    //métodos de Arraylist de Funcionários Comum
    public void adicionaFuncionariosComum(FuncionariosComum comum){
        this.listaDeFuncionariosComum.add(comum);
        this.buscaComumPorCargo.put(comum.getCargo(),comum.getNomeCompleto());
    }
    public void removeFuncionariosComum(FuncionariosComum comum){
        this.listaDeFuncionariosComum.remove(comum);
        this.buscaComumPorCargo.remove(comum.getCargo(),comum.getNomeCompleto());
    }
    public List<FuncionariosComum> getListaDeFuncionariosComum() {
        return Collections.unmodifiableList(listaDeFuncionariosComum) ;
    }
    public void ordenaListaComumPorNome(){
        listaDeFuncionariosComum.sort(Comparator.comparing
                (FuncionariosComum::getNomeCompleto));
    }
    public void ordenaListaComumPorCargo() {
        listaDeFuncionariosComum.sort(Comparator.comparing
                (FuncionariosComum::getCargo));
    }
    //Métodos de LinkedHashMap Jogador
    public Map<String, String> getbuscaJogadorPorPosicao() {
        return Collections.unmodifiableMap(buscaJogadorPorPosicao);
    }
    public String procuraJogadorPelaPosicao(String posicao){
        return buscaJogadorPorPosicao.get(posicao);
    }
    //Métodos de LinkedHashMap Comissao
    public Map<String, String> getBuscaComissaoPorCargo() {
        return Collections.unmodifiableMap(buscaComissaoPorCargo);
    }
    public String procuraComissaoPeloCargo(String cargo){
        return buscaComissaoPorCargo.get(cargo);
    }
    //Métodos de HashMap ADM
    public Map<String, String> getBuscaADMPorCargo() {
        return Collections.unmodifiableMap(buscaADMPorCargo);
    }
    public String procuraADMPeloCargo(String cargo){
        return buscaADMPorCargo.get(cargo);
    }
    //Métodos de HashMap Comum
    public Map<String, String> getBuscaComumPorCargo() {
        return Collections.unmodifiableMap(buscaComumPorCargo);
    }
    public String procuraComumPeloCargo(String cargo){
        return buscaComumPorCargo.get(cargo);
    }

    //métodos de transferir CSV file para List - Jogadores
    public void leCSVFile(String fileName) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(fileName+".csv"),"UTF-8");
        while(scanner.hasNext()){
            String linha = scanner.nextLine();
            Scanner scn = new Scanner(linha);
            scn.useDelimiter(",");
            String nome = scn.next();
            long CPF = scn.nextLong();
            String posicao = scn.next();
            System.out.format("Nome: %s CPF: %d Posicao/Cargo: %s \n"
                    ,nome,CPF,posicao);
            scn.close();
        }

        scanner.close();
    }
    public void criaJogadoresPorCSV(String fileName, Clube clube) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(fileName+".csv"),"UTF-8");
        while(scanner.hasNext()){
            String linha = scanner.nextLine();
            Scanner scn = new Scanner(linha);
            scn.useDelimiter(",");
            String nome = scn.next();
            long CPF = scn.nextLong();
            String posicao = scn.next();
            clube.adicionaJogadores(new Jogadores(nome,CPF,posicao)); ;
            scn.close();
        }
        scanner.close();
    }
    //métodos de transferir CSV file para List - Comissao técnica
    public void criaComissaoPorCSV(String fileName, Clube clube) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(fileName+".csv"),"UTF-8");
        while(scanner.hasNext()){
            String linha = scanner.nextLine();
            Scanner scn = new Scanner(linha);
            scn.useDelimiter(",");
            String nome = scn.next();
            long CPF = scn.nextLong();
            String cargo = scn.next();
            clube.adicionaComissaoTecnica(new ComissaoTecnica(nome,CPF,cargo)); ;
            scn.close();
        }
        scanner.close();
    }
    //métodos de transferir CSV file para List - FuncionariosAdministrativos
    public void criaFuncionarioADMPorCSV(String fileName, Clube clube) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(fileName+".csv"),"UTF-8");
        while(scanner.hasNext()){
            String linha = scanner.nextLine();
            Scanner scn = new Scanner(linha);
            scn.useDelimiter(",");
            String nome = scn.next();
            long CPF = scn.nextLong();
            String cargo = scn.next();
            clube.adicionaFuncionariosADM(new FuncionariosADM(nome,CPF,cargo)); ;
            scn.close();
        }
        scanner.close();
    }
    //métodos de transferir CSV file para List - FuncionariosAdministrativos
    public void criaFuncionarioComumPorCSV(String fileName, Clube clube) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(fileName+".csv"),"UTF-8");
        while(scanner.hasNext()){
            String linha = scanner.nextLine();
            Scanner scn = new Scanner(linha);
            scn.useDelimiter(",");
            String nome = scn.next();
            long CPF = scn.nextLong();
            String cargo = scn.next();
            clube.adicionaFuncionariosComum(new FuncionariosComum(nome,CPF,cargo)); ;
            scn.close();
        }
        scanner.close();
    }

}
