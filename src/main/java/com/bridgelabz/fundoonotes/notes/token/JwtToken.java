package com.bridgelabz.fundoonotes.notes.token;

import javax.xml.bind.DatatypeConverter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.bridgelabz.fundoonotes.notes.exceptions.TokenParsingException;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@Service
public class JwtToken {

	@Value("${mykey}")
	String KEY;

	/**
	 * Method to access token
	 * @param jwt
	 * @throws TokenParsingException 
	 */
	public void parseJWT(String jwt) throws TokenParsingException{
		Claims claims;
		
		try {
		    	 claims = Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary(KEY)).parseClaimsJws(jwt)
				.getBody();
		    }
		      catch(Exception exception) {
		    	  throw new TokenParsingException("Malformed Token");
		      }
		      
		
	}
	
	public String getUserId(String jwt) throws TokenParsingException {
		Claims claims;
		try {
			claims = Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary(KEY)).parseClaimsJws(jwt)
					.getBody();
		}
		catch (Exception e) {
			throw new TokenParsingException("Malformed Token");
		}
		return  claims.getSubject();
	}
	
	
}
