<%@ page import = "java.io.*,java.util.*, javax.servlet.*" %>
<%@ page import = "javax.servlet.http.*" %>

<%
//File creation
String strPath = "/img/";
File strFile = new File(strPath);
boolean fileCreated = strFile.createNewFile();
//File appending
Writer objWriter = new BufferedWriter(new FileWriter(strFile));
objWriter.write("This is a test");
objWriter.flush();
objWriter.close();

if(fileCreated = true){
out.println("done");}else{out.println("undone");};
%>