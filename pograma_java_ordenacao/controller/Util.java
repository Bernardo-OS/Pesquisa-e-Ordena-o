package controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Util {

    public static void carregarArquivoEmLista(String nomeArquivo, ArrayList<Integer> lista) throws IOException {
        ArrayList<Integer> numeros = new ArrayList<>();

        try (BufferedReader leitor = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            int numeroLinha = 0;

            while ((linha = leitor.readLine()) != null) {
                numeroLinha++;
                try {
                    numeros.add(Integer.parseInt(linha.trim()));
                } catch (NumberFormatException e) {
                    throw new IOException("Número inválido na linha " + numeroLinha + ": " + linha, e);
                }
            }
        }

        lista.addAll(numeros);
    }
    
}
