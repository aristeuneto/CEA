/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author neto_
 */
@Entity
@Table(name = "tbl_professor")
/*@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ModelProfessor.findAll", query = "SELECT p FROM ModelProfessor p")
    , @NamedQuery(name = "ModelProfessor.findByPesId", query = "SELECT p FROM ModelProfessor p WHERE p.pesId = :pesId")
    , @NamedQuery(name = "ModelProfessor.findByProfStatus", query = "SELECT p FROM ModelProfessor p WHERE p.profStatus = :profStatus")})*/
@PrimaryKeyJoinColumn(name = "pes_id")
public class ModelProfessor extends ModelPessoa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pes_id")
    private Integer pesId;
    @OneToMany(mappedBy = "pesId")
    private Collection<ModelAuxProfDisc> modelAuxProfDiscCollection;
    @OneToMany(mappedBy = "pesId")
    private Collection<ModelAuxProfTurma> modelAuxProfTurmaCollection;
    @JoinColumn(name = "pes_id", referencedColumnName = "pes_id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private ModelPessoa pessoa;
    @OneToMany(mappedBy = "pesId")
    private Collection<ModelAcesso> modelAcessoCollection;

    @Size(max = 20)
    @Column(name = "prof_status")
    private String profStatus;
    @OneToMany(mappedBy = "pesId")
    private Collection<ModelAuxProfDisc> auxProfDiscCollection;
    @OneToMany(mappedBy = "pesId")
    private Collection<ModelAuxProfTurma> auxProfTurmaCollection;
    @OneToMany(mappedBy = "pesId")
    private Collection<ModelAcesso> acessoCollection;

    public ModelProfessor() {
    }

    public String getProfStatus() {
        return profStatus;
    }

    public void setProfStatus(String profStatus) {
        this.profStatus = profStatus;
    }

    @XmlTransient
    public Collection<ModelAuxProfDisc> getAuxProfDiscCollection() {
        return auxProfDiscCollection;
    }

    public void setAuxProfDiscCollection(Collection<ModelAuxProfDisc> auxProfDiscCollection) {
        this.auxProfDiscCollection = auxProfDiscCollection;
    }

    @XmlTransient
    public Collection<ModelAuxProfTurma> getAuxProfTurmaCollection() {
        return auxProfTurmaCollection;
    }

    public void setAuxProfTurmaCollection(Collection<ModelAuxProfTurma> auxProfTurmaCollection) {
        this.auxProfTurmaCollection = auxProfTurmaCollection;
    }

    @XmlTransient
    public Collection<ModelAcesso> getAcessoCollection() {
        return acessoCollection;
    }

    public void setAcessoCollection(Collection<ModelAcesso> acessoCollection) {
        this.acessoCollection = acessoCollection;
    }

    public ModelProfessor(Integer pesId) {
        this.pesId = pesId;
    }

    public Integer getPesId() {
        return pesId;
    }

    public void setPesId(Integer pesId) {
        this.pesId = pesId;
    }

    @XmlTransient
    public Collection<ModelAuxProfDisc> getModelAuxProfDiscCollection() {
        return modelAuxProfDiscCollection;
    }

    public void setModelAuxProfDiscCollection(Collection<ModelAuxProfDisc> modelAuxProfDiscCollection) {
        this.modelAuxProfDiscCollection = modelAuxProfDiscCollection;
    }

    @XmlTransient
    public Collection<ModelAuxProfTurma> getModelAuxProfTurmaCollection() {
        return modelAuxProfTurmaCollection;
    }

    public void setModelAuxProfTurmaCollection(Collection<ModelAuxProfTurma> modelAuxProfTurmaCollection) {
        this.modelAuxProfTurmaCollection = modelAuxProfTurmaCollection;
    }

    public ModelPessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(ModelPessoa pessoa) {
        this.pessoa = pessoa;
    }

    @XmlTransient
    public Collection<ModelAcesso> getModelAcessoCollection() {
        return modelAcessoCollection;
    }

    public void setModelAcessoCollection(Collection<ModelAcesso> modelAcessoCollection) {
        this.modelAcessoCollection = modelAcessoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pesId != null ? pesId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ModelProfessor)) {
            return false;
        }
        ModelProfessor other = (ModelProfessor) object;
        if ((this.pesId == null && other.pesId != null) || (this.pesId != null && !this.pesId.equals(other.pesId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Professor[ pesId=" + pesId + " ]";
    }
    
}
