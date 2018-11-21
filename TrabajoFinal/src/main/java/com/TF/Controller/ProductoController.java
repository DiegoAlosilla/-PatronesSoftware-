package com.TF.Controller;

import java.util.List;

import com.TF.Model.Dto.Producto;
import com.TF.Service.ProductoService;


public class ProductoController {
	
	private ProductoService productoService;
	
	public ProductoController(ProductoService productoService) {
		this.productoService = productoService;
	}
	
	public boolean SaveProducto(Producto obj) {
		if(productoService.Save(obj))
			return true;
		else
			return false;
	}
	
	public List<Producto> GetAll(){
		return productoService.getAll();
	}
	
	public Producto FindById(int id) {
		return productoService.FindBy(id);
	}
}
