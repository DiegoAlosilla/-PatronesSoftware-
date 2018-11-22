package com.TF.Model.Dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.TF.Model.Dao.ClienteDao;
import com.TF.Model.DataBase.DataBaseMysql;
import com.TF.Model.Dto.Cliente;

public class ClienteDaoImpl  implements ClienteDao{

	DataBaseMysql db = new DataBaseMysql();
	Connection cn = null;
	
	@Override
	public boolean Save(Cliente obj) {
		try {
			cn = db.connectDb();
			PreparedStatement prepare = cn.prepareStatement("INSERT INTO productos"
					+ "(ruc, razonSocial, direccion, tipo) VALUES(?,?,?,?)");
			prepare.setString(1, obj.getRuc());
			prepare.setString(2, obj.getRazonSocial());
			prepare.setString(3, obj.getDireccion());
			prepare.setString(4, obj.getTipo());
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
	public boolean Delete(Cliente obj) {
		try {
			cn = db.connectDb();
			PreparedStatement prepare = cn.prepareStatement("DELETE FROM clientes WHERE ruc =?");
			prepare.setString(1, obj.getRuc());
			prepare.executeUpdate();
			return true;
		} catch (SQLException e) {
			return false;
		} finally {
			db.desconnectDb();
		}
	}

	@Override
	public boolean Update(Cliente obj) {
		try {
			cn = db.connectDb();
			PreparedStatement prepare = cn.prepareStatement("UPDATE clientes SET razonSocial=? , direccion=?, tipo = ? where ruc=?");
			prepare.setString(1, obj.getRazonSocial());
			prepare.setString(2, obj.getDireccion());
			prepare.setString(3, obj.getTipo());
			prepare.setString(3, obj.getRuc());
			prepare.executeUpdate();
			return true;
		} catch (SQLException e) {
			return false;
		} finally {
			db.desconnectDb();
		}
	}

	@Override
	public List<Cliente> getAll() {
		Cliente cliente = null;
		List<Cliente> listado = new ArrayList<>();
		try {
			cn = db.connectDb();
			PreparedStatement prepare = cn.prepareStatement("SELECT p.ruc, p.razonSocial, p.direccion, p.tipo FROM productos p");
			ResultSet result = prepare.executeQuery();
			while(result.next()) {
				cliente = new Cliente();
				cliente.setRuc(result.getString("ruc"));
				cliente.setRazonSocial(result.getString("razonSocial"));
				cliente.setDireccion(result.getString(("direccion")));
				cliente.setTipo(result.getString("tipo"));
				listado.add(cliente);
			}
			return listado;
		} catch(SQLException e) {
			return null;
		} finally {
			db.desconnectDb();
		}
	}

	@Override
	public Cliente FindBy(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
