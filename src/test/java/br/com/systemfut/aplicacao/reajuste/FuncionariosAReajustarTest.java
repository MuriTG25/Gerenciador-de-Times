package br.com.systemfut.aplicacao.reajuste;

import br.com.systemfut.dominio.funcionarios.atributos_Funcionarios.CPF;
import br.com.systemfut.dominio.funcionarios.funcionarios_gerais.FuncionariosADM;
import br.com.systemfut.dominio.funcionarios.funcionarios_gerais.valores.FuncionariosSalarios;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class FuncionariosAReajustarTest {
    FuncionariosADM funcionariosADM;
    FuncionariosADM funcionariosADM2;
    FuncionariosADM funcionariosADM3;
    FuncionariosAReajustar reajustar;
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
        reajustar = new FuncionariosAReajustar();
    }
    @Test
    public void fazerVerificacaoDeQualFuncionarioPrecisaDeReajusteJogandoOsMesmosEmUmaList() {
        ArrayList<FuncionariosADM> lista = new ArrayList<>();
        funcionariosADM3.setDataDeReajusteSalarial(20, 6, 2022);
        lista.add(funcionariosADM);
        lista.add(funcionariosADM2);
        lista.add(funcionariosADM3);
        lista.forEach(f -> reajustar.verificaFuncionariosNaoReajustados(f));
        assertEquals("[[Nome: Maicon / CPF: 98004712002 / Cargo: Gerente do Feminino Junior]," +
                " [Nome: Roberto / CPF: 54132641007 / Cargo: Gerente de Base Senior]]",
                reajustar.getListaReajuste().toString());
    }
}