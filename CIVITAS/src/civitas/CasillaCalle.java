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
public class CasillaCalle extends Casilla {

    private float precioCompra;
    private float precioEdificar;
    private float precioBaseAlquiler;

    private static final float FACTORALQUILERCALLE = 1.0f;
    private static final float FACTORALQUILERCASA = 1.0f;
    private static final float FACTORALQUILERHOTEL = 4.0f;

    private Jugador propietario = null;
    private int numHoteles;//
    private int numCasas;//

    CasillaCalle(String titulo, float precioCompra, float precioEdificar, float precioBaseAlquiler) {
        super(titulo);
        numCasas = 0;
        numHoteles = 0;
        this.precioCompra = precioCompra;
        this.precioEdificar = precioEdificar;
        this.precioBaseAlquiler = precioBaseAlquiler;
    }

    int cantidadCasasHoteles() {
        return numCasas + numHoteles;
    }

    float getPrecioCompra() {
        return precioCompra;
    }

    float getPrecioEdificar() {
        return precioEdificar;
    }

    public float getPrecioBaseAlquiler() {
        return precioBaseAlquiler;
    }

    public int getnumHoteles() {
        return numHoteles;
    }

    public int getnumCasa() {
        return numCasas;
    }

    float getPrecioAlquilerCompleto() {
        return precioBaseAlquiler * (1 + numCasas + numHoteles * 4);
    }

    public boolean construirHoteles() {
        numHoteles++;
        return true;
    }

    boolean construirCasa() {
        numCasas++;
        return true;
    }

    boolean tienePropietario() {

        return propietario != null;
    }

    public int cantidadCasasHotels() {
        return numCasas + numHoteles;
    }

    //metodo sesion 2 casilla
    public void tramitarAlquiler(Jugador jugador) {

        float dinero;
        if (!esEsteElPropietario(jugador) && tienePropietario()) {
            jugador.pagaAlquiler(getPrecioAlquilerCompleto());
            propietario.recibe(getPrecioAlquilerCompleto());
        }
    }

    //metodo seion2 casilla
    public boolean destruirCasas(int n, Jugador jugador) {
        if (esEsteElPropietario(jugador) && numCasas >= n) {
            numCasas = numCasas - n;
            return true;
        }
        return false;

    }

    boolean comprar(Jugador jugador) {
        propietario = jugador;
        jugador.paga(precioCompra);

        return true;
    }

    boolean construirCasa(Jugador jugador) {
        jugador.paga(precioEdificar);
        numCasas++;
        return true;
    }

    boolean construirHotel(Jugador jugador) {
        jugador.paga(precioCompra);
        numHoteles++;
        return true;

    }

    boolean esEsteElPropietario(Jugador jugador) {
        return jugador == propietario;
    }

    public void actualizaPropietarioPorConversion(JugadorEspeculador prop) {
        this.propietario = prop;
    }

    @Override
    public String toString() {
        return "\nNombre: " + getNombre()
                + "\nEL precio de compra sería " + precioCompra
                + "  \ncasas: " + Integer.toString(numCasas) + "  \nPrecio Edificar: " + precioEdificar
                + "  \nPrecioBaseAlquiler:  " + precioBaseAlquiler
                + "  \nNumHoteles " + numHoteles;
    }

    @Override
    public void recibeJugador(int actual, ArrayList<Jugador> todos) {

        if (actual <= todos.size()) {
            this.informe(actual, todos);
            Jugador jugador;
            jugador = todos.get(actual);

            if (!tienePropietario()) {
                jugador.puedeComprarCasilla();
            } else {
                this.tramitarAlquiler(jugador);
            }
        }
    }
}
