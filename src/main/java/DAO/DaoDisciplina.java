/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import model.ModelDisciplina;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author Cpd01
 */
public class DaoDisciplina {

    Session session = HibernateUtil.getSessionFactory().openSession();

    public void salvarDisciplina(ModelDisciplina modelDisciplina) {

        try {

            session.getTransaction().begin();
            session.persist(modelDisciplina);
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

    public void excluirDisciplina(ModelDisciplina modelDisciplina) {

        try {

            session.getTransaction().begin();
            session.delete(modelDisciplina);
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

    public void atualizarDisciplina(ModelDisciplina modelDisciplina) {

        try {
            session.getTransaction().begin();
            session.update(modelDisciplina);
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

    public List<ModelDisciplina> listaDisciplina() {
        List<ModelDisciplina> listaDisciplinas = new ArrayList<>();
        org.hibernate.Query sql = session.createQuery("from ModelDisciplina");
        listaDisciplinas = sql.list();

        return listaDisciplinas;
    }

}
