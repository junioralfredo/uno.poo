/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.uno;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author George Ladines
 */
public class UNO {
    public static int jugador_actual = 0;
    public static final int NUMERO_JUGADORES = 4;
    public static Color color_actual = Color.AMARILLO;
    public static int sentido = 1;
    public static Mazo mazo = new Mazo();
    private static ArrayList<Jugador> jugadores = new ArrayList<>();
    public static final Random RND = new Random();
    
    public static void main(String[] args) {    
        init();
    }
    
    private static void init(){
        for(int i=0; i<NUMERO_JUGADORES; i++) {
            jugadores.add(new Jugador());
        }
        elegirPrimerJugador();
        
        mazo.barajar();
        mazo.repartir(jugadores);
    }

    private static void elegirPrimerJugador() {
        int i = RND.nextInt(jugadores.size()-1);
        Jugador tmp = jugadores.get(i);
        jugadores.set(i, jugadores.get(0));
        jugadores.set(0, tmp);
    }
    
    public static void siguienteTurno() {
        jugador_actual = jugador_actual + sentido;
        if(sentido==1 && jugador_actual==jugadores.size()){
            jugador_actual = 0;
        } else if(sentido==-1 && jugador_actual==-1){
            jugador_actual = jugadores.size()-1;
        }
    }

    static Color ingresarColor() {
        System.out.println("Ingresar color a cambiar");
        System.out.println("1. Amarillo");
        System.out.println("2. Rojo");
        System.out.println("3. Azul");
        System.out.println("4. Verde");
        
        String color_str;
        int color_int;
        Scanner entrada=new Scanner(System.in);// se declara e inicializa una instancia  de la clase Scanner.
        System.out.print("Ingrese una opcion [1/2/3/4]: ");
        color_str = entrada.next();
        
        color_int = Integer.valueOf(color_str);
        do {
            switch(color_int){
                case 1:
                    return Color.AMARILLO;
                case 2:
                    return Color.ROJO;
                case 3:
                    return Color.AZUL;
                case 4:
                    return Color.VERDE;
            }
        } while (color_int<1 || color_int>4);
        return Color.MULTI;
    }
}
