package pcshop.entities;

import java.util.ArrayList;
import java.util.InputMismatchException;
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

    public void obtenerProductoPorNombre(String nombreProd) {
        Producto productoBuscado = null;
        for (Producto productoEncontrado : listaProductos) {
            if (productoEncontrado.getNombreProducto().contains(nombreProd)) {
                System.out.println("Producto encontrado !");
                productoBuscado = productoEncontrado;
                System.out.println(productoBuscado);
            } else {
                productoBuscado = null;
            }
        }
        if (productoBuscado == null) {
            System.out.println("Lo sentimos, el producto no existe");
        }
    }

    public void agregarProducto(Producto producto) {
        Scanner sc = new Scanner(System.in);
        producto.setIdProducto(generarIdProducto());
        System.out.println("Id generado: " + producto.getIdProducto());

        System.out.println("Ingrese nombre para producto: ");
        String nombreProducto = sc.nextLine();
        producto.setNombreProducto(nombreProducto);
        System.out.println("Nombre agregado con éxito!");

        System.out.println("Ingrese una descripción para el producto: ");
        String descripcionProd = sc.nextLine();
        producto.setDescripcionProducto(descripcionProd);
        System.out.println("Descripción agregada con éxito!");

        // Valido el precio
        double precio = 0;
        boolean precioValido = false;
        do {
            try {
                System.out.println("Ingrese precio del producto: ");
                precio = sc.nextDouble();
                if (precio < 0) {
                    throw new IllegalArgumentException("El precio no puede ser negativo.");
                }
                producto.setPrecioProducto(precio);
                precioValido = true;
                System.out.println("Precio agregado con éxito!");
            } catch (InputMismatchException e) {
                System.out.println("Error: Ingrese un número válido para el precio.");
                sc.next(); // Limpiar el buffer del Scanner
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (!precioValido);

        // Valido el stock
        int stock = 0;
        boolean stockValido = false;
        do {
            try {
                System.out.println("Ingrese cantidad de stock para productos: ");
                stock = sc.nextInt();
                if (stock < 0) {
                    throw new IllegalArgumentException("La cantidad de stock no puede ser negativa.");
                }
                producto.setCantidadStockProducto(stock);
                stockValido = true;
                System.out.println("Stock agregado con éxito!");
            } catch (InputMismatchException e) {
                System.out.println("Error: Ingrese un número entero válido para el stock.");
                sc.next(); // Limpiar el buffer del Scanner
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (!stockValido);

        listaProductos.add(producto);
        if (!listaProductos.isEmpty()) {
            System.out.println("Producto agregado con éxito al inventario.");
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
            System.out.println("Nombre actualizado con éxito!");

            System.out.println("Ingrese una descripción para el producto: ");
            String descripcionProd = sc.nextLine();
            productoBuscado.setDescripcionProducto(descripcionProd);
            System.out.println("Descripción actualizada con éxito!");

            // Validar precio
            double precio = 0;
            boolean precioValido = false;
            do {
                try {
                    System.out.println("Ingrese precio del producto: ");
                    precio = sc.nextDouble();
                    if (precio < 0) {
                        throw new IllegalArgumentException("El precio no puede ser negativo.");
                    }
                    productoBuscado.setPrecioProducto(precio);
                    precioValido = true;
                    System.out.println("Precio actualizado con éxito!");
                } catch (InputMismatchException e) {
                    System.out.println("Error: Ingrese un número válido para el precio.");
                    sc.next(); // Limpiar el buffer del Scanner
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            } while (!precioValido);

            // Validar stock
            int stock = 0;
            boolean stockValido = false;
            do {
                try {
                    System.out.println("Ingrese cantidad de stock para productos: ");
                    stock = sc.nextInt();
                    if (stock < 0) {
                        throw new IllegalArgumentException("La cantidad de stock no puede ser negativa.");
                    }
                    productoBuscado.setCantidadStockProducto(stock);
                    stockValido = true;
                    System.out.println("Stock actualizado con éxito!");
                } catch (InputMismatchException e) {
                    System.out.println("Error: Ingrese un número entero válido para el stock.");
                    sc.next(); // Limpiar el buffer del Scanner
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            } while (!stockValido);

            System.out.println("Producto actualizado con éxito.");
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
            } else {
                productoBuscado = null;
            }
        }
        if (productoBuscado == null) {
            System.out.println("Lo sentimos, no hay productos con esa descripcion");
        }
    }
}
