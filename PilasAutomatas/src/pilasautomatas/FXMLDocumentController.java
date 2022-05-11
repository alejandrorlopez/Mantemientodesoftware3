/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pilasautomatas;



import java.net.URL;
import java.util.ArrayList;

import java.util.ResourceBundle;
import java.util.Stack;
import javafx.animation.TranslateTransition;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;



import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.util.Duration;


/**
 *
 * @author Luis Manuel
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private VBox pilaComprobar; 
    @FXML
    private VBox pilaBotones;
    @FXML
    private TextField tipoFuncion; 
    @FXML
    private TextField tipoVariable; 
    @FXML
    private TextField nombreFuncion; 
    @FXML
    private TextField parentesisApertura; 
    @FXML
    private TextField parametro; 
    @FXML
    private TextField parentesisCierre; 
    @FXML
    private TextField llaveApertura; 
    @FXML
    private TextField contenido; 
    @FXML
    private TextField llaveCierre;
    @FXML
    private Label popPila;
    @FXML
    private Label gramaticaLabel;
    @FXML
    private TextArea derivacionTexArea;
    @FXML
    private Button devolver;
    
     Stack pila = new Stack();
     Gramatica gramatica = new Gramatica();
     ArrayList<String> arrayTipoFuncion = new ArrayList<>();
     ArrayList<String> arrayTipoVariable = new ArrayList<>();
     ArrayList<String> arrayAux = new ArrayList<>();
       
    @FXML
    private void handleButtonAction(ActionEvent event) {
            llenarPila();
            compararPila(arrayTipoFuncion); 
             
    }
    @FXML
    private void reinicio( ActionEvent event) {
           
            
            
    }
     @FXML
    private void llenarParametros(){
        tipoFuncion.setText("public");
        tipoVariable.setText("int");
        nombreFuncion.setText("funcion");
        parentesisApertura.setText("(");
        parametro.setText("int valor");
        parentesisCierre.setText(")");
        llaveApertura.setText("{");
        contenido.setText("return Variable;");
        llaveCierre.setText("}");
        
    }
  
 
    private void llenarPila(){

        arrayTipoFuncion.add("public");
        arrayTipoFuncion.add("private");
        arrayTipoFuncion.add("protected");
        arrayTipoFuncion.add("");
        arrayTipoVariable.add("int");
        arrayTipoVariable.add("String");
        arrayTipoVariable.add("float");
        arrayTipoVariable.add("boolean");
        arrayTipoVariable.add("char");
        pila.push("}");
        pila.push("Contenido");
        pila.push("{");
        pila.push(")");
        pila.push("Resto");
        pila.push("Nombre");
        pila.push(arrayTipoVariable);
        pila.push("(");
        pila.push("Nombre Funcion");
        pila.push(arrayTipoVariable);
        pila.push(arrayTipoFuncion);
    }
    private void compararPila( ArrayList<String> valor){
        
        System.out.println(""+pila);
       
        if (pila.pop().toString().contains(tipoFuncion.getText())) {
            
            System.out.println("Tipo de funcion Encontrado");
          
            System.out.println(""+pila);
        }else{
            
            System.out.println("No encontrado");
            System.out.println(""+pila);
            return;
            
        }
        
        ArrayList<String> aux= (ArrayList<String>) pila.pop();
                if (aux.contains(tipoVariable.getText())) {
             
            System.out.println("Tipo de Variable Encontrado");
            System.out.println(""+pila);
        }else{
            System.out.println("Tipo de variable no encontrado");
            System.out.println(""+pila);
            return;
        } 
        if (gramatica.nombreFuncion(nombreFuncion.getText())) {
            System.out.println("Nombre de Funcion Encontrado");
            pila.pop();
            System.out.println(""+pila);
        }else{
             System.out.println("No encontrado");
             System.out.println(""+pila);
             return;
        }
        String aux4 = (String) pila.pop();
        if (aux4.equals(parentesisApertura.getText())) {
             System.out.println("Parentesis encontrado");
          
            System.out.println(""+pila);
        }else{
             System.out.println("No encontrado");
             System.out.println(""+pila);
             return;
        }
        
        String[]dividirparametro = parametro.getText().split(" ");
          
        if (pila.pop().toString().contains(dividirparametro[0])) {
            System.out.println(""+dividirparametro[0]);
            System.out.println("Parametro encontrado");
            
            System.out.println(""+pila);
        }else{
             System.out.println("No encontrado");
             System.out.println(""+pila);
             return;
        }
        if (gramatica.nombreFuncion(dividirparametro[1])) {
            pila.pop();
            System.out.println("Se encontro---->"+dividirparametro[1]);
            System.out.println(""+pila);
        }else{
            System.out.println("No se encontro");
            System.out.println(""+pila);
            return;
        }
        if (parametro.getText().contains(",")) {
            System.out.println("Se encontro una coma");
            if (arrayTipoVariable.contains(dividirparametro[3])) {
                System.out.println("Se encontro el tipo de dato ");
            }else{
                System.out.println("No se encontro dato");
                System.out.println(""+pila);
                return;
            }
            if (gramatica.nombreFuncion(dividirparametro[4])) {
                pila.pop();
                System.out.println("Se encontro el nombre");
            }else{
                System.out.println("No se encontro el nombre");
                System.out.println(""+pila);
                return;
            }
        }else{
            pila.pop();
            System.out.println("Se encontro un vacio");
        }
        
        String aux2 = (String) pila.pop();
        
        if (aux2.equals(parentesisCierre.getText())) {
            System.out.println("Parentesis Cierre Encontrado");
           System.out.println(""+pila);
        }else{
            System.out.println("No encontrado");
            System.out.println(""+pila);
            return;
        }
        String aux1 = (String) pila.pop();
        if(aux1.equals(llaveApertura.getText())){
            System.out.println("Llave Apertura Encontado");
            System.out.println(""+pila);
        }else{
            System.out.println("No encontrado");
            System.out.println(""+pila);
            return;
        }
        if (gramatica.contenidoVoid(contenido.getText())) {
            pila.pop();
            System.out.println("Contenido Encontrado");
            System.out.println(""+pila);
        }else if (gramatica.contenidoRetorno(contenido.getText())) {
            pila.pop();
            System.out.println("Contenido Encontrado");
            System.out.println(""+pila);
        }else{
            System.out.println("No encontrado");
            System.out.println(""+pila);
            return;
        }
        String aux5 = (String) pila.pop();
        if (aux5.equals(llaveCierre.getText())) {
            System.out.println("Llave de Cierre encontrada");
            System.out.println("Pila Vacia"+pila);
        }else{
            System.out.println("No encontrado");
            System.out.println(""+pila);
            
        }
        
     
    }
    
    
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       gramaticaLabel.setText("Funcion");
       derivacionTexArea.setText("Funcion Java");
    }    
    
}
