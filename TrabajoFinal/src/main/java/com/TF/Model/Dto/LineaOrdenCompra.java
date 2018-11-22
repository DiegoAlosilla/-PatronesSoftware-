package com.TF.Model.Dto;

public class LineaOrdenCompra {

	private int cantidad;
	private OrdenCompra orden;
	private Producto producto;

	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public OrdenCompra getOrden() {
		return orden;
	}
	public void setOrden(OrdenCompra orden) {
		this.orden = orden;
	}
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	
}
