/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import entidades.Editorial;

/**
 *
 * @author Usuario
 */
public class EditorialPersistencia extends Persistencia{
    public void persistirEditorial(Editorial editorial){
        em.getTransaction().begin();
        em.persist(editorial);
        em.getTransaction().commit();
        em.clear();
        //em.close();
        System.out.println("Transacción realizada con éxito");
    }
    
    public Editorial devolverEditorial(Integer id){
        Editorial editorial = em.find(Editorial.class, id);
        
        return editorial;
    
    }
    
    public void editarEditorialAlta(boolean respuesta, Integer id){
        Editorial editorial;
        editorial = em.find(Editorial.class, id);
        editorial.setAlta(respuesta);
        em.getTransaction().begin();
        em.merge(editorial);
        em.getTransaction().commit();
        em.clear();
        //em.close();
        System.out.println("Transacción realizada con éxito");
    
    }
    
}
