package directoriodejuegos2.pkg0;

/**
 * @author {Juan Borrajo Rodriguez}
 */
public class Plataforma {

    private String codP;
    private String nombre;
    private String modelo;
    private String marca;
    private String descripcion;

    public Plataforma() {
    }

    public Plataforma(String codP, String nombre, String modelo, String marca, String descripcion) {
        this.codP = codP;
        this.nombre = nombre;
        this.modelo = modelo;
        this.marca = marca;
        this.descripcion = descripcion;
    }

    public String getCodP() {
        return codP;
    }

    public void setCodP(String codP) {
        this.codP = codP;
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
        return "Plataforma{" + "codP=" + codP + ", nombre=" + nombre + ", modelo=" + modelo + ", marca=" + marca + ", descripcion=" + descripcion + '}';
    }
    
    

}
