/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import static DAO.EquipeDAO.session;
import Entites.ClientParticulier;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;

/**
 *
 * @author HP
 */
public class ClientparticDAO implements ClientparticDAOInterface<ClientParticulier> {

ClientParticulier cl;
static Session session = null;
        private Session currentSession;
     
    private Transaction currentTransaction;
     public ClientparticDAO() {
        
    }
     
     public List<ClientParticulier> findClientpartic() {
         session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.getTransaction();
        session.beginTransaction();
        List noms;
        //String fonction="commercial";
        noms = session.createCriteria(ClientParticulier.class)
           //    .setProjection(Projections.property("nom"))
                
              //  .setProjection(Projections.property("nom"))
              //  .add(Restrictions.like("fonction", fonction))
      
                .list();
        tx.commit();
        session.close();
        return noms;
        
    }
      public List<ClientParticulier> findClientparticprenom() {
         session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.getTransaction();
        session.beginTransaction();
        List noms;
        //String fonction="commercial";
        noms = session.createCriteria(ClientParticulier.class)
               //.setProjection(Projections.property("nom"))
                
               .setProjection(Projections.property("prenom"))
              //  .add(Restrictions.like("fonction", fonction))
      
                .list();
        tx.commit();
        session.close();
        return noms;
        
    }

    @Override
    public void insert(ClientParticulier t) {
     session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.getTransaction();
        session.beginTransaction();
        session.save(t);

        tx.commit();

        session.close();}

    @Override
    public void delete(ClientParticulier t) {
       session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.getTransaction();
        session.beginTransaction();
        session.delete(t);

        tx.commit();

        session.close(); }

    @Override
    public void update(ClientParticulier t) {
       session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.getTransaction();
        session.beginTransaction();
        session.merge(t);
        session.flush();
        tx.commit();

        session.close(); }

    
}
