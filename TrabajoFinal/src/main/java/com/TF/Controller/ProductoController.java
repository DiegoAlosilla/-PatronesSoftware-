package com.TF.Controller;

import java.util.List;

import com.TF.Model.Dto.Producto;
import com.TF.Service.CategoriaService;
import com.TF.Service.ProductoService;
import com.TF.Service.ProveedorService;


public class ProductoController {
	
	private ProductoService productoService;
	private CategoriaService categoriaService;
	private ProveedorService proveedorService;
	
	public ProductoController(ProductoService productoService, CategoriaService categoriaService, ProveedorService proveedorService) {
		this.productoService = productoService;
		this.categoriaService = categoriaService;
		this.proveedorService = proveedorService;
	}
	
	public boolean SaveProducto(Producto obj) {
		obj.setCategoria(categoriaService.FindBy(obj.getCategoria().getId()));
		obj.setProveedor(proveedorService.FindBy(obj.getProveedor().getId()));
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
