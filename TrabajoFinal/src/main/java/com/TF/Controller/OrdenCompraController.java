package com.TF.Controller;

import java.util.List;

import com.TF.Model.Dto.LineaOrdenCompra;
import com.TF.Model.Dto.OrdenCompra;
import com.TF.Service.LineaOrdenCompraService;
import com.TF.Service.OrdenCompraService;
import com.TF.Service.ProductoService;

public class OrdenCompraController {
	
	private OrdenCompraService ordencompraService;
	private LineaOrdenCompraService lineaordenService;
	private ProductoService productoService;
	
	public OrdenCompraController(OrdenCompraService ordencompraService, LineaOrdenCompraService lineaordenService, ProductoService productoService) {
		this.ordencompraService = ordencompraService;
		this.lineaordenService = lineaordenService;
		this.productoService = productoService;
	}
	
	public boolean SaveOrden(OrdenCompra obj, List<LineaOrdenCompra> listado) {
		double total = obj.getTotal();
		if(listado == null)
			return false;
		else {
			if(ordencompraService.Save(obj)) {
				for (int i = 0; i < listado.size(); i++) {
					lineaordenService.Save(listado.get(i));
					total += productoService.FindBy(listado.get(i).getProducto().getId()).getPrecio();
				}
				ordencompraService.UpdateTotal(obj.getId(), total);
			}
			return true;
		}
	}
	
	public boolean UpdateLineaOrden(LineaOrdenCompra linea) {
		if(lineaordenService.Update(linea))
			return true;
		else
			return false;
	}
	
	public OrdenCompra FindById(int id) {
		return ordencompraService.FindBy(id);
	}
	
	public List<LineaOrdenCompra> FindByOrden(int id){
		return lineaordenService.FindByOrden(id);
	}
	
	public boolean Delete(OrdenCompra obj) {
		List<LineaOrdenCompra> linea;
		linea = lineaordenService.FindByOrden(obj.getId());
		for(int i = 0; i < linea.size(); i++) {
			//Grabando linea en base de datos postgre
			lineaordenService.Delete(linea.get(i));
		}
		//Guardar orden en base de datos postgre
		if(ordencompraService.Delete(obj)) {
			return true;
		}else {
			return false;
		}
	}
}
