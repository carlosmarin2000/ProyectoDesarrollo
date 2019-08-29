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
@Table(name = "meta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Meta.findAll", query = "SELECT m FROM Meta m")
    , @NamedQuery(name = "Meta.findByCodigoMeta", query = "SELECT m FROM Meta m WHERE m.codigoMeta = :codigoMeta")
    , @NamedQuery(name = "Meta.findByDescripcion", query = "SELECT m FROM Meta m WHERE m.descripcion = :descripcion")
    , @NamedQuery(name = "Meta.findByFecha", query = "SELECT m FROM Meta m WHERE m.fecha = :fecha")})
public class Meta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "codigo meta")
    private Integer codigoMeta;
    @Basic(optional = false)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;

    public Meta() {
    }

    public Meta(Integer codigoMeta) {
        this.codigoMeta = codigoMeta;
    }

    public Meta(Integer codigoMeta, String descripcion, Date fecha) {
        this.codigoMeta = codigoMeta;
        this.descripcion = descripcion;
        this.fecha = fecha;
    }

    public Integer getCodigoMeta() {
        return codigoMeta;
    }

    public void setCodigoMeta(Integer codigoMeta) {
        this.codigoMeta = codigoMeta;
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
        hash += (codigoMeta != null ? codigoMeta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Meta)) {
            return false;
        }
        Meta other = (Meta) object;
        if ((this.codigoMeta == null && other.codigoMeta != null) || (this.codigoMeta != null && !this.codigoMeta.equals(other.codigoMeta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Meta[ codigoMeta=" + codigoMeta + " ]";
    }
    
}
