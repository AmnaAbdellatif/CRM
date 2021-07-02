/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entites.Commercial;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author HP
 */
public class CommercialDAO implements CommercialDAOInterface<Commercial>{
    
    Commercial cr;
    static Session session = null;
        private Session currentSession;
     
    private Transaction currentTransaction;
 
    public CommercialDAO() {
        
    }
    Commercial findObj;
public List<Commercial> findCommercial() {
         session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.getTransaction();
        session.beginTransaction();
        List noms;
        //String fonction="commercial";
        noms = session.createCriteria(Commercial.class)
               // .setProjection(Projections.property("prenom"))
                
              //  .setProjection(Projections.property("nom"))
              //  .add(Restrictions.like("fonction", fonction))
      
                .list();
        tx.commit();
        session.close();
        return noms;
        
    }
public List<Commercial> findCommercialprenom() {
         session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.getTransaction();
        session.beginTransaction();
        List noms;
        noms = session.createCriteria(Commercial.class)
                .setProjection(Projections.property("prenom")) 
               // .setProjection(Projections.property("nom"))
                //.setProjection(Projections.property("fonction"))
                .list();
        tx.commit();
        session.close();
        return noms;
        
    }
public List<String> findCommercialfonction() {
         session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.getTransaction();
        session.beginTransaction();
        List noms;
        noms = session.createCriteria(Commercial.class)
                .setProjection(Projections.property("fonction")) 
               // .setProjection(Projections.property("nom"))
                //.setProjection(Projections.property("fonction"))
                .list();
        tx.commit();
        session.close();
        return noms;
        
    }

      
    @Override
    public void insert(Commercial t) {
         session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.getTransaction();
        session.beginTransaction();
        session.save(t);

        tx.commit();

        session.close();
         }

    @Override
    public void delete(Commercial t) {
       session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.getTransaction();
        session.beginTransaction();
        session.delete(t);

        tx.commit();

        session.close();}

    @Override
    public void update(Commercial t) {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.getTransaction();
        session.beginTransaction();
        session.merge(t);
        session.flush();
        tx.commit();

        session.close(); }
    public Commercial findbylogin(String Login, String motPasse) {
       // Personne findObj = null;
        try {
            System.out.println("dans fonction");
            // Getting Session Object From SessionFactory
            session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.getTransaction();
            session.beginTransaction();

            findObj = (Commercial) session.get(Commercial.class,Login);
              findObj = (Commercial) session.get(Commercial.class,motPasse);
        } catch (Exception sqlException) {
            if (null != session.getTransaction()) {
              //  logger.info("\n.......Transaction Is Being Rolled Back.......\n");
                session.getTransaction().rollback();
            }
            sqlException.printStackTrace();
        }
        return findObj;
        
    }
    public Commercial findbymotPasse( String motPasse) {
       // Personne findObj = null;
        try {
            System.out.println("dans fonction");
            // Getting Session Object From SessionFactory
            session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.getTransaction();
            session.beginTransaction();
               findObj = (Commercial) session.get(Commercial.class,motPasse);
        } catch (Exception sqlException) {
            if (null != session.getTransaction()) {
              //  logger.info("\n.......Transaction Is Being Rolled Back.......\n");
                session.getTransaction().rollback();
            }
            sqlException.printStackTrace();
        }
        return findObj;
        
    }
    
    
}
