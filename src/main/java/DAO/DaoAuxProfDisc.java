/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import model.ModelAuxProfDisc;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author Cpd01
 */
public class DaoAuxProfDisc {

    Session session = HibernateUtil.getSessionFactory().openSession();

    public void salvarAuxProfDisc(ModelAuxProfDisc modelAuxProfDisc) {

        try {

            session.getTransaction().begin();
            session.persist(modelAuxProfDisc);
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

    public void excluirAuxProfDisc(ModelAuxProfDisc modelAuxProfDisc) {

        try {

            session.getTransaction().begin();
            session.delete(modelAuxProfDisc);
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

    public void atualizarAuxProfDisc(ModelAuxProfDisc modelAuxProfDisc) {

        try {
            session.getTransaction().begin();
            session.update(modelAuxProfDisc);
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

    public List<ModelAuxProfDisc> listaAuxProfDisc() {
        List<ModelAuxProfDisc> listaAuxProfDiscs = new ArrayList<>();
        org.hibernate.Query sql = session.createQuery("from ModelAuxProfDisc");
        listaAuxProfDiscs = sql.list();

        return listaAuxProfDiscs;
    }

}
