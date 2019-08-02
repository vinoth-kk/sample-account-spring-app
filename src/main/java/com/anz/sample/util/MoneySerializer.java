package com.anz.sample.util;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class MoneySerializer extends JsonSerializer<BigDecimal> {
	@Override
	public void serialize(BigDecimal value, JsonGenerator jgen, SerializerProvider provider)
			throws IOException, JsonProcessingException {
		String currency = "";
		if (value != null) {
			currency = String.format("%,.2f", value.setScale(2, RoundingMode.DOWN));
		}
		jgen.writeString(currency);
	}
}