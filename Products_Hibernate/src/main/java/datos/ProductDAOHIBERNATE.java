/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import Domain.Category;
import Domain.Product;
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
public class ProductDAOHIBERNATE implements ProductDAO, Serializable {

    public final static Logger logger = Logger.getLogger(ProductDAOHIBERNATE.class);

    @Override
    public List<Product> select() throws SQLException {
        List<Product> lista = new ArrayList();
        Transaction transaction = null;

        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // operate the object
            lista = session.createQuery("FROM Product").list();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }

        return lista;
    }

    @Override
    public int insert(Product pro) throws SQLException {
        Transaction transaction = null;
        int flag = 0;
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // operate the object
            session.save(pro);
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
    public int update(Product pro) throws SQLException {
        Transaction transaction = null;
        int flag = 0;
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // operate the object
            session.update(pro);
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
    public int delete(Product pro) throws SQLException {
        Transaction transaction = null;
        int flag = 0;
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // operate the object
            session.delete(pro);
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
    public Product getProduct(int id) throws SQLException {
       Transaction transaction = null;
       Product pro = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();

            // get category entity using get() method
             pro = session.get(Product.class, id);
          

            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        
        return pro;
    }

}
