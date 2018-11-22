package com.TF.Service.Impl;

import java.util.List;

import com.TF.Model.Dao.LineaOrdenCompraDao;
import com.TF.Model.Dto.LineaOrdenCompra;
import com.TF.Model.Factory.Factory;
import com.TF.Service.LineaOrdenCompraService;

public class LineaOrdenCompraServiceImpl implements LineaOrdenCompraService {

	private LineaOrdenCompraDao Dao;
	
	public LineaOrdenCompraServiceImpl() {
		Dao = Factory.getInstance().getLineaOrden();
	}

	@Override
	public boolean Save(LineaOrdenCompra obj) {
		return Dao.Save(obj);
	}

	@Override
	public boolean Delete(LineaOrdenCompra obj) {
		return Dao.Delete(obj);
	}

	@Override
	public boolean Update(LineaOrdenCompra obj) {
		return Dao.Update(obj);
	}

	@Override
	public List<LineaOrdenCompra> getAll() {
		return Dao.getAll();
	}

	@Override
	public LineaOrdenCompra FindBy(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LineaOrdenCompra> FindByOrden(int id) {
		return Dao.FindByOrden(id);
	}
}
