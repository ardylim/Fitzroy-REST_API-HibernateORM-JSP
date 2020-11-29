package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class maintenance_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

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

      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("<title>Fitzroy Catholic Bookshop</title>\n");
      out.write("<meta charset=\"UTF-8\">\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("<link rel=\"stylesheet\" href=\"https://www.w3schools.com/w3css/4/w3.css\">\n");
      out.write("<link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/css?family=Lato\">\n");
      out.write("<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\n");
      out.write("<style>\n");
      out.write("body {font-family: \"Lato\", sans-serif; background-image: url(\"img//white.jpg\"); background-repeat: no-repeat;background-size: cover;}\n");
      out.write(".mySlides {display: none}\n");
      out.write("</style>\n");
      out.write("<style>\n");
      out.write("\n");
      out.write("ul.breadcrumb {\n");
      out.write("  padding: 10px 16px;\n");
      out.write("  list-style: none;\n");
      out.write("}\n");
      out.write("ul.breadcrumb li {\n");
      out.write("  display: inline;\n");
      out.write("  font-size: 18px;\n");
      out.write("}\n");
      out.write("ul.breadcrumb li+li:before {\n");
      out.write("  padding: 8px;\n");
      out.write("  color: white;\n");
      out.write("}\n");
      out.write("ul.breadcrumb li a {\n");
      out.write("  color: #0275d8;\n");
      out.write("  text-decoration: none;\n");
      out.write("}\n");
      out.write("ul.breadcrumb li a:hover {\n");
      out.write("  color: #01447e;\n");
      out.write("  text-decoration: underline;\n");
      out.write("}\n");
      out.write("</style>\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("<!-- Navbar -->\n");
      out.write("<div class=\"w3-top\">\n");
      out.write("  <div class=\"w3-bar w3-black w3-card\">\n");
      out.write("   <a class=\"w3-bar-item w3-button w3-padding-large w3-hide-medium w3-hide-large w3-right\" href=\"javascript:void(0)\" onclick=\"myFunction()\" title=\"Toggle Navigation Menu\"><i class=\"fa fa-bars\"></i></a>\n");
      out.write("    <img src=\"img/fitzroy.png\" alt=\"Fitzroy Catholic Bookshop\" width=\"8%\" class=\"w3-left\">\n");
      out.write("\t<ul class=\"breadcrumb\">\n");
      out.write("\t<li> <a href=\"index.jsp\" class=\"w3-bar-item w3-button w3-padding-large\">HOME</a></li>\n");
      out.write("    <li> <a href=\"site_map.jsp\" class=\"w3-bar-item w3-button w3-padding-large w3-hide-small\">SITE MAP</a></li>\n");
      out.write("     <li> <a href=\"search.jsp\" class=\"w3-bar-item w3-button w3-padding-large\">SEARCH</a></li>\n");
      out.write("    <li style=\"background-color:silver\"> <a href=\"maintenance.jsp\" class=\"w3-bar-item w3-button w3-padding-large w3-hide-small\">MAINTENANCE</a></li>\n");
      out.write("\t<li> <a href=\"javascript:void(0)\" class=\"w3-padding-large w3-hover-red w3-hide-small w3-right\"><i class=\"fa fa-search\"></i></a></li>\n");
      out.write("\t</ul>\n");
      out.write("   \n");
      out.write("  </div>\n");
      out.write("</div>\n");
      out.write("\t  <div class=\"w3-container w3-content w3-padding-64\" style=\"max-width:800px\" id=\"catMain\">\n");
      out.write("  </br></br>\n");
      out.write("    <div style=\"height:100%;\"><br></div>\n");
      out.write("  <h2 class=\"w3-wide w3-center\">CATALOGUE MAINTENANCE</h2>\n");
      out.write("  \t<div style=\"width:50%;margin: auto;\">\n");
      out.write("  \t\t<p id=\"error_alert\" style=\"color:red\"></p>\n");
      out.write("  \t\n");
      out.write("\t\t<p style=\"display: inline-block\">Title:&emsp;&emsp;&emsp;&emsp;&emsp;<input id=\"title\" style=\"float: right;width: 15em;\"type=\"text\" placeholder=\"Title\"></p><br>\n");
      out.write("\t\t<p style=\"display: inline-block\">ISBN:  &emsp;&emsp;&emsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input name=\"isbn\" id=\"isbn\"style=\"float: right;width: 15em;\"type=\"number\" min=0 max=9999999999999 placeholder=\"ISBN\"></p><br>\n");
      out.write("\t\t<p style=\"display: inline-block\">Category: &emsp;&emsp;&nbsp;&nbsp;&nbsp;&nbsp;<select name=\"cat\" id=\"cat\" style=\"float: right;width: 15em;\">\n");
      out.write("\t\t<option disabled selected value> -- select an option -- </option>\n");
      out.write("\t\t<option value=\"book\">Book</option>\n");
      out.write("\t\t<option value=\"audio\">Audio Book</option>\n");
      out.write("\t\t<option value=\"music\">Music</option>\n");
      out.write("\t\t<option value=\"VIdeo\">VIdeo</option>\n");
      out.write("\t\t</select></p>\n");
      out.write("\t\t<br>\n");
      out.write("\t\t<p style=\"display: inline-block\">Author(s):&emsp;&emsp;&nbsp;&nbsp;&nbsp;&nbsp;<input id=\"auth\" style=\"float: right;width: 15em;\"type=\"text\" placeholder=\"Author(s)\"></p><br>\n");
      out.write("\t\t<p style=\"display: inline-block\">Publisher:&emsp;&emsp;&nbsp;&nbsp;&nbsp;&nbsp;<select name=\"pub\" id=\"pub\" style=\"float: right;width: 15em;\">\n");
      out.write("\t\t<option disabled selected value> -- select an option -- </option>\n");
      out.write("\t\t<option value=\"harper\">Harper Collins</option>\n");
      out.write("\t\t<option value=\"penguin\">Penguins</option>\n");
      out.write("\t\t<option value=\"paul\">St Pauls Publication</option>\n");
      out.write("\t\t<option value=\"fmed\">Franciscan Media</option>\n");
      out.write("\t\t<option value=\"orbis\">Orbis</option>\n");
      out.write("\t\t</select></p>\n");
      out.write("\t\t<br>\n");
      out.write("\t\t<p style=\"display: inline-block\">Price:&emsp;&emsp;&emsp;&emsp;&nbsp;&nbsp;<input id=\"price\" step=\"0.01\" min=0 style=\"float: right;width: 15em;\"type=\"number\" placeholder=\"Price\"></p><br>\n");
      out.write("\t\t<p style=\"display: inline-block\">Quantity:&emsp;&emsp;&nbsp;&nbsp;&nbsp;&nbsp;<input id=\"quantity\" min=0 style=\"float: right;width: 15em;\"type=\"number\" placeholder=\"Quantity\"></p><br>\n");
      out.write("\t\t<input class=\"add-button\" value=\"Submit\" type=\"button\" style=\"margin:center;width: 20em;\" onclick=\"submit()\">\n");
      out.write("<div>\n");
      out.write("\t\t<iframe style=\"width:100%;height:100%;border:none;border:0\" id=\"ifrm\">\n");
      out.write("\t\t</iframe>\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("\t\n");
      out.write("\t</div>\n");
      out.write("\t\n");
      out.write("\t<footer class=\"w3-container w3-center w3-opacity w3-light-grey w3-xlarge\">\n");
      out.write("  <p class=\"fa fa-copyright\">2020 Fitzroy Catholic Bookshop</p>\n");
      out.write("</footer>\n");
      out.write("<script>\n");
      out.write("function submit(){\n");
      out.write("\tvar errortext = \"\";\n");
      out.write("\tvar error_ = false;\n");
      out.write("\tvar isbn = document.getElementById(\"isbn\").value;\n");
      out.write("\tvar cat = document.getElementById(\"cat\").options[document.getElementById(\"cat\").selectedIndex].text;\n");
      out.write("\tvar title = document.getElementById(\"title\").value;\n");
      out.write("\tvar auth =document.getElementById(\"auth\").value;\n");
      out.write("\tvar pub = document.getElementById(\"pub\").options[document.getElementById(\"pub\").selectedIndex].text;\n");
      out.write("\tvar price =document.getElementById(\"price\").value;\n");
      out.write("\tvar quantity = document.getElementById(\"quantity\").value;\n");
      out.write("\tvar imagePath;\n");
      out.write("\tconsole.log(\"1\"+error_);\n");
      out.write("\tif(title == null || title==\"Title\" || title == \"\"){\n");
      out.write("\t\terror_ = true;\n");
      out.write("\t\terrortext += \"wrong input on Title field<br>\";\n");
      out.write("\t};\n");
      out.write("\tconsole.log(\"2\"+error_);\n");
      out.write("\tif(isbn == null || isbn==\"ISBN\" || isbn == \"\" || isNaN(isbn)|| isbn == 0 || isbn%1 != 0){\n");
      out.write("\t\terror_ = true;\n");
      out.write("\t\terrortext += \"wrong input on ISBN field<br>\";\n");
      out.write("\t};\n");
      out.write("\tconsole.log(\"3\"+error_);\n");
      out.write("\tif(cat == null || cat==\"-- select an option --\" || cat == \"\"){\n");
      out.write("\t\terror_ = true;\n");
      out.write("\t\terrortext += \"wrong input on Category field<br>\";\n");
      out.write("\t};\n");
      out.write("\tconsole.log(\"4\"+error_);\n");
      out.write("\tif(auth == null || auth==\"Author\" || auth == \"\"){\n");
      out.write("\t\terror_ = true;\n");
      out.write("\t\terrortext += \"wrong input on Author field<br>\";\n");
      out.write("\t};\n");
      out.write("\tconsole.log(\"5\"+error_);\n");
      out.write("\tif(pub == null || pub==\"-- select an option --\" || pub == \"\"){\n");
      out.write("\t\terror_ = true;\n");
      out.write("\t\terrortext += \"wrong input on Publisher field<br>\";\n");
      out.write("\t};\n");
      out.write("\tconsole.log(\"6\"+error_);\n");
      out.write("\tif(price == null || price==\"Price\" || price == \"\" || isNaN(price) || price == 0){\n");
      out.write("\t\terror_ = true;\n");
      out.write("\t\terrortext += \"wrong input on Price field<br>\";\n");
      out.write("\t};\n");
      out.write("\tconsole.log(\"7\"+error_);\n");
      out.write("\tif(quantity == null || quantity==\"Quantity\" || quantity == \"\" || isNaN(quantity) || quantity == 0 || quantity%1 != 0){\n");
      out.write("\t\terror_ = true;\n");
      out.write("\t\terrortext += \"wrong input on Quantity field<br>\";\n");
      out.write("\t};\n");
      out.write("\tconsole.log(\"8\"+error_);\n");
      out.write("\t\n");
      out.write("\tif(error_ == false){\n");
      out.write("\t\tvar text2 =\n");
      out.write("\t\t\"{\"+\n");
      out.write("\t\t \"\\\"isbn\\\":\\\"\"+document.getElementById(\"isbn\").value+\"\\\",\"+\n");
      out.write("\t\t\t\"\\\"title\\\":\\\"\"+document.getElementById(\"title\").value+\"\\\",\"+\n");
      out.write("\t\t\t\"\\\"cat\\\":\\\"\"+document.getElementById(\"cat\").options[document.getElementById(\"cat\").selectedIndex].text+\"\\\",\"+\n");
      out.write("\t\t\t\"\\\"pub\\\":\\\"\"+document.getElementById(\"pub\").options[document.getElementById(\"pub\").selectedIndex].text+\"\\\",\"+\n");
      out.write("\t\t\t\"\\\"auth\\\":\\\"\"+document.getElementById(\"auth\").value+\"\\\",\"+\n");
      out.write("\t\t\t\"\\\"price\\\":\\\"\"+document.getElementById(\"price\").value+\"\\\",\"+\n");
      out.write("\t\t\t\"\\\"quantity\\\":\\\"\"+document.getElementById(\"quantity\").value+\"\\\",\"+\n");
      out.write("\t\t\t\"\\\"imgPath\\\":\\\"\"+\"img/\"+document.getElementById(\"isbn\").value+\".png\"+\"\\\"}\";\n");
      out.write("\t\t\tconsole.log(error_);\n");
      out.write("\tvar obj = JSON.parse(text2);\n");
      out.write("\t\talert(JSON.stringify(obj));\n");
      out.write("\tvar url = new URL(\"http://localhost:8080/RESTHIBER/POST2.jsp\");\n");
      out.write("\turl.searchParams.append('x',text2);\n");
      out.write("\t\n");
      out.write("\tdocument.getElementById('ifrm').src = url;\n");
      out.write("\n");
      out.write("\t}else if(error_ == true){document.getElementById(\"error_alert\").innerHTML = errortext+\"Please check again before submitting\";\n");
      out.write("\tconsole.log(error_)};\n");
      out.write("}\n");
      out.write("\n");
      out.write("</script>\n");
      out.write("</body>\n");
      out.write("</html>\n");
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
