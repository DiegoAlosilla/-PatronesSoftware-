package com.TF.Controller;

import java.util.List;

import com.TF.Model.Dto.Venta;
import com.TF.Service.VentaService;

public class VentaController {

	private VentaService ventaService;
	
	public VentaController(VentaService ventaService) {
		this.ventaService = ventaService;
	}
	
	public boolean SaveProducto(Venta obj) {
		if(ventaService.Save(obj))
			return true;
		else
			return false;
	}
	
	public List<Venta> GetAll(){
		return ventaService.getAll();
	}
	
	public Venta FindById(int id) {
		return ventaService.FindBy(id);
	}
}
