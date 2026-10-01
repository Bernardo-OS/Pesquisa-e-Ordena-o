package controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;
import model.Model;

public class Util {
     /**
     * Carrega valores de um arquivo com valores separados por linha, e preenche na lista do model.
     * 
     * @param nomeArquivo caminho do arquivo dos valores
     * @param lista lista que será preenchida com valores do arquivo
     */
    public static boolean carregarArquivoEmLista(String nomeArquivo, ArrayList<Integer> lista) {
        try {
            FileReader procurador;
            procurador = new FileReader(nomeArquivo);
            BufferedReader leitor = new BufferedReader(procurador);
            String linha;
            do {
                linha = leitor.readLine();
                if (linha != null) {
                    lista.add(Integer.parseInt(linha));
                }                
            } while (linha != null);
            leitor.close();
            return true;
        } catch (Exception e) {
            //System.out.println("Erro " + e.getMessage());
            return false;
        }
    }
    
     /**
     * Gera números aleatórios e preenche a lista do model.
     * 
     * @param quantidade Tamanho da lista que será gerada
     * @param min Valor mínimo do intervalo (inclusivo)
     * @param max Valor máximo do intervalo (inclusivo)
     */
    public static void gerarListaAleatoria(int quantidade, int min, int max) {
        // Garante que a lista está limpa antes de gerar novos dados
        if (Model.lista == null) {
            Model.lista = new java.util.ArrayList<>();
        } else {
            Model.lista.clear();
        }

        Random random = new Random();
        
        // O próximo inteiro gerado respeita o limite: min até max
        int intervalo = (max - min) + 1;

        for (int i = 0; i < quantidade; i++) {
            int numeroAleatorio = random.nextInt(intervalo) + min;
            Model.lista.add(numeroAleatorio);
        }
    }
}

