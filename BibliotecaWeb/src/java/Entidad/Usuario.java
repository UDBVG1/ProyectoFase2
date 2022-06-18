/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidad;

/**
 *
 * @author amgoo
 */
public class Usuario {
    private int IdUs,Nivel;
    private String Nombre,Usuario,Identificador,Clave;

    public int getIdUs() {
        return IdUs;
    }

    public void setIdUs(int IdUs) {
        this.IdUs = IdUs;
    }

    public int getNivel() {
        return Nivel;
    }

    public void setNivel(int Nivel) {
        this.Nivel = Nivel;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getIdentificador() {
        return Identificador;
    }

    public void setIdentificador(String Identificador) {
        this.Identificador = Identificador;
    }

    public String getClave() {
        return Clave;
    }

    public void setClave(String Clave) {
        this.Clave = Clave;
    }

    public Usuario() {
    }

    public Usuario(int IdUs, int Nivel, String Nombre, String Usuario, String Identificador, String Clave) {
        this.IdUs = IdUs;
        this.Nivel = Nivel;
        this.Nombre = Nombre;
        this.Usuario = Usuario;
        this.Identificador = Identificador;
        this.Clave = Clave;
    }
    
}
