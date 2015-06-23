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
public class Jugador {
    private ArrayList<Naipe> mano;

    public Jugador() {
        this.mano = new ArrayList<>();
    }

    public ArrayList<Naipe> getMano() {
        return mano;
    }

    public void tomarNaipe(Naipe naipe) {
        this.mano.add(naipe);
    }
    
    public Naipe lanzarNaipe(int index){
        return this.mano.remove(index);
    }

    @Override
    public String toString() {
        String jugador_str = "";
        for(Naipe naipe: mano){
            jugador_str = jugador_str + (mano.indexOf(naipe)+1) + ". " + naipe.toString() + "\n";
        }
        return jugador_str;
    }
}
