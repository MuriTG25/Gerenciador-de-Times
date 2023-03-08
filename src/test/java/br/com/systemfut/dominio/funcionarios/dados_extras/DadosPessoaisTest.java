package br.com.systemfut.dominio.funcionarios.dados_extras;

import br.com.systemfut.aplicacao.exception.ValorInvalidoException;
import br.com.systemfut.dominio.funcionarios.dados_extras.DadosPessoais;
import br.com.systemfut.dominio.funcionarios.dados_extras.atribitos_dados_pessoais.Email;
import br.com.systemfut.dominio.funcionarios.dados_extras.atribitos_dados_pessoais.Telefone;
import br.com.systemfut.dominio.funcionarios.atletas_e_comissao.Jogadores;
import br.com.systemfut.dominio.funcionarios.atributos_Funcionarios.CPF;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.DateTimeException;

import static org.junit.jupiter.api.Assertions.*;

class DadosPessoaisTest {
    DadosPessoais pessoal;
    Jogadores funcionario;
    @BeforeEach
    public void criacaoDeClasse(){
        pessoal = new DadosPessoais();
        funcionario = new Jogadores("Lucas",
                new CPF("98004712002"),"Atacante");
        funcionario.setDadosPessoais(pessoal);
    }
    @Test
    public void TestaDataDeNascimentoEIdade(){
        pessoal.setDataDeNascimento(20,01,1992);
        String dataDeNascimento = pessoal.getDataDeNascimento();
        assertEquals("20/01/1992",dataDeNascimento);
        int idade = pessoal.getIdade();
        assertEquals(31,idade);
        pessoal.setDataDeNascimento(25,12,1992);
        int idade2 = pessoal.getIdade();
        assertEquals(30,idade2);
        pessoal.setDataDeNascimento(25,12,2015);
        int idade3 = pessoal.getIdade();
        assertEquals(7,idade3);
    }
    @Test
    public void TestaDatasInvalidasDeDiaMesEDia2902ForaDeAnoBissexto(){
        assertThrows(DateTimeException.class,() -> pessoal.setDataDeNascimento(33,06,2020));
        assertThrows(DateTimeException.class,() -> pessoal.setDataDeNascimento(30,13,2020));
        assertThrows(DateTimeException.class,() -> pessoal.setDataDeNascimento(29,02,2021));
    }
    @Test
    public void TestaIntegracaoComClasseDeFuncionarios(){
        funcionario.getDadosPessoais().setEstadoCivil("solteiro");
        String estadoCivil = funcionario.getDadosPessoais().getEstadoCivil();
        assertEquals("solteiro",estadoCivil);
    }
    @Test
    public void deveAdicionarAte2Telefones(){
        funcionario.getDadosPessoais().adicionaTelefone(new Telefone("11","996753423"));
        funcionario.getDadosPessoais().adicionaTelefone(new Telefone("11","996753432"));
        assertEquals("[(11)99675-3423, (11)99675-3432]",funcionario.
                getDadosPessoais().getTelefones().toString());
        assertEquals(2,funcionario.getDadosPessoais().getTelefones().size());
    }
    @Test
    public void naoDeveAdicionarMaisQue2Telefones(){
        funcionario.getDadosPessoais().adicionaTelefone(new Telefone("11","996753423"));
        funcionario.getDadosPessoais().adicionaTelefone(new Telefone("11","996753432"));
        assertThrows(ValorInvalidoException.class,() -> funcionario.
                getDadosPessoais().adicionaTelefone(new Telefone("11","996753432")));
    }
    @Test
    public void testeDeRemocaoDeTelefone(){
        funcionario.getDadosPessoais().adicionaTelefone(new Telefone("11","996753423"));
        funcionario.getDadosPessoais().adicionaTelefone(new Telefone("11","996753432"));
        assertEquals("[(11)99675-3423, (11)99675-3432]",funcionario.
                getDadosPessoais().getTelefones().toString());
        assertEquals(2,funcionario.getDadosPessoais().getTelefones().size());
        funcionario.getDadosPessoais().removeTelefone(funcionario.getDadosPessoais().getTelefones().get(1));
        funcionario.getDadosPessoais().removeTelefone(funcionario.getDadosPessoais().getTelefones().get(0));
        assertEquals("[]",funcionario.
                getDadosPessoais().getTelefones().toString());
        assertEquals(0,funcionario.getDadosPessoais().getTelefones().size());
    }
    @Test
    public void consegueCriarEmailAtravesDosDadosPessoais(){
        funcionario.getDadosPessoais().setEmail(new Email("lucas@gmail.com"));
        assertEquals("lucas@gmail.com",funcionario.getDadosPessoais().getEmail());
    }
}