package com.TF.Model.Factory;

import com.TF.Model.Dao.ProveedorDao;
import com.TF.Model.Dao.Impl.ProveedorDaoImpl;

public class Factory {

	private static Factory Instance = null;
	
	private Factory() {
	}
	
	public static Factory getInstance() {
		if(Instance == null)
			Instance = new Factory();
		return Instance;
	}
	
	public ProveedorDao getProveedor() {
		return new ProveedorDaoImpl();
	}
}
