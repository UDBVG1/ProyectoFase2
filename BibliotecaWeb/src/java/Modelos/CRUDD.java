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
    
    
//Función que ejecuta sentencia para listar miembros de una base de datos.
    
    public DefaultTableModel material_lista(String SQL, int tipo,ArrayList datos) {
        
        int index;

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        DefaultTableModel dtm=new DefaultTableModel();
        try {
            conn = Conexion.getConexion();
            stmt = conn.prepareStatement(SQL); 
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
                    System.out.println("valor datos : "+i+ " index: "+index+ " " +String.valueOf(datos.get(i)));
                    }
                    
                    break;
                default:
                                      
            }
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
            System.out.println("valor: "+String.valueOf(dtm.getValueAt(0,1)));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexion.closeStatement(stmt);
            Conexion.closeConnection(conn);
            Conexion.closeResulset(rs);
        }
        return dtm;
    }    
    
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
                JOptionPane.showMessageDialog(null, "Registro exitoso" + "/n" + "Registros afectados" + rows, "Ingresado", JOptionPane.INFORMATION_MESSAGE);
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
            JOptionPane.showMessageDialog(null, "Error al guardar datos", "Alta", JOptionPane.INFORMATION_MESSAGE);
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
            JOptionPane.showMessageDialog(null, "Error al buscar el id", "extraer", JOptionPane.INFORMATION_MESSAGE);
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
        
    
        

