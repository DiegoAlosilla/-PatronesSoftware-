package model.dao;

import java.util.List;

public interface Dao<T> {
	T find(int id);

	boolean create(T obj);

	boolean update(T obj);

	boolean delete(List<Integer> ids);

	List<T> getAll();
}
