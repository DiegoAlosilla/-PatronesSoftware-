package com.TF.Model.Dto;

public class Venta {
	private int id;
	private String comprobante;
	private int numComprobante;
	private int total;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getComprobante() {
		return comprobante;
	}
	public void setComprobante(String comprobante) {
		this.comprobante = comprobante;
	}
	public int getNumComprobante() {
		return numComprobante;
	}
	public void setNumComprobante(int numComprobante) {
		this.numComprobante = numComprobante;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	
}
