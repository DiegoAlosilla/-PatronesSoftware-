package com.TF.View;

import java.util.List;
import java.util.Scanner;

import com.TF.Controller.ProveedorController;
import com.TF.Model.Dto.Proveedor;
import com.TF.Service.ProveedorService;
import com.TF.Service.Impl.ProveedorServiceImpl;

public class AppMain {

	public static void main(String[] args) {
		Proveedor obj;
		List<Proveedor> listadoP;
		ProveedorService proServ = new ProveedorServiceImpl();
		ProveedorController pController = new ProveedorController(proServ);
		Scanner s = new Scanner(System.in);
		System.out.println("Seleccione la Opcion: ");
		System.out.println("[1] Registrar");
		System.out.println("[2] Listar Todo");
		System.out.println("[3] Encontrar por id");
		System.out.println("[4] Salir");
		int temp = Integer.parseInt(s.nextLine());
		while(temp != 4) {
			switch(temp) {
			case 1:
				obj = new Proveedor();
				System.out.println("Ingresar razon: ");
				obj.setRazonSocial(s.nextLine());
				System.out.println("Ingresar rubro: ");
				obj.setRubro(s.nextLine());
				System.out.println("Ingresar ruc: ");
				obj.setRuc(Double.parseDouble(s.nextLine()));
				System.out.println("Ingresar nombre: ");
				obj.setNombreComercial(s.nextLine());
				System.out.println("Ingresar pais: ");
				obj.setPais(s.nextLine());
				System.out.println("Ingresar ciudad: ");
				obj.setCiudad(s.nextLine());
				System.out.println("Ingresar referencia: ");
				obj.setReferencia(s.nextLine());
				System.out.println("Ingresar provincia: ");
				obj.setProvincia(s.nextLine());
				System.out.println("Ingresar direccion: ");
				obj.setDireccion(s.nextLine());
				System.out.println("Ingresar email: ");
				obj.setEmail(s.nextLine());
				System.out.println("Ingresar contacto: ");
				obj.setContacto(s.nextLine());
				System.out.println("Ingresar fax: ");
				obj.setFax(Double.parseDouble(s.nextLine()));
				System.out.println("Ingresar telf1: ");
				obj.setTelefono1(Double.parseDouble(s.nextLine()));
				System.out.println("Ingresar telf2: ");
				obj.setTelefono2(Double.parseDouble(s.nextLine()));
				if(pController.SaveProveedor(obj))
					System.out.println("Registro Okey");
				else
					System.out.println("Ocurrio un error");
				break;
			case 2:
				listadoP = pController.GetAll();
				for(int i = 0; i < listadoP.size(); i++) {
					System.out.println("id: " + listadoP.get(i).getId());
					System.out.println("razon: " + listadoP.get(i).getRazonSocial());
					System.out.println("rubro: " + listadoP.get(i).getRubro());
					System.out.println("ruc: " + listadoP.get(i).getRuc());
					System.out.println("nombre: " + listadoP.get(i).getNombreComercial());
					System.out.println("pais: " + listadoP.get(i).getPais());
					System.out.println("provincia: " + listadoP.get(i).getProvincia());
					System.out.println("ciudad: " + listadoP.get(i).getCiudad());
					System.out.println("direccion: " + listadoP.get(i).getDireccion());
					System.out.println("referencia: " + listadoP.get(i).getReferencia());
					System.out.println("email: " + listadoP.get(i).getEmail());
					System.out.println("contacto: " + listadoP.get(i).getContacto());
					System.out.println("fax: " + listadoP.get(i).getFax());
					System.out.println("telefono 1: " + listadoP.get(i).getTelefono1());
					System.out.println("telefono 2: " + listadoP.get(i).getTelefono2());
					System.out.println("==========================================================================");	
				}
				break;
			case 3:
				break;
			}
			
			System.out.println("Seleccione la Opcion: ");
			System.out.println("[1] Registrar");
			System.out.println("[2] Listar Todo");
			System.out.println("[3] Encontrar por id");
			System.out.println("[4] Salir");
			temp = s.nextInt();
		}
		s.close();
	}

}
