package com.efostach.web.controller;

import com.efostach.web.model.Customer;
import com.efostach.web.repository.hibernate.CustomerRepoImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.efostach.web.controller.ControllerUtil.EMPTY_INPUT_VALUE_WARN_MSG;
import static com.efostach.web.controller.ControllerUtil.OBJ_NOT_FOUND_WARN_MSG;

@WebServlet("/customer/search")
public class SearchCustomer extends HttpServlet {

    private CustomerRepoImpl ioCustomer = new CustomerRepoImpl();

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/views/searchCustomer.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (!req.getParameter("id").isEmpty()) {
            Integer id = Integer.valueOf(req.getParameter("id"));

            Customer customer = ioCustomer.getById(id);
            if (customer == null) {
                req.setAttribute("warning_msg", OBJ_NOT_FOUND_WARN_MSG);
            }
            req.setAttribute("customer", customer);
        } else
            req.setAttribute("warning_msg", EMPTY_INPUT_VALUE_WARN_MSG);
        doGet(req, resp);
    }
}