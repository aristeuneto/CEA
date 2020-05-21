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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author neto_
 */
@Entity
@Table(name = "tbl_boletim")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Boletim.findAll", query = "SELECT b FROM Boletim b")
    , @NamedQuery(name = "Boletim.findByBoleId", query = "SELECT b FROM Boletim b WHERE b.boleId = :boleId")
    , @NamedQuery(name = "Boletim.findByBoleNota01", query = "SELECT b FROM Boletim b WHERE b.boleNota01 = :boleNota01")
    , @NamedQuery(name = "Boletim.findByBoleNota02", query = "SELECT b FROM Boletim b WHERE b.boleNota02 = :boleNota02")
    , @NamedQuery(name = "Boletim.findByBoleNota03", query = "SELECT b FROM Boletim b WHERE b.boleNota03 = :boleNota03")
    , @NamedQuery(name = "Boletim.findByBoleNota04", query = "SELECT b FROM Boletim b WHERE b.boleNota04 = :boleNota04")
    , @NamedQuery(name = "Boletim.findByBoleSituacao", query = "SELECT b FROM Boletim b WHERE b.boleSituacao = :boleSituacao")})
public class Boletim implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "bole_id")
    private Integer boleId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "bole_nota_01")
    private Float boleNota01;
    @Column(name = "bole_nota_02")
    private Float boleNota02;
    @Column(name = "bole_nota_03")
    private Float boleNota03;
    @Column(name = "bole_nota_04")
    private Float boleNota04;
    @Size(max = 15)
    @Column(name = "bole_situacao")
    private String boleSituacao;
    @OneToMany(mappedBy = "boleId")
    private Collection<AuxBoleDisc> auxBoleDiscCollection;
    @JoinColumn(name = "pes_id", referencedColumnName = "pes_id")
    @ManyToOne
    private Aluno pesId;

    public Boletim() {
    }

    public Boletim(Integer boleId) {
        this.boleId = boleId;
    }

    public Integer getBoleId() {
        return boleId;
    }

    public void setBoleId(Integer boleId) {
        this.boleId = boleId;
    }

    public Float getBoleNota01() {
        return boleNota01;
    }

    public void setBoleNota01(Float boleNota01) {
        this.boleNota01 = boleNota01;
    }

    public Float getBoleNota02() {
        return boleNota02;
    }

    public void setBoleNota02(Float boleNota02) {
        this.boleNota02 = boleNota02;
    }

    public Float getBoleNota03() {
        return boleNota03;
    }

    public void setBoleNota03(Float boleNota03) {
        this.boleNota03 = boleNota03;
    }

    public Float getBoleNota04() {
        return boleNota04;
    }

    public void setBoleNota04(Float boleNota04) {
        this.boleNota04 = boleNota04;
    }

    public String getBoleSituacao() {
        return boleSituacao;
    }

    public void setBoleSituacao(String boleSituacao) {
        this.boleSituacao = boleSituacao;
    }

    @XmlTransient
    public Collection<AuxBoleDisc> getAuxBoleDiscCollection() {
        return auxBoleDiscCollection;
    }

    public void setAuxBoleDiscCollection(Collection<AuxBoleDisc> auxBoleDiscCollection) {
        this.auxBoleDiscCollection = auxBoleDiscCollection;
    }

    public Aluno getPesId() {
        return pesId;
    }

    public void setPesId(Aluno pesId) {
        this.pesId = pesId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (boleId != null ? boleId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Boletim)) {
            return false;
        }
        Boletim other = (Boletim) object;
        if ((this.boleId == null && other.boleId != null) || (this.boleId != null && !this.boleId.equals(other.boleId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Boletim[ boleId=" + boleId + " ]";
    }
    
}
