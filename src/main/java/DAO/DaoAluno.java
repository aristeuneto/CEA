/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import model.ModelAluno;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author Cpd01
 */
public class DaoAluno {

    Session session = HibernateUtil.getSessionFactory().openSession();

    public void salvarAluno(ModelAluno modelAluno) {

        try {

            session.getTransaction().begin();
            session.persist(modelAluno);
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

    public void excluirAluno(ModelAluno modelAluno) {

        try {

            session.getTransaction().begin();
            session.delete(modelAluno);
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

    public void atualizarAluno(ModelAluno modelAluno) {

        try {
            session.getTransaction().begin();
            session.update(modelAluno);
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

    public List<ModelAluno> listaAluno() {
        List<ModelAluno> listaAluno = new ArrayList<>();
        org.hibernate.Query sql =  session.createQuery("from ModelAluno");
        listaAluno = sql.list();

        return listaAluno;
    }

}
