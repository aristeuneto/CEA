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
 * @author Cpd01
 */
@Entity
@Table(name = "tbl_aux_bole_disc")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ModelAuxBoleDisc.findAll", query = "SELECT m FROM ModelAuxBoleDisc m")
    , @NamedQuery(name = "ModelAuxBoleDisc.findByAuxId", query = "SELECT m FROM ModelAuxBoleDisc m WHERE m.auxId = :auxId")})
public class ModelAuxBoleDisc implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "aux_id")
    private Integer auxId;
    @JoinColumn(name = "bole_id", referencedColumnName = "bole_id")
    @ManyToOne
    private ModelBoletim boleId;
    @JoinColumn(name = "disc_id", referencedColumnName = "disc_id")
    @ManyToOne
    private ModelDisciplina discId;

    public ModelAuxBoleDisc() {
    }

    public ModelAuxBoleDisc(Integer auxId) {
        this.auxId = auxId;
    }

    public Integer getAuxId() {
        return auxId;
    }

    public void setAuxId(Integer auxId) {
        this.auxId = auxId;
    }

    public ModelBoletim getBoleId() {
        return boleId;
    }

    public void setBoleId(ModelBoletim boleId) {
        this.boleId = boleId;
    }

    public ModelDisciplina getDiscId() {
        return discId;
    }

    public void setDiscId(ModelDisciplina discId) {
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
        if (!(object instanceof ModelAuxBoleDisc)) {
            return false;
        }
        ModelAuxBoleDisc other = (ModelAuxBoleDisc) object;
        if ((this.auxId == null && other.auxId != null) || (this.auxId != null && !this.auxId.equals(other.auxId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.ModelAuxBoleDisc[ auxId=" + auxId + " ]";
    }
    
}
