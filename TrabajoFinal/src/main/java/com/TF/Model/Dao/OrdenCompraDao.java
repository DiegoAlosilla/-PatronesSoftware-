package com.TF.Model.Dao;

import com.TF.Model.Dto.OrdenCompra;

public interface OrdenCompraDao extends CRUDdao<OrdenCompra> {
	boolean UpdateTotal(int id, double sum);
}
