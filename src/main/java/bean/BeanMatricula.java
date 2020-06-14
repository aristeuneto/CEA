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
import javax.faces.model.SelectItem;
import model.ModelMatricula;
import util.BLDatas;

/**
 *
 * @author LUIZ
 */
@ManagedBean
@SessionScoped
public class BeanMatricula implements Serializable {

    private ArrayList<SelectItem> listaMatricula = null;
    private ModelMatricula modelMatricula = new ModelMatricula();
    private String data = new String();

    public BeanMatricula() {
    }

    public void salvarMatricula() throws Exception{
        DaoMatricula daoMatricula = new DaoMatricula();
        BLDatas bLDatas = new BLDatas();

        Date dt = bLDatas.converterDataStringParaDate(getData());
        if (modelMatricula != null) {
            daoMatricula.salvarMatricula(modelMatricula);
            modelMatricula = new ModelMatricula();
            setData(new String());
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

    public ModelMatricula getModelMatricula() {
        return modelMatricula;
    }

    public void setModelMatricula(ModelMatricula modelMatricula) {
        this.modelMatricula = modelMatricula;
    }

    public ArrayList<SelectItem> getListaMatricula() {

        if (listaMatricula == null) {
            listaMatricula = new ArrayList<>();
            DaoMatricula daoMatricula = new DaoMatricula();

            for (ModelMatricula M : daoMatricula.listaMatricula()) {
                SelectItem s = new SelectItem(M.getMatId());
                listaMatricula.add(s);
            }
        }
        return listaMatricula;
    }

    public void setListaMatricula(ArrayList<SelectItem> listaMatricula) {
        this.listaMatricula = listaMatricula;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

}
