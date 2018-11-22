package com.TF.Service.Impl;

import java.util.List;

import com.TF.Model.Dao.CategoriaDao;
import com.TF.Model.Dto.Categoria;
import com.TF.Model.Factory.Factory;
import com.TF.Service.CategoriaService;

public class CategoriaServiceImpl implements CategoriaService {

	CategoriaDao Dao;
	
	public CategoriaServiceImpl() {
		Dao = Factory.getInstance().getCategoria();
	}
	
	@Override
	public boolean Save(Categoria obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean Delete(Categoria obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean Update(Categoria obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Categoria> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Categoria FindBy(int id) {
		return Dao.FindBy(id);
	}

}
