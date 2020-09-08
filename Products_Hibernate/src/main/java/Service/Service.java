/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Domain.Category;
import Domain.Product;
import Domain.Supplier;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author DSC-L
 */
@Local
public interface Service {

    public List<Product> findAllProducts();

    public List<Category> findAllCategories();

    public List<Supplier> findAllSuppliers();

    public Product getProductByID(int id);

    public int updateProduct(Product producto);

    public int saveProduct(Product producto);

    public int deleteProduct(Product producto);

    public int updateCategories(Category categoria);

    public int saveCategories(Category categoria);

    public int deleteCategories(Category categoria);

    public int updateSupplier(Supplier supplier);

    public int saveSupplier(Supplier supplier);

    public int deleteSupplier(Supplier supplier);

    public Category getCategory(int id);

    public Product getProduct(int id);

    public Supplier getSupplier(int id);
}
