package com.TF.Model.Dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.TF.Model.Dao.ProductoDao;
import com.TF.Model.DataBase.DataBaseMysql;
import com.TF.Model.Dto.Producto;
import com.TF.Model.Dto.Proveedor;



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
		try {
			cn = db.connectDb();
			PreparedStatement prepare = cn.prepareStatement("DELETE FROM productos WHERE id =?");
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
	public boolean Update(Producto obj) {
		try {
			cn = db.connectDb();
			PreparedStatement prepare = cn.prepareStatement("UPDATE productos SET nombre=? , precio=? , stock=?, unidad=? where id=?");
			prepare.setString(1, obj.getNombre());
			prepare.setDouble(2, obj.getPrecio());
			prepare.setInt(3, obj.getStock());
			prepare.setInt(4, obj.getUnidad());
			prepare.setInt(5, obj.getId());
			prepare.executeUpdate();
			return true;
		} catch (SQLException e) {
			return false;
		} finally {
			db.desconnectDb();
		}
	}

	@Override
	public List<Producto> getAll() {
		Producto producto = null;
		List<Producto> listado = new ArrayList<>();
		try {
			cn = db.connectDb();
			PreparedStatement prepare = cn.prepareStatement("SELECT p.id, p.nombre, p.precio, p.stock, p.unidad FROM productos p");
			ResultSet result = prepare.executeQuery();
			while(result.next()) {
				producto = new Producto();
				producto.setId(result.getInt("id"));
				producto.setNombre(result.getString("razon"));
				producto.setPrecio(result.getDouble(("rubro")));
				producto.setStock(result.getInt("ruc"));
				listado.add(producto);
			}
			return listado;
		} catch(SQLException e) {
			return null;
		} finally {
			db.desconnectDb();
		}
	}

	@Override
	public Producto FindBy(int id) {
		Producto producto = null;
		try {
			cn = db.connectDb();
			PreparedStatement prepare = cn.prepareStatement("SELECT p.id, p.nombre, p.precio, p.stock, p.unidad FROM productos p where p.id=?");
			prepare.setInt(1, id);
			ResultSet result = prepare.executeQuery();
			producto = new Producto();
			producto.setId(result.getInt("id"));
			producto.setNombre(result.getString("razon"));
			producto.setPrecio(result.getDouble(("rubro")));
			producto.setStock(result.getInt("ruc"));
			return producto;
		} catch(SQLException e) {
			return null;
		} finally {
			db.desconnectDb();
		}
	}

}
