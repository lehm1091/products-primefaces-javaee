/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import domainOrcl.*;
import datos.CategoryDAO;

import datos.ProductDAO;
import datos.SupplierDAO;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author lehm
 */
@Stateless
@Default
public class ServiceDefault implements Service, Serializable {

    @Inject
    CategoryDAO categoryDao;

    @Inject
    SupplierDAO supplierDao;

    @Inject
    ProductDAO productDao;

    @Override
    public List<Product> findAllProducts() {
        List<Product> lista = null;
        try {

            lista = productDao.select();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("Entramos al rollback");

        }

        return lista;
    }

    @Override
    public List<Category> findAllCategories() {

        List<Category> lista = null;
        try {

            lista = categoryDao.select();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("Entramos al rollback");

        }

        return lista;
    }

    @Override
    public List<Supplier> findAllSuppliers() {
        List<Supplier> lista = null;
        try {

            lista = supplierDao.select();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("Entramos al rollback");

        }

        return lista;
    }

    @Override
    public Product getProductByID(int arg0) {
        return null;
    }

    @Override
    public int updateProduct(Product arg0) {
        int c = 0;
        try {
            c = productDao.update(arg0);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("Entramos al rollback");

        }

        return c;
    }

    @Override
    public int saveProduct(Product arg0) {
        int c = 0;
        try {
            c = productDao.insert(arg0);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("Entramos al rollback");

        }

        return c;
    }

    @Override
    public int deleteProduct(Product arg0) {
        int c = 0;
        try {
            c = productDao.delete(arg0);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("Entramos al rollback");

        }

        return c;
    }

    @Override
    public int updateCategories(Category arg0) {
        int c = 0;
        try {
            c = categoryDao.update(arg0);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("Entramos al rollback");

        }

        return c;
    }

    @Override
    public int saveCategories(Category arg0) {
        int c = 0;
        try {
            c = categoryDao.insert(arg0);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("Entramos al rollback");

        }

        return c;
    }

    @Override
    public int deleteCategories(Category arg0) {
        int c = 0;
        try {
            c = categoryDao.delete(arg0);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("Entramos al rollback");

        }

        return c;
    }

    @Override
    public int updateSupplier(Supplier arg0) {
        int c = 0;
        try {
            c = supplierDao.update(arg0);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("Entramos al rollback");

        }

        return c;
    }

    @Override
    public int saveSupplier(Supplier arg0) {
     
        try {
            return supplierDao.insert(arg0);
           

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("Entramos al rollback");
            return 0;

        }

       
    }

    @Override
    public int deleteSupplier(Supplier arg0) {
        int c = 0;
        try {
            c = supplierDao.delete(arg0);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("Entramos al rollback");

        }

        return c;
    }

    @Override
    public Category getCategory(int id) {

        try {
            return categoryDao.getCategory(id);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("Entramos al rollback");
            return null;

        }

    }

    @Override
    public Product getProduct(int id) {
        try {
            return productDao.getProduct(id);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("Entramos al rollback");
            return null;

        }
    }

    @Override
    public Supplier getSupplier(int id) {
        try {
            return supplierDao.getSupplier(id);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("Entramos al rollback");
            return null;

        }
    }

}
