package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

@WebServlet(name = "ReadCookies")
public class ReadCookies extends HttpServlet {
    public ReadCookies() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie cookie = null;
        Cookie[] cookies = null;
        cookies = request.getCookies();

        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();
        String title = "Delete Cookie Example";
        String docType = "<!DOCTYPE html>\n";
        out.println(docType +
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body bgcolor=\"#f0f0f0\">\n");
        if (cookies != null) {
            out.println("<h2>Cookie 名称和值</h2>");
            for (int i = 0; i < cookies.length; i++) {
                cookie = cookies[i];
                if ((cookie.getName()).compareTo("name") == 0) {
                    cookie.setMaxAge(0);
                    response.addCookie(cookie);
                    out.print("已删除的 cookie：" +
                            cookie.getName() + "<br/>");
                }
                out.print("名称：" + cookie.getName() + "，");
                out.print("值：" + URLDecoder.decode(cookie.getValue(), "utf-8") + " <br/>");
            }
        } else {
            out.println(
                    "<h2 class=\"tutheader\">No Cookie founds</h2>");
        }
        out.println("</body>");
        out.println("</html>");
    }
}
