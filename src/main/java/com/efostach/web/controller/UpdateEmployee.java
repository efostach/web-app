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

@WebServlet("/employee/update")
public class UpdateEmployee extends HttpServlet {

    private EmployeeRepoImpl ioEmployee = new EmployeeRepoImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/views/updateEmployee.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        String firstName = req.getParameter("first_name");
        String lastName = req.getParameter("last_name");
        String specialty = req.getParameter("specialty");
        Employee employee = ioEmployee.getById(id);

        if(!firstName.equals(""))
            employee.setFirstName(firstName);
        if(!lastName.equals(""))
            employee.setLastName(lastName);
        if(!specialty.equals("") )
        employee.setSpecialty(Integer.valueOf(specialty));
        ioEmployee.update(employee);

       doGet(req, resp);
    }
}