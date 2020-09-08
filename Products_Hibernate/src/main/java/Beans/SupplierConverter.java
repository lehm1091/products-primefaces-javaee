/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Domain.Supplier;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "SupplierConverter")
public class SupplierConverter implements Converter {

    private final static String DELIMITER = "~";

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {

        String[] parts = value.split(DELIMITER);
        Supplier result = new Supplier(Integer.valueOf(parts[0]), parts[1], parts[2], parts[3], parts[4]);

        return result;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {

        if (!(value instanceof Supplier)) {
            throw new RuntimeException(String.format("Inconvertable type: %s of value '%s'", value.getClass(), value));
        }

        Supplier sup = (Supplier) value;
        StringBuilder sb = new StringBuilder();
        sb
                .append(sup.getSupplierID())
                .append(DELIMITER)
                .append(sup.getCompanyName())
                .append(DELIMITER)
                .append(sup.getContacName())
                .append(DELIMITER)
                .append(sup.getAddress())
                .append(DELIMITER)
                .append(sup.getPhone())
                .append(DELIMITER);

        String result = new String(sb);

        return result;
    }
}
