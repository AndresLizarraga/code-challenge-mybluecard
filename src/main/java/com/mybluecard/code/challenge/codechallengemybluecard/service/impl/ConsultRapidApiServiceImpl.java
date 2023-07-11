package com.mybluecard.code.challenge.codechallengemybluecard.service.impl;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mybluecard.code.challenge.codechallengemybluecard.exception.RapidApiException;
import com.mybluecard.code.challenge.codechallengemybluecard.model.ConversionDTO;
import com.mybluecard.code.challenge.codechallengemybluecard.model.RapidApiResponse;
import com.mybluecard.code.challenge.codechallengemybluecard.service.ConsultRapidApiService;

@Service
public class ConsultRapidApiServiceImpl implements ConsultRapidApiService {

	private static String API_KEY = "3460b91731msh8a9e7486e13de16p1d0d4ejsn103266a82b3a";
	
	@Override
	public RapidApiResponse consultApi(ConversionDTO conversion) throws UnirestException, JsonMappingException, JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
    	
	  	  HttpResponse<String> response = Unirest.post("https://community-neutrino-currency-conversion.p.rapidapi.com/convert")
	  				.header("content-type", "application/x-www-form-urlencoded")
	  				.header("X-RapidAPI-Key", API_KEY)
	  				.header("X-RapidAPI-Host", "community-neutrino-currency-conversion.p.rapidapi.com")
	  				.body("from-value="
	  						+ conversion.fromValue + "&from-type="
	  						+ conversion.fromType + "&to-type=" 
	  						+ conversion.toType)
	  				.asString();
	  	  if (response.getCode() != 200)
	  		  throw new RapidApiException("An error occurred querying the api");
	  	  
	  	  String resp = response.getBody();
	  	  
	  	  RapidApiResponse rAR = objectMapper.readValue(resp, RapidApiResponse.class);
  	  
  	  return rAR;
	}

}
