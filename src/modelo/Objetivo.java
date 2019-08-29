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
@Table(name = "objetivo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Objetivo.findAll", query = "SELECT o FROM Objetivo o")
    , @NamedQuery(name = "Objetivo.findByCodObjetivo", query = "SELECT o FROM Objetivo o WHERE o.codObjetivo = :codObjetivo")
    , @NamedQuery(name = "Objetivo.findByDescripcion", query = "SELECT o FROM Objetivo o WHERE o.descripcion = :descripcion")
    , @NamedQuery(name = "Objetivo.findByFecha", query = "SELECT o FROM Objetivo o WHERE o.fecha = :fecha")})
public class Objetivo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "cod objetivo")
    private String codObjetivo;
    @Basic(optional = false)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;

    public Objetivo() {
    }

    public Objetivo(String codObjetivo) {
        this.codObjetivo = codObjetivo;
    }

    public Objetivo(String codObjetivo, String descripcion, Date fecha) {
        this.codObjetivo = codObjetivo;
        this.descripcion = descripcion;
        this.fecha = fecha;
    }

    public String getCodObjetivo() {
        return codObjetivo;
    }

    public void setCodObjetivo(String codObjetivo) {
        this.codObjetivo = codObjetivo;
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
        hash += (codObjetivo != null ? codObjetivo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Objetivo)) {
            return false;
        }
        Objetivo other = (Objetivo) object;
        if ((this.codObjetivo == null && other.codObjetivo != null) || (this.codObjetivo != null && !this.codObjetivo.equals(other.codObjetivo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Objetivo[ codObjetivo=" + codObjetivo + " ]";
    }
    
}
