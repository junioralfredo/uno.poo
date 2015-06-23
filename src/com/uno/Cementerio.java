/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.uno;

import java.util.ArrayList;

public class Cementerio extends Mazo {

    public Cementerio() {
        this.naipes = new ArrayList<>();
    }    

    void ponerNaipe(Naipe naipe) {
        this.naipes.add(naipe);
    }
}
