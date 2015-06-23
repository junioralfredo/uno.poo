/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.uno;

import java.util.ArrayList;

/**
 *
 * @author George Ladines
 */
public class UNO {
    public static int jugador_actual = 0;
    public static final int NUMERO_JUGADORES = 4;
    public static Color color_actual = Color.AMARILLO;
    public static int sentido = 1;    
    public static int turno = 0;
    
    public static void main(String[] args) {
        Mazo mazo = new Mazo();
        ArrayList<Jugador> jugadores = new ArrayList<>();
        
        for(int i=0; i<NUMERO_JUGADORES; i++) {
            jugadores.add(new Jugador());
        }
        //System.out.println(mazo);
        mazo.barajar();
        mazo.repartir(jugadores);
        
//////        System.out.println("jugador uno:"+jugadores.get(0));
//////        System.out.println("jugador dos:"+jugadores.get(1));
//////        System.out.println("jugador tres:"+jugadores.get(2));
//////        System.out.println("jugador cuatro:"+jugadores.get(3));
    }
    
}
