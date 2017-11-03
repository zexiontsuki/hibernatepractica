/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbm;

import org.hibernate.Session;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author RigoBono
 */
public class HibernateUtil {

    private static final SessionFactory sessionFactory; //se crea una variable tipo final que no puede ser modificada
    private static final ThreadLocal localSession; // se crea un hilo local del tipo final de la sesion local
    
    static {
        try {
           Configuration config = new Configuration(); //se crea un objeto tipo configuracion 
            config.configure("hibernate.cfg.xml");//se le ingresa al objeto config la configuracion de hibernate.cfg.xml
            StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder(). 
// se crea un bjeto y se  contextualiza la sesion factory mediante un objeto 
            applySettings(config.getProperties());// las aplicaciones settings configura las propiedades y las entrega 
            sessionFactory = config.buildSessionFactory(builder.build());
        } catch (Throwable ex) {
            // Log the exception. 
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
        localSession = new ThreadLocal(); // para una sesion local creo nuevo hilo 
    }
    
    public static SessionFactory getSessionFactory() {// creas una interfaz tipo sessionfactory
        return sessionFactory;// retorna la session 
    }
    
     public static Session getLocalSession() { // se crea una interfaz del tipo sesion 
        Session session = (Session) localSession.get(); // se crea un objeto tipo session y se castea ademas se le agrega la sesion local y se puede entregar
        if (session == null) { // si la sesion es igual null 
            session = sessionFactory.openSession();//se asigna la sesion local en una sesion abierta
            localSession.set(session); // la sesion local se entrega 
            System.out.println("\nsesion iniciada"); // imprime inicio de sesion
        }
        return session; // regresa session 
    }
     
     public static void closeLocalSession() { // un metodo para cerrar la sesion 
        Session session = (Session) localSession.get(); // la sesion del tipo sesion se castea y envia
        if (session != null) session.close(); // si la session es igual o diferente a null se debe cerrar
        localSession.set(null); // se enviara null
        System.out.println("sesion cerrada\n"); // la sesion fue cerrada 
    }
}
