
package testes;

import java.util.ArrayList;
import model.Ordenacao;
import controll.Utilidades;
import view.View;

/**
 *
 * @author laboratorio
 */
public class MeusTestes {
    public static void main(String[] args) {       
        ArrayList<Integer> listaBolha = new ArrayList<>();
        ArrayList<Integer> listaPente = new ArrayList<>();
        ArrayList<Long> metricas = new ArrayList<>();
        long tempoInicio, tempoFim, tempoTotal; 
        
        //desempenho do bolha
        System.out.println("Bolha....");
        Utilidades.popularLista(listaBolha, 100000);
        tempoInicio = System.nanoTime();
        metricas.addAll(Ordenacao.bolha(listaBolha));
        tempoFim = System.nanoTime();
        tempoTotal = (tempoFim - tempoInicio)/1000000;        
        metricas.add(tempoTotal);        
        View.exibirMetricas(metricas);
        
        //desempenho do pente
        System.out.println("Pente....");
        metricas.clear(); //limpeza das metricas do bolha
        Utilidades.popularLista(listaPente, 100000);
        tempoInicio = System.nanoTime();
        metricas.addAll(Ordenacao.pente(listaPente));
        tempoFim = System.nanoTime();
        tempoTotal = (tempoFim - tempoInicio)/1000000;        
        metricas.add(tempoTotal);        
        View.exibirMetricas(metricas);
    }    
}