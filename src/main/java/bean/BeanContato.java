/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import DAO.DaoContato;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.ModelContato;

/**
 *
 * @author neto_
 */
@ManagedBean
@SessionScoped
public class BeanContato implements Serializable{

    private ModelContato contato = new ModelContato();

    public BeanContato() {
    }

    public void salvarContato(){
    
        DaoContato daoContato = new DaoContato();
        contato.setContEmail("email");
        contato.setContCelular("celular");
        contato.setContTelefone("telefone");
        contato.setContTerceiros("terceiros");
        daoContato.salvarContato(contato);
    
    }
    
    
    public ModelContato getContato() {
        return contato;
    }

    public void setContato(ModelContato contato) {
        this.contato = contato;
    }

}
