/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import static DAO.CommercialDAO.session;
import Entites.Commercial;
import Entites.EquipeCommerciale;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author HP
 */
public class EquipeDAO implements EquipeDAOInterface<EquipeCommerciale>{
    EquipeCommerciale eq;
    static Session session = null;
        private Session currentSession;
     
    private Transaction currentTransaction;
     public EquipeDAO() {
        
    }
     
     public List<EquipeCommerciale> findNomEquipe() {
         session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.getTransaction();
        session.beginTransaction();
        List noms;
        //String fonction="commercial";
        noms = session.createCriteria(EquipeCommerciale.class)
             .setProjection(Projections.distinct(Projections.property("nomEquipe")))
                    
                
                .list();
        tx.commit();
        session.close();
        return noms;
        
    }
      public List<EquipeCommerciale> findlistCommerc(String nomEquipe) {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.getTransaction();
        session.beginTransaction();
        List noms;
        noms = session.createCriteria(EquipeCommerciale.class)
                .add(Restrictions.like("nomEquipe", nomEquipe))
                .list();
        tx.commit();
        session.close();
        return noms;
    }
       public List<EquipeCommerciale> findRespo(String nomEquipe) {
         session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.getTransaction();
        session.beginTransaction();
        List noms;
        //String fonction="commercial";
        noms = session.createCriteria(EquipeCommerciale.class)
             .setProjection(Projections.distinct(Projections.property("responsableEquipe")))
                .add(Restrictions.like("nomEquipe", nomEquipe))
                    
                
                .list();
        tx.commit();
        session.close();
        return noms;
        
    }
        public List<EquipeCommerciale> findact(String nomEquipe) {
         session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.getTransaction();
        session.beginTransaction();
        List noms;
        //String fonction="commercial";
        noms = session.createCriteria(EquipeCommerciale.class)
             .setProjection(Projections.distinct(Projections.property("typeActivEquipe")))
                .add(Restrictions.like("nomEquipe", nomEquipe))
                    
                
                .list();
        tx.commit();
        session.close();
        return noms;
        
    }
        
  

    @Override
    public void insert(EquipeCommerciale t) {
       session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.getTransaction();
        session.beginTransaction();
        session.save(t);

        tx.commit();

        session.close(); }

    @Override
    public void delete(EquipeCommerciale t) {
       session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.getTransaction();
        session.beginTransaction();
        session.delete(t);

        tx.commit();

        session.close(); }

    @Override
    public void update(EquipeCommerciale t) {
      
    session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.getTransaction();
        session.beginTransaction();
        session.merge(t);
        session.flush();
        tx.commit();

        session.close();}
    
}
