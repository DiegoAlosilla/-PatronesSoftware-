package com.TF.Model.Factory;

import com.TF.Model.Dao.LineaOrdenCompraDao;
import com.TF.Model.Dao.OrdenCompraDao;
import com.TF.Model.Dao.ProductoDao;
import com.TF.Model.Dao.ProveedorDao;
import com.TF.Model.Dao.Impl.LineaOrdenCompraDaoImpl;
import com.TF.Model.Dao.Impl.OrdenCompraDaoImpl;
import com.TF.Model.Dao.Impl.ProductoDaoImpl;
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
	
	public ProductoDao getProducto() {
		return new ProductoDaoImpl();
	}
	
	public OrdenCompraDao getOrden() {
		return new OrdenCompraDaoImpl();
	}
	
	public LineaOrdenCompraDao getLineaOrden() {
		return new LineaOrdenCompraDaoImpl();
	}
}
