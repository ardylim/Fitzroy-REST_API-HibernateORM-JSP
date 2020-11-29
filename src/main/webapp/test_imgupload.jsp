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
System.out.println("123");
    	out.println("<h2>Writting to Database Success...</h2>");
    	out.println("<h2>Please upload image...</h2>");
    	out.println("<h3>File Upload:</h3>"+
    		      "Select a file to upload: <br/>"+
        "<form action = 'rest/products/UploadImage' method = 'post' enctype = 'multipart/form-data'>"+
         "  <input type = 'file' name = 'imagefile' size = '50' /><br/>"+
         " <input type = 'submit' value = 'Upload File' /></form>");
    	System.out.println("dadah");
	%> 
<script type="text/javascript">
function uploadImg(){
	
}
</script>
</body>
</html>
