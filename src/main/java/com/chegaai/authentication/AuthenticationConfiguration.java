package com.chegaai.authentication;

import java.lang.reflect.Method;

import org.springframework.context.annotation.Configuration;
import org.springframework.util.ReflectionUtils;

@Configuration
public class AuthenticationConfiguration {

    public AuthenticationConfiguration() throws Exception {
        configureOnlyUsuarioAdmin();
    }

    private void configureOnlyUsuarioAdmin() {
        new ReflectionUtils.MethodCallback() {
            @Override
            public void doWith(Method method) throws IllegalArgumentException, IllegalAccessException {
                if(!method.isAnnotationPresent(OnlyUsarioAdmin.class)) {
                    return;
                }

                throw new RuntimeException("DEU ERROR PORRA!");
            }
        };
    }
}
