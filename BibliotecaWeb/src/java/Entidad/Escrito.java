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
    public int numPaginas,fechaPubli;
    public String editorial,periodicidad,ISBN;

    public Escrito(String codigo, String titulo, String autor,int numPaginas, String ISBN,int fechaPubli,int cantDis) {
        super(codigo, titulo, autor,cantDis);
        this.numPaginas = numPaginas;
        this.ISBN = ISBN;
        this.fechaPubli = fechaPubli;
    }

    
    public int getNumPaginas() {
        return numPaginas;
    }

    public void setNumPaginas(int numPaginas) {
        this.numPaginas = numPaginas;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
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
   
}
