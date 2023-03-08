package br.com.systemfut.infraestrutura.funcionarios.dados_extras.atributos_dados_bancarios;

import java.util.*;

public class ConsultaDeBancos {
    Map<String,Integer> DadosDeBancos;

    public ConsultaDeBancos(ExtraiDadosDeBancoNaNet dadosDeBancos) {
        String json = dadosDeBancos.pegaSiteEmString();
        Map<String, Integer> MapadeBanco = dadosDeBancos.transformaStringEmList(json);
        this.DadosDeBancos = MapadeBanco;
    }

    public Map<String,Integer> consultaMapsDeBanco(){
        return this.DadosDeBancos;
    }
}
