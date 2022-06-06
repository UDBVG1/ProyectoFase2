/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import Entidad.*;
import Utilidades.ParametrosGlobales;
import java.util.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Eveling Santos
 */
public class MaterialCRUDD extends CRUDD{
//Declaracion de variables SQL
    
    private String SQLMaterial="SELECT m.codigo,m.idescrito,m.idaudiovisual, case when m.idescrito is not null then l.titulo \n" +
                                        "WHEN m.idaudiovisual is not null THEN r.titulo \n" +
                                        "else null end AS titulo,catalogacion,cantidad_total,cantidad_disponible\n" +
                                        "FROM material m LEFT join escrito l on m.idescrito=l.idescrito \n" +
                                        "LEFT join audiovisual r on m.idaudiovisual=r.idaudiovisual\n" +
                                        ";";
    private final String SQLbuscar="SELECT codigo,titulo, catalogacion,autor,editorial,isbn,genero, artista, director from materiales_vista " +
                                    "where titulo like ? or autor like ? or editorial like ? or isbn like ? or genero like ? or artista like ? or director like ?;";
    private final String SQL_DELETE_ESCRITO="DELETE FROM escrito WHERE idescrito = ? ;";
   private final String SQL_DELETE_AUDIOVISUAL="DELETE FROM audiovisual WHERE idaudiovisual = ? ;";
    private final String SQL_SELECTRN = "select count(*) from material where codigo = ?;";
    private String SQL_VALIDAR="SELECT codigo FROM `materiales_vista` WHERE codigo=?;";
    private String SQL_INSERT="";
     private String SQL_MATERIAL="";
     private String SQL_UPDATE="";
     /*
    
    */
     
    private final ArrayList<String> matriz_entidad = new ArrayList<>();
    private final ArrayList<String> matriz_material = new ArrayList<>();
    private final ArrayList<String> code=new ArrayList();
     public String[] Lista={"LIB","OBR","REV","CDA","DVD"};
        
    public String InsertarEscrito(Escrito Entidad){
        String codigo; 
        int i,j,a,b,c;

        i=j=0;
        a=b=c=100;
        /*Asignar a String*/
        matriz_entidad.clear();
        matriz_material.clear();
        matriz_entidad.add(Entidad.getTitulo());
        matriz_entidad.add(Entidad.getTipo());
        matriz_entidad.add(Entidad.getAutor());
        matriz_entidad.add(String.valueOf(Entidad.getNumPaginas()));
        a=3;
        matriz_entidad.add(Entidad.getEditorial());
        SQL_INSERT="INSERT INTO `escrito` (`titulo`, `tipo`, `autor`, `num_pag`, `editorial`,";
        switch (Entidad.getTipo()){
            case "LIB":
                matriz_entidad.add(String.valueOf(Entidad.getISBN()));
                matriz_entidad.add(String.valueOf(Entidad.getFechaPubli()));
                SQL_INSERT=SQL_INSERT + "`isbn`,`publicacion`) values(?,?,?,?,?,?,?);";
                b=5;c=6;
                break;
            case "REV":
                matriz_entidad.add(Entidad.getPeriodicidad());
                b=100; c=100;
                SQL_INSERT=SQL_INSERT + " `periodicidad`) values(?,?,?,?,?,?);";
                break;
            case "OBR":
                matriz_entidad.add(String.valueOf(Entidad.getFechaPubli()));
                SQL_INSERT=SQL_INSERT + " `publicacion`) values(?,?,?,?,?,?);";
                b=5;c=100;
                break;
               
            default:
                System.out.println("error"); 
        } 
        i=matriz_entidad.size();
        matriz_material.add(Entidad.getcatalogacion());
        matriz_material.add(String.valueOf(Entidad.getCantTotal()));
        matriz_material.add(String.valueOf(Entidad.getCantDisp()));
        matriz_material.add(String.valueOf(Entidad.getTiempo()));
        j=4;
        SQL_MATERIAL="INSERT INTO `material` (`codigo`, `catalogacion`, `cantidad_total`, `cantidad_disponible`, `tiempo`, `idescrito`)\n" +
                                       "VALUES (?, ?,?,?,?,?);";
        codigo=super.NumRandom(SQL_SELECTRN,Entidad.tipo);
        
        
        
        super.insertarDatos(SQL_INSERT, SQL_MATERIAL,matriz_entidad ,matriz_material, codigo,i,j,a,b,c); 
        return codigo;
    }
    
    public String InsertarAudio(Audiovisual Entidad){
        String codigo; 
        int i,j,a,b,c;
        boolean salir;
        i=j=0;
        a=b=c=100;
        /*Asignar a String*/
        matriz_entidad.clear();
        matriz_material.clear();
        matriz_entidad.add(Entidad.getTitulo());
        matriz_entidad.add(Entidad.getTipo());
        matriz_entidad.add(Entidad.getAutor());
        matriz_entidad.add(Entidad.getGenero());
        matriz_entidad.add(Entidad.getDuracion());
        SQL_INSERT="INSERT INTO `audiovisual` (`titulo`, `tipo`,"; 
        switch(Entidad.getTipo()){
            case "CDA":
                SQL_INSERT=SQL_INSERT + " `artista`,`genero`,`duracion`,`canciones`) values(?,?,?,?,?,?);";
                matriz_entidad.add(String.valueOf(Entidad.getNumCanciones()));
                a=6;b=100;c=100;
                break;
            case "DVD":
                SQL_INSERT=SQL_INSERT + " `director`,`genero`,`duracion`) values(?,?,?,?,?);";
                break;
        }

        i=matriz_entidad.size();
        
        SQL_MATERIAL="INSERT INTO `material` (`codigo`, `catalogacion`, `cantidad_total`, `cantidad_disponible`, `tiempo`, `idaudiovisual`)\n" +
                                       "VALUES (?, ?,?,?,?,?);";
        matriz_material.add(Entidad.getcatalogacion());
        matriz_material.add(String.valueOf(Entidad.getCantTotal()));
        matriz_material.add(String.valueOf(Entidad.getCantDisp()));
        matriz_material.add(String.valueOf(Entidad.getTiempo()));
        j=4;
        
        do{
        codigo=super.NumRandom(SQL_SELECTRN,Entidad.tipo);
        }while(codigo.equals("Vacia"));
        super.insertarDatos(SQL_INSERT, SQL_MATERIAL,matriz_entidad ,matriz_material, codigo,i,j,a,b,c); 
        return codigo;
    }
    
    public DefaultTableModel listarMateriales(){
        switch (ParametrosGlobales.GlobalAccesNivel){
            case 1: SQLMaterial="select codigo, titulo, catalogacion, tiempo, cantidad_total, cantidad_disponible from materiales_vista;";
                    break;
            case 2: SQLMaterial="select codigo, titulo, catalogacion, cantidad_total, cantidad_disponible from materiales_vista;";
                    break;
            case 3: SQLMaterial="select codigo, titulo, catalogacion,  cantidad_disponible from materiales_vista;";
                    break;
        }
        
        DefaultTableModel dtm=super.material_lista(SQLMaterial,0,code);
        return dtm;
    }
    
    public int EliminarMateriales(String codigo, String tipo){
        int id,i;

        
        code.clear();
        code.add(codigo);
        JOptionPane.showMessageDialog(null, "tipo: " + tipo);
        if (tipo.equals(Lista[0]) || tipo.equals(Lista[1])  || tipo.equals(Lista[2] )){
            SQLMaterial="Select codigo,idescrito from materiales_vista where codigo=?;";            
            DefaultTableModel dtm=super.material_lista(SQLMaterial,1,code);
            id=Integer.parseInt(String.valueOf(dtm.getValueAt(0,1)));
            super.EliminarMaterial(SQL_DELETE_ESCRITO,id); i=0;
            
        }
        else{
            if (tipo.equals(Lista[3]) || tipo.equals(Lista[4])){
            SQLMaterial="Select codigo,idaudiovisual from materiales_vista where codigo=?;";            
            DefaultTableModel dtm=super.material_lista(SQLMaterial,1,code);
            id=Integer.parseInt(String.valueOf(dtm.getValueAt(0,1)));
            super.EliminarMaterial(SQL_DELETE_AUDIOVISUAL,id); i=0;
        }
            else{
                JOptionPane.showMessageDialog(null, "¡Error!\n No se encuentra Material", "Alerta", JOptionPane.WARNING_MESSAGE); i=1;
            }
            }
        return i;
    }
    
    
    public DefaultTableModel Busqueda(ArrayList elementos){
      DefaultTableModel dtm=super.material_lista(SQLbuscar,2,elementos);
      return dtm;
    }
    
    public DefaultTableModel BuscarMaterial(String codigo, String datos){
        code.clear();
        code.add(codigo);
        SQLMaterial="select codigo,titulo,catalogacion,";
        switch(datos){
        case "LIB":
            SQLMaterial=SQLMaterial + " autor,num_pag,editorial,ISBN, publicacion ";  
            break;
        case "OBR":
            SQLMaterial=SQLMaterial + " autor,num_pag,editorial, publicacion ";  
            break;
        case "REV":
            SQLMaterial=SQLMaterial + " num_pag,periodicidad, publicacion ";  
            break;
        case "CDA":
            SQLMaterial=SQLMaterial + " artista, genero, duracion, canciones  ";  
          break;
        case "DVD":
            SQLMaterial= SQLMaterial + " director, genero, duracion "; 
            break;
        }
       
        switch (ParametrosGlobales.GlobalAccesNivel){
        case 1: SQLMaterial=SQLMaterial + ",cantidad_total, cantidad_disponible, tiempo from materiales_vista where codigo=?;";
                break;
        case 2: SQLMaterial=SQLMaterial + ",cantidad_total, cantidad_disponible from materiales_vista where codigo=?;";
                break;
        case 3: SQLMaterial=SQLMaterial + ",cantidad_disponible from materiales_vista where codigo=?;";
                break;
    } 
        //System.out.println(SQLMaterial);
      DefaultTableModel dtm=super.material_lista(SQLMaterial,1,code);
      return dtm;
    }
    
    public void Actualizar(String elemento, String codigo, int index){
        String id;
        int dec=0;
        switch(index){
            case 1:
                    id=AveriguarID(codigo, codigo.substring(0,3));
                    if (codigo.substring(0,3).equals(Lista[0]) || codigo.substring(0,3).equals(Lista[1])  || codigo.substring(0,3).equals(Lista[2] )){
                    SQL_UPDATE="UPDATE Escrito SET titulo = ? WHERE idescrito = ?;";
                    }
                    else{
                        if (codigo.substring(0,3).equals(Lista[3]) || codigo.substring(0,3).equals(Lista[4])){
                        SQL_UPDATE="UPDATE Audiovisual SET titulo = ? WHERE idaudiovisual = ?;";                    
                        }
                        else{
                          JOptionPane.showMessageDialog(null, "¡Error!\n No se encuentra Material", "Alerta", JOptionPane.WARNING_MESSAGE);  
                          dec=1;
                        }
                    }
                    if(dec==0){
                        super.ActualizarMaterial(SQL_UPDATE,id, elemento, 1);
                    }
                    break;
            case 2:
                 if (codigo.substring(0,3).equals(Lista[0]) ||  codigo.substring(0,3).equals(Lista[1] )){   
                 SQL_UPDATE="UPDATE materiales_vista SET autor = ? WHERE materiales_vista.codigo = ?;";}
                 else{
                 if (codigo.substring(0,3).equals(Lista[3])){
                     SQL_UPDATE="UPDATE materiales_vista SET artista = ? WHERE materiales_vista.codigo = ?;";
                 }
                 else{
                    if (codigo.substring(0,3).equals(Lista[4])){ 
                        SQL_UPDATE="UPDATE materiales_vista SET director = ? WHERE materiales_vista.codigo = ?;";
                    }
                    else{
                      
                      JOptionPane.showMessageDialog(null, "¡Error!\n No se encuentra Material", "Alerta", JOptionPane.WARNING_MESSAGE);
                      dec=1;
                    }
                 }
                 }
                 if(dec==0){
                 super.ActualizarMaterial(SQL_UPDATE,codigo, elemento, 2);
                 }
                 break;
            case 3:
                 SQL_UPDATE="UPDATE materiales_vista SET catalogacion = ? WHERE materiales_vista.codigo = ?;";
                 super.ActualizarMaterial(SQL_UPDATE,codigo, elemento, 2);
                 break;
            case 4:
                 SQL_UPDATE="UPDATE materiales_vista SET cantidad_total = ? WHERE materiales_vista.codigo = ?;";
                 super.ActualizarMaterial(SQL_UPDATE,codigo, elemento, 3);
                break;
            case 5:
                 SQL_UPDATE="UPDATE materiales_vista SET tiempo = ? WHERE materiales_vista.codigo = ?;";
                 super.ActualizarMaterial(SQL_UPDATE,codigo, elemento, 3);
                break;
            case 6:
                SQL_UPDATE="UPDATE materiales_vista SET editorial = ? WHERE materiales_vista.codigo = ?;";
                super.ActualizarMaterial(SQL_UPDATE,codigo, elemento, 2);
                break;
            case 7:
                SQL_UPDATE="UPDATE materiales_vista SET genero = ? WHERE materiales_vista.codigo = ?;";
                super.ActualizarMaterial(SQL_UPDATE,codigo, elemento, 2);
                break;
            case 8:
                SQL_UPDATE="UPDATE materiales_vista SET isbn = ? WHERE materiales_vista.codigo = ?;";
                super.ActualizarMaterial(SQL_UPDATE,codigo, elemento, 3);
                break;
            case 9:
                SQL_UPDATE="UPDATE materiales_vista SET num_pag = ? WHERE materiales_vista.codigo = ?;";
                super.ActualizarMaterial(SQL_UPDATE,codigo, elemento, 3);
                break;
            case 10:
                SQL_UPDATE="UPDATE materiales_vista SET duracion = ? WHERE materiales_vista.codigo = ?;";
                super.ActualizarMaterial(SQL_UPDATE,codigo, elemento, 2);
                break;
            case 11:
                SQL_UPDATE="UPDATE materiales_vista SET publicacion = ? WHERE materiales_vista.codigo = ?;";
                super.ActualizarMaterial(SQL_UPDATE,codigo, elemento, 2);
                break;
            case 12:
                SQL_UPDATE="UPDATE materiales_vista SET canciones = ? WHERE materiales_vista.codigo = ?;";
                super.ActualizarMaterial(SQL_UPDATE,codigo, elemento, 2);
                break;
            default:
                
                }
                
                
        }
    
        public String AveriguarID(String codigo, String tipo){
        code.clear();
        code.add(codigo);
        String id=null;
            if (tipo.equals(Lista[0]) || tipo.equals(Lista[1])  || tipo.equals(Lista[2] )){
            SQLMaterial="Select codigo,idescrito from materiales_vista where codigo=?;";            
            DefaultTableModel dtm=super.material_lista(SQLMaterial,1,code);
            id=String.valueOf(dtm.getValueAt(0,1));
            }
            else{
            if (tipo.equals(Lista[3]) || tipo.equals(Lista[4])){
            SQLMaterial="Select codigo,idaudiovisual from materiales_vista where codigo=?;";            
            DefaultTableModel dtm=super.material_lista(SQLMaterial,1,code);
            id=String.valueOf(dtm.getValueAt(0,1));
             }
            else{
                JOptionPane.showMessageDialog(null, "¡Error!\n No se encuentra Material", "Alerta", JOptionPane.WARNING_MESSAGE);
            } 
           
          }
            return id;
    }

}
    

    
