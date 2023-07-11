package com.mybluecard.code.challenge.codechallengemybluecard.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mybluecard.code.challenge.codechallengemybluecard.domain.Conversion;
import com.mybluecard.code.challenge.codechallengemybluecard.model.ConversionDTO;
import com.mybluecard.code.challenge.codechallengemybluecard.model.RapidApiResponse;
import com.mybluecard.code.challenge.codechallengemybluecard.repository.ConversionRepository;
import com.mybluecard.code.challenge.codechallengemybluecard.service.ConsultRapidApiService;
import com.mybluecard.code.challenge.codechallengemybluecard.service.ConversionService;

@Service
public class ConversionServiceImpl implements ConversionService {
	
	@Autowired
	private ConversionRepository conversionRepository; 
	
	@Autowired
	private ConsultRapidApiService apiService;

	@Override
	public void persistConversionFromApiResponse(ConversionDTO dto) throws JsonMappingException, JsonProcessingException, UnirestException {
		RapidApiResponse apiResponse = apiService.consultApi(dto);
		Conversion conversion = new Conversion();
		conversion.buildFromApiResponse(apiResponse);
		conversionRepository.save(conversion);
	}

}
