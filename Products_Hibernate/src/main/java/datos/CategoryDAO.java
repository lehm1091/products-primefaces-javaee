/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import Domain.Category;
import Domain.Product;
import java.sql.SQLException;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Alumnos
 */

@Local
public interface CategoryDAO {

    public List<Category> select() throws SQLException;

    public int insert(Category cat) throws SQLException;

    public int update(Category cat) throws SQLException;

    public int delete(Category cat) throws SQLException;
    
    public Category getCategory(int id) throws SQLException;
    

}
