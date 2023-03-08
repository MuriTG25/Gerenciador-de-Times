package br.com.systemfut.infraestrutura.senha;

import br.com.systemfut.aplicacao.exception.ValorInvalidoException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.system.CapturedOutput;
import org.springframework.boot.test.system.OutputCaptureExtension;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(OutputCaptureExtension.class)
class CriadorEAcessadorDeSenhasArquivoPropertiesTest {
    CriadorEAcessadorDeSenhasArquivoProperties criador;
    @BeforeEach
    public void criadorDeSenha(){
        criador = new CriadorEAcessadorDeSenhasArquivoProperties();
    }
    @Test
    public void testaGeradorDeSenhaDe6DigitosParaComissaoTecnicaNumArquivoProperties(CapturedOutput output){
        criador.setDadosDeLogin("Lucas102","234567");
        criador.acessaDadosDeLogin("Lucas102");
        assertEquals("Lucas102, 234567, systemfut.com.br", output.getOut().trim());
    }
    @Test
    public void testaGeradorDeSenhacomMenosDe6digitosParaComissaoTecnicaNumArquivoProperties(){
        assertThrows(ValorInvalidoException.class,() ->
            criador.setDadosDeLogin("Lucas10","12345"));

    }
    @Test
    public void TestaAcessoDeSenhaDaComissaoTecnicaAPartirDoArquivoProperties(CapturedOutput output){
        criador.acessaDadosDeLogin("Lucas10");
        assertEquals("Lucas10, 234567, systemfut.com.br", output.getOut().trim());
    }

}