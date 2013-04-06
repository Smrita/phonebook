package com.example.phonebook.login.controller;

import com.example.phonebook.login.dao.LoginDao;
import com.example.phonebook.login.dao.LoginDaoFactory;
import com.example.phonebook.login.dto.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

/**
 * Author: Pramod Bhandari
 * Date: 3/26/13
 * Time: 8:46 PM
 */
public class Login extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        LoginDao dao;
        String username = new String();
        String password = new String();
        String remember = new String();
        User user;
        try {
            dao = LoginDaoFactory.getLoginDao();
            username = request.getParameter("username");
            password = request.getParameter("password");
            remember = request.getParameter("remember");
            System.out.println("====================================");
            System.out.println("uname: " + username + "pass: " + password);
            System.out.println("====================================");
            System.out.println("remember: " + remember);
            user = dao.login(username, password);
            System.out.println("User login, Id:" + user.getId());
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            if (remember.equals("true")) {
                String cookieToken = UUID.randomUUID().toString();
                Cookie cookie = new Cookie("auth", cookieToken);
                cookie.setMaxAge(30 * 24 * 60 * 60);
                response.addCookie(cookie);
                dao.setRememberToken(user, cookieToken);
            }
            response.sendRedirect("home");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("login");
        }

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session;
        RequestDispatcher view;
        LoginDao dao;
        User user;
        Cookie cookie;
        try {
            session = request.getSession(false);

            if (session != null && session.getAttribute("user") != null) {
                user = (User) session.getAttribute("user");
                response.sendRedirect("home");
            } else {
                user = null;
                Cookie[] cookies = request.getCookies();
                for (int i = 0; i < cookies.length; i++) {
                    cookie = cookies[i];
                    if (cookie.getName().equals("auth")) {
                        dao = LoginDaoFactory.getLoginDao();
                        String authToken = cookie.getValue();
                        user = dao.getUserFromAuthToken(authToken);
                        if (user != null) {
                            session = request.getSession();
                            session.setAttribute("user", user);
                            response.sendRedirect("home");
                        } else {
                            view = request.getRequestDispatcher("pages/login.jsp");
                            view.forward(request, response);
                        }

                    }


                }
                view = request.getRequestDispatcher("pages/login.jsp");
                view.forward(request, response);

            }
        } catch (Exception e) {
            e.printStackTrace();
            view = request.getRequestDispatcher("pages/login.jsp");
            view.forward(request, response);
        }


//        try {
//            Cookie[] cookies = request.getCookies();
//            for (int i = 0; i < cookies.length; i++) {
//                Cookie cookie = cookies[i];
//                if (cookie.getName().equals("identification")) {
//                    dao = LoginDaoFactory.getLoginDao();
//
//                    String authToken = cookie.getValue();
//                    User user = dao.getUserFromAuthToken(authToken);
//                    if (user != null) {
//                        session.setAttribute("user", user);
//                    }
//
//                }
//
//
//            }
//        } catch (Exception ex) {
//
//        }
//


//        Cookie[] cookies = request.getCookies();
//        for (int i = 0; i < cookies.length; i++) {
//            Cookie cookie = cookies[i];
//            if (cookie.getName().equals("identification")) {
//                String cookieValue = cookie.getValue();
//
//                User user = dao.getUserByRemeberMe(ucookieValue);
//                HibernateUtil.commitTransaction();
//
//                if (user != null) {
//                    this.setReturnPage("/landingpage.jsp");
//                    this.getRequest().setAttribute("categories", categories);
//                    this.getRequest().getSession().setAttribute("role", user.getRole());
//                } else {
//                    this.setReturnPage("/login.jsp");
//                }
//
//            }
//
//
//        }


    }
}
