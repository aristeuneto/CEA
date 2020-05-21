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
 * @author neto_
 */
@Entity
@Table(name = "tbl_disciplina")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Disciplina.findAll", query = "SELECT d FROM Disciplina d")
    , @NamedQuery(name = "Disciplina.findByDiscId", query = "SELECT d FROM Disciplina d WHERE d.discId = :discId")
    , @NamedQuery(name = "Disciplina.findByDiscNome", query = "SELECT d FROM Disciplina d WHERE d.discNome = :discNome")
    , @NamedQuery(name = "Disciplina.findByDiscDesc", query = "SELECT d FROM Disciplina d WHERE d.discDesc = :discDesc")
    , @NamedQuery(name = "Disciplina.findByDiscCarga", query = "SELECT d FROM Disciplina d WHERE d.discCarga = :discCarga")
    , @NamedQuery(name = "Disciplina.findByDiscStatus", query = "SELECT d FROM Disciplina d WHERE d.discStatus = :discStatus")})
public class Disciplina implements Serializable {

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
    private Collection<AuxBoleDisc> auxBoleDiscCollection;
    @OneToMany(mappedBy = "discId")
    private Collection<AuxProfDisc> auxProfDiscCollection;
    @OneToMany(mappedBy = "discId")
    private Collection<AuxTurmaDisc> auxTurmaDiscCollection;

    public Disciplina() {
    }

    public Disciplina(Integer discId) {
        this.discId = discId;
    }

    public Disciplina(Integer discId, String discNome, String discDesc, int discCarga, String discStatus) {
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
    public Collection<AuxBoleDisc> getAuxBoleDiscCollection() {
        return auxBoleDiscCollection;
    }

    public void setAuxBoleDiscCollection(Collection<AuxBoleDisc> auxBoleDiscCollection) {
        this.auxBoleDiscCollection = auxBoleDiscCollection;
    }

    @XmlTransient
    public Collection<AuxProfDisc> getAuxProfDiscCollection() {
        return auxProfDiscCollection;
    }

    public void setAuxProfDiscCollection(Collection<AuxProfDisc> auxProfDiscCollection) {
        this.auxProfDiscCollection = auxProfDiscCollection;
    }

    @XmlTransient
    public Collection<AuxTurmaDisc> getAuxTurmaDiscCollection() {
        return auxTurmaDiscCollection;
    }

    public void setAuxTurmaDiscCollection(Collection<AuxTurmaDisc> auxTurmaDiscCollection) {
        this.auxTurmaDiscCollection = auxTurmaDiscCollection;
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
        if (!(object instanceof Disciplina)) {
            return false;
        }
        Disciplina other = (Disciplina) object;
        if ((this.discId == null && other.discId != null) || (this.discId != null && !this.discId.equals(other.discId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Disciplina[ discId=" + discId + " ]";
    }
    
}
