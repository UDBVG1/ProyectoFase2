/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidades;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

/**
 *
 * @author rafael.torres
 */
public class PruebaLogs {

    /**
     * @param args the command line arguments
     */
    static final Logger log = Logger.getLogger(PruebaLogs.class);
    public static void main(String[] args) {
        // TODO code application logic here      
      log.info("Mensaje con Info");
      log.fatal("Mensaje con Fatal");
      log.warn("Mensaje con Warn");
      log.error("Mensaje con Error");
      log.debug("Mensaje con Debug");    
    } 
}
