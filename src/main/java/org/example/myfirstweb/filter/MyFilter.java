package org.example.myfirstweb.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.Getter;
import org.example.myfirstweb.entity.User;
import org.example.myfirstweb.enums.Role;

import java.io.IOException;

@WebFilter("/*")
public class MyFilter implements Filter {
    @Getter
    private static User CurrentUser;


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String servletPath = request.getServletPath();


        if (servletPath.contains("sign")) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }
        if (servletPath.contains("auth")) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }


        HttpSession session = request.getSession();
        Object user1 = session.getAttribute("user");

        if (user1 == null) {
            request.getRequestDispatcher("/signin").forward(request, servletResponse);
            return;
        }
        assert CurrentUser != null;
        CurrentUser = (User) session.getAttribute("user");

        System.out.println("--Current user is-- " + CurrentUser);
        if (!CurrentUser.getRole().equals(Role.ADMIN)) {
            if (
                    servletPath.contains("admincabinet")
                            || servletPath.contains("addrent")
                            || servletPath.contains("showrents")
                            || servletPath.contains("showusers")
                            || servletPath.contains("updateuser")


                            || servletPath.contains("showbooks")
                            || servletPath.contains("addbook")
                            || servletPath.contains("updatebook")

//                            || servletPath.contains("deletebook")
//                            || servletPath.contains("deleteuser")

                            || servletPath.contains("malumotlar")
                            || servletPath.contains("showactiveusers")
                            || servletPath.contains("showpassiveusers")
                            || servletPath.contains("showactiverents")
                            || servletPath.contains("showpassiverents")
                            || servletPath.contains("showrentsMU")


            ) {
                request.setAttribute("warning", "Faqat ADMIN huquqi bor!");
                request.setAttribute("url", "/signin");
                request.getRequestDispatcher("templates/WARNING.jsp").forward(request, servletResponse);
                return;
            }
        }

//        if (!CurrentUser.getRole().equals(Role.USER)) {
//            if (
//                    servletPath.contains("usercabinet")
//                            || servletPath.contains("addrentuserCabinet")
//                            || servletPath.contains("showrentuser")
//                            || servletPath.contains("returnrentuser")
//                            || servletPath.contains("user-showbooks")
//                            || servletPath.contains("addrentuser")
//                            || servletPath.contains("Ushowactiverents")
//                            || servletPath.contains("Ushowpassiverents")
//
//
//            ) {
//                request.setAttribute("warning", "Faqat USER huquqi bor!");
//                request.setAttribute("url","/signin");
//                request.getRequestDispatcher("templates/WARNING.jsp").forward(request, servletResponse);
//                return;
//            }
//
//        }


        filterChain.doFilter(servletRequest, servletResponse);
    }
}
