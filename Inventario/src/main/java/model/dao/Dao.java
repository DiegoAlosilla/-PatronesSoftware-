package model.dao;

import java.util.List;

public interface Dao<T> {
	T findBy(int id);

	boolean create(T obj);

	boolean update(T obj);

	boolean delete(int id);

	List<T> getAll();
}
