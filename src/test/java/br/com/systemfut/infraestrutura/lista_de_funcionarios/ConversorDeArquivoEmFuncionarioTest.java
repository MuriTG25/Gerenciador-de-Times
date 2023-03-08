package br.com.systemfut.infraestrutura.lista_de_funcionarios;

import br.com.systemfut.aplicacao.lista_de_funcionarios.ListaDeFuncionarios;
import br.com.systemfut.infraestrutura.lista_de_funcionarios.conversor.ConversorDeCSV;
import br.com.systemfut.infraestrutura.lista_de_funcionarios.tipo_funcionario.ComissaoTecnicaConversor;
import br.com.systemfut.infraestrutura.lista_de_funcionarios.tipo_funcionario.FuncionarioADMConversor;
import br.com.systemfut.infraestrutura.lista_de_funcionarios.tipo_funcionario.FuncionarioComumConversor;
import br.com.systemfut.infraestrutura.lista_de_funcionarios.tipo_funcionario.JogadoresConversor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.system.CapturedOutput;
import org.springframework.boot.test.system.OutputCaptureExtension;
import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(OutputCaptureExtension.class)
class ConversorDeArquivoEmFuncionarioTest {
    ListaDeFuncionarios funcionarios;
    ConversorDeArquivoEmFuncionario conversor;
    ConversorDeCSV csv;
    ComissaoTecnicaConversor comissao;
    FuncionarioComumConversor comum;
    FuncionarioADMConversor adm;
    JogadoresConversor jogadores;
    @BeforeEach
    public void instanciaClasses(){
        funcionarios= new ListaDeFuncionarios();
        conversor = new ConversorDeArquivoEmFuncionario();
        csv = new ConversorDeCSV();
        comissao = new ComissaoTecnicaConversor(funcionarios);
        comum = new FuncionarioComumConversor(funcionarios);
        adm = new FuncionarioADMConversor(funcionarios);
        jogadores = new JogadoresConversor(funcionarios);


    }
    @Test
    public void TestaLerArquivosCSVComissao(CapturedOutput output) throws FileNotFoundException {
        conversor.leArquivoNaTela("comissao",csv);
        assertEquals("""
                Nome: Murilo CPF: 17768821050 Posicao/Cargo: treinador\s
                Nome: Milton CPF: 05554659004 Posicao/Cargo: preparador de goleiros\s
                Nome: Rogerio CPF: 40532219007 Posicao/Cargo: assistente tecnico\s
                Nome: Adriano CPF: 38483885026 Posicao/Cargo: preparador fisico\s
                Nome: Sandro Rocha CPF: 12128376068 Posicao/Cargo: fisioterapeuta""", output.getOut().trim());
    }
    @Test
    public void CriaComissaoTecnicaListPeloCSVFile() throws FileNotFoundException {
        conversor.importaArquivoParaListaDeFuncionarios("comissao",comissao,csv);
        String comissao1 = funcionarios.getListaDeComissaoTecnica().get(0).toString();
        String comissao2 = funcionarios.getListaDeComissaoTecnica().get(1).toString();
        String comissao3 = funcionarios.getListaDeComissaoTecnica().get(2).toString();
        String comissao4 = funcionarios.getListaDeComissaoTecnica().get(3).toString();
        String comissao5 = funcionarios.getListaDeComissaoTecnica().get(4).toString();
        assertEquals("[Nome: Murilo / CPF: 17768821050 / Cargo: treinador]",comissao1);
        assertEquals("[Nome: Milton / CPF: 05554659004 / Cargo: preparador de goleiros]",comissao2);
        assertEquals("[Nome: Rogerio / CPF: 40532219007 / Cargo: assistente tecnico]",comissao3);
        assertEquals("[Nome: Adriano / CPF: 38483885026 / Cargo: preparador fisico]",comissao4);
        assertEquals("[Nome: Sandro Rocha / CPF: 12128376068 / Cargo: fisioterapeuta]",comissao5);
        assertThrows(IndexOutOfBoundsException.class,() -> funcionarios.getListaDeComissaoTecnica().get(5));
    }
    @Test
    public void CriaFuncionarioADMListPeloCSVFile() throws FileNotFoundException {
        conversor.importaArquivoParaListaDeFuncionarios("funcionariosADM",adm,csv);
        String adm1 = funcionarios.getListaDeFuncionariosADM().get(0).toString();
        String adm2 = funcionarios.getListaDeFuncionariosADM().get(1).toString();
        String adm3 = funcionarios.getListaDeFuncionariosADM().get(2).toString();
        String adm4 = funcionarios.getListaDeFuncionariosADM().get(3).toString();
        String adm5 = funcionarios.getListaDeFuncionariosADM().get(4).toString();
        assertEquals("[Nome: Murilo / CPF: 17768821050 / Cargo: auxiliar de escritorio]",adm1);
        assertEquals("[Nome: Milton / CPF: 05554659004 / Cargo: Gerente de Base]",adm2);
        assertEquals("[Nome: Rogerio / CPF: 40532219007 / Cargo: Secretario Junior]",adm3);
        assertEquals("[Nome: Adriano / CPF: 38483885026 / Cargo: auxiliar de escritorio]",adm4);
        assertEquals("[Nome: Sandro Rocha / CPF: 12128376068 / Cargo: Gerente do Profissional Senior]",adm5);
        assertThrows(IndexOutOfBoundsException.class,() -> funcionarios.getListaDeFuncionariosADM().get(5));
    }
    @Test
    public void CriaJogadoresPeloCSVFile() throws FileNotFoundException {
        conversor.importaArquivoParaListaDeFuncionarios("jogadores",jogadores,csv);
        String jogador1 = funcionarios.getListaDeJogadores().get(0).toString();
        String jogador2 = funcionarios.getListaDeJogadores().get(1).toString();
        String jogador3 = funcionarios.getListaDeJogadores().get(2).toString();
        String jogador4 = funcionarios.getListaDeJogadores().get(3).toString();
        String jogador5 = funcionarios.getListaDeJogadores().get(4).toString();
        assertEquals("[Nome: Murilo / CPF: 17768821050 / Posicao: zagueiro]",jogador1);
        assertEquals("[Nome: Milton / CPF: 05554659004 / Posicao: atacante]",jogador2);
        assertEquals("[Nome: Rogerio / CPF: 40532219007 / Posicao: meio-campo]",jogador3);
        assertEquals("[Nome: Adriano / CPF: 38483885026 / Posicao: lateral-direito]",jogador4);
        assertEquals("[Nome: Sandro Rocha / CPF: 12128376068 / Posicao: goleiro]",jogador5);
        assertThrows(IndexOutOfBoundsException.class,() -> funcionarios.getListaDeJogadores().get(5));
    }
    @Test
    public void CriaFuncionarioComumListPeloCSVFile() throws FileNotFoundException {
        conversor.importaArquivoParaListaDeFuncionarios("funcionariosComum2",comum,csv);
        String comum1 = funcionarios.getListaDeFuncionariosComum().get(0).toString();
        String comum2 = funcionarios.getListaDeFuncionariosComum().get(1).toString();
        String comum3 = funcionarios.getListaDeFuncionariosComum().get(2).toString();
        String comum4 = funcionarios.getListaDeFuncionariosComum().get(3).toString();
        String comum5 = funcionarios.getListaDeFuncionariosComum().get(4).toString();
        assertEquals("[Nome: Murilo / CPF: 17768821050 / Cargo: massagista junior]",comum1);
        assertEquals("[Nome: Milton / CPF: 05554659004 / Cargo: limpeza junior]",comum2);
        assertEquals("[Nome: Rogerio / CPF: 38483885026 / Cargo: limpeza senior]",comum3);
        assertEquals("[Nome: Adriano / CPF: 72487692820 / Cargo: massagista senior]",comum4);
        assertEquals("[Nome: Sandro Rocha / CPF: 12128376068 / Cargo: roupeiro pleno]",comum5);
        assertThrows(IndexOutOfBoundsException.class,() -> funcionarios.getListaDeFuncionariosComum().get(5));
    }
    @Test
    public void pegaListaDeJogadorETransformaEmArquivoCSV(CapturedOutput output) throws IOException  {
        conversor.importaArquivoParaListaDeFuncionarios("jogadores",jogadores,csv);
        conversor.exportaListaFuncionariosParaArquivo("jogadores2",jogadores,csv);
        conversor.leArquivoNaTela("jogadores2",csv);
        assertEquals("""
                Nome: Murilo CPF: 17768821050 Posicao/Cargo: zagueiro\s
                Nome: Milton CPF: 05554659004 Posicao/Cargo: atacante\s
                Nome: Rogerio CPF: 40532219007 Posicao/Cargo: meio-campo\s
                Nome: Adriano CPF: 38483885026 Posicao/Cargo: lateral-direito\s
                Nome: Sandro Rocha CPF: 12128376068 Posicao/Cargo: goleiro""", output.getOut().trim());
    }
    @Test
    public void pegaListaDeComissaoETransformaEmArquivoCSV(CapturedOutput output) throws IOException  {
        conversor.importaArquivoParaListaDeFuncionarios("comissao",comissao,csv);
        conversor.exportaListaFuncionariosParaArquivo("comissao2",comissao,csv);
        conversor.leArquivoNaTela("comissao2",csv);
        assertEquals("""
                Nome: Murilo CPF: 17768821050 Posicao/Cargo: treinador\s
                Nome: Milton CPF: 05554659004 Posicao/Cargo: preparador de goleiros\s
                Nome: Rogerio CPF: 40532219007 Posicao/Cargo: assistente tecnico\s
                Nome: Adriano CPF: 38483885026 Posicao/Cargo: preparador fisico\s
                Nome: Sandro Rocha CPF: 12128376068 Posicao/Cargo: fisioterapeuta""", output.getOut().trim());
    }
    @Test
    public void pegaListaDeFuncionariosADMEETransformaEmArquivoCSV(CapturedOutput output) throws IOException {
        conversor.importaArquivoParaListaDeFuncionarios("funcionariosADM",adm,csv);
        conversor.exportaListaFuncionariosParaArquivo("funcionariosADM2",adm,csv);
        conversor.leArquivoNaTela("funcionariosADM2",csv);
        assertEquals("""
                Nome: Murilo CPF: 17768821050 Posicao/Cargo: auxiliar de escritorio\s
                Nome: Milton CPF: 05554659004 Posicao/Cargo: Gerente de Base\s
                Nome: Rogerio CPF: 40532219007 Posicao/Cargo: Secretario Junior\s
                Nome: Adriano CPF: 38483885026 Posicao/Cargo: auxiliar de escritorio\s
                Nome: Sandro Rocha CPF: 12128376068 Posicao/Cargo: Gerente do Profissional Senior""", output.getOut().trim());
    }
    @Test
    public void pegaListaDeFuncionariosComumETransformaEmArquivoCSV(CapturedOutput output) throws IOException {
        conversor.importaArquivoParaListaDeFuncionarios("funcionariosComum",comum,csv);
        conversor.exportaListaFuncionariosParaArquivo("funcionariosComum2",comum,csv);
        conversor.leArquivoNaTela("funcionariosComum2",csv);
        assertEquals("""
                Nome: Murilo CPF: 17768821050 Posicao/Cargo: massagista junior\s
                Nome: Milton CPF: 05554659004 Posicao/Cargo: limpeza junior\s
                Nome: Rogerio CPF: 38483885026 Posicao/Cargo: limpeza senior\s
                Nome: Adriano CPF: 72487692820 Posicao/Cargo: massagista senior\s
                Nome: Sandro Rocha CPF: 12128376068 Posicao/Cargo: roupeiro pleno""", output.getOut().trim());
    }

}