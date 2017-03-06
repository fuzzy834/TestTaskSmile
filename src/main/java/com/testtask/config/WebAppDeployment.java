package com.testtask.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * Created by Vitalii on 3/3/2017.
 */
public class WebAppDeployment implements WebApplicationInitializer {

    public void onStartup(ServletContext servletContext) throws ServletException {

        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(SpringMVC.class);

        ContextLoaderListener contextLoaderListener = new ContextLoaderListener(context);
        servletContext.addListener(contextLoaderListener);

        AnnotationConfigWebApplicationContext dispatcherServlet = new AnnotationConfigWebApplicationContext();
        dispatcherServlet.register(SpringMVC.class);

        ServletRegistration.Dynamic dispatcher = servletContext.addServlet
                (
                        "dispatcher",
                        new DispatcherServlet(dispatcherServlet)
                );
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");
    }
}
