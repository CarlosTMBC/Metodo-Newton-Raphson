/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pckMain;

import Controlador.metNewtonController;
import Modelos.NewtonModel;
import Vistas.frmPrincipal;

/**
 *
 * @author carlt
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    frmPrincipal VistaPrincipal = new frmPrincipal() ;
    NewtonModel ModeloNewton = new NewtonModel();
    metNewtonController Controlador = new metNewtonController(VistaPrincipal,ModeloNewton);
    }
    
}
