/*
 * package com.pawan.mvc.dsconfig;
 * 
 * import javax.servlet.ServletContext; import javax.servlet.ServletException;
 * import javax.servlet.ServletRegistration;
 * 
 * import org.springframework.web.WebApplicationInitializer; import
 * org.springframework.web.context.support.
 * AnnotationConfigWebApplicationContext; import
 * org.springframework.web.servlet.DispatcherServlet;
 * 
 * import com.pawan.mvc.configure.WebAppConfig;
 * 
 * public class WebAppInitializer implements WebApplicationInitializer {
 * 
 * @Override public void onStartup(ServletContext servletContext) throws
 * ServletException { AnnotationConfigWebApplicationContext context=new
 * AnnotationConfigWebApplicationContext();
 * context.register(WebAppConfig.class);
 * context.setServletContext(servletContext); ServletRegistration.Dynamic
 * dispatcher=servletContext.addServlet("DispatcherServlet", new
 * DispatcherServlet(context)); dispatcher.setLoadOnStartup(1);
 * dispatcher.addMapping("/");
 * 
 * }
 * 
 * }
 */