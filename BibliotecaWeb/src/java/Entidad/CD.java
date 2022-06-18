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
public class CD extends Material{
    String genero, duracion;
    public CD(String codigo, String titulo, String genero,String duracion,String autor, int CantDisp) {
        super(codigo, titulo, autor, CantDisp);
        this.genero=genero;
        this.duracion=duracion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }
    
}
