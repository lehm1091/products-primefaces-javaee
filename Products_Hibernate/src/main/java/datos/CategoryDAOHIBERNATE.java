/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import Domain.Category;
import java.io.Serializable;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.jboss.logging.Logger;
import test.HibernateUtil;

/**
 *
 * @author lehm
 */
@Stateless
public class CategoryDAOHIBERNATE implements CategoryDAO, Serializable {

    public final static Logger logger = Logger.getLogger(CategoryDAOHIBERNATE.class);

    @Override
    public List<Category> select() throws SQLException {
        List<Category> lista = new ArrayList();
        Transaction transaction = null;

        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // operate the object
            lista = session.createQuery("FROM Category").list();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }

        return lista;
    }

    @Override
    public int insert(Category cat) throws SQLException {
        Transaction transaction = null;
        int flag = 0;
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // operate the object
            session.save(cat);
            // commit transaction
            transaction.commit();
            flag = 1;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }

        return flag;
    }

    @Override
    public int update(Category cat) throws SQLException {
        Transaction transaction = null;
        int flag = 0;
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // operate the object
            session.update(cat);
            // commit transaction
            transaction.commit();
            flag = 1;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }

        return flag;
    }

    @Override
    public int delete(Category cat) throws SQLException {
        Transaction transaction = null;
        int flag = 0;
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // operate the object
            session.delete(cat);
            // commit transaction
            transaction.commit();
            flag = 1;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }

        return flag;
    }

    @Override
    public Category getCategory(int id) throws SQLException {
       Transaction transaction = null;
       Category cat = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();

            // get category entity using get() method
             cat = session.get(Category.class, id);
          

            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        
        return cat;
    }

}
