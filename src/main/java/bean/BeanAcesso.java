/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;
import model.ModelAcesso;

/**
 *
 * @author LUIZ
 */
@Named
@ManagedBean
@SessionScoped
public class BeanAcesso {
    
    
    private ModelAcesso modelAcesso = new ModelAcesso();
    
    public BeanAcesso(){       
    }
    
    
}
