package pcshop.entities;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuPrincipal {

    public void ejecutarMenuPrincipal(Producto producto, Inventario inventario) {
        Scanner sc = new Scanner(System.in);
        int opcionMenu = 0;
        boolean salirCiclo = false;
        do{
        try{
        System.out.println("Digite el numero de la opcion que desea ingresar: ");
        System.out.println("1: Agregar producto.\n"
                + "2: Buscar producto por nombre.\n"
                + "3: Actualizar producto por ID.\n"
                + "4: Eliminar producto por Id.\n"
                + "5: Listar todos los productos.\n"
                + "6: Buscar producto por descripcion.\n"
                + "7: Salir.");
        
        opcionMenu = sc.nextInt();
        sc.nextLine();
        }catch(InputMismatchException e){
            System.out.println("Dato ingresado incorrecto,por favor elegi un numero valido");
            sc.nextLine(); //Limpio el buffer de mi scanner
            continue;       //reinicio el ciclo
        }
        
        switch (opcionMenu) {
            //AGREGAR PRODUCTO A INVENTARIO
            case 1:
                inventario.agregarProducto(producto);
                break;
                //BUSCAR PRODUCTO POR NOMBRE
            case 2:
                System.out.println("Ingrese el nombre del prducto que desea buscar:");
                String nombreProd = sc.nextLine();
                inventario.obtenerProductoPorNombre(nombreProd);
                break;
                //ACTUALIZAR PRODUCTO POR ID
            case 3:
                System.out.println("Mostrando productos..");
                inventario.listarTodosLosProductos();
                System.out.println("Ingrese el id del producto que desea actualizar");
                int idProd = sc.nextInt();
                inventario.actualizarProducto(idProd);
                break;
                //ELIMINAR PRODUCTO POR ID
            case 4:
                System.out.println("Mostrando productos..");
                inventario.listarTodosLosProductos();
                System.out.println("Ingrese el id del producto que desea eliminar");
                idProd = sc.nextInt();
                inventario.eliminarProductoPorId(idProd);
                break;
                //LISTAR TODOS LOS PRODUCTOS
            case 5:
                inventario.listarTodosLosProductos();
                break;
                //BUSCAR PRODUCTO POR DESCRIPCION
            case 6:
                System.out.println("Ingrese la una palabra que este dentro de la descripcion de un producto para poder localizarlo");
                String descripcion = sc.nextLine();
                inventario.buscarProdPorDescripcion(descripcion);
                break;
                //SALIR
            case 7:
                System.out.println("Saliendo del sistema..");
                salirCiclo = true;
                break;
                
            default:
                    System.out.println("Lo sentimos la opcion ingresada no es valida");
        }
        }while(!salirCiclo);
    }
}
