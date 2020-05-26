package bean;

import DAO.DaoDisciplina;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.ModelDisciplina;

@SessionScoped
@ManagedBean
public class BeanDisciplina {
    
  
        private ModelDisciplina disciplina = new ModelDisciplina();

    public BeanDisciplina() {
    }

    public void salvarDisciplina(){
    
        DaoDisciplina daoDisciplina = new DaoDisciplina();
        daoDisciplina.salvarDisciplina(getDisciplina());
    
    }

    public ModelDisciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(ModelDisciplina disciplina) {
        this.disciplina = disciplina;
    }
    
    

}
