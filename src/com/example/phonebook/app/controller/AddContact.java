package com.example.phonebook.app.controller;

import com.example.phonebook.app.dao.AppDao;
import com.example.phonebook.app.dao.AppDaoFactory;
import com.example.phonebook.app.dto.Contact;
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
 * Time: 11:11 PM
 */
public class AddContact extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Contact contact = new Contact();
        try {
            AppDao dao = AppDaoFactory.getAppDao();
            HttpSession session = request.getSession(false);
            User user = (User) session.getAttribute("user");
            contact.setFirstName(request.getParameter("firstName"));
            contact.setMiddleName(request.getParameter("middleName"));
            contact.setLastName(request.getParameter("lastName"));
            contact.setAddress(request.getParameter("address"));
            contact.setPhone(request.getParameter("phone"));
            contact.setUserId(user.getId());
            dao.addContact(contact);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            response.sendRedirect("home");

        }

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        RequestDispatcher view;
        HttpSession session = request.getSession(false);
        try {

            User user = (User) session.getAttribute("user");
            System.out.println(user.getFirstName());
            view = request.getRequestDispatcher("pages/add.jsp");
            view.forward(request, response);
        } catch (Exception e) {
            response.sendRedirect("home");

        }
    }

}