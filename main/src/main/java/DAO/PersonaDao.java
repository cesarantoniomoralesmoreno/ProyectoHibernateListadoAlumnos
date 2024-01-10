package DAO;

import java.util.List;

import domain.Persona;
import jakarta.persistence.*;

public class PersonaDao {
    private EntityManagerFactory emf;
    private EntityManager em;
    
    public PersonaDao() {
        emf = Persistence.createEntityManagerFactory("HibernatePU");
        em = emf.createEntityManager();//Con esta variable es que se hacen las consultas hacia el Framework de Hibernate
    }

    public List<Persona> listar(){

        String hql = "SELECT p FROM Persona p";
        Query query = em.createQuery(hql);//Estamos recuperando objetos de tipo persona
        @SuppressWarnings("unchecked")/*The expression of type List needs unchecked conversion to conform to List<Persona>" 
        se refiere a que estás utilizando una lista genérica sin proporcionar un tipo específico y el compilador no puede 
        verificar si el tipo de lista que estás utilizando es compatible con el tipo de lista que esperas.

        En tu caso, la lista que obtienes del resultado de la consulta es de tipo genérico List, pero deberías indicar 
        que es una lista de objetos de tipo Persona. Para corregir esta advertencia, puedes agregar una anotación 
        @SuppressWarnings sobre la línea donde obtienes el resultado de la consulta para indicarle al compilador que 
        estás consciente de que la conversión puede ser insegura, pero que estás seguro de que es correcta en este caso:
        
        @SuppressWarnings("unchecked")
        List<Persona> personas = query.getResultList();

        Ten en cuenta que aunque esto elimina la advertencia, aún es importante que estés seguro de que la consulta realmente
         devuelve una lista de objetos Persona. Si estás seguro de que tu consulta y tu mapeo de entidades están configurados 
         correctamente, esta supresión de advertencia debería ser segura.  */

        List<Persona> personas =  query.getResultList();
        //System.out.println("Veamos que imprime: "+ query.getResultList());

        for(Persona p : personas){
            System.out.println("p = "+ p);
        }

        return personas;
    }

    public void insertar(Persona persona){
        try {

            em.getTransaction().begin();
            em.persist(persona);
            em.getTransaction().commit();//Cuando se trabaja con un servidor empresarial este se encarga de hacer esto
        } catch (Exception e) {
            
            e.printStackTrace();
            em.getTransaction().rollback();//Cuando se trabaja con un servidor empresarial este se encarga de hacer esto
        }
        finally{
            if(em != null){
                //em.close();//Cuando se trabaja con un servidor empresarial este se encarga de hacer esto
            }
        }

    }

    public void modificar(Persona persona){
        try {

            em.getTransaction().begin();
            em.merge(persona);
            em.getTransaction().commit();//Cuando se trabaja con un servidor empresarial este se encarga de hacer esto
        } catch (Exception e) {
            
            e.printStackTrace();
            em.getTransaction().rollback();//Cuando se trabaja con un servidor empresarial este se encarga de hacer esto
        }
        finally{
            if(em != null){
               // em.close();//Cuando se trabaja con un servidor empresarial este se encarga de hacer esto
            }
        }
    }


    public void eliminar(Persona persona){
        try {

            em.getTransaction().begin();
            em.remove(em.merge(persona));//Para poder eliminar un valor primero se debe ejecutar el metodo merge
            em.getTransaction().commit();//Cuando se trabaja con un servidor empresarial este se encarga de hacer esto
        } catch (Exception e) {
            
            e.printStackTrace();
            em.getTransaction().rollback();//Cuando se trabaja con un servidor empresarial este se encarga de hacer esto
        }
        finally{
            if(em != null){
               // em.close();//Cuando se trabaja con un servidor empresarial este se encarga de hacer esto
            }
        }
    }
    //Metodo buscar para evitar errores y hacer la app mas independiente
    public Persona buscarPersonaByID(Persona p){
        // Aqui como solo estamos haciendo un "select" de la BD no es necesario iniciar una transaccion.
        
        return em.find(Persona.class, p.getIdPersona());

        
    }

    

}
