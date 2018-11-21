package com.TF.Service;

import java.util.List;

public interface CRUDservice<T> {
	boolean Save(T obj);
	boolean Delete(T obj);
	boolean Update(T obj);
	List<T> getAll();
	T FindBy(int id);	
}
