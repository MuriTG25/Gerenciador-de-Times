package br.com.systemfut.atletas_e_comissao;

import br.com.systemfut.Clube.Clube;
import br.com.systemfut.dados_extras.DadosBancarios;
import br.com.systemfut.dados_extras.DadosPessoais;
import br.com.systemfut.exception.InvalidNumberException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.time.DateTimeException;

import static org.junit.jupiter.api.Assertions.*;

class JogadoresTest {

    Jogadores j1;
    Jogadores j2;
    Jogadores j3;
    Clube clube;


    @BeforeEach
    public void criaJogadorEClube(){
        j1 = new Jogadores("Lucas",
                34565476890L,"Atacante");
        j2 = new Jogadores("Roberto",
                34565476560L,"Zagueiro");
        j3 = new Jogadores("Adriano",23565876560L,"Meio-Campo");
        clube = new Clube("Matonense",
                31111266000135L,"Matonense Futebol Clube");
    }
    @Test
    public void TestaJogadorComSalarioMenorque1500(){
        criaJogadorEClube();
        assertThrows(InvalidNumberException.class,
                () -> j1.setSalario(1000.0));
    }
    @Test
    public void TestaJogadorComSalarioNaMedia(){
        criaJogadorEClube();
        j1.setSalario(5000);
        var pagamento = j1.getSalario();
        assertEquals(5000,pagamento);
    }
    @Test
    public void TestaJogadorComSalarioMaiorque50000(){
        criaJogadorEClube();
        assertThrows(InvalidNumberException.class,
                () -> j1.setSalario(100000.0));
    }
    @Test
    public void TestaToStringJogadores(){
        criaJogadorEClube();
        String toString = j1.toString();
        assertEquals("[Nome: Lucas /"+
                " CPF: 34565476890 / Posicao: Atacante]",toString);
    }
    @Test
    public void TestaDataDeAdmisaoDoJogador(){
        criaJogadorEClube();
        j1.setDataDeAdmissao(25,04,2016);
        String dataDeAdmissao = j1.getDataDeAdmissao();
        assertEquals("25/04/2016",dataDeAdmissao);
        String tempoDeTrabalho = j1.tempoDeTrabalho().toString();
        assertEquals("P6Y9M8D",tempoDeTrabalho);
    }
    @Test
    public void TestaDatasInvalidasDeDiaMesEDia2902ForaDeAnoBissexto(){
        criaJogadorEClube();
        assertThrows(DateTimeException.class,() -> j1.setDataDeAdmissao(33,06,2020));
        assertThrows(DateTimeException.class,() -> j1.setDataDeAdmissao(30,13,2020));
        assertThrows(DateTimeException.class,() -> j1.setDataDeAdmissao(29,02,2021));
    }
    @Test
    public void TestaLinkedListDeJogadores(){
        criaJogadorEClube();
        clube.adicionaJogadores(j1);
        clube.adicionaJogadores(j2);
        Jogadores list0 = clube.getListaDeJogadores().get(0);
        Jogadores list1 = clube.getListaDeJogadores().get(1);
        assertEquals(j1,list0);
        assertEquals(j2,list1);
    }
    @Test
    public void TestaMetodoDeBuscaDeLinkedHashMapdeComissaoTecnica(){
        criaJogadorEClube();
        clube.adicionaJogadores(j1);
        String nomeJogador = clube.procuraJogadorPelaPosicao("Atacante");
        assertEquals("Lucas",nomeJogador);
    }
    @Test
    public void TestaRemoveJogadorDeLinkedList(){
        criaJogadorEClube();
        clube.adicionaJogadores(j1);
        Jogadores list0 = clube.getListaDeJogadores().get(0);
        assertEquals(j1,list0);
        String nomeJogador = clube.procuraJogadorPelaPosicao("Atacante");
        assertEquals("Lucas",nomeJogador);
        clube.removeJogadores(j1);
        assertThrows(IndexOutOfBoundsException.class,
                () -> clube.getListaDeJogadores().get(0));
        String removeJogador = clube.procuraJogadorPelaPosicao("Atacante");
        assertEquals(null,nomeJogador);
    }
    @Test
    public void OrganizaALinkedListPeloNomeDosJogadores(){
        criaJogadorEClube();
        clube.adicionaJogadores(j1);
        clube.adicionaJogadores(j2);
        clube.adicionaJogadores(j3);
        clube.ordenaListaJogadoresPorNome();
        String listaJogadores = clube.getListaDeJogadores().toString();
        assertEquals("[[Nome: Adriano / CPF: 23565876560 / Posicao: Meio-Campo], " +
                "[Nome: Lucas / CPF: 34565476890 / Posicao: Atacante], " +
                "[Nome: Roberto / CPF: 34565476560 / Posicao: Zagueiro]]",listaJogadores);
    }
    @Test
    public void OrganizaALinkedListPelaPosicaoDosJogadores(){
        criaJogadorEClube();
        clube.adicionaJogadores(j1);
        clube.adicionaJogadores(j2);
        clube.adicionaJogadores(j3);
        clube.ordenaListaJogadoresPorPosicao();
        String listaJogadores = clube.getListaDeJogadores().toString();
        assertEquals("[[Nome: Lucas / CPF: 34565476890 / Posicao: Atacante], " +
                "[Nome: Adriano / CPF: 23565876560 / Posicao: Meio-Campo], " +
                "[Nome: Roberto / CPF: 34565476560 / Posicao: Zagueiro]]",listaJogadores);
    }
    @Test
    public void TestaDadosPessoaisdoJogador(){
        criaJogadorEClube();
        DadosPessoais p1 = new DadosPessoais();
        j1.setDadosPessoais(p1);
        j1.getDadosPessoais().setCidade("Salto");
        String cidade = j1.getDadosPessoais().getCidade();
        assertEquals("Salto",cidade);
    }
    @Test
    public void TestaDadosBancariosdoJogador(){
        criaJogadorEClube();
        DadosBancarios b1 = new DadosBancarios();
        j1.setDadosDoBanco(b1);
        j1.getDadosDoBanco().setBanco("Bradesco");
        String banco = j1.getDadosDoBanco().getBanco();
        assertEquals("Bradesco",banco);
    }
    @Test
    public void TestaLerArquivosCSV() throws FileNotFoundException {
        criaJogadorEClube();
        clube.leCSVFile("jogadores");
    }
    @Test
    public void CriaJogadoresPeloCSVFile() throws FileNotFoundException {
        criaJogadorEClube();
        clube.criaJogadoresPorCSV("jogadores",clube);
        String jogador1 = clube.getListaDeJogadores().get(0).toString();
        String jogador2 = clube.getListaDeJogadores().get(1).toString();
        String jogador3 = clube.getListaDeJogadores().get(2).toString();
        String jogador4 = clube.getListaDeJogadores().get(3).toString();
        String jogador5 = clube.getListaDeJogadores().get(4).toString();
        assertEquals("[Nome: Murilo / CPF: 34576897687 / Posicao: zagueiro]",jogador1);
        assertEquals("[Nome: Milton / CPF: 74036851802 / Posicao: atacante]",jogador2);
        assertEquals("[Nome: Rogerio / CPF: 33317607815 / Posicao: meio-campo]",jogador3);
        assertEquals("[Nome: Adriano / CPF: 72487692820 / Posicao: lateral-direito]",jogador4);
        assertEquals("[Nome: Sandro Rocha / CPF: 80523094841 / Posicao: goleiro]",jogador5);
        assertThrows(IndexOutOfBoundsException.class,() -> clube.getListaDeJogadores().get(5));
    }
}