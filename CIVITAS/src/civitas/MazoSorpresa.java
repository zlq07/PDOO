/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package civitas;

import java.util.ArrayList;
import java.util.Collections; //para barajar el vector

/**
 *
 * @author martina
 */
public class MazoSorpresa {

    private ArrayList<Sorpresa> sorpresas = new ArrayList<Sorpresa>(); //almacena cartas sorpresa
    private boolean barajada;
    private int usadas;
    private boolean debug;
    private Sorpresa cartaSorpresa;

    private void init() {
        sorpresas = new ArrayList();
        barajada = false;
        usadas = 0;
    }

    //constructor con un parametro
    MazoSorpresa(boolean debug) {
        this.debug = debug;
        init();
        if (debug == true) {
            Diario.getInstance().ocurreEvento("Esta: " + debug);
        }

    }

    MazoSorpresa() {
        init();
        debug = false;
    }

    void alMazo(Sorpresa s) {
        if (!barajada) {
            sorpresas.add(s);
        }
    }

    Sorpresa siguiente() {
        if (!barajada && usadas == sorpresas.size() && !debug) {
            usadas = 0;
            barajada = true;
        }
        usadas++;
//        cartaSorpresa= sorpresas.get(usadas);
//        return cartaSorpresa;

        cartaSorpresa = sorpresas.get(0);
        sorpresas.remove(0);
        sorpresas.add(cartaSorpresa);
        return cartaSorpresa;
    }

}
