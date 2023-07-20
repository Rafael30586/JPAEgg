/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import entidades.Libro;
import java.util.ArrayList;
import java.util.List;

public class LibroPersistencia extends Persistencia{
    public void persistirLibro(Libro libro){
        em.getTransaction().begin();
        em.persist(libro);
        em.getTransaction().commit();
        em.clear();
        //em.close();
        System.out.println("Transacción realizada con éxito");
    }
    
    public List<Libro> buscarLibroISBN(Long isbn){
        
        List<Libro> libros = em.createQuery("Select l from Libro l where l.isbn = "+isbn)
                            .getResultList();
        return libros;
    }
    
    public List<Libro> buscarLibroTitulo(String titulo){
        
        List<Libro> libros = em.createQuery("Select l from Libro l where l.titulo LIKE :titulo")
                .setParameter("titulo",titulo)
                .getResultList();
        
        return libros;
    }
    
    public List<Libro> burcarLibroAutor(String autor){ //hay que hacer join
        
        List<Libro> libros = em.createQuery("Select l from Libro l join l.autor a where a.nombre LIKE :autor")
                .setParameter("autor",autor)
                .getResultList();
        
        return libros;
    }
    
    public List<Libro> burcarLibroEditorial(String editorial){ //hay que hacer join
        
        List<Libro> libros = em.createQuery("Select l from Libro l join l.editorial e where e.nombre LIKE :editorial")
                .setParameter("editorial", editorial)
                .getResultList();
        
        return libros;
    }
    
    public void editarLibroAlta(boolean respuesta,Long isbn){
        Libro libro = em.find(Libro.class, isbn);
        libro.setAlta(respuesta);
        em.getTransaction().begin();
        em.merge(libro);
        em.getTransaction().commit();
        em.clear();
        //em.close();
        System.out.println("Transacción realizada con éxito");
    
    }
    
}
