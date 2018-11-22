package com.TF.Model.Dao;

import java.util.List;

import com.TF.Model.Dto.LineaOrdenCompra;

public interface LineaOrdenCompraDao extends CRUDdao<LineaOrdenCompra>{

	List<LineaOrdenCompra> FindByOrden(int id);
}
