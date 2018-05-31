package BaseDeDatos;

import directoriodejuegos2.pkg0.Juego;
import directoriodejuegos2.pkg0.Plataforma;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author {Arturo Alvarellos Blas}{Juan Borrajo Rodriguez}
 */
public class FuncionesBase{

    static Connection conn=null;
    private static String url="jdbc:sqlite:.\\Directorio.db";

    public static boolean firstConnect(){
        boolean conectado=false;
        try{
            conn=DriverManager.getConnection(url);
            IO.sout("Conexion establecida");
            conectado=true;
        }catch(SQLException e){
            conectado=false;
            IO.Mensaje("Connection to SQLite has failed.");
            Logger.getLogger(e.getMessage());
        }finally{

            try{
                if(conn!=null){
                    conn.close();
                }
            }catch(SQLException ex){
                Logger.getLogger(FuncionesBase.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return conectado;
    }

    public static Connection connect(){
        Connection connect=null;
        try{
            connect=DriverManager.getConnection(url);
        }catch(SQLException e){
            IO.sout(e.getMessage());
            IO.sout("Connection to SQLite has failed.");
            IO.Mensaje("Connection to SQLite has failed.");
        }
        return connect;
    }

    public static void close(){
        try{
            if(conn!=null){
                conn.close();
            }
            IO.sout("Database closed");
        }catch(SQLException ex){
            IO.Mensaje("Database close error");
            Logger.getLogger(FuncionesBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void createNewTablePlataforma(){
        // SQL statement for creating a new table
        String sql="CREATE TABLE IF NOT EXISTS plataforma (\n"
                +"	codp integer PRIMARY KEY,\n"
                +"	nombre text NOT NULL,\n"
                +"	modelo text,\n"
                +"      marca text, \n"
                +"      descripcion text \n"
                +");";

        try(Connection conn=DriverManager.getConnection(url);
                Statement stmt=conn.createStatement()){
            // create a new table
            stmt.execute(sql);
            IO.sout("Tabla Creada");
        }catch(SQLException e){
            IO.Mensaje("Fallo en la creacion de la tabla");
            System.out.println(e.getMessage());
        }
    }

    public static void createNewTableJuego(){
        // SQL statement for creating a new table
        String sql="CREATE TABLE IF NOT EXISTS juego (\n"
                +"	codj integer PRIMARY KEY,\n"
                +"      codp integer, \n"
                +"	nombre text NOT NULL,\n"
                +"	tipo text,\n"
                +"      njug int, \n"
                +"      terminado boolean, \n"
                +"      FOREIGN KEY (codp) REFERENCES plataforma (codp) \n"
                +");";

        try(Connection conn=DriverManager.getConnection(url);
                Statement stmt=conn.createStatement()){
            // create a new table
            stmt.execute(sql);
            IO.sout("Tabla Creada");
        }catch(SQLException e){
            IO.Mensaje("Fallo en la creacion de la tabla");
            System.out.println(e.getMessage());
        }
    }

    public static void updateAllPlataforma(int cod, String nombre, String modelo, String marca, String descripcion){
        String sql="UPDATE plataforma SET nombre = ? , "
                +"modelo = ? , "
                +"marca = ? , "
                +"descripcion = ? , "
                +"WHERE codp = ?";

        try(Connection conn=FuncionesBase.connect();
                PreparedStatement pstmt=conn.prepareStatement(sql)){

            // set the corresponding param
            pstmt.setString(1, nombre);
            pstmt.setString(2, modelo);
            pstmt.setString(3, marca);
            pstmt.setString(4, descripcion);
            pstmt.setInt(5, cod);
            // update 
            pstmt.executeUpdate();
            IO.Mensaje("Actualización realizada");
        }catch(SQLException e){
            IO.Mensaje("Fallo al actualizar");
            System.out.println(e.getMessage());
        }
    }

    public static void updateAllJuego(int cod, int plataforma, String nombre, String tipo, int njug, boolean terminado){
        String sql="UPDATE jurgo SET plataforma = ? , "
                +"nombre = ? , "
                +"tipo = ? , "
                +"njug = ? , "
                +"terminado = ? , "
                +"WHERE codigo = ?";

        try(Connection conn=FuncionesBase.connect();
                PreparedStatement pstmt=conn.prepareStatement(sql)){

            // set the corresponding param
            pstmt.setInt(1, plataforma);
            pstmt.setString(2, nombre);
            pstmt.setString(3, tipo);
            pstmt.setInt(4, njug);
            pstmt.setBoolean(5, terminado);
            pstmt.setInt(6, cod);
            // update 
            pstmt.executeUpdate();
            IO.Mensaje("Actualización realizada");
        }catch(SQLException e){
            IO.Mensaje("Fallo al actualizar");
            System.out.println(e.getMessage());
        }
    }

    public static void updateFieldJuego(String campo, String dato, int cod){
        String sql="UPDATE juego SET '"+campo+"' = ? WHERE codigo = ? ";

        try(Connection conn=FuncionesBase.connect();
                PreparedStatement pstmt=conn.prepareStatement(sql)){
            // set the corresponding param
            pstmt.setString(1, dato);
            pstmt.setInt(2, cod);
            //update
            pstmt.executeUpdate();
            IO.Mensaje("Actualización realizada");
        }catch(SQLException ex){
            IO.Mensaje("Fallo al actualizar");
            Logger.getLogger(FuncionesBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void selectAllPlataforma(){
        String sql="SELECT codp, nombre, modelo, marca, descripcion FROM plataforma";
        Plataforma.plataformas.clear();
        try(Connection conn=FuncionesBase.connect();
                Statement stmt=conn.createStatement();
                ResultSet rs=stmt.executeQuery(sql)){

            // loop through the result set
            while(rs.next()){
                IO.sout(rs.getInt("codp")+"\t"
                        +rs.getString("nombre")+"\t"
                        +rs.getString("modelo")+"\t"
                        +rs.getString("marca")+"\t"
                        +rs.getString("descripcion"));

                Plataforma.plataformas.add(new Plataforma(
                        rs.getInt("codp"),
                        rs.getString("nombre"),
                        rs.getString("modelo"),
                        rs.getString("marca"),
                        rs.getString("descripcion")));
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public static void selectAllJuego(){
        String sql="SELECT codj, codp, nombre, tipo, njug, terminado FROM juego";
        Juego.juegos.clear();
        try(Connection conn=FuncionesBase.connect();
                Statement stmt=conn.createStatement();
                ResultSet rs=stmt.executeQuery(sql)){

            // loop through the result set
            while(rs.next()){
                IO.sout(rs.getInt("codj")+"\t"
                        +rs.getInt("codp")+"\t"
                        +rs.getString("nombre")+"\t"
                        +rs.getString("tipo")+"\t"
                        +rs.getInt("njug")+"\t"
                        +rs.getBoolean("terminado"));

                Juego.juegos.add(new Juego(
                        rs.getInt("codj"),
                        rs.getInt("codp"),
                        rs.getString("nombre"),
                        rs.getString("tipo"),
                        rs.getInt("njug"),
                        rs.getBoolean("terminado")));
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public static String selectCodPlataforma(int cod){
        String sql="SELECT codp, nombre, modelo, marca, descripcion "
                +"FROM plataforma WHERE codigo = ?";
        String st="";
        try(Connection conn=FuncionesBase.connect();
                PreparedStatement pstmt=conn.prepareStatement(sql)){

            // set the value
            pstmt.setDouble(1, cod);
            //
            ResultSet rs=pstmt.executeQuery();

            // loop through the result set
            while(rs.next()){
                st=(rs.getInt("codp")+"\t"
                        +rs.getString("nombre")+"\t"
                        +rs.getString("modelo")+"\t"
                        +rs.getString("marca")+"\t"
                        +rs.getString("descripcion"));
                System.out.println(st);
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return st;
    }

    public static String selectCodJuego(int cod){
        String sql="SELECT codj, codp, nombre, tipo, njug, terminado "
                +"FROM juego WHERE codigo = ?";
        String st="";
        try(Connection conn=FuncionesBase.connect();
                PreparedStatement pstmt=conn.prepareStatement(sql)){

            // set the value
            pstmt.setDouble(1, cod);
            //
            ResultSet rs=pstmt.executeQuery();

            // loop through the result set
            while(rs.next()){
                st=(rs.getInt("codj")+"\t"
                        +rs.getInt("codp")+"\t"
                        +rs.getString("nombre")+"\t"
                        +rs.getString("tipo")+"\t"
                        +rs.getInt("njug")+"\t"
                        +rs.getBoolean("terminado"));
                System.out.println(st);
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return st;
    }

    public static void insertPlataforma(int cod, String nombre, String modelo, String marca, String descripcion){
        String sql="INSERT INTO plataforma(codp ,nombre, modelo, marca, descripcion) VALUES(?,?,?,?,?)";

        try(Connection conn=FuncionesBase.connect();
                PreparedStatement pstmt=conn.prepareStatement(sql)){
            pstmt.setInt(1, cod);
            pstmt.setString(2, nombre);
            pstmt.setString(3, modelo);
            pstmt.setString(4, marca);
            pstmt.setString(5, descripcion);
            pstmt.executeUpdate();
            IO.sout("Introducción Realizada");
        }catch(SQLException e){
            IO.sout("Fallo al introducir datos");
            System.out.println(e.getMessage());
        }
    }

    public static void insertJuego(int cod, int plataforma, String nombre, String tipo, int njug, boolean terminado){
        String sql="INSERT INTO juego(codj ,codp, nombre, tipo, njug, terminado) VALUES(?,?,?,?,?,?)";

        try(Connection conn=FuncionesBase.connect();
                PreparedStatement pstmt=conn.prepareStatement(sql)){
            pstmt.setInt(1, cod);
            pstmt.setInt(2, plataforma);
            pstmt.setString(3, nombre);
            pstmt.setString(4, tipo);
            pstmt.setInt(5, njug);
            pstmt.setBoolean(6, terminado);
            pstmt.executeUpdate();
            IO.Mensaje("Introducción Realizada");
        }catch(SQLException e){
            IO.Mensaje("Fallo al introducir datos");
            System.out.println(e.getMessage());
        }
    }

    public static void updateField(String tabla, String campo, String dato, int cod){
        String code="";
        if(tabla.equalsIgnoreCase("juego")){
            code="codj";
        }else{
            code="codp";
        }
        String sql="UPDATE '"+tabla+"' SET '"+campo+"' = ? WHERE "+code+" = ? ";

        try(Connection conn=FuncionesBase.connect();
                PreparedStatement pstmt=conn.prepareStatement(sql)){
            // set the corresponding param
            pstmt.setString(1, dato);
            pstmt.setInt(2, cod);
            //update
            pstmt.executeUpdate();
            IO.Mensaje("Actualización terminada");
        }catch(SQLException ex){
            IO.Mensaje("Actualización Fallida");
            Logger.getLogger(FuncionesBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void delete(String tabla, int cod){
        String code="";
        if(tabla.equalsIgnoreCase("juego")){
            code="codj";
        }else{
            code="codp";
        }
        String sql="DELETE FROM '"+tabla+"' WHERE "+code+" = ?";
        try(Connection conn=FuncionesBase.connect();
                PreparedStatement pstmt=conn.prepareStatement(sql)){

            // set the corresponding param
            pstmt.setInt(1, cod);
            // execute the delete statement
            pstmt.executeUpdate();
            IO.Mensaje("Se ha borrado una entrada");
        }catch(SQLException e){
            IO.Mensaje("Fallo al borrar");
            System.out.println(e.getMessage());
        }
    }
}
