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
    public int IdUs,Nivel;
    public String Nombre,Usuario,Identificador,Clave;
    
    public int getIdUs(){
        return IdUs;
    }
    public void setIdUs(int IdUs){
        this.IdUs=IdUs;
    }
    
    public String getNombre(){
        return Nombre;
    }
    public void setNombre(String Nombre){
        this.Nombre=Nombre;
    }
    
    public String getIdentificador(){
        return Identificador;
    }
    public void setIdentificador(String Identificador){
        this.Identificador=Identificador;
    }
    
    public String getUsuario(){
        return Usuario;
    }
    public void setUsuario(String Usuario){
        this.Usuario=Usuario;
    }
    
    public String getClave(){
        return Clave;
    }
    public void setClave(String Clave){
        this.Clave=Clave;
    }
    
    public int getNivel(){
        return Nivel;
    }
    public void setNivel(int Nivel){
        this.Nivel=Nivel;
    }
    
    @Override
    public String toString() {
        return "Usuario{" + "idUs= " + IdUs + ", nombre= " + Nombre + ", usuario= " + Usuario + ", identificador= " + Identificador + ", password= " + Clave + ", nivel= " + Nivel + '}';
    }
}
