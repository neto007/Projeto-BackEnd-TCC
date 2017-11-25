package com.chegaai.utils;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import com.chegaai.authentication.OnlyUsarioAdmin;
import org.reflections.Reflections;
import org.reflections.scanners.MethodAnnotationsScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import java.lang.reflect.Method;
import java.util.Set;

public class ApplicationUtils {

	static public Object manualInjectByRequest(Object injectable, HttpServletRequest request) {
		ServletContext servletContext = request.getServletContext();
		WebApplicationContext webAppContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
		return webAppContext.getBean(injectable.getClass());
	}

    public static Set<Method> getMethodsByAnnotation(Class<OnlyUsarioAdmin> onlyUsarioAdminClass) {
		Reflections reflections = new Reflections(new ConfigurationBuilder()
				.setUrls(ClasspathHelper.forJavaClassPath())
				.setScanners(new MethodAnnotationsScanner()));

		return reflections.getMethodsAnnotatedWith(onlyUsarioAdminClass);
    }
}
