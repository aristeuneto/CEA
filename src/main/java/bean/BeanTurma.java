/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import DAO.DaoTurma;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.ModelTurma;

/**
 *
 * @author neto_
 */
@ManagedBean
@SessionScoped
public class BeanTurma {

    private ModelTurma modelTurma = new ModelTurma();

    public BeanTurma() {
    }

    public void salvarTurma(){
        DaoTurma daoTurma = new DaoTurma();
        daoTurma.salvarTurma(modelTurma);
    
    }
    
    public ModelTurma getModelTurma() {
        return modelTurma;
    }

    public void setModelTurma(ModelTurma modelTurma) {
        this.modelTurma = modelTurma;
    }

}
