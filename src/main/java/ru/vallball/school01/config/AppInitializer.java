package ru.vallball.school01.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
	public static final String CHARACTER_ENCODING = "UTF-8";

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { JpaConfig.class, ApplicationConfiguration.class, WebSecurityConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return null;
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

}
