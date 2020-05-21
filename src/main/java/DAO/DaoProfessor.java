/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import model.ModelProfessor;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author Cpd01
 */
public class DaoProfessor {
    
     Session session = HibernateUtil.getSessionFactory().openSession();

    public void salvarProfessor(ModelProfessor modelProfessor) {

        try {

            session.getTransaction().begin();
            session.persist(modelProfessor);
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

    public void excluirProfessor(ModelProfessor modelProfessor) {

        try {

            session.getTransaction().begin();
            session.delete(modelProfessor);
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

    public void atualizarProfessor(ModelProfessor modelProfessor) {

        try {
            session.getTransaction().begin();
            session.update(modelProfessor);
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

    public List<ModelProfessor> listaProfessor() {
        List<ModelProfessor> listaProfessores = new ArrayList<>();
        Query sql = (Query) session.createQuery("from ModelProfessor");
        listaProfessores = sql.getResultList();

        return listaProfessores;
    }
    
}
