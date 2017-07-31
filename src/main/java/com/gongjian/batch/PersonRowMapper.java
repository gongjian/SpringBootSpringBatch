package com.gongjian.batch;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.gongjian.domain.Person;

public class PersonRowMapper implements RowMapper<Person> {

	@Override
	public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
		Person person = new Person();

		person.setName(rs.getString("name"));
		person.setAge(rs.getInt("age"));
		person.setNation(rs.getString("nation"));
		person.setAddress(rs.getString("address"));

		return person;
	}

}
