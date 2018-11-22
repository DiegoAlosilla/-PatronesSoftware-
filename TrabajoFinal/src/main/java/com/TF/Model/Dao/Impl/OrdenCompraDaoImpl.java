package com.TF.Model.Dao.Impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.TF.Model.Dao.OrdenCompraDao;
import com.TF.Model.DataBase.DataBaseMysql;
import com.TF.Model.Dto.OrdenCompra;

public class OrdenCompraDaoImpl implements OrdenCompraDao {

	DataBaseMysql db = new DataBaseMysql();
	Connection cn = null;
	
	@Override
	public boolean Save(OrdenCompra obj) {
		try {
			cn = db.connectDb();
			PreparedStatement prepare = cn.prepareStatement("INSERT INTO ordenescompra (total, fecha) VALUES(?,?)");
			prepare.setDouble(1, obj.getTotal());
			prepare.setDate(2, (Date)obj.getFecha());
			prepare.executeUpdate();
			return true;
		} catch (SQLException e) {
			return false;
		} finally {
			db.desconnectDb();
		}
	}

	@Override
	public boolean Delete(OrdenCompra obj) {
		try {
			cn = db.connectDb();
			PreparedStatement prepare = cn.prepareStatement("DELETE FROM ordenescompra WHERE id =?");
			prepare.setInt(1, obj.getId());
			prepare.executeUpdate();
			return true;
		} catch (SQLException e) {
			return false;
		} finally {
			db.desconnectDb();
		}
	}

	@Override
	public boolean Update(OrdenCompra obj) {
		try {
			cn = db.connectDb();
			PreparedStatement prepare = cn.prepareStatement("UPDATE ordenescompra SET total=?, fecha=? where id=?");
			prepare.setDouble(1, obj.getTotal());
			prepare.setDate(2, (Date)obj.getFecha());
			prepare.setInt(3, obj.getId());
			prepare.executeUpdate();
			return true;
		} catch (SQLException e) {
			return false;
		} finally {
			db.desconnectDb();
		}
	}

	@Override
	public List<OrdenCompra> getAll() {
		OrdenCompra orden = null;
		List<OrdenCompra> listado = new ArrayList<>();
		try {
			cn = db.connectDb();
			PreparedStatement prepare = cn.prepareStatement("SELECT o.id, o.total, o.fecha FROM ordenescompra o");
			ResultSet result = prepare.executeQuery();
			while(result.next()) {
				orden = new OrdenCompra();
				orden.setId(result.getInt("id"));
				orden.setTotal(result.getDouble("total"));
				orden.setFecha(result.getDate("fecha"));
				listado.add(orden);
			}
			return listado;
		} catch(SQLException e) {
			return null;
		} finally {
			db.desconnectDb();
		}
	}

	@Override
	public OrdenCompra FindBy(int id) {
		OrdenCompra orden = null;
		try {
			cn = db.connectDb();
			PreparedStatement prepare = cn.prepareStatement("SELECT o.id, o.total, o.fecha FROM ordenescompra o where o.id=?");
			prepare.setInt(1, id);
			ResultSet result = prepare.executeQuery();
			if(result.next()){
				orden = new OrdenCompra();
				orden.setId(result.getInt("id"));
				orden.setTotal(result.getDouble("total"));
				orden.setFecha(result.getDate("fecha"));
			}
			return orden;
		} catch(SQLException e) {
			return null;
		} finally {
			db.desconnectDb();
		}
	}
}