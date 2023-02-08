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
public class Diario {

    static final private Diario instance = new Diario();
    private ArrayList<String> eventos;

    //Constructor privado para evitar que se puedan crear más instancias
    Diario() {
        eventos = new ArrayList<>();
    }

    public ArrayList<String> getEventos() {
        return eventos;
    }

    //Método para obtener la instancia
    static public Diario getInstance() {
        return instance;
    }

    void ocurreEvento(String e) {
        eventos.add(e);
    }

    public boolean eventosPendientes() {
        return !eventos.isEmpty();
    }

    public String leerEvento() {
        String salida = "";
        if (eventosPendientes()) { //si no hay eventos pendientes
            salida = eventos.remove(0);
        }
        return salida;
    }

}
