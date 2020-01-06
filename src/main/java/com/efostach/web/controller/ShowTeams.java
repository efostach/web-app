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
import java.util.ArrayList;
import java.util.List;

@WebServlet("/skill/list")
public class ShowSkills extends HttpServlet {

    private SkillRepoImpl ioSkill = new SkillRepoImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<String> skills = new ArrayList<>();
        for (Skill skill : ioSkill.getAll()) {
            skills.add(skill.toString());
        }
        req.setAttribute("skills", skills);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/views/showSkills.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
