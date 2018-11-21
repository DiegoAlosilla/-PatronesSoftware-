package com.TF.Service.Impl;

import java.util.List;

import com.TF.Model.Dao.ProductoDao;
import com.TF.Model.Dto.Producto;
import com.TF.Model.Factory.Factory;
import com.TF.Service.ProductoService;

public class ProductoServiceImpl implements ProductoService{

	private ProductoDao Dao;
	
	public ProductoServiceImpl() 
	{
		Dao = Factory.getInstance().getProducto();
	}
	@Override
	public boolean Save(Producto obj) {
		return Dao.Save(obj);
	}

	@Override
	public boolean Delete(Producto obj) {
		return Dao.Delete(obj);
	}

	@Override
	public boolean Update(Producto obj) {
		return Dao.Update(obj);
	}

	@Override
	public List<Producto> getAll() {
		return Dao.getAll();
	}

	@Override
	public Producto FindBy(int id) {
		return Dao.FindBy(id);
	}

}
