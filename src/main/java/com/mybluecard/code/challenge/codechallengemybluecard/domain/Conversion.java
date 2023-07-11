package com.mybluecard.code.challenge.codechallengemybluecard.domain;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.mybluecard.code.challenge.codechallengemybluecard.model.RapidApiResponse;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Table
@Entity
public class Conversion {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
	
	public String fromValue;
	
	public String fromType;
	
	public String toType;
	
	public LocalDateTime conversionDate;
	
	public Conversion buildFromApiResponse(RapidApiResponse apiResponse) {
		this.fromValue = apiResponse.getFromValue();
		this.fromType = apiResponse.getFromType();
		this.toType =apiResponse.getToType();
		this.conversionDate = LocalDateTime.now();
		return this;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFromValue() {
		return fromValue;
	}

	public void setFromValue(String fromValue) {
		this.fromValue = fromValue;
	}

	public String getFromType() {
		return fromType;
	}

	public void setFromType(String fromType) {
		this.fromType = fromType;
	}

	public String getToType() {
		return toType;
	}

	public void setToType(String toType) {
		this.toType = toType;
	}

	public LocalDateTime getConversionDate() {
		return conversionDate;
	}

	public void setConversionDate(LocalDateTime conversionDate) {
		this.conversionDate = conversionDate;
	}
}
