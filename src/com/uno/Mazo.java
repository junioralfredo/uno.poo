/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.uno;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author George Ladines
 */
public class Mazo {
     protected ArrayList<Naipe> naipes;
     
     public static final String[] COMODINES = {"INVERTIR", "PASAR_TURNO", "CAMBIA_COLOR"};
     public static final int VALORES_N = 10;
     public static final int VALORES_C = 2;
     public static final int VALORES_M = 4;
     public static final int NUMERO_REPARTIR = 5;
     public static final Random RND = new Random();

    public Mazo() {
        this.naipes = new ArrayList<>();
        this.initialize();
    }
     
    private void initialize() {
        for(Color c: Color.values()) {
            if(c!=Color.MULTI) {
               for (int i=0; i<VALORES_N; i++) {
                   if (i==0) {
                       this.naipes.add(new Naipe(c, String.valueOf(i)));
                   } else {
                       this.naipes.add(new Naipe(c, String.valueOf(i)));
                       this.naipes.add(new Naipe(c, String.valueOf(i)));
                   }             
               }
               for(int i=0; i<VALORES_C;i++){
                   this.naipes.add(new Naipe(c, "+2"));
                   this.naipes.add(new Naipe(c, COMODINES[0]));
                   this.naipes.add(new Naipe(c, COMODINES[1]));
               }
            } else {
               for(int i=0; i<VALORES_M;i++){
                   this.naipes.add(new Naipe(c, "+4"));
                   this.naipes.add(new Naipe(c, COMODINES[2]));
               }
            }
        }
    }
     
    public void barajar(){
        for (Naipe naipe: this.getNaipes()){
            int i = RND.nextInt(this.getNaipes().size()-1), j = RND.nextInt(this.getNaipes().size()-1);
            Naipe tmp = this.naipes.get(i);
            this.naipes.set(i, this.naipes.get(j));
            this.naipes.set(j, tmp);
        }
    }
    

    public void repartir(ArrayList<Jugador> jugadores){
        for(Jugador jugador: jugadores){
            for(int i=0; i<NUMERO_REPARTIR; i++){
                jugador.tomarNaipe(quitarNaipe());
            }
        }
    }
    
    public ArrayList<Naipe> getNaipes() {
        return naipes;
    }
    
    public Naipe quitarNaipe(){
        return this.naipes.remove(this.naipes.size()-1);
    }

    @Override
    public String toString() {
        String n = "";
        for(Naipe naipe : this.naipes){
           n = n + naipe.toString();
        }
        return n;
    }
}
