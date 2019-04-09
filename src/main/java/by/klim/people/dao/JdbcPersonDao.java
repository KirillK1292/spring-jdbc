package by.klim.people.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

import by.klim.people.model.Person;

@Repository
public class JdbcPersonDao implements IPersonDao {
	private Connection connection;
	
	@Autowired
	public JdbcPersonDao(DriverManagerDataSource dataSource) {
		try {
			connection = dataSource.getConnection();
		} catch (SQLException e) {
			throw new IllegalStateException(e.getMessage());
		}
	}

	public void save(Person model) {
		try(PreparedStatement statement = connection.prepareStatement(SAVE_PERSON)) {
			statement.setString(1, model.getFirstName());
			statement.setString(2, model.getLastName());
			statement.setString(3, model.getSex());
			statement.setDate(4, model.getBirthdate());
			statement.setString(5, model.getPhone());
			statement.setString(6, model.getEmail());
			statement.execute();
		} catch (SQLException e) {
			throw new IllegalStateException(e.getMessage());
		}
	}

	public void update(Person model) {
		try(PreparedStatement statement = connection.prepareStatement(UPDATE_PERSON)) {
			statement.setString(1, model.getLastName());
			statement.setString(2, model.getPhone());
			statement.setString(3, model.getEmail());
			statement.setLong(4, model.getId());
			statement.execute();
		} catch (SQLException e) {
			throw new IllegalStateException(e.getMessage());
		}
	}

	public void delete(Long id) {
		try(Statement statement = connection.createStatement()) {
			statement.execute(DELETE_PERSON + id);
		} catch (SQLException e) {
			throw new IllegalStateException(e.getMessage());
		}
	}

	public Optional<Person> findById(Long id) {
		try(Statement statement = connection.createStatement()) {
			ResultSet rs = statement.executeQuery(FIND_PERSON_BY_ID + id);
			if(rs.next()) {
				String firstName = rs.getString("firstName");
				String lastName = rs.getString("lastName");
				String sex = rs.getString("sex");
				Date birthdate = rs.getDate("birthdate");
				String phone = rs.getString("phone");
				String email = rs.getString("email");
				return Optional.of(new Person(id, firstName, lastName, sex, birthdate, phone, email));
			}
			return Optional.empty();
		} catch (SQLException e) {
			throw new IllegalStateException(e.getMessage());
		}
	}

	public List<Person> findAll() {
		try(Statement statement = connection.createStatement()) {
			ResultSet rs = statement.executeQuery(FIND_ALL_PEOPLE);
			List<Person> people = new ArrayList<Person>();
			while(rs.next()) {
				Long id = rs.getLong("id");
				String firstName = rs.getString("firstName");
				String lastName = rs.getString("lastName");
				String sex = rs.getString("sex");
				Date birthdate = rs.getDate("birthdate");
				String phone = rs.getString("phone");
				String email = rs.getString("email");
				people.add(new Person(id, firstName, lastName, sex, birthdate, phone, email));
			}
			return people;
		} catch(SQLException e) {
			throw new IllegalStateException(e.getMessage());
		}
	}

	public List<Person> findByLastName(String lastName) {
		try(PreparedStatement statement = connection.prepareStatement(FIND_PERSON_BY_LASTNAME)) {
			statement.setString(1, lastName);
			ResultSet rs = statement.executeQuery();
			List<Person> people = new ArrayList<Person>();
			while(rs.next()) {
				Long id = rs.getLong("id");
				String firstName = rs.getString("firstName");
				String sex = rs.getString("sex");
				Date birthdate = rs.getDate("birthdate");
				String phone = rs.getString("phone");
				String email = rs.getString("email");
				people.add(new Person(id, firstName, lastName, sex, birthdate, phone, email));
			}
			return people;
		} catch (SQLException e) {
			throw new IllegalStateException(e.getMessage());
		}
	}

	public Optional<Person> findByPhone(String phone) {
		try(PreparedStatement statement = connection.prepareStatement(FIND_PERSON_BY_PHONE)) {
			statement.setString(1, phone);
			ResultSet rs = statement.executeQuery();
			if(rs.next()) {
				Long id = rs.getLong("id");
				String firstName = rs.getString("firstName");
				String lastName = rs.getString("lastName");
				String sex = rs.getString("sex");
				Date birthdate = rs.getDate("birthdate");
				String email = rs.getString("email");
				return Optional.of(new Person(id, firstName, lastName, sex, birthdate, phone, email));
			}
			return Optional.empty();
		} catch (SQLException e) {
			throw new IllegalStateException(e.getMessage());
		}
	}

	public Optional<Person> findByEmail(String email) {
		try(PreparedStatement statement = connection.prepareStatement(FIND_PERSON_BY_PHONE)) {
			statement.setString(1, email);
			ResultSet rs = statement.executeQuery();
			if(rs.next()) {
				Long id = rs.getLong("id");
				String firstName = rs.getString("firstName");
				String lastName = rs.getString("lastName");
				String sex = rs.getString("sex");
				Date birthdate = rs.getDate("birthdate");
				String phone = rs.getString("phone");
				return Optional.of(new Person(id, firstName, lastName, sex, birthdate, phone, email));
			}
			return Optional.empty();
		} catch (SQLException e) {
			throw new IllegalStateException(e.getMessage());
		}
	}
}
