package directoriodejuegos2.pkg0;

import java.util.ArrayList;

/**
 * @author {Juan Borrajo Rodriguez}
 */
public class Juego {

    private int codj;
    private int codp;
    private String nome;
    private String tipo;
    private int njug;
    private boolean terminado;
    public static ArrayList<Juego> juegos=new ArrayList();

    public Juego(){
    }

    public Juego(int codj, int codp, String nome, String tipo, int nJugadores, boolean terminado){
        this.codj=codj;
        this.codp=codp;
        this.nome=nome;
        this.tipo=tipo;
        this.njug=nJugadores;
        this.terminado=terminado;
    }

    public int getCodj(){
        return codj;
    }

    public void setCodj(int codj){
        this.codj=codj;
    }

    public int getCodp(){
        return codp;
    }

    public void setCodp(int codp){
        this.codp=codp;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome=nome;
    }

    public String getTipo(){
        return tipo;
    }

    public void setTipo(String tipo){
        this.tipo=tipo;
    }

    public int getnjug(){
        return njug;
    }

    public void setnjug(int njug){
        this.njug=njug;
    }

    public boolean getTerminado(){
        return terminado;
    }

    public void setTerminado(boolean terminado){
        this.terminado=terminado;
    }

    public ArrayList<Juego> getJuegos(){
        return juegos;
    }

    public void setJuegos(ArrayList<Juego> juegos){
        this.juegos=juegos;
    }
    
    

}
