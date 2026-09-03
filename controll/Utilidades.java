/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controll;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author laboratorio
 */
public class Utilidades {
    public static void popularLista(ArrayList<Integer> lista, int qtd){
        Random gerador = new Random();
        for (int i = 0; i < qtd; i ++) {
            lista.add(gerador.nextInt(200,400));
        }
    }
}
