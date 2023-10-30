package pckMain;
import Controlador.CadenasController;
import Modelos.CadenasModel;
import Vistas.frmPrincipal;
import javax.swing.*;


public class Main {
    
//    public frmPrincipal

    public static void main(String[] args) {
        frmPrincipal ventana = new frmPrincipal();
        CadenasModel ModeloCadenas = new CadenasModel();
        CadenasController controlador = new CadenasController(ventana,ModeloCadenas);
        
        
        
        
        
        
    }
    

}
