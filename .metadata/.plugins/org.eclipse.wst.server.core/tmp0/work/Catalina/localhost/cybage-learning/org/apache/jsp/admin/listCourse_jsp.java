/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.45
 * Generated at: 2021-02-10 16:55:06 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.cybage.model.Course;
import java.util.List;

public final class listCourse_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/WEB-INF/lib/jstl-1.2.jar", Long.valueOf(1612355172003L));
    _jspx_dependants.put("jar:file:/D:/java-miniProject/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/cybage-learning/WEB-INF/lib/jstl-1.2.jar!/META-INF/c.tld", Long.valueOf(1153365282000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("java.util.List");
    _jspx_imports_classes.add("com.cybage.model.Course");
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems;

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.release();
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


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
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "header.jsp", out, false);
      out.write("\r\n");
      out.write("<!--Inline CSS -->\r\n");
      out.write("<style>\r\n");
      out.write(".card {\r\n");
      out.write("\twidth: 18rem;\r\n");
      out.write("\tpadding: 3%;\r\n");
      out.write("\tpadding-top: 5%;\r\n");
      out.write("\tmargin-top: 7%;\r\n");
      out.write("\tmargin-bottom: 5%;\r\n");
      out.write("\tmargin-left: 5%;\r\n");
      out.write("\tmargin-right: 5%;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".jumbotron {\r\n");
      out.write("\tbackground-color: 60c7c1;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\t/* Function to show data in modal in update functionality. */\r\n");
      out.write("\tfunction f(ci, i, n, p, d, a, de, ts, u){\r\n");
      out.write("\t\tdocument.getElementById(\"catid\").value=ci;\r\n");
      out.write("\t\tdocument.getElementById(\"cid\").value=i;\r\n");
      out.write("\t\tdocument.getElementById(\"cname\").value=n;\r\n");
      out.write("\t\tdocument.getElementById(\"cprice\").value=p;\r\n");
      out.write("\t\tdocument.getElementById(\"cduration\").value=d;\r\n");
      out.write("\t\tdocument.getElementById(\"cauthor\").value=a;\r\n");
      out.write("\t\tdocument.getElementById(\"cdescription\").value=de;\r\n");
      out.write("\t\tdocument.getElementById(\"tsubcount\").value=ts;\r\n");
      out.write("\t\tdocument.getElementById(\"curl\").value=u;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("<div class=\"col-lg-6 col-sm-12\">\r\n");
      out.write("\t<!-- Add a category card. -->\r\n");
      out.write("\t<div class=\"card\">\r\n");
      out.write("\t\t<i class=\"fa fa-plus addSymbol\" aria-hidden=\"true\"></i>\r\n");
      out.write("\t\t<div class=\"card-body\">\r\n");
      out.write("\t\t\t<h3 class=\"card-title\">New Course</h3>\r\n");
      out.write("\t\t\t<a data-toggle=\"modal\" data-target=\"#addCourseModal\"\r\n");
      out.write("\t\t\t\tclass=\"btn btn-primary\">Add a new course</a>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t");

		int categoryId = (Integer) request.getAttribute("categoryId");
	
      out.write("\r\n");
      out.write("\t<!-- Modal for adding the category. -->\r\n");
      out.write("\t<div class=\"modal fade\" id=\"addCourseModal\" tabindex=\"-1\" role=\"dialog\"\r\n");
      out.write("\t\taria-hidden=\"true\">\r\n");
      out.write("\t\t<div class=\"modal-dialog\" role=\"document\">\r\n");
      out.write("\t\t\t<div class=\"modal-content\">\r\n");
      out.write("\t\t\t\t<div class=\"modal-header\">\r\n");
      out.write("\t\t\t\t\t<h5 class=\"modal-title\" id=\"courseTitle\">Add a Course</h5>\r\n");
      out.write("\t\t\t\t\t<button type=\"button\" class=\"close\" data-dismiss=\"modal\"\r\n");
      out.write("\t\t\t\t\t\taria-label=\"Close\">\r\n");
      out.write("\t\t\t\t\t\t<span aria-hidden=\"true\">&times;</span>\r\n");
      out.write("\t\t\t\t\t</button>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"modal-body\">\r\n");
      out.write("\t\t\t\t\t<form id=\"addCourseForm\"\r\n");
      out.write("\t\t\t\t\t\taction=\"");
      out.print(request.getContextPath());
      out.write("/AdminController/addCourse?cid=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${categoryId}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\"\r\n");
      out.write("\t\t\t\t\t\tmethod=\"post\">\r\n");
      out.write("\t\t\t\t\t\t<label for=\"courseName\">Course Name:</label><input type=\"text\"\r\n");
      out.write("\t\t\t\t\t\t\tid=\"cName\" name=\"courseName\"><br> <br> <label\r\n");
      out.write("\t\t\t\t\t\t\tfor=\"coursePrice\">Course Price:</label><input type=\"text\"\r\n");
      out.write("\t\t\t\t\t\t\tid=\"cPrice\" name=\"coursePrice\"><br> <br> <label\r\n");
      out.write("\t\t\t\t\t\t\tfor=\"courseDuration\">Course Duration:</label><input type=\"text\"\r\n");
      out.write("\t\t\t\t\t\t\tid=\"cDuration\" name=\"courseDuration\"><br> <br>\r\n");
      out.write("\t\t\t\t\t\t<label for=\"courseAuthor\">Course Author:</label><input type=\"text\"\r\n");
      out.write("\t\t\t\t\t\t\tid=\"cAuthor\" name=\"courseAuthor\"><br> <br> <label\r\n");
      out.write("\t\t\t\t\t\t\tfor=\"courseDescription\">Course Description:</label>\r\n");
      out.write("\t\t\t\t\t\t<textarea rows=\"5\" cols=\"5\" id=\"cDescription\"\r\n");
      out.write("\t\t\t\t\t\t\tname=\"courseDescription\"></textarea>\r\n");
      out.write("\t\t\t\t\t\t<br> <br> <label for=\"totalSubCourse\">Sub Course\r\n");
      out.write("\t\t\t\t\t\t\tCount:</label><input type=\"text\" id=\"tSubCount\" name=\"totalSubCourse\">\r\n");
      out.write("\t\t\t\t\t\t<br> <br> <label for=\"imageUrl\">Image Url:</label><input\r\n");
      out.write("\t\t\t\t\t\t\ttype=\"text\" id=\"cUrl\" name=\"imageUrl\"><br> <input\r\n");
      out.write("\t\t\t\t\t\t\ttype=\"submit\" value=\"Add\" class=\"btn btn-primary\">\r\n");
      out.write("\t\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t<!-- Dynamic cards for listing all the courses -->\r\n");
      out.write("\t");
      //  c:forEach
      org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
      boolean _jspx_th_c_005fforEach_005f0_reused = false;
      try {
        _jspx_th_c_005fforEach_005f0.setPageContext(_jspx_page_context);
        _jspx_th_c_005fforEach_005f0.setParent(null);
        // /admin/listCourse.jsp(91,1) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
        _jspx_th_c_005fforEach_005f0.setVar("c");
        // /admin/listCourse.jsp(91,1) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
        _jspx_th_c_005fforEach_005f0.setItems(new org.apache.jasper.el.JspValueExpression("/admin/listCourse.jsp(91,1) '${courses}'",_jsp_getExpressionFactory().createValueExpression(_jspx_page_context.getELContext(),"${courses}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
        int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[] { 0 };
        try {
          int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
          if (_jspx_eval_c_005fforEach_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n");
              out.write("\t\t<div class=\"card\">\r\n");
              out.write("\t\t\t<img class=\"card-img-top\" src=\"");
              out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${c.getImageUrl()}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
              out.write("\">\r\n");
              out.write("\t\t\t<div class=\"card-body\">\r\n");
              out.write("\t\t\t\t<h3 class=\"card-title\">");
              out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${c.getCourseName()}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
              out.write("</h3>\r\n");
              out.write("\t\t\t\t<input type=\"hidden\" id=\"courseId\" name=\"courseId\"\r\n");
              out.write("\t\t\t\t\tvalue=\"");
              out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${c.getCourseId()}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
              out.write("\"> <a\r\n");
              out.write("\t\t\t\t\tid=\"updateButton\" data-toggle=\"modal\"\r\n");
              out.write("\t\t\t\t\tdata-target=\"#updateCourseModal\" class=\"btn btn-primary\"\r\n");
              out.write("\t\t\t\t\tonclick=\"f(");
              out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${c.getCourseId()}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
              out.write(',');
              out.write(' ');
              out.write('\'');
              out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${c.getCourseName()}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
              out.write("', '");
              out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${c.getCoursePrice()}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
              out.write("', '");
              out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${c.getCourseDuration()}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
              out.write("', '");
              out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${c.getCourseAuthor()}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
              out.write("', '");
              out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${c.getCourseDescription()}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
              out.write("', '");
              out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${c.getTotalSubCourse()}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
              out.write("', '");
              out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${c.getImageUrl()}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
              out.write("' )\">Update</a> <a\r\n");
              out.write("\t\t\t\t\thref=\"");
              out.print(request.getContextPath());
              out.write("/AdminController/deleteCourse?id=");
              out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ c.getCourseId()}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
              out.write("&amp;coid=");
              out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${c.getCategoryId()}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
              out.write("\"\r\n");
              out.write("\t\t\t\t\tclass=\"btn btn-primary\">Delete</a> <a\r\n");
              out.write("\t\t\t\t\thref=\"");
              out.print(request.getContextPath());
              out.write("/AdminController/listSubCourse?coid=");
              out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${c.getCourseId()}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
              out.write("\"\r\n");
              out.write("\t\t\t\t\tclass=\"btn btn-primary\">View subCourses</a>\r\n");
              out.write("\t\t\t</div>\r\n");
              out.write("\t\t</div>\r\n");
              out.write("\t");
              int evalDoAfterBody = _jspx_th_c_005fforEach_005f0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_c_005fforEach_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
            return;
          }
        } catch (java.lang.Throwable _jspx_exception) {
          while (_jspx_push_body_count_c_005fforEach_005f0[0]-- > 0)
            out = _jspx_page_context.popBody();
          _jspx_th_c_005fforEach_005f0.doCatch(_jspx_exception);
        } finally {
          _jspx_th_c_005fforEach_005f0.doFinally();
        }
        _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f0);
        _jspx_th_c_005fforEach_005f0_reused = true;
      } finally {
        org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fforEach_005f0, _jsp_getInstanceManager(), _jspx_th_c_005fforEach_005f0_reused);
      }
      out.write("\r\n");
      out.write("\t<!-- Modal for updating the course. -->\r\n");
      out.write("\t<div class=\"modal fade\" id=\"updateCourseModal\" tabindex=\"-1\"\r\n");
      out.write("\t\trole=\"dialog\" aria-hidden=\"true\">\r\n");
      out.write("\t\t<div class=\"modal-dialog\" role=\"document\">\r\n");
      out.write("\t\t\t<div class=\"modal-content\">\r\n");
      out.write("\t\t\t\t<div class=\"modal-header\">\r\n");
      out.write("\t\t\t\t\t<h5 class=\"modal-title\" id=\"courseTitle\">Update Course</h5>\r\n");
      out.write("\t\t\t\t\t<button type=\"button\" class=\"close\" data-dismiss=\"modal\"\r\n");
      out.write("\t\t\t\t\t\taria-label=\"Close\">\r\n");
      out.write("\t\t\t\t\t\t<span aria-hidden=\"true\">&times;</span>\r\n");
      out.write("\t\t\t\t\t</button>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"modal-body\">\r\n");
      out.write("\t\t\t\t\t<form id=\"updateCourseForm\"\r\n");
      out.write("\t\t\t\t\t\taction=\"");
      out.print(request.getContextPath());
      out.write("/AdminController/updateCourse\"\r\n");
      out.write("\t\t\t\t\t\tmethod=\"post\">\r\n");
      out.write("\t\t\t\t\t\t<input type=\"text\"\r\n");
      out.write("\t\t\t\t\t\t\tid=\"catid\" name=\"catId\" readonly=\"readonly\"><br>\r\n");
      out.write("\t\t\t\t\t\t<label for=\"courseId\">Course Id:</label><input type=\"text\"\r\n");
      out.write("\t\t\t\t\t\t\tid=\"cid\" name=\"courseId\" readonly=\"readonly\"><br> <label\r\n");
      out.write("\t\t\t\t\t\t\tfor=\"courseName\">Category Name:</label><input type=\"text\"\r\n");
      out.write("\t\t\t\t\t\t\tid=\"cname\" name=\"courseName\"><br> <br> <label\r\n");
      out.write("\t\t\t\t\t\t\tfor=\"coursePrice\">Course Price:</label><input type=\"text\"\r\n");
      out.write("\t\t\t\t\t\t\tid=\"cprice\" name=\"coursePrice\"><br> <br> <label\r\n");
      out.write("\t\t\t\t\t\t\tfor=\"courseDuration\">Course Duration:</label><input type=\"text\"\r\n");
      out.write("\t\t\t\t\t\t\tid=\"cduration\" name=\"courseDuration\"><br> <br>\r\n");
      out.write("\t\t\t\t\t\t<label for=\"courseAuthor\">Course Author:</label><input type=\"text\"\r\n");
      out.write("\t\t\t\t\t\t\tid=\"cauthor\" name=\"courseAuthor\"><br> <br> <label\r\n");
      out.write("\t\t\t\t\t\t\tfor=\"courseDescription\">Course Description:</label>\r\n");
      out.write("\t\t\t\t\t\t<textarea rows=\"5\" cols=\"5\" id=\"cdescription\"\r\n");
      out.write("\t\t\t\t\t\t\tname=\"courseDescription\"></textarea>\r\n");
      out.write("\t\t\t\t\t\t<br> <label for=\"totalSubCourse\">Sub Course Count:</label><input\r\n");
      out.write("\t\t\t\t\t\t\ttype=\"text\" id=\"tsubcount\" name=\"totalSubCourse\"><br>\r\n");
      out.write("\t\t\t\t\t\t<br> <br> <label for=\"imageUrl\">Image Url:</label><input\r\n");
      out.write("\t\t\t\t\t\t\ttype=\"text\" id=\"curl\" name=\"imageUrl\"><br> <input\r\n");
      out.write("\t\t\t\t\t\t\ttype=\"submit\" value=\"Update\" class=\"btn btn-primary\">\r\n");
      out.write("\t\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</div>\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "footer.jsp", out, false);
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}