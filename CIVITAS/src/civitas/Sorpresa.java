
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
public abstract class Sorpresa {

    private String texto;

    Sorpresa(String texto) {
        this.texto = texto;
    }

    public abstract void aplicarAJugador(int actual, ArrayList<Jugador> todos);

    protected void informe(int actual, ArrayList<Jugador> todos) {
        Diario.getInstance().ocurreEvento("\nEl jugador : " + todos.get(actual).getNombre() + " ha conseguido la sorpresa " + this.toString());
    }

    @Override
    public String toString() {
        String info;
        info = "\nSorpresa : " + texto;
        return info;
    }

}
