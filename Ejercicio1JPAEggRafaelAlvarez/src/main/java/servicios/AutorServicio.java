/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicios;

import entidades.Autor;
import java.util.List;
import java.util.Scanner;
import persistencia.AutorPersistencia;

public class AutorServicio {
    
    private AutorPersistencia autorPersistencia = new AutorPersistencia();
    
    public void crearAutor(){
        Scanner entrada = new Scanner(System.in).useDelimiter("\n");
        Autor autor = new Autor();
        
        System.out.println("Ingrese nombre completo del autor");
        String nombre = entrada.next();
        
        autor.setNombre(nombre);
        autor.setAlta(false);
        
        autorPersistencia.persistirAutor(autor);
    }
    
    public void mostrarAutoresNombre(){
        Scanner entrada = new Scanner(System.in).useDelimiter("\n");
        
        System.out.println("Ingrese nombre completo del autor");
        String nombre = entrada.next();
        
        List<Autor> autores = autorPersistencia.buscarAutorNombre(nombre);
        
        for(Autor a : autores){
            System.out.print("ID: "+a.getId()+" ");
            System.out.println("Nombre: "+a.getNombre());
        }
    
    }
    
    public void darAltaAutor(){
        Scanner entrada = new Scanner(System.in).useDelimiter("\n");
        char respuesta='t';
        boolean alta = false;
        do{
            System.out.println("Desea dar de alta a un autor? s o n");
        respuesta = entrada.next().charAt(0);
        
        
        if(respuesta=='s'){
            alta = true;
        }else if(respuesta=='n'){
            alta = false;
            System.out.println("El autor que elija se dará de baja");
        }else{
            System.out.println("Respuesta incorrecta"); 
        }
        
        }while(respuesta!='n' && respuesta!='s');
        
        System.out.println("Ingresar ID del autor");
        Integer id = entrada.nextInt();
        
        autorPersistencia.editarAltaAutor(alta, id);
         
    }
    
}
