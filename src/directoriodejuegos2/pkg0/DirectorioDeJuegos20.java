
package directoriodejuegos2.pkg0;


import BaseDeDatos.FuncionesBase;
import GUI.VentanaPrincipal;

/**
 *
 * @author Juan Borrajo Rodriguez
 */
public class DirectorioDeJuegos20 {

    
    public static void main(String[] args) {
        FuncionesBase.firstConnect();
        FuncionesBase.createNewTablePlataforma();
        FuncionesBase.createNewTableJuego();
        FuncionesBase.insertPlataforma(1, "Xbox", "One s", "Microsoft", "La única consola diseñada para disfrutar de los mejores juegos del pasado, presente y futuro");
        FuncionesBase.insertPlataforma(2, "PlayStation", "4", "Sony", "La nueva PS4 más delgada y ligera, la consola más vendida del mundo, incluye gran potencia para tus juegos en versiones de 500 GB y 1 TB. Ya disponible en Jet Black, Glacier White y los fantásticos Gold y Silver.");
        FuncionesBase.insertPlataforma(3, "PC", "Windows 10", "Desconocido", "Ordenador de torre con pantalla teclado y raton");
        FuncionesBase.insertPlataforma(4, "Switch", " ", "Nintendo", "La consola Nintendo Switch está diseñada para acompañarte dondequiera que vayas, transformándose de consola para el hogar a consola portátil en un instante.");
        VentanaPrincipal a=new VentanaPrincipal();
    }

}
