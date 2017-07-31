package com.gongjian.batch;

import org.springframework.batch.item.validator.ValidatingItemProcessor;
import org.springframework.batch.item.validator.ValidationException;

import com.gongjian.domain.Person;

public class CsvItemProcessor extends ValidatingItemProcessor<Person> {

	@Override
	public Person process(Person item) throws ValidationException {
		super.process(item);

		if ("汉族".equals(item.getName())) {
			item.setNation("01");
		} else {
			item.setNation("02");
		}

		return item;
	}

}
