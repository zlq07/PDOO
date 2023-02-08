/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package civitas;

import java.util.Random;

/**
 *
 * @author martina
 */
public class Dado {

    //esta clase tiene visibilidad de paquete
    private Random random;
    private int ultimoResultado;
    private boolean debug;
    private static int VALORDEBUG = 1;
    private static int VALORESDADO = 6;

    //Atributo de clase privado
    private static final Dado instance = new Dado();

    //constructor por defecto sin parametros
    private Dado() {
        random = new Random();
        ultimoResultado = 0;
        debug = false;
    }

    //consultor de instance
    public static Dado getInstance() { //con visibilidad de pquete
        return instance;
    }

    public int tirar() {
        int tirada;
        if (debug) {
            tirada = VALORDEBUG;
        } else //nexInt(int) devuelve 0 a 6 excluyendo el 6 por eso suma 1
        {
            tirada = random.nextInt(VALORESDADO) + 1;
        }

        return tirada;

    }

    int quienEmpieza(int n) {
        return random.nextInt(n);
    }

    void setDebug(boolean d) {
        debug = d;
        String estado;

        if (d = false) {
            estado = "Apagado";
        } else {
            estado = "Encendido";
        }

        Diario.getInstance().ocurreEvento(estado);

    }

    int getUltimoResultado() {
        return ultimoResultado;
    }
}
