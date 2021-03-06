/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.ArrayList;
import java.util.List;
import model.ModelAcesso;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author Cpd01
 */
public class DaoAcesso {

    Session session = HibernateUtil.getSessionFactory().openSession();

    public void salvarAcesso(ModelAcesso modelAcesso) {

        try {

            session.getTransaction().begin();
            session.persist(modelAcesso);
            session.getTransaction().commit();
            session.flush();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }

        }

    }

    public void excluirAcesso(ModelAcesso modelAcesso) {

        try {

            session.getTransaction().begin();
            session.delete(modelAcesso);
            session.getTransaction().commit();
            session.flush();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }

        }

    }

    public void atualizarAcesso(ModelAcesso modelAcesso) {

        try {
            session.getTransaction().begin();
            session.update(modelAcesso);
            session.getTransaction().commit();
            session.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }

    }

    public List<ModelAcesso> listaAcesso() {
        List<ModelAcesso> listaAcesso = new ArrayList<>();
        org.hibernate.Query sql = session.createQuery("from ModelAcesso");
        listaAcesso = sql.list();

        return listaAcesso;
    }

    public ModelAcesso getModelAcesso(ModelAcesso modelAcesso) {
        ModelAcesso pModelAcesso = new ModelAcesso();
        List<ModelAcesso> list = new ArrayList<>();

        try {

            org.hibernate.Query sql = session.createQuery("from model.ModelAcesso m where m.acesLogin='" + modelAcesso.getAcesLogin()
                    + "' and m.acesSenha='" + modelAcesso.getAcesSenha() + "'");
            list = sql.list();
            modelAcesso = list.get(0);
            return pModelAcesso;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
