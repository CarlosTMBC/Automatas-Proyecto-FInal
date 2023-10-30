/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelos.CadenasModel;
import Vistas.frmPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author carlt
 */
public class CadenasController implements ActionListener {
    frmPrincipal VistaPrincipal;
    CadenasModel ModeloCadenas;

    public CadenasController(frmPrincipal VistaPrincipal, CadenasModel ModeloCadenas) {
        this.VistaPrincipal = VistaPrincipal;
        this.ModeloCadenas = ModeloCadenas;
        
        this.VistaPrincipal.setLocationRelativeTo(VistaPrincipal);
        this.VistaPrincipal.setVisible(true);
        
        this.VistaPrincipal.cambiarColores(VistaPrincipal.paneles);
        this.VistaPrincipal.cColor(VistaPrincipal.btnIngresar);
        this.VistaPrincipal.cColor(VistaPrincipal.btnEvaluar);
        this.VistaPrincipal.cColor(VistaPrincipal.btnLimpiar);
        
        this.VistaPrincipal.btnEvaluar.addActionListener(this);
        this.VistaPrincipal.btnIngresar.addActionListener(this);
        this.VistaPrincipal.btnLimpiar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.VistaPrincipal.btnIngresar)
        {
            
            this.ModeloCadenas.IngresarCadenas(this.VistaPrincipal.txtCadenas.getText());
            this.VistaPrincipal.tabla.setModel(this.ModeloCadenas.MostrarRegistros());
            this.VistaPrincipal.txtCadenas.setText("");
        }
        if(e.getSource() == this.VistaPrincipal.btnEvaluar)
        {
            this.VistaPrincipal.tabla.setModel(this.ModeloCadenas.Evaluar());
        }
        if(e.getSource() == this.VistaPrincipal.btnLimpiar)
        {
            this.ModeloCadenas.Limpiar();
            this.VistaPrincipal.tabla.setModel(this.ModeloCadenas.MostrarRegistros());
        }
    }
    
    
    
}
