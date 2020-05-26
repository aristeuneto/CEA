/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import DAO.DaoProfessor;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import model.ModelContato;
import model.ModelEndereco;
import model.ModelProfessor;
import util.BLDatas;

/**
 *
 * @author neto_
 */
@Named
@ManagedBean
@SessionScoped
public class BeanProfessor {

    private ModelProfessor modelProfessor = new ModelProfessor();
    private ModelEndereco modelEndereco = new ModelEndereco();
    private ModelContato modelContato = new ModelContato();
    private String dataNascimento = new String();

    public BeanProfessor() {
    }

    public void salvarProfessor() throws Exception {
        BLDatas bLDatas = new BLDatas();
        Date dtNascimento = bLDatas.converterDataStringParaDate(dataNascimento);

        DaoProfessor daoProfessor = new DaoProfessor();
        modelProfessor.setPesDtnasc(dtNascimento);
        modelProfessor.setEndId(modelEndereco);
        modelProfessor.setContId(modelContato);
        if (modelProfessor != null) {
            daoProfessor.salvarProfessor(modelProfessor);
            modelProfessor = new ModelProfessor();
            modelEndereco = new ModelEndereco();
            modelContato = new ModelContato();
            dataNascimento = new String();
            mensagemSalvo();
        }

    }

    public void mensagemSalvo() {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Sucesso!", "Cadastro Salvo!"));
    }

    public ModelProfessor getModelProfessor() {
        return modelProfessor;
    }

    public void setModelProfessor(ModelProfessor modelProfesor) {
        this.modelProfessor = modelProfesor;
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
