package com.joannesaunders.controller;


import com.joannesaunders.persistence.UserDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * A simple servlet to search the user database.
 * @author jasaunders
 */

@WebServlet(
        urlPatterns = {"/searchUser"}
)

public class SearchUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UserDao userDao = new UserDao();
        String url = null;

        if (req.getParameter("submit").equals("Search")) {
            req.setAttribute("users", userDao.getUsersByLastName(req.getParameter("searchTerm")));
        } else {
            req.setAttribute("users", userDao.getAllUsers());
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("/admin_search_results.jsp");
        dispatcher.forward(req, resp);
    }
}