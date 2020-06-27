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
import javax.inject.Named;
import model.ModelTurma;

/**
 *
 * @author neto_
 */
@Named
@ManagedBean
@SessionScoped
public class BeanTurma extends BeanTela {

    private ArrayList<ModelTurma> listaTurma;
    private ModelTurma modelTurma = new ModelTurma();
    DaoTurma daoTurma = new DaoTurma();

    public BeanTurma() {
    }

    public void salvarTurma() {

        if (modelTurma != null) {
            daoTurma.salvarTurma(modelTurma);
            mudarParaView();
            modelTurma = new ModelTurma();
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
        mudarParaEdit();
    }

    public void AtualizarTurma(ModelTurma modelTurma) {

        daoTurma.atualizarTurma(modelTurma);

    }

    public void deletarTurma(ModelTurma modelTurma) {

        daoTurma.excluirTurma(modelTurma);

    }

    public ArrayList<ModelTurma> getListaTurma() {
        DaoTurma daoTurma = new DaoTurma();
        listaTurma = (ArrayList<ModelTurma>) daoTurma.listaTurma();
        if (listaTurma == null) {
            listaTurma = new ArrayList<>();
      //      for (ModelTurma T : daoTurma.listaTurma()) {
            for (ModelTurma T : listaTurma) {

                listaTurma.add(T);
            }
        }

        return listaTurma;
    }

    public void setListaTurma(ArrayList<ModelTurma> listaTurma) {
        this.listaTurma = listaTurma;
    }

}
