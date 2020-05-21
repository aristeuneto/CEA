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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.ws.rs.OPTIONS;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author neto_
 */
@Entity
@Table(name = "tbl_aluno")
@PrimaryKeyJoinColumn(name = "pes_id")
public class ModelAluno extends ModelPessoa implements Serializable {

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
    // Dps tirar o @Basic
    @Basic(optional = true)
    @OneToMany(mappedBy = "pesId")
    private Collection<ModelBoletim> boletimCollection;
    // Dps tirar o @Basic
    @Basic(optional = true)
    @JoinColumn(name = "turma_id", referencedColumnName = "turma_id")
    @ManyToOne
    private ModelTurma turmaId;
    // Dps tirar o @Basic
    @Basic(optional = true)
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

}
