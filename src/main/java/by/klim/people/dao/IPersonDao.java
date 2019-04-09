package by.klim.people.dao;

import java.util.List;
import java.util.Optional;

import by.klim.people.model.Person;

public interface IPersonDao extends ICrudDao<Person> {
	String SAVE_PERSON = "insert into person(firstName, lastName, sex, birthdate, phone, email) values(?, ?, ?, ?, ?, ?)";
	String UPDATE_PERSON = "update person set lastName=?, phone=?, email=? where id=?";
	String DELETE_PERSON = "delete from person where id=";
	String FIND_PERSON_BY_ID = "select * from person where id=";
	String FIND_ALL_PEOPLE = "select * from person";
	String FIND_PERSON_BY_LASTNAME = "select * from person where lastName=?";
	String FIND_PERSON_BY_PHONE = "select * from person where phone=?";
	String FIND_PERSON_BY_EMAIL = "select * from person where email=?";
	List<Person> findByLastName(String lastName);
	Optional<Person> findByPhone(String phone);
	Optional<Person> findByEmail(String email);
}
