/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import civitas.Jugador;
import civitas.JugadorEspeculador;
import GUI.CivitasView;
import GUI.Dado;
import GUI.CapturaNombres; 
//import civitas.Dado;
import java.util.ArrayList;
import civitas.CivitasJuego;
import controladorCivitas.Controlador;
/**
 *
 * @author martina
 */
public class TestP5 {
    public static void main(String[] args){

       CivitasView view = new CivitasView();
       Dado.createInstance(view);
       CapturaNombres captura=new CapturaNombres(view,true);
       ArrayList<String>nombres=new ArrayList<>();
       nombres=captura.getNombres();
       
       CivitasJuego juego=new CivitasJuego(nombres,true);//false para que no sea el modo debug
       Controlador controlador=new Controlador(juego,view);
       
       view.setCivitasJuego(juego);
      view.actualiza();
       
        
       controlador.juega();
    }
}
