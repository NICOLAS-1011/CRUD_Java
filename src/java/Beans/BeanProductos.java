
package Beans;


import Implementation.IMProductos;
import Interface.ITProductos;
import Modelo.Productos;
import java.io.Serializable;
import java.util.List;
import javax.inject.Named;
import javax.faces.view.ViewScoped;


@Named(value = "beanProductos")
@ViewScoped
public class BeanProductos implements Serializable { 

private List<Productos> productosList;
private Productos productos;

    public List<Productos> getProductosList() {
        return productosList;
    }

    public void setProductosList(List<Productos> productosList) {
        this.productosList = productosList;
    }
    
    public List<Productos> metodo(){
        
        ITProductos aux = new IMProductos();
        productosList= aux.consultarProductos();
        
        return productosList;
    }
    
    
    public BeanProductos() {
        
        metodo();
        
    }    
    
    //++++++++++++++++++++++

    public Productos getProductos() {
        return productos;
    }

    public void setProductos(Productos productos) {
        this.productos = productos;
    }

    public void limpiarProductos() {
        productos = new Productos();
    }

    public void agregarProductos() {
        ITProductos ad = new IMProductos();
        ad.agregar(productos);
    }

    public void modificarProductos() {
        IMProductos ad = new IMProductos();
        ad.modificar(productos);
        limpiarProductos();
    }

    public void eliminarProductos() {
        IMProductos ad = new IMProductos();
        ad.eliminar(productos);
        limpiarProductos();
    }
    
}
