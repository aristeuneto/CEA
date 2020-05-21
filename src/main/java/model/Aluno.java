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
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author neto_
 */
@Entity
@Table(name = "tbl_aluno")
/*@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Aluno.findAll", query = "SELECT a FROM Aluno a")
    , @NamedQuery(name = "Aluno.findByPesId", query = "SELECT a FROM Aluno a WHERE a.pesId = :pesId")
    , @NamedQuery(name = "Aluno.findByAluEscolaOrigem", query = "SELECT a FROM Aluno a WHERE a.aluEscolaOrigem = :aluEscolaOrigem")
    , @NamedQuery(name = "Aluno.findByAluObs", query = "SELECT a FROM Aluno a WHERE a.aluObs = :aluObs")
    , @NamedQuery(name = "Aluno.findByAluStatus", query = "SELECT a FROM Aluno a WHERE a.aluStatus = :aluStatus")})*/
@PrimaryKeyJoinColumn(name = "pes_id")
public class Aluno extends Pessoa implements Serializable {

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
    private Collection<Boletim> boletimCollection;
   /* @JoinColumn(name = "pes_id", referencedColumnName = "pes_id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Pessoa pessoa;*/
    @JoinColumn(name = "turma_id", referencedColumnName = "turma_id")
    @ManyToOne
    private Turma turmaId;
    @OneToMany(mappedBy = "pesId")
    private Collection<Matricula> matriculaCollection;

    public Aluno() {
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
    public Collection<Boletim> getBoletimCollection() {
        return boletimCollection;
    }

    public void setBoletimCollection(Collection<Boletim> boletimCollection) {
        this.boletimCollection = boletimCollection;
    }

    public Turma getTurmaId() {
        return turmaId;
    }

    public void setTurmaId(Turma turmaId) {
        this.turmaId = turmaId;
    }

    @XmlTransient
    public Collection<Matricula> getMatriculaCollection() {
        return matriculaCollection;
    }

    public void setMatriculaCollection(Collection<Matricula> matriculaCollection) {
        this.matriculaCollection = matriculaCollection;
    }
    
}
