package com.TF.Service.Impl;

import java.util.List;
import com.TF.Model.Dao.VentaDao;
import com.TF.Model.Dto.Venta;
import com.TF.Service.VentaService;

public class VentaServiceImpl implements VentaService{

	private VentaDao Dao;
	
	@Override
	public boolean Save(Venta obj) {
		return Dao.Save(obj);
	}

	@Override
	public boolean Delete(Venta obj) {
		return Dao.Delete(obj);
	}

	@Override
	public boolean Update(Venta obj) {
		return Dao.Update(obj);
	}

	@Override
	public List<Venta> getAll() {
		return Dao.getAll();
	}

	@Override
	public Venta FindBy(int id) {
		return Dao.FindBy(id);
	}


}
