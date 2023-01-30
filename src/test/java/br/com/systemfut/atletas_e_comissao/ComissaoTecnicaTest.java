package br.com.systemfut.atletas_e_comissao;

import br.com.systemfut.Clube.Clube;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ComissaoTecnicaTest {
    ComissaoTecnica t1;
    ComissaoTecnica t2;
    ComissaoTecnica t3;
    Clube clube;


    @BeforeEach
    public void criaComissaoEClube(){
        t1 = new ComissaoTecnica("Lucas",
                34565476890L, "técnico");
        t2 = new ComissaoTecnica("Vitor",
                14565476350L, "preparador de goleiros");
        t3 = new ComissaoTecnica("Adriano",
                14533376350L, "Auxiliar Técnico");
        clube = new Clube("Matonense",
                31111266000135L,"Matonense Futebol Clube");
    }
    @Test
    public void TestaComissaoTecnicaComSalarioMenorque2000(){
        criaComissaoEClube();
        assertThrows(ArithmeticException.class,
                () -> t1.setSalario(1000.0));
    }
    @Test
    public void TestaComissaoTecnicaComSalarioNaMedia(){
        criaComissaoEClube();
        t1.setSalario(5000);
        var pagamento = t1.getSalario();
        assertEquals(5000,pagamento);
    }
    @Test
    public void TestaComissaoTecnicaComSalarioMaiorque20000(){
        criaComissaoEClube();
        assertThrows(ArithmeticException.class,
                () -> t1.setSalario(100000.0));
    }
    @Test
    public void VerificaCPFcomMenosDe11digitos(){
        assertThrows(ArithmeticException.class,() ->
                new ComissaoTecnica("Lucas",
                        1234567890L, "técnico"));
    }
    @Test
    public void VerificaCPFValidocom11digitos(){
        var t3 = new ComissaoTecnica("Lucas",
                34565476890L, "técnico");
        var cpf = t3.getCPF();
        assertEquals(34565476890L,cpf);
    }
    @Test
    public void VerificaCPFcomMaisDe11digitos(){
        assertThrows(ArithmeticException.class,() ->
                new ComissaoTecnica("Vitor",
                        123456789012L, "técnico"));
    }
    @Test
    public void TesteToStringComissaoTecnica(){
        criaComissaoEClube();
        var tostring = t1.toString();
        assertEquals("[Nome: Lucas /"+
                " CPF: 34565476890 / Cargo: técnico]",tostring);
    }
    @Test
    public void TestaLinkedListDeComissaoTecnica(){
        criaComissaoEClube();
        clube.adicionaComissaoTecnica(t1);
        clube.adicionaComissaoTecnica(t2);
        ComissaoTecnica list0 = clube.getListaDeComissaoTecnica().get(0);
        ComissaoTecnica list1 = clube.getListaDeComissaoTecnica().get(1);
        assertEquals(t1,list0);
        assertEquals(t2,list1);
    }
    @Test
    public void TestaMetodoDeBuscaDeLinkedHashMapdeComissaoTecnica(){
        criaComissaoEClube();
        clube.adicionaComissaoTecnica(t1);
        String nomeComissao = clube.procuraComissaoPeloCargo("técnico");
        assertEquals("Lucas",nomeComissao);
    }
    @Test
    public void TestaRemoveComissaoTecnicaDeLinkedListELinkedHashMap(){
        criaComissaoEClube();
        clube.adicionaComissaoTecnica(t1);
        ComissaoTecnica list0 = clube.getListaDeComissaoTecnica().get(0);
        assertEquals(t1,list0);
        String nomeComissao = clube.procuraComissaoPeloCargo("técnico");
        assertEquals("Lucas",nomeComissao);
        clube.removeComissaoTecnica(t1);
        assertThrows(IndexOutOfBoundsException.class,
                () -> clube.getListaDeComissaoTecnica().get(0));
        String nomeRemovido = clube.procuraComissaoPeloCargo("técnico");
        assertEquals(null,nomeRemovido);
    }
    @Test
    public void OrganizaALinkedListPeloNomeDaComissaoTecnica(){
        criaComissaoEClube();
        clube.adicionaComissaoTecnica(t1);
        clube.adicionaComissaoTecnica(t2);
        clube.adicionaComissaoTecnica(t3);
        clube.ordenaListaComissaoPorNome();
        String listaComissao = clube.getListaDeComissaoTecnica().toString();
        assertEquals("[[Nome: Adriano / CPF: 14533376350 / Cargo: Auxiliar Técnico]," +
                " [Nome: Lucas / CPF: 34565476890 / Cargo: técnico]," +
                " [Nome: Vitor / CPF: 14565476350 / Cargo: preparador de goleiros]]",listaComissao);
    }
    @Test
    public void OrganizaALinkedListPeloCargoDaComissaoTecnica(){
        criaComissaoEClube();
        clube.adicionaComissaoTecnica(t1);
        clube.adicionaComissaoTecnica(t2);
        clube.adicionaComissaoTecnica(t3);
        clube.ordenaListaComissaoPorCargo();
        String listaComissao = clube.getListaDeComissaoTecnica().toString();
        assertEquals("[[Nome: Adriano / CPF: 14533376350 / Cargo: Auxiliar Técnico]," +
                " [Nome: Vitor / CPF: 14565476350 / Cargo: preparador de goleiros]," +
                " [Nome: Lucas / CPF: 34565476890 / Cargo: técnico]]",listaComissao);
    }
    @Test
    public void testaGeradorDeSenhaDe6DigitosParaComissaoTecnicaNumArquivoProperties(){
        criaComissaoEClube();
        t1.setDadosDeLogin("Lucas10","234567");
    }
    @Test
    public void testaGeradorDeSenhacomMenosDe6digitosParaComissaoTecnicaNumArquivoProperties(){
        criaComissaoEClube();
        assertThrows(ArithmeticException.class,() ->
                t1.setDadosDeLogin("Lucas10","12345"));

    }
    @Test
    public void TestaAcessoDeSenhaDaComissaoTecnicaAPartirDoArquivoProperties(){
        criaComissaoEClube();
        t1.acessaDadosDeLogin("Lucas10");
    }
    @Test
    public void TestaLerArquivosCSVComissao() throws FileNotFoundException {
        criaComissaoEClube();
        clube.leCSVFile("comissao");
    }
    @Test
    public void CriaComissaoTecnicaListPeloCSVFile() throws FileNotFoundException {
        criaComissaoEClube();
        clube.criaComissaoPorCSV("comissao",clube);
        String comissao1 = clube.getListaDeComissaoTecnica().get(0).toString();
        String comissao2 = clube.getListaDeComissaoTecnica().get(1).toString();
        String comissao3 = clube.getListaDeComissaoTecnica().get(2).toString();
        String comissao4 = clube.getListaDeComissaoTecnica().get(3).toString();
        String comissao5 = clube.getListaDeComissaoTecnica().get(4).toString();
        assertEquals("[Nome: Murilo / CPF: 34576897687 / Cargo: treinador]",comissao1);
        assertEquals("[Nome: Milton / CPF: 74036851802 / Cargo: preparador de goleiros]",comissao2);
        assertEquals("[Nome: Rogerio / CPF: 33317607815 / Cargo: assistente tecnico]",comissao3);
        assertEquals("[Nome: Adriano / CPF: 72487692820 / Cargo: preparador fisico]",comissao4);
        assertEquals("[Nome: Sandro Rocha / CPF: 80523094841 / Cargo: fisioterapeuta]",comissao5);
        assertThrows(IndexOutOfBoundsException.class,() -> clube.getListaDeComissaoTecnica().get(5));
    }
}