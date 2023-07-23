
package Interface;

import Modelo.Productos;
import java.util.List;


public interface ITProductos {
    
    public List<Productos> consultarProductos();
    public void agregar(Productos productos);
    
    
    
}
