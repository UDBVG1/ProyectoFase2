/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import Entidad.*;
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
        public String SQL_prestar="call validarPrestamos(?,?,?);";
        public String SQL_reservas = "SELECT r.idreserva as ID,	m.codigo as Codigo,case when m.idescrito is not null then l.titulo\n" +
                                    "when m.idaudiovisual is not null then mc.titulo\n" +
                                    "else null end AS titulo,autor,(SELECT c.descripcion FROM poo.config c where c.estado='estado reserva' and valor=r.estado) as estado,u.usuario\n" +
                                    "FROM material m\n" +
                                    "LEFT join escrito l on m.idescrito=l.idescrito\n" +
                                    "LEFT join audiovisual mc on m.idaudiovisual=mc.idaudiovisual\n" +
                                    "LEFT join reserva r on m.codigo = r.codigo\n" +
                                    "LEFT join usuario u on u.idusuario = r.idusuario\n" +
                                    "where r.estado not in (2);";
        public String SQL_devolucion = "call devolucion(?,?);";
         public String SQL_SELECTPRESX = "SELECT p.codigo,case when m.idescrito is not null then l.titulo\n" +
                                        "when m.idaudiovisual is not null then mc.titulo\n" +
                                        "else null end AS titulo,CONVERT(p.fechaprestamo, CHAR)as Fecha_Prestamo,CONVERT(p.fechaentrega, CHAR)as Fecha_Entrega,p.mora\n" +
                                        "FROM material m\n" +
                                        "LEFT join escrito l on m.idescrito=l.idescrito\n" +
                                        "LEFT join audiovisual mc on m.idaudiovisual=mc.idaudiovisual\n" +
                                        "LEFT join prestamos p on m.codigo = p.codigo\n";
         
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
        
       public ArrayList<Reserva> reservas(){
        Connection cn=null;
        ArrayList<Reserva> reservas=null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            cn=Conexion.getConexion();
            st=cn.prepareStatement(SQL_reservas);
            rs = st.executeQuery();
            reservas=new ArrayList<Reserva>();
            while (rs.next()) {
                Reserva r2=new Reserva(rs.getString("Codigo"),rs.getString("Titulo"),
                        rs.getString("Autor"),rs.getString("estado"),rs.getString("usuario"),rs.getInt("ID"));               
                reservas.add(r2);
            }
           
        } catch (Exception e ) {
            System.out.println("Problemas de conexion "+e);
        } finally {
            Conexion.closeStatement(st);
            Conexion.closeConnection(cn);
            Conexion.closeResulset(rs);
        }
        return(reservas);
    }  
       
    public ArrayList<Prestamo> prestamoU(int usuario){
        Connection cn=null;
        ArrayList<Prestamo> prestamo=null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            cn=Conexion.getConexion();
            st=cn.prepareStatement(SQL_SELECTPRESX + "where p.idsocio = ?;");
            st.setInt(1,usuario);
            rs = st.executeQuery();          
            prestamo=new ArrayList<Prestamo>();
            while (rs.next()) {
                Prestamo p=new Prestamo(rs.getString("codigo"),rs.getString("titulo"),
                        rs.getString("Fecha_Prestamo"),rs.getString("Fecha_Entrega"),rs.getInt("mora"));
                prestamo.add(p);
            }
            
           
        } catch (Exception e ) {
            System.out.println("Problemas de conexion "+e);
        } finally {
            Conexion.closeStatement(st);
            Conexion.closeConnection(cn);
            Conexion.closeResulset(rs);
        }
        return(prestamo);
    }
    public ArrayList labels(String sql){
        Connection cn=null;
        ArrayList labels=null;
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            cn=Conexion.getConexion();
            st=cn.prepareStatement(sql);
            rs = st.executeQuery();
            ResultSetMetaData meta = rs.getMetaData();
            int numberOfColumns = meta.getColumnCount();
 
            labels=new ArrayList();
              for (int i = 1; i<=numberOfColumns; i++) {
                  labels.add(meta.getColumnLabel(i));
                }
                                 
          
        } catch (Exception e ) {
            System.out.println("Problemas de conexion "+e);
        } finally {
            Conexion.closeStatement(st);
            Conexion.closeConnection(cn);
            Conexion.closeResulset(rs);
        }
        return(labels);
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
    
        public int insertarPrestamo(int idsocio,Object codigo, Object idreserva){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String resultado = "";
        int resp = JOptionPane.showConfirmDialog(null, "Desea continuar con el Prestamo?");
        try {
        if(resp==0){
            conn = Conexion.getConexion();
            stmt = conn.prepareStatement(SQL_prestar);
            int index = 1;
            stmt.setInt(index++,idsocio);
            stmt.setObject(index++,codigo);            
            stmt.setObject(index,idreserva);
            rs = stmt.executeQuery();
            while (rs.next()) {
                    resultado=(String) rs.getObject(1);
            }
            if(!resultado.equals("Prestamo realizado exitosamente")){
            JOptionPane.showMessageDialog(null, "Prestamo Cancelado", "Contactanos en caso de ser necesario!", JOptionPane.INFORMATION_MESSAGE);         
            }
        }    
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e2) {
            System.out.println("error prestamos sistema: "+e2);
        }finally {
            Conexion.closeStatement(stmt);
            Conexion.closeConnection(conn);
            Conexion.closeResulset(rs);            
        }
            return resp;
    }
        
        public int devolucion(int idsocio,Object codigo, Object idreserva){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String resultado = "";
        int resp = JOptionPane.showConfirmDialog(null, "Desea continuar con la devolucion?");
        try {
        if(resp==0){
            conn = Conexion.getConexion();
            stmt = conn.prepareStatement(SQL_devolucion);
            int index = 1;
//no necesario el usuario ya que usamos directamente el id resserva jeje
            stmt.setObject(index++,codigo);            
            stmt.setObject(index,idreserva);
            rs = stmt.executeQuery();
        }    
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e2) {
            System.out.println("error prestamos sistema: "+e2);
        }finally {
            Conexion.closeStatement(stmt);
            Conexion.closeConnection(conn);
            Conexion.closeResulset(rs);            
        }
            return resp;
    }
}
