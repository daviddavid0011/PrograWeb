/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package facade;

import static java.util.Collections.list;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import uc.proyectofinal.Producto;

/**
 *
 * @author Reparador
 */
@Stateless
public class ProductoFacade extends AbstractFacade<Producto> {
    @PersistenceContext(unitName = "uc_ProyectoFinal_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProductoFacade() {
        super(Producto.class);
    }
    
    //Personal
    
    public List<Producto> devolverProductos(double x){
        Query query= this.em.createNamedQuery(Producto.precioLimite);
        query.setParameter("precio", x);
        
        return query.getResultList();
    
    
    }
    
}
