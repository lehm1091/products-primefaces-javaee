package Beans;

import Domain.Supplier;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;
import java.util.ArrayList;
import Service.Service;


@Named("dtEditViewSuppliers")
@ViewScoped
public class EditViewSuppliers implements Serializable {

    private ArrayList<Supplier> suppliers;
    private Supplier supplierToDelete;
    private Supplier supplierDetail;
    private Supplier selectedSupplier;
    private Supplier newSupplier;

    @Inject
    Service service;

    @PostConstruct
    public void init() {

        setSuppliers((ArrayList<Supplier>) service.findAllSuppliers());
        selectedSupplier = new Supplier();
        selectedSupplier.setSupplierID(0);
        newSupplier = new Supplier();
    }

    public String viewDetails() {

        return "vistaAparte";
    }

    public void onRowEdit(RowEditEvent event) {
    }

    public void onRowCancel(RowEditEvent event) {
    }

    public void onCellEdit(CellEditEvent event) {
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();

        Supplier ss = suppliers.get(event.getRowIndex());

        if (newValue != null && !newValue.equals(oldValue)) {
            if (service.updateSupplier(ss) > 0) {
            } else {
                FacesMessage msj = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Contacte al mero mero");
                FacesContext.getCurrentInstance().addMessage(null, msj);
            }
        }
    }

    public void onAddNew() {
        Supplier sup = new Supplier();
        sup.setCompanyName("test");

        if (service.saveSupplier(sup) < 1) {
            FacesMessage msj = new FacesMessage(FacesMessage.SEVERITY_ERROR, "error", "contacte al programador");
            FacesContext.getCurrentInstance().addMessage(null, msj);
        } else {
            suppliers = (ArrayList<Supplier>) service.findAllSuppliers();
        }

    }

    public void botonEliminar() {
        if (service.deleteSupplier(supplierToDelete) > 0) {
            suppliers.remove(supplierToDelete);
            FacesMessage msj = new FacesMessage("Deleted Entry");
            FacesContext.getCurrentInstance().addMessage(null, msj);
        } else {

            FacesMessage msj = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "contacte al lokillo");
            FacesContext.getCurrentInstance().addMessage(null, msj);
        }
    }

    public void bontonGuardarSupplier() {
        if (service.saveSupplier(newSupplier) > 0) {
            suppliers = (ArrayList<Supplier>) service.findAllSuppliers();
            FacesMessage msj = new FacesMessage("Se a agregado un supplier siiiuuuuuu!!");
            FacesContext.getCurrentInstance().addMessage(null, msj);
            newSupplier = new Supplier();
        } else {
            FacesMessage msj = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "No sea loco agregue un supplier");
            FacesContext.getCurrentInstance().addMessage(null, msj);
        }
    }

    //****getss y sets
    public Supplier getNewSupplier() {
        return newSupplier;
    }

    public void setNewSupplier(Supplier newSupplier) {
        this.newSupplier = newSupplier;
    }

    public ArrayList<Supplier> getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(ArrayList<Supplier> suppliers) {
        this.suppliers = suppliers;
    }

    public Supplier getSupplierToDelete() {
        return supplierToDelete;
    }

    public void setSupplierToDelete(Supplier supplierToDelete) {
        this.supplierToDelete = supplierToDelete;
    }

    public Supplier getSupplierDetail() {
        return supplierDetail;
    }

    public void setSupplierDetail(Supplier supplierDetail) {
        this.supplierDetail = supplierDetail;
    }

    public Supplier getSelectedSupplier() {
        return selectedSupplier;
    }

    public void setSelectedSupplier(Supplier selectedSupplier) {
        this.selectedSupplier = selectedSupplier;
    }

}
