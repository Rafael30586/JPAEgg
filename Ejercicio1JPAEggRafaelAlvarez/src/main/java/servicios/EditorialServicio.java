/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicios;

import entidades.Editorial;
import java.util.Scanner;
import persistencia.EditorialPersistencia;


public class EditorialServicio {
    
    private EditorialPersistencia editorialPersistencia = new EditorialPersistencia();
    
    public void crearEditorial(){
        Scanner entrada = new Scanner(System.in).useDelimiter("\n");
        System.out.println("Nombre de la editorial");
        String nombre = entrada.next();
        
        Editorial editorial = new Editorial();
        editorial.setNombre(nombre);
        editorial.setAlta(false);
        
        editorialPersistencia.persistirEditorial(editorial);
    
    }
    
    public void darAltaEditorial(){
        Scanner entrada = new Scanner(System.in).useDelimiter("\n");
        char respuesta='t';
        boolean alta = false;
        do{
            System.out.println("Desea dar de alta a una editorial? s o n");
        respuesta = entrada.next().charAt(0);
        
        
        if(respuesta=='s'){
            alta = true;
        }else if(respuesta=='n'){
            alta = false;
            System.out.println("La editorial que elija se dará de baja");
        }else{
            System.out.println("Respuesta incorrecta"); 
        }
        
        }while(respuesta!='n' && respuesta!='s');
        
        System.out.println("Ingresar ID de la editorial");
        Integer id = entrada.nextInt();
        
        editorialPersistencia.editarEditorialAlta(alta, id);
         
    }
    
}
