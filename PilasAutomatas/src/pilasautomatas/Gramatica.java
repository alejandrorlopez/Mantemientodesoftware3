/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pilasautomatas;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Luis Manuel
 */
public class Gramatica {
    
    
    
   
     
    boolean nombreFuncion(String valor){
        Pattern tipoFuncion = Pattern.compile("([a-zA-Z]\\w+)|([a-zA-Z])");
        Matcher buscar = tipoFuncion.matcher(valor);
          return buscar.matches();
    }
    
   
   
    boolean contenidoVoid(String valor){
        Pattern tipoFuncion = Pattern.compile("System.out.print\\(\\\"\\Hola\\s+Mundo\\\"\\)\\;");
        Matcher buscar = tipoFuncion.matcher(valor);
          return buscar.matches();
    }
     boolean contenidoRetorno(String valor){
        Pattern tipoFuncion = Pattern.compile("return\\s+Variable\\;");
        Matcher buscar = tipoFuncion.matcher(valor);
          return buscar.matches();
    }
 
}
