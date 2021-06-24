package dto;

import Domain.Category;
import Domain.Supplier;
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

    /**
     * @return the productID
     */
    public Integer getProductID() {
        return productID;
    }

    /**
     * @param productID the productID to set
     */
    public void setProductID(Integer productID) {
        this.productID = productID;
    }

    /**
     * @return the productName
     */
    public String getProductName() {
        return productName;
    }

    /**
     * @param productName the productName to set
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * @return the quantityPerUnit
     */
    public BigInteger getQuantityPerUnit() {
        return quantityPerUnit;
    }

    /**
     * @param quantityPerUnit the quantityPerUnit to set
     */
    public void setQuantityPerUnit(BigInteger quantityPerUnit) {
        this.quantityPerUnit = quantityPerUnit;
    }

    /**
     * @return the unitInstock
     */
    public Integer getUnitInstock() {
        return unitInstock;
    }

    /**
     * @param unitInstock the unitInstock to set
     */
    public void setUnitInstock(Integer unitInstock) {
        this.unitInstock = unitInstock;
    }

    /**
     * @return the unitPrice
     */
    public BigInteger getUnitPrice() {
        return unitPrice;
    }

    /**
     * @param unitPrice the unitPrice to set
     */
    public void setUnitPrice(BigInteger unitPrice) {
        this.unitPrice = unitPrice;
    }

   
  
    private Integer productID;
  
    private String productName;

    private BigInteger quantityPerUnit;

    private Integer unitInstock;

    private BigInteger unitPrice;
 

 

    public ProductDTO(Integer productID, String productName, BigInteger quantityPerUnit, Integer unitInstock, BigInteger unitPrice) {
        this.productID = productID;
        this.productName = productName;
        this.quantityPerUnit = quantityPerUnit;
        this.unitInstock = unitInstock;
        this.unitPrice = unitPrice;
    }

    
}
