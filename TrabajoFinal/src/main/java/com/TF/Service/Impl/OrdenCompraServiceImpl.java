package com.TF.Service.Impl;

import java.util.List;

import com.TF.Model.Dao.OrdenCompraDao;
import com.TF.Model.Dto.OrdenCompra;
import com.TF.Model.Factory.Factory;
import com.TF.Service.OrdenCompraService;

public class OrdenCompraServiceImpl implements OrdenCompraService {

	private OrdenCompraDao Dao;
	
	public OrdenCompraServiceImpl() {
		Dao = Factory.getInstance().getOrden();
	}

	@Override
	public boolean Save(OrdenCompra obj) {
		return Dao.Save(obj);
	}

	@Override
	public boolean Delete(OrdenCompra obj) {
		return Dao.Delete(obj);
	}

	@Override
	public boolean Update(OrdenCompra obj) {
		return Dao.Update(obj);
	}

	@Override
	public List<OrdenCompra> getAll() {
		return Dao.getAll();
	}

	@Override
	public OrdenCompra FindBy(int id) {
		return Dao.FindBy(id);
	}

	@Override
	public boolean UpdateTotal(int id, double sum) {
		return Dao.UpdateTotal(id, sum);
	}
}
