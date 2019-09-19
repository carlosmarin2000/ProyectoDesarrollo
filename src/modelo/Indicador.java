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
@Table(name = "indicador")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Indicador.findAll", query = "SELECT i FROM Indicador i")
    , @NamedQuery(name = "Indicador.findByCodIndicador", query = "SELECT i FROM Indicador i WHERE i.codIndicador = :codIndicador")
    , @NamedQuery(name = "Indicador.findByDescripcion", query = "SELECT i FROM Indicador i WHERE i.descripcion = :descripcion")})
public class Indicador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "codIndicador")
    private Integer codIndicador;
    @Basic(optional = false)
    @Column(name = "descripcion")
    private String descripcion;
    @JoinColumn(name = "codObj", referencedColumnName = "codObjetivo")
    @ManyToOne(optional = false)
    private Objetivo codObj;

    public Indicador() {
    }

    public Indicador(Integer codIndicador) {
        this.codIndicador = codIndicador;
    }

    public Indicador(Integer codIndicador, String descripcion) {
        this.codIndicador = codIndicador;
        this.descripcion = descripcion;
    }

    public Integer getCodIndicador() {
        return codIndicador;
    }

    public void setCodIndicador(Integer codIndicador) {
        this.codIndicador = codIndicador;
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
        hash += (codIndicador != null ? codIndicador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Indicador)) {
            return false;
        }
        Indicador other = (Indicador) object;
        if ((this.codIndicador == null && other.codIndicador != null) || (this.codIndicador != null && !this.codIndicador.equals(other.codIndicador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Indicador[ codIndicador=" + codIndicador + " ]";
    }
    
}
