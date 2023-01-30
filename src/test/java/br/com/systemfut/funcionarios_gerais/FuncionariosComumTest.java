package br.com.systemfut.funcionarios_gerais;

import br.com.systemfut.Clube.Clube;
import br.com.systemfut.dados_extras.DadosBancarios;
import br.com.systemfut.dados_extras.DadosPessoais;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class FuncionariosComumTest {
    FuncionariosComum fc1;
    FuncionariosComum fc2;
    FuncionariosComum fc3;
    Clube clube;


    @BeforeEach
    public void criaFuncionarioComumEClube(){
        fc1 = new FuncionariosComum("Maicon",
                32456789043L, "Auxiliar de Limpeza Junior");
        fc2 = new FuncionariosComum("Roberto",
                34556789045L, "Massagista senior");
        fc3 = new FuncionariosComum("Adriano",
                34556789045L, "Massagista junior");
        clube = new Clube("Matonense",
                31111266000135L,"Matonense Futebol Clube");
    }
    @Test
    public void TestaToStringFuncionarioComum() {
        criaFuncionarioComumEClube();
        String toString = fc1.toString();
        assertEquals("[Nome: Maicon / CPF: 32456789043"+
                " / Cargo: Auxiliar de Limpeza Junior]", toString);
    }
    @Test
    public void TestaArrayListDeFuncionariosComum(){
        criaFuncionarioComumEClube();
        clube.adicionaFuncionariosComum(fc1);
        clube.adicionaFuncionariosComum(fc2);
        FuncionariosComum list0 = clube.getListaDeFuncionariosComum().get(0);
        FuncionariosComum list1 = clube.getListaDeFuncionariosComum().get(1);
        assertEquals(fc1,list0);
        assertEquals(fc2,list1);
    }
    @Test
    public void TestaMetodoDeBuscadeHashMapdeFuncionariosComum(){
        criaFuncionarioComumEClube();
        clube.adicionaFuncionariosComum(fc1);
        String nomeComum = clube.procuraComumPeloCargo("Auxiliar de Limpeza Junior");
        assertEquals("Maicon",nomeComum);
    }
    @Test
    public void TestaRemoveFuncionariosComumDeLinkedListEHashMap(){
        criaFuncionarioComumEClube();
        clube.adicionaFuncionariosComum(fc1);
        FuncionariosComum list0 = clube.getListaDeFuncionariosComum().get(0);
        assertEquals(fc1,list0);
        String nomeComum = clube.procuraComumPeloCargo("Auxiliar de Limpeza Junior");
        assertEquals("Maicon",nomeComum);
        clube.removeFuncionariosComum(fc1);
        assertThrows(IndexOutOfBoundsException.class,
                () -> clube.getListaDeFuncionariosComum().get(0));
        String removeComum = clube.procuraComumPeloCargo("Auxiliar de Limpeza Junior");
        assertEquals(null,removeComum);
    }
    @Test
    public void OrganizaAArrayListPeloNomeDosFuncionariosADM(){
        criaFuncionarioComumEClube();
        clube.adicionaFuncionariosComum(fc1);
        clube.adicionaFuncionariosComum(fc2);
        clube.adicionaFuncionariosComum(fc3);
        clube.ordenaListaComumPorNome();
        String listaComum = clube.getListaDeFuncionariosComum().toString();
        assertEquals("[[Nome: Adriano / CPF: 34556789045 / Cargo: Massagista junior]," +
                " [Nome: Maicon / CPF: 32456789043 / Cargo: Auxiliar de Limpeza Junior]," +
                " [Nome: Roberto / CPF: 34556789045 / Cargo: Massagista senior]]",listaComum);
    }
    @Test
    public void OrganizaAArrayListPeloCargoDosFuncionariosADM(){
        criaFuncionarioComumEClube();
        clube.adicionaFuncionariosComum(fc1);
        clube.adicionaFuncionariosComum(fc2);
        clube.adicionaFuncionariosComum(fc3);
        clube.ordenaListaComumPorCargo();
        String listaComum = clube.getListaDeFuncionariosComum().toString();
        assertEquals("[[Nome: Maicon / CPF: 32456789043 / Cargo: Auxiliar de Limpeza Junior]," +
                " [Nome: Adriano / CPF: 34556789045 / Cargo: Massagista junior]," +
                " [Nome: Roberto / CPF: 34556789045 / Cargo: Massagista senior]]",listaComum);
    }
    @Test
    public void TestaDadosPessoaisdoFuncionarioComum(){
        criaFuncionarioComumEClube();
        DadosPessoais p1 = new DadosPessoais();
        fc1.setDadosPessoais(p1);
        fc1.getDadosPessoais().setCidade("Salto");
        String cidade = fc1.getDadosPessoais().getCidade();
        assertEquals("Salto",cidade);
    }
    @Test
    public void TestaDadosBancariosdoFuncionarioComum(){
        criaFuncionarioComumEClube();
        DadosBancarios b1 = new DadosBancarios();
        fc1.setDadosDoBanco(b1);
        fc1.getDadosDoBanco().setBanco("Bradesco");
        String banco = fc1.getDadosDoBanco().getBanco();
        assertEquals("Bradesco",banco);
    }
    @Test
    public void TestaLerArquivosCSVFuncionarioComum() throws FileNotFoundException {
        criaFuncionarioComumEClube();
        clube.leCSVFile("funcionariosComum");
    }
    @Test
    public void CriaFuncionarioComumListPeloCSVFile() throws FileNotFoundException {
        criaFuncionarioComumEClube();
        clube.criaFuncionarioComumPorCSV("funcionariosComum",clube);
        String comum1 = clube.getListaDeFuncionariosComum().get(0).toString();
        String comum2 = clube.getListaDeFuncionariosComum().get(1).toString();
        String comum3 = clube.getListaDeFuncionariosComum().get(2).toString();
        String comum4 = clube.getListaDeFuncionariosComum().get(3).toString();
        String comum5 = clube.getListaDeFuncionariosComum().get(4).toString();
        assertEquals("[Nome: Murilo / CPF: 34576897687 / Cargo: massagista junior]",comum1);
        assertEquals("[Nome: Milton / CPF: 74036851802 / Cargo: limpeza junior]",comum2);
        assertEquals("[Nome: Rogerio / CPF: 33317607815 / Cargo: limpeza senior]",comum3);
        assertEquals("[Nome: Adriano / CPF: 72487692820 / Cargo: massagista senior]",comum4);
        assertEquals("[Nome: Sandro Rocha / CPF: 80523094841 / Cargo: roupeiro pleno]",comum5);
        assertThrows(IndexOutOfBoundsException.class,() -> clube.getListaDeFuncionariosComum().get(5));
    }
}