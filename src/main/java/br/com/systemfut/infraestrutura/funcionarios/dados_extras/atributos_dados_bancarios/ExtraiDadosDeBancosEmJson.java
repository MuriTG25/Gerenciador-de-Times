package br.com.systemfut.infraestrutura.funcionarios.dados_extras.atributos_dados_bancarios;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.*;
import java.util.stream.Collectors;

public class ExtraiDadosDeBancosEmJson implements ExtraiDadosDeBancoNaNet{
    public String getSite(){
        return "https://gist.githubusercontent.com/antoniopresto/d73888dab087ae35a7cf41a61d8a3cbc/" +
                "raw/43c94b305367afa82734f6fb4480f55e77e08a6e/banco_codigo.json";
    }
    @Override
    public String pegaSiteEmString(){
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().uri
                    (new URI(this.getSite())).GET().build();
            HttpResponse<String> response = client.send(request,
                    HttpResponse.BodyHandlers.ofString());
            return response.body();
        } catch (URISyntaxException | IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public Map<String,Integer> transformaStringEmList(String json){
        String[] split = json.split(",");
        List<String> listaRawAgencia = Arrays.stream(split).filter(
                c -> c.contains("value")).collect(Collectors.toList());
        List<String> listaRawNomeBanco = Arrays.stream(split).filter(
                c -> c.contains("label")).collect(Collectors.toList());
        ArrayList<Integer> ListaLimpaAgencia = new ArrayList<>();
        ArrayList<String> ListaLimpaNomeBanco = new ArrayList<>();
        for (String agencia : listaRawAgencia) {
            String replace = agencia.replaceAll("\"", "").replaceAll("\\{", "").
                    replaceAll("}", "").replaceAll("\\[","").
                    replaceAll("]","");
            String agenciaCortada = replace.substring(15);
            int numero = Integer.parseInt(agenciaCortada);
            ListaLimpaAgencia.add(numero);
        }
        for (String nome: listaRawNomeBanco) {
            String replace = nome.replaceAll("\"", "").replaceAll("\\{", "").
                    replaceAll("}", "").replaceAll("\\[","").
                    replaceAll("]","");
            String nomeCortado = replace.substring(12);
            ListaLimpaNomeBanco.add(nomeCortado);
        }

        Map<String,Integer> bancos = new LinkedHashMap<>();
        for (int i = 0; i < ListaLimpaAgencia.size(); i++) {
            bancos.put(ListaLimpaNomeBanco.get(i),ListaLimpaAgencia.get(i));
        }
        return bancos;
    }
}
