package com.mybluecard.code.challenge.codechallengemybluecard.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mybluecard.code.challenge.codechallengemybluecard.model.ConversionDTO;
import com.mybluecard.code.challenge.codechallengemybluecard.model.RapidApiResponse;

public interface ConsultRapidApiService {

	public RapidApiResponse consultApi(ConversionDTO dto) throws UnirestException, JsonMappingException, JsonProcessingException;
	
}
