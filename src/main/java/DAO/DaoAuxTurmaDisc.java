/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import model.ModelAuxTurmaDisc;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author Cpd01
 */
public class DaoAuxTurmaDisc {

    Session session = HibernateUtil.getSessionFactory().openSession();

    public void salvarAuxTurmaDisc(ModelAuxTurmaDisc modelAuxTurmaDisc) {

        try {

            session.getTransaction().begin();
            session.persist(modelAuxTurmaDisc);
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

    public void excluirAuxTurmaDisc(ModelAuxTurmaDisc modelAuxTurmaDisc) {

        try {

            session.getTransaction().begin();
            session.delete(modelAuxTurmaDisc);
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

    public void atualizarAuxTurmaDisc(ModelAuxTurmaDisc modelAuxTurmaDisc) {

        try {
            session.getTransaction().begin();
            session.update(modelAuxTurmaDisc);
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

    public List<ModelAuxTurmaDisc> listaAuxTurmaDisc() {
        List<ModelAuxTurmaDisc> listaAuxTurmaDiscs = new ArrayList<>();
        org.hibernate.Query sql = session.createQuery("from ModelAuxTurmaDisc");
        listaAuxTurmaDiscs = sql.list();

        return listaAuxTurmaDiscs;
    }

}
