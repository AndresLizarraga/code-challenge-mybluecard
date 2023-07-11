package com.mybluecard.code.challenge.codechallengemybluecard.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Table
@Entity
public class CurrencyExchange implements Serializable {

	private static final long serialVersionUID = 1815744647700361038L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    
    @Size(min=3, max=3, message = "Origin Currency should have strict 3 characters")
    @Pattern(regexp="^[A-Za-z]*$",message = "Invalid Input, just string characters are permitted")
    private String originCurrency;

    @Size(min=3, max=3, message = "Origin Currency should have strict 3 characters")
    @Pattern(regexp="^[A-Za-z]*$",message = "Invalid Input, just string characters are permitted")
    private String targetCurrency;

    private BigDecimal originValue;

    private BigDecimal targetValue;

    private LocalDateTime converterDate;

	public CurrencyExchange(Long id, String originCurrency, String targetCurrency, BigDecimal originValue,
			BigDecimal targetValue, LocalDateTime converterDate) {
		super();
		this.id = id;
		this.originCurrency = originCurrency;
		this.targetCurrency = targetCurrency;
		this.originValue = originValue;
		this.targetValue = targetValue;
		this.converterDate =  converterDate;
	}

	public CurrencyExchange() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOriginCurrency() {
		return originCurrency;
	}

	public void setOriginCurrency(String originCurrency) {
		this.originCurrency = originCurrency;
	}

	public String getTargetCurrency() {
		return targetCurrency;
	}

	public void setTargetCurrency(String targetCurrency) {
		this.targetCurrency = targetCurrency;
	}

	public BigDecimal getOriginValue() {
		return originValue;
	}

	public void setOriginValue(BigDecimal originValue) {
		this.originValue = originValue;
	}

	public BigDecimal getTargetValue() {
		return targetValue;
	}

	public void setTargetValue(BigDecimal targetValue) {
		this.targetValue = targetValue;
	}

	public LocalDateTime getConverterDate() {
		return converterDate;
	}

	public void setConverterDate(LocalDateTime converterDate) {
		this.converterDate = converterDate;
	}
	
}
