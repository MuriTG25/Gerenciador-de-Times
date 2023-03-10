package br.com.systemfut.dominio.funcionarios.dados_extras.atribitos_dados_pessoais;

import br.com.systemfut.aplicacao.exception.ValorInvalidoException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmailTest {

    @Test
    public void TestaEmailValido(){
        Email email = new Email("marcos@gmail.com");
        assertEquals("marcos@gmail.com",email.getEnderecoEMail());
    }
    @Test
    public void TestaEmailInvalidoComoNulo(){
        assertThrows(ValorInvalidoException.class, () -> new Email(null));
    }
    @Test
    public void TestaEmailInvalidoVazio(){
        assertThrows(ValorInvalidoException.class, () -> new Email(""));
    }
    @Test
    public void TestaEmailInvalidoSemoArroba(){
        assertThrows(ValorInvalidoException.class, () -> new Email("marcos.silvagmail.com"));
    }
    @Test
    public void TestaEmailInvalidoSemOPontoCom(){
        assertThrows(ValorInvalidoException.class, () -> new Email("marcos.silva@gmail"));
    }
}