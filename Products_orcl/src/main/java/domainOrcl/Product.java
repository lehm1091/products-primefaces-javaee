/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domainOrcl;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Luis
 */
@Entity
@Table(name = "PRODUCTS.PRODUCTS")
@NamedQueries({
    @NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p")})
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Column(name = "PRODUCT_ID", precision = 38, scale = 0)
    private BigDecimal productId;
    @Size(max = 20)
    @Column(name = "PRODUCT_NAME", length = 20)
    private String productName;
    @Column(name = "UNIT_PRICE", precision = 126)
    private Double unitPrice;
    @Column(name = "QUANTITY_PER_UNIT")
    private BigInteger quantityPerUnit;
    @Column(name = "UNIT_IN_STOCK")
    private BigInteger unitInStock;
    @JoinColumn(name = "CATEGORY_ID", referencedColumnName = "CATEGORY_ID")
    @ManyToOne(fetch = FetchType.EAGER)
    private Category categoryId;
    @JoinColumn(name = "SUPPLIER_ID", referencedColumnName = "SUPPLIER_ID")
    @ManyToOne(fetch = FetchType.EAGER)
    private Supplier supplierId;

    public Product() {
    }

    public Product(BigDecimal productId) {
        this.productId = productId;
    }

    public BigDecimal getProductId() {
        return productId;
    }

    public void setProductId(BigDecimal productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public BigInteger getQuantityPerUnit() {
        return quantityPerUnit;
    }

    public void setQuantityPerUnit(BigInteger quantityPerUnit) {
        this.quantityPerUnit = quantityPerUnit;
    }

    public BigInteger getUnitInStock() {
        return unitInStock;
    }

    public void setUnitInStock(BigInteger unitInStock) {
        this.unitInStock = unitInStock;
    }

    public Category getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Category categoryId) {
        this.categoryId = categoryId;
    }

    public Supplier getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Supplier supplierId) {
        this.supplierId = supplierId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productId != null ? productId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Product)) {
            return false;
        }
        Product other = (Product) object;
        if ((this.productId == null && other.productId != null) || (this.productId != null && !this.productId.equals(other.productId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domainOrcl.Product[ productId=" + productId + " ]";
    }

    public Product(BigDecimal productId, String productName, Double unitPrice, BigInteger quantityPerUnit, BigInteger unitInStock) {
        this.productId = productId;
        this.productName = productName;
        this.unitPrice = unitPrice;
        this.quantityPerUnit = quantityPerUnit;
        this.unitInStock = unitInStock;
    }

}
