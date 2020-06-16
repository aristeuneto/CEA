package bean;

import DAO.DaoDisciplina;
import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import model.ModelDisciplina;

@SessionScoped
@ManagedBean
public class BeanDisciplina {

    private ArrayList<ModelDisciplina> listaDisciplina;
    private ModelDisciplina modelDisciplina = new ModelDisciplina();

    public BeanDisciplina() {
    }

    public void salvarDisciplina() {

        DaoDisciplina daoDisciplina = new DaoDisciplina();
        if (modelDisciplina != null) {
            daoDisciplina.salvarDisciplina(modelDisciplina);
            modelDisciplina = new ModelDisciplina();
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

    public ModelDisciplina getModelDisciplina() {
        return modelDisciplina;
    }

    public void setModelDisciplina(ModelDisciplina modelDisciplina) {
        this.modelDisciplina = modelDisciplina;
    }

    public ArrayList<ModelDisciplina> getListaDisciplina() {
        DaoDisciplina daoDisciplina = new DaoDisciplina();
        if (listaDisciplina == null) {
            listaDisciplina = new ArrayList<>();

            for (ModelDisciplina Al : daoDisciplina.listaDisciplina()) {

                listaDisciplina.add(Al);
            }

        }

        return listaDisciplina;
    }

    public void setListaDisciplina(ArrayList<ModelDisciplina> listaDisciplina) {
        this.listaDisciplina = listaDisciplina;
    }

}
