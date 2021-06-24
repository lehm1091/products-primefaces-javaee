/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import domainOrcl.Category;
import java.math.BigDecimal;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;


@FacesConverter(value = "CategoryConverter")
public class CategoryConverter implements Converter {
  
    private final static String DELIMITER = "~";

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        
        String[] parts = value.split(DELIMITER);
        Category result = new Category(BigDecimal.valueOf(Integer.valueOf(parts[0])), parts[1], parts[2]);

        return result;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {

        if (!(value instanceof Category)) {
            throw new RuntimeException(String.format("Inconvertable type: %s of value '%s'", value.getClass(), value));
        }

        Category category = (Category) value;
        StringBuilder sb = new StringBuilder();
        sb
                .append(category.getCategoryId())
                .append(DELIMITER)
                .append(category.getCategoryName())
                .append(DELIMITER)
                .append(category.getDescription());

        String result = new String(sb);

        return result;
    }
}
