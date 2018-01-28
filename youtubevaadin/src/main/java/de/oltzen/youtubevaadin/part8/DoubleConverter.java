package de.oltzen.youtubevaadin.part8;

import com.vaadin.data.Converter;
import com.vaadin.data.Result;
import com.vaadin.data.ValueContext;

public class DoubleConverter implements Converter<String, Double> {

	@Override
	public Result<Double> convertToModel(String value, ValueContext context) {
		try {
			return Result.ok(Double.valueOf(value));
		} catch (Exception exc) {
			exc.printStackTrace();
			return Result.error("Input is not a number!");
		}
	}

	@Override
	public String convertToPresentation(Double value, ValueContext context) {
		return value.toString();
	}

}
