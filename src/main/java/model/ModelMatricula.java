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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Cpd01
 */
@Entity
@Table(name = "tbl_matricula")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ModelMatricula.findAll", query = "SELECT m FROM ModelMatricula m")
    , @NamedQuery(name = "ModelMatricula.findByMatId", query = "SELECT m FROM ModelMatricula m WHERE m.matId = :matId")
    , @NamedQuery(name = "ModelMatricula.findByMatAnoLetivo", query = "SELECT m FROM ModelMatricula m WHERE m.matAnoLetivo = :matAnoLetivo")
    , @NamedQuery(name = "ModelMatricula.findByMatTurno", query = "SELECT m FROM ModelMatricula m WHERE m.matTurno = :matTurno")
    , @NamedQuery(name = "ModelMatricula.findByMatSerie", query = "SELECT m FROM ModelMatricula m WHERE m.matSerie = :matSerie")
    , @NamedQuery(name = "ModelMatricula.findByMatData", query = "SELECT m FROM ModelMatricula m WHERE m.matData = :matData")
    , @NamedQuery(name = "ModelMatricula.findByMatStatus", query = "SELECT m FROM ModelMatricula m WHERE m.matStatus = :matStatus")})
public class ModelMatricula implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "mat_id")
    private Integer matId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "mat_ano_letivo")
    private String matAnoLetivo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "mat_turno")
    private String matTurno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "mat_serie")
    private String matSerie;
    @Column(name = "mat_data")
    @Temporal(TemporalType.DATE)
    private Date matData;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "mat_status")
    private String matStatus;
    @JoinColumn(name = "pes_id", referencedColumnName = "pes_id")
    @ManyToOne
    private ModelAluno pesId;

    public ModelMatricula() {
    }

    public ModelMatricula(Integer matId) {
        this.matId = matId;
    }

    public ModelMatricula(Integer matId, String matAnoLetivo, String matTurno, String matSerie, String matStatus) {
        this.matId = matId;
        this.matAnoLetivo = matAnoLetivo;
        this.matTurno = matTurno;
        this.matSerie = matSerie;
        this.matStatus = matStatus;
    }

    public Integer getMatId() {
        return matId;
    }

    public void setMatId(Integer matId) {
        this.matId = matId;
    }

    public String getMatAnoLetivo() {
        return matAnoLetivo;
    }

    public void setMatAnoLetivo(String matAnoLetivo) {
        this.matAnoLetivo = matAnoLetivo;
    }

    public String getMatTurno() {
        return matTurno;
    }

    public void setMatTurno(String matTurno) {
        this.matTurno = matTurno;
    }

    public String getMatSerie() {
        return matSerie;
    }

    public void setMatSerie(String matSerie) {
        this.matSerie = matSerie;
    }

    public Date getMatData() {
        return matData;
    }

    public void setMatData(Date matData) {
        this.matData = matData;
    }

    public String getMatStatus() {
        return matStatus;
    }

    public void setMatStatus(String matStatus) {
        this.matStatus = matStatus;
    }

    public ModelAluno getPesId() {
        return pesId;
    }

    public void setPesId(ModelAluno pesId) {
        this.pesId = pesId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (matId != null ? matId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ModelMatricula)) {
            return false;
        }
        ModelMatricula other = (ModelMatricula) object;
        if ((this.matId == null && other.matId != null) || (this.matId != null && !this.matId.equals(other.matId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.ModelMatricula[ matId=" + matId + " ]";
    }
    
}
