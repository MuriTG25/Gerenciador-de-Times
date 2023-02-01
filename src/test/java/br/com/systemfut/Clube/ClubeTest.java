package br.com.systemfut.Clube;

import br.com.systemfut.atletas_e_comissao.ComissaoTecnica;
import br.com.systemfut.exception.InvalidNumberException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClubeTest {

    @Test
    public void VerificaCNPJcomMenosDe14digitos(){
        assertThrows(InvalidNumberException.class,() ->
                new Clube("Matonense",
                        1234567890123L,"Matonense Futebol Clube"));
    }
    @Test
    public void VerificaCNPJValidocom14digitos(){
        var c1 = new Clube("Matonense",
                31111266000135L,"Matonense Futebol Clube");
        var cnpj = c1.getCNPJ();
        assertEquals(31111266000135L,cnpj);
    }
    @Test
    public void VerificaCNPJcomMaisDe14digitos(){
        assertThrows(InvalidNumberException.class,() ->
                new Clube("Matonense",
                        123456789012345L,"Matonense Futebol Clube"));
    }
}