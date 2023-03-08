package br.com.systemfut.dominio.funcionarios_gerais;

import br.com.systemfut.aplicacao.lista_de_funcionarios.fabrica_de_lista.FabricaDeLista;
import br.com.systemfut.dominio.funcionarios.atributos_Funcionarios.CPF;
import br.com.systemfut.dominio.funcionarios.funcionarios_gerais.FuncionariosComum;
import br.com.systemfut.dominio.funcionarios.funcionarios_gerais.valores.FuncionariosSalarios;
import br.com.systemfut.aplicacao.lista_de_funcionarios.ListaDeFuncionarios;
import br.com.systemfut.infraestrutura.lista_de_funcionarios.ConversorDeArquivoEmFuncionario;
import br.com.systemfut.aplicacao.lista_de_funcionarios.implementacoes.FuncionariosComumListaMetodos;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class FuncionariosComumTest {
    FuncionariosComum fc1;
    FuncionariosComum fc2;
    FuncionariosComum fc3;
    ListaDeFuncionarios funcionarios;
    ConversorDeArquivoEmFuncionario conversor;
    FuncionariosComumListaMetodos comumListaMetodos;
    FabricaDeLista fabrica;

    @BeforeEach
    public void criaFuncionarioComumEClube(){
        fc1 = new FuncionariosComum("Maicon",
                new CPF("20434949027"), "Auxiliar de Limpeza Junior");
        fc2 = new FuncionariosComum("Roberto",
                new CPF("17768821050"), "Massagista senior");
        fc3 = new FuncionariosComum("Adriano",
                new CPF("09642034050"), "Massagista junior");
        funcionarios = new ListaDeFuncionarios();
        conversor = new ConversorDeArquivoEmFuncionario();
        comumListaMetodos = new FuncionariosComumListaMetodos(funcionarios);
        fabrica = new FabricaDeLista(funcionarios);
    }
    @Test
    public void TestaToStringFuncionarioComum() {
        String toString = fc1.toString();
        assertEquals("[Nome: Maicon / CPF: 20434949027"+
                " / Cargo: Auxiliar de Limpeza Junior]", toString);
    }
    @Test
    public void TestaSalarioDeFuncionarioComum(){
        var maicon = new FuncionariosComum("Maicon", new CPF("20434949027"),"Auxiliar de Limpeza Junior");
        maicon.setSalario(FuncionariosSalarios.LIMPEZA_JUNIOR);
        assertEquals(new BigDecimal("1100.00"),maicon.getSalario());
    }
    @Test
    public void TestaMetodoDeBuscadeHashMapdeFuncionariosComum(){
        fabrica.adicionarFuncionarioNovo(fc1);
        String nomeComum = funcionarios.procuraFuncionarioPeloCargo(
                "Auxiliar de Limpeza Junior",comumListaMetodos);
        assertEquals("Maicon",nomeComum);
    }
    @Test
    public void OrganizaAArrayListPeloNomeDosFuncionariosADM(){
        fabrica.adicionarFuncionarioNovo(fc1);
        fabrica.adicionarFuncionarioNovo(fc2);
        fabrica.adicionarFuncionarioNovo(fc3);
        funcionarios.ordenaListaFuncionariosPorNome(comumListaMetodos);
        String listaComum = funcionarios.getListaDeFuncionariosComum().toString();
        assertEquals("[[Nome: Adriano / CPF: 09642034050 / Cargo: Massagista junior]," +
                " [Nome: Maicon / CPF: 20434949027 / Cargo: Auxiliar de Limpeza Junior]," +
                " [Nome: Roberto / CPF: 17768821050 / Cargo: Massagista senior]]",listaComum);
    }
    @Test
    public void OrganizaAArrayListPeloCargoDosFuncionariosADM(){
        fabrica.adicionarFuncionarioNovo(fc1);
        fabrica.adicionarFuncionarioNovo(fc2);
        fabrica.adicionarFuncionarioNovo(fc3);
        funcionarios.ordenaListaFuncionariosPorCargo(comumListaMetodos);
        String listaComum = funcionarios.getListaDeFuncionariosComum().toString();
        assertEquals("[[Nome: Maicon / CPF: 20434949027 / Cargo: Auxiliar de Limpeza Junior]," +
                " [Nome: Adriano / CPF: 09642034050 / Cargo: Massagista junior]," +
                " [Nome: Roberto / CPF: 17768821050 / Cargo: Massagista senior]]",listaComum);
    }
}