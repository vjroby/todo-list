package main.java;


import main.java.dao.MongoDBListDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class Home extends HttpServlet{

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        MongoDBListDao mongoDBListDao = new MongoDBListDao();

        List lists = mongoDBListDao.readAllList() ;

        request.setAttribute("lists", lists);

        request.getRequestDispatcher("WEB-INF/jsp/index.jsp").forward(request, response);
    }
}