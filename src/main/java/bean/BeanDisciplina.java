package bean;

import DAO.DaoDisciplina;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import model.ModelDisciplina;

@SessionScoped
@ManagedBean
public class BeanDisciplina {

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

}
