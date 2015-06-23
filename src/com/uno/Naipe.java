/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.uno;

/**
 *
 * @author George Ladines
 */
public class Naipe {
    private Color color;
    private String valor;
    private TipoNaipe tipo_naipe;

    public Naipe(Color color, String valor) {
        this.color = color;
        this.valor = valor;
        
        if (this.esNumero()){
            this.tipo_naipe = TipoNaipe.NUMERO;
        } else if ( this.valor.startsWith("+") ) {
            this.tipo_naipe = TipoNaipe.SUMADOR;
        }else {
            this.tipo_naipe = TipoNaipe.valueOf(valor);
        }
    }

    public Color getColor() {
        return color;
    }

    public String getValor() {
        return valor;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
    
    private boolean esNumero() {
        for (char c : this.getValor().toCharArray()) {
            if (!Character.isDigit(c)) return false;
        }
        return true;
    }
    
    public void accion(Jugador jugador) {
        //Si la carta es un inversor el turno se aumenta si esta disminuyendo y disminuye si esta aumentando
        //Si la carta es un sumador el jugador quita cartas del mazo el numero de veces que le indique la carta
        //Si la carta es un cambia_color el color actual del juego cambia
        switch(this.tipo_naipe){
            case INVERTIR:
                UNO.sentido = UNO.sentido * -1;
                break;
            case PASAR_TURNO:
                UNO.siguienteTurno();
                break;
            case CAMBIA_COLOR:
                UNO.color_actual = UNO.ingresarColor();
                break;
            case SUMADOR:
                int valor_suma = Integer.valueOf(this.getValor().split("+")[1]);
                for(int i=0; i<=valor_suma;i++){
                    Naipe naipe = UNO.mazo.quitarNaipe();
                    jugador.tomarNaipe(naipe);
                }
                break;
            default:
                break;
        }
    }

    @Override
    public String toString() {
        return "Naipe{" + "color=" + color + ", valor=" + valor + '}';
    }
}
