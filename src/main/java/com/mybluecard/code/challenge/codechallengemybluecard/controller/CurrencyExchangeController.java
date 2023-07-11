package com.mybluecard.code.challenge.codechallengemybluecard.controller;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mybluecard.code.challenge.codechallengemybluecard.domain.Conversion;
import com.mybluecard.code.challenge.codechallengemybluecard.domain.CurrencyExchange;
import com.mybluecard.code.challenge.codechallengemybluecard.model.ConversionDTO;
import com.mybluecard.code.challenge.codechallengemybluecard.repository.ConversionRepository;
import com.mybluecard.code.challenge.codechallengemybluecard.repository.CurrencyExchangeRepository;
import com.mybluecard.code.challenge.codechallengemybluecard.service.ConversionService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequiredArgsConstructor
@Slf4j
public class CurrencyExchangeController {
	
	@Autowired
	private CurrencyExchangeRepository exchangeRepository;
	
	@Autowired
	private ConversionRepository conversionRepository;
	
	@Autowired
	private ConversionService conversionService;
		
    @GetMapping({"/", "/index"})
    public String listConversions(Model model) {

        List<CurrencyExchange> list = new ArrayList<>(Arrays.asList(
                new CurrencyExchange(23432L, "USD", "BRL", BigDecimal.valueOf(100.00), BigDecimal.valueOf(500.00), LocalDateTime.now()),
                new CurrencyExchange(4235L, "EUR", "BRL", BigDecimal.valueOf(30.00), BigDecimal.valueOf(99.00), LocalDateTime.now()),
                new CurrencyExchange(487L, "BRL", "USD", BigDecimal.valueOf(1000.00), BigDecimal.valueOf(5000.00), LocalDateTime.now())));

                model.addAttribute("title", "Currency Exchange");
        model.addAttribute("conversions", list);
        return "index";
    }
    
	@GetMapping(path="/currencyConversion")
    public String addExchange(CurrencyExchange exchange, Model model) {
		model.addAttribute("exchange", new CurrencyExchange());
    	return "newCurrencyConversion";
    }
    
	@PostMapping(path="/currencyConversion")
    public String addExchange(@Valid CurrencyExchange exchange) throws JsonMappingException, JsonProcessingException, UnirestException {
		exchange.setConverterDate(LocalDateTime.now());
		CurrencyExchange savedExchange = exchangeRepository.save(exchange);
		ConversionDTO conversionDTO = new ConversionDTO();
		conversionDTO.buildFromCurrencyExchange(savedExchange);
		conversionService.persistConversionFromApiResponse(conversionDTO);
    	return "redirect:/currencyConversion";
    }
	
    @GetMapping({"/conversions"})
    public String listCreatedConversions(Model model) {

        List<Conversion> list = conversionRepository.findAll();
        model.addAttribute("title", "Made Conversions");
        model.addAttribute("addedConversions", list);
        model.addAttribute("addedConversion", conversionRepository.count());
        return "addedConversions";
    }
    
}
