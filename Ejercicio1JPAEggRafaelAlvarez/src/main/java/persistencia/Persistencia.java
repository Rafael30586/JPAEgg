/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import entidades.Autor;
import entidades.Editorial;
import entidades.Libro;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Usuario
 */
public abstract class Persistencia {
    protected EntityManagerFactory ef = Persistence.createEntityManagerFactory("com.mycompany_Ejercicio1JPAEggRafaelAlvarez_jar_1.0-SNAPSHOTPU");
    protected EntityManager em = ef.createEntityManager();

}
