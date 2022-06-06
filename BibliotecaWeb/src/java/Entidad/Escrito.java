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
public class Escrito extends Material{
    public int numPaginas,ISBN,fechaPubli;
    public String editorial,periodicidad;

    public int getNumPaginas() {
        return numPaginas;
    }

    public void setNumPaginas(int numPaginas) {
        this.numPaginas = numPaginas;
    }

    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }
    
     public String getPeriodicidad() {
        return periodicidad;
    }

    public void setPeriodicidad(String periodicidad) {
        this.periodicidad = periodicidad;
    }

    public int getFechaPubli() {
        return fechaPubli;
    }

    public void setFechaPubli(int fechaPubli) {
        this.fechaPubli = fechaPubli;
    }

    @Override
    public String toString() {
        return "Libro: "+super.titulo+" "+this.ISBN+" escrito por: "+super.autor;
    }
    
    
}
