/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidades;

import java.util.logging.Logger;

/**
 *
 * @author amgoo
 */
public class ParametrosGlobales {
    //Aqui se pondran todos los parametros globales necesarios
    //para usar en la aplicaion en general
    public static boolean UsuariosPanelAgregar;
    public static boolean UsuariosPanelModificar;
  
    //Usuario Global
    public static String GlobalUser;
    public static int GlobalAccesNivel;
    public static int GlobalAccesId;
    
    //indice del menu de prestamo
    public static int TipoPrestamo;  

    //Materiales
      public static String tipo;
      public static boolean mat_table;

    public static boolean isUsuariosPanelAgregar() {
        return UsuariosPanelAgregar;
    }

    public static void setUsuariosPanelAgregar(boolean UsuariosPanelAgregar) {
        ParametrosGlobales.UsuariosPanelAgregar = UsuariosPanelAgregar;
    }

    public static boolean isUsuariosPanelModificar() {
        return UsuariosPanelModificar;
    }

    public static void setUsuariosPanelModificar(boolean UsuariosPanelModificar) {
        ParametrosGlobales.UsuariosPanelModificar = UsuariosPanelModificar;
    }

    public static String getGlobalUser() {
        return GlobalUser;
    }

    public static void setGlobalUser(String GlobalUser) {
        ParametrosGlobales.GlobalUser = GlobalUser;
    }

    public static int getGlobalAccesNivel() {
        return GlobalAccesNivel;
    }

    public static void setGlobalAccesNivel(int GlobalAccesNivel) {
        ParametrosGlobales.GlobalAccesNivel = GlobalAccesNivel;
    }

    public static int getGlobalAccesId() {
        return GlobalAccesId;
    }

    public static void setGlobalAccesId(int GlobalAccesId) {
        ParametrosGlobales.GlobalAccesId = GlobalAccesId;
    }

    public static int getTipoPrestamo() {
        return TipoPrestamo;
    }

    public static void setTipoPrestamo(int TipoPrestamo) {
        ParametrosGlobales.TipoPrestamo = TipoPrestamo;
    }

    public static String getTipo() {
        return tipo;
    }

    public static void setTipo(String tipo) {
        ParametrosGlobales.tipo = tipo;
    }

    public static boolean isMat_table() {
        return mat_table;
    }

    public static void setMat_table(boolean mat_table) {
        ParametrosGlobales.mat_table = mat_table;
    }

    public ParametrosGlobales() {
    }
       
}
