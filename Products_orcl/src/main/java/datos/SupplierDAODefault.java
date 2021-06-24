/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

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
public class SupplierDAODefault implements SupplierDAO {

    @PersistenceContext(unitName = "ProductsPU")
    EntityManager em;

    @Override
    public List<Supplier> select() throws SQLException {
        return new ArrayList<>(em.createNamedQuery("Supplier.findAll").getResultList());
    }

    @Override
    public int insert(Supplier s) throws SQLException {
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
    public int update(Supplier s) throws SQLException {
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
    public int delete(Supplier s) throws SQLException {
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
    public Supplier getSupplier(int id) throws SQLException {
        return em.find(Supplier.class, BigDecimal.valueOf(id));
    }

}
