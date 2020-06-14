/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import DAO.DaoBoletim;
import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.inject.Named;
import model.ModelBoletim;

/**
 *
 * @author LUIZ
 */
@Named
@ManagedBean
@SessionScoped
public class BeanBoletim {

    private ArrayList<SelectItem> listaBoletim = null;
    private ModelBoletim modelBoletim = new ModelBoletim();

    public BeanBoletim() {

    }

    public void salvarBoletim() {
        DaoBoletim daoAcesso = new DaoBoletim();

        if (getModelBoletim() != null) {
            daoAcesso.salvarBoletim(getModelBoletim());
            setModelBoletim(new ModelBoletim());
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

    public ArrayList<SelectItem> getListaBoletim() {

        if (listaBoletim == null) {
            listaBoletim = new ArrayList<>();
            DaoBoletim daoBoletim = new DaoBoletim();

            for (ModelBoletim B : daoBoletim.listaBoletim()) {
                SelectItem s = new SelectItem(B.getBoleId());
                listaBoletim.add(s);
            }

        }
        return listaBoletim;
    }

    public void setListaBoletim(ArrayList<SelectItem> listaBoletim) {
        this.listaBoletim = listaBoletim;
    }

    public ModelBoletim getModelBoletim() {
        return modelBoletim;
    }

    public void setModelBoletim(ModelBoletim modelBoletim) {
        this.modelBoletim = modelBoletim;
    }

}
