package model.cliente;

public class Test {
	/*Hola mundo*/
	
	public static void main(String[] args) {
	int op = 0;
        int ap = 0;
        do {
            System.out.println("1.Registrar orden de compra");
            System.out.println("2.Consultar orden de compra");
            System.out.println("3.Modificar producto");
            System.out.println("4.Consultar proveedor");
            System.out.println("5.Actualizar estado cotización");

            switch (op) {
                case 1:

                    System.out.println("Registrar orden de compra");
                    System.out.println("-------------------------");
                    int valor = 1234123;
                    System.out.println("Orden de compra : " + valor);
                    System.out.println("Ingresar numero de cotizacion :");
                    // Sin numero de cotizacion
                    System.out.println("Ruc : ");
                    // Sin Ruc
                    System.out.println("Proveedor : ");
                    // Proveedor
                    System.out.println("Direccion : ");
                    //Direccion
                    System.out.println("Ciudad : ");
                    //Ciudad
                    System.out.println("Telefono : ");
                    //telefono;
                    System.out.println("Correo : ");
                    //correo;
                    System.out.println(" \n ");
                    System.out.println("Subtotal : ");
                    //subtotal
                    System.out.println("IGV(18%) : ");
                    //IGV
                    System.out.println("Total : ");
                    //total
                    System.out.println("Producto    Unidad   Cantidad   Precio : ");
                    //Productos

                    System.out.println("------------------------------------------ ");
                    do {
                        System.out.println("1.Enviar : ");
                        System.out.println("2.Imprimir : ");
                        System.out.println("3.Modificar datos : ");
                        switch (ap) {
                            case 1:
                                System.out.println("Orden de compra Registrada y enviada");
                                break;
                            case 2:
                                System.out.println("Imprimiendo... ");
                                break;
                            case 3:
                                System.out.println("Modifique los datos ... ");
                                break;
                            default:
                                break;
                        }
                    } while (ap != 1 && ap != 2 && ap != 3);
                    break;
                case 2:
                    System.out.println("Consultar orden de compra ");
                    System.out.println("------------------------- ");
                    System.out.println("N° Orden : ");
                    //Ingresar numero de orden
                    System.out.println("Codigo    Proveedor             Precio     Descuento      Importe ");
                    break;
	}
	

}
