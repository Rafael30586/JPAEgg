/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import entidades.Autor;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Usuario
 */
public class AutorPersistencia extends Persistencia{
    
    public void persistirAutor(Autor autor){
        em.getTransaction().begin();
        em.persist(autor);
        em.getTransaction().commit();
        //em.close();
        em.clear();
        System.out.println("Transacción realizada con éxito");
    }
    
    public List<Autor> buscarAutorNombre(String nombre){
        
        List<Autor> autores = em.createQuery("SELECT a FROM Autor a WHERE a.nombre LIKE :nombre")
                .setParameter("nombre", nombre) //uno es el atributo de clase, el otro es el parametro String
                .getResultList();
        
        return autores;
    }
    
    public Autor devolverAutor(int id){
        Autor autor = em.find(Autor.class, id);
        
        return autor;
    
    }
    
    public void editarAltaAutor(boolean alta, Integer id){
        Autor autor = em.find(Autor.class, id);
        autor.setAlta(alta);
        em.getTransaction().begin();
        em.merge(autor);
        em.getTransaction().commit();
        em.clear();
        //em.close();
        System.out.println("Transacción realizada con éxito");
    }
}
