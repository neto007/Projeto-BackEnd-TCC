package com.chegaai.utils;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.chegaai.commons.DefaultEntity;

public class ResponseUtils {

	public static ResponseEntity<Object> created(DefaultEntity entity) {
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest().path("/{id}")
				.buildAndExpand(entity.getId())
				.toUri();
		
		return ResponseEntity.created(location).build();
	}

	public static ResponseEntity<Object> updated(DefaultEntity entity) {
		return ResponseEntity.ok().body(entity);
	}
}

