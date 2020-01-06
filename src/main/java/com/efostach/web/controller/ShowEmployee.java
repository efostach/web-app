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
import java.util.ArrayList;
import java.util.List;

@WebServlet("/employee/list")
public class ShowEmployee extends HttpServlet {

    private EmployeeRepoImpl ioEmployee = new EmployeeRepoImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<String> employees = new ArrayList<>();
        for (Employee employee : ioEmployee.getAll()) {
            employees.add(employee.toString());
        }
        req.setAttribute("employees", employees);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/views/showEmployees.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
