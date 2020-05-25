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
        disciplina.setDiscNome("nome");
        disciplina.setDiscDesc("descricao");
        disciplina.setDiscCarga (Integer.parseInt("carga"));
        disciplina.setDiscStatus("status");
        daoDisciplina.salvarDisciplina(disciplina);
    
    }
    
    
    public ModelDisciplina getContato() {
        return disciplina;
    }

    public void setDisciplina(ModelDisciplina disciplina) {
        this.disciplina = disciplina;
    }
}
