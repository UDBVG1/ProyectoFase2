/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidad;

import Utilidades.Conexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


/**
 *
 * @author admin
 */
public class Material {
    public String titulo,autor,codigo,catalogacion, tipo;
    public int CantTotal,CantPrestada,CantDisp, tiempo;
    private final String SQL_SELECTID = "select COALESCE(concat(upper(?),(lpad(substr(max(codigo),4,7)+1,5,'0'))),concat(upper(?),'00001')) as idcodigo from material where codigo like upper(?);";

    public Material(String codigo, String titulo, String autor, int CantDisp){
        this.codigo = codigo;
        this.titulo = titulo;
        this.CantDisp = CantDisp;
        this.autor = autor;
    }
    
    public int getTiempo(){
        return tiempo;
    }
    public void setTiempo(int Tiempo){
        this.tiempo=Tiempo;
    }

    public String getTipo(){
        return tipo;
    }
    public void setTipo(String tipo){
        this.tipo=tipo;
    }
    public String getcatalogacion(){
        return catalogacion;
    }
    public void setCatalogacion(String catalogacion){
        this.catalogacion=catalogacion;
    }
    public String getCodigo(){
        return codigo;
    }
    public void setCodigo(String code){
        this.codigo=code;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getCantTotal() {
        return CantTotal;
    }

    public void setCantTotal(int CantTotal) {
        this.CantTotal = CantTotal;
    }

    public int getCantPrestada() {
        return CantPrestada;
    }

    public void setCantPrestada(int CantPrestada) {
        this.CantPrestada = CantPrestada;
    }

    public int getCantDisp() {
        return CantDisp;
    }

    public void setCantDisp(int CantDisp) {
        this.CantDisp = CantDisp;
    }
    
    public String IDinterno(Object tipo){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String IDinterno="";
        try{
                conn = Conexion.getConexion();
                stmt = conn.prepareStatement(SQL_SELECTID);
                int index = 1;
                stmt.setObject(index++, tipo);
                stmt.setObject(index++, tipo);
                stmt.setObject(index, tipo+"%");
                rs = stmt.executeQuery();
                while(rs.next()){
                IDinterno = (String) rs.getObject(1);
                }
        }catch (SQLException e) {
                System.out.println("error mysql: " + e);
        }catch(Exception e2) {
                System.out.println("error: " + e2);
        }finally {
            Conexion.closeConnection(conn);
            Conexion.closeStatement(stmt);
            Conexion.closeResulset(rs);
        }
        
        return IDinterno;
        
        }
    
}
