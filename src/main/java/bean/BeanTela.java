/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

/**
 *
 * @author LUIZ
 */
public class BeanTela {
    
    public String Tela = "View";// Estados da tela nos formularios.
    
    public boolean isSave(){
        return "Save" .equals(Tela);
    }
    public boolean isEdit(){
        return "Edit" .equals(Tela);
    }
    public boolean isView(){
        return "View" .equals(Tela);
    }
    
    public void mudarParaSave(){
        Tela = "Save";
    }
    public void mudarParaEdit(){
        Tela = "Edit";
    }
    public void mudarParaView(){
        Tela = "View";
    }
}
