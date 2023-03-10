package br.com.systemfut.aplicacao.reajuste;

import br.com.systemfut.aplicacao.exception.ValorInvalidoException;
import br.com.systemfut.dominio.funcionarios.atletas_e_comissao.ComissaoTecnica;
import br.com.systemfut.dominio.funcionarios.atletas_e_comissao.Jogadores;
import br.com.systemfut.dominio.funcionarios.atributos_Funcionarios.CPF;
import br.com.systemfut.dominio.funcionarios.funcionarios_gerais.FuncionariosADM;
import br.com.systemfut.dominio.funcionarios.funcionarios_gerais.FuncionariosComum;
import br.com.systemfut.dominio.funcionarios.funcionarios_gerais.valores.FuncionariosSalarios;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ReajusteServiceTest {
    FuncionariosADM funcionariosADM;
    FuncionariosADM funcionariosADM2;
    FuncionariosADM funcionariosADM3;
    @BeforeEach
    public void inicializar(){
        funcionariosADM = new FuncionariosADM("Maicon",
                new CPF("98004712002"), "Gerente do Feminino Junior");
        funcionariosADM2 = new FuncionariosADM("Roberto",
                new CPF("54132641007"), "Gerente de Base Senior");
        funcionariosADM3 = new FuncionariosADM("Adriano",
                new CPF("20434949027"), "Secretário Junior");
        funcionariosADM.setSalario(FuncionariosSalarios.GERENTE_JUNIOR);
        funcionariosADM2.setSalario(FuncionariosSalarios.AUXILIAR_DE_ESCRITORIO_JUNIOR);
        funcionariosADM3.setSalario(FuncionariosSalarios.GERENTE_SENIOR);
        funcionariosADM.setDataDeReajusteSalarial(20,2,2022);
        funcionariosADM2.setDataDeReajusteSalarial(20,2,2022);
    }
    @Test
    public void testaAumentoValidoDeSalarioMenorQue15porcentoEEmDataValida(){
        funcionariosADM.reajustaSalario(new BigDecimal("0.15"));
        assertEquals(new BigDecimal("4025.00"),funcionariosADM.getSalario());
    }
    @Test
    public void testaAumentoComOutroValorDeSalario(){
        funcionariosADM2.reajustaSalario(new BigDecimal("0.15"));
        assertEquals(new BigDecimal("2300.00"),funcionariosADM2.getSalario());
    }
    @Test
    public void testaAumentoComOutraPorcentagemDeAumento(){
        funcionariosADM2.reajustaSalario(new BigDecimal("0.10"));
        assertEquals(new BigDecimal("2200.00"),funcionariosADM2.getSalario());
    }
    @Test
    public void testaAumentoInvalidoDeSalarioMaiorQue15porcento(){
        assertThrows(ValorInvalidoException.class,()->
                funcionariosADM.reajustaSalario(new BigDecimal("0.16")));
    }
    @Test
    public void testaDiminuicaoInvalidaDeSalarioAbaixoDoValorAtual(){
        assertThrows(ValorInvalidoException.class,()->
                funcionariosADM.reajustaSalario(new BigDecimal("-0.1")));
    }
    @Test
    public void testaAumentoEmDataInvalida(){
        funcionariosADM.setDataDeReajusteSalarial(20,03,2022);
        assertThrows(ValorInvalidoException.class,()->
                funcionariosADM.reajustaSalario(new BigDecimal("0.15")));
    }
    @Test
    public void testaAumentoEmDataInvalidaFeitoAgora(){
        assertThrows(ValorInvalidoException.class,()->
                funcionariosADM3.reajustaSalario(new BigDecimal("0.15")));
    }
    @Test
    public void impedeReajustarNovamenteSalario(){
        funcionariosADM.reajustaSalario(new BigDecimal("0.15"));
        assertEquals(new BigDecimal("4025.00"),funcionariosADM.getSalario());
        assertThrows(ValorInvalidoException.class,()-> funcionariosADM.
                reajustaSalario(new BigDecimal("0.15")));
    }
    @Test
    public void fazerForEachParaAumentarSalarioDeMaisDeUmFuncionario(){
        ArrayList<FuncionariosADM> lista = new ArrayList<>();
        funcionariosADM3.setDataDeReajusteSalarial(20,2,2022);
        lista.add(funcionariosADM);
        lista.add(funcionariosADM2);
        lista.add(funcionariosADM3);
        lista.forEach(f -> f.reajustaSalario(new BigDecimal("0.15")));
        assertEquals(new BigDecimal("4025.00"),funcionariosADM.getSalario());
        assertEquals(new BigDecimal("2300.00"),funcionariosADM2.getSalario());
        assertEquals(new BigDecimal("9200.00"),funcionariosADM3.getSalario());
    }
    @Test
    public void fazerForEachParaAumentarSalarioDeMaisDeUmFuncionarioMas1ComDataInvalida(){
        ArrayList<FuncionariosADM> lista = new ArrayList<>();
        funcionariosADM3.setDataDeReajusteSalarial(20,4,2022);
        lista.add(funcionariosADM);
        lista.add(funcionariosADM2);
        lista.add(funcionariosADM3);
        assertThrows(ValorInvalidoException.class,()-> lista.forEach(f -> f.reajustaSalario(new BigDecimal("0.15"))));
    }
}