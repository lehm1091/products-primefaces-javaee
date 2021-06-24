/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import domainOrcl.Product;
import java.sql.SQLException;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Alumnos
 */
@Local
public interface ProductDAO {

    public List<Product> select() throws SQLException;

    public int insert(Product p) throws SQLException;

    public int update(Product p) throws SQLException;

    public int delete(Product p) throws SQLException;

    public Product getProduct(int id) throws SQLException;
}
