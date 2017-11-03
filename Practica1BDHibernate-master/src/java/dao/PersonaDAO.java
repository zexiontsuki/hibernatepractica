/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import hbm.HibernateUtil; // IMPORTA EL HIBERNATE UTIL 
import java.util.List; // JAVALIST  
import org.hibernate.Session; // IMPORTA ALGO PAQUETE DE SESION
import org.hibernate.Transaction; // IMPORTA PAQUETE DE TRANSACCION
import org.hibernate.criterion.Restrictions; // IMPORTA DE CRITERIO RESTRICCIONS
import pojo.Persona; // TRAE EL PAQUETE DE POJO .PERSONA
import pojo.TipoPersona; //TRAE DEL PAQUETE POJO.TIPO PERSONA 

/**
 *
 * @author RigoBono
 */
public class PersonaDAO { // esta es la clase publica persona DAO Data Acces Object
    Session session; //se importa un objeto sesion del tipo sesion del tipo usuario
    
    public PersonaDAO(){ //persona dao trae de sesion con me dio del get la sesion en la que esta 
        session=HibernateUtil.getLocalSession();
    }
    
    public  Persona getPersonaById(int id){ //aqui extrae de persona id por medio del get 
        return (Persona)session.load(Persona.class, id); // aqui debe entregar cual persona la secion cargada y el id
    }
    
    public List<Persona>  getPersonaByName(String nombre){ //  se crea una lista de tipo persona ademas aqui extrae de la lista persona el nombre de la persona del tipo string name
        List<Persona> listaDePersonas=(List<Persona>) //en la lista persona se crea la lista de personas  la cual esta dentro de una sesion yse castea el dato y cambiarlo
                session.createCriteria(Persona.class) // de la sesion que fue creada, crea un criterio en persona ..class
                .add(Restrictions.eq("Nombre", nombre)); //añade si en las restricciones es igual a nombre cambia nombre
        return listaDePersonas; // y lo retorna a lista de personas.
    }
    
    public boolean updateById(int id,Persona persona){ //del tipo boolean si hay un update entra en el id de persona 
        Persona personaAModificar=getPersonaById(id); // persona  a persona modifica es igual  saca el id de esa persona 
        try{ //intenta 
            Transaction transaccion=session.beginTransaction(); // de la transaccion verifica la sesion y inicia la transanccion
            personaAModificar.setNombre(persona.getNombre()); //saca el nombre de la persona a modificar 
            session.update(personaAModificar); // se hace un update en la persona a modificar.
            transaccion.commit(); //es la verificacion para cambiar la transaccion 
            return true; // retorna verdadero
        }catch(Exception e){ // si es una excepcion del tipo e
            return false; // regresa falso
        }
    }
    
    public boolean savePersona(String nombre,String materno,String paterno,String telefono,int idTipoPersona){
   // aqui es el metodo salvar persona entraran las variables tipo cadenas de nombre , materno , paeterno , telefono y el entero de un id del tipo de persona  
        
        Persona personaDeTanque=new Persona(); //aqui hacemos un objeto tipo persona del tipo persona tanque
        TipoPersona tipoDeTanque=(TipoPersona)session.load(TipoPersona.class, idTipoPersona); // la persona del tipo tanque tendra una sesion de la clase tipo persona y un id de tipo persona
        personaDeTanque.setNombre(nombre);//aqui envia de persona tanque el nombre con el metodo set
        personaDeTanque.setMaterno(materno); //aqui envia de persona tanque elapellido materno con el metodo set
        personaDeTanque.setPaterno(paterno); //aqui envia de persona tanque el apellido paterno con el metodo set
        personaDeTanque.setTelefono(telefono); //aqui envia de persona tanque el telefono con el metodo set
        personaDeTanque.setTipoPersona(tipoDeTanque); //aqui envia de persona tanque el tipo de persona y el tipo de tanque metodo set
        try{ //intenta 
            Transaction transaccion=session.beginTransaction(); // si la transaccion esta en la sesion inicia la transaccion
            session.save(personaDeTanque);// la sesion graba en persona tanque 
            transaccion.commit(); // la verificacion para finalizar la transaccion
            return true; // si es igual a verdadero 
        }catch(Exception e){ //si es excepcion e hacer
            
        }finally{ //finalmente
            
        }
        return true; //retorna verdad 
    }
    
}
