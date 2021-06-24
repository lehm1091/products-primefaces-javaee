/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import domainOrcl.Category;
import domainOrcl.Supplier;
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
public class CategoryDAODefault implements CategoryDAO {

    @PersistenceContext(unitName = "ProductsPU")
    EntityManager em;

    @Override
    public List<Category> select() throws SQLException {
        return new ArrayList<>(em.createNamedQuery("Category.findAll").getResultList());
    }

    @Override
    public int insert(Category s) throws SQLException {
        boolean flag = true;
        try {
            em.persist(s);

        } catch (Exception e) {
            e.printStackTrace();
            flag = false;
        }

        return flag ? 1 : 0;
    }

    @Override
    public int update(Category s) throws SQLException {
        boolean flag = true;
        try {
            em.merge(s);

        } catch (Exception e) {
            e.printStackTrace();
            flag = false;

        }
        return flag ? 1 : 0;
    }

    @Override
    public int delete(Category s) throws SQLException {
        boolean flag = true;
        try {
            em.remove(em.merge(s));
        } catch (Exception e) {
            e.printStackTrace();
            flag = false;
        }
        return flag ? 1 : 0;
    }

    @Override
    public Category getCategory(int id) throws SQLException {
        return em.find(Category.class, BigDecimal.valueOf(id));
    }
}
