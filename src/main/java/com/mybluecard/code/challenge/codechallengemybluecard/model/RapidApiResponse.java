package com.mybluecard.code.challenge.codechallengemybluecard.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RapidApiResponse {

	@JsonProperty("result")
	private String result;
	
	@JsonProperty("valid")
	private boolean valid;
	
	@JsonProperty("from-value")
	private String fromValue;
	
	@JsonProperty("to-type")
	private String toType;
	
	@JsonProperty("from-type")
	private String fromType;
	
	@JsonProperty("result-float")
	private float resultFloat;

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}

	public String getFromValue() {
		return fromValue;
	}

	public void setFromValue(String fromValue) {
		this.fromValue = fromValue;
	}

	public String getToType() {
		return toType;
	}

	public void setToType(String toType) {
		this.toType = toType;
	}

	public String getFromType() {
		return fromType;
	}

	public void setFromType(String fromType) {
		this.fromType = fromType;
	}

	public float getResultFloat() {
		return resultFloat;
	}

	public void setResultFloat(float resultFloat) {
		this.resultFloat = resultFloat;
	}
}
