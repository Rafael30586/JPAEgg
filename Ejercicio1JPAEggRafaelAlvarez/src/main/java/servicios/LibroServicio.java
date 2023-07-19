/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicios;

import entidades.Autor;
import entidades.Editorial;
import entidades.Libro;
import java.util.List;
import java.util.Scanner;
import persistencia.AutorPersistencia;
import persistencia.EditorialPersistencia;
import persistencia.LibroPersistencia;

public class LibroServicio {
    
    private LibroPersistencia libroPersistencia = new LibroPersistencia();
    private AutorPersistencia autorPersistencia = new AutorPersistencia();
    private EditorialPersistencia editorialPersistencia = new EditorialPersistencia();
    
    public void crearLibro(){ 
        Scanner entrada = new Scanner(System.in).useDelimiter("\n");
        System.out.println("Nombre del libro");
        String nombre = entrada.next();
        System.out.println("ISBN: ");
        Long isbn = entrada.nextLong();
        System.out.println("Año: ");
        Integer anio = entrada.nextInt();
        System.out.println("Cantidad de ejemplares: ");
        Integer cantidadEjemplares = entrada.nextInt();
        System.out.println("Ejemplares prestados: ");
        Integer prestados = entrada.nextInt();
        System.out.println("Ejemplares restantes: ");
        Integer restantes = entrada.nextInt();
        System.out.println("ID del autor: ");
        Integer idAutor = entrada.nextInt();
        Autor autor = autorPersistencia.devolverAutor(idAutor);
        System.out.println("ID de la editorial: ");
        Integer idEditorial = entrada.nextInt();
        Editorial editorial = editorialPersistencia.devolverEditorial(idEditorial);
        
        Libro libro = new Libro();
        libro.setAnio(anio);
        libro.setEditorial(editorial);
        libro.setAutor(autor);
        libro.setTitulo(nombre);
        libro.setAlta(Boolean.FALSE);
        libro.setEjemplares(cantidadEjemplares);
        libro.setEjemplaresRestantes(prestados);
        libro.setEjemplaresPrestados(restantes);
        libro.setIsbn(isbn);
        
        libroPersistencia.persistirLibro(libro);
    }
    
    public void mostrarLibrosISBN(){
        Scanner entrada = new Scanner(System.in).useDelimiter("\n");
        System.out.println("Ingresar ISBN: ");
        long isbn = entrada.nextLong();
        
        List<Libro> libros = libroPersistencia.buscarLibroISBN(isbn);
        
        for(Libro l : libros){
            System.out.println(l);
        }
    }
    
    public void mostrarLibrosTitulo(){
        Scanner entrada = new Scanner(System.in).useDelimiter("\n");
        System.out.println("Ingresar título del libro: ");
        String titulo = entrada.next();
        
        List<Libro> libros = libroPersistencia.buscarLibroTitulo(titulo);
        
        for(Libro l : libros){
            System.out.println(l);
        }
    }
    
    public void mostrarLibrosAutor(){
        Scanner entrada = new Scanner(System.in).useDelimiter("\n");
        System.out.println("Ingresar autor de: ");
        String autor = entrada.next();
        
        List<Libro> libros = libroPersistencia.burcarLibroAutor(autor);
        
        for(Libro l : libros){
            System.out.println(l);
        }
    }
    
    public void mostrarLibrosEditorial(){
        Scanner entrada = new Scanner(System.in).useDelimiter("\n");
        System.out.println("Ingresar editorial: ");
        String eidtorial = entrada.next();
        
        List<Libro> libros = libroPersistencia.burcarLibroEditorial(eidtorial);
        
        for(Libro l : libros){
            System.out.println(l);
        }
    }
    
}
