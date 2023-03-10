package br.com.systemfut.dominio.funcionarios_gerais;

import br.com.systemfut.aplicacao.lista_de_funcionarios.fabrica_de_lista.FabricaDeLista;
import br.com.systemfut.dominio.funcionarios.atributos_Funcionarios.CPF;
import br.com.systemfut.dominio.funcionarios.funcionarios_gerais.FuncionariosADM;
import br.com.systemfut.dominio.funcionarios.funcionarios_gerais.valores.FuncionariosSalarios;
import br.com.systemfut.aplicacao.lista_de_funcionarios.ListaDeFuncionarios;
import br.com.systemfut.aplicacao.lista_de_funcionarios.implementacoes.FuncionariosADMListaMetodos;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FuncionariosADMTest {
    FuncionariosADM adm1;
    FuncionariosADM adm2;
    FuncionariosADM adm3;
    ListaDeFuncionarios funcionarios;
    FuncionariosADMListaMetodos admListaMetodos;
    FabricaDeLista fabrica;


    @BeforeEach
    public void criaFuncionarioADMeClube(){
        adm1 = new FuncionariosADM("Maicon",
                new CPF("98004712002"), "Gerente do Feminino Junior");
        adm2 = new FuncionariosADM("Roberto",
                new CPF("54132641007"), "Gerente de Base Senior");
        adm3 = new FuncionariosADM("Adriano",
                new CPF("20434949027"), "Secretário Junior");
        funcionarios = new ListaDeFuncionarios();
        admListaMetodos = new FuncionariosADMListaMetodos(funcionarios);
        fabrica = new FabricaDeLista(funcionarios);
    }
    @Test
    public void TestaToStringFuncionarioADM() {
        String toString = adm1.toString();
        assertEquals("[Nome: Maicon /"+
                " CPF: 98004712002 / Cargo: Gerente do Feminino Junior]", toString);
    }
    @Test
    public void TestaSalarioDeFuncionarioADM() {
        var maicon = new FuncionariosADM("Maicon", new CPF("98004712002"), "Gerente Junior");
        maicon.setSalario(FuncionariosSalarios.GERENTE_JUNIOR);
        assertEquals(new BigDecimal("3500.00"),maicon.getSalario());
    }
    @Test
    public void TestaMetodoDeBuscadeHashMapdeFuncionariosADM(){
        fabrica.adicionarFuncionarioNovo(adm1);
        String nomeADM = funcionarios.procuraFuncionarioPeloCargo("Gerente do Feminino Junior",admListaMetodos);
        assertEquals("Maicon",nomeADM);
    }
    @Test
    public void OrganizaAArrayListPeloNomeDosFuncionariosADM(){
        fabrica.adicionarFuncionarioNovo(adm1);
        fabrica.adicionarFuncionarioNovo(adm2);
        fabrica.adicionarFuncionarioNovo(adm3);
        funcionarios.ordenaListaFuncionariosPorNome(admListaMetodos);
        String listaAdm = funcionarios.getListaDeFuncionariosADM().toString();
        assertEquals("[[Nome: Adriano / CPF: 20434949027 / Cargo: Secretário Junior]," +
                " [Nome: Maicon / CPF: 98004712002 / Cargo: Gerente do Feminino Junior]," +
                " [Nome: Roberto / CPF: 54132641007 / Cargo: Gerente de Base Senior]]",listaAdm);
    }
    @Test
    public void OrganizaAArrayListPeloCargoDosFuncionariosADM(){
        fabrica.adicionarFuncionarioNovo(adm1);
        fabrica.adicionarFuncionarioNovo(adm2);
        fabrica.adicionarFuncionarioNovo(adm3);
        funcionarios.ordenaListaFuncionariosPorCargo(admListaMetodos);
        String listaADM = funcionarios.getListaDeFuncionariosADM().toString();
        assertEquals("[[Nome: Roberto / CPF: 54132641007 / Cargo: Gerente de Base Senior]," +
                " [Nome: Maicon / CPF: 98004712002 / Cargo: Gerente do Feminino Junior]," +
                " [Nome: Adriano / CPF: 20434949027 / Cargo: Secretário Junior]]",listaADM);
    }
}