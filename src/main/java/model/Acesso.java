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
 * @author neto_
 */
@Entity
@Table(name = "tbl_acesso")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Acesso.findAll", query = "SELECT a FROM Acesso a")
    , @NamedQuery(name = "Acesso.findByAcesId", query = "SELECT a FROM Acesso a WHERE a.acesId = :acesId")
    , @NamedQuery(name = "Acesso.findByAcesNome", query = "SELECT a FROM Acesso a WHERE a.acesNome = :acesNome")
    , @NamedQuery(name = "Acesso.findByAcesLogin", query = "SELECT a FROM Acesso a WHERE a.acesLogin = :acesLogin")
    , @NamedQuery(name = "Acesso.findByAcesSenha", query = "SELECT a FROM Acesso a WHERE a.acesSenha = :acesSenha")
    , @NamedQuery(name = "Acesso.findByAcesStatus", query = "SELECT a FROM Acesso a WHERE a.acesStatus = :acesStatus")})
public class Acesso implements Serializable {

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
    private Professor pesId;

    public Acesso() {
    }

    public Acesso(Integer acesId) {
        this.acesId = acesId;
    }

    public Acesso(Integer acesId, String acesNome, String acesLogin, String acesSenha) {
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

    public Professor getPesId() {
        return pesId;
    }

    public void setPesId(Professor pesId) {
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
        if (!(object instanceof Acesso)) {
            return false;
        }
        Acesso other = (Acesso) object;
        if ((this.acesId == null && other.acesId != null) || (this.acesId != null && !this.acesId.equals(other.acesId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Acesso[ acesId=" + acesId + " ]";
    }
    
}
