package model;

import java.util.ArrayList;

/**
 *
 * @author laboratorio
 */
public class Ordenacao {
    
    public static ArrayList bolha(ArrayList<Integer> lista) {
        int tmp;
        boolean houveTroca;
        long qtdComparacoes = 0;
        long qtdTrocas = 0;
        //posicao 0 é qtdComparacoes e posicao 1 é a qtdTrocas
        ArrayList<Long> metricas = new ArrayList<>();
        do {
            houveTroca = false;
            for (int i = 0; i < lista.size() - 1; i++) {
                //if (lista[i] > lista[i+1]) {}
                qtdComparacoes++;
                if (lista.get(i) > lista.get(i+ 1)) {
                    qtdTrocas++;
                    houveTroca = true;
                    tmp = lista.get(i); //tmp = lista[i]
                    lista.set(i, lista.get(i + 1)); // lista[i] = lista[i+1]
                    lista.set(i+1, tmp); //lista[i+1] = tmp
                }                    
            }            
        }while (houveTroca);
        metricas.add(qtdComparacoes);
        metricas.add(qtdTrocas);
        
        return metricas;
    }    
    
    public static ArrayList pente(ArrayList<Integer> lista) {
        int tmp;
        boolean houveTroca;
        long qtdComparacoes = 0;
        long qtdTrocas = 0;
        long distancia = lista.size();
        //posicao 0 é qtdComparacoes e posicao 1 é a qtdTrocas
        ArrayList<Long> metricas = new ArrayList<>();
        do {
            distancia = (int) (distancia / 1.3);
            if (distancia <= 0) distancia = 1;
            houveTroca = false;
            for (int i = 0; i + distancia < lista.size() - 1; i++) {
                qtdComparacoes++;
                if (lista.get(i) > lista.get(i + (int)distancia)) {
                    qtdTrocas++;
                    houveTroca = true;
                    tmp = lista.get(i);
                    lista.set(i, lista.get(i + (int)distancia));
                    lista.set(i+(int)distancia, tmp);
                }                    
            }            
        }while (distancia > 1 || houveTroca);
        metricas.add(qtdComparacoes);
        metricas.add(qtdTrocas);
        
        return metricas;
    }    
}