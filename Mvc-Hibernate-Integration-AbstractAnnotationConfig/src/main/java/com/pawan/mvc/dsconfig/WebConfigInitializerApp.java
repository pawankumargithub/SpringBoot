package com.pawan.mvc.dsconfig;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.pawan.mvc.configure.WebAppConfig;

public class WebConfigInitializerApp extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		
		return new Class[] {};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		
		return new Class[] {WebAppConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		
		return new String[] {"/"};
	}

}
