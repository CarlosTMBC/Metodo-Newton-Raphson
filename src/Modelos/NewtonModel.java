/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;


import javax.swing.table.DefaultTableModel;
import java.util.LinkedList;
import java.util.Queue;
import org.nfunk.jep.JEP;


/**
 *
 * @author carlt
 */
public class NewtonModel {
    Queue<Datos> ListaDatos = new LinkedList();
    DefaultTableModel ModeloTabla;
    JEP jep;
    JEP jep2;
    double result=0;
    double result2=0;
    String error="";
  
     
   
   
    
    
    public void remplazar(int n, Double po, String funcion, String derivada)
    {
        double poNuevo=0;
        jep = new JEP();
        jep2 = new JEP();
        String funcionOriginal = funcion;
        String derivadaOriginal = derivada;
        Datos registro = null ;
        this.jep.addStandardFunctions();
        this.jep.addStandardConstants();
        this.jep.addVariable("x", po);
        this.jep.parseExpression(funcion);
        this.result = this.jep.getValue();
        funcion =String.valueOf(result);
        this.jep2.addStandardFunctions();
        this.jep2.addStandardConstants();
        this.jep2.addVariable("x", po);
        this.jep2.parseExpression(derivada);
        this.result2 = this.jep2.getValue();
        derivada =String.valueOf(result2);
        
        
        
        this.error = (this.jep.hasError())? "Existe un error.":"No hay error.";
        this.error = (this.jep2.hasError())? "Existe un error.":"No hay error.";
        for(int i = 0; i<=n;i++)
        {   
           
//            funcion = funcion.replace("x", Double.toString(po));
//            derivada = derivada.replace("x", Double.toString(po));
            registro = new Datos(i, po,funcion,derivada);  
            if(i == 0 )
            {
                
                this.ListaDatos.add(registro);
            }
            else if(i!=0)
            {
                poNuevo = po;
                po = poNuevo - (Double.parseDouble(funcion) / Double.parseDouble(derivada));
                
                
                this.jep.addVariable("x", po);
                this.jep.parseExpression(funcionOriginal);
                this.result = this.jep.getValue();
                funcion =String.valueOf(result);
                
                this.jep2.addVariable("x", po);
                this.jep2.parseExpression(derivadaOriginal);
                this.result2 = this.jep2.getValue();
                derivada =String.valueOf(result2);
                this.ListaDatos.add(registro);
                System.out.println(po);
            }
            
        }
     
        
    }
    
    public DefaultTableModel MostrarRegistros()
    {
        ModeloTabla = new DefaultTableModel();
            this.ModeloTabla.addColumn("N°");
            this.ModeloTabla.addColumn("P[n]");
            this.ModeloTabla.addColumn("f(P[n])");
            this.ModeloTabla.addColumn("f'(P[n])");
            
        
        for(Datos MiListaDeDatos: ListaDatos)
        {
            
            this.ModeloTabla.addRow(new Object []{MiListaDeDatos.getN()
                    ,MiListaDeDatos.getPo(),MiListaDeDatos.getFuncion(),MiListaDeDatos.getDerivada()});
        }
        
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
