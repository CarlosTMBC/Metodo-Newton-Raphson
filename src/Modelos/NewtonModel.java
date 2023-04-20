/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;


import javax.swing.table.DefaultTableModel;
import java.util.LinkedList;
import java.util.Queue;
import javax.swing.JOptionPane;

/**
 *
 * @author carlt
 */
public class NewtonModel {
    Queue<Datos> ListaDatos = new LinkedList();
    DefaultTableModel ModeloTabla;
    
    
   
    
    public DefaultTableModel DesenlistarAntiguos()
    {
            if(this.ModeloTabla.getRowCount()>0)
            {
                ModeloTabla = new DefaultTableModel();
            }
        return ModeloTabla;
    }
    
    
    public void replacas()
    {
        
    }
    
    public void remplazar(int n, int po, String funcion, String derivada)
    {
        Datos registro = null ;
        for(int i = 0; i<=n;i++)
        {   
            funcion = funcion.replace("x", Integer.toString(po));
            derivada = derivada.replace("x", Integer.toString(po));
            
            registro = new Datos(i, po,funcion,derivada);

               
               
           
           this.ListaDatos.add(registro);
        }  
    }
    
    public DefaultTableModel MostrarRegistros()
    {
        
        for(Datos MiListaDeDatos: ListaDatos)
        {
            
            this.ModeloTabla.addRow(new Object []{MiListaDeDatos.getN()
                    ,MiListaDeDatos.getPo(),MiListaDeDatos.getFuncion(),MiListaDeDatos.getDerivada()});
        }
        
        return ModeloTabla;
    }
    
     public DefaultTableModel columnas()
     {
         ModeloTabla = new DefaultTableModel();
            this.ModeloTabla.addColumn("N°");
            this.ModeloTabla.addColumn("P[n]");
            this.ModeloTabla.addColumn("f(P[n])");
            this.ModeloTabla.addColumn("f'(P[n])");
            return ModeloTabla;
     }
     
     public void Vaciar()
        {
            this.ListaDatos.clear();
            
            
        }
     public void Desencolar()
     {
         this.ListaDatos.poll();
     }
}
