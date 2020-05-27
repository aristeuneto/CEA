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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Cpd01
 */
@Entity
@Table(name = "tbl_turma")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ModelTurma.findAll", query = "SELECT m FROM ModelTurma m")
    , @NamedQuery(name = "ModelTurma.findByTurmaId", query = "SELECT m FROM ModelTurma m WHERE m.turmaId = :turmaId")
    , @NamedQuery(name = "ModelTurma.findByTurmaNome", query = "SELECT m FROM ModelTurma m WHERE m.turmaNome = :turmaNome")
    , @NamedQuery(name = "ModelTurma.findByTurmaDescricao", query = "SELECT m FROM ModelTurma m WHERE m.turmaDescricao = :turmaDescricao")
    , @NamedQuery(name = "ModelTurma.findByTurmaStatus", query = "SELECT m FROM ModelTurma m WHERE m.turmaStatus = :turmaStatus")})
public class ModelTurma implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "turma_id")
    private Integer turmaId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "turma_nome")
    private String turmaNome;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "turma_descricao")
    private String turmaDescricao;
    @Size(max = 20)
    @Column(name = "turma_status")
    private String turmaStatus;
    @Basic(optional = true)
    @OneToMany(mappedBy = "turmaId")
    private Collection<ModelAuxProfTurma> modelAuxProfTurmaCollection;
    @Basic(optional = true)
    @OneToMany(mappedBy = "turmaId")
    private Collection<ModelAluno> alunoCollection;
    @Basic(optional = true)
    @OneToMany(mappedBy = "turmaId")
    private Collection<ModelAuxTurmaDisc> modelAuxTurmaDiscCollection;

    public ModelTurma() {
    }

    public ModelTurma(Integer turmaId) {
        this.turmaId = turmaId;
    }

    public ModelTurma(Integer turmaId, String turmaNome, String turmaDescricao) {
        this.turmaId = turmaId;
        this.turmaNome = turmaNome;
        this.turmaDescricao = turmaDescricao;
    }

    public Integer getTurmaId() {
        return turmaId;
    }

    public void setTurmaId(Integer turmaId) {
        this.turmaId = turmaId;
    }

    public String getTurmaNome() {
        return turmaNome;
    }

    public void setTurmaNome(String turmaNome) {
        this.turmaNome = turmaNome;
    }

    public String getTurmaDescricao() {
        return turmaDescricao;
    }

    public void setTurmaDescricao(String turmaDescricao) {
        this.turmaDescricao = turmaDescricao;
    }

    public String getTurmaStatus() {
        return turmaStatus;
    }

    public void setTurmaStatus(String turmaStatus) {
        this.turmaStatus = turmaStatus;
    }

    @XmlTransient
    public Collection<ModelAuxProfTurma> getModelAuxProfTurmaCollection() {
        return modelAuxProfTurmaCollection;
    }

    public void setModelAuxProfTurmaCollection(Collection<ModelAuxProfTurma> modelAuxProfTurmaCollection) {
        this.modelAuxProfTurmaCollection = modelAuxProfTurmaCollection;
    }

    @XmlTransient
    public Collection<ModelAluno> getAlunoCollection() {
        return alunoCollection;
    }

    public void setAlunoCollection(Collection<ModelAluno> alunoCollection) {
        this.alunoCollection = alunoCollection;
    }

    @XmlTransient
    public Collection<ModelAuxTurmaDisc> getModelAuxTurmaDiscCollection() {
        return modelAuxTurmaDiscCollection;
    }

    public void setModelAuxTurmaDiscCollection(Collection<ModelAuxTurmaDisc> modelAuxTurmaDiscCollection) {
        this.modelAuxTurmaDiscCollection = modelAuxTurmaDiscCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (turmaId != null ? turmaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ModelTurma)) {
            return false;
        }
        ModelTurma other = (ModelTurma) object;
        if ((this.turmaId == null && other.turmaId != null) || (this.turmaId != null && !this.turmaId.equals(other.turmaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.ModelTurma[ turmaId=" + turmaId + " ]";
    }

}
