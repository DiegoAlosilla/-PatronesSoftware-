package com.TF.Model.Dao;

import java.util.List;

public interface CRUDdao<T> {
	boolean Save(T obj);
	boolean Delete(T obj);
	boolean Update(T obj);
	List<T> getAll();
	T FindBy(int id);	
}
