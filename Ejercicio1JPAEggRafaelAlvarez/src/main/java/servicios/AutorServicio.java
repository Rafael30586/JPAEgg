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
}
