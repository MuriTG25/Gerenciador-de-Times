package br.com.systemfut.dominio.atletas_e_comissao;

import br.com.systemfut.aplicacao.exception.ValorInvalidoException;
import br.com.systemfut.aplicacao.lista_de_funcionarios.fabrica_de_lista.FabricaDeLista;
import br.com.systemfut.dominio.funcionarios.atletas_e_comissao.Jogadores;
import br.com.systemfut.aplicacao.lista_de_funcionarios.ListaDeFuncionarios;
import br.com.systemfut.aplicacao.lista_de_funcionarios.implementacoes.JogadoresListaMetodos;
import br.com.systemfut.dominio.funcionarios.atributos_Funcionarios.CPF;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class JogadoresTest {

    Jogadores j1;
    Jogadores j2;
    Jogadores j3;
    ListaDeFuncionarios funcionarios;
    JogadoresListaMetodos jogadorMetodos;
    FabricaDeLista fabrica;


    @BeforeEach
    public void criaJogadorEClube(){
        j1 = new Jogadores("Lucas",
                new CPF("30044943024"),"Atacante");
        j2 = new Jogadores("Roberto",
                new CPF("45520627002"),"Zagueiro");
        j3 = new Jogadores("Adriano",new CPF("98004712002"),"Meio-Campo");
        funcionarios = new ListaDeFuncionarios();
        jogadorMetodos = new JogadoresListaMetodos(funcionarios);
        fabrica= new FabricaDeLista(funcionarios);
    }
    @Test
    public void TestaJogadorComSalarioMenorque1500(){
        assertThrows(ValorInvalidoException.class,
                () -> j1.setSalario(new BigDecimal("1000.0")));
    }
    @Test
    public void TestaJogadorComSalarioNaMedia(){
        j1.setSalario(new BigDecimal("5000.00"));
        var pagamento = j1.getSalario();
        assertEquals(new BigDecimal("5000.00"),pagamento);
    }
    @Test
    public void TestaJogadorComSalarioComMinimoPermitidoDe1500(){
        j1.setSalario(new BigDecimal("1500.00"));
        var pagamento = j1.getSalario();
        assertEquals(new BigDecimal("1500.00"),pagamento);
    }
    @Test
    public void TestaJogadorComSalarioNoLimiteDe50000(){
        j1.setSalario(new BigDecimal("50000.00"));
        var pagamento = j1.getSalario();
        assertEquals(new BigDecimal("50000.00"),pagamento);
    }
    @Test
    public void TestaJogadorComSalarioMaiorque50000(){
        assertThrows(ValorInvalidoException.class,
                () -> j1.setSalario(new BigDecimal("100000.00")));
    }
    @Test
    public void TestaToStringJogadores(){
        String toString = j1.toString();
        assertEquals("[Nome: Lucas /"+
                " CPF: 30044943024 / Posicao: Atacante]",toString);
    }
    @Test
    public void TestaMetodoDeBuscaDeLinkedHashMapdeComissaoTecnica(){
        fabrica.adicionarFuncionarioNovo(j1);
        String nomeJogador = funcionarios.procuraFuncionarioPeloCargo("Atacante",jogadorMetodos);
        assertEquals("Lucas",nomeJogador);
    }
    @Test
    public void OrganizaALinkedListPeloNomeDosJogadores(){
        fabrica.adicionarFuncionarioNovo(j1);
        fabrica.adicionarFuncionarioNovo(j2);
        fabrica.adicionarFuncionarioNovo(j3);
        funcionarios.ordenaListaFuncionariosPorNome(jogadorMetodos);
        String listaJogadores = funcionarios.getListaDeJogadores().toString();
        assertEquals("[[Nome: Adriano / CPF: 98004712002 / Posicao: Meio-Campo], " +
                "[Nome: Lucas / CPF: 30044943024 / Posicao: Atacante], " +
                "[Nome: Roberto / CPF: 45520627002 / Posicao: Zagueiro]]",listaJogadores);
    }
    @Test
    public void OrganizaALinkedListPelaPosicaoDosJogadores(){
        fabrica.adicionarFuncionarioNovo(j1);
        fabrica.adicionarFuncionarioNovo(j2);
        fabrica.adicionarFuncionarioNovo(j3);
        funcionarios.ordenaListaFuncionariosPorCargo(jogadorMetodos);
        String listaJogadores = funcionarios.getListaDeJogadores().toString();
        assertEquals("[[Nome: Lucas / CPF: 30044943024 / Posicao: Atacante], " +
                "[Nome: Adriano / CPF: 98004712002 / Posicao: Meio-Campo], " +
                "[Nome: Roberto / CPF: 45520627002 / Posicao: Zagueiro]]",listaJogadores);
    }
}