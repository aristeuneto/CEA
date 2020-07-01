/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import DAO.DaoAcesso;
import java.util.ArrayList;
import java.util.List;
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
public class BeanAcesso extends BeanTela {

    private List<ModelAcesso> listaAcesso;
    private ModelAcesso modelAcesso = new ModelAcesso();
    DaoAcesso daoAcesso = new DaoAcesso();

    public BeanAcesso() {
    }

    public void salvarAcesso() {

        if (getModelAcesso() != null) {
            daoAcesso.salvarAcesso(getModelAcesso());
            mudarParaView();
            setModelAcesso(new ModelAcesso());
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

 public void AtualizarAcesso(ModelAcesso modelAcesso) {

        daoAcesso.atualizarAcesso(modelAcesso);
        mudarParaView();
        mensagemAtualizado(true);
    }

    public void mensagemAtualizado(Boolean status) {
        FacesContext context = FacesContext.getCurrentInstance();
        if (status) {
            context.addMessage(null, new FacesMessage("Sucesso!", "Cadastro Atualizado!"));
        } else {
            context.addMessage(null, new FacesMessage("Erro!", "Erro ao Atualizar!"));
        }
    }

    public void deletarAcesso(ModelAcesso modelAcesso) {

        daoAcesso.excluirAcesso(modelAcesso);
        mudarParaView();
        mensagemDeletar(true);

    }

    public void mensagemDeletar(Boolean status) {
        FacesContext context = FacesContext.getCurrentInstance();
        if (status) {
            context.addMessage(null, new FacesMessage("Sucesso!", "Cadastro Deletado!"));
        } else {
            context.addMessage(null, new FacesMessage("Erro!", "Erro ao Deletar!"));
        }
    }

    public ModelAcesso getModelAcesso() {
        return modelAcesso;
    }

    public void setModelAcesso(ModelAcesso modelAcesso) {
        this.modelAcesso = modelAcesso;
    }

    public List<ModelAcesso> getListaAcesso() {
        DaoAcesso daoAcesso = new DaoAcesso();
        listaAcesso = daoAcesso.listaAcesso();

        if (listaAcesso == null) {
            listaAcesso = new ArrayList<>();
            for (ModelAcesso A : listaAcesso) {
                listaAcesso.add(A);
            }
        }

        return listaAcesso;
    }

    public void setListaAcesso(List<ModelAcesso> listaAcesso) {
        this.listaAcesso = listaAcesso;
    }

}
