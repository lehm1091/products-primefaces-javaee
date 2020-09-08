package Beans;

import Domain.Category;
import Domain.Product;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.component.datatable.DataTable;
import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;
import java.util.ArrayList;
import Service.Service;
import Service.ServiceHibernate;
import java.util.Objects;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;

import javax.faces.bean.ManagedBean;

import javax.faces.view.ViewScoped;

//@ManagedBean(name ="dtEditViewCategories")
@Named("dtEditViewCategories")
@ViewScoped
public class EditViewCategories implements Serializable {

    private ArrayList<Category> categories;
    private Category categoryToDelete;
    private Category categoryDetail;
    private Category selectedCategory;
    private Category newCategory;
    private ArrayList<Product> orderByForProducts;

    @Inject
    private Service service;

   
    @PostConstruct
    public void init() {
        
        setCategories((ArrayList<Category>) service.findAllCategories());
        selectedCategory = new Category();
        selectedCategory.setCategoryID(0);
        newCategory = new Category();
        System.out.println("entramos a init**********************");

    }
    

    public String botonVerProducts() {

        return "products";
    }

    public void onRowEdit(RowEditEvent event) {
    }

    public void onRowCancel(RowEditEvent event) {
    }

    public void onCellEdit(CellEditEvent event) {
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();

        Category cc = categories.get(event.getRowIndex());

        if (newValue != null && !newValue.equals(oldValue)) {
            if (service.updateCategories(cc) > 0) {
            } else {
                FacesMessage msj = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Contacte al mero mero");
                FacesContext.getCurrentInstance().addMessage(null, msj);
            }
        }
    }

    public void onAddNew() {
        Category categoria = new Category();
        categoria.setCategoryName("Categoria");

        if (service.saveCategories(categoria) < 1) {
            FacesMessage msj = new FacesMessage(FacesMessage.SEVERITY_ERROR, "error", "contacte al programador");
            FacesContext.getCurrentInstance().addMessage(null, msj);
        } else {
            categories = (ArrayList<Category>) service.findAllCategories();
        }

    }

    public void botonEliminar() {
        if (service.deleteCategories(categoryToDelete) > 0) {
            categories.remove(categoryToDelete);
            FacesMessage msj = new FacesMessage("Deleted Entry");
            FacesContext.getCurrentInstance().addMessage(null, msj);
        } else {

            FacesMessage msj = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Contacte al administrador");
            FacesContext.getCurrentInstance().addMessage(null, msj);
        }
    }

    public void botonGuardarCategoria() {
        if (service.saveCategories(newCategory) > 0) {
            categories = (ArrayList<Category>) service.findAllCategories();
            FacesMessage msj = new FacesMessage("Se a agregado una categoria uuuuuu!!");
            FacesContext.getCurrentInstance().addMessage(null, msj);
            newCategory = new Category();
        } else {
            FacesMessage msj = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "No sea loco agregue una categoria");
            FacesContext.getCurrentInstance().addMessage(null, msj);
        }
    }

  

    public Category getNewCategory() {
        return newCategory;
    }

    public void setNewCategory(Category newCategory) {
        this.newCategory = newCategory;
    }

    //****getss y sets
    public ArrayList<Category> getCategories() {
        return categories;
    }

    public void setCategories(ArrayList<Category> categories) {
        this.categories = categories;
    }

    public Category getCategoryToDelete() {
        return categoryToDelete;
    }

    public void setCategoryToDelete(Category categoryToDelete) {
        this.categoryToDelete = categoryToDelete;
    }

    public Category getCategoryDetail() {
        return categoryDetail;
    }

    public void setCategoryDetail(Category categoryDetail) {
        this.categoryDetail = categoryDetail;
    }

    public Category getSelectedCategory() {
        return selectedCategory;
    }

    public void setSelectedCategory(Category selectedCategory) {
        this.selectedCategory = selectedCategory;
    }

    public ArrayList<Product> getOrderByForProducts() {
        return orderByForProducts;
    }

    public void setOrderByForProducts(ArrayList<Product> orderByForProducts) {
        this.orderByForProducts = orderByForProducts;
    }
}
