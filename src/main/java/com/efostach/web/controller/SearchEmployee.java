package com.efostach.web.controller;

import com.efostach.web.model.Employee;
import com.efostach.web.repository.hibernate.EmployeeRepoImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.efostach.web.controller.Util.EMPTY_INPUT_VALUE_WARN_MSG;
import static com.efostach.web.controller.Util.OBJ_NOT_FOUND_WARN_MSG;

@WebServlet("/employee/search")
public class SearchEmployee extends HttpServlet {

    private EmployeeRepoImpl ioEmployee = new EmployeeRepoImpl();

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/views/searchEmployee.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (!req.getParameter("id").isEmpty()) {
            Integer id = Integer.valueOf(req.getParameter("id"));

            Employee employee = ioEmployee.getById(id);
            if (employee == null) {
                req.setAttribute("warning_msg", OBJ_NOT_FOUND_WARN_MSG);
            }
            req.setAttribute("employee", employee);
        } else
            req.setAttribute("warning_msg", EMPTY_INPUT_VALUE_WARN_MSG);
        doGet(req, resp);
    }
}