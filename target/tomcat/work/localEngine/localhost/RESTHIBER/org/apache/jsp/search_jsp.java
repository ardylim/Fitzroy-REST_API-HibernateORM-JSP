package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class search_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("     <li style=\"background-color:silver\"> <a href=\"search.jsp\" class=\"w3-bar-item w3-button w3-padding-large\">SEARCH</a></li>\n");
      out.write("    <li> <a href=\"maintenance.jsp\" class=\"w3-bar-item w3-button w3-padding-large w3-hide-small\">MAINTENANCE</a></li>\n");
      out.write("\t<li> <a href=\"javascript:void(0)\" class=\"w3-padding-large w3-hover-red w3-hide-small w3-right\"><i class=\"fa fa-search\"></i></a></li>\n");
      out.write("\t</ul>\n");
      out.write("   \n");
      out.write("  </div>\n");
      out.write("</div>\n");
      out.write("\t  <div class=\"w3-container w3-content w3-padding-64\" style=\"max-width:100%; overflow:hidden\" id=\"catMain\">\n");
      out.write("  <br/> <br/>\n");
      out.write("    <div style=\"height:100%;width:30%\"><br/></div>\n");
      out.write("  <h2 class=\"w3-wide w3-center\">CATALOGUE SEARCH</h2>\n");
      out.write("  \t<div style=\"width:30%;margin: left;float: left\">\n");
      out.write("  \t\t<p id=\"error_alert\" style=\"color:red\"></p>\n");
      out.write("\t\t<h3>Search Criteria</h3>\n");
      out.write("\t\t<div id=\"cri_sch\">\n");
      out.write("\t\t<p style=\"display: inline-block\"><select name=\"option1\" id=\"option1\" style=\"float: center;width: 10em;\" onchange=\"optionchange(1)\">\n");
      out.write("\t\t<option disabled selected value> -- Criteria -- </option>\n");
      out.write("\t\t<option value=\"title\">Title</option>\n");
      out.write("\t\t<option value=\"isbn\">ISBN</option>\n");
      out.write("\t\t<option value=\"cat\">Category</option>\n");
      out.write("\t\t<option value=\"pub\">Publisher</option>\n");
      out.write("\t\t<option value=\"auth\">Author</option>\n");
      out.write("\t\t<option value=\"price\">Price</option>\n");
      out.write("\t\t</select>&emsp;&emsp;&nbsp;&nbsp;&nbsp;&nbsp;\n");
      out.write("\t\t<input id=\"c1\" style=\"float: right;width: 15em;\"type=\"text\" name=\"noname\">\n");
      out.write("\t\t</p>\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<input class=\"add-button\" value=\"More Criteria\" type=\"button\" style=\"margin:left;width: 10em;\" onclick=\"addCri()\">\n");
      out.write("\t\t<input class=\"add-button\" value=\"Submit\" type=\"button\" style=\"margin:right;width: 10em;\" onclick=\"submit()\">\n");
      out.write("\t</div>\n");
      out.write("\t\t<div style=\"width:70%;margin: right;float:right\">\n");
      out.write("\t\t<iframe style=\"width:100%;height:100%;border:none;border:0\" id=\"ifrm\">\n");
      out.write("\t\t<h2>Search result will appear here</h2>\n");
      out.write("\t\t</iframe>\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("\t<footer class=\"w3-container w3-center w3-opacity w3-light-grey w3-xlarge\">\n");
      out.write("  <p class=\"fa fa-copyright\">2020 Fitzroy Catholic Bookshop</p>\n");
      out.write("</footer>\n");
      out.write("\n");
      out.write("<script>\n");
      out.write("var optIndex = 1;\n");
      out.write("document.getElementById('ifrm').style.height = screen.height/1.75+\"px\";\n");
      out.write("\n");
      out.write("console.log(document.getElementById('ifrm').height +\" dan \"+screen.height);\n");
      out.write("function addCri(){\n");
      out.write("\tif(0<optIndex<6){\n");
      out.write("\t\toptIndex++;\n");
      out.write("\t\tconsole.log(\"current optIndex=\"+optIndex);\n");
      out.write("\t\tvar more = \"<p style='display: inline-block'><select name='option\"+optIndex+\n");
      out.write("\t\t\"'id='option\"+optIndex+\"' style='float: center;width: 10em;' onchange='optionchange(\"+optIndex+\")'>\"+\n");
      out.write("\t\t\"<option disabled selected value> -- Criteria -- </option>\"+\n");
      out.write("\t\t\"<option value='title'>Title</option>\"+\n");
      out.write("\t\t\"<option value='isbn'>ISBN</option>\"+\n");
      out.write("\t\t\"<option value='cat'>Category</option>\"+\n");
      out.write("\t\t\"<option value='pub'>Publisher</option>\"+\n");
      out.write("\t\t\"<option value='auth'>Author</option>\"+\n");
      out.write("\t\t\"<option value='price'>Price</option>\"+\n");
      out.write("\t\t\"</select>&emsp;&emsp;&nbsp;&nbsp;&nbsp;&nbsp;\"+\n");
      out.write("\t\t\"<input id='c\"+optIndex+\"'style='float: right;width: 15em;'type='text' name='noname'>\"+\n");
      out.write("\t\t\"</p>\";\n");
      out.write("\t\tdocument.getElementById(\"cri_sch\").innerHTML+=more;\n");
      out.write("\t}else if(optIndex>5){\n");
      out.write("\t\talert(\"too many criteria field\");\n");
      out.write("\t}else if(optIndex<1){\n");
      out.write("\t\talert(\"really?!\");\n");
      out.write("\t};\n");
      out.write("};\n");
      out.write("function optionchange(i){\n");
      out.write("\tif(6>i>0){\n");
      out.write("\t\tif(document.getElementById(\"option\"+i).options[document.getElementById(\"option\"+i).selectedIndex].value==\"isbn\"){\n");
      out.write("\t\tdocument.getElementById(\"c\"+i).name = \"isbn\";}\n");
      out.write("\t\telse if(document.getElementById(\"option\"+i).options[document.getElementById(\"option\"+i).selectedIndex].value==\"title\"){\n");
      out.write("\t\t\tdocument.getElementById(\"c\"+i).name = \"title\";}\n");
      out.write("\t\telse if(document.getElementById(\"option\"+i).options[document.getElementById(\"option\"+i).selectedIndex].value==\"cat\"){\n");
      out.write("\t\t\tdocument.getElementById(\"c\"+i).name = \"cat\";}\n");
      out.write("\t\telse if(document.getElementById(\"option\"+i).options[document.getElementById(\"option\"+i).selectedIndex].value==\"pub\"){\n");
      out.write("\t\t\tdocument.getElementById(\"c\"+i).name = \"pub\";}\n");
      out.write("\t\telse if(document.getElementById(\"option\"+i).options[document.getElementById(\"option\"+i).selectedIndex].value==\"auth\"){\n");
      out.write("\t\t\tdocument.getElementById(\"c\"+i).name = \"auth\";}\n");
      out.write("\t\telse if(document.getElementById(\"option\"+i).options[document.getElementById(\"option\"+i).selectedIndex].value==\"price\"){\n");
      out.write("\t\t\tdocument.getElementById(\"c\"+i).name = \"price\";}\n");
      out.write("\t\t\n");
      out.write("\t}\n");
      out.write("\n");
      out.write("};\n");
      out.write("\n");
      out.write(" function submit(){\n");
      out.write("\t var text;\n");
      out.write("\t \n");
      out.write("\t\tvar isbn = \"\";\n");
      out.write("\t\tvar cat = \"\";\n");
      out.write("\t\tvar title = \"\";\n");
      out.write("\t\tvar auth =\"\";\n");
      out.write("\t\tvar pub = \"\";\n");
      out.write("\t\tvar price =\"\";\n");
      out.write("\t\tvar quantity = \"\";\n");
      out.write("\t\tvar imagePath = \"\";\n");
      out.write("\n");
      out.write("\t\tfor(var z = 1; z<optIndex+1;z++){\n");
      out.write("\t\t\tif(document.getElementById(\"c\"+z).name == \"noname\"){\n");
      out.write("\t\t\t\talert(\"please choose criteria option field\");\n");
      out.write("\t\t\t\treturn;};\n");
      out.write("\t\t\tif(document.getElementById(\"c\"+z).value == \"\"||document.getElementById(\"c\"+z).value == null){\n");
      out.write("\t\t\t\talert(\"please enter the search keyword\");\n");
      out.write("\t\t\t\treturn;\n");
      out.write("\t\t\t}else{\n");
      out.write("\t\t\t\tif(document.getElementById(\"c\"+z).name == \"isbn\"){\n");
      out.write("\t\t\t\t\tif(isNaN(document.getElementById(\"c\"+z).value) != true){isbn = document.getElementById(\"c\"+z).value\n");
      out.write("\t\t\t\t\t\t}else{alert(\"ISBN field has to be in number\"); return;\n");
      out.write("\t\t\t\t\t\t}\n");
      out.write("\t\t\t\t\t}\n");
      out.write("\t\t\t\telse if (document.getElementById(\"c\"+z).name == \"title\"){title = document.getElementById(\"c\"+z).value}\n");
      out.write("\t\t\t\telse if (document.getElementById(\"c\"+z).name == \"cat\"){cat = document.getElementById(\"c\"+z).value}\n");
      out.write("\t\t\t\telse if (document.getElementById(\"c\"+z).name == \"pub\"){pub = document.getElementById(\"c\"+z).value}\n");
      out.write("\t\t\t\telse if (document.getElementById(\"c\"+z).name == \"auth\"){auth = document.getElementById(\"c\"+z).value}\n");
      out.write("\t\t\t\telse if (document.getElementById(\"c\"+z).name == \"price\"){price = document.getElementById(\"c\"+z).value};\n");
      out.write("\t\t\t};\n");
      out.write("\t\t\tconsole.log(document.getElementById(\"c\"+z).name+\"=\"+document.getElementById(\"c\"+z).value);\n");
      out.write("\t\t\t//text+= \",\\\"\"+document.getElementById(\"c\"+z).name+\"\\\":\\\"\"+document.getElementById(\"c\"+z).value+\"\\\"\";\n");
      out.write("\t\t};\n");
      out.write("\t\ttext = \t\t\"{\"+\n");
      out.write("\t\t \"\\\"isbn\\\":\\\"\"+isbn+\"\\\",\"+\n");
      out.write("\t\t\t\"\\\"title\\\":\\\"\"+title+\"\\\",\"+\n");
      out.write("\t\t\t\"\\\"cat\\\":\\\"\"+cat+\"\\\",\"+\n");
      out.write("\t\t\t\"\\\"pub\\\":\\\"\"+pub+\"\\\",\"+\n");
      out.write("\t\t\t\"\\\"auth\\\":\\\"\"+auth+\"\\\",\"+\n");
      out.write("\t\t\t\"\\\"price\\\":\\\"\"+price+\"\\\",\"+\n");
      out.write("\t\t\t\"\\\"quantity\\\":\\\"\\\",\"+\n");
      out.write("\t\t\t\"\\\"imgPath\\\":\\\"\\\"}\";\n");
      out.write("\t\t\tconsole.log(text);\n");
      out.write("\t\tdocument.getElementById('ifrm').append(text);\t\n");
      out.write("\t\tvar url ;\n");
      out.write("\t\tif((isbn ==null || isbn == \"\") && (title == null || title == \"\") && (cat == null || cat ==\"\") && (pub == null || pub ==\"\") &&\n");
      out.write("\t\t\t(auth == null || auth ==\"\") && (price == null || price ==\"\")){\n");
      out.write("\t\t\turl = new URL(\"http://localhost:8080/RESTHIBER/GET_TABLE.jsp\");\n");
      out.write("\t\t}else{url= new URL(\"http://localhost:8080/RESTHIBER/GET2.jsp\");\n");
      out.write("\t\turl.searchParams.append('x',text);\n");
      out.write("\t\t};\n");
      out.write("\t\tconsole.log(url);\n");
      out.write("\t\tdocument.getElementById('ifrm').src = url;\n");
      out.write("};\n");
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
