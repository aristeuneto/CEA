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
@Table(name = "tbl_disciplina")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ModelDisciplina.findAll", query = "SELECT m FROM ModelDisciplina m")
    , @NamedQuery(name = "ModelDisciplina.findByDiscId", query = "SELECT m FROM ModelDisciplina m WHERE m.discId = :discId")
    , @NamedQuery(name = "ModelDisciplina.findByDiscNome", query = "SELECT m FROM ModelDisciplina m WHERE m.discNome = :discNome")
    , @NamedQuery(name = "ModelDisciplina.findByDiscDesc", query = "SELECT m FROM ModelDisciplina m WHERE m.discDesc = :discDesc")
    , @NamedQuery(name = "ModelDisciplina.findByDiscCarga", query = "SELECT m FROM ModelDisciplina m WHERE m.discCarga = :discCarga")
    , @NamedQuery(name = "ModelDisciplina.findByDiscStatus", query = "SELECT m FROM ModelDisciplina m WHERE m.discStatus = :discStatus")})
public class ModelDisciplina implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "disc_id")
    private Integer discId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "disc_nome")
    private String discNome;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "disc_desc")
    private String discDesc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "disc_carga")
    private int discCarga;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "disc_status")
    private String discStatus;
    @OneToMany(mappedBy = "discId")
    private Collection<ModelAuxBoleDisc> modelAuxBoleDiscCollection;
    @OneToMany(mappedBy = "discId")
    private Collection<ModelAuxProfDisc> modelAuxProfDiscCollection;
    @OneToMany(mappedBy = "discId")
    private Collection<ModelAuxTurmaDisc> modelAuxTurmaDiscCollection;

    public ModelDisciplina() {
    }

    public ModelDisciplina(Integer discId) {
        this.discId = discId;
    }

    public ModelDisciplina(Integer discId, String discNome, String discDesc, int discCarga, String discStatus) {
        this.discId = discId;
        this.discNome = discNome;
        this.discDesc = discDesc;
        this.discCarga = discCarga;
        this.discStatus = discStatus;
    }

    public Integer getDiscId() {
        return discId;
    }

    public void setDiscId(Integer discId) {
        this.discId = discId;
    }

    public String getDiscNome() {
        return discNome;
    }

    public void setDiscNome(String discNome) {
        this.discNome = discNome;
    }

    public String getDiscDesc() {
        return discDesc;
    }

    public void setDiscDesc(String discDesc) {
        this.discDesc = discDesc;
    }

    public int getDiscCarga() {
        return discCarga;
    }

    public void setDiscCarga(int discCarga) {
        this.discCarga = discCarga;
    }

    public String getDiscStatus() {
        return discStatus;
    }

    public void setDiscStatus(String discStatus) {
        this.discStatus = discStatus;
    }

    @XmlTransient
    public Collection<ModelAuxBoleDisc> getModelAuxBoleDiscCollection() {
        return modelAuxBoleDiscCollection;
    }

    public void setModelAuxBoleDiscCollection(Collection<ModelAuxBoleDisc> modelAuxBoleDiscCollection) {
        this.modelAuxBoleDiscCollection = modelAuxBoleDiscCollection;
    }

    @XmlTransient
    public Collection<ModelAuxProfDisc> getModelAuxProfDiscCollection() {
        return modelAuxProfDiscCollection;
    }

    public void setModelAuxProfDiscCollection(Collection<ModelAuxProfDisc> modelAuxProfDiscCollection) {
        this.modelAuxProfDiscCollection = modelAuxProfDiscCollection;
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
        hash += (discId != null ? discId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ModelDisciplina)) {
            return false;
        }
        ModelDisciplina other = (ModelDisciplina) object;
        if ((this.discId == null && other.discId != null) || (this.discId != null && !this.discId.equals(other.discId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.ModelDisciplina[ discId=" + discId + " ]";
    }
    
}
