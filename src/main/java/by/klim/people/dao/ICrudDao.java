package by.klim.people.dao;

import java.util.List;
import java.util.Optional;

interface ICrudDao<T> {
	void save(T model);
	void update(T model);
	void delete(Long id);
	Optional<T> findById(Long id);
	List<T> findAll();
}
