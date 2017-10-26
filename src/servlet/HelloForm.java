package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

@WebServlet(name = "HelloForm")
public class HelloForm extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie name = new Cookie("name", URLEncoder.encode(request.getParameter("name"), "UTF-8"));
        Cookie url = new Cookie("url", request.getParameter("url"));

        name.setMaxAge(60 * 60 * 24);
        url.setMaxAge(60 * 60 * 24);

        response.addCookie(name);
        response.addCookie(url);

        response.setContentType("text/html;charser=UTF-8");

        PrintWriter out = response.getWriter();
        String title = "Cookie 实例";
        String docType = "!<DOCTYPE html>";
        out.print(docType + "<html lang=\"zh-CN\">\n" + "<head><title>" + title + "</title></head>" + "<body>\n" + "<h1 align=\"center\">" + title + "</h1>\n" + "<ul>\n"
                + "<li><b>站点名：</b>:" + request.getParameter("name") + "\n</li>" + "  <li><b>站点 URL：</b>："
                + request.getParameter("url") + "\n</li>" +
                "</ul>\n" +
                "</body></html>"
        );
    }
}
