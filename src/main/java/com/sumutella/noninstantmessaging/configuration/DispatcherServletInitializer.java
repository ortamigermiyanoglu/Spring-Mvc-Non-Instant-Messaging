package com.sumutella.noninstantmessaging.configuration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @author sumutella
 * @time 1:41 PM
 * @since 11/12/2019, Tue
 */
public class DispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{AppConfiguration.class};
    }


    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
