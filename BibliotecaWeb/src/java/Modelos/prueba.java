/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import Entidad.Material;
import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class prueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        PrestamosCRUD mostrar = new PrestamosCRUD();
        ArrayList<Material> materiales = mostrar.materialIndividual(mostrar.SQL_libro, "LIB88365"); 

        System.out.println(materiales);
    }
    
}
