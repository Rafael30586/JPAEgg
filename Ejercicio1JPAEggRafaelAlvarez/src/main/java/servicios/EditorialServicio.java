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
    
}
