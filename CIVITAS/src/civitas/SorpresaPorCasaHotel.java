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
public class SorpresaPorCasaHotel extends Sorpresa {

    private int valor;

    SorpresaPorCasaHotel(int valor, String texto) {
        super(texto);
        this.valor = valor;
    }

    @Override
    public void aplicarAJugador(int actual, ArrayList<Jugador> todos) {
        if (actual <= todos.size()) {
            informe(actual, todos);
            todos.get(actual).modificarSaldo(this.valor * todos.get(actual).cantidadCasasHoteles());
        }
    }

    @Override
    public String toString() {
        String info;
        info = "\nSorpresaPorCasaHotel " + valor + " " + super.toString();
        return info;
    }

}
