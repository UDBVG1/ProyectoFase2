/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;
import Utilidades.Conexion;
import Entidad.*;
import Utilidades.ParametrosGlobales;
import static java.lang.Math.floor;
import java.util.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author Eveling Santos
 */
public class MaterialBD {
    
   
    
public  boolean insertarEscritoLibro(Escrito Datos){
        int rows = 0;
        int id=0;
        Connection conn = null;
        PreparedStatement stmt = null;
        PreparedStatement stmt2= null;
        boolean agregado=false;
        try {
            conn = Conexion.getConexion();
            Statement st;
            st=conn.createStatement();
            //Ingresando en escrito
            st.executeUpdate("INSERT INTO `escrito` (`titulo`, `tipo`, `autor`, `num_pag`, `editorial`,`isbn`,`publicacion`) values( '"
                    + Datos.getTitulo()+ "','"
                    + Datos.getTipo() + "','"
                    +Datos.getAutor() + "','"
                    + Datos.getNumPaginas() + "','"
                    +Datos.getEditorial() + "','"
                    +Datos.getISBN() + "','"
                    + Datos.getFechaPubli() + "')");
           
                   agregado=true;
                   st.close();
                   
         } catch (SQLException e) {
             agregado=false;
        } finally {
            Conexion.closeStatement(stmt);
            Conexion.closeConnection(conn);
            return agregado;
        }
}
}
 
