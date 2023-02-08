/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package civitas;

import java.util.ArrayList;

/**
 *
 * @author martina
 */
public class CIVITAS {

    /**
     * @param args the command line arguments
     */
    public static float main(String[] args) {
        // TODO code application logic here
                // TODO code application logic here
         
        //EJERCICIO1
        
        int jugadores = 4;
        
        //Como declarar los arrays en Java
        ArrayList<Integer> sucesion = new ArrayList<>();
        
        //Para que comience desde la posicion 0
        for(int i=0; i<jugadores; i++){
            sucesion.add(0);
        }
        
        //Variable que utilizaremos para conservar el valor despues de cada tiro
        int guardar; 
        
        //bucle recorriendo las 100 posiciones
         
        for(int i=0; i<100; i++){
            guardar = Dado.getInstance().quienEmpieza(jugadores);
            //los almacenamos en el array creado anteriormente
            sucesion.set(guardar, sucesion.get(guardar)+1); // +1 porque le añadimos el del siguiente
        }
        
        
        System.out.println("RESULTADOS: ");
        
        //bucle para devolver los resultados

        for(int i=0; i<jugadores; i++){
        //imprimimos los datos
        System.out.println("Jugador num: " + (i+1) + ", porcentaje: " 
                       + (sucesion.get(i)*1.0) + " %");
       
    }
        

        
       //EJERCICIO2
       //VER SI FUNCIONA EL MODO DEBUG
       
        
        int tiradas= 5;
        
        System.out.println("Los resultados SIN DEBUG: \n");
        
        for(int i=0; i<tiradas/2;i++){
            System.out.println(Dado.getInstance().tirar());
        }
        
            
        Dado.getInstance().setDebug(true);
        System.out.println("Los resultados CON DEBUG: \n");

            
        for(int i = 0 ; i < tiradas/2 ; i++)
            System.out.println(Dado.getInstance().tirar());   
            
        Dado.getInstance().setDebug(false);
        
        
        //EJERCICIO3
        // 3 
        // Prueba de los método getUltimoResultado() 

        System.out.println("Último resultado" + Dado.getInstance().getUltimoResultado());
        
       
        
        //EJERCICIO4
        // Mostrar un valor de cada enumerado
        
      //  System.out.println(TipoCasilla.CALLE);
        //System.out.println(TipoSorpresa.PAGARCOBRAR);

        //EJERCICIO5
       //Crear objeto tablero y hacer operacionesañade algunas calles al tablero, obtén
       //dichas casillas y muestra su estado por consola usando el método toString de la clase Casilla
       //int guardar=0;
       Tablero tab = new Tablero();
      // Casilla cas = new Casilla(); 
       
       //tab.añadeCasilla(cas);
       
       guardar = 0;
       
       tab.toString();
       

        // EJERCICIO6
        // Crea algunos bucles sobre la totalidad de las calles para calcular y mostrar cuál es la calle
        //más cara (en cuanto a su precio de compra), la más barata y el precio medio de las calles
        
        //creamos el arrayList media y le asignamos el valor 0
//        ArrayList <Integer> media= new ArrayList<>();
//        for(int i=0; i<cas.getPrecioCompra();i++){
//            media.add(0);
//        }
//        
//        
//        for(int i=0; i<cas.getPrecioCompra(); i++){
//            if(media.get(i) < cas.getPrecioBaseAlquiler()){
//                return media.get(i);
//            }
//            else
//                 return cas.getPrecioAlquilerCompleto();
//        }
       

        // EJERCICIO7
        Diario d= new Diario();
        
        System.out.println(d.getEventos() + d.leerEvento());
        return 0;

        
        
    }
    
}
