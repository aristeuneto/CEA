/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import DAO.DaoAcesso;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import model.ModelAcesso;

/**
 *
 * @author LUIZ
 */
@Named
@ManagedBean
@SessionScoped
public class BeanAcesso {

    private ModelAcesso modelAcesso = new ModelAcesso();

    public BeanAcesso() {
    }

    public void salvarAcesso() {
        DaoAcesso daoAcesso = new DaoAcesso();

        if (modelAcesso != null) {
            daoAcesso.salvarAcesso(modelAcesso);
            modelAcesso = new ModelAcesso();
            mensagemSalvo(true);
        } else {
            mensagemSalvo(false);
        }

    }

    public void mensagemSalvo(Boolean status) {
        FacesContext context = FacesContext.getCurrentInstance();
        if (status) {
            context.addMessage(null, new FacesMessage("Sucesso!", "Cadastro Salvo!"));
        } else {
            context.addMessage(null, new FacesMessage("Erro!", "Erro ao Salvar!"));
        }
    }

    public ModelAcesso getModelAcesso() {
        return modelAcesso;
    }

    public void setModelAcesso(ModelAcesso modelAcesso) {
        this.modelAcesso = modelAcesso;
    }


    public void atualizarAcesso() {
        DaoAcesso daoAcesso = new DaoAcesso();

        if (modelAcesso != null) {
            daoAcesso.atualizarAcesso(modelAcesso);
            modelAcesso = new ModelAcesso();
            mensagemSalvo(true);
        } else {
            mensagemSalvo(false);
        }

    }
               
}