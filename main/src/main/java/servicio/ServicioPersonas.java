package servicio;

import java.util.List;

import DAO.PersonaDao;
import domain.Persona;

public class ServicioPersonas {

    private PersonaDao personaDao;

    
    
    public ServicioPersonas() {
        this.personaDao=new PersonaDao();
    }



    public List<Persona> listarPersonas(){
        

        return this.personaDao.listar();
        
        
    }
}
