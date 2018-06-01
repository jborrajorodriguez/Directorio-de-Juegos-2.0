package directoriodejuegos2.pkg0;

import BaseDeDatos.FuncionesBase;
import java.util.ArrayList;

/**
 * @author {Juan Borrajo Rodriguez}
 */
public class Juego extends SistemasDeEntretenimiento{

    private int codj;
    private int codp;
    private String nombre;
    private String tipo;
    private int njug;
    private boolean terminado;
    public static ArrayList<Juego> juegos = new ArrayList();

    public Juego() {
    }

    public Juego(int codj, int codp, String nombre, String tipo, int nJugadores, boolean terminado) {
        this.codj = codj;
        this.codp = codp;
        this.nombre = nombre;
        this.tipo = tipo;
        this.njug = nJugadores;
        this.terminado = terminado;
    }

    public int getCodj() {
        return codj;
    }

    public void setCodj(int codj) {
        this.codj = codj;
    }

    @Override
    public int getCodp() {
        return codp;
    }

    @Override
    public void setCodp(int codp) {
        this.codp = codp;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getnjug() {
        return njug;
    }

    public void setnjug(int njug) {
        this.njug = njug;
    }

    public boolean getTerminado() {
        return terminado;
    }

    public void setTerminado(boolean terminado) {
        this.terminado = terminado;
    }

    public ArrayList<Juego> getJuegos() {
        return juegos;
    }

    public void setJuegos(ArrayList<Juego> juegos) {
        this.juegos = juegos;
    }

    @Override
    public String toString() {
        String term = "";
        if (terminado) {
            term = "Terminado";
        } else {
            term = "Sin Terminar";
        }
        String plataf = "";
        FuncionesBase.selectAllPlataforma();
        for (int i = 0; i < Plataforma.plataformas.size(); i++) {
            if (Plataforma.plataformas.get(i).getCodP() == codp) {
                plataf = Plataforma.plataformas.get(i).getNombre();
            }
        }
        return ("Nombre: " + nombre + "\n"
                + "Plataforma: " + plataf + "\n"
                + "Tipo: " + tipo + "\n"
                + "Numero de jugadores: " + njug + "\n"
                + "Terminado: " + term + "\n")
                + "********************************\n";
    }

}
