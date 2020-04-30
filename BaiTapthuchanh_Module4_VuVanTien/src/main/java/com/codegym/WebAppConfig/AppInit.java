package com.codegym.WebAppConfig;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

// ~ web.xml
public class AppInit extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] { WebAppConfig.class};
    }
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] { };
    }

        @Override
    protected String[] getServletMappings() {
        return new String[] { "/" }; // url-pattern
    }
}

