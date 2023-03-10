package br.com.systemfut.aplicacao.lista_de_funcionarios.implementacoes.fabrica_de_lista;

import br.com.systemfut.aplicacao.lista_de_funcionarios.ListaDeFuncionarios;
import br.com.systemfut.aplicacao.lista_de_funcionarios.fabrica_de_lista.FabricaDeLista;
import br.com.systemfut.dominio.funcionarios.atletas_e_comissao.ComissaoTecnica;
import br.com.systemfut.dominio.funcionarios.atletas_e_comissao.Jogadores;
import br.com.systemfut.dominio.funcionarios.atributos_Funcionarios.CPF;
import br.com.systemfut.dominio.funcionarios.funcionarios_gerais.FuncionariosADM;
import br.com.systemfut.dominio.funcionarios.funcionarios_gerais.FuncionariosComum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FabricaDeListaTest {
    ComissaoTecnica tecnico;
    FuncionariosComum comum;
    FuncionariosADM adm;
    Jogadores jogador;
    ListaDeFuncionarios lista;
    FabricaDeLista fabrica;
    @BeforeEach
    public void criaListaEFuncionarios(){
        lista = new ListaDeFuncionarios();
        tecnico = new ComissaoTecnica("Lucas",
                new CPF("47624931044"), "técnico");
        jogador = new Jogadores("Lucas",
                new CPF("30044943024"),"Atacante");
        adm = new FuncionariosADM("Maicon",
                new CPF("98004712002"), "Gerente do Feminino Junior");
        comum = new FuncionariosComum("Maicon",
                new CPF("20434949027"), "Auxiliar de Limpeza Junior");
        fabrica = new FabricaDeLista(this.lista);
    }
    @Test
    public void TestaAdicionarJogadoresNaLista(){
        this.fabrica.adicionarFuncionarioNovo(jogador);
        String funcionario = lista.getListaDeJogadores().get(0).toString();
        assertEquals("[Nome: Lucas / CPF: 30044943024 / Posicao: Atacante]",funcionario);
        assertThrows(IndexOutOfBoundsException.class, ()-> lista.getListaDeFuncionariosComum().get(0));
        assertThrows(IndexOutOfBoundsException.class, ()-> lista.getListaDeFuncionariosADM().get(0));
        assertThrows(IndexOutOfBoundsException.class, ()-> lista.getListaDeComissaoTecnica().get(0));

    }
    @Test
    public void TestaAdicionarComissaoTecnicaNaLista(){
        this.fabrica.adicionarFuncionarioNovo(tecnico);
        String funcionario = lista.getListaDeComissaoTecnica().get(0).toString();
        assertEquals("[Nome: Lucas / CPF: 47624931044 / Cargo: técnico]",funcionario);
        assertThrows(IndexOutOfBoundsException.class, ()-> lista.getListaDeFuncionariosComum().get(0));
        assertThrows(IndexOutOfBoundsException.class, ()-> lista.getListaDeFuncionariosADM().get(0));
        assertThrows(IndexOutOfBoundsException.class, ()-> lista.getListaDeJogadores().get(0));
    }
    @Test
    public void TestaAdicionarFuncionarioComumNaLista(){
        this.fabrica.adicionarFuncionarioNovo(comum);
        String funcionario = lista.getListaDeFuncionariosComum().get(0).toString();
        assertEquals("[Nome: Maicon / CPF: 20434949027 / Cargo: Auxiliar de Limpeza Junior]",funcionario);
        assertThrows(IndexOutOfBoundsException.class, ()-> lista.getListaDeComissaoTecnica().get(0));
        assertThrows(IndexOutOfBoundsException.class, ()-> lista.getListaDeFuncionariosADM().get(0));
        assertThrows(IndexOutOfBoundsException.class, ()-> lista.getListaDeJogadores().get(0));
    }
    @Test
    public void TestaAdicionarFuncionarioADMNaLista(){
        this.fabrica.adicionarFuncionarioNovo(adm);
        String funcionario = lista.getListaDeFuncionariosADM().get(0).toString();
        assertEquals("[Nome: Maicon / CPF: 98004712002 / Cargo: Gerente do Feminino Junior]",funcionario);
        assertThrows(IndexOutOfBoundsException.class, ()-> lista.getListaDeFuncionariosComum().get(0));
        assertThrows(IndexOutOfBoundsException.class, ()-> lista.getListaDeComissaoTecnica().get(0));
        assertThrows(IndexOutOfBoundsException.class, ()-> lista.getListaDeJogadores().get(0));
    }
    @Test
    public void TestaRemoverJogadoresNaLista(){
        this.fabrica.adicionarFuncionarioNovo(jogador);
        String funcionario = lista.getListaDeJogadores().get(0).toString();
        assertEquals("[Nome: Lucas / CPF: 30044943024 / Posicao: Atacante]",funcionario);
        fabrica.removeFuncionarioNovo(jogador);
        assertThrows(IndexOutOfBoundsException.class, ()-> lista.getListaDeJogadores().get(0));
    }
    @Test
    public void TestaRemoverComissaoTecnicaNaLista(){
        this.fabrica.adicionarFuncionarioNovo(tecnico);
        String funcionario = lista.getListaDeComissaoTecnica().get(0).toString();
        assertEquals("[Nome: Lucas / CPF: 47624931044 / Cargo: técnico]",funcionario);
        fabrica.removeFuncionarioNovo(tecnico);
        assertThrows(IndexOutOfBoundsException.class, ()-> lista.getListaDeComissaoTecnica().get(0));
    }
    @Test
    public void TestaRemoverFuncionarioComumNaLista(){
        this.fabrica.adicionarFuncionarioNovo(comum);
        String funcionario = lista.getListaDeFuncionariosComum().get(0).toString();
        assertEquals("[Nome: Maicon / CPF: 20434949027 / Cargo: Auxiliar de Limpeza Junior]",funcionario);
        fabrica.removeFuncionarioNovo(comum);
        assertThrows(IndexOutOfBoundsException.class, ()-> lista.getListaDeFuncionariosComum().get(0));
    }
    @Test
    public void TestaRemoverFuncionarioADMNaLista(){
        this.fabrica.adicionarFuncionarioNovo(adm);
        String funcionario = lista.getListaDeFuncionariosADM().get(0).toString();
        assertEquals("[Nome: Maicon / CPF: 98004712002 / Cargo: Gerente do Feminino Junior]",funcionario);
        fabrica.removeFuncionarioNovo(adm);
        assertThrows(IndexOutOfBoundsException.class, ()-> lista.getListaDeFuncionariosADM().get(0));
    }


}