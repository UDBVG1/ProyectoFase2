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
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author amgoo
 */
public class UsuariosCRUD {
    //SELECTS
    private final String sqlUsuarioAcceso = "SELECT idusuario,nombre,usuario,password,nivel FROM usuario where usuario=? and password=?;";
    private final String sqlUsuarios = "SELECT idusuario as ID,nombre as NOMBRE,usuario as USUARIO, nivel AS NIVEL, (select descripcion from config where estado='nivel usuario' and valor=nivel) as NIVEL_USUARIO, identificacion as IDENTIFICACION FROM usuario where nivel>=?;";
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
    public DefaultTableModel usuariosLista(int nivel){
        DefaultTableModel dtm = new DefaultTableModel();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConexion();
            stmt = conn.prepareStatement(sqlUsuarios);
            stmt.setInt(1, nivel);
            rs = stmt.executeQuery();
            ResultSetMetaData meta = rs.getMetaData();
            int numberOfColumns = meta.getColumnCount();
            for (int i = 1; i<= numberOfColumns; i++) {
                dtm.addColumn(meta.getColumnLabel(i));
            }
            while (rs.next()) {
                    
                    Object[] fila = new Object[numberOfColumns];
                    for (int i = 0; i<numberOfColumns; i++) {
                    fila[i]=rs.getObject(i+1);
                    }
                    dtm.addRow(fila);
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
            if(usuario.Nombre!=null){
                setCambios="nombre = '"+usuario.Nombre+"'";
            }
            if(usuario.Identificador!=null && usuario.Nombre!=null){
                setCambios=setCambios+", identificacion = '"+usuario.Identificador+"'";
            }else if(usuario.Identificador!=null){
                setCambios="identificacion = '"+usuario.Identificador+"'";
            }
            if(usuario.Clave!=null && (usuario.Identificador!=null || usuario.Nombre!=null)){
                setCambios=setCambios+", password = '"+usuario.Clave+"'";
            }else if(usuario.Clave!=null){
                setCambios="password = '"+usuario.Clave+"'";
            }
            if(usuario.Nivel!=0 && (usuario.Identificador!=null || usuario.Nombre!=null|| usuario.Clave!=null)){
                setCambios=setCambios+", nivel = '"+usuario.Nivel+"'";
            }else if(usuario.Nivel!=0){
                setCambios="nivel = '"+usuario.Nivel+"'";
            }
            conn = Conexion.getConexion();
            System.out.println(sqlUsuarioUpdate+setCambios+sqlUsuarioParam);
            stmt = conn.prepareStatement(sqlUsuarioUpdate+setCambios+sqlUsuarioParam);
            int index=1;
            stmt.setInt(index, usuario.IdUs);
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
            stmt.setString(index++, usuario.Nombre);
            stmt.setString(index++, usuario.Identificador);
            stmt.setString(index++, usuario.Usuario);
            stmt.setString(index++, usuario.Clave);
            stmt.setInt(index, usuario.Nivel);
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
