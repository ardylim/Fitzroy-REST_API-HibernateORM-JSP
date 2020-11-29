<%@ page import="com.sun.jersey.api.client.Client, com.sun.jersey.api.client.ClientResponse, com.sun.jersey.api.client.WebResource" %>
<html>
<head> <title>List of Product</title>
    <style>
        th, td, p, input {
            font:14px Verdana;
        }
        table, th, td 
        {
            border: solid 1px #DDD;
            border-collapse: collapse;
            padding: 2px 3px;
            text-align: center;
        }
        th {
            font-weight:bold;
        }
    </style></head>
<body>
<%@page import="org.json.JSONObject"%>
<%@page import="org.json.JSONArray"%>
<%! String error; String output; %>
	<h2>No search criteria, shows all Product detail</h2>
    <p id="showData"></p>
<%


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
	%> 

</body>
</html>
