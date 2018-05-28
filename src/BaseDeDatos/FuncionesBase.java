package BaseDeDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author {Juan Borrajo Rodriguez}
 */
public class FuncionesBase {

    static Connection connect=null;
    private static String url="jdbc:sqlite:.\\Directorio.db";
    public static boolean firstConnect(){
        boolean conectado=false;
        try {
            connect=DriverManager.getConnection(url);
            System.out.println("Conexion establecida");
            conectado=true;
        } catch (SQLException ex) {
            conectado=false;
            Logger.getLogger(FuncionesBase.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            
                try {
                    if(connect!=null){
                    connect.close();
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(FuncionesBase.class.getName()).log(Level.SEVERE, null, ex);
                }
            
        }
        return conectado;
        
        
        
    }
}
