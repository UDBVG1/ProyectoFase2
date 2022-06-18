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
    public String periodicidad;
    int fechaPubli;

    public Revista(String codigo, String titulo,String autor,String periodicidad, int fechaPubli, int CantDisp) {
        super(codigo, titulo,autor, CantDisp);
        this.periodicidad = periodicidad;
        this.fechaPubli = fechaPubli;       
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
        return "Revista: " + super.titulo + " escrita por: "+super.autor;
    }
    
}
