package com.mybluecard.code.challenge.codechallengemybluecard.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mybluecard.code.challenge.codechallengemybluecard.model.ConversionDTO;

public interface ConversionService {
	
	public void persistConversionFromApiResponse(ConversionDTO dto)  throws JsonMappingException, JsonProcessingException, UnirestException;

}
