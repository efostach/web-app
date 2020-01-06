package com.efostach.web.controller;

import com.efostach.web.model.Team;
import com.efostach.web.repository.hibernate.TeamRepoImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/team/update")
public class UpdateTeam extends HttpServlet {

    private TeamRepoImpl ioTeam = new TeamRepoImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/views/updateTeam.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        String name = req.getParameter("name");
        Team team = ioTeam.getById(id);

        team.setName(name);
        ioTeam.update(team);

       doGet(req, resp);
    }
}