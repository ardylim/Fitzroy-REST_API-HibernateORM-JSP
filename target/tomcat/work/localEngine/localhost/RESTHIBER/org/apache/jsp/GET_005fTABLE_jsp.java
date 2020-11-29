package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import org.json.JSONObject;
import org.json.JSONArray;

public final class GET_005fTABLE_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head> <title>List of Product</title>\r\n");
      out.write("    <style>\r\n");
      out.write("        th, td, p, input {\r\n");
      out.write("            font:14px Verdana;\r\n");
      out.write("        }\r\n");
      out.write("        table, th, td \r\n");
      out.write("        {\r\n");
      out.write("            border: solid 1px #DDD;\r\n");
      out.write("            border-collapse: collapse;\r\n");
      out.write("            padding: 2px 3px;\r\n");
      out.write("            text-align: center;\r\n");
      out.write("        }\r\n");
      out.write("        th {\r\n");
      out.write("            font-weight:bold;\r\n");
      out.write("        }\r\n");
      out.write("    </style></head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t<h2>No search criteria, shows all Product detail</h2>\r\n");
      out.write("    <p id=\"showData\"></p>\r\n");



System.out.println("Running_index3");
//Create Client
Client client = Client.create();
WebResource webResource = client.resource("http://localhost:8080/RESTHIBER/rest/products/");

System.out.println("Client_GET");
    //--------------------Begin of test GET by uncommenting the following------------------------------
    //GET
    ClientResponse res = webResource.accept("application/json").get(ClientResponse.class);
    // Status 200 is successful.
    if (res.getStatus() != 200) {
        error = "Failed with HTTP Error code: " + res.getStatus()+"\n";
        error+= res.getEntity(String.class);
        out.println("Error: "+error);
        System.out.println("error");
        return;
    }
	
    output = res.getEntity(String.class);
    JSONObject jsonObject = new JSONObject(output);
//    JSONObject jj = jsonObject.getJSONObject("products");
    JSONArray jarray = new JSONArray(jsonObject.get("products").toString());
    String htmll = "<table class='column3 tworow' style='background-color:#bbb;' align='center' border='1'>"+
    				"<thead>"+
    "<tr class='header' style='color:#ffffff'>"+
    "<th class='tab_header'>ISBN/SERIAL NUMBER</th>"+
    "<th class='tab_header'>TITLE</th>"+
    "<th class='tab_header'>CATEGORY</th>"+
    "<th class='tab_header'>PUBLISHER</th>"+
    "<th class='tab_header'>AUTHOR</th>"+
    "<th class='tab_header'>PRICE</th>"+
    "<th class='tab_header'>QUANTITY AVAILABLE</th>"+
    "<th class='tab_header'>IMAGE</th>"+
    "</tr></thead><tbody id='body_rows'>";
  //  out.println("<h2>"+jsonObject+"</h2>");
    for(int i = 0; i<jarray.length();i++){
  //  out.println("<h2>"+jarray.getJSONObject(i)+"</h2>");
    htmll += "<tr>";
    htmll +="<td>"+jarray.getJSONObject(i).getInt("isbn")+"</td>";
    htmll +="<td>"+jarray.getJSONObject(i).getString("title")+"</td>";
    htmll +="<td>"+jarray.getJSONObject(i).getString("cat")+"</td>";
    htmll +="<td>"+jarray.getJSONObject(i).getString("pub")+"</td>";
    htmll +="<td>"+jarray.getJSONObject(i).getString("auth")+"</td>";
    htmll +="<td>"+jarray.getJSONObject(i).getDouble("price")+"</td>";
    htmll +="<td>"+jarray.getJSONObject(i).getInt("quantity")+"</td>";
    htmll +="<td><img src='"+jarray.getJSONObject(i).getString("imgPath")+"'></td>";
    htmll += "</tr>";
    };
    htmll+= "</tbody></table>";
    //put json to table
    out.println(htmll);
    //----------------------End of test GET ------------------------------------------------------------
/*
    //----------------------Begin of test POST  by uncommenting the following------------------------------
   System.out.println("Client_POST");
   //POST followed by GET
       
	 String postData = "{"+
			 "\"isbn\":\"876\","+
				"\"title\":\"BOBOBO\","+
				"\"cat\":\"book\","+
				"\"pub\":\"Orbits\","+
				"\"auth\":\"AJ\","+
				"\"price\":\"100.0\","+
				"\"quantity\":\"10\","+
				"\"imgPath\":\"fitzroy.png\""+
				"}";
	  ClientResponse resPost = webResource.type("application/json").post(ClientResponse.class, postData);
	  if (resPost.getStatus() != 200) { 
         error = "Failed with HTTP Error code: " + resPost.getStatus()+"\n";
         error+= resPost.getEntity(String.class);
        
         out.println("Error: "+error+postData);
         return;
     }
     
 
     ClientResponse res = webResource.accept("application/json").get(ClientResponse.class);
 
     // Status 200 is successful.
     if (res.getStatus() != 200) {
     
         
         error = "Failed with HTTP Error code: " + res.getStatus()+"\n";
         error+= res.getEntity(String.class);
         
         out.println("Error: "+error);
         return;
     }

     output = resPost.getEntity(String.class);
 
     output+="<br>Output from Server .... \n";
     out.println("<h2>"+output+"</h2>");
*/     
        
//----------------------End of test POST  -------------------------------------------------
/*
System.out.println("Client_PUT");
   //----------------------Begin of test PUT by uncommenting the following------------------------------     
     //Update using PUT - Change Employee E01 from Smith to Smith 2
     String putData = "{"+
	"\"empNo\":\"E01\","+
	"\"empName\":\"Smith 2\","+
	"\"position\":\"Clerk\""+
	"}";
     
      ClientResponse resPut = webResource.type("application/json").put(ClientResponse.class, putData);
	  if (resPut.getStatus() != 200) {
     
         
         error = "Failed with HTTP Error code: " + resPut.getStatus()+"\n";
         error+= resPut.getEntity(String.class);
         
         out.println("Error: "+error);
         return;
     }
     
     ClientResponse res = webResource.accept("application/json").get(ClientResponse.class);
 
     // Status 200 is successful.
     if (res.getStatus() != 200) {
     
         
         error = "Failed with HTTP Error code: " + res.getStatus()+"\n";
         error+= res.getEntity(String.class);
         
         out.println("Error: "+error);
         return;
     }

     output = resPut.getEntity(String.class);
 
     output+="\nOutput from Server .... \n";
     out.println(output);
   //----------------------End of test PUT ------------------------------
   */
   /*  
   //----------------------Begin of test DELETE by uncommenting the following------------------------------
     ClientResponse deleteResp = webResource.path("E01").delete(ClientResponse.class);

      ClientResponse res = webResource.accept("application/json").get(ClientResponse.class);
 
     // Status 200 is successful.
     if (res.getStatus() != 200) {
     
         
         error = "Get Failed with HTTP Error code: " + res.getStatus()+"\n";
         error+= res.getEntity(String.class);
         
         out.println("Error: "+error);
         return;
     }

     output = deleteResp.getEntity(String.class);
 
     output+="\nOutput from Server .... \n";
     out.println(output);
   
      //----------------------End of test DELETE ------------------------------
	*/
	
      out.write(" \r\n");
      out.write("\r\n");
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
