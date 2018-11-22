package com.TF.Service;

import com.TF.Model.Dto.OrdenCompra;

public interface OrdenCompraService extends CRUDservice<OrdenCompra> {
	boolean UpdateTotal(int id, double sum);
}
