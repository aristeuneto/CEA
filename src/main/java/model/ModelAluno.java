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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author neto_
 */
@Entity
@Table(name = "tbl_aluno")
/*@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ModelAluno.findAll", query = "SELECT a FROM ModelAluno a")
    , @NamedQuery(name = "ModelAluno.findByPesId", query = "SELECT a FROM ModelAluno a WHERE a.pesId = :pesId")
    , @NamedQuery(name = "ModelAluno.findByAluEscolaOrigem", query = "SELECT a FROM ModelAluno a WHERE a.aluEscolaOrigem = :aluEscolaOrigem")
    , @NamedQuery(name = "ModelAluno.findByAluObs", query = "SELECT a FROM ModelAluno a WHERE a.aluObs = :aluObs")
    , @NamedQuery(name = "ModelAluno.findByAluStatus", query = "SELECT a FROM ModelAluno a WHERE a.aluStatus = :aluStatus")})*/
@PrimaryKeyJoinColumn(name = "pes_id")
public class ModelAluno extends ModelPessoa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pes_id")
    private Integer pesId;
    @OneToMany(mappedBy = "pesId")
    private Collection<ModelBoletim> modelBoletimCollection;
    @JoinColumn(name = "pes_id", referencedColumnName = "pes_id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private ModelPessoa pessoa;
    @OneToMany(mappedBy = "pesId")
    private Collection<ModelMatricula> modelMatriculaCollection;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "alu_escola_origem")
    private String aluEscolaOrigem;
    @Size(max = 500)
    @Column(name = "alu_obs")
    private String aluObs;
    @Size(max = 20)
    @Column(name = "alu_status")
    private String aluStatus;
    @OneToMany(mappedBy = "pesId")
    private Collection<ModelBoletim> boletimCollection;
   /* @JoinColumn(name = "pes_id", referencedColumnName = "pes_id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private ModelPessoa pessoa;*/
    @JoinColumn(name = "turma_id", referencedColumnName = "turma_id")
    @ManyToOne
    private ModelTurma turmaId;
    @OneToMany(mappedBy = "pesId")
    private Collection<ModelMatricula> matriculaCollection;

    public ModelAluno() {
    }

    public String getAluEscolaOrigem() {
        return aluEscolaOrigem;
    }

    public void setAluEscolaOrigem(String aluEscolaOrigem) {
        this.aluEscolaOrigem = aluEscolaOrigem;
    }

    public String getAluObs() {
        return aluObs;
    }

    public void setAluObs(String aluObs) {
        this.aluObs = aluObs;
    }

    public String getAluStatus() {
        return aluStatus;
    }

    public void setAluStatus(String aluStatus) {
        this.aluStatus = aluStatus;
    }

    @XmlTransient
    public Collection<ModelBoletim> getBoletimCollection() {
        return boletimCollection;
    }

    public void setBoletimCollection(Collection<ModelBoletim> boletimCollection) {
        this.boletimCollection = boletimCollection;
    }

    public ModelTurma getTurmaId() {
        return turmaId;
    }

    public void setTurmaId(ModelTurma turmaId) {
        this.turmaId = turmaId;
    }

    @XmlTransient
    public Collection<ModelMatricula> getMatriculaCollection() {
        return matriculaCollection;
    }

    public void setMatriculaCollection(Collection<ModelMatricula> matriculaCollection) {
        this.matriculaCollection = matriculaCollection;
    }

    public ModelAluno(Integer pesId) {
        this.pesId = pesId;
    }

    public Integer getPesId() {
        return pesId;
    }

    public void setPesId(Integer pesId) {
        this.pesId = pesId;
    }

    @XmlTransient
    public Collection<ModelBoletim> getModelBoletimCollection() {
        return modelBoletimCollection;
    }

    public void setModelBoletimCollection(Collection<ModelBoletim> modelBoletimCollection) {
        this.modelBoletimCollection = modelBoletimCollection;
    }

    public ModelPessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(ModelPessoa pessoa) {
        this.pessoa = pessoa;
    }

    @XmlTransient
    public Collection<ModelMatricula> getModelMatriculaCollection() {
        return modelMatriculaCollection;
    }

    public void setModelMatriculaCollection(Collection<ModelMatricula> modelMatriculaCollection) {
        this.modelMatriculaCollection = modelMatriculaCollection;
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
        if (!(object instanceof ModelAluno)) {
            return false;
        }
        ModelAluno other = (ModelAluno) object;
        if ((this.pesId == null && other.pesId != null) || (this.pesId != null && !this.pesId.equals(other.pesId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Aluno[ pesId=" + pesId + " ]";
    }
    
}
