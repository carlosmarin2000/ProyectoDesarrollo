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
@Table(name = "indicador")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Indicador.findAll", query = "SELECT i FROM Indicador i")
    , @NamedQuery(name = "Indicador.findByCodigoIndicador", query = "SELECT i FROM Indicador i WHERE i.codigoIndicador = :codigoIndicador")
    , @NamedQuery(name = "Indicador.findByDescripcion", query = "SELECT i FROM Indicador i WHERE i.descripcion = :descripcion")
    , @NamedQuery(name = "Indicador.findByFecha", query = "SELECT i FROM Indicador i WHERE i.fecha = :fecha")})
public class Indicador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "codigo indicador")
    private Integer codigoIndicador;
    @Basic(optional = false)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;

    public Indicador() {
    }

    public Indicador(Integer codigoIndicador) {
        this.codigoIndicador = codigoIndicador;
    }

    public Indicador(Integer codigoIndicador, String descripcion, Date fecha) {
        this.codigoIndicador = codigoIndicador;
        this.descripcion = descripcion;
        this.fecha = fecha;
    }

    public Integer getCodigoIndicador() {
        return codigoIndicador;
    }

    public void setCodigoIndicador(Integer codigoIndicador) {
        this.codigoIndicador = codigoIndicador;
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
        hash += (codigoIndicador != null ? codigoIndicador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Indicador)) {
            return false;
        }
        Indicador other = (Indicador) object;
        if ((this.codigoIndicador == null && other.codigoIndicador != null) || (this.codigoIndicador != null && !this.codigoIndicador.equals(other.codigoIndicador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Indicador[ codigoIndicador=" + codigoIndicador + " ]";
    }
    
}
