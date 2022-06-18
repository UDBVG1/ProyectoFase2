/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import Entidad.Audiovisual;
import Entidad.CD;
import Entidad.Escrito;
import Entidad.Material;
import Entidad.Revista;
import Utilidades.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author admin
 */
public class PrestamosCRUD {  
        public String SQL_todo="SELECT codigo as Codigo,case when idescrito is not null then titulo\n" +
                            "when idaudiovisual is not null then titulo\n" +
                            "else null end AS Titulo, autor as Autor,cantidad_disponible as \"Cantidad Disponible\"\n" +
                            "FROM materiales_vista;";
        public String SQL_libro ="select codigo as Codigo,titulo as Titulo,autor as Autor,num_pag as 'Numero de Paginas',isbn as ISBN,publicacion as Publicacion,cantidad_disponible as 'Cantidad Disponible' from materiales_vista where codigo = ?;";
        public String SQL_revista ="select codigo,titulo,editorial,periodicidad,publicacion,cantidad_disponible from materiales_vista where codigo=?;";
        public String SQL_cd = "select codigo,titulo,genero,duracion,canciones,director,cantidad_disponible from materiales_vista where codigo =?;";
        public String SQL_dvd = "select codigo,titulo,genero,duracion,director,cantidad_disponible from materiales_vista where codigo =?;";
        private final String SQL_INSERTREV = "INSERT INTO reserva(fechareserva,estado,codigo,idusuario) values (CURDATE(),'1',?,?);";
     
        public ArrayList<Material> materiales(){
        Connection cn=null;
        ArrayList<Material> material=null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            cn=Conexion.getConexion();
            st=cn.prepareStatement(SQL_todo);
            rs = st.executeQuery();          
            material=new ArrayList<Material>();
            
            while (rs.next()) {
                Material m=new Material(rs.getString("Codigo"),rs.getString("Titulo"),
                        rs.getString("Autor"),rs.getInt("Cantidad Disponible"));               
                material.add(m);
            }
           
        } catch (Exception e ) {
            System.out.println("Problemas de conexion "+e);
        } finally {
            Conexion.closeStatement(st);
            Conexion.closeConnection(cn);
            Conexion.closeResulset(rs);
        }
        return(material);
    }
        
        public ArrayList materialIndividual(String sql, String code){
        Connection cn=null;
        ArrayList material=null;
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            cn=Conexion.getConexion();
            st=cn.prepareStatement(sql);
            int index = 1;
            st.setString(index,code);
            rs = st.executeQuery();
            ResultSetMetaData meta = rs.getMetaData();
            int numberOfColumns = meta.getColumnCount();
              
            material=new ArrayList();
            while (rs.next()) {
              for (int i = 0; i<numberOfColumns; i++) {
                  material.add(rs.getObject(i+1));
                }
            }                                 
          
        } catch (Exception e ) {
            System.out.println("Problemas de conexion "+e);
        } finally {
            Conexion.closeStatement(st);
            Conexion.closeConnection(cn);
            Conexion.closeResulset(rs);
        }
        return(material);
    }
    
    public int insertarReserva(Object codigo,int idsocio){
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        int resp = JOptionPane.showConfirmDialog(null, "Desea continuar con la reserva?");
        try {
        if(resp==0){
            conn = Conexion.getConexion();
            stmt = conn.prepareStatement(SQL_INSERTREV);
            int index = 1;
            stmt.setObject(index++,codigo);
            stmt.setInt(index,idsocio);
            rows = stmt.executeUpdate();
            }
        else{
            System.out.println("Cancelado");
        }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e2) {
            System.out.println("error Reserva sistema: "+e2);
        }finally {
            Conexion.closeStatement(stmt);
            Conexion.closeConnection(conn);
        }
        return resp;
    }    
}
