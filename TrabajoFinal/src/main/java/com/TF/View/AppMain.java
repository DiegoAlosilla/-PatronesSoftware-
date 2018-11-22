package com.TF.View;

import java.util.List;
import java.util.Scanner;

import com.TF.Controller.ProveedorController;
import com.TF.Model.Dto.Proveedor;
import com.TF.Service.ProveedorService;
import com.TF.Service.Impl.ProveedorServiceImpl;

public class AppMain {
	
    public static void main(String[] args) {
    	menu();
            }

    /*
 
	 * System.out.println("Seleccione la Opcion: ");
	 * System.out.println("[1] Registrar"); System.out.println("[2] Listar Todo");
	 * System.out.println("[3] Encontrar por id"); System.out.println("[4] Salir");
	 * int temp = Integer.parseInt(s.nextLine()); while(temp != 4) { switch(temp) {
	 * case 1: obj = new Proveedor(); System.out.println("Ingresar razon: ");
	 * obj.setRazonSocial(s.nextLine()); System.out.println("Ingresar rubro: ");
	 * obj.setRubro(s.nextLine()); System.out.println("Ingresar ruc: ");
	 * obj.setRuc(Double.parseDouble(s.nextLine()));
	 * System.out.println("Ingresar nombre: ");
	 * obj.setNombreComercial(s.nextLine()); System.out.println("Ingresar pais: ");
	 * obj.setPais(s.nextLine()); System.out.println("Ingresar ciudad: ");
	 * obj.setCiudad(s.nextLine()); System.out.println("Ingresar referencia: ");
	 * obj.setReferencia(s.nextLine()); System.out.println("Ingresar provincia: ");
	 * obj.setProvincia(s.nextLine()); System.out.println("Ingresar direccion: ");
	 * obj.setDireccion(s.nextLine()); System.out.println("Ingresar email: ");
	 * obj.setEmail(s.nextLine()); System.out.println("Ingresar contacto: ");
	 * obj.setContacto(s.nextLine()); System.out.println("Ingresar fax: ");
	 * obj.setFax(Double.parseDouble(s.nextLine()));
	 * System.out.println("Ingresar telf1: ");
	 * obj.setTelefono1(Double.parseDouble(s.nextLine()));
	 * System.out.println("Ingresar telf2: ");
	 * obj.setTelefono2(Double.parseDouble(s.nextLine()));
	 * if(pController.SaveProveedor(obj)) System.out.println("Registro Okey"); else
	 * System.out.println("Ocurrio un error"); break; case 2: listadoP =
	 * pController.GetAll(); for(int i = 0; i < listadoP.size(); i++) {
	 * System.out.println("id: " + listadoP.get(i).getId());
	 * System.out.println("razon: " + listadoP.get(i).getRazonSocial());
	 * System.out.println("rubro: " + listadoP.get(i).getRubro());
	 * System.out.println("ruc: " + listadoP.get(i).getRuc());
	 * System.out.println("nombre: " + listadoP.get(i).getNombreComercial());
	 * System.out.println("pais: " + listadoP.get(i).getPais());
	 * System.out.println("provincia: " + listadoP.get(i).getProvincia());
	 * System.out.println("ciudad: " + listadoP.get(i).getCiudad());
	 * System.out.println("direccion: " + listadoP.get(i).getDireccion());
	 * System.out.println("referencia: " + listadoP.get(i).getReferencia());
	 * System.out.println("email: " + listadoP.get(i).getEmail());
	 * System.out.println("contacto: " + listadoP.get(i).getContacto());
	 * System.out.println("fax: " + listadoP.get(i).getFax());
	 * System.out.println("telefono 1: " + listadoP.get(i).getTelefono1());
	 * System.out.println("telefono 2: " + listadoP.get(i).getTelefono2());
	 * System.out.println(
	 * "==========================================================================")
	 * ; } break; case 3: break; }
	 * 
	 * System.out.println("Seleccione la Opcion: ");
	 * System.out.println("[1] Registrar"); System.out.println("[2] Listar Todo");
	 * System.out.println("[3] Encontrar por id"); System.out.println("[4] Salir");
	 * temp = s.nextInt(); } s.close();
     */
    public static void menu() {
		Proveedor obj;
        List<Proveedor> listadoP;
        ProveedorService proServ = new ProveedorServiceImpl();
        ProveedorController pController = new ProveedorController(proServ);
        Scanner s = new Scanner(System.in);

        int ap = 0;
        int ra= 0;
        int re=0;
        int ri=0;
        int ro=0;
       
        do {
            System.out.println("1.Registrar orden de compra");
            System.out.println("2.Consultar orden de compra");
            System.out.println("3.Modificar producto");
            System.out.println("4.Consultar proveedor");
            System.out.println("5.Actualizar estado cotización");
            ap = s.nextInt();
            switch (ap) {
                case 1:

                    System.out.println("Registrar orden de compra");
                    System.out.println("-------------------------");
                    int valor = 1234123;
                    System.out.println("Orden de compra : " + valor);
                   // recursiva_modificar();
                    break;
                case 2:
                    System.out.println("Consultar orden de compra ");
                    System.out.println("------------------------- ");
                    System.out.println("N° Orden : ");
                    // Ingresar numero de orden
                    System.out.println("Codigo    Proveedor             Precio     Descuento      Importe ");
                    //Mostrar los datos desde la bd
                    System.out.println("..................................................................");
                    System.out.println("Presione 1 para volver al menu");
                    ra=s.nextInt();
                    if (ra==1) {
                    	menu();
                    }
                    break;
                case 3:
                    System.out.println("Modificar Producto ");
                    System.out.println("------------------ ");
                    System.out.println("Si desea modificar ingrese el nuevo valor, si no desea modificar ingrese 0 ");
                    System.out.println("Nombre :  ");
                    // Ingresar variable nombre
                    System.out.println("Precio :  ");
                    // Ingresar precio
                    System.out.println("Nivel minimo : ");
                    // Ingresar nivel minimo
                    System.out.println("Proveedor : ");
                    // Ingresar Proveedor
                    System.out.println("Producto Modificado");
                    System.out.println("....................");
                    System.out.println("Presione 1 para volver al menu");
                    re=s.nextInt();
                    if (re==1) {
                    	menu();
                    }
                    break;
                case 4:
                    System.out.println("Consultar Proveedor");
                    System.out.println("-------------------");
                    System.out.println("RUC: ");
                    //ingresa Ruc
                    System.out.println("Codigo       Razon Social   RUC    Rubro   Direccion");
                    // ingresa ruc
                    System.out.println("..................................................................");
                    System.out.println("Presione 1 para volver al menu");
                    ri=s.nextInt();
                    if (ri==1) {
                    	menu();
                    }
                    break;
                case 5:
                    System.out.println("Actualizar estado de cotizacion");
                    System.out.println("-------------------------------");
                    System.out.println("Codigo(Finalize con enter) : ");
                    // Ingresa el codigo
                    System.out.println("Codigo     Proveedor    Precio   Descuento");
                    System.out.println("Nombre : ");
                    // Mostrar nombre del proveedor
                    System.out.println("Estado de cotización actualizado ");
                    System.out.println("Presione 1 para volver al menu");
                    ro=s.nextInt();
                    if (ro==1) {
                    	menu();
                    }
                    break;
                default:
                    break;
            }
        } while (ap != 1 && ap != 2 && ap != 3 && ap != 4 && ap != 5);

	}
    
}