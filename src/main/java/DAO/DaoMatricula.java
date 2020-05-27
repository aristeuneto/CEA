/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import model.ModelMatricula;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author Cpd01
 */
public class DaoMatricula {

    Session session = HibernateUtil.getSessionFactory().openSession();

    public void salvarMatricula(ModelMatricula modelMatricula) {

        try {

            session.getTransaction().begin();
            session.persist(modelMatricula);
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

    public void excluirMatricula(ModelMatricula modelMatricula) {

        try {

            session.getTransaction().begin();
            session.delete(modelMatricula);
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

    public void atualizarMatricula(ModelMatricula modelMatricula) {

        try {
            session.getTransaction().begin();
            session.update(modelMatricula);
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

    public List<ModelMatricula> listaMatricula() {
        List<ModelMatricula> listaMatriculas = new ArrayList<>();
        org.hibernate.Query sql = session.createQuery("from ModelMatricula");
        listaMatriculas = sql.list();

        return listaMatriculas;
    }

}
