/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import model.ModelAuxProfTurma;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author Cpd01
 */
public class DaoAuxProfTurma {

    Session session = HibernateUtil.getSessionFactory().openSession();

    public void salvarAuxProfTurma(ModelAuxProfTurma modelAuxProfTurma) {

        try {

            session.getTransaction().begin();
            session.persist(modelAuxProfTurma);
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

    public void excluirAuxProfTurma(ModelAuxProfTurma modelAuxProfTurma) {

        try {

            session.getTransaction().begin();
            session.delete(modelAuxProfTurma);
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

    public void atualizarAuxProfTurma(ModelAuxProfTurma modelAuxProfTurma) {

        try {
            session.getTransaction().begin();
            session.update(modelAuxProfTurma);
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

    public List<ModelAuxProfTurma> listaAuxProfTurma() {
        List<ModelAuxProfTurma> listaAuxProfTurmas = new ArrayList<>();
        Query sql = (Query) session.createQuery("from ModelAuxProfTurma");
        listaAuxProfTurmas = sql.getResultList();

        return listaAuxProfTurmas;
    }

}
