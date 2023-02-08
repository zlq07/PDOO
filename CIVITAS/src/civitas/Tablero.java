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
public class Tablero {
    private ArrayList<Casilla> casillas = new ArrayList<>(); //contiene las casillas del juego
    private boolean porSalida;//si el jugador tiene el turno o ha pasado por la salida de dicho turno o no
    private static int ERROR=-1;
    private static int numCasillas;

    
    public Tablero(){
        casillas= new ArrayList<Casilla>();
        //añade una nueva casilla de nombre salida
        Casilla salida = new Casilla("Salida");
        casillas.add(salida);
        porSalida=false;
    }

    //métodos de instancia privados
    private boolean correcto(int numCasilla){
        return((casillas.size() > numCasillas));
    }
    
    boolean computarPasoPorSalida(){
        porSalida=false;
        return porSalida;
    }
    
    void añadeCasilla(Casilla casilla){
        casillas.add(casilla);
    }

  
    public Casilla getCasilla(int numCasilla){
        if(correcto(numCasilla))
            return casillas.get(numCasilla);
        else
            return null;
    }
    public Casilla getCasilla(){
        return casillas.get(numCasillas);
    }
    int nuevaPosicion(int actual, int tirada){
        
        if(correcto(actual)){
            int opcion_1= actual + tirada;
            int opcion_2=(actual+tirada)%casillas.size();
            if(opcion_1==opcion_2)
                return opcion_1;
            else{
                numCasillas++;
                return opcion_2;
            }
        }
        else
            return -1;
    }

}
