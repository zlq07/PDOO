/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladorCivitas;

import GUI.CivitasView;
import civitas.OperacionJuego;
import civitas.OperacionInmobiliaria;
import civitas.Diario;
import civitas.CivitasJuego;
import civitas.GestionInmobiliaria;
import civitas.Jugador;
import java.util.ArrayList;

/**
 *
 * @author martina
 */
public class Controlador {

    private CivitasJuego juego;
    private Respuesta respuesta;
    private CivitasView view;

    public Controlador(CivitasJuego juego, CivitasView vista) {
        this.juego = juego;
        this.view = vista;
        respuesta = null;
    }

    public void juega() {
        int casa = 0;

        while (!juego.finalDelJuego()) {

            
            view.actualiza();
            view.pausa();

            OperacionJuego siguiente;
            siguiente = juego.siguientePaso();

            view.mostrarSiguienteOperacion(siguiente);

            if (siguiente != OperacionJuego.PASAR_TURNO) {
                view.mostrarEventos();
            }

            if (!juego.finalDelJuego()) {
                //uso switch case
                switch (siguiente) {
                    case COMPRAR:
                        Respuesta res;
                        res = view.comprar();
                        if (res == Respuesta.SI) {
                            juego.comprar();
                        }

                        juego.siguientePasoCompletado(siguiente);

                        break;

                    case GESTIONAR:
                        OperacionInmobiliaria op;
                        op = view.elegirOperacion();

                        if (op == OperacionInmobiliaria.TERMINAR) {
                            juego.siguientePasoCompletado(siguiente);
                        } else {
                            casa = view.elegirPropiedad();

                            //A continuación, se crea un objeto GestionInmobiliaria
                            //con esos valores y se llama al método del modelo correspondiente a la
                            //gestión elegida pasando el índice de la propiedad como parámetro.
                            //GestionInmobiliaria ges = new GestionInmobiliaria(op,casa);
                            if (op == OperacionInmobiliaria.CONSTRUIR_CASA) {
                                juego.construirCasa(casa);
                            } else if (op == OperacionInmobiliaria.CONSTRUIR_HOTEL) {
                                juego.construirHotel(casa);
                            }
                        }

                        break;
                }

            }

        }

        view.actualiza();
        ArrayList<Jugador> lista = juego.ranking();
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(lista.get(i).getNombre() + "\n"); //muestra el ranking
        }

    }

}
