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
public class BeanBoletim extends BeanTela{

    private ArrayList<ModelBoletim> listaBoletim ;
    private ModelBoletim modelBoletim = new ModelBoletim();
    DaoBoletim daoBoletim = new DaoBoletim();

    public BeanBoletim() {

    }

    public void salvarBoletim() {

        if (getModelBoletim() != null) {
            daoBoletim.salvarBoletim(getModelBoletim());
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

    public void AtualizarBoletim(ModelBoletim modelBoletim) {

        daoBoletim.atualizarBoletim(modelBoletim);
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

    public void deletarAluno(ModelBoletim modelBoletim) {

        daoBoletim.excluirBoletim(modelBoletim);
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

    public ArrayList<ModelBoletim> getListaBoletim() {

        if (listaBoletim == null) {
            listaBoletim = new ArrayList<>();
            DaoBoletim daoBoletim = new DaoBoletim();

            for (ModelBoletim B : daoBoletim.listaBoletim()) {
                
                listaBoletim.add(B);
            }

        }
        return listaBoletim;
    }

    public void setListaBoletim(ArrayList<ModelBoletim> listaBoletim) {
        this.listaBoletim = listaBoletim;
    }

    public ModelBoletim getModelBoletim() {
        return modelBoletim;
    }

    public void setModelBoletim(ModelBoletim modelBoletim) {
        this.modelBoletim = modelBoletim;
    }

}
