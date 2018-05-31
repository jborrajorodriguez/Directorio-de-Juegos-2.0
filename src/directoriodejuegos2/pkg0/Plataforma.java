package directoriodejuegos2.pkg0;

import java.util.ArrayList;

/**
 * @author {Juan Borrajo Rodriguez}
 */
public class Plataforma {

    private int codp;
    private String nombre;
    private String modelo;
    private String marca;
    private String descripcion;
    public static ArrayList<Plataforma> plataformas=new ArrayList();

    public Plataforma() {
    }

    public Plataforma(int codp, String nombre, String modelo, String marca, String descripcion) {
        this.codp = codp;
        this.nombre = nombre;
        this.modelo = modelo;
        this.marca = marca;
        this.descripcion = descripcion;
    }

    public int getCodP() {
        return codp;
    }

    public void setCodP(int codp) {
        this.codp = codp;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return("Nombre: "+nombre+"\n"
                + "Modelo: "+modelo+"\n"
                + "Marca: "+marca+"\n"
                + "Descripción: "+descripcion);
    }
    
    

}
