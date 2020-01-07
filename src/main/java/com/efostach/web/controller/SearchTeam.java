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

import static com.efostach.web.controller.ControllerUtil.EMPTY_INPUT_VALUE_WARN_MSG;
import static com.efostach.web.controller.ControllerUtil.OBJ_NOT_FOUND_WARN_MSG;

@WebServlet("/team/search")
public class SearchTeam extends HttpServlet {

    private TeamRepoImpl ioTeam = new TeamRepoImpl();

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/views/searchTeam.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (!req.getParameter("id").isEmpty()) {
            Integer id = Integer.valueOf(req.getParameter("id"));

            Team team = ioTeam.getById(id);
            if (team == null) {
                req.setAttribute("warning_msg", OBJ_NOT_FOUND_WARN_MSG);
            }
            req.setAttribute("team", team);
        } else
            req.setAttribute("warning_msg", EMPTY_INPUT_VALUE_WARN_MSG);
        doGet(req, resp);
    }
}
