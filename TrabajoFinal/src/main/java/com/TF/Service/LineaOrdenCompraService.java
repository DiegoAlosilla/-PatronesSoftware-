package com.TF.Service;

import java.util.List;

import com.TF.Model.Dto.LineaOrdenCompra;

public interface LineaOrdenCompraService extends CRUDservice<LineaOrdenCompra>{

	List<LineaOrdenCompra> FindByOrden(int id);
}
