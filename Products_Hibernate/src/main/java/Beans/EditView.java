package Beans;

import Domain.Product;
import Domain.Category;
import Domain.Supplier;
import Service.Service;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.component.datatable.DataTable;
import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;
import java.util.ArrayList;
import javax.enterprise.context.SessionScoped;

@Named("dtEditView")
@ViewScoped
public class EditView implements Serializable {

    private ArrayList<Product> lista;
    private ArrayList<Category> categories;
    private ArrayList<Supplier> suppliers;
    private Product selectedProduct;
    private Product deleteProduct;
    private Product ProductDetail;
    private Product newProduct;
    private ArrayList<Product> filteredProducts;

    @Inject
    private Service service;

    @Inject
    private EditViewCategories editCategories;
    
   @Inject
   private SessionView sessionview;

    @PostConstruct
    public void init() {

        lista = (ArrayList<Product>) service.findAllProducts();

        setCategories((ArrayList<Category>) service.findAllCategories());
        suppliers = (ArrayList<Supplier>) service.findAllSuppliers();
        selectedProduct = new Product();
        selectedProduct.setProductID(0);
        newProduct = new Product();

    }

 

    public void onRowEdit(RowEditEvent event) {

    }

    public void onRowCancel(RowEditEvent event) {
    }

    public void onCellEdit(CellEditEvent event) {
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();

        Product pp = lista.get(event.getRowIndex());

        if (true) {
            if (service.updateProduct(pp) > 0) {
            } else {
                FacesMessage msj = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Contacte al administrador");
                FacesContext.getCurrentInstance().addMessage(null, msj);
            }
        }

    }
    
    public String botonEditar(){
       sessionview.setSelectedProduct(selectedProduct);
        return "editProduct";
    }

    public void onAddNew() {
        if (service.findAllCategories().size() > 0 && service.findAllCategories().size() > 0) {

            Product nuevo = new Product();
            nuevo.setProductName("Nombre Producto");

            nuevo.setCategoryID(categories.get(0));
            nuevo.setSupplierID(suppliers.get(0));

            if (service.saveProduct(nuevo) < 1) {
                FacesMessage msj = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Contacte al administrador");
                FacesContext.getCurrentInstance().addMessage(null, msj);
            } else {
                lista = (ArrayList<Product>) service.findAllProducts();
            }

        } else {
            FacesMessage msj = new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia!", "No ha agregado suppliers o categories");
            FacesContext.getCurrentInstance().addMessage(null, msj);
        }
    }

    public void botonEliminar() {
        if (service.deleteProduct(getDeleteProduct()) > 0) {
            getLista().remove(getDeleteProduct());
            FacesMessage msj = new FacesMessage("Deleted Entry");
            FacesContext.getCurrentInstance().addMessage(null, msj);
        } else {

            FacesMessage msj = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Contacte al administrador");
            FacesContext.getCurrentInstance().addMessage(null, msj);
        }
    }

    public void botonAgregarProducto() {
        if (service.saveProduct(newProduct) > 0) {
            lista = (ArrayList<Product>) service.findAllProducts();
            FacesMessage msj = new FacesMessage("Se a agregado un producto lokillo");
            FacesContext.getCurrentInstance().addMessage(null, msj);
            newProduct = new Product();
            lista = (ArrayList<Product>) service.findAllProducts();
        } else {
            FacesMessage msj = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "No agrego ningun producto");
            FacesContext.getCurrentInstance().addMessage(null, msj);
        }
    }

     public String botonGuardarProducto() {
        if (service.updateProduct(sessionview.getSelectedProduct()) > 0) {
            FacesMessage msj = new FacesMessage("Se han guardado los cambios");
            FacesContext.getCurrentInstance().addMessage(null, msj);
            selectedProduct = new Product();
            sessionview.setSelectedProduct(selectedProduct);
        } else {
            FacesMessage msj = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "No se guardo");
            FacesContext.getCurrentInstance().addMessage(null, msj);
        }
        
        return "products";
    }
     

     
     
    public ArrayList<Product> getFilteredProducts() {
        return filteredProducts;
    }

    public void setFilteredProducts(ArrayList<Product> filteredProducts) {
        this.filteredProducts = filteredProducts;
    }

    public Product getNewProduct() {
        return newProduct;
    }

    public void setNewProduct(Product newProduct) {
        this.newProduct = newProduct;
    }

    public ArrayList<Product> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Product> lista) {
        this.lista = lista;
    }

    public Product getSelectedProduct() {
        return selectedProduct;
    }

    public void setSelectedProduct(Product selectedProduct) {
        this.selectedProduct = selectedProduct;
    }

    public Product getDeleteProduct() {
        return deleteProduct;
    }

    public void setDeleteProduct(Product deleteProduct) {
        this.deleteProduct = deleteProduct;
    }

    public Product getProductDetail() {
        return ProductDetail;
    }

    public void setProductDetail(Product ProductDetail) {
        this.ProductDetail = ProductDetail;
    }

    public ArrayList<Category> getCategories() {
        return categories;
    }

    public void setCategories(ArrayList<Category> categories) {
        this.categories = categories;
    }

    public ArrayList<Supplier> getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(ArrayList<Supplier> suppliers) {
        this.suppliers = suppliers;
    }
}
