package com.efostach.web.controller;

import com.efostach.web.model.Employee;
import com.efostach.web.model.Team;
import com.efostach.web.repository.hibernate.EmployeeRepoImpl;
import com.efostach.web.repository.hibernate.TeamRepoImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.efostach.web.controller.ControllerUtil.REF_OBJ_NOT_EXISTS_WARN_MSG;

@WebServlet("/team/create")
public class CreateTeam extends HttpServlet {

    private TeamRepoImpl ioTeam = new TeamRepoImpl();
    private EmployeeRepoImpl ioEmployee = new EmployeeRepoImpl();

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/views/createTeam.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String employee = req.getParameter("employee");

        Team team = new Team();
        team.setName(name);

        if (!team.equals("")) {
            List<Employee> employees = new ArrayList<>();
            if (ioEmployee.getById(Integer.valueOf(employee)) != null) {
                employees.add(ioEmployee.getById(Integer.valueOf(employee)));
            } else
                req.setAttribute("warning_msg", REF_OBJ_NOT_EXISTS_WARN_MSG);
            team.setEmployees(employees);
        } else
            req.setAttribute("warning_msg", REF_OBJ_NOT_EXISTS_WARN_MSG);

        ioTeam.create(team);

        doGet(req, resp);
    }
}
