/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import model.ModelTurma;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author Cpd01
 */
public class DaoTurma {

    Session session = HibernateUtil.getSessionFactory().openSession();

    public void salvarTurma(ModelTurma modelTurma) {

        try {
            if (session.isOpen() == false) {
                session = HibernateUtil.getSessionFactory().openSession();
            }
            session.getTransaction().begin();
            session.persist(modelTurma);
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

    public void excluirTurma(ModelTurma modelTurma) {

        try {
            if (session.isOpen() == false) {
                session = HibernateUtil.getSessionFactory().openSession();
            }
            session.getTransaction().begin();
            session.delete(modelTurma);
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

    public void atualizarTurma(ModelTurma modelTurma) {

        try {
            if (session.isOpen() == false) {
                session = HibernateUtil.getSessionFactory().openSession();
            }
            session.getTransaction().begin();
            session.update(modelTurma);
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

    public List<ModelTurma> listaTurma() {

        try {
            if (session.isOpen() == false) {
                session = HibernateUtil.getSessionFactory().openSession();
            }
            List<ModelTurma> listaTurma = new ArrayList<>();
            org.hibernate.Query sql = session.createQuery("from ModelTurma");
            listaTurma = sql.list();

            return listaTurma;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return null;
    }
}
