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
@Table(name = "tbl_turma")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Turma.findAll", query = "SELECT t FROM Turma t")
    , @NamedQuery(name = "Turma.findByTurmaId", query = "SELECT t FROM Turma t WHERE t.turmaId = :turmaId")
    , @NamedQuery(name = "Turma.findByTurmaNome", query = "SELECT t FROM Turma t WHERE t.turmaNome = :turmaNome")
    , @NamedQuery(name = "Turma.findByTurmaDescricao", query = "SELECT t FROM Turma t WHERE t.turmaDescricao = :turmaDescricao")
    , @NamedQuery(name = "Turma.findByTurmaStatus", query = "SELECT t FROM Turma t WHERE t.turmaStatus = :turmaStatus")})
public class Turma implements Serializable {

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
    @OneToMany(mappedBy = "turmaId")
    private Collection<AuxProfTurma> auxProfTurmaCollection;
    @OneToMany(mappedBy = "turmaId")
    private Collection<Aluno> alunoCollection;
    @OneToMany(mappedBy = "turmaId")
    private Collection<AuxTurmaDisc> auxTurmaDiscCollection;

    public Turma() {
    }

    public Turma(Integer turmaId) {
        this.turmaId = turmaId;
    }

    public Turma(Integer turmaId, String turmaNome, String turmaDescricao) {
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
    public Collection<AuxProfTurma> getAuxProfTurmaCollection() {
        return auxProfTurmaCollection;
    }

    public void setAuxProfTurmaCollection(Collection<AuxProfTurma> auxProfTurmaCollection) {
        this.auxProfTurmaCollection = auxProfTurmaCollection;
    }

    @XmlTransient
    public Collection<Aluno> getAlunoCollection() {
        return alunoCollection;
    }

    public void setAlunoCollection(Collection<Aluno> alunoCollection) {
        this.alunoCollection = alunoCollection;
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
        hash += (turmaId != null ? turmaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Turma)) {
            return false;
        }
        Turma other = (Turma) object;
        if ((this.turmaId == null && other.turmaId != null) || (this.turmaId != null && !this.turmaId.equals(other.turmaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Turma[ turmaId=" + turmaId + " ]";
    }
    
}
