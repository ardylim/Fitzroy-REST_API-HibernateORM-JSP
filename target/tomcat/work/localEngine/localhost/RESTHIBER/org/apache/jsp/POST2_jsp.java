package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.o7planning.resthiber.product;

public final class POST2_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

 String error; String output; 
  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<!doctype html>\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<body>\r\n");
      out.write('\r');
      out.write('\n');

System.out.println("Running_POST2");
String x = request.getParameter("x"); //get parameter from url

product a = new ObjectMapper().readValue(x, product.class); //assign string as product object

String isbnString = String.valueOf(a.getisbn()); //get isbn from the created product object from parameter

//Create Client
Client client = Client.create();
WebResource webResource = client.resource("http://localhost:8080/RESTHIBER/rest/products/"); //for the post path
    //----------------------Begin of POST------------------------------
   System.out.println("Client_POST");
WebResource webResource2 = client.resource("http://localhost:8080/RESTHIBER/rest/products/"+isbnString); //for the get path
   //GET to chek if data exist in db
     ClientResponse res = webResource2.accept("application/json").get(ClientResponse.class);
     // Status 200 is successful.
     if (res.getStatus() != 200) {
         error = "Failed with HTTP Error code: " + res.getStatus()+"\n";
       //  error+= res.getEntity(String.class);
         out.println("Error: "+error);
         return;
     }
     String check = res.getEntity(String.class);
     if(check == null || check == "{}" || check==""){	  //if get not returns null or empty, then back to maintenance page
	 // String existData = res.getEntity(String.class);
	  Integer quantity = a.getquantity();
	     output="Data exist in database ....";
	     out.println("<h2>"+output+check+"</h2>");      
	     out.println("<input value='Back' type='button' onclick='window.location.href=\"maintenance.html\"'>");
     }else {out.println("<h2>Data does not exist yet...</h2>"+check);// if get returns null or empty run the post method
   //POST
   		out.println("<h2>Writting to Database...</h2>");
	  ClientResponse resPost = webResource.type("application/json").post(ClientResponse.class, x);
	  if (resPost.getStatus() != 200) { 
        error = "Failed with HTTP Error code: " + resPost.getStatus()+"\n";
        error+= resPost.getEntity(String.class);
        out.println("Error: "+error+x);
        return;
    }else{
    	out.println("<h2>Success...</h2>");
    };
     }
	
      out.write(" \r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("function uploadImg(){\r\n");
      out.write("\t\r\n");
      out.write("}\r\n");
      out.write("</script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
