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

@WebServlet("/skill/update")
public class UpdateSkill extends HttpServlet {

    private SkillRepoImpl ioSkill = new SkillRepoImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/views/updateSkill.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        String name = req.getParameter("name");
        Skill skill = ioSkill.getById(id);

        skill.setName(name);
        ioSkill.update(skill);

       doGet(req, resp);
    }
}