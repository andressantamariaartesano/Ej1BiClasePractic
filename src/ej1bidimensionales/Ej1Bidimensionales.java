/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ej1bidimensionales;

/**
 *
 * @author dam
 */
public class Ej1Bidimensionales {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Concesionario concesionario = new Concesionario(3);
        concesionario.introducirDatos();
        concesionario.pedirVentas();
        concesionario.informeVentas();
        
    }
    
}
