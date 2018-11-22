package com.TF.View;

import java.util.List;
import java.util.Scanner;


import com.TF.Controller.ProveedorController;
import com.TF.Model.Dto.Proveedor;
import com.TF.Service.ProveedorService;
import com.TF.Service.Impl.ProveedorServiceImpl;


public class AppMain {
	
 
 
        List<Proveedor> listadoP;
        ProveedorService proServ = new ProveedorServiceImpl();
        ProveedorController pController = new ProveedorController(proServ);
        
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

        Scanner s = new Scanner(System.in);

        int op_menu1 = 0;
        int op_consultarOrden= 0;
        int op_modificarProducto=0;
        int op_consultarProveedor=0;
        int op_actualizar=0;
       
        do {
            System.out.println("1.Registrar orden de compra");
            System.out.println("2.Consultar orden de compra");
            System.out.println("3.Modificar producto");
            System.out.println("4.Consultar proveedor");
            System.out.println("5.Actualizar estado cotización");
            op_menu1 = s.nextInt();
            switch (op_menu1) {
                case 1:

                    System.out.println("Registrar orden de compra");
                    System.out.println("-------------------------");
                    int valor = 1234123;
                    System.out.println("Orden de compra : " + valor);
                    recursiva_modificar();
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
                    op_consultarOrden=s.nextInt();
                    if (op_consultarOrden==1) {
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
                    op_modificarProducto=s.nextInt();
                    if (op_modificarProducto==1) {
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
                    op_consultarProveedor=s.nextInt();
                    if (op_consultarProveedor==1) {
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
                    op_actualizar=s.nextInt();
                    if (op_actualizar==1) {
                    	menu();
                    }
                    break;
                default:
                    break;
            }
        } while (op_menu1 != 1 && op_menu1 != 2 && op_menu1 != 3 && op_menu1 != 4 && op_menu1 != 5);

	}
    public static void recursiva_modificar(){
        Proveedor proveedor = new Proveedor();
        Scanner s = new Scanner(System.in);
        int op_recursiva=0;
                    System.out.println("Ingresar numero de cotizacion :");
                    //numero de cotizacion
                    System.out.println("Ruc : ");
                    proveedor.getRuc();
                    System.out.println("Proveedor : ");
                    // Proveedor
                    System.out.println("Direccion : ");
                    // Direccion
                    System.out.println("Ciudad : ");
                    // Ciudad
                    System.out.println("Telefono : ");
                    // telefono;
                    System.out.println("Correo : ");
                    // correo;
                    System.out.println(" \n ");
                    System.out.println("Subtotal : ");
                    // subtotal
                    System.out.println("IGV(18%) : ");
                    // IGV
                    System.out.println("Total : ");
                    // total
                    System.out.println("Producto    Unidad   Cantidad   Precio : ");
                    // Productos

                    System.out.println("------------------------------------------ ");
                    do {
                        System.out.println("1.Enviar : ");
                        System.out.println("2.Imprimir : ");
                        System.out.println("3.Modificar datos : ");
                        op_recursiva = s.nextInt();
                        switch (op_recursiva) {
                            case 1:
                                System.out.println("Orden de compra Registrada y enviada");
                                break;
                            case 2:
                                System.out.println("Imprimiendo... ");
                                break;
                            case 3:
                                //Runtime.getRuntime().exec("cls");
                               // LimpiarPantalla();
                                recursiva_modificar();
                                break;
                            default:
                                break;
                        }
                    } while (op_recursiva != 1 && op_recursiva != 2 && op_recursiva != 3);
    }
}

