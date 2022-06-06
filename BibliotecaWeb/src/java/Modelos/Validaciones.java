/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author admin
 */
public class Validaciones {
     SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    
    public static boolean Vacio(String dato){
        boolean valido = false;    
        if(dato.length()==0){
        valido = true;
        }
        return valido;
    }
    
    public static boolean InicialM(String nombre){//1 palabra sin espacios inicial mayu
        return nombre.matches("^([A-Z]{1}[a-z]+)$");
    }
    
    public static boolean SoloTexto(String texto){
        return texto.matches("^([a-zA-Z]+)$");//ya sea mayus o minus 
    }
        
    public static boolean SoloNum13(String num){
        return num.matches("[0-9]{13}");
    }
    
    public static boolean usuario(String usuario){//la primera debe ser mayuscula
    return usuario.matches("^([A-Za-z]+[0-9]+)$");
    }
    
    public static boolean correo(String correo){
        return correo.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
    }
    
    public static boolean contra(String contra){
    return contra.matches("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})");
    }

    public boolean isValidDate(String fecha) {
         try {
              format.parse(fecha);
              return true;
         }
         catch(ParseException e){
              System.out.println("Parse exception validDate" + e);
              return false;
         }
    }
}
