/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
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
    @NamedQuery(name = "Professor.findAll", query = "SELECT p FROM Professor p")
    , @NamedQuery(name = "Professor.findByPesId", query = "SELECT p FROM Professor p WHERE p.pesId = :pesId")
    , @NamedQuery(name = "Professor.findByProfStatus", query = "SELECT p FROM Professor p WHERE p.profStatus = :profStatus")})*/
@PrimaryKeyJoinColumn(name = "pes_id")
public class Professor extends Pessoa implements Serializable {

    @Size(max = 20)
    @Column(name = "prof_status")
    private String profStatus;
    @OneToMany(mappedBy = "pesId")
    private Collection<AuxProfDisc> auxProfDiscCollection;
    @OneToMany(mappedBy = "pesId")
    private Collection<AuxProfTurma> auxProfTurmaCollection;
    @OneToMany(mappedBy = "pesId")
    private Collection<Acesso> acessoCollection;

    public Professor() {
    }

    public String getProfStatus() {
        return profStatus;
    }

    public void setProfStatus(String profStatus) {
        this.profStatus = profStatus;
    }

    @XmlTransient
    public Collection<AuxProfDisc> getAuxProfDiscCollection() {
        return auxProfDiscCollection;
    }

    public void setAuxProfDiscCollection(Collection<AuxProfDisc> auxProfDiscCollection) {
        this.auxProfDiscCollection = auxProfDiscCollection;
    }

    @XmlTransient
    public Collection<AuxProfTurma> getAuxProfTurmaCollection() {
        return auxProfTurmaCollection;
    }

    public void setAuxProfTurmaCollection(Collection<AuxProfTurma> auxProfTurmaCollection) {
        this.auxProfTurmaCollection = auxProfTurmaCollection;
    }

    @XmlTransient
    public Collection<Acesso> getAcessoCollection() {
        return acessoCollection;
    }

    public void setAcessoCollection(Collection<Acesso> acessoCollection) {
        this.acessoCollection = acessoCollection;
    }
    
}
