package dto;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Luis
 */
public class ProductDTO {

    private BigDecimal productId;
   
    private String productName;
   
    private Double unitPrice;
   
    private BigInteger quantityPerUnit;

    public ProductDTO(BigDecimal productId, String productName, Double unitPrice, BigInteger quantityPerUnit, BigInteger unitInStock) {
        this.productId = productId;
        this.productName = productName;
        this.unitPrice = unitPrice;
        this.quantityPerUnit = quantityPerUnit;
        this.unitInStock = unitInStock;
    }
  
    private BigInteger unitInStock;

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

}
