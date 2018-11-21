package com.TF.Model.Dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.TF.Model.Dao.ProductoDao;
import com.TF.Model.DataBase.DataBaseMysql;
import com.TF.Model.Dto.Producto;



public class ProductoDaoImpl implements ProductoDao{
	
	DataBaseMysql db = new DataBaseMysql();
	Connection cn = null;
	
	@Override
	public boolean Save(Producto obj) {
		try {
			cn = db.connectDb();
			PreparedStatement prepare = cn.prepareStatement("INSERT INTO productos"
					+ "(nombre, precio, stock, unidad) VALUES(?,?,?,?)");
			prepare.setString(1, obj.getNombre());
			prepare.setDouble(2, obj.getPrecio());
			prepare.setInt(3, obj.getStock());
			prepare.setInt(4, obj.getStock());
			prepare.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO: handle exception
			return false;
		}finally
		{
			db.desconnectDb();
		}
	}

	@Override
	public boolean Delete(Producto obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean Update(Producto obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Producto> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Producto FindBy(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
