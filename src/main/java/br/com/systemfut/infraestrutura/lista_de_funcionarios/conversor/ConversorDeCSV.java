package br.com.systemfut.infraestrutura.lista_de_funcionarios.conversor;

import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * Interface que faz a importacao e exportacao de arquivos csv para uma lista de strings
 * @author Murilo Bioni Caruso
 * @version 1.1
 * @since 2023
 */

public class ConversorDeCSV implements ConversorDeArquivo{
    @Override
    public List<String> ImportadorDeArquivoEmList(String nomeArquivo) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(nomeArquivo +".csv"),"UTF-8");
        List<String> lista = new ArrayList<>();
        while(scanner.hasNext()){
            String linha = scanner.nextLine();
            Scanner scn = new Scanner(linha);
            scn.useDelimiter(",");
            String nome1 = scn.next();
            String CPF1 = scn.next();
            String cargo1 = scn.next();
            String nome = nome1.replace("\"", "");
            String CPF = CPF1.replace("\"", "");
            String cargo = cargo1.replace("\"", "");
            lista.add(nome);
            lista.add(CPF);
            lista.add(cargo);
            scn.close();
        }
        scanner.close();
        return lista;
    }

    @Override
    public void exportaListEmArquivoExterno(List<String[]> lista, String nomeArquivo) throws IOException {
        Writer writer = Files.newBufferedWriter(Paths.get(nomeArquivo+".csv"));
        CSVWriter csvWriter = new CSVWriter(writer);
        csvWriter.writeAll(lista);
        csvWriter.flush();
        writer.close();
    }

}
