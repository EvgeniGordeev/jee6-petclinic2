/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package example.jee6.petclinic.session;

import example.jee6.petclinic.Owner;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author EvgeniGordeev
 */
@Stateless
public class OwnerFacade extends AbstractFacade<Owner> {
    @PersistenceContext(unitName = "jee6-petclinic2PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OwnerFacade() {
        super(Owner.class);
    }
    
}
