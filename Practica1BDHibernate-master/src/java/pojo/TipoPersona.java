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
import javax.persistence.Table;

/**
 *  #Pray4Tanque
 * @author RigoBono
 */
@Entity // le decias a tipo persona que es un tabla de base de datos 
@Table(name="TipoPersona", catalog="generationHibernate") // la tabla tipo persona dentro del catalogo generation hibernate
public class TipoPersona { // aqui tenemos la clase tipo persona 
    
    @Id @GeneratedValue // aqui decimos que este es la llave primaria con id y alto incrementable
    @Column(name="idTipoPersona") // la columna id tipo persona 
    private int idTipoPersona; // attributo idtipo persona 
    
     @Column(name="TipoPersonacol") //la columna id tipo persona col
    private String TipoPersona;// attributo tipo persona 
     
     public TipoPersona(){ // clase constructora vacia
         
     }
     

    /**
     * @return the idTipoPersona
     */
    public int getIdTipoPersona() {
        return idTipoPersona;
    }

    /**
     * @param idTipoPersona the idTipoPersona to set
     */
    public void setIdTipoPersona(int idTipoPersona) {
        this.idTipoPersona = idTipoPersona;
    }

    /**
     * @return the TipoPersona
     */
    public String getTipoPersona() {
        return TipoPersona;
    }

    /**
     * @param TipoPersona the TipoPersona to set
     */
    public void setTipoPersona(String TipoPersona) {
        this.TipoPersona = TipoPersona;
    }
     
     
     
     
    
}
