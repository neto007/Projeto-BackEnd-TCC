package com.chegaai.utils;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

public class RequestUtils {
    public static final String CURRENT_USER = "current_user";
    public static final String FACEBOOK_USER = "facebook_user";

    public static Object getRequestAttribute(String key) {
        return RequestContextHolder.getRequestAttributes().getAttribute(key, RequestAttributes.SCOPE_REQUEST);
    }

    public static void setRequestAttribute(String key, Object value) {
        RequestContextHolder.getRequestAttributes().setAttribute(key, value, RequestAttributes.SCOPE_REQUEST);
    }
}
