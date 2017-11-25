package com.chegaai.authentication;

import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;

import com.chegaai.user.UserBasicData;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class Token  {
	static final String SECRET = "asdas44qw4_@%34SD";
	static final int DAYS_TO_EXPIRE = 365;
	static final String USER_BASIC_DATA_CLAIMS = "_user";

	private String token;
	private Date expirationDate;
	private String subject;
	private UserBasicData userBasicData;

	public Token(String token, Date expireIn, String subject, UserBasicData userBasicData) {
		this.token = token;
		this.expirationDate = expireIn;
		this.subject = subject;
		this.userBasicData = userBasicData;
	}
	
	public String getToken() {
		return token;
	}

	public static Token factoryByString(String token) {
		Jws<Claims> claims = Jwts.parser()
			.setSigningKey(SECRET)
			.parseClaimsJws(token);
		
		return new Token(
				token,
				claims.getBody().getExpiration(),
				claims.getBody().getSubject(),
				new UserBasicData((LinkedHashMap<String, String>) claims.getBody().get(USER_BASIC_DATA_CLAIMS))
		);		
	}

	public String getSubject() {
		return subject;
	}
	
	public Date getExpirationDate() {
		return expirationDate;
	}

	public static Token factoryBySubject(String subject, UserBasicData userBasicData) {
		Date expirationDate = generateExpireDate();
		
		String token = Jwts.builder()
				.setSubject(subject)
				.setExpiration(expirationDate)
				.claim(USER_BASIC_DATA_CLAIMS, userBasicData)
				.signWith(SignatureAlgorithm.HS256, SECRET)
				.compact();
		
		return new Token(
				token,
				expirationDate,
				subject,
				userBasicData
	    );
	}
	
	private static Date generateExpireDate() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, DAYS_TO_EXPIRE);
		
		return calendar.getTime();
	}
}
