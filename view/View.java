
package view;

import java.util.ArrayList;
/**
 *
 * @author laboratorio
 */
public class View {
    public static void exibirLista(String frase, ArrayList<Integer> lista) {
        System.out.println(frase);
        for (Integer item : lista) {
            System.out.println(item);
        }
    }
    
    public static void exibirMetricas(ArrayList<Long> metricas) {
        System.out.println("Total de comparacoes   : " + metricas.get(0));
        System.out.println("Total de trocas   : " + metricas.get(1));
        System.out.println("Total de tempo   : " + metricas.get(2));
    }
}
