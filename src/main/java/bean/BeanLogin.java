/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import DAO.DaoAcesso;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.ModelAcesso;

/**
 *
 * @author Cpd01
 */
@ManagedBean
@SessionScoped
public class BeanLogin {

    private ModelAcesso modelAcesso = new ModelAcesso();

    public BeanLogin() {
    }

    public String efetuarLogin() {
        DaoAcesso daoAcesso = new DaoAcesso();
        daoAcesso.getModelAcesso(modelAcesso);
        if(daoAcesso.getModelAcesso(modelAcesso) != null){
        return "index.xhtml";
        }
        return null;
    }

    public ModelAcesso getModelAcesso() {
        return modelAcesso;
    }

    public void setModelAcesso(ModelAcesso modelAcesso) {
        this.modelAcesso = modelAcesso;
    }

}
