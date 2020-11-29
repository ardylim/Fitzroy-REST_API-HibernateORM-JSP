<!doctype html>
<%@ page import="com.sun.jersey.api.client.Client, com.sun.jersey.api.client.ClientResponse, com.sun.jersey.api.client.WebResource" 
import= "org.codehaus.jackson.JsonParseException"
import= "org.codehaus.jackson.map.JsonMappingException"
import= "org.codehaus.jackson.map.ObjectMapper"
import= "org.o7planning.resthiber.product"
%>
<html>
<body>
<%! String error; String output; %>
<%
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
	%> 
<script type="text/javascript">
function uploadImg(){
	
}
</script>
</body>
</html>
