/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import datos.ProductDAO;
import datos.SupplierDAO;
import domainOrcl.*;
import dto.ProductDTO;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.SQLException;
import java.util.ArrayList;
;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    ProductDAO productDao;
    @Inject
    SupplierDAO supplierDao;

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response listarProdutcs() {
        ArrayList<ProductDTO> lista = new ArrayList<>();
        try {
            for (Product actual : productDao.select()) {
                lista.add(new ProductDTO(actual.getProductId(),
                        actual.getProductName(),
                        actual.getUnitPrice(),
                        actual.getQuantityPerUnit(),
                        actual.getUnitInStock()));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceJAXRS.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Response.status(Response.Status.OK).entity(lista).build();
    }

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("{id}")
    public Product findByID(@PathParam("id") int id) {

        try {

            return productDao.getProduct(id);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("Entramos al rollback");
            return null;

        }

    }

    @POST
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response agregarProduct(Product product) {
        try {

            return Response.ok().entity(productDao.insert(product)).build();
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
            Product productL = productDao.getProduct(id);
            if (productL != null) {
                productDao.update(product);
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
    public Response eliminarProductById(@PathParam("id") int id) {
        try {
            Product p = new Product();
            p.setProductId(BigDecimal.valueOf(id));
            productDao.delete(p);
            return Response.ok().build();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return Response.status(404).build();
        }
    }
}
