package com.efostach.web.controller;

import com.efostach.web.model.Employee;
import com.efostach.web.model.Skill;
import com.efostach.web.repository.hibernate.EmployeeRepoImpl;
import com.efostach.web.repository.hibernate.SkillRepoImpl;

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

@WebServlet("/employee/create")
public class CreateEmployee extends HttpServlet {

    private EmployeeRepoImpl ioEmployee = new EmployeeRepoImpl();
    private SkillRepoImpl ioSkill = new SkillRepoImpl();

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/views/createEmployee.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("first_name");
        String lastName = req.getParameter("last_name");
        Integer specialty = Integer.valueOf(req.getParameter("specialty"));
        String skill = req.getParameter("skill");

        Employee employee = new Employee();
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employee.setSpecialty(specialty);

        if (!skill.equals("")) {
            List<Skill> skills = new ArrayList<>();
            if (ioSkill.getById(Integer.valueOf(skill)) != null) {
                skills.add(ioSkill.getById(Integer.valueOf(skill)));
            } else
                req.setAttribute("warning_msg", REF_OBJ_NOT_EXISTS_WARN_MSG);
            employee.setSkills(skills);
        } else
            req.setAttribute("warning_msg", REF_OBJ_NOT_EXISTS_WARN_MSG);

        ioEmployee.create(employee);

        doGet(req, resp);
    }
}