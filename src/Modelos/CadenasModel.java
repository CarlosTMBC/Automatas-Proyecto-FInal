/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author carlt
 */
public class CadenasModel {
    ArrayList<Cadenas> ListaDatos = new ArrayList();
    DefaultTableModel ModeloTabla; 
    Cadenas registro;
    public void IngresarCadenas(String texto)
    {
         registro = new Cadenas(texto, "");
            ListaDatos.add(registro);
    }
    
    public DefaultTableModel MostrarRegistros()
    {
        ModeloTabla = new DefaultTableModel();
            this.ModeloTabla.addColumn("Cadenas");
            this.ModeloTabla.addColumn("Evaluacion");
            
        for(Cadenas MiListaDeDatos: ListaDatos)
        {
            
            this.ModeloTabla.addRow(new Object []{MiListaDeDatos.getTexto(),MiListaDeDatos.getValidacion()});
        }
        
        return ModeloTabla;
    } 
    public DefaultTableModel Evaluar()
    {    
       
        for (int fila = 0; fila < ModeloTabla.getRowCount(); fila++) {
            Object valorColumna0 = ModeloTabla.getValueAt(fila, 0);
            
           ModeloTabla.setValueAt(validarCadena((String)valorColumna0), fila, 1);
        }
        
        return ModeloTabla;
    } 

    

    public ArrayList<Cadenas> Limpiar()
    {
        this.ListaDatos.removeAll(ListaDatos);
        return ListaDatos;
    }
    
    
    public static String validarCadena(String cadena) {
        // Expresión regular para validar la cadena
        String expresionRegular = "^\\d+|[A-Z][a-z]*$";
        String respuesta ="";
        
        Pattern pattern = Pattern.compile(expresionRegular);
        Matcher matcher = pattern.matcher(cadena);
        
        
         if (matcher.matches() && !contieneDosVocalesIguales(cadena)) 
            respuesta ="Cadena Aceptada";
         else 
            respuesta = "Cadena No Aceptada";
         
        return respuesta;
    }
    
    public static boolean contieneDosVocalesIguales(String cadena) {
        cadena = cadena.toLowerCase();
        for (int i = 0; i < cadena.length() - 1; i++) {
            if (cadena.charAt(i) == cadena.charAt(i + 1) && "aeioubdfghjkmnprqstvwyz".contains(String.valueOf(cadena.charAt(i)))) 
                return true;
        }
        return false;
    }
}
