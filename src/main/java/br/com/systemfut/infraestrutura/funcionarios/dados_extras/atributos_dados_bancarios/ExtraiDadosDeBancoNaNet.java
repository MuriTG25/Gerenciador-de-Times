package br.com.systemfut.infraestrutura.funcionarios.dados_extras.atributos_dados_bancarios;

import java.util.*;

public interface ExtraiDadosDeBancoNaNet {
    public String pegaSiteEmString();
    public Map<String,Integer> transformaStringEmList(String json);
}
