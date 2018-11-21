package com.TF.Controller;

import java.util.List;
import com.TF.Model.Dto.Proveedor;
import com.TF.Service.ProveedorService;

public class ProveedorController {
	
	private ProveedorService proveedorServ;
	
	public ProveedorController(ProveedorService proveedorServ) {
		this.proveedorServ = proveedorServ;
	}
	
	public boolean SaveProveedor(Proveedor obj) {
		if(proveedorServ.Save(obj))
			return true;
		else
			return false;
	}
	
	public List<Proveedor> GetAll(){
		return proveedorServ.getAll();
	}
	
	public Proveedor FindById(int id) {
		return proveedorServ.FindBy(id);
	}
}
