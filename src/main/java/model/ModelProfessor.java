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
@PrimaryKeyJoinColumn(name = "pes_id")
public class ModelProfessor extends ModelPessoa implements Serializable {

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
    
}
