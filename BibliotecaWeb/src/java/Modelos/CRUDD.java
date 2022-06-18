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
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Eveling Santos
 */
public class CRUDD {
    private String SQL_MATERIAL="INSERT INTO `material` (`codigo`, `catalogacion`, `cantidad_total`, `cantidad_disponible`, `tiempo`, `idescrito`)\n" +
                                       "VALUES (?, ?,?,?,?,?);";
    private String INSERT_LIBRO="INSERT INTO `escrito` (`titulo`, `tipo`, `autor`, `num_pag`, `editorial`,`isbn`,`publicacion`) values(?,?,?,?,?,?,?);";
//Función que ejecuta sentencia para listar miembros de una base de datos.
    
    public List<List<String>> material_lista(String SQL, int tipo,ArrayList datos) {
        
        int index;

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<List<String>> ListaMaterial= new ArrayList();
        List<String> MiMaterial = new ArrayList();
        
        try {
            conn = Conexion.getConexion();
            stmt = conn.prepareStatement(SQL); 
            if (tipo!=0){
            switch(tipo){
                case 1:
                    index=1;
                    stmt.setString(index,String.valueOf(datos.get(0))) ;
                    break;
                case 2:
                    index=1;
                    //stmt.setString(index,String.valueOf(datos.get(0)));
                    for (int i=0;i<datos.size();i++){
                    
                    stmt.setString(index++,String.valueOf(datos.get(i)));
                    
                    }
                    
                    break;
                default:
                                      
            }}
            rs = stmt.executeQuery();
            
            
            while (rs.next()) {
                    MiMaterial= new ArrayList();
                    MiMaterial.add(rs.getString("codigo"));
                    MiMaterial.add(rs.getString("titulo"));
                    MiMaterial.add(rs.getString("catalogacion"));
                    MiMaterial.add(rs.getString("cantidad_disponible"));
                    MiMaterial.add(rs.getString("cantidad_total"));
                    ListaMaterial.add(MiMaterial);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexion.closeStatement(stmt);
            Conexion.closeConnection(conn);
            Conexion.closeResulset(rs);
        }
        return ListaMaterial;
    }    
    /*
    public List<List<String>> Listar(String SQL, int Tipo){
        

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<List<String>> ListaMaterial= new ArrayList();
        List<String> MiMaterial = new ArrayList();
        
        ListaMaterial.clear();
        MiMaterial.clear();
       
        try {
            conn = Conexion.getConexion();
            stmt = conn.prepareStatement(SQL);          
            rs = stmt.executeQuery();

            while (rs.next()) {
                    MiMaterial= new ArrayList();
                    MiMaterial.add(rs.getString("codigo"));
                    MiMaterial.add(rs.getString("titulo"));
                    MiMaterial.add(rs.getString("catalogacion"));
                    MiMaterial.add(rs.getString("cantidad_disponible"));
                    MiMaterial.add(rs.getString("cantidad_total"));
                    switch (Tipo){
                        case 1:
                            break;
                        case 2:
                        default:
                            
                    }
                    ListaMaterial.add(MiMaterial);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexion.closeStatement(stmt);
            Conexion.closeConnection(conn);
            Conexion.closeResulset(rs);
        }
        return ListaMaterial;
    }    
    */
    
    public void insertarEscritoLibro(Escrito Datos){
        int rows = 0;
        int id=0;
        Connection conn = null;
        PreparedStatement stmt = null;
        PreparedStatement stmt2= null;
        try {
            conn = Conexion.getConexion();
            //Ingresando en escrito
            stmt = conn.prepareStatement(INSERT_LIBRO,Statement.RETURN_GENERATED_KEYS);
            int index = 1;
                stmt.setString(index++,Datos.getTitulo());
                stmt.setString(index++,Datos.getTipo());
                stmt.setString(index++,Datos.getAutor());
                stmt.setInt(index++,Datos.getNumPaginas());
                stmt.setString(index++, Datos.getcatalogacion());
                stmt.setString(index++,Datos.getEditorial());
                stmt.setInt(index++, Datos.getISBN());
                stmt.setInt(index++,Datos.getFechaPubli());
            rows = stmt.executeUpdate();
                   
            if (rows > 0) {
               System.out.println("Registro Exitoso"); 
            }
            ResultSet getidescrito = stmt.getGeneratedKeys();
            if(getidescrito.next()){ 
                    id = getidescrito.getInt(1);
                }
            index=1;
                stmt2.setString(index, "LIB64654");
                stmt2.setString(index++,Datos.getcatalogacion());
                stmt2.setInt(index++, Datos.getCantTotal());
                stmt2.setInt(index++,Datos.getCantDisp());
                stmt2.setInt(index++,Datos.getTiempo());
                stmt2.setInt(index++, id);
            rows = stmt.executeUpdate();
            if (rows > 0) {
               System.out.println("Registro Exitoso"); 
            }
         } catch (SQLException e) {
            System.out.println("Error al guardar datos");
        } finally {
            Conexion.closeStatement(stmt);
            Conexion.closeConnection(conn);
        }
        
    }
    
    
    public void insertarDatos(String SQL,String SQL2,ArrayList<String> Informacion,ArrayList<String> Informacion2,String codigo, int i, int j,int a, int b, int c) {
        int rows = 0;
        int id=0;

        Connection conn = null;
        PreparedStatement stmt = null;
        PreparedStatement stmt2= null;
        
        int x;
        try {
            conn = Conexion.getConexion();
            //Ingresando en escrito
            stmt = conn.prepareStatement(SQL,Statement.RETURN_GENERATED_KEYS);
            int index = 1;

            for (x=0; x<i;x++){
                    if(x==a || x==b || x==c){
                    stmt.setInt(index++, Integer.parseInt(Informacion.get(x)));                        
                    }
                    else{
                    stmt.setString(index++, Informacion.get(x));
                    }
            }
            rows = stmt.executeUpdate();
            System.out.println(SQL);        
            if (rows > 0) {
               System.out.println("Registro Exitoso"); 
            }
            if(ParametrosGlobales.mat_table=true){
            ResultSet getidescrito = stmt.getGeneratedKeys();            
                if(getidescrito.next()){ 
                    id = getidescrito.getInt(1);
                }
            }
            
            if(ParametrosGlobales.mat_table=false){
            ResultSet getidaudiovisual = stmt.getGeneratedKeys();          
            if(getidaudiovisual.next()){ 
                id = getidaudiovisual.getInt(1);
            }   
            }
            //Ingresando en materiales
            
            stmt2 = conn.prepareStatement(SQL2);
            index = 1;
            rows=0;
            
            stmt2.setString(index++, codigo);
            stmt2.setString(index++, Informacion2.get(0));
                for (x=1; x<j;x++){
                    stmt2.setInt(index++,Integer.parseInt(Informacion2.get(x)));
                }
            stmt2.setInt(index, id);
            rows = stmt2.executeUpdate();
            
            if (rows > 0) {
                System.out.println("Registro exitoso de material" + "/n" + "Registros afectados" + rows);
            }
            else{
            System.out.println("Registro NO exitoso del material!!");
            }
            
        } catch (SQLException e) {
            System.out.println("Error al guardar datos");
        } finally {
            Conexion.closeStatement(stmt);
            Conexion.closeConnection(conn);
        }
    }
    
     /*   public void insertarDatos2(String SQL,String SQL2,Audiovisual Entidad,String codigo) {
        int rows = 0;
        int idEscrito=0;

        Connection conn = null;
        PreparedStatement stmt = null;
        PreparedStatement stmt2= null;
        try {
            conn = Conexion.getConexion();
            //Ingresando en escrito
            stmt = conn.prepareStatement(SQL,Statement.RETURN_GENERATED_KEYS);
            int index = 1;
            System.out.println(Entidad.toString());
            stmt.setString(index++, Entidad.titulo);
            stmt.setString(index++, "LIB");
            stmt.setString(index++, Entidad.autor);
            stmt.setInt(index++, Entidad.numCanciones);

          
            rows = stmt.executeUpdate();
            System.out.println(SQL);        
            if (rows > 0) {
                JOptionPane.showMessageDialog(null, "Registro exitoso" + "/n" + "Registros afectados" + rows, "Ingresado", JOptionPane.INFORMATION_MESSAGE);
            }
            ResultSet getidescrito = stmt.getGeneratedKeys();
            
            if(getidescrito.next()){ 
                idEscrito = getidescrito.getInt(1);
            }
            
            //Ingresando en materiales
            stmt2 = conn.prepareStatement(SQL2);
            index = 1;
            rows=0;
            stmt2.setString(index++, codigo);
            stmt2.setString(index++,Entidad.catalogacion);
            stmt2.setInt(index++,Entidad.CantTotal);
            stmt2.setInt(index++,Entidad.CantDisp);
            stmt2.setInt(index++,Entidad.tiempo);
            stmt2.setInt(index, idEscrito);
            rows = stmt2.executeUpdate();
            
            if (rows > 0) {
                System.out.println("Registro exitoso de material" + "/n" + "Registros afectados" + rows);
            }
            else{
            System.out.println("Registro NO exitoso del material!!");
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al guardar datos", "Alta", JOptionPane.INFORMATION_MESSAGE);
        } finally {
            Conexion.closeStatement(stmt);
            Conexion.closeConnection(conn);
        }
    }*/
        public String NumRandom(String SQL,String tipo){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String cadena = "";
        try{

            while(rs == null){
            conn = Conexion.getConexion();
            stmt = conn.prepareStatement(SQL); 
            int fiveDigits = (int) floor(10000 + Math.random() * 90000);
            
            cadena = tipo + String.valueOf(fiveDigits);
            stmt.setString(1, cadena);
            rs = stmt.executeQuery();
            
            }
        } catch (SQLException e) {
            System.out.println("Error al buscar el id");
        } finally {
            Conexion.closeStatement(stmt);
            Conexion.closeConnection(conn);
        }
        return cadena;
        }
        
        public void EliminarMaterial(String SQL, int id){
        int rows;
        Connection conn = null;
        PreparedStatement stmt = null;
        rows=0;
        try {
            conn = Conexion.getConexion();
            stmt = conn.prepareStatement(SQL);
            stmt.setInt(1,id);
            System.out.print(stmt);
            rows = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); 
        } finally {
            Conexion.closeConnection(conn);
            Conexion.closeStatement(stmt);
        }
            
        }
        
        public void ActualizarMaterial(String SQL,String codigo,String elemento, int tipo){
        int rows;
        Connection conn = null;
        PreparedStatement stmt = null;
        rows=0;

        try {
            conn = Conexion.getConexion();
            stmt = conn.prepareStatement(SQL);
            int index = 1;
            switch(tipo){
                case 1:
                       stmt.setString(index++,elemento);
                       stmt.setInt(index, Integer.parseInt(codigo));
                        break;
                        
                case 2:
                       stmt.setString(index++,elemento);
                       stmt.setString(index, codigo);
                    break;
                case 3:
                       stmt.setInt(index++,Integer.parseInt(elemento));
                       stmt.setString(index, codigo);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "¡Error!\n No se puede actualizar BD", "Alerta", JOptionPane.WARNING_MESSAGE); 
            }

        rows = stmt.executeUpdate();
        
        if (rows > 0) {
                System.out.println("Registro exitoso de material" + "/n" + "Registros afectados" + rows);
            }
        else{
            System.out.println("Registro NO exitoso del material!!");
        }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexion.closeStatement(stmt);
            Conexion.closeConnection(conn);
        }
        }
}
        
    
        

