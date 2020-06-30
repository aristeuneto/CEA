/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import DAO.DaoMatricula;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import model.ModelMatricula;
import util.BLDatas;

/**
 *
 * @author LUIZ
 */
@ManagedBean
@SessionScoped
public class BeanMatricula extends BeanTela implements Serializable{

    private ArrayList<ModelMatricula> listaMatricula;
    private ModelMatricula modelMatricula = new ModelMatricula();
    private String data = new String();
    DaoMatricula daoMatricula = new DaoMatricula();

    public BeanMatricula() {
    }

    public void salvarMatricula() throws Exception {
       
        BLDatas bLDatas = new BLDatas();

        Date dt = bLDatas.converterDataStringParaDate(getData());
        if (modelMatricula != null) {
            daoMatricula.salvarMatricula(modelMatricula);
            modelMatricula = new ModelMatricula();
            setData(new String());
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

     public void AtualizarMatricula(ModelMatricula modelMatricula) {

        daoMatricula.atualizarMatricula(modelMatricula);
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

    public void deletarMatricula(ModelMatricula modelMatricula) {

        daoMatricula.excluirMatricula(modelMatricula);
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

    
    public ModelMatricula getModelMatricula() {
        return modelMatricula;
    }

    public void setModelMatricula(ModelMatricula modelMatricula) {
        this.modelMatricula = modelMatricula;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public ArrayList<ModelMatricula> getListaMatricula() {

        listaMatricula = (ArrayList<ModelMatricula>) daoMatricula.listaMatricula();
        
        if (listaMatricula == null) {
            listaMatricula = new ArrayList<>();
            for (ModelMatricula M : listaMatricula) {
                listaMatricula.add(M);
            }
        }
        return listaMatricula;
    }

    public void setListaMatricula(ArrayList<ModelMatricula> listaMatricula) {
        this.listaMatricula = listaMatricula;
    }

}
