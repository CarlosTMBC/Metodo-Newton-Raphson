
package Controlador;

import Modelos.Datos;
import Modelos.NewtonModel;
import Vistas.frmPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Queue;

/**
 *
 * @author carlt
 */
public class metNewtonController implements ActionListener
{
    frmPrincipal VistaPrincipal;
    NewtonModel ModeloNewton;

    public metNewtonController(frmPrincipal VistaPrincipal, NewtonModel ModeloNewton) {
        this.VistaPrincipal = VistaPrincipal;
        this.ModeloNewton = ModeloNewton;
        
        this.VistaPrincipal.btnEjecutar.addActionListener(this);
        this.VistaPrincipal.btnVaciar.addActionListener(this);
        
        this.VistaPrincipal.setAlwaysOnTop(true);
        this.VistaPrincipal.setVisible(true);
    }
    

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getSource()==this.VistaPrincipal.btnEjecutar)
        {
            
            this.VistaPrincipal.jtTabla.setModel(this.ModeloNewton.columnas());
           this.ModeloNewton.DesenlistarAntiguos();
            this.ModeloNewton.remplazar(Integer.parseInt(this.VistaPrincipal.txtIteraciones.getText()),
                    Integer.parseInt(this.VistaPrincipal.txtPo.getText()),this.VistaPrincipal.txtFuncion.getText(), 
                    this.VistaPrincipal.txtDerivada.getText());
            
            this.VistaPrincipal.jtTabla.setModel(this.ModeloNewton.MostrarRegistros());
            
            this.ModeloNewton.Vaciar();
            this.VistaPrincipal.txtFuncion.setText("");
            this.VistaPrincipal.txtDerivada.setText("");
            this.VistaPrincipal.txtIteraciones.setText("");
            this.VistaPrincipal.txtPo.setText("");
   
        }
        if(e.getSource()==this.VistaPrincipal.btnVaciar)
        {
            this.ModeloNewton.DesenlistarAntiguos();
            this.VistaPrincipal.jtTabla.setModel(this.ModeloNewton.MostrarRegistros());
        }
    }
    
}
