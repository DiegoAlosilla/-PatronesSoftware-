package com.TF.Model.Dao.Impl;

import java.sql.Connection;
import java.util.List;

import com.TF.Model.Dao.LineaOrdenCompraDao;
import com.TF.Model.DataBase.DataBaseMysql;
import com.TF.Model.Dto.LineaOrdenCompra;

public class LineaOrdenCompraDaoImpl implements LineaOrdenCompraDao {

	DataBaseMysql db = new DataBaseMysql();
	Connection cn = null;
	
	@Override
	public boolean Save(LineaOrdenCompra obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean Delete(LineaOrdenCompra obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean Update(LineaOrdenCompra obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<LineaOrdenCompra> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LineaOrdenCompra FindBy(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
