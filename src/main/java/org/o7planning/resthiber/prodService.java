package org.o7planning.resthiber;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
 
import org.o7planning.resthiber.prodDAO;
import org.o7planning.resthiber.product;
 
@Path("/products")
public class prodService {
//     URI:
//     /contextPath/servletPath/products/{empNo}
	//access from POST2.jsp
    @GET
    @Path("/{x}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public List<product> getproduct(@PathParam("x") String x) {
    	System.out.println("GET_"+x);
        return prodDAO.getproduct(x);
    }
 
    // URI:
    // /contextPath/servletPath/products
    //access from POST2.jsp
    @POST
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public product addproduct(product emp) {
    	System.out.println("POST");
        return prodDAO.addproduct(emp);
    }
 
    // URI:
    // /contextPath/servletPath/products
    //access from GET_TABLE.jsp
    @GET
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public List<product> getproducts_JSON() {
    	System.out.println("prodService_GET");
        List<product> listOfProd = prodDAO.getAllproducts1();
        return listOfProd;
    }
    // URI:
    // /contextPath/servletPath/products
    //accessed from GET2.jsp
    @POST
    @Path("/{x}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public List<product> getprod_search(product p) throws Exception{
    	System.out.println("prodService_getprod_search"+p);
        List<product> listOfProd = prodDAO.getsearch(p);
        System.out.println("prodService_getprod_search"+listOfProd);
        if(listOfProd != null) {
        	System.out.println("prodService_getprod_search"+listOfProd);
        	return listOfProd;	
        };
        System.out.println("prodService_getprod_search"+listOfProd);
        return null;
        
    }
}
