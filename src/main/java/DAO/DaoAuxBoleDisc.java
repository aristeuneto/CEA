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
import model.ModelAuxBoleDisc;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author Cpd01
 */
public class DaoAuxBoleDisc {

    Session session = HibernateUtil.getSessionFactory().openSession();

    public void salvarAuxBoleDisc(ModelAuxBoleDisc modelAuxBoleDisc) {

        try {

            session.getTransaction().begin();
            session.persist(modelAuxBoleDisc);
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

    public void excluirAuxBoleDisc(ModelAuxBoleDisc modelAuxBoleDisc) {

        try {

            session.getTransaction().begin();
            session.delete(modelAuxBoleDisc);
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

    public void atualizarAuxBoleDisc(ModelAuxBoleDisc modelAuxBoleDisc) {

        try {
            session.getTransaction().begin();
            session.update(modelAuxBoleDisc);
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

    public List<ModelAuxBoleDisc> listaAuxBoleDisc() {
         try {
            if (session.isOpen() == false) {
                session = HibernateUtil.getSessionFactory().openSession();
            }
        List<ModelAuxBoleDisc> listaAuxBoleDiscs = new ArrayList<>();
        org.hibernate.Query sql = session.createQuery("from ModelAuxBoleDisc");
        listaAuxBoleDiscs = sql.list();

        return listaAuxBoleDiscs;
    }catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return null;
    }

}
