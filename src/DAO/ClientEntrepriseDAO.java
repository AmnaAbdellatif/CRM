/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import static DAO.ClientparticDAO.session;
import static DAO.CommercialDAO.session;
import Entites.ClientEntreprise;
import Entites.ClientParticulier;
import Entites.Commercial;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;

/**
 *
 * @author HP
 */
public class ClientEntrepriseDAO implements CommercialDAOInterface<ClientEntreprise> {
    ClientEntreprise etrp;
    static Session session = null;
        private Session currentSession;
     
    private Transaction currentTransaction;
 
    public ClientEntrepriseDAO() {
        
    }
 public List<ClientEntreprise> findClientEntreprise() {
         session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.getTransaction();
        session.beginTransaction();
        List noms;
        //String fonction="commercial";
        noms = session.createCriteria(ClientEntreprise.class)
               
               
      
                .list();
        tx.commit();
        session.close();
        return noms;
        
    }
    
    
    
    
    @Override
    public void insert(ClientEntreprise t) {
       session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.getTransaction();
        session.beginTransaction();
        session.save(t);

        tx.commit();

        session.close(); }

    @Override
    public void delete(ClientEntreprise t) {
       session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.getTransaction();
        session.beginTransaction();
        session.delete(t);

        tx.commit();

        session.close();  }

    @Override
    public void update(ClientEntreprise t) {
       session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.getTransaction();
        session.beginTransaction();
        session.merge(t);
        session.flush();
        tx.commit();

        session.close(); }
    
}
