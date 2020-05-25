/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
 * @author Cpd01
 */
@Entity
@Table(name = "tbl_endereco")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ModelEndereco.findAll", query = "SELECT m FROM ModelEndereco m")
    , @NamedQuery(name = "ModelEndereco.findByEndId", query = "SELECT m FROM ModelEndereco m WHERE m.endId = :endId")
    , @NamedQuery(name = "ModelEndereco.findByEndPais", query = "SELECT m FROM ModelEndereco m WHERE m.endPais = :endPais")
    , @NamedQuery(name = "ModelEndereco.findByEndEstado", query = "SELECT m FROM ModelEndereco m WHERE m.endEstado = :endEstado")
    , @NamedQuery(name = "ModelEndereco.findByEndCidade", query = "SELECT m FROM ModelEndereco m WHERE m.endCidade = :endCidade")
    , @NamedQuery(name = "ModelEndereco.findByEndBairro", query = "SELECT m FROM ModelEndereco m WHERE m.endBairro = :endBairro")
    , @NamedQuery(name = "ModelEndereco.findByEndRua", query = "SELECT m FROM ModelEndereco m WHERE m.endRua = :endRua")
    , @NamedQuery(name = "ModelEndereco.findByEndCep", query = "SELECT m FROM ModelEndereco m WHERE m.endCep = :endCep")
    , @NamedQuery(name = "ModelEndereco.findByEndNum", query = "SELECT m FROM ModelEndereco m WHERE m.endNum = :endNum")})
public class ModelEndereco implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "end_id")
    private Integer endId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "end_pais")
    private String endPais;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "end_estado")
    private String endEstado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "end_cidade")
    private String endCidade;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "end_bairro")
    private String endBairro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "end_rua")
    private String endRua;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "end_cep")
    private String endCep;
    @Basic(optional = false)
    @NotNull
    @Column(name = "end_num")
    private int endNum;
    @OneToMany(mappedBy = "endId", cascade = CascadeType.ALL)
    private Collection<ModelPessoa> pessoaCollection;

    public ModelEndereco() {
    }

    public ModelEndereco(Integer endId) {
        this.endId = endId;
    }

    public ModelEndereco(Integer endId, String endPais, String endEstado, String endCidade, String endBairro, String endRua, String endCep, int endNum) {
        this.endId = endId;
        this.endPais = endPais;
        this.endEstado = endEstado;
        this.endCidade = endCidade;
        this.endBairro = endBairro;
        this.endRua = endRua;
        this.endCep = endCep;
        this.endNum = endNum;
    }

    public Integer getEndId() {
        return endId;
    }

    public void setEndId(Integer endId) {
        this.endId = endId;
    }

    public String getEndPais() {
        return endPais;
    }

    public void setEndPais(String endPais) {
        this.endPais = endPais;
    }

    public String getEndEstado() {
        return endEstado;
    }

    public void setEndEstado(String endEstado) {
        this.endEstado = endEstado;
    }

    public String getEndCidade() {
        return endCidade;
    }

    public void setEndCidade(String endCidade) {
        this.endCidade = endCidade;
    }

    public String getEndBairro() {
        return endBairro;
    }

    public void setEndBairro(String endBairro) {
        this.endBairro = endBairro;
    }

    public String getEndRua() {
        return endRua;
    }

    public void setEndRua(String endRua) {
        this.endRua = endRua;
    }

    public String getEndCep() {
        return endCep;
    }

    public void setEndCep(String endCep) {
        this.endCep = endCep;
    }

    public int getEndNum() {
        return endNum;
    }

    public void setEndNum(int endNum) {
        this.endNum = endNum;
    }

    @XmlTransient
    public Collection<ModelPessoa> getPessoaCollection() {
        return pessoaCollection;
    }

    public void setPessoaCollection(Collection<ModelPessoa> pessoaCollection) {
        this.pessoaCollection = pessoaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (endId != null ? endId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ModelEndereco)) {
            return false;
        }
        ModelEndereco other = (ModelEndereco) object;
        if ((this.endId == null && other.endId != null) || (this.endId != null && !this.endId.equals(other.endId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.ModelEndereco[ endId=" + endId + " ]";
    }
    
}
