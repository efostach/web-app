package com.efostach.web.controller;

import com.efostach.web.model.Skill;
import com.efostach.web.repository.hibernate.SkillRepoImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/skill/create")
public class CreateSkill extends HttpServlet {

    private SkillRepoImpl ioSkill = new SkillRepoImpl();

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/views/createSkill.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");

        Skill skill = new Skill();
        skill.setName(name);
        ioSkill.create(skill);

        doGet(req, resp);
    }
}
