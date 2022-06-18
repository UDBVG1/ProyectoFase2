/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidades;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.log4j.Logger;

public class Conexion {
//   static final Logger logger =Logger.getLogger(Conexion.class);
   public static Connection conn=null;//conn es la conexion
   private static String driver ="com.mysql.jdbc.Driver";//The name of the class that implements java.sql.Driver in MySQL Connector/J has changed from com.mysql.jdbc.Driver to com.mysql.cj.jdbc.Driver. The old class name has been deprecated.
   private static String user = "root";
   private static String password = "";
   private static String server = "jdbc:mysql://localhost:3306/poo";//server el cual establece la 


    /**
     * @return 
     * @throws java.sql.SQLException
     */
   //*************************creamos la conexion************************
    public static Connection getConexion(){
    conn = null;
    try{
    Class.forName(driver);//driver
     conn=DriverManager.getConnection(server, user, password);//conexion
     System.out.println("conexion exitosa");
        }

    catch(ClassNotFoundException | SQLException e){
        System.out.println("ERROR No encuentro el driver de la BD: "+ e);
    }
    return conn;
    }

    //*********************cerrar la bd****************************
    
    public static void closeResulset(ResultSet rs){//cerrar conexion para mandar a llamar info a la db
    try{
        if (rs != null){
        rs.close();
    }
    }catch (SQLException e) {
        System.out.println("ERROR No encuentro el driver de la BD: "+ e);
        }
    }
            
    public static void closeStatement(PreparedStatement Pstm){//cerrar el statement para el update delete y select
    try{
        if (Pstm != null){
        Pstm.close();
    }
    } catch (SQLException e) {
        System.out.println("ERROR No encuentro el driver de la BD: "+ e);
       }
    }
    public static void closeConnection(Connection conn){//cerrar la conexion
        try {
    if (conn != null){
    conn.close();
    }
        } catch (SQLException e) {
            System.out.println("ERROR No encuentro el driver de la BD: "+ e);
        }
    }
    }