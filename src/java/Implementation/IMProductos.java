
package Implementation;

import HibernateUtil.HibernateUtil;
import Interface.ITProductos;
import Modelo.Productos;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class IMProductos implements ITProductos{

    @Override
    public List<Productos> consultarProductos() {

        Session session = null;
        List<Productos> listamisProductos = null;
        
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            Transaction ex = session .beginTransaction();
             Query query = session.createQuery("from Productos");
             listamisProductos = (List<Productos>) query.list();
             
             ex.commit();
        } catch (HibernateException e){
            System.out.println(e.getMessage());
        } finally {
            if (session != null){
                
            }
        }
        return listamisProductos;
    }    

      @Override
    public void agregar(Productos productos) {
        Session sesion = null;
        try {
            sesion = HibernateUtil.getSessionFactory().openSession();
            sesion.beginTransaction(); 
           sesion.save(productos);
            sesion.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            sesion.getTransaction().rollback();
        } finally {
            if (sesion != null) {
                sesion.close();
            }
        }
    }

    public void modificar(Productos productos) {
        Session sesion = null;
        try {
            sesion = HibernateUtil.getSessionFactory().openSession();
            sesion.beginTransaction();
            sesion.update(productos);
            sesion.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            sesion.getTransaction().rollback();
        } finally {
            if (sesion != null) {
                sesion.close();
            }
        }
    }

    public void eliminar(Productos productos) {
        Session sesion = null;
        try {
            sesion = HibernateUtil.getSessionFactory().openSession();
            sesion.beginTransaction();
            sesion.delete(productos);
            sesion.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            sesion.getTransaction().rollback();
        } finally {
            if (sesion != null) {
                sesion.close();
            }
        }
    }

}