/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import model.ModelEndereco;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author Cpd01
 */
public class DaoEndereco {

    Session session = HibernateUtil.getSessionFactory().openSession();

    public void salvarMatricula(ModelEndereco modelEndereco) {

        try {

            session.getTransaction().begin();
            session.persist(modelEndereco);
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

    public void excluirMatricula(ModelEndereco modelEndereco) {

        try {

            session.getTransaction().begin();
            session.delete(modelEndereco);
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

    public void atualizarMatricula(ModelEndereco modelEndereco) {

        try {
            session.getTransaction().begin();
            session.update(modelEndereco);
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

    public List<ModelEndereco> listaEndereco() {
        List<ModelEndereco> listaEnderecos = new ArrayList<>();
        org.hibernate.Query sql = session.createQuery("from ModelEndereco");
        listaEnderecos = sql.list();

        return listaEnderecos;
    }
}
