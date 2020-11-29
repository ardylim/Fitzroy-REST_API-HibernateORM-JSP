package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("<title>Fitzroy Catholic Bookshop</title>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"https://www.w3schools.com/w3css/4/w3.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/css?family=Lato\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\r\n");
      out.write("<style>\r\n");
      out.write("body {font-family: \"Lato\", sans-serif; background-image: url(\"img//white.jpg\"); background-repeat: no-repeat;background-size: cover;}\r\n");
      out.write(".mySlides {display: none}\r\n");
      out.write("</style>\r\n");
      out.write("<style>\r\n");
      out.write("\r\n");
      out.write("ul.breadcrumb {\r\n");
      out.write("  padding: 10px 16px;\r\n");
      out.write("  list-style: none;\r\n");
      out.write("}\r\n");
      out.write("ul.breadcrumb li {\r\n");
      out.write("  display: inline;\r\n");
      out.write("  font-size: 18px;\r\n");
      out.write("}\r\n");
      out.write("ul.breadcrumb li+li:before {\r\n");
      out.write("  padding: 8px;\r\n");
      out.write("  color: black;\r\n");
      out.write("}\r\n");
      out.write("ul.breadcrumb li a {\r\n");
      out.write("  color: #0275d8;\r\n");
      out.write("  text-decoration: none;\r\n");
      out.write("}\r\n");
      out.write("ul.breadcrumb li a:hover {\r\n");
      out.write("  color: #01447e;\r\n");
      out.write("  text-decoration: underline;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("<!-- Navbar -->\r\n");
      out.write("<div class=\"w3-top\">\r\n");
      out.write("  <div class=\"w3-bar w3-black w3-card\">\r\n");
      out.write("   <a class=\"w3-bar-item w3-button w3-padding-large w3-hide-medium w3-hide-large w3-right\" href=\"javascript:void(0)\" onclick=\"myFunction()\" title=\"Toggle Navigation Menu\"><i class=\"fa fa-bars\"></i></a>\r\n");
      out.write("    <img src=\"img/fitzroy.png\" alt=\"Fitzroy Catholic Bookshop\" width=\"8%\" class=\"w3-left\">\r\n");
      out.write("\t<ul class=\"breadcrumb\">\r\n");
      out.write("\t<li style=\"background-color:silver\"> <a href=\"index.jsp\" class=\"w3-bar-item w3-button w3-padding-large\">HOME</a></li>\r\n");
      out.write("    <li> <a href=\"site_map.jsp\" class=\"w3-bar-item w3-button w3-padding-large w3-hide-small\">SITE MAP</a></li>\r\n");
      out.write("     <li> <a href=\"search.jsp\" class=\"w3-bar-item w3-button w3-padding-large\">SEARCH</a></li>\r\n");
      out.write("    <li> <a href=\"maintenance.jsp\" class=\"w3-bar-item w3-button w3-padding-large w3-hide-small\">MAINTENANCE</a></li>\r\n");
      out.write("\t<li> <a href=\"javascript:void(0)\" class=\"w3-padding-large w3-hover-red w3-hide-small w3-right\"><i class=\"fa fa-search\"></i></a></li>\r\n");
      out.write("\t</ul>\r\n");
      out.write("   \r\n");
      out.write("  </div>\r\n");
      out.write("</div>\r\n");
      out.write("<!-- Page content -->\r\n");
      out.write("<div class=\"w3-content\" style=\"max-width:2000px;\">\r\n");
      out.write("  <!-- The Home Section -->\r\n");
      out.write("  <div style=\"height:100%;\"><br></div>\r\n");
      out.write("  <div class=\"w3-container w3-content w3-center w3-padding-64\" style=\"max-width:800px\" id=\"home\">\r\n");
      out.write("\t</br>\r\n");
      out.write("\t<img src=\"img/fitzroy.png\" alt=\"Fitzroy Catholic Bookshop\" width=\"25%\" class=\"w3-center\">\r\n");
      out.write("    <h2 class=\"w3-wide\">Fitzroy Catholic Bookshop</h2>\r\n");
      out.write("    <p class=\"w3-opacity\"><i>We love to share</i></p>\r\n");
      out.write("    <p class=\"w3-justify\">Fitzroy Catholic Bookshop is a place where you can find your favorite book, audio book, video, and music. \r\n");
      out.write("\tOur vision is to spread love through education and entertainment. Our mission is to provide all the information you need about electronic media. \r\n");
      out.write("\tHere you can search your selected product with multiple key words.</p>\r\n");
      out.write("    <div class=\"w3-row w3-padding-30\">\r\n");
      out.write("      <div class=\"w3-third\">\r\n");
      out.write("        <p>Facebook Page</p>\r\n");
      out.write("        <i class=\"fa fa-facebook-official\"> Fitzroy Catholic Bookshop</i>\r\n");
      out.write("      </div>\r\n");
      out.write("      <div class=\"w3-third\">\r\n");
      out.write("        <p>Instagram</p>\r\n");
      out.write("       <i class=\"fa fa-instagram\"> fitzroy_catholic</i>\r\n");
      out.write("      </div>\r\n");
      out.write("      <div class=\"w3-third\">  \r\n");
      out.write("\t   <p>  Contact</p>\r\n");
      out.write("<p><i class=\"fa fa-phone\" style=\"width:30px\"></i> +61-002-602-81</p>\r\n");
      out.write("<p><i class=\"fa fa-envelope\" style=\"width:30px\"> </i>enquiry@fitzroy.com</p>\r\n");
      out.write("      </div>\r\n");
      out.write("    </div>\r\n");
      out.write("  </div>\r\n");
      out.write("\t</br>\t\r\n");
      out.write("\r\n");
      out.write("<!-- End Page Content -->\r\n");
      out.write("</div>\r\n");
      out.write("<!-- Footer -->\r\n");
      out.write("<footer class=\"w3-container w3-center w3-opacity w3-light-grey w3-xlarge\">\r\n");
      out.write("  <p class=\"fa fa-copyright\">2020 Fitzroy Catholic Bookshop</p>\r\n");
      out.write("</footer>\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("// When the user clicks anywhere outside of the modal, close it\r\n");
      out.write("var modal = document.getElementById('ticketModal');\r\n");
      out.write("window.onclick = function(event) {\r\n");
      out.write("  if (event.target == modal) {\r\n");
      out.write("    modal.style.display = \"none\";\r\n");
      out.write("  }\r\n");
      out.write("}\r\n");
      out.write("</script>\r\n");
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
