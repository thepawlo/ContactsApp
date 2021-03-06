package com.converters;


import com.facade.ContactCategoriesFacade;
import com.model.MainContactCategory;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

/**
 * Created by Pawel on 2017-05-12.
 */

@ManagedBean
@ApplicationScoped
@FacesConverter(forClass = MainContactCategory.class)
public class MainContactCategoryConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        ContactCategoriesFacade contactCategoriesFacade = new ContactCategoriesFacade();
        int mainCategoryId;

        try {
            mainCategoryId = Integer.parseInt(s);
        } catch (NumberFormatException exception) {
            throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR,"Choose category", "Choose category"));
        }

        return contactCategoriesFacade.findMainCategory(mainCategoryId);
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        if (o == null) {
            return "";
        }
        MainContactCategory mainContactCategory = (MainContactCategory) o;
        return String.valueOf(mainContactCategory.getId());
    }
}
