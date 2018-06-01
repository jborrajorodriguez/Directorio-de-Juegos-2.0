package BaseDeDatos;

import directoriodejuegos2.pkg0.Juego;
import directoriodejuegos2.pkg0.Plataforma;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Arturo
 */
public class FuncionesGrafica{

    public static boolean rellenarTabla(DefaultTableModel tab){
        FuncionesBase.selectAllPlataforma();
        FuncionesBase.selectAllJuego();
        boolean control=false;
        for(int i=0; i<tab.getRowCount(); i++){
            tab.removeRow(i);
            tab.setRowCount(0);
        }
        FuncionesBase.selectAllJuego();
        Object ob[]=null;
        String pla="";
        for(int i=0; i<Juego.juegos.size(); i++){
            tab.addRow(ob);
            for(int j=0; j<Plataforma.plataformas.size(); j++){
                if(Juego.juegos.get(i).getCodp()==Plataforma.plataformas.get(j).getCodP()){
                    pla=Plataforma.plataformas.get(j).getNombre();
                }
            }
            tab.setValueAt(Juego.juegos.get(i).getNombre(), i, 0);
            tab.setValueAt(pla, i, 1);
            tab.setValueAt(Juego.juegos.get(i).getTipo(), i, 2);
            tab.setValueAt(Juego.juegos.get(i).getnjug(), i, 3);
            tab.setValueAt(Juego.juegos.get(i).getTerminado(), i, 4);
            control=true;
        }
        return control;
    }

    public static boolean rellenarTabla2(DefaultTableModel tab){
        FuncionesBase.selectAllPlataforma();
        FuncionesBase.selectAllJuego();
        boolean control=false;
        for(int i=0; i<tab.getRowCount(); i++){
            tab.removeRow(i);
            tab.setRowCount(0);
        }
        FuncionesBase.selectAllJuego();
        Object ob[]=null;
        String pla="";
        for(int i=0; i<Juego.juegos.size(); i++){
            tab.addRow(ob);
            for(int j=0; j<Plataforma.plataformas.size(); j++){
                if(Juego.juegos.get(i).getCodp()==Plataforma.plataformas.get(j).getCodP()){
                    pla=Plataforma.plataformas.get(j).getNombre();
                }
            }
            tab.setValueAt(Juego.juegos.get(i).getNombre(), i, 0);
            tab.setValueAt(pla, i, 1);
            control=true;
        }
        return control;
    }

}
