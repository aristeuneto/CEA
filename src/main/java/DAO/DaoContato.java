/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import model.ModelContato;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author neto_
 */
public class DaoContato {

    Session session = HibernateUtil.getSessionFactory().openSession();

    public void salvarContato(ModelContato modelContato) {

        try {

            session.getTransaction().begin();
            session.persist(modelContato);
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

    public void excluirContato(ModelContato modelContato) {

        try {

            session.getTransaction().begin();
            session.delete(modelContato);
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

    public void atualizarContato(ModelContato modelContato) {

        try {
            session.getTransaction().begin();
            session.update(modelContato);
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

    public List<ModelContato> listaContato() {
        List<ModelContato> listaContato = new ArrayList<>();
        Query sql = (Query) session.createQuery("from ModelContato");
        listaContato = sql.getResultList();

        return listaContato;
    }

}
