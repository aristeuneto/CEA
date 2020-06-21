/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import DAO.DaoTurma;
import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import model.ModelTurma;

/**
 *
 * @author neto_
 */
@ManagedBean
@SessionScoped
public class BeanTurma extends BeanTela{

    private ArrayList<ModelTurma> listaTurma;
    private ModelTurma modelTurma = new ModelTurma();
    DaoTurma daoTurma = new DaoTurma();

    public BeanTurma() {
    }

    public void salvarTurma() {

        if (modelTurma != null) {
            daoTurma.salvarTurma(modelTurma); 
            modelTurma = new ModelTurma();
            mudarParaView();
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

    public void mensagemAtualizado(Boolean status) {
        FacesContext context = FacesContext.getCurrentInstance();
        if (status) {
            context.addMessage(null, new FacesMessage("Sucesso!", "Cadastro Atualizado!"));
        } else {
            context.addMessage(null, new FacesMessage("Erro!", "Erro ao Atualizar!"));
        }
    }

    public ModelTurma getModelTurma() {
        return modelTurma;
    }

    public void setModelTurma(ModelTurma modelTurma) {
        this.modelTurma = modelTurma;

    }

    public void AtualizarTurma() {

        if (modelTurma != null) {
            daoTurma.atualizarTurma(modelTurma); 
            modelTurma = new ModelTurma();
            mudarParaView();
            mensagemAtualizado(true);
             
        } else {
            mensagemAtualizado(false);
        }
    }

    public void mensagemAtualizar(Boolean status) {
        FacesContext context = FacesContext.getCurrentInstance();
        if (status) {
            context.addMessage(null, new FacesMessage("Sucesso!", "Cadastro Atualizado!"));
        } else {
            context.addMessage(null, new FacesMessage("Erro!", "Erro ao Atualizar!"));
        }
    }

    public void deletarTurma() {

    }

    public ArrayList<ModelTurma> getListaTurma() {
        DaoTurma daoTurma = new DaoTurma();
        listaTurma = (ArrayList<ModelTurma>) daoTurma.listaTurma();
        if (listaTurma == null) {
            listaTurma = new ArrayList<>();
            for (ModelTurma T : daoTurma.listaTurma()) {

                listaTurma.add(T);
            }
        }

        return listaTurma;
    }

    public void setListaTurma(ArrayList<ModelTurma> listaTurma) {
        this.listaTurma = listaTurma;
    }

}
