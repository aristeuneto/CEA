/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Cpd01
 */
@Entity
@Table(name = "tbl_acesso")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ModelAcesso.findAll", query = "SELECT m FROM ModelAcesso m")
    , @NamedQuery(name = "ModelAcesso.findByAcesId", query = "SELECT m FROM ModelAcesso m WHERE m.acesId = :acesId")
    , @NamedQuery(name = "ModelAcesso.findByAcesNome", query = "SELECT m FROM ModelAcesso m WHERE m.acesNome = :acesNome")
    , @NamedQuery(name = "ModelAcesso.findByAcesLogin", query = "SELECT m FROM ModelAcesso m WHERE m.acesLogin = :acesLogin")
    , @NamedQuery(name = "ModelAcesso.findByAcesSenha", query = "SELECT m FROM ModelAcesso m WHERE m.acesSenha = :acesSenha")
    , @NamedQuery(name = "ModelAcesso.findByAcesStatus", query = "SELECT m FROM ModelAcesso m WHERE m.acesStatus = :acesStatus")})
public class ModelAcesso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "aces_id")
    private Integer acesId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "aces_nome")
    private String acesNome;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "aces_login")
    private String acesLogin;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "aces_senha")
    private String acesSenha;
    @Size(max = 20)
    @Column(name = "aces_status")
    private String acesStatus;
    @JoinColumn(name = "pes_id", referencedColumnName = "pes_id")
    @ManyToOne
    private ModelProfessor pesId;

    public ModelAcesso() {
    }

    public ModelAcesso(Integer acesId) {
        this.acesId = acesId;
    }

    public ModelAcesso(Integer acesId, String acesNome, String acesLogin, String acesSenha) {
        this.acesId = acesId;
        this.acesNome = acesNome;
        this.acesLogin = acesLogin;
        this.acesSenha = acesSenha;
    }

    public Integer getAcesId() {
        return acesId;
    }

    public void setAcesId(Integer acesId) {
        this.acesId = acesId;
    }

    public String getAcesNome() {
        return acesNome;
    }

    public void setAcesNome(String acesNome) {
        this.acesNome = acesNome;
    }

    public String getAcesLogin() {
        return acesLogin;
    }

    public void setAcesLogin(String acesLogin) {
        this.acesLogin = acesLogin;
    }

    public String getAcesSenha() {
        return acesSenha;
    }

    public void setAcesSenha(String acesSenha) {
        this.acesSenha = acesSenha;
    }

    public String getAcesStatus() {
        return acesStatus;
    }

    public void setAcesStatus(String acesStatus) {
        this.acesStatus = acesStatus;
    }

    public ModelProfessor getPesId() {
        return pesId;
    }

    public void setPesId(ModelProfessor pesId) {
        this.pesId = pesId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (acesId != null ? acesId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ModelAcesso)) {
            return false;
        }
        ModelAcesso other = (ModelAcesso) object;
        if ((this.acesId == null && other.acesId != null) || (this.acesId != null && !this.acesId.equals(other.acesId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.ModelAcesso[ acesId=" + acesId + " ]";
    }
    
}
