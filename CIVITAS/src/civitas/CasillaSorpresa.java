/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package civitas;

import java.util.ArrayList;

/**
 *
 * @author martina
 */
class CasillaSorpresa extends Casilla {

    private Sorpresa sorpresa;
    private MazoSorpresa mazo;

    CasillaSorpresa(MazoSorpresa mazo, String nombre) {
        super(nombre);
        this.mazo = mazo;
    }

    public void recibeJugador(int actual, ArrayList<Jugador> todos) {
        if (actual <= todos.size()) {
            sorpresa = mazo.siguiente();
            informe(actual, todos);
            sorpresa.aplicarAJugador(actual, todos);
        }
    }

    @Override
    public String toString() {
        String info;
        info = "\nCasilla sorpresa (" + sorpresa + ", mazo " + mazo + ")";
        return info;
    }

}
