package bean;

import DAO.DaoDisciplina;
import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import model.ModelDisciplina;

@SessionScoped
@ManagedBean
public class BeanDisciplina {

    private ArrayList<SelectItem> listaDisciplina = null;
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

    public ArrayList<SelectItem> getListaDisciplina() {
        
        if (listaDisciplina == null){
           listaDisciplina = new ArrayList<>(); 
           DaoDisciplina daoDisciplina = new DaoDisciplina();

              for (ModelDisciplina Al : daoDisciplina.listaDisciplina()){
                  SelectItem s = new SelectItem(Al.getDiscId(), Al.getDiscNome());
                  listaDisciplina.add(s);
              }
           
        }
        
        return listaDisciplina;
    }

    public void setListaDisciplina(ArrayList<SelectItem> listaDisciplina) {
        this.listaDisciplina = listaDisciplina;
    }

}
