/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import model.Contato;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author neto_
 */
public class ContatoDAO {

    public void salvarContato(Contato contato) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        try {

            session.getTransaction().begin();
            session.persist(contato);
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

}
