/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author neto_
 */
@Entity
@Table(name = "tbl_aux_bole_disc")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AuxBoleDisc.findAll", query = "SELECT a FROM AuxBoleDisc a")
    , @NamedQuery(name = "AuxBoleDisc.findByAuxId", query = "SELECT a FROM AuxBoleDisc a WHERE a.auxId = :auxId")})
public class AuxBoleDisc implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "aux_id")
    private Integer auxId;
    @JoinColumn(name = "bole_id", referencedColumnName = "bole_id")
    @ManyToOne
    private Boletim boleId;
    @JoinColumn(name = "disc_id", referencedColumnName = "disc_id")
    @ManyToOne
    private Disciplina discId;

    public AuxBoleDisc() {
    }

    public AuxBoleDisc(Integer auxId) {
        this.auxId = auxId;
    }

    public Integer getAuxId() {
        return auxId;
    }

    public void setAuxId(Integer auxId) {
        this.auxId = auxId;
    }

    public Boletim getBoleId() {
        return boleId;
    }

    public void setBoleId(Boletim boleId) {
        this.boleId = boleId;
    }

    public Disciplina getDiscId() {
        return discId;
    }

    public void setDiscId(Disciplina discId) {
        this.discId = discId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (auxId != null ? auxId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AuxBoleDisc)) {
            return false;
        }
        AuxBoleDisc other = (AuxBoleDisc) object;
        if ((this.auxId == null && other.auxId != null) || (this.auxId != null && !this.auxId.equals(other.auxId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.AuxBoleDisc[ auxId=" + auxId + " ]";
    }
    
}
