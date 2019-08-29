/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Lenovo
 */
@Entity
@Table(name = "instancia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Instancia.findAll", query = "SELECT i FROM Instancia i")
    , @NamedQuery(name = "Instancia.findByCodInstancia", query = "SELECT i FROM Instancia i WHERE i.codInstancia = :codInstancia")
    , @NamedQuery(name = "Instancia.findByDescripcion", query = "SELECT i FROM Instancia i WHERE i.descripcion = :descripcion")
    , @NamedQuery(name = "Instancia.findByFecha", query = "SELECT i FROM Instancia i WHERE i.fecha = :fecha")})
public class Instancia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "cod instancia")
    private Integer codInstancia;
    @Basic(optional = false)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;

    public Instancia() {
    }

    public Instancia(Integer codInstancia) {
        this.codInstancia = codInstancia;
    }

    public Instancia(Integer codInstancia, String descripcion, Date fecha) {
        this.codInstancia = codInstancia;
        this.descripcion = descripcion;
        this.fecha = fecha;
    }

    public Integer getCodInstancia() {
        return codInstancia;
    }

    public void setCodInstancia(Integer codInstancia) {
        this.codInstancia = codInstancia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codInstancia != null ? codInstancia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Instancia)) {
            return false;
        }
        Instancia other = (Instancia) object;
        if ((this.codInstancia == null && other.codInstancia != null) || (this.codInstancia != null && !this.codInstancia.equals(other.codInstancia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Instancia[ codInstancia=" + codInstancia + " ]";
    }
    
}
