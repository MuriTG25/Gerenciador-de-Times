package br.com.systemfut.funcionarios_gerais;

import br.com.systemfut.Clube.Clube;
import br.com.systemfut.exception.InvalidNumberException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FuncionariosADMTest {
    FuncionariosADM adm1;
    FuncionariosADM adm2;
    FuncionariosADM adm3;
    Clube clube;


    @BeforeEach
    public void criaFuncionarioADMeClube(){
        adm1 = new FuncionariosADM("Maicon",
                32456789043L, "Gerente do Feminino Junior");
        adm2 = new FuncionariosADM("Roberto",
                14556788843L, "Gerente de Base Senior");
        adm3 = new FuncionariosADM("Adriano",
                14336458843L, "Secretário Junior");
        clube = new Clube("Matonense",
                31111266000135L,"Matonense Futebol Clube");
    }
    @Test
    public void TestaToStringFuncionarioADM() {
        criaFuncionarioADMeClube();
        String toString = adm1.toString();
        assertEquals("[Nome: Maicon /"+
                " CPF: 32456789043 / Cargo: Gerente do Feminino Junior]", toString);
    }
    @Test
    public void TestaArrayListDeFuncionariosADM(){
        criaFuncionarioADMeClube();
        clube.adicionaFuncionariosADM(adm1);
        clube.adicionaFuncionariosADM(adm2);
        FuncionariosADM list0 = clube.getListaDeFuncionariosADM().get(0);
        FuncionariosADM list1 = clube.getListaDeFuncionariosADM().get(1);
        assertEquals(adm1,list0);
        assertEquals(adm2,list1);
    }
    @Test
    public void TestaMetodoDeBuscadeHashMapdeFuncionariosADM(){
        criaFuncionarioADMeClube();
        clube.adicionaFuncionariosADM(adm1);
        String nomeADM = clube.procuraADMPeloCargo("Gerente do Feminino Junior");
        assertEquals("Maicon",nomeADM);
    }
    @Test
    public void TestaRemoveFuncionariosADMDdeLinkedListEHashMap(){
        criaFuncionarioADMeClube();
        clube.adicionaFuncionariosADM(adm1);
        FuncionariosADM list0 = clube.getListaDeFuncionariosADM().get(0);
        assertEquals(adm1,list0);
        String nomeADM = clube.procuraADMPeloCargo("Gerente do Feminino Junior");
        assertEquals("Maicon",nomeADM);
        clube.removeFuncionariosADM(adm1);
        assertThrows(IndexOutOfBoundsException.class,
                () -> clube.getListaDeFuncionariosADM().get(0));
        String removeADM = clube.procuraADMPeloCargo("Gerente do Feminino Junior");
        assertEquals(null,removeADM);
    }
    @Test
    public void OrganizaAArrayListPeloNomeDosFuncionariosADM(){
        criaFuncionarioADMeClube();
        clube.adicionaFuncionariosADM(adm1);
        clube.adicionaFuncionariosADM(adm2);
        clube.adicionaFuncionariosADM(adm3);
        clube.ordenaListaADMPorNome();
        String listaAdm = clube.getListaDeFuncionariosADM().toString();
        assertEquals("[[Nome: Adriano / CPF: 14336458843 / Cargo: Secretário Junior]," +
                " [Nome: Maicon / CPF: 32456789043 / Cargo: Gerente do Feminino Junior]," +
                " [Nome: Roberto / CPF: 14556788843 / Cargo: Gerente de Base Senior]]",listaAdm);
    }
    @Test
    public void OrganizaAArrayListPeloCargoDosFuncionariosADM(){
        criaFuncionarioADMeClube();
        clube.adicionaFuncionariosADM(adm1);
        clube.adicionaFuncionariosADM(adm2);
        clube.adicionaFuncionariosADM(adm3);
        clube.ordenaListaADMPorCargo();
        String listaADM = clube.getListaDeFuncionariosADM().toString();
        assertEquals("[[Nome: Roberto / CPF: 14556788843 / Cargo: Gerente de Base Senior]," +
                " [Nome: Maicon / CPF: 32456789043 / Cargo: Gerente do Feminino Junior]," +
                " [Nome: Adriano / CPF: 14336458843 / Cargo: Secretário Junior]]",listaADM);
    }
    @Test
    public void testaGeradorDeSenhacom6digitosNumArquivoProperties(){
        criaFuncionarioADMeClube();
        adm1.setDadosDeLogin("Maicon10","234567");
    }
    @Test
    public void testaGeradorDeSenhaComMenosde6digitosNumArquivoProperties(){
        criaFuncionarioADMeClube();
        assertThrows(InvalidNumberException.class,() ->
                adm1.setDadosDeLogin("Maicon10","12345"));
    }
    @Test
    public void TestaAcessoDeSenhaAPartirDoArquivoProperties(){
        criaFuncionarioADMeClube();
        adm1.acessaDadosDeLogin("Maicon10");
    }
    @Test
    public void TestaLerArquivosCSVFuncionarioADM() throws FileNotFoundException {
        criaFuncionarioADMeClube();
        clube.leCSVFile("funcionariosADM");
    }
    @Test
    public void CriaFuncionarioADMListPeloCSVFile() throws FileNotFoundException {
        criaFuncionarioADMeClube();
        clube.criaFuncionarioADMPorCSV("funcionariosADM",clube);
        String adm1 = clube.getListaDeFuncionariosADM().get(0).toString();
        String adm2 = clube.getListaDeFuncionariosADM().get(1).toString();
        String adm3 = clube.getListaDeFuncionariosADM().get(2).toString();
        String adm4 = clube.getListaDeFuncionariosADM().get(3).toString();
        String adm5 = clube.getListaDeFuncionariosADM().get(4).toString();
        assertEquals("[Nome: Murilo / CPF: 34576897687 / Cargo: auxiliar de escritorio]",adm1);
        assertEquals("[Nome: Milton / CPF: 74036851802 / Cargo: Gerente de Base]",adm2);
        assertEquals("[Nome: Rogerio / CPF: 33317607815 / Cargo: Secretario Junior]",adm3);
        assertEquals("[Nome: Adriano / CPF: 72487692820 / Cargo: auxiliar de escritorio]",adm4);
        assertEquals("[Nome: Sandro Rocha / CPF: 80523094841 / Cargo: Gerente do Profissional Senior]",adm5);
        assertThrows(IndexOutOfBoundsException.class,() -> clube.getListaDeFuncionariosADM().get(5));
    }
}