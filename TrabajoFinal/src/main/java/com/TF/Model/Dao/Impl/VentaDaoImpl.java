package com.TF.Model.Dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.TF.Model.Dao.VentaDao;
import com.TF.Model.DataBase.DataBaseMysql;
import com.TF.Model.Dto.Venta;

public class VentaDaoImpl implements VentaDao{
	
	DataBaseMysql db = new DataBaseMysql();
	Connection cn = null;
	
	@Override
	public boolean Save(Venta obj) {
		try {
			cn = db.connectDb();
			PreparedStatement prepare = cn.prepareStatement("INSERT INTO ventas"
					+ "(comprobante, numComprobante, total) VALUES(?,?,?)");
			prepare.setString(1, obj.getComprobante());
			prepare.setInt(2, obj.getNumComprobante());
			prepare.setInt(3, obj.getTotal());
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
	public boolean Delete(Venta obj) {
		try {
			cn = db.connectDb();
			PreparedStatement prepare = cn.prepareStatement("DELETE FROM ventas WHERE id =?");
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
	public boolean Update(Venta obj) {
		try {
			cn = db.connectDb();
			PreparedStatement prepare = cn.prepareStatement("UPDATE ventas SET comprobante=? , numComprobante=? , total=? where id=?");
			prepare.setString(1, obj.getComprobante());
			prepare.setInt(2, obj.getNumComprobante());
			prepare.setInt(3, obj.getTotal());
			prepare.setInt(4, obj.getId());
			prepare.executeUpdate();
			return true;
		} catch (SQLException e) {
			return false;
		} finally {
			db.desconnectDb();
		}
	}

	@Override
	public List<Venta> getAll() {
		Venta venta = null;
		List<Venta> listado = new ArrayList<>();
		try {
			cn = db.connectDb();
			PreparedStatement prepare = cn.prepareStatement("SELECT v.id, v.comprobante, v.numComprobante, v.total FROM ventas v");
			ResultSet result = prepare.executeQuery();
			while(result.next()) {
				venta = new Venta();
				venta.setId(result.getInt("id"));
				venta.setComprobante(result.getString("comprobante"));
				venta.setNumComprobante(result.getInt("numComprobante"));
				venta.setTotal(result.getInt("total"));
				listado.add(venta);
			}
			return listado;
		} catch(SQLException e) {
			return null;
		} finally {
			db.desconnectDb();
		}
	}

	@Override
	public Venta FindBy(int id) {
		Venta venta = null;
		try {
			cn = db.connectDb();
			PreparedStatement prepare = cn.prepareStatement("SELECT v.id, v.comprobante, v.numComprobante, v.total FROM ventas v where v.id=?");
			prepare.setInt(1, id);
			ResultSet result = prepare.executeQuery();
			venta = new Venta();
			venta.setId(result.getInt("id"));
			venta.setComprobante(result.getString("comprobante"));
			venta.setNumComprobante(result.getInt("numComprobante"));
			venta.setTotal(result.getInt("total"));
			return venta;
		} catch(SQLException e) {
			return null;
		} finally {
			db.desconnectDb();
		}
	}

}
