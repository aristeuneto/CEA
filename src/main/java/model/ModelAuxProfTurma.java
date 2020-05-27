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
@Table(name = "tbl_aux_prof_turma")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ModelAuxProfTurma.findAll", query = "SELECT m FROM ModelAuxProfTurma m")
    , @NamedQuery(name = "ModelAuxProfTurma.findByAuxId", query = "SELECT m FROM ModelAuxProfTurma m WHERE m.auxId = :auxId")})
public class ModelAuxProfTurma implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "aux_id")
    private Integer auxId;
    @JoinColumn(name = "pes_id", referencedColumnName = "pes_id")
    @ManyToOne
    private ModelProfessor pesId;
    @JoinColumn(name = "turma_id", referencedColumnName = "turma_id")
    @ManyToOne
    private ModelTurma turmaId;

    public ModelAuxProfTurma() {
    }

    public ModelAuxProfTurma(Integer auxId) {
        this.auxId = auxId;
    }

    public Integer getAuxId() {
        return auxId;
    }

    public void setAuxId(Integer auxId) {
        this.auxId = auxId;
    }

    public ModelProfessor getPesId() {
        return pesId;
    }

    public void setPesId(ModelProfessor pesId) {
        this.pesId = pesId;
    }

    public ModelTurma getTurmaId() {
        return turmaId;
    }

    public void setTurmaId(ModelTurma turmaId) {
        this.turmaId = turmaId;
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
        if (!(object instanceof ModelAuxProfTurma)) {
            return false;
        }
        ModelAuxProfTurma other = (ModelAuxProfTurma) object;
        if ((this.auxId == null && other.auxId != null) || (this.auxId != null && !this.auxId.equals(other.auxId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.ModelAuxProfTurma[ auxId=" + auxId + " ]";
    }
    
}
