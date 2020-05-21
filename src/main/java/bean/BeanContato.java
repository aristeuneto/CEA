/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import DAO.ContatoDAO;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.Contato;

/**
 *
 * @author neto_
 */
@ManagedBean
@SessionScoped
public class BeanContato {

    private Contato contato = new Contato();

    public BeanContato() {
    }

    public void salvarContato(){
    
        ContatoDAO contatoDAO = new ContatoDAO();
        contato.setContEmail("email");
        contato.setContCelular("celular");
        contato.setContTelefone("telefone");
        contato.setContTerceiros("terceiros");
        contatoDAO.salvarContato(contato);
    
    }
    
    
    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }

}
