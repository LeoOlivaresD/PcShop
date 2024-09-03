package pcshop.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Inventario {

    private List<Producto> listaProductos;

    public Inventario() {
        this.listaProductos = new ArrayList<>();
    }

    public Inventario(List<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public List<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(List<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    //Metodo para generar ids automaticos en productos
    public Integer generarIdProducto() {
        Random randomNumero = new Random();
        int idGenerado = randomNumero.nextInt(1000) + 1;
        return idGenerado;
    }

    //Obtengo un producto por medio de su ID
    public Producto obtenerProductoPorId(int idProd) {
        Producto productoBuscado = new Producto();
        for (Producto productoEncontrado : listaProductos) {
            if (productoEncontrado.getIdProducto() == idProd) {
                System.out.println("Producto encontrado !");
                productoBuscado = productoEncontrado;
                return productoBuscado;
            } else {
                System.out.println("Lo sentimos, producto no encotrado");
            }
        }
        return null;
    }

    public Producto obtenerProductoPorNombre(String nombreProd) {
        Producto productoBuscado = new Producto();
        for (Producto productoEncontrado : listaProductos) {
            if (productoEncontrado.getNombreProducto().equalsIgnoreCase(nombreProd)) {
                System.out.println("Producto encontrado !");
                productoBuscado = productoEncontrado;
                return productoBuscado;
            } else {
                System.out.println("Lo sentimos, no encontramos el producto");
            }
        }
        return null;
    }

    public void agregarProducto(Producto producto) {

        Scanner sc = new Scanner(System.in);
        producto.setIdProducto(generarIdProducto());
        System.out.println("Id generado: " + producto.getIdProducto());
        System.out.println("Ingrese nombre para producto: ");
        String nombreProducto = sc.nextLine();
        producto.setNombreProducto(nombreProducto);
        System.out.println("Nombre agregado con exito !");
        System.out.println("Ingrese una descripcion para el producto: ");
        String descripcionProd = sc.nextLine();
        producto.setDescripcionProducto(descripcionProd);
        System.out.println("Descripcion agregada con exito !");
        System.out.println("Ingrese precio del producto: ");
        double precio = sc.nextDouble();
        producto.setPrecioProducto(precio);
        System.out.println("Precio agregado con exito !");
        System.out.println("Ingrese cantidad de stock para productos");
        int stock = sc.nextInt();
        producto.setCantidadStockProducto(stock);
        System.out.println("Stock agregado con exito !");
        listaProductos.add(producto);

        if (!listaProductos.isEmpty()) {
            System.out.println("Producto agregado con exito al inventario");
        }

    }

    public void actualizarProducto(int idProd) {
        Scanner sc = new Scanner(System.in);
        Producto productoBuscado;
        for (Producto productoEncontrado : listaProductos) {
            if (productoEncontrado.getIdProducto() == idProd) {
                productoBuscado = productoEncontrado;
                System.out.println("Ingrese nombre para producto: ");
                String nombreProducto = sc.nextLine();
                productoBuscado.setNombreProducto(nombreProducto);
                System.out.println("Nombre agregado con exito !");
                System.out.println("Ingrese una descripcion para el producto: ");
                String descripcionProd = sc.nextLine();
                productoBuscado.setDescripcionProducto(descripcionProd);
                System.out.println("Descripcion agregada con exito !");
                System.out.println("Ingrese precio del producto: ");
                double precio = sc.nextDouble();
                sc.nextLine();
                productoBuscado.setPrecioProducto(precio);
                System.out.println("Precio agregado con exito !");
                System.out.println("Ingrese cantidad de stock para productos");
                int stock = sc.nextInt();
                sc.nextLine();
                productoBuscado.setCantidadStockProducto(stock);
                System.out.println("Stock agregado con exito !");
                //listaProductos.add(productoEncontrado); se pongo esta linea mi producto quedaria duplicado con el id
                System.out.println("Producto actualizado con exito");
            }
        }

    }

    //Elimina un producto por el id
    public void eliminarProductoPorId(int idProd) {
        Producto productoAEliminar = null;
        for (Producto producto : listaProductos) {
            if (producto.getIdProducto() == idProd) {
                productoAEliminar = producto;
                break;
            }
        }
        if (productoAEliminar != null) {
            listaProductos.remove(productoAEliminar);
            System.out.println("Producto eliminado con éxito!");
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    //Listar productos
    public void listarTodosLosProductos() {
        System.out.println("Listando productos");
        for (Producto p : listaProductos) {
            System.out.println(p);
        }
    }

    //Buscar producto por descripcion
    public void buscarProdPorDescripcion(String descripcion) {
        Producto productoBuscado = null;
        for (Producto productoEncontrado : listaProductos) {
            if (productoEncontrado.getDescripcionProducto().contains(descripcion)) {
                productoBuscado = productoEncontrado;
                System.out.println(productoBuscado);
            }else{
            productoBuscado = null;
            }
        }
        if(productoBuscado == null){
            System.out.println("Lo sentimos, no hay productos con esa descripcion");
        }
    }
}
