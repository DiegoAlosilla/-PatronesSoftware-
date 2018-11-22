package com.TF.Model.Dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.TF.Model.Dao.LineaOrdenCompraDao;
import com.TF.Model.DataBase.DataBasePostgre;
import com.TF.Model.Dto.LineaOrdenCompra;

public class LineaOrdenCompraDaoImplPostgre implements LineaOrdenCompraDao {

	DataBasePostgre db = new DataBasePostgre();
	Connection cn = null;
	
	@Override
	public boolean Save(LineaOrdenCompra obj) {
		try {
			cn = db.connectDb();
			PreparedStatement prepare = cn.prepareStatement("INSERT INTO lineaordencompras (cantidad, ordencompras_id, productos_id) VALUES(?,?,?)");
			prepare.setInt(1, obj.getCantidad());
			prepare.setInt(2, obj.getOrden().getId());
			prepare.setInt(3, obj.getProducto().getId());
			prepare.executeUpdate();
			return true;
		} catch (SQLException e) {
			return false;
		} finally {
			db.desconnectDb();
		}
	}

	@Override
	public boolean Delete(LineaOrdenCompra obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean Update(LineaOrdenCompra obj) {
		try {
			cn = db.connectDb();
			PreparedStatement prepare = cn.prepareStatement("UPDATE lineaordencompras SET cantidad=? WHERE ordencompras_id=? and productos_id=?");
			prepare.setInt(1, obj.getCantidad());
			prepare.setInt(2, obj.getOrden().getId());
			prepare.setInt(3, obj.getProducto().getId());
			prepare.executeUpdate();
			return true;
		} catch (SQLException e) {
			return false;
		} finally {
			db.desconnectDb();
		}
	}

	@Override
	public List<LineaOrdenCompra> getAll() {
		LineaOrdenCompra linea = null;
		List<LineaOrdenCompra> listado = new ArrayList<>();
		try {
			cn = db.connectDb();
			PreparedStatement prepare = cn.prepareStatement("SELECT l.ordencompras_id, l.productos_id, l.cantidad FROM lineaordencompras l");
			ResultSet result = prepare.executeQuery();
			while(result.next()) {
				linea = new LineaOrdenCompra();
				linea.setOrden(new OrdenCompraDaoImpl().FindBy(result.getInt("ordencompras_id")));
				linea.setProducto(new ProductoDaoImpl().FindBy(result.getInt("productos_id")));
				linea.setCantidad(result.getInt("cantidad"));
				listado.add(linea);
			}
			return listado;
		} catch(SQLException e) {
			return null;
		} finally {
			db.desconnectDb();
		}
	}

	@Override
	public LineaOrdenCompra FindBy(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LineaOrdenCompra> FindByOrden(int id) {
		LineaOrdenCompra linea = null;
		List<LineaOrdenCompra> listado = new ArrayList<>();
		try {
			cn = db.connectDb();
			PreparedStatement prepare = cn.prepareStatement("SELECT l.ordencompras_id, l.productos_id, l.cantidad FROM lineaordencompras l WHERE l.ordencompras_id=?");			
			prepare.setInt(1, id);
			ResultSet result = prepare.executeQuery();
			while(result.next()) {
				linea = new LineaOrdenCompra();
				linea.setOrden(new OrdenCompraDaoImpl().FindBy(result.getInt("ordencompras_id")));
				linea.setProducto(new ProductoDaoImpl().FindBy(result.getInt("productos_id")));
				linea.setCantidad(result.getInt("cantidad"));
				listado.add(linea);
			}
			return listado;
		} catch(SQLException e) {
			return null;
		} finally {
			db.desconnectDb();
		}
	}
}
