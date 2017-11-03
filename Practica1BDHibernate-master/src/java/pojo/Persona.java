/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author RigoBono
 */

@Entity // le decias a persona que es una entidad de base de datos

@Table(name="Persona",catalog="generationHibernate") //en la tabla persona de el catalogo generationhibernate (en mysql)
public class Persona { //creas una class persona 
    
    @Id @GeneratedValue //designas la llvae primaria con id y es autogenerativa 
    @Column(name="idPersona") // aqui decimos qu e la columna con el nombre id persona
    private int idPersona; // es un atributo privado del tipo entero id
    
    @Column(name="Nombre",nullable=true) // en la column con el nombre nombre y puede ser null
    private String Nombre; // se crea un atributo de cadena nombre 
    
    @Column(name="Paterno") // en la columna con el nombre paterno
    private String Paterno; // se crea un atributo de cadena paterno 
    
     @Column(name="Materno") // en la columna con el nombre materno
    private String Materno; // se crea un atributo de cadena Materno
     
     @Column(name="Telefono") // en la columna con el nombre telefono
    private String Telefono; // se crea un atributo de cadena telefono
    
     @ManyToOne // aqui decimos que esta tabla va de varios datos a uno solo 
     @JoinColumn(name="idTipoPersona") //llave foranea para ide tipo persona 
    private TipoPersona tipoPersona; // de la clase privada tipo persona y tipo persona 

    /**
     * @return the idPersona
     */
    public int getIdPersona() {
        return idPersona;
    }

    /**
     * @param idPersona the idPersona to set
     */
    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    /**
     * @return the Nombre
     */
    public String getNombre() {
        return Nombre;
    }

    /**
     * @param Nombre the Nombre to set
     */
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    /**
     * @return the Paterno
     */
    public String getPaterno() {
        return Paterno;
    }

    /**
     * @param Paterno the Paterno to set
     */
    public void setPaterno(String Paterno) {
        this.Paterno = Paterno;
    }

    /**
     * @return the Materno
     */
    public String getMaterno() {
        return Materno;
    }

    /**
     * @param Materno the Materno to set
     */
    public void setMaterno(String Materno) {
        this.Materno = Materno;
    }

    /**
     * @return the Telefono
     */
    public String getTelefono() {
        return Telefono;
    }

    /**
     * @param Telefono the Telefono to set
     */
    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    /**
     * @return the tipoPersona
     */
    public TipoPersona getTipoPersona() {
        return tipoPersona;
    }

    /**
     * @param tipoPersona the tipoPersona to set
     */
    public void setTipoPersona(TipoPersona tipoPersona) {
        this.tipoPersona = tipoPersona;
    }
     
     
    
}
