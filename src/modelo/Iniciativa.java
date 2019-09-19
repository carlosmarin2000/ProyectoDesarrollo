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
@Table(name = "iniciativa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Iniciativa.findAll", query = "SELECT i FROM Iniciativa i")
    , @NamedQuery(name = "Iniciativa.findByCodIniciativa", query = "SELECT i FROM Iniciativa i WHERE i.codIniciativa = :codIniciativa")
    , @NamedQuery(name = "Iniciativa.findByDescripcion", query = "SELECT i FROM Iniciativa i WHERE i.descripcion = :descripcion")})
public class Iniciativa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "codIniciativa")
    private Integer codIniciativa;
    @Basic(optional = false)
    @Column(name = "descripcion")
    private String descripcion;
    @JoinColumn(name = "codObj", referencedColumnName = "codObjetivo")
    @ManyToOne(optional = false)
    private Objetivo codObj;

    public Iniciativa() {
    }

    public Iniciativa(Integer codIniciativa) {
        this.codIniciativa = codIniciativa;
    }

    public Iniciativa(Integer codIniciativa, String descripcion) {
        this.codIniciativa = codIniciativa;
        this.descripcion = descripcion;
    }

    public Integer getCodIniciativa() {
        return codIniciativa;
    }

    public void setCodIniciativa(Integer codIniciativa) {
        this.codIniciativa = codIniciativa;
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
        hash += (codIniciativa != null ? codIniciativa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Iniciativa)) {
            return false;
        }
        Iniciativa other = (Iniciativa) object;
        if ((this.codIniciativa == null && other.codIniciativa != null) || (this.codIniciativa != null && !this.codIniciativa.equals(other.codIniciativa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Iniciativa[ codIniciativa=" + codIniciativa + " ]";
    }
    
}
