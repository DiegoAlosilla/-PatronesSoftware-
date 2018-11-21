package com.TF.Service.Impl;

import java.util.List;

import com.TF.Model.Dao.ProveedorDao;
import com.TF.Model.Dto.Proveedor;
import com.TF.Model.Factory.Factory;
import com.TF.Service.ProveedorService;

public class ProveedorServiceImpl implements ProveedorService{

	private ProveedorDao Dao;
	
	public ProveedorServiceImpl() {
		Dao = Factory.getInstance().getProveedor();
	}
	
	@Override
	public boolean Save(Proveedor obj) {
		return Dao.Save(obj);
	}

	@Override
	public boolean Delete(Proveedor obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean Update(Proveedor obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Proveedor> getAll() {
		return Dao.getAll();
	}

	@Override
	public Proveedor FindBy(int id) {
		return Dao.FindBy(id);
	}

}
