/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import DAO.DaoAluno;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import model.ModelAluno;
import model.ModelContato;
import model.ModelEndereco;
import util.BLDatas;

/**
 *
 * @author neto_
 */
@Named
@ManagedBean
@SessionScoped
public class BeanAluno extends BeanTela {

    private ArrayList<ModelAluno> listaAluno = null;
    private ModelAluno modelAluno = new ModelAluno();
    private ModelEndereco modelEndereco = new ModelEndereco();
    private ModelContato modelContato = new ModelContato();
    private String dataNascimento = new String();
    DaoAluno daoAluno = new DaoAluno();

    public BeanAluno() {
    }

    public void salvarAluno() throws Exception {
        BLDatas bLDatas = new BLDatas();
        Date dtNascimento = bLDatas.converterDataStringParaDate(dataNascimento);

        modelAluno.setPesDtnasc(dtNascimento);
        modelAluno.setEndId(modelEndereco);
        modelAluno.setContId(modelContato);
        if (modelAluno != null) {
            daoAluno.salvarAluno(modelAluno);
            modelAluno = new ModelAluno();
            modelEndereco = new ModelEndereco();
            modelContato = new ModelContato();
            dataNascimento = new String();
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

    public void AtualizarAluno(ModelAluno modelAluno) {

        daoAluno.atualizarAluno(modelAluno);
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

    public void deletarAluno(ModelAluno modelAluno) {

        daoAluno.excluirAluno(modelAluno);
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
    
    public ModelAluno getModelAluno() {
        return modelAluno;
    }

    public void setModelAluno(ModelAluno modelAluno) {
        this.modelAluno = modelAluno;
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

    public ArrayList<ModelAluno> getListaAluno() {

        listaAluno = (ArrayList<ModelAluno>) daoAluno.listaAluno();
        if (listaAluno == null) {
            listaAluno = new ArrayList<>();    
            for (ModelAluno A : listaAluno) {

                listaAluno.add(A);
            }
        }

        return listaAluno;
    }

    public void setListaAluno(ArrayList<ModelAluno> listaAluno) {
        this.listaAluno = listaAluno;
    }

}
