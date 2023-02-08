/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package civitas;

import java.util.ArrayList;
import java.util.Arrays;
import GUI.Dado;
import java.util.Collections;


public final class CivitasJuego {

    private int indiceJugadorActual;
    private ArrayList<Jugador> jugadores;
    private MazoSorpresa mazo;
    private Tablero tablero;
    private GestorEstados gestorEstados;
    private Jugador jugador;
    private Dado dado;
    private Diario diario;
    private EstadoJuego estado;

    public CivitasJuego(ArrayList<String> nombres, boolean debug) {

        //inicializamos los jugadores
        jugadores = new ArrayList<>();
        for (int i = 0; i < nombres.size(); i++) {
            jugadores.add(new Jugador(nombres.get(i)));
        }

        //inicializamos gestorEstados
        gestorEstados = new GestorEstados();
        estado = gestorEstados.estadoInicial();

        //inicializamos el dado
        //Dado.getInstance().setDebug(debug);

        //inicializamos el jugadorActual para indicar quien empieza
        indiceJugadorActual = Dado.getInstance().quienEmpieza(jugadores.size());

        mazo = new MazoSorpresa(debug);
        tablero = new Tablero();
        estado = EstadoJuego.INICIO_TURNO;
        inicializaMazoSorpresas(tablero);

        inicializaTablero(mazo);

    }

    public void inicializaTablero(MazoSorpresa mazo) {

        tablero.añadeCasilla(new CasillaSorpresa(mazo, "\nCasilla sorpresa\n"));
        Casilla c1 = new CasillaCalle("Ronda de Valencia\n", 600, 1200, 750);//1
        Casilla c2 = new CasillaCalle("Plaza Lavapiés\n", 600, 1200, 750);//2
        tablero.añadeCasilla(c1);
        tablero.añadeCasilla(c2);
        tablero.añadeCasilla(new CasillaCalle("Avenida Reina Victoria\n", 1000, 2000, 1250));//3
        tablero.añadeCasilla(new CasillaCalle("Calle Bravo Murillo\n", 1200, 2400, 1500));//4
        tablero.añadeCasilla(new CasillaCalle("Calle Alberto Aguilera\n", 1400, 2800, 1750));//5
        tablero.añadeCasilla(new CasillaCalle("Calle Fuencarral\n", 700, 1400, 875));//6
        tablero.añadeCasilla(new CasillaSorpresa(mazo, "\nCasilla sorpresa\n"));
        tablero.añadeCasilla(new CasillaCalle("Calle Velázquez\n", 800, 1600, 1000));//7
        tablero.añadeCasilla(new Casilla("Esta es la casilla de descanso\n"));
        tablero.añadeCasilla(new CasillaCalle("Calle Serrano\n", 750, 1550, 938));//8
        tablero.añadeCasilla(new CasillaCalle("Calle Maria de Molina\n", 100, 2000, 1250));//9
        tablero.añadeCasilla(new CasillaCalle("Calle Cea Bermudez", 600, 1200, 750));//10
        tablero.añadeCasilla(new CasillaSorpresa(mazo, "\nCcasilla sorpresa\n"));
        tablero.añadeCasilla(new CasillaCalle("Calle Bailén\n", 900, 1800, 1125));//11
        tablero.añadeCasilla(new CasillaCalle("Calle Velázquez\n", 800, 1600, 1000));//12
        tablero.añadeCasilla(new CasillaCalle("Calle Fenicios\n", 600, 100, 800));//13
        tablero.añadeCasilla(new CasillaSorpresa(mazo, "\nCasilla sorpresa\n"));
        tablero.añadeCasilla(new CasillaCalle("Calle SantaMarta\n", 600, 100, 800));//14

    }

    public void inicializaMazoSorpresas(Tablero tablero) {

        Sorpresa sorpresa = new SorpresaConvertirme("\nSoy jugador especulador");
        mazo.alMazo(sorpresa);

        mazo.alMazo(new SorpresaPorCasaHotel(100, "Ganas"));
        mazo.alMazo(new SorpresaPorCasaHotel(50, "Pierdes"));
        mazo.alMazo(new SorpresaPagarCobrar(100, "Pagar"));
        mazo.alMazo(new SorpresaPagarCobrar(50, "Cobrar"));
        mazo.alMazo(new SorpresaPorCasaHotel(50, "Pierdes"));
        mazo.alMazo(new SorpresaPagarCobrar(50, "Pagas"));
        mazo.alMazo(new SorpresaPagarCobrar(50, "Ganas"));
        mazo.alMazo(new SorpresaPorCasaHotel(50, "Ganas"));

    }

    public Casilla getCasillaActual() {
        return tablero.getCasilla(getJugadorActual().getCasillaActual());
    }

    public Jugador getJugadorActual() {
        return this.jugadores.get(indiceJugadorActual);
    }

    private void contabilizarPasosPorSalida(Jugador jugadorActual) {
        if (tablero.computarPasoPorSalida() == true) {
            jugadorActual.pasaPorSalida();
        }
    }

    private void pasarTurno() {
        this.indiceJugadorActual = (this.indiceJugadorActual + 1) % jugadores.size();
    }

    public boolean construirCasa(int ip) {
        return jugadores.get(indiceJugadorActual).construirCasa(ip);
    }

    public boolean construirHotel(int ip) {
        return jugadores.get(indiceJugadorActual).construirHotel(ip);
    }

    public boolean finalDelJuego() {

        boolean llega_al_final = false;

        for (int i = 0; i < jugadores.size() && !llega_al_final; i++) {
            llega_al_final = this.jugadores.get(i).enBancarrota();
        }

        return llega_al_final;
    }

    public ArrayList<Jugador> ranking() {
        ArrayList<Jugador> lista_ranking = jugadores;
        lista_ranking.sort((j1, j2) -> j1.compareTo(j2));
        Collections.reverse(lista_ranking);
        return lista_ranking;
    }

    public void contabilizarPasosPorSalida() {
        if (tablero.computarPasoPorSalida()) {
            jugador.pasaPorSalida();
        }

    }

    public void avanzaJugador() {
        Jugador jugadorActual;
        jugadorActual = this.getJugadorActual();

        int posicionActual;
        posicionActual = jugadorActual.getCasillaActual();
        // Dado.getInstance().setDebug(true); ->para avanzar de uno en uno
        int tirada;
        tirada = Dado.getInstance().tirar();

        int nuevaPosicion;
        nuevaPosicion = tablero.nuevaPosicion(posicionActual, tirada);

        Casilla casilla;
        casilla = tablero.getCasilla(nuevaPosicion);

        this.contabilizarPasosPorSalida(jugadorActual);
        jugadorActual.moverAcasilla(nuevaPosicion);

        casilla.recibeJugador(indiceJugadorActual, jugadores);
        this.contabilizarPasosPorSalida(jugadorActual);
    }

    public OperacionJuego siguientePaso() {
        Jugador jugadorActual = this.getJugadorActual();
        OperacionJuego operacion;
        operacion = gestorEstados.siguienteOperacion(jugadorActual, this.estado);

        if (operacion == OperacionJuego.PASAR_TURNO) {
            this.pasarTurno();
            this.siguientePasoCompletado(operacion);
        } else if (operacion == OperacionJuego.AVANZAR) {
            this.avanzaJugador();
            this.siguientePasoCompletado(operacion);
        }
        return operacion;
    }

    public boolean comprar() {
        boolean res = false;

        Jugador jugadorActual;
        jugadorActual = jugadores.get(indiceJugadorActual);

        int numCasillaActual = jugadorActual.getCasillaActual();
        CasillaCalle casilla = (CasillaCalle)tablero.getCasilla(numCasillaActual);
        res = jugadorActual.comprar(casilla);
        return res;

    }

    public int getIndiceJugadorActual() {
        return indiceJugadorActual;
    }

    public Jugador getJugadores() {
        return jugadores.get(indiceJugadorActual);
    }

    public void siguientePasoCompletado(OperacionJuego operacion) {
        //se actualiza el estado del juego obteniendo el 
        //siguiente estado del gestor de estados (método 
        //siguienteEstado). Para ello es necesario obtener 
        //el jugador actual.
        estado = gestorEstados.siguienteEstado(jugadores.get(indiceJugadorActual), estado, operacion);
    }

    public Tablero getTablero() {
        return tablero;
    }

    public ArrayList<CasillaCalle> getPropiedades(Jugador jugadorActual) {
        return jugadorActual.getPropiedades();
    }

}
