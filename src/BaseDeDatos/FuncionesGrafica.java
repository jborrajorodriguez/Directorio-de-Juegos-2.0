package BaseDeDatos;

import directoriodejuegos2.pkg0.Juego;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Arturo
 */
public class FuncionesGrafica {
    
    public static boolean rellenarTabla(DefaultTableModel tab){
        boolean control=false;
        for(int i=0; i<tab.getRowCount(); i++){
            tab.removeRow(i);
            tab.setRowCount(0);
        }
        FuncionesBase.selectAllJuego();
        Object ob[]=null;
        for(int i=0; i<Juego.juegos.size(); i++){
            tab.addRow(ob);
            tab.setValueAt(Juego.juegos.get(i).getNome(), i, 0);
            tab.setValueAt(Juego.juegos.get(i).getCodp(), i, 1);
            tab.setValueAt(Juego.juegos.get(i).getTipo(), i, 2);
            tab.setValueAt(Juego.juegos.get(i).getnjug(), i, 3);
            tab.setValueAt(Juego.juegos.get(i).getTerminado(), i, 4);
            control=true;
        }
        return control;
    }
}
