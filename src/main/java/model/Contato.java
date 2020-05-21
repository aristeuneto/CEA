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
@Table(name = "tbl_contato")
/*@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Contato.findAll", query = "SELECT c FROM Contato c")
    , @NamedQuery(name = "Contato.findByContId", query = "SELECT c FROM Contato c WHERE c.contId = :contId")
    , @NamedQuery(name = "Contato.findByContCelular", query = "SELECT c FROM Contato c WHERE c.contCelular = :contCelular")
    , @NamedQuery(name = "Contato.findByContTelefone", query = "SELECT c FROM Contato c WHERE c.contTelefone = :contTelefone")
    , @NamedQuery(name = "Contato.findByContEmail", query = "SELECT c FROM Contato c WHERE c.contEmail = :contEmail")
    , @NamedQuery(name = "Contato.findByContTerceiros", query = "SELECT c FROM Contato c WHERE c.contTerceiros = :contTerceiros")})*/
public class Contato implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cont_id")
    private Integer contId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "cont_celular")
    private String contCelular;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "cont_telefone")
    private String contTelefone;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "cont_email")
    private String contEmail;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "cont_terceiros")
    private String contTerceiros;
 /*   @OneToMany(mappedBy = "contId")
    private Collection<Pessoa> pessoaCollection;*/

    public Contato() {
    }

    public Contato(Integer contId) {
        this.contId = contId;
    }

    public Contato(Integer contId, String contCelular, String contTelefone, String contEmail, String contTerceiros) {
        this.contId = contId;
        this.contCelular = contCelular;
        this.contTelefone = contTelefone;
        this.contEmail = contEmail;
        this.contTerceiros = contTerceiros;
    }

    public Integer getContId() {
        return contId;
    }

    public void setContId(Integer contId) {
        this.contId = contId;
    }

    public String getContCelular() {
        return contCelular;
    }

    public void setContCelular(String contCelular) {
        this.contCelular = contCelular;
    }

    public String getContTelefone() {
        return contTelefone;
    }

    public void setContTelefone(String contTelefone) {
        this.contTelefone = contTelefone;
    }

    public String getContEmail() {
        return contEmail;
    }

    public void setContEmail(String contEmail) {
        this.contEmail = contEmail;
    }

    public String getContTerceiros() {
        return contTerceiros;
    }

    public void setContTerceiros(String contTerceiros) {
        this.contTerceiros = contTerceiros;
    }

  /*  @XmlTransient
    public Collection<Pessoa> getPessoaCollection() {
        return pessoaCollection;
    }

    public void setPessoaCollection(Collection<Pessoa> pessoaCollection) {
        this.pessoaCollection = pessoaCollection;
    }
*/
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (contId != null ? contId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contato)) {
            return false;
        }
        Contato other = (Contato) object;
        if ((this.contId == null && other.contId != null) || (this.contId != null && !this.contId.equals(other.contId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Contato[ contId=" + contId + " ]";
    }
    
}
