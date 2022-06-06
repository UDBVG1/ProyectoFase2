/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidad;

/**
 *
 * @author admin
 */
public class Revista extends Material{
    public String editorial, periodicidad, fechaPubli;

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }



    @Override
    public String toString() {
        return "Revista: " + super.titulo + " escrita por: "+super.autor;
    }
    
}
