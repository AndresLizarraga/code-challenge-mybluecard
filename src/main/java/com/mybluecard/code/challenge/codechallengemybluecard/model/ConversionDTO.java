package com.mybluecard.code.challenge.codechallengemybluecard.model;

import com.mybluecard.code.challenge.codechallengemybluecard.domain.CurrencyExchange;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ConversionDTO {
	
	public String fromValue;
	
	public String fromType;
	
	public String toType;
	
	public ConversionDTO buildFromCurrencyExchange(CurrencyExchange exchange) {
		this.fromType = exchange.getOriginCurrency();
		this.toType = exchange.getTargetCurrency();
		this.fromValue = String.valueOf(exchange.getOriginValue());
		return this;
	}
	
}
