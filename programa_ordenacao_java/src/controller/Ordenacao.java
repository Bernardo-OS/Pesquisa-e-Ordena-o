package controller;

import java.util.ArrayList;

/**
* Classe principal que roda todos os métodos de ordenação do sistema
*/
public class Ordenacao {

    /**
     * Método de ordenação bolha
     * 
     * @param lista Lista com valores a serem ordenados
     * @return metricas
     */
    public static ArrayList bolha(ArrayList<Integer> lista) {
        ArrayList<Float> metricas = new ArrayList<>();
        long qtdComparacoes = 0;
        long qtdTrocas = 0;
        int aux;
        boolean houveTroca;
        int i;
        do {
            houveTroca = false;
            for (i = 0; i < lista.size() - 1; i++) {
                qtdComparacoes++;
                if (lista.get(i) > lista.get(i + 1)) {
                    houveTroca = true;
                    aux = lista.get(i);
                    lista.set(i, lista.get(i + 1));
                    lista.set(i + 1, aux);
                    qtdTrocas++;
                }
            }
        } while (houveTroca);
        metricas.add((float) qtdComparacoes);
        metricas.add((float) qtdTrocas);
        return metricas;
    }

    /**
     * Método de ordenação seleção
     * 
     * @param lista Lista com valores a serem ordenados
     * @return metricas
     */
    public static ArrayList selecao(ArrayList<Integer> lista) {
        ArrayList<Float> metricas = new ArrayList<>();
        long qtdComparacoes = 0;
        long qtdTrocas = 0;
        int i, j, posMenor, aux;
        posMenor = 0;

        for (i = 0; i < lista.size(); i++) {
            posMenor = i;
            for (j = i + 1; j < lista.size(); j++) {
                qtdComparacoes++;
                if (lista.get(j) < lista.get(posMenor)) {
                    posMenor = j;
                }
            }
            if (posMenor != i) {
                aux = lista.get(i);
                lista.set(i, lista.get(posMenor));
                lista.set(posMenor, aux);
                qtdTrocas++;
            }
        }

        metricas.add((float) qtdComparacoes);
        metricas.add((float) qtdTrocas);
        return metricas;
    }

    /**
     * Método de ordenação inserção
     * 
     * @param lista Lista com valores a serem ordenados
     * @return metricas
     */
    public static ArrayList insercao(ArrayList<Integer> lista) {
        ArrayList<Float> metricas = new ArrayList<>();
        long qtdComparacoes = 0;
        long qtdTrocas = 0;
        int i, j, aux;

        for (i = 1; i < lista.size(); i++) {
            aux = lista.get(i);
            for (j = i - 1; j > 0 && aux < lista.get(j); j--, qtdComparacoes++) {
                qtdTrocas++;
                lista.set(j + 1, lista.get(j));
            }
            lista.set(j + 1, aux);
        }
        metricas.add((float) qtdComparacoes);
        metricas.add((float) qtdTrocas);
        return metricas;
    }

    /**
     * Método de ordenação pente
     * 
     * @param lista Lista com valores a serem ordenados
     * @return metricas
     */
    public static ArrayList pente(ArrayList<Integer> lista) {
        ArrayList<Float> metricas = new ArrayList<>();
        long qtdComparacoes = 0;
        long qtdTrocas = 0;
        int aux;
        boolean houveTroca;
        int i;
        int distancia = lista.size();
        do {
            distancia = (int) (distancia / 1.3);
            if (distancia <= 0) {
                distancia = 1;
            }
            houveTroca = false;
            for (i = 0; i + distancia < lista.size(); i++) {
                qtdComparacoes++;
                if (lista.get(i) > lista.get(i + distancia)) {
                    houveTroca = true;
                    aux = lista.get(i);
                    lista.set(i, lista.get(i + distancia));
                    lista.set(i + distancia, aux);
                    qtdTrocas++;
                }
            }
        } while (distancia > 1 || houveTroca);
        metricas.add((float) qtdComparacoes);
        metricas.add((float) qtdTrocas);
        return metricas;
    }
    
    
    //Para ordenação merge:
    /**
     * Função principal método de ordenação merge
     * 
     * @param lista Lista com valores a serem ordenados
     * @return metricas
     */
    public static ArrayList<Float> merge(ArrayList<Integer> lista) {
        ArrayList<Float> metricas = new ArrayList<>();
        
        // contadores[0] = qtdComparacoes, contadores[1] = qtdTrocas (movimentações)
        long[] contadores = new long[2]; 
        
        if (lista != null && lista.size() > 1) {
            mergeSortRecursivo(lista, 0, lista.size() - 1, contadores);
        }
        
        metricas.add((float) contadores[0]); // Quantidade de Comparações
        metricas.add((float) contadores[1]); // Quantidade de Trocas/Movimentações
        return metricas;
    }

    /**
     * Função auxiliar para dividir a lista recursivamente para merge
     * 
     * @param lista Lista com valores a serem ordenados
     * @param inicio da lista
     * @param fim da lista
     * @param contadores guarda valor de métrica
     */
    private static void mergeSortRecursivo(ArrayList<Integer> lista, int inicio, int fim, long[] contadores) {
        if (inicio < fim) {
            int meio = inicio + (fim - inicio) / 2;

            // Divide a metade esquerda e direita
            mergeSortRecursivo(lista, inicio, meio, contadores);
            mergeSortRecursivo(lista, meio + 1, fim, contadores);

            // Intercala as partes ordenando-as
            intercalar(lista, inicio, meio, fim, contadores);
        }
    }

    /**
     * Função auxiliar para juntar as partes e contabilizar as métricas
     * 
     * @param lista Lista com valores a serem ordenados
     * @param inicio da lista
     * @param fim da lista
     * @param contadores guarda valor de métrica
     */
    private static void intercalar(ArrayList<Integer> lista, int inicio, int meio, int fim, long[] contadores) {
        // Cria listas temporárias para armazenar as metades
        ArrayList<Integer> esquerda = new ArrayList<>();
        ArrayList<Integer> direita = new ArrayList<>();

        for (int i = inicio; i <= meio; i++) {
            esquerda.add(lista.get(i));
        }
        for (int j = meio + 1; j <= fim; j++) {
            direita.add(lista.get(j));
        }

        int i = 0, j = 0;
        int k = inicio;

        // Compara os elementos das duas metades e reinsere na lista original
        while (i < esquerda.size() && j < direita.size()) {
            contadores[0]++; // Incrementa quantidade de comparações
            
            if (esquerda.get(i) <= direita.get(j)) {
                lista.set(k, esquerda.get(i));
                i++;
            } else {
                lista.set(k, direita.get(j));
                j++;
            }
            contadores[1]++; // Cada inserção de volta na lista conta como uma movimentação/troca
            k++;
        }

        // Copia os elementos restantes da sublista esquerda, se houver
        while (i < esquerda.size()) {
            lista.set(k, esquerda.get(i));
            i++;
            k++;
            contadores[1]++;
        }

        // Copia os elementos restantes da sublista direita, se houver
        while (j < direita.size()) {
            lista.set(k, direita.get(j));
            j++;
            k++;
            contadores[1]++;
        }
    }
    
    //Para ordenação quick:
    /**
     * Função principal método de ordenação quick
     * 
     * @param lista Lista com valores a serem ordenados
     * @return metricas 
     */
    public static ArrayList<Float> quick(ArrayList<Integer> lista) {
        ArrayList<Float> metricas = new ArrayList<>();
        
        // contadores[0] = qtdComparacoes, contadores[1] = qtdTrocas
        long[] contadores = new long[2]; 
        
        if (lista != null && lista.size() > 1) {
            quicksortRecursivo(lista, 0, lista.size() - 1, contadores);
        }
        
        metricas.add((float) contadores[0]); // Quantidade de Comparações
        metricas.add((float) contadores[1]); // Quantidade de Trocas
        return metricas;
    }

    /**
     * Função auxiliar para controlar as partições recursivamente para quick
     * 
     * @param lista Lista com valores a serem ordenados
     * @param inicio da lista
     * @param fim da lista
     * @param contadores guarda valor de métrica
     */
    private static void quicksortRecursivo(ArrayList<Integer> lista, int inicio, int fim, long[] contadores) {
        if (inicio < fim) {
            // Encontra o índice do pivô posicionado corretamente
            int indicePivo = particionar(lista, inicio, fim, contadores);

            // Ordena os elementos antes e depois do pivô
            quicksortRecursivo(lista, inicio, indicePivo - 1, contadores);
            quicksortRecursivo(lista, indicePivo + 1, fim, contadores);
        }
    }

    // Função que escolhe o pivô e reorganiza os elementos na lista para quick
    private static int particionar(ArrayList<Integer> lista, int inicio, int fim, long[] contadores) {
        // Escolhe o último elemento como pivô
        int pivo = lista.get(fim);
        int i = (inicio - 1); 

        for (int j = inicio; j < fim; j++) {
            contadores[0]++; // Incrementa quantidade de comparações
            
            // Se o elemento atual for menor ou igual ao pivô
            if (lista.get(j) <= pivo) {
                i++;
                // Faz a troca (swap) de elementos
                int aux = lista.get(i);
                lista.set(i, lista.get(j));
                lista.set(j, aux);
                contadores[1]++; // Incrementa quantidade de trocas
            }
        }

        // Coloca o pivô na sua posição correta (meio)
        int aux = lista.get(i + 1);
        lista.set(i + 1, lista.get(fim));
        lista.set(fim, aux);
        contadores[1]++; // Incrementa a troca final do pivô

        return i + 1;
    }
}
