/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
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

    public void excluirAluno(ModelAcesso modelAcesso) {

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

    public void atualizarAluno(ModelAcesso modelAcesso) {

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

    public List<ModelAcesso> listaAluno() {
        List<ModelAcesso> listaAluno = new ArrayList<>();
        Query sql = (Query) session.createQuery("from ModelAcesso");
        listaAluno = sql.getResultList();

        return listaAluno;
    }

    public ModelAcesso getModelAcesso(ModelAcesso modelAcesso) {
        ModelAcesso pModelAcesso = new ModelAcesso();
        List<ModelAcesso> list = new ArrayList<>();

        try {

            Query sql = (Query) session.createQuery("from ModelAcesso where acesLogin='" + modelAcesso.getAcesLogin()
                    + "' and acesSenha='" + modelAcesso.getAcesSenha() + "'");
            list = sql.getResultList();
            modelAcesso = list.get(0);
            return pModelAcesso;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
