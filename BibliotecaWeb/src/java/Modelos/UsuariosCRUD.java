/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;
import Utilidades.Conexion;
import Entidad.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author amgoo
 */
public class UsuariosCRUD extends Conexion{
    //SELECTS
    private final String sqlUsuarioAcceso = "SELECT idusuario,nombre,usuario,password,nivel FROM usuario where usuario=? and password=?;";
    private final String sqlUsuarios = "SELECT idusuario as ID,nombre as NOMBRE,usuario as USUARIO, nivel AS NIVEL, identificacion as IDENTIFICACION FROM usuario where nivel>=?;";
    private final String sqlComboNivel="SELECT descripcion from config where estado='nivel usuario';";
    private final String sqlUsuario="SELECT idusuario,nombre,usuario,password,nivel FROM usuario where idusuario=?;";
    private final String sqlUsuarioGenerate="select coalesce(concat(upper(?),substr(year(curdate()),3,4),(lpad(substr(max(usuario),3,6)+1,4,'0'))),concat(upper(?),substr(year(curdate()),3,4),'0001')) AS U_generado from usuario where usuario like upper(?);";
    //UPDATES
    private final String sqlUsuarioUpdate="UPDATE usuario SET ";
    private final String sqlUsuarioParam=" WHERE (idusuario = ?);";
    //INSERTS
    private final String sqlUsuarioInsert="INSERT INTO usuario (nombre, identificacion, usuario, password, nivel) VALUES (?,?,?,?,?);";
    //DELETES
    private final String sqlDeleteUsuario="DELETE FROM usuario WHERE idusuario=?;";
    //VARIABLES
    private String mensaje;

    public Usuario usuarioAcceso(String Usuario, String Password){
        Connection conn =null;
        PreparedStatement stmt =null;
        ResultSet rs=null;
        Usuario obUsuario = new Usuario();
        try{
            conn = Conexion.getConexion();
            stmt = conn.prepareStatement(sqlUsuarioAcceso);
            int index=1;
            stmt.setString(index++, Usuario);
            stmt.setString(index, Password);
            rs = stmt.executeQuery();
            while (rs.next()) {
                obUsuario.setIdUs(Integer.parseInt(rs.getObject(1).toString()));
                obUsuario.setNombre(rs.getObject(2).toString());
                obUsuario.setUsuario(rs.getObject(3).toString());
                obUsuario.setClave(rs.getObject(4).toString());
                obUsuario.setNivel(Integer.parseInt(rs.getObject(5).toString()));
            }
        }catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al Intentar Ingresar", "Error", JOptionPane.INFORMATION_MESSAGE); 
        } finally {
            Conexion.closeConnection(conn);
            Conexion.closeStatement(stmt);
            Conexion.closeResulset(rs);
        }
        return obUsuario;
    }
    public List<Usuario> usuariosLista(int nivel){
        List<Usuario> dtm= null;
        Usuario us;
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConexion();
            stmt = conn.prepareStatement(sqlUsuarios);
            stmt.setInt(1, nivel);
            rs = stmt.executeQuery();
            dtm=new ArrayList<>();                
            while (rs.next()) {
                us = new Usuario(rs.getInt("ID"), rs.getInt("NIVEL"), rs.getString("NOMBRE"), rs.getString("USUARIO"), rs.getString("IDENTIFICACION"), null); 
                dtm.add(us);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexion.closeStatement(stmt);
            Conexion.closeConnection(conn);
            Conexion.closeResulset(rs);
        }
        return dtm;
    }
    public ArrayList usuarioList(){
        ArrayList dtm=new ArrayList();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConexion();
            stmt = conn.prepareStatement(sqlComboNivel);
            rs = stmt.executeQuery();
            int num = 1;
            while (rs.next()) {
                    dtm.add(rs.getObject(num));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexion.closeStatement(stmt);
            Conexion.closeConnection(conn);
            Conexion.closeResulset(rs);
        }
        return dtm;
    }
    public Usuario usuarioData(int id){
        Usuario data = new Usuario();
        Connection conn =null;
        PreparedStatement stmt =null;
        ResultSet rs=null;
        try{
            conn = Conexion.getConexion();
            stmt = conn.prepareStatement(sqlUsuario);
            int index=1;
            stmt.setInt(index, id);
            rs = stmt.executeQuery();
            while (rs.next()) {
                data.setIdUs(Integer.parseInt(rs.getObject(1).toString()));
                data.setNombre(rs.getObject(2).toString());
                data.setUsuario(rs.getObject(3).toString());
                data.setClave(rs.getObject(4).toString());
                data.setNivel(Integer.parseInt(rs.getObject(5).toString()));
            }
        }catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al Intentar Ingresar", "Error", JOptionPane.INFORMATION_MESSAGE); 
        } finally {
            Conexion.closeConnection(conn);
            Conexion.closeStatement(stmt);
            Conexion.closeResulset(rs);
        }
        return data;
    }
    
    public String usuarioGenerate(String US){
        String UsGenerado=null;
        Connection conn =null;
        PreparedStatement stmt =null;
        ResultSet rs=null;
        try{
            conn = Conexion.getConexion();
            stmt = conn.prepareStatement(sqlUsuarioGenerate);
            int index=1;
            stmt.setString(index++, US);
            stmt.setString(index++, US);
            stmt.setString(index, US+"%");
            rs = stmt.executeQuery();
            while(rs.next()){
                UsGenerado=rs.getObject(1).toString();
            }
        }catch(SQLException e) {
            e.printStackTrace();
        } finally {
            Conexion.closeConnection(conn);
            Conexion.closeStatement(stmt);
            Conexion.closeResulset(rs);
        } 
        return UsGenerado;
    }
    
    public int updateUsuario(Usuario usuario){
        int rows=0;
        Connection conn =null;
        PreparedStatement stmt =null;
        ResultSet rs=null;
        String setCambios=null;
        System.out.println(usuario.toString());
        try{
            if(usuario.getNombre()!=null){
                setCambios="nombre = '"+usuario.getNombre()+"'";
            }
            if(usuario.getIdentificador()!=null && usuario.getNombre()!=null){
                setCambios=setCambios+", identificacion = '"+usuario.getIdentificador()+"'";
            }else if(usuario.getIdentificador()!=null){
                setCambios="identificacion = '"+usuario.getIdentificador()+"'";
            }
            if(usuario.getClave()!=null && (usuario.getIdentificador()!=null || usuario.getNombre()!=null)){
                setCambios=setCambios+", password = '"+usuario.getClave()+"'";
            }else if(usuario.getClave()!=null){
                setCambios="password = '"+usuario.getClave()+"'";
            }
            if(usuario.getNivel()!=0 && (usuario.getIdentificador()!=null || usuario.getNombre()!=null|| usuario.getClave()!=null)){
                setCambios=setCambios+", nivel = '"+usuario.getNivel()+"'";
            }else if(usuario.getNivel()!=0){
                setCambios="nivel = '"+usuario.getNivel()+"'";
            }
            conn = Conexion.getConexion();
            System.out.println(sqlUsuarioUpdate+setCambios+sqlUsuarioParam);
            stmt = conn.prepareStatement(sqlUsuarioUpdate+setCambios+sqlUsuarioParam);
            int index=1;
            stmt.setInt(index, usuario.getIdUs());
            System.out.print(stmt);
            rows = stmt.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            Conexion.closeConnection(conn);
            Conexion.closeStatement(stmt);
            Conexion.closeResulset(rs);
        }
        return rows;
    }
        
    public int insertarUsuario(Usuario usuario){
        int rows=0;
        Connection conn =null;
        PreparedStatement stmt =null;
        ResultSet rs=null;
        try{
            conn = Conexion.getConexion();
            stmt = conn.prepareStatement(sqlUsuarioInsert);
            int index=1;
            stmt.setString(index++, usuario.getNombre());
            stmt.setString(index++, usuario.getIdentificador());
            stmt.setString(index++, usuario.getUsuario());
            stmt.setString(index++, usuario.getClave());
            stmt.setInt(index, usuario.getNivel());
            System.out.print(stmt);
            rows = stmt.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            Conexion.closeConnection(conn);
            Conexion.closeStatement(stmt);
            Conexion.closeResulset(rs);
        }
        return rows;
    }
    
    public String eliminarUsuario(String id) {
        int rows;
        Connection conn =null;
        PreparedStatement stmt =null;
        try {
            conn = Conexion.getConexion();
            stmt = conn.prepareStatement(sqlDeleteUsuario);
            stmt.setInt(1,Integer.parseInt(id));
            System.out.print(stmt);
            rows = stmt.executeUpdate();
            mensaje=rows+" Usuario Eliminado";
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            Conexion.closeConnection(conn);
            Conexion.closeStatement(stmt);
        }
        return mensaje;
    }
}
