/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import domainOrcl.Product;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Luis
 */
@Stateless
public class ProductDAODefault implements ProductDAO {

    @PersistenceContext(unitName = "ProductsPU")
    EntityManager em;

    @Override
    public List<Product> select() throws SQLException {
        return new ArrayList<>(em.createNamedQuery("Product.findAll").getResultList());
    }

    @Override
    public int insert(Product p) throws SQLException {
        boolean flag = true;
        try {
            em.persist(p);

        } catch (Exception e) {
            e.printStackTrace();
            flag = false;

        }
        return flag ? 1 : 0;
    }

    @Override
    public int update(Product p) throws SQLException {
        boolean flag = true;
        try {
            em.merge(p);

        } catch (Exception e) {
            e.printStackTrace();
            flag = false;

        }
        return flag ? 1 : 0;
    }

    @Override
    public int delete(Product p) throws SQLException {
        boolean flag = true;
        try {
            em.remove(em.merge(p));

        } catch (Exception e) {
            e.printStackTrace();
            flag = false;

        }
        return flag ? 1 : 0;
    }

    @Override
    public Product getProduct(int id) throws SQLException {
        return em.find(Product.class, BigDecimal.valueOf(id));
    }

}
