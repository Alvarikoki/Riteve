package Models;

import Views.FrmVehiculos;

/**
 *
 * @author Álvaro Álvarez R
 */
public class Hilo implements Runnable{
    private FrmVehiculos frm;

    public Hilo(FrmVehiculos frm) {
        this.frm = frm;
    }
    
    
    @Override
    public void run() {
        while(true) {
            frm.mostrarTodo();
            try {
                Thread.sleep(8000);
            } catch (InterruptedException ex) {
                System.out.println(ex.toString());
            }
        }
        
    }
    
}
