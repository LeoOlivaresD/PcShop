package pcshop;

import pcshop.entities.Inventario;
import pcshop.entities.MenuPrincipal;
import pcshop.entities.Producto;


public class PcShop {

   
    public static void main(String[] args) {
        System.out.println("Bienvenido al sistema de inventario de tiendas PcShop");
        Producto producto = new Producto();
        Inventario inventario = new Inventario();
        MenuPrincipal menuPrincipal = new MenuPrincipal();
        System.out.println("********************************************");
        System.out.println("Cargando productos por defecto en sistema..");
        Producto cpu = new Producto(1, "Procesador Ryzen 5", "Procesador de 6 nucleos y 12 hilos", 150000.0, 3);
        Producto gpu = new Producto(2, "Rtx 2070 super", "Targeta de video nvidia para 1080p 144 hz", 200000.0, 3);
        Producto ram = new Producto(3, "Corzair venguence", "Memoria ram de 8gb a 3600 Mhz", 30000.0, 3);
        inventario.getListaProductos().add(cpu);
        inventario.getListaProductos().add(gpu);
        inventario.getListaProductos().add(ram);
        System.out.println("********************************************");
        
        
        menuPrincipal.ejecutarMenuPrincipal(producto, inventario);
           
    }
    
}
