/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import Utilidades.Conexion;
import Utilidades.ParametrosGlobales;
import static java.lang.Integer.parseInt;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel; 
/**
 *
 * @author admin
 */
public class PrestamosCRUD {
     private final String SQL_SELECTMORA = "SELECT TIMESTAMPDIFF(DAY,fechaprestamo,fechaentrega)  as newfecha FROM prestamos WHERE codigo = ?;";
     
     public String SQL_SELECTlibros ="SELECT M.codigo as Codigo,E.titulo as Titulo,E.autor as Autor,E.num_pag as Paginas,E.editorial as Editorial,E.isbn as ISBN\n" +
                                        "FROM material M\n" +
                                        "INNER JOIN ESCRITO E ON M.IDESCRITO=E.IDESCRITO\n" +
                                        "WHERE TIPO='LIB';";
     
     public String SQL_SELECTrevista = "select codigo as Codigo,r.titulo as Titulo,r.editorial as Editorial,r.periodicidad as Periodicidad,r.publicacion as Publicidad\n" +
                                        "FROM material M\n" +
                                        "INNER JOIN ESCRITO r ON M.IDESCRITO=r.IDESCRITO\n" +
                                        "WHERE r.TIPO='REV';";
             
     public String SQL_SELECTcd="select codigo as Codigo,cd.titulo as Titulo,cd.artista as Artista,cd.genero as Genero,cd.duracion as Duracion,cd.canciones as \"Numero de Canciones\"\n" +
                                "FROM material M\n" +
                                "INNER JOIN audiovisual cd ON M.idaudiovisual=cd.idaudiovisual\n" +
                                "WHERE cd.TIPO='CDA';";
             
     public String SQL_SELECTdvd="select codigo as Codigo,dvd.titulo as Titulo,dvd.director as Director,dvd.duracion as Duracion,dvd.genero as Genero\n" +
                                "FROM material M\n" +
                                "INNER JOIN audiovisual dvd ON M.idaudiovisual=dvd.idaudiovisual\n" +
                                "WHERE dvd.TIPO='DVD';";
     
     public String SQL_SELECTall="SELECT codigo as Codigo,case when m.idescrito is not null then l.titulo\n" +
                                "when m.idaudiovisual is not null then r.titulo\n" +
                                "else null end AS titulo, cantidad_disponible\n" +
                                "FROM material m\n" +
                                "LEFT join escrito l on m.idescrito=l.idescrito\n" +
                                "LEFT join audiovisual r on m.idaudiovisual=r.idaudiovisual;";
     
     public String SQL_BUSCARL ="SELECT codigo as Codigo,titulo as Titulo,autor as Autor,num_pag as \"Numero de paginar\",editorial as Editorial,isbn as ISBN from escrito l \n" +
                                "right join material m on l.idescrito = m.idescrito\n" +
                                "where l.tipo='LIB'\n"+
                                "AND titulo like ? or autor like ? or editorial like ? or isbn like ? ;";
     public String SQL_BUSCARR ="SELECT codigo as Codigo,titulo as Titulo,editorial as Editorial,periodicidad as Periodicidad,CONVERT(publicacion, CHAR) as \"Año publicacion\" from escrito r\n" +
                                "right join material m on r.idescrito = m.idescrito\n" +
                                "where tipo='REV' and titulo like ? or editorial like ? or periodicidad like ? or publicacion like ? ;";
     public String SQL_BUSCARC ="SELECT codigo as Codigo,titulo as Titulo,artista as Artista,genero as Genero,duracion as Duracion, canciones as Canciones from audiovisual cd\n" +
                                "right join material m on cd.idaudiovisual = m.idaudiovisual\n" +
                                "where tipo='CDA' and titulo like ? or artista like ? or genero like ? or duracion like ?;";
     public String SQL_BUSCARD ="SELECT codigo as Codigo,titulo as Titulo,director as Director,duracion as Duracion,genero as Genero from audiovisual d\n" +
                                "right join material m on d.idaudiovisual = m.idaudiovisual\n" +
                                "where tipo='DVD' AND titulo like ? or director like ? or genero like ? or duracion like ?;";
     
     private final String SQL_INSERTREV = "INSERT INTO reserva(fechareserva,estado,reservado,codigo,idusuario) values (CURDATE(),'1',?,?,?);";
     
     private final String SQL_INSERTPRE ="insert into prestamos(fechaprestamo,fechaentrega,codigo,idsocio) values (curdate(),?,?,?);";
     
     private final String SQL_UPDATEPD = "update material set cantidad_disponible = (cantidad_disponible + ?) where codigo = ?;";
    
     public String SQL_SELECTREVSALL = "SELECT 	m.codigo as Codigo,case when m.idescrito is not null then l.titulo\n" +
"                                        when m.idaudiovisual is not null then mc.titulo\n" +
"                                        else null end AS titulo,autor,(SELECT c.descripcion FROM poo.config c where c.estado='estado reserva' and valor=r.estado) as estado,u.usuario\n" +
"                                        FROM material m\n" +
"                                        LEFT join escrito l on m.idescrito=l.idescrito\n" +
"                                        LEFT join audiovisual mc on m.idaudiovisual=mc.idaudiovisual\n" +
"                                        LEFT join reserva r on m.codigo = r.codigo\n" +
"                                        LEFT join usuario u on u.idusuario = r.idusuario\n" +
"                                        where r.idusuario != 0 and r.estado not in (2);";
                                        
     
     public String SQL_SELECTPRESX = "SELECT 	m.codigo as Codigo,case when m.idescrito is not null then l.titulo\n" +
                                    "when m.idaudiovisual is not null then mc.titulo\n" +
                                    "else null end AS titulo,autor,(SELECT c.descripcion FROM poo.config c where c.estado='estado reserva' and valor=r.estado) as estado,u.usuario\n" +
                                    "FROM material m\n" +
                                    "LEFT join escrito l on m.idescrito=l.idescrito\n" +
                                    "LEFT join audiovisual mc on m.idaudiovisual=mc.idaudiovisual\n" +
                                    "LEFT join reserva r on m.codigo = r.codigo\n" +
                                    "LEFT join usuario u on u.idusuario = r.idusuario\n" +
                                    "where r.idusuario = ? and r.estado not in (2);";
     
     
     public String SQL_SelectFiltrado = "select codigo, cantidad_disponible from material where codigo = ?;";
     
     private String SQL_getIdUsuario = "select idusuario from usuario where usuario = ?;";
     
     private String SQL_Estado = "update reserva set estado = ? where idusuario = ? and codigo = ?;";
     
     public String FechaEntrega(){//agregando 5 dias mas
        LocalDateTime hoy = LocalDateTime.now();
        LocalDateTime hoyCorto = hoy.plusDays(5);//SQLCANTIDADAPRESTAR MATERIALES
        //LocalDateTime hoyCorto = hoy.minusDays(5);//5 dias menos
        String fechaEntrega = hoyCorto.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        return fechaEntrega;
        }
    
    public DefaultTableModel mostrar(String select){
        DefaultTableModel dtm = new DefaultTableModel();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConexion();
            stmt = conn.prepareStatement(select);
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
            //logger.error("ERROR en la conexion bd", e);
        } finally {
            Conexion.closeStatement(stmt);
            Conexion.closeConnection(conn);
            Conexion.closeResulset(rs);
        }
        return dtm;
    }
    
    public DefaultTableModel Filtrar(String select,String box1,String box2,String box3,String box4){
        DefaultTableModel dtm = new DefaultTableModel();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
       
        try {
            conn = Conexion.getConexion();
            stmt = conn.prepareStatement(select);
            int index = 1;
            stmt.setString(index++,box1);
            stmt.setString(index++,box2);
            stmt.setString(index++,box3);
            stmt.setString(index,box4);
            
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
     
    public void insertarReserva(Object codigo,int idsocio,int reservado){
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConexion();
            stmt = conn.prepareStatement(SQL_INSERTREV);
            int index = 1;
            stmt.setInt(index++,reservado);
            stmt.setObject(index++,codigo);
            stmt.setInt(index,idsocio);
            rows = stmt.executeUpdate();
        if (rows > 0) {
                JOptionPane.showMessageDialog(null, "Registro exitoso" + "/n" + "Registros afectados" + rows, "Ingresado", JOptionPane.INFORMATION_MESSAGE);
            }    
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e2) {
            System.out.println("error mora sistema: "+e2);
        }finally {
            Conexion.closeStatement(stmt);
            Conexion.closeConnection(conn);
        }
    }
    
    public void updateMaterial(int Indicador,Object codigo){
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConexion();
            stmt = conn.prepareStatement(SQL_UPDATEPD);
            int index = 1;
            stmt.setInt(index++,Indicador);
            stmt.setObject(index++,codigo);
            
            rows = stmt.executeUpdate();    
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e2) {
            System.out.println("error mora sistema: "+e2);
        }finally {
            Conexion.closeStatement(stmt);
            Conexion.closeConnection(conn);
        }
    }
    
    public DefaultTableModel mostrarPrestamoUsuario(int nivel,String SQL_SELECT){
        DefaultTableModel dtm = new DefaultTableModel();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;      
        try{
            conn = Conexion.getConexion();
            stmt = conn.prepareStatement(SQL_SELECT);
            int index = 1;
            stmt.setInt(index++,nivel);
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
    
    public DefaultTableModel mostrarRev(){
        DefaultTableModel dtm = new DefaultTableModel();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;      
        try{
            conn = Conexion.getConexion();
            stmt = conn.prepareStatement(SQL_SELECTREVSALL);
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
    
    public void insertarPrestamo(Object codigo,int idsocio){
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        int prestado;
        try {
            conn = Conexion.getConexion();
            stmt = conn.prepareStatement(SQL_INSERTPRE);
            int index = 1;
            stmt.setObject(index++,FechaEntrega());
//            String msg = JOptionPane.showInputDialog(null, "Introduce cuantos desea reservar");
//            prestado = parseInt(msg);
//            stmt.setInt(index++,prestado);
            stmt.setObject(index++,codigo);
            stmt.setInt(index,idsocio);
            rows = stmt.executeUpdate();
        if (rows > 0) {
                JOptionPane.showMessageDialog(null, "Registro exitoso" + "/n" + "Registros afectados" + rows, "Ingresado", JOptionPane.INFORMATION_MESSAGE);
            }    
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e2) {
            System.out.println("error prestamos sistema: "+e2);
        }finally {
            Conexion.closeStatement(stmt);
            Conexion.closeConnection(conn);
        }
    }
    
    public int GetUsuario(String userName){
        Connection conn =null;
        PreparedStatement stmt =null;
        ResultSet rs=null;
        int idsocio = 0;
        try{
            conn = Conexion.getConexion();
            stmt = conn.prepareStatement(SQL_getIdUsuario);
            int index=1;
            stmt.setString(index++, userName);

            rs = stmt.executeQuery();
            while (rs.next()) {
                 idsocio = (int) rs.getObject(1); 
            }
        }catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al Intentar Ingresar", "Error", JOptionPane.INFORMATION_MESSAGE); 
        } finally {
            Conexion.closeConnection(conn);
            Conexion.closeStatement(stmt);
            Conexion.closeResulset(rs);
        }
        return idsocio;        
    }
    
    public int Updateestado(String estado,int usuario , Object codigo){
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConexion();
            stmt = conn.prepareStatement(SQL_Estado);
            int index = 1;
            stmt.setString(index++,estado);
            stmt.setInt(index++,usuario);
            stmt.setObject(index,codigo);
            
            rows = stmt.executeUpdate();
        if (rows == 0) {
              System.out.println("error devolucion");  
        }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e2) {
            System.out.println("error devolucion sistema: "+e2);
        }finally {
            Conexion.closeStatement(stmt);
            Conexion.closeConnection(conn);
        }   
       return rows; 
    }
    
        public DefaultTableModel FiltrarSeleccion(String select,Object box1){
        DefaultTableModel dtm = new DefaultTableModel();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
       
        try {
            conn = Conexion.getConexion();
            stmt = conn.prepareStatement(select);
            int index = 1;
            stmt.setObject(index,box1);
            
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
}
