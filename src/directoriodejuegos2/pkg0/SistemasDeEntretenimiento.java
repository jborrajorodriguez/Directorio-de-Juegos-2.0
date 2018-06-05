package directoriodejuegos2.pkg0;

/**
 *
 * @author Arturo
 */
public class SistemasDeEntretenimiento {
    private int codp;
    private String nombre;

    public SistemasDeEntretenimiento(){
    }

    public SistemasDeEntretenimiento(int codp, String nombre){
        this.codp=codp;
        this.nombre=nombre;
    }

    public int getCodp(){
        return codp;
    }

    public void setCodp(int codp){
        this.codp=codp;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    
}
