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
public class Audiovisual extends Material{
    public String genero,duracion;
    public int numCanciones;
    
    public Audiovisual(){
        super();
    }
    
    public Audiovisual(String genero, String duracion, int numCanciones){
        this.genero=genero;
        this.duracion=duracion;
        this.numCanciones=numCanciones;
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

    public int getNumCanciones() {
        return numCanciones;
    }

    public void setNumCanciones(int numCanciones) {
        this.numCanciones = numCanciones;
    }

    @Override
    public String toString() {
        return "CDs: " + super.titulo + " ("+genero + "), escrita por: " + super.autor;
    }
    
    
}
