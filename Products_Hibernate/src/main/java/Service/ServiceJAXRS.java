/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Domain.Product;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import javax.ws.rs.core.Response.Status;

/**
 *
 * @author lehm
 */
@Path("/products")
@Stateless
public class ServiceJAXRS {

    @Inject
    Service service;

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Product> listarProdutcs() {
        return service.findAllProducts();
    }

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("{id}")
    public Product findByID(@PathParam("id") int id) {
        return service.getProduct(id);
        
        
    }

    @POST
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response agregarProduct(Product product) {
        try {
            service.saveProduct(product);
            return Response.ok().entity(product).build();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return Response.status(Status.INTERNAL_SERVER_ERROR).build();

        }
    }

    @PUT
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("{id}")
    public Response modificarProduct(@PathParam("id") int id, Product product) {
        try {
            Product productL = service.getProduct(id);
            if (productL != null) {
                service.updateProduct(product);
                return Response.ok().entity(product).build();
            } else {
                return Response.status(Status.NOT_FOUND).build();
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return Response.status(Status.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    
    @DELETE
    @Path("{id}")
    public Response eliminarProductById(@PathParam("id") int id){
        try{
            Product p=new Product();
            p.setProductID(id);
            service.deleteProduct(p);
            return Response.ok().build();
        }catch(Exception e){
            e.printStackTrace(System.out);
            return Response.status(404).build();
        }
    }
}
