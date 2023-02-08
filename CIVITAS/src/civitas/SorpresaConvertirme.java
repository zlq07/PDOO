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
public class SorpresaConvertirme extends Sorpresa {

    SorpresaConvertirme(String texto) {
        super(texto);
    }

    @Override
    public void aplicarAJugador(int actual, ArrayList<Jugador> todos) {
        if (actual <= todos.size()) {
            informe(actual, todos);

            Jugador nuevo = todos.get(actual).convertir();

            todos.set(actual, nuevo);
        }
    }

    @Override
    public String toString() {
        String info;
        info = "\nSorpresaEspeculador: " + super.toString();
        return info;
    }
}
