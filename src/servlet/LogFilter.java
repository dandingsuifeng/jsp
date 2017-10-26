package servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "LogFilter")
public class LogFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("站点网址:http://www.google.co.jp");
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {
        String site = config.getInitParameter("Site");
        System.out.println("网站名称" + site);
    }

}
