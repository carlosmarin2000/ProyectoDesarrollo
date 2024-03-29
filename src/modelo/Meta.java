/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
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
    , @NamedQuery(name = "Meta.findByDescripcion", query = "SELECT m FROM Meta m WHERE m.descripcion = :descripcion")})
public class Meta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "codigoMeta")
    private Integer codigoMeta;
    @Basic(optional = false)
    @Column(name = "descripcion")
    private String descripcion;
    @JoinColumn(name = "codObj", referencedColumnName = "codObjetivo")
    @ManyToOne(optional = false)
    private Objetivo codObj;

    public Meta() {
    }

    public Meta(Integer codigoMeta) {
        this.codigoMeta = codigoMeta;
    }

    public Meta(Integer codigoMeta, String descripcion) {
        this.codigoMeta = codigoMeta;
        this.descripcion = descripcion;
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

    public Objetivo getCodObj() {
        return codObj;
    }

    public void setCodObj(Objetivo codObj) {
        this.codObj = codObj;
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
