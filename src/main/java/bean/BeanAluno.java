/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import DAO.DaoAcesso;
import DAO.DaoAluno;
import java.io.Serializable;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.ModelAluno;
import model.ModelContato;
import model.ModelEndereco;
import util.BLDatas;

/**
 *
 * @author neto_
 */
@ManagedBean
@SessionScoped
public class BeanAluno implements Serializable {

    private ModelAluno modelAluno = new ModelAluno();
    private ModelEndereco modelEndereco = new ModelEndereco();
    private ModelContato modelContato = new ModelContato();
    private String dataNascimento = new String();

    public BeanAluno() {
    }

    public void salvarAluno() throws Exception {
        BLDatas bLDatas = new BLDatas();
        Date dtNascimento = bLDatas.converterDataStringParaDate(dataNascimento);

        DaoAluno daoAluno = new DaoAluno();
        modelAluno.setPesDtnasc(dtNascimento);
        modelAluno.setEndId(modelEndereco);
        modelAluno.setContId(modelContato);
        if (modelAluno != null) {
            daoAluno.salvarAluno(modelAluno);
        }

    }

    public ModelAluno getModelAluno() {
        return modelAluno;
    }

    public void setModelAluno(ModelAluno modelAluno) {
        this.modelAluno = modelAluno;
    }

    public ModelEndereco getModelEndereco() {
        return modelEndereco;
    }

    public void setModelEndereco(ModelEndereco modelEndereco) {
        this.modelEndereco = modelEndereco;
    }

    public ModelContato getModelContato() {
        return modelContato;
    }

    public void setModelContato(ModelContato modelContato) {
        this.modelContato = modelContato;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

}
