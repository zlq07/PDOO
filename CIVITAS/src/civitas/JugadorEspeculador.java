/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package civitas;

/**
 *
 * @author martina
 */
public class JugadorEspeculador extends Jugador {

    private static int FactorEspeculador = 2;

    public JugadorEspeculador(Jugador jugador) {
        super(jugador);
        actualizaPropiedadesPorConversion();
    }

    public void actualizaPropiedadesPorConversion() {
        for (int i = 0; i < super.propiedades.size(); i++) {
            propiedades.get(i).actualizaPropietarioPorConversion(this);
        }
    }

    protected static int getCasasMax() {
        return CasasMax * FactorEspeculador;
    }

    protected static int getHotelesMax() {
        return CasaPorHotel * FactorEspeculador;
    }
    
    /*
    @Override
    boolean modificarSaldo(float cantidad) {
        saldo = saldo + cantidad / 2;

        String texto = "\nSe modifica el saldo del jugador" + getNombre() + " a la cantidad " + cantidad;
        Diario.getInstance().ocurreEvento(texto);

        return true;
    }
*/

    @Override
    public JugadorEspeculador convertir() {
        return this;
    }

    @Override
    boolean paga(float cantidad) {
        return this.modificarSaldo(-cantidad / FactorEspeculador);
    }

    @Override
    public String toString() {
        return "JugadorEspeculador " + this.getNombre();
    }

    @Override
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
                Diario.getInstance().ocurreEvento("El jugador " + super.getNombre() + " construye una casa en la propiedad " + i);

            }
        }
        return result;

    }

    @Override
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
                Diario.getInstance().ocurreEvento("\nEl jugador " + super.getNombre() + " construye hotel en la propiedad " + ip);
            }
        }
        return result;
    }

    @Override
    public boolean puedoEdificarCasa(CasillaCalle propiedad) {
        boolean puedo = false;
        if (propiedad.getnumCasa() < this.getCasasMax() && puedoGastar(propiedad.getPrecioEdificar())) {
            puedo = true;
        }
        return puedo;

    }

    @Override
    public boolean puedoEdificarHotel(CasillaCalle propiedad) {
        boolean puedo = false;
        if (propiedad.getnumCasa() == CasasMax && puedoGastar(propiedad.getPrecioEdificar()) && propiedad.getnumHoteles() <= HotelesMax) {
            puedo = true;
        } else {
            puedo = false;
        }
        return puedo;
    }

    @Override
    public boolean puedoGastar(float precio) {
        return saldo >= precio;
    }
}
