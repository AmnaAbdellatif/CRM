/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import static DAO.EquipeDAO.session;
import Entites.EquipeCommerciale;
import Entites.Historique;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author HP
 */
public class HistoriqueDAO implements HistoriqueInterfaceDAO<Historique>{
    EquipeCommerciale eq;
    static Session session = null;
        private Session currentSession;
     
    private Transaction currentTransaction;
     public HistoriqueDAO() {
         
     }
public List<Historique> findlistCommerc(String nomEquipe) {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.getTransaction();
        session.beginTransaction();
        List noms;
        noms = session.createCriteria(Historique.class)
                .add(Restrictions.like("nomEquipe", nomEquipe))
                .list();
        tx.commit();
        session.close();
        return noms;
    }
   

    @Override
    public void insert(Historique t) {
         session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.getTransaction();
        session.beginTransaction();
        session.save(t);

        tx.commit();

        session.close();
          }

    @Override
    public void delete(Historique t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Historique t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
        
    
    
}
