package org.acme.hibernate.orm;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("fruits")
@ApplicationScoped
@Produces("application/json")
@Consumes("application/json")
@Transactional
public class FruitResource {


    @Inject
    EntityManager em;

    @GET
    public String get() {
        Fruit fruit1 = new Fruit();
        fruit1.setName("apple");
        em.persist(fruit1);
        em.flush();
        try {
        em.createNativeQuery("update nonexistenttable set aaa=1").executeUpdate();
        } catch (Exception e) {
        }
        Fruit fruit2 = new Fruit();
        fruit2.setName("apple");
        em.persist(fruit2);
        em.flush();
        
        return "Hello";
    }

}
