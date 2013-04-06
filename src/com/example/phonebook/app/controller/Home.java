package com.example.phonebook.app.controller;

import com.example.phonebook.app.dao.AppDao;
import com.example.phonebook.app.dao.AppDaoFactory;
import com.example.phonebook.login.dto.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Author: Pramod Bhandari
 * Date: 4/3/13
 * Time: 8:13 AM
 */
public class Home extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession(false);
        RequestDispatcher view;
        List contacts = new ArrayList();
        User user;
        try {
            String search=request.getParameter("search");
            System.out.println("Search string: "+search);
            user = (User) session.getAttribute("user");
            System.out.println(user.getFirstName());
            AppDao dao = AppDaoFactory.getAppDao();
            contacts = dao.getContacts(user,search);
            request.setAttribute("contacts", contacts);
            request.setAttribute("search",search);
            view = request.getRequestDispatcher("pages/home.jsp");
            view.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("login");
//            view = request.getRequestDispatcher("pages/login.jsp");
//            view.forward(request,response);
        }


    }
}
