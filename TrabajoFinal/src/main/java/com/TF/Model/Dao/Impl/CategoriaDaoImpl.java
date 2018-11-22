package com.TF.Model.Dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.TF.Model.Dao.CategoriaDao;
import com.TF.Model.DataBase.DataBaseMysql;
import com.TF.Model.Dto.Categoria;

public class CategoriaDaoImpl implements CategoriaDao {

	DataBaseMysql db = new DataBaseMysql();
	Connection cn = null;
	
	@Override
	public boolean Save(Categoria obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean Delete(Categoria obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean Update(Categoria obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Categoria> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Categoria FindBy(int id) {
		Categoria categoria = null;
		try {
			cn = db.connectDb();
			PreparedStatement prepare = cn.prepareStatement("SELECT c.id, c.nombre FROM categorias c WHERE c.id=?");
			prepare.setInt(1, id);
			ResultSet result = prepare.executeQuery();
			if(result.next()) {
				categoria = new Categoria();
				categoria.setId(result.getInt("id"));
				categoria.setNombre(result.getString("nombre"));
			}
			return categoria;
		} catch(SQLException e) {
			return null;
		} finally {
			db.desconnectDb();
		}
	}
}
