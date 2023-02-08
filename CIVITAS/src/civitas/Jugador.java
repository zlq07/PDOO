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
public class Jugador implements Comparable<Jugador> {

    protected static int maxJugadores;
    private int numJugadores;
    protected CasillaCalle propietario;
    protected static int CasasMax = 4;
    protected static int CasaPorHotel = 4;
    private int casillaActual;
    protected static int HotelesMax = 4;
    private String nombre;
    protected static float PasoPorSalida = 1000;
    private boolean puedeComprar;
    protected float saldo = 7500;
    protected ArrayList<CasillaCalle> propiedades = new ArrayList<CasillaCalle>();
    protected Boolean especulador = false;

    int cantidadCasasHoteles() {
        int casaHotel = 0;

        for (CasillaCalle prop : propiedades) {
            casaHotel = casaHotel + prop.cantidadCasasHoteles();
        }
        return casaHotel;

    }

    public Jugador(String nombre) {
        this.nombre = nombre;
        casillaActual = 0;
        puedeComprar = true;
        saldo = 7500;
        especulador = false;

    }

    protected Jugador(Jugador otro) {
        this.nombre = otro.nombre;
        this.saldo = otro.saldo;
        this.puedeComprar = otro.puedeComprar;
        this.numJugadores = otro.numJugadores;
        this.casillaActual = otro.casillaActual;
        this.especulador = otro.especulador;
        this.propiedades = new ArrayList<>(otro.propiedades);

    }

    public boolean existeLaPropiedad(int ip) {
        return propiedades.size() > ip && ip >= 0;
    }

    public ArrayList<CasillaCalle> getPropiedades() {
        return propiedades;
    }

    protected static int getCasasMax() {
        return CasasMax;
    }

    protected static int getCasasPorHotel() {
        return CasaPorHotel;
    }

    public int getCasillaActual() {
        return casillaActual;

    }

    private static int getHotelesMax() {
        return HotelesMax;
    }

    //antes protected-> lo he cambiado a public para que se pueda usar en el PanelJugador
    public String getNombre() {
        return nombre;
    }

    public Boolean getEspeculador() {
        return especulador;
    }

    boolean getPuedeComprar() {
        return puedeComprar;
    }

    //estaba en protected y lo he cambiado a public para poder usarlo en jugadorPanel
    public float getSaldo() {
        return saldo;
    }

    boolean puedeComprarCasilla() {
        puedeComprar = true;
        return puedeComprar;
    }

    boolean paga(float cantidad) {
        return this.modificarSaldo(cantidad * -1);
    }

    boolean pagaAlquiler(float cantidad) {
        return this.paga(cantidad);
    }

    boolean recibe(float cantidad) {
        return this.modificarSaldo(cantidad);
    }

    boolean modificarSaldo(float cantidad) {
        this.saldo = this.saldo + cantidad;
        Diario.getInstance().ocurreEvento("\n Se ha modificado el saldo del jugador " + nombre + " : " + cantidad + "\n");
        return true;
    }

    boolean moverAcasilla(int c) {
        casillaActual = c;
        puedeComprar = false;
        Diario.getInstance().ocurreEvento(nombre + " se mueve a la casilla " + c);
        return true;
    }

    //private
    public boolean puedoGastar(float precio) {
        return saldo >= precio;
    }

    public boolean tieneAlgoQueGestionar() {
        return propiedades.size() > 0;
    }

    boolean pasaPorSalida() {
        this.modificarSaldo(PasoPorSalida);
        Diario.getInstance().ocurreEvento("\nJugador :" + nombre + " recibe al pasar por la casilla de salida " + Float.toString(PasoPorSalida));
        return true;
    }

    @Override
    public int compareTo(Jugador otro) {
        int a = 0;
        if (this.saldo > otro.saldo) {
            a = 1;
        } else if (this.saldo < otro.saldo) {
            a = -1;
        }

        return a;
    }

    public boolean enBancarrota() {
        return this.saldo < 0;
    }

    private static float getPremioPasoPorSalida() {
        return PasoPorSalida;
    }

    public boolean comprar(CasillaCalle Titulo) {
        boolean result = false;
        if (this.puedeComprar) {
            float precio;
            precio = Titulo.getPrecioCompra();
            if (this.puedoGastar(precio)) {
                result = Titulo.comprar(this);
                propiedades.add(Titulo);
                Diario.getInstance().ocurreEvento("\nEl jugador" + this + "  compra la propiedad " + Titulo);
                this.puedeComprar = false;
            } else {
                Diario.getInstance().ocurreEvento("\nEl jugador" + this + "  no tiene saldo para comprar la propiedad " + Titulo);
            }
        }
        return result;
    }

    boolean construirCasa(int i) {
        boolean result = false;
        boolean existe = existeLaPropiedad(i);
        boolean puedoEdificar;
        float precioEdificar;

        if (existe) {
            CasillaCalle propiedad = propiedades.get(i);
            puedoEdificar = this.puedoEdificarCasa(propiedad);
            if (existe && puedoEdificar) {
                result = propiedad.construirCasa(this);
                Diario.getInstance().ocurreEvento("\nEl jugador " + nombre + " construye una casa en la propiedad " + i);

            }
        }
        return result;

    }

    boolean construirHotel(int ip) {
        boolean result = false;
        boolean puedoEdificarHotel = false;
        CasillaCalle propiedad = null;
        if (existeLaPropiedad(ip)) {
            propiedad = propiedades.get(ip);

            puedoEdificarHotel = this.puedoEdificarHotel(propiedad);

            if (puedoEdificarHotel) {
                result = propiedad.construirHotel(this);
                propiedad.destruirCasas(CasaPorHotel, this);
                Diario.getInstance().ocurreEvento("\nEl jugador " + nombre + " construye hotel en la propiedad " + ip);
            }
        }
        return result;
    }

    boolean puedoEdificarCasa(CasillaCalle propiedad) {
        boolean puedo = false;
        if (propiedad.getnumCasa() < this.getCasasMax() && puedoGastar(propiedad.getPrecioEdificar())) {
            puedo = true;
        }
        return puedo;
    }

    boolean puedoEdificarHotel(CasillaCalle propiedad) {
        boolean puedo = false;
        if (propiedad.getnumCasa() == CasasMax && puedoGastar(propiedad.getPrecioEdificar()) && propiedad.getnumHoteles() <= HotelesMax) {
            puedo = true;
        } else {
            puedo = false;
        }
        return puedo;
    }

    @Override
    public String toString() {
        String info;
        return info = ("\nNombre: " + nombre + " Saldo: " + saldo + " Puede comprar?: " + puedeComprar + "\n");

    }

    public Jugador convertir() {
        this.especulador = true;
        return new JugadorEspeculador(this);
    }
}
