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
public class SorpresaPagarCobrar extends Sorpresa {

    private int valor;

    SorpresaPagarCobrar(int valor, String texto) {
        super(texto);
        this.valor = valor;
    }

    @Override
    public String toString() {
        String info;
        info = "\nLa SorpresaPagarCobrar : " + valor + "  " + super.toString();
        return info;
    }

    @Override
    public void aplicarAJugador(int actual, ArrayList<Jugador> todos) {
        if (actual <= todos.size()) {
            informe(actual, todos);
            todos.get(actual).modificarSaldo(valor);
        }
    }

}
