package br.com.systemfut.dominio.atletas_e_comissao;

import br.com.systemfut.aplicacao.exception.ValorInvalidoException;
import br.com.systemfut.aplicacao.lista_de_funcionarios.fabrica_de_lista.FabricaDeLista;
import br.com.systemfut.dominio.funcionarios.atletas_e_comissao.ComissaoTecnica;
import br.com.systemfut.aplicacao.lista_de_funcionarios.ListaDeFuncionarios;
import br.com.systemfut.aplicacao.lista_de_funcionarios.implementacoes.ComissaoTecnicaListaMetodos;
import br.com.systemfut.dominio.funcionarios.atributos_Funcionarios.CPF;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ComissaoTecnicaTest {
    ComissaoTecnica t1;
    ComissaoTecnica t2;
    ComissaoTecnica t3;
    ListaDeFuncionarios funcionarios;
    ComissaoTecnicaListaMetodos comissaoMetodos;
    FabricaDeLista fabrica;


    @BeforeEach
    public void criaComissaoEClube(){
        t1 = new ComissaoTecnica("Lucas",
                new CPF("47624931044"), "técnico");
        t2 = new ComissaoTecnica("Vitor",
                new CPF("63369314045"), "preparador de goleiros");
        t3 = new ComissaoTecnica("Adriano",
                new CPF("30044943024"), "Auxiliar Técnico");
        funcionarios = new ListaDeFuncionarios();
        comissaoMetodos = new ComissaoTecnicaListaMetodos(funcionarios);
        fabrica = new FabricaDeLista(funcionarios);
    }
    @Test
    public void TestaComissaoTecnicaComSalarioMenorque2000(){
        assertThrows(ValorInvalidoException.class,
                () -> t1.setSalario(new BigDecimal("1000.0")));
    }
    @Test
    public void TestaComissaoTecnicaComSalarioNaMedia(){
        t1.setSalario(new BigDecimal("5000.00"));
        var pagamento = t1.getSalario();
        assertEquals(new BigDecimal("5000.00"),pagamento);
    }
    @Test
    public void TestaComissaoTecnicaComSalarioComMinimoPermitidoDe2000(){
        t1.setSalario(new BigDecimal("2000.00"));
        var pagamento = t1.getSalario();
        assertEquals(new BigDecimal("2000.00"),pagamento);
    }
    @Test
    public void TestaComissaoTecnicaComComSalarioComMaximoPermitidoDe20000(){
        t1.setSalario(new BigDecimal("20000.00"));
        var pagamento = t1.getSalario();
        assertEquals(new BigDecimal("20000.00"),pagamento);
    }
    @Test
    public void TestaComissaoTecnicaComSalarioMaiorque20000(){
        assertThrows(ValorInvalidoException.class,
                () -> t1.setSalario(new BigDecimal("100000.0")));
    }
    @Test
    public void TesteToStringComissaoTecnica(){
        var tostring = t1.toString();
        assertEquals("[Nome: Lucas /"+
                " CPF: 47624931044 / Cargo: técnico]",tostring);
    }
    @Test
    public void TestaMetodoDeBuscaDeLinkedHashMapdeComissaoTecnica(){
        fabrica.adicionarFuncionarioNovo(t1);
        String nomeComissao = funcionarios.procuraFuncionarioPeloCargo("técnico",comissaoMetodos);
        assertEquals("Lucas",nomeComissao);
    }
    @Test
    public void OrganizaALinkedListPeloNomeDaComissaoTecnica(){
        fabrica.adicionarFuncionarioNovo(t1);
        fabrica.adicionarFuncionarioNovo(t2);
        fabrica.adicionarFuncionarioNovo(t3);
        funcionarios.ordenaListaFuncionariosPorNome(comissaoMetodos);
        String listaComissao = funcionarios.getListaDeComissaoTecnica().toString();
        assertEquals("[[Nome: Adriano / CPF: 30044943024 / Cargo: Auxiliar Técnico]," +
                " [Nome: Lucas / CPF: 47624931044 / Cargo: técnico]," +
                " [Nome: Vitor / CPF: 63369314045 / Cargo: preparador de goleiros]]",listaComissao);
    }
    @Test
    public void OrganizaALinkedListPeloCargoDaComissaoTecnica(){
        fabrica.adicionarFuncionarioNovo(t1);
        fabrica.adicionarFuncionarioNovo(t2);
        fabrica.adicionarFuncionarioNovo(t3);
        funcionarios.ordenaListaFuncionariosPorCargo(comissaoMetodos);
        String listaComissao = funcionarios.getListaDeComissaoTecnica().toString();
        assertEquals("[[Nome: Adriano / CPF: 30044943024 / Cargo: Auxiliar Técnico]," +
                " [Nome: Vitor / CPF: 63369314045 / Cargo: preparador de goleiros]," +
                " [Nome: Lucas / CPF: 47624931044 / Cargo: técnico]]",listaComissao);
    }
}