package com.sjsu.cmpe275.lab2.viewresolver;
 
import java.util.Locale;
 
import org.springframework.oxm.Marshaller;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.xml.MarshallingView;
 
public class Jaxb2MarshallingXmlViewResolver implements ViewResolver {
 
    private Marshaller marshaller;
 
    public Jaxb2MarshallingXmlViewResolver(Marshaller marshaller) {
        this.marshaller = marshaller;
    }
     
    public View resolveViewName(String viewName, Locale locale) throws Exception {
        MarshallingView view = new MarshallingView();
        view.setMarshaller(marshaller);
        return view;
    }
}