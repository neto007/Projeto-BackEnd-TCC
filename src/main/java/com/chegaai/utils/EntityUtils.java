package com.chegaai.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.management.RuntimeErrorException;

import org.springframework.security.core.context.SecurityContextHolder;

import com.chegaai.authentication.Token;
import com.chegaai.commons.DefaultEntity;
import com.chegaai.user.User;
import com.chegaai.user.UserRepository;

public class EntityUtils {
	static public void setResourceToCurrentUser(DefaultEntity entity, UserRepository userRepo) {
		setResourceToCurrentUser(entity, userRepo, "owner");
	}

	private static void setResourceToCurrentUser(DefaultEntity entity, UserRepository userRepo, String field) {
		Token token = (Token) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		Method setOwnerMethod;
		
		try {
			setOwnerMethod = entity.getClass().getDeclaredMethod("set" + WordUtils.capitalize(field), User.class);
		} catch (NoSuchMethodException | SecurityException e) {
			throw new RuntimeErrorException(null, "Method set" + WordUtils.capitalize(field) + "() not found in "+ entity.getClass().getName());
		}
		
		try {
			setOwnerMethod.invoke(entity, userRepo.getOne(token.getSubject()));
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			throw new RuntimeErrorException(null, "Method set" + WordUtils.capitalize(field) + " is invalid in "+ entity.getClass().getName());
		}
	}
}
