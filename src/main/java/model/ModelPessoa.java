/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author neto_
 */
@Entity
@Table(name = "tbl_pessoa")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class ModelPessoa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pes_id")
    private Integer pesId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "pes_nome")
    private String pesNome;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "pes_rg")
    private String pesRg;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "pes_cpf")
    private int pesCpf;
    @Column(name = "pes_dtnasc")
    @Temporal(TemporalType.DATE)
    private Date pesDtnasc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "pes_filiacao")
    private String pesFiliacao;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "pes_naturalidade")
    private String pesNaturalidade;
    @Size(max = 20)
    @Column(name = "pes_status")
    private String pesStatus;
    // Tirar dps o @Basic
    @Basic(optional = true)
    @JoinColumn(name = "cont_id", referencedColumnName = "cont_id")
    @ManyToOne
    private ModelContato contId;
    // Tirar dps o @Basic
    @Basic(optional = true)
    @JoinColumn(name = "end_id", referencedColumnName = "end_id")
    @ManyToOne
    private ModelEndereco endId;

    public ModelPessoa() {
    }

    public ModelPessoa(Integer pesId) {
        this.pesId = pesId;
    }

    public ModelPessoa(Integer pesId, String pesNome, String pesRg, int pesCpf, String pesFiliacao, String pesNaturalidade) {
        this.pesId = pesId;
        this.pesNome = pesNome;
        this.pesRg = pesRg;
        this.pesCpf = pesCpf;
        this.pesFiliacao = pesFiliacao;
        this.pesNaturalidade = pesNaturalidade;
    }

    public Integer getPesId() {
        return pesId;
    }

    public void setPesId(Integer pesId) {
        this.pesId = pesId;
    }

    public String getPesNome() {
        return pesNome;
    }

    public void setPesNome(String pesNome) {
        this.pesNome = pesNome;
    }

    public String getPesRg() {
        return pesRg;
    }

    public void setPesRg(String pesRg) {
        this.pesRg = pesRg;
    }

    public int getPesCpf() {
        return pesCpf;
    }

    public void setPesCpf(int pesCpf) {
        this.pesCpf = pesCpf;
    }

    public Date getPesDtnasc() {
        return pesDtnasc;
    }

    public void setPesDtnasc(Date pesDtnasc) {
        this.pesDtnasc = pesDtnasc;
    }

    public String getPesFiliacao() {
        return pesFiliacao;
    }

    public void setPesFiliacao(String pesFiliacao) {
        this.pesFiliacao = pesFiliacao;
    }

    public String getPesNaturalidade() {
        return pesNaturalidade;
    }

    public void setPesNaturalidade(String pesNaturalidade) {
        this.pesNaturalidade = pesNaturalidade;
    }

    public String getPesStatus() {
        return pesStatus;
    }

    public void setPesStatus(String pesStatus) {
        this.pesStatus = pesStatus;
    }

    public ModelContato getContId() {
        return contId;
    }

    public void setContId(ModelContato contId) {
        this.contId = contId;
    }

    public ModelEndereco getEndId() {
        return endId;
    }

    public void setEndId(ModelEndereco endId) {
        this.endId = endId;
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
        if (!(object instanceof ModelPessoa)) {
            return false;
        }
        ModelPessoa other = (ModelPessoa) object;
        if ((this.pesId == null && other.pesId != null) || (this.pesId != null && !this.pesId.equals(other.pesId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Pessoa[ pesId=" + pesId + " ]";
    }

}
