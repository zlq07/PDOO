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
public class Casilla {

    private String nombre;

    Casilla(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

//    }
    @Override
    public String toString() {
        String info;
        return info = ("\nEsta es la casilla de descanso (" + nombre + ")");
        //return null;
    }

    /* Informa al diario del jugador que ha caido en la casjlla 
    actual permitiendo utilizar el metodo to_string paara poder
    acceder a la casilla
     */
    void informe(int actual, ArrayList<Jugador> todos) {
        Diario.getInstance().ocurreEvento("\nJugador: " + todos.get(actual).toString() + " y se encuentra en la casilla: \n" + this.toString());
    }

    public void recibeJugador(int actual, ArrayList<Jugador> todos) {
        if (actual <= todos.size()) {
            informe(actual, todos);
        }
    }

}
