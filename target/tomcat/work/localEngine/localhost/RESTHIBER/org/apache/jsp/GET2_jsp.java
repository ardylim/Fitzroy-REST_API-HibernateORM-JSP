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
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.io.UnsupportedEncodingException;
import org.json.JSONObject;
import org.json.JSONArray;

public final class GET2_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    <p id=\"showData\"></p>\r\n");

System.out.println("Running_GET2");
String x = request.getParameter("x"); //gget the parameter that has been assigned to the url address

product a = new ObjectMapper().readValue(x, product.class); //put the value to product object

int count = 0;

//Create Client
Client client = Client.create();
WebResource webResource = client.resource("http://localhost:8080/RESTHIBER/rest/products/"+"or");

System.out.println("Client_GET"); //shows on console to mark the milestone
    //--------------------Begin of GET ------------------------------
    //GET
    ClientResponse res = webResource.type("application/json").post(ClientResponse.class, x); //utilize post to send the specific criteria json
    // Status 200 is successful.
    if (res.getStatus() != 200 && res.getStatus() != 204) {
        error = "Failed with HTTP Error code: " + res.getStatus()+"\n";
        error+= res.getEntity(String.class);
        out.println("Error: "+error);
        System.out.println("error");
        return;
    }else if(res.getStatus() == 204){
    	System.out.println("No content");
    	out.println("<h2>no record found</h2>");
    }
	
    output = res.getEntity(String.class); //if there is data found, will be stored in the response entity, this line is to get the value
   
    JSONObject jsonObject = new JSONObject(output); //make it to json object

    //begins the table design header
    String htmll = "<table class='column3 tworow' style='background-color:#0f877b;' align='center' border='1'>"+
    				"<thead>"+
    "<tr class='header' style='color:white'>"+
    "<th class='tab_header'>ISBN/SERIAL NUMBER</th>"+
    "<th class='tab_header'>TITLE</th>"+
    "<th class='tab_header'>CATEGORY</th>"+
    "<th class='tab_header'>PUBLISHER</th>"+
    "<th class='tab_header'>AUTHOR</th>"+
    "<th class='tab_header'>PRICE</th>"+
    "<th class='tab_header'>QUANTITY AVAILABLE</th>"+
    "<th class='tab_header'>IMAGE</th>"+
    "</tr></thead><tbody id='body_rows'>";
    int prodNum=0;
    try{
	    JSONArray jarray = new JSONArray(jsonObject.get("products").toString());// from json object to array		
	    for(int i = 0; i<jarray.length();i++){ //for every data found in the json array
	      	if(jarray.getJSONObject(i).getInt("quantity") > 5){ //if the quantity is more than 5 then its green
	      		htmll += "<tr>";	
	      		 htmll +="<td>"+jarray.getJSONObject(i).getInt("isbn")+"</td>";
	      	    htmll +="<td>"+jarray.getJSONObject(i).getString("title")+"</td>";
	      	    htmll +="<td>"+jarray.getJSONObject(i).getString("cat")+"</td>";
	      	    htmll +="<td>"+jarray.getJSONObject(i).getString("pub")+"</td>";
	      	    htmll +="<td>"+jarray.getJSONObject(i).getString("auth")+"</td>";
	      	    htmll +="<td>"+jarray.getJSONObject(i).getDouble("price")+"</td>";
	      	    htmll +="<td>"+jarray.getJSONObject(i).getInt("quantity")+"</td>";
	      	    htmll +="<td><img height= 150px src='"+jarray.getJSONObject(i).getString("imgPath")+"'></td>";
	      	    htmll += "</tr>";
	      	}else{ //if the quantity is less than or equal to 5 then its red (coral), count to count it
	      		count=count+1;
	      		htmll += "<tr bgcolor='#63c7bd' style='background-color: coral;	'>";
	      		 htmll +="<td>"+jarray.getJSONObject(i).getInt("isbn")+"</td>";
	      	    htmll +="<td>"+jarray.getJSONObject(i).getString("title")+"</td>";
	      	    htmll +="<td>"+jarray.getJSONObject(i).getString("cat")+"</td>";
	      	    htmll +="<td>"+jarray.getJSONObject(i).getString("pub")+"</td>";
	      	    htmll +="<td>"+jarray.getJSONObject(i).getString("auth")+"</td>";
	      	    htmll +="<td>"+jarray.getJSONObject(i).getDouble("price")+"</td>";
	      	    htmll +="<td>"+jarray.getJSONObject(i).getInt("quantity")+"</td>";
	      	    htmll +="<td><img height= 150px src='"+jarray.getJSONObject(i).getString("imgPath")+"'></td>";
	      	    htmll += "</tr>";
	      	};
	      	prodNum = jarray.length();
	        };
	}catch(Exception e){
		htmll += "<tr bgcolor='#63c7bd' style='background-color: coral;	'>";
 		htmll +="<td>"+jsonObject.getJSONObject("products").get("isbn")+"</td>";
 	    htmll +="<td>"+jsonObject.getJSONObject("products").get("title")+"</td>";
 	    htmll +="<td>"+jsonObject.getJSONObject("products").get("cat")+"</td>";
 	    htmll +="<td>"+jsonObject.getJSONObject("products").get("pub")+"</td>";
 	    htmll +="<td>"+jsonObject.getJSONObject("products").get("auth")+"</td>";
 	    htmll +="<td>"+jsonObject.getJSONObject("products").get("price")+"</td>";
 	    htmll +="<td>"+jsonObject.getJSONObject("products").get("quantity")+"</td>";
 	    htmll +="<td><img height= 150px src='"+jsonObject.getJSONObject("products").get("imgPath")+"'></td>";
 	    htmll += "</tr>";
 	    prodNum=1;
		if(Integer.parseInt(jsonObject.getJSONObject("products").get("quantity").toString()) <6){
 	    count = 1;};
	};

    
    htmll+= "</tbody></table>";
    //put json to table
    out.println("<h3>Number of product: "+prodNum+"</h3>"); //json array lenght is equal to number of product satisfy the criteria
    out.println("<h3>Total product with quantity below 5: "+count+"</h3>"); //count printed to number of product bellow 6
    out.println(htmll);


      out.write(" \r\n");
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
