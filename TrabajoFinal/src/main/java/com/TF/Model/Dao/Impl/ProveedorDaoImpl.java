package com.TF.Model.Dao.Impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.TF.Model.Dao.ProveedorDao;
import com.TF.Model.DataBase.DataBaseMysql;
import com.TF.Model.Dto.Proveedor;
import java.sql.Connection;

public class ProveedorDaoImpl implements ProveedorDao{

	DataBaseMysql db = new DataBaseMysql();
	Connection cn = null;
	
	@Override
	public boolean Save(Proveedor obj) {
		try {
			cn = db.connectDb();
			PreparedStatement prepare = cn.prepareStatement("INSERT INTO proveedores "
					+ "(razon, rubro, ruc, nombre, pais,"
					+ "ciudad, referencia, provincia, direccion, email,"
					+ "contacto, fax, telf1, telf2) "
					+ "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			prepare.setString(1, obj.getRazonSocial());
			prepare.setString(2, obj.getRubro());
			prepare.setDouble(3, obj.getRuc());
			prepare.setString(4, obj.getNombreComercial());
			prepare.setString(5, obj.getPais());
			prepare.setString(6, obj.getCiudad());
			prepare.setString(7, obj.getReferencia());
			prepare.setString(8, obj.getProvincia());
			prepare.setString(9, obj.getDireccion());
			prepare.setString(10, obj.getEmail());
			prepare.setString(11, obj.getContacto());
			prepare.setDouble(12, obj.getFax());
			prepare.setDouble(13, obj.getTelefono1());
			prepare.setDouble(14, obj.getTelefono2());
			prepare.executeUpdate();
			return true;
		} catch (SQLException e) {
			return false;
		} finally {
			db.desconnectDb();
		}
	}

	@Override
	public boolean Delete(Proveedor obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean Update(Proveedor obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Proveedor> getAll() {
		Proveedor proveedor = null;
		List<Proveedor> listado = new ArrayList<>();
		try {
			cn = db.connectDb();
			PreparedStatement prepare = cn.prepareStatement("SELECT p.id, p.razon, p.rubro, p.ruc, p.nombre,"
					+ "p.pais, p.ciudad, p.referencia, p.provincia,"
					+ "p.direccion, p.email, p.contacto, p.fax, p.telf1, p.telf2 FROM proveedores p");
			ResultSet result = prepare.executeQuery();
			while(result.next()) {
				proveedor = new Proveedor();
				proveedor.setId(result.getInt("id"));
				proveedor.setRazonSocial(result.getString("razon"));
				proveedor.setRubro(result.getString("rubro"));
				proveedor.setRuc(result.getDouble("ruc"));
				proveedor.setNombreComercial(result.getString("nombre"));
				proveedor.setPais(result.getString("pais"));
				proveedor.setCiudad(result.getString("ciudad"));
				proveedor.setReferencia(result.getString("referencia"));
				proveedor.setProvincia(result.getString("provincia"));
				proveedor.setDireccion(result.getString("direccion"));
				proveedor.setEmail(result.getString("email"));
				proveedor.setContacto(result.getString("contacto"));
				proveedor.setFax(result.getDouble("fax"));
				proveedor.setTelefono1(result.getDouble("telf1"));
				proveedor.setTelefono2(result.getDouble("telf2"));
				listado.add(proveedor);
			}
			return listado;
		} catch(SQLException e) {
			return null;
		} finally {
			db.desconnectDb();
		}
	}

	@Override
	public Proveedor FindBy(int id) {
		Proveedor proveedor = null;
		try {
			cn = db.connectDb();
			PreparedStatement prepare = cn.prepareStatement("SELECT p.id, p.razon, p.rubro, p.ruc, p.nombre,"
					+ "p.pais, p.ciudad, p.referencia, p.provincia,"
					+ "p.direccion, p.email, p.contacto, p.fax, p.telf1, p.telf2 FROM proveedores p where p.id =?");
			prepare.setInt(1, id);
			ResultSet result = prepare.executeQuery();
			if(result.next()) {
				proveedor = new Proveedor();
				proveedor.setId(result.getInt("id"));
				proveedor.setRazonSocial(result.getString("razon"));
				proveedor.setRubro(result.getString("rubro"));
				proveedor.setRuc(result.getDouble("ruc"));
				proveedor.setNombreComercial(result.getString("nombre"));
				proveedor.setPais(result.getString("pais"));
				proveedor.setCiudad(result.getString("ciudad"));
				proveedor.setReferencia(result.getString("referencia"));
				proveedor.setProvincia(result.getString("provincia"));
				proveedor.setDireccion(result.getString("direccion"));
				proveedor.setEmail(result.getString("email"));
				proveedor.setContacto(result.getString("contacto"));
				proveedor.setFax(result.getDouble("fax"));
				proveedor.setTelefono1(result.getDouble("telf1"));
				proveedor.setTelefono2(result.getDouble("telf2"));
			}
			return proveedor;
		} catch(SQLException e) {
			return null;
		} finally {
			db.desconnectDb();
		}
	}

}
