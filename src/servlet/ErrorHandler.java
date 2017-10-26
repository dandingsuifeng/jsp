package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ErrorHandler")
public class ErrorHandler extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Throwable throwable = (Throwable) request.getAttribute("javax.servlet.error.exception");
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.servlet_code");
        String servletName = (String) request.getAttribute("javax.servlet.error.servlet_name");
        if (servletName == null) {
            servletName = "Unknown";
        }
        String requestUri = (String) request.getAttribute("javax.servlet.error.request_uri");
        if (requestUri == null) {
            requestUri = "Unknown";
        }
        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();
        String title = "Error/Exception message";

        String docType = "<!DOCTYPE html>\n";
        out.print(docType + "<html>\n" + "<head><title>" + title + "</title></head>\n" + "<body>\n");
        out.print("<h1>异常信息实例</h1>");
        if (throwable == null && statusCode == null) {
            out.println("<h2>错误信息丢失</h2>");
            out.println("请返回 <a href=\"" + response.encodeURL("http://localhost:8080/") + "\" >主页</a>");
        } else if (statusCode != null) {
            out.println("错误代码 : " + statusCode);
        } else {
            out.println("<h2>错误信息</h2>");
            out.print("Servlet Name :" + servletName + "</br></br>");
            out.println("异常类型 : " +
                    throwable.getClass().getName() +
                    "</br></br>");
            out.println("请求 URI: " + requestUri +
                    "<br><br>");
            out.println("异常信息: " +
                    throwable.getMessage());
        }
        out.println("</body>");
        out.println("</html>");
    }
}
