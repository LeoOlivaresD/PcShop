
package pcshop.entities;


public class Producto {
   private Integer idProducto;
   private String nombreProducto;
   private String descripcionProducto;
   private Double precioProducto;
   private Integer cantidadStockProducto;

    //Contructores
    public Producto() {
    }
    

    public Producto(Integer idProducto, String nombreProducto, String descripcionProducto, Double precioProducto, Integer cantidadStockProducto) {
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.descripcionProducto = descripcionProducto;
        this.precioProducto = precioProducto;
        this.cantidadStockProducto = cantidadStockProducto;
    }
    
    //Getters & Setters

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getDescripcionProducto() {
        return descripcionProducto;
    }

    public void setDescripcionProducto(String descripcionProducto) {
        this.descripcionProducto = descripcionProducto;
    }

    public Double getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(Double precioProducto) {
        this.precioProducto = precioProducto;
    }

    public Integer getCantidadStockProducto() {
        return cantidadStockProducto;
    }

    public void setCantidadStockProducto(Integer cantidadStockProducto) {
        this.cantidadStockProducto = cantidadStockProducto;
    }

    @Override
    public String toString() {
        return "Producto{" + "idProducto=" + idProducto + ", nombreProducto=" + nombreProducto + ", descripcionProducto=" + descripcionProducto + ", precioProducto=" + precioProducto + ", cantidadStockProducto=" + cantidadStockProducto + '}';
    }
    
    
}
