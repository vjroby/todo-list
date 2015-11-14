package ro.robertgabriel.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ro.robertgabriel.dao.MongoDBListDao;
import ro.robertgabriel.frontend.Configuration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping(value = {"/"})
public class HomeController {

    @Autowired
    private Configuration configuration;

    @ResponseBody
    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public void getHome(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MongoDBListDao mongoDBListDao = new MongoDBListDao();

        List lists = mongoDBListDao.readAllList() ;

        request.setAttribute("lists", lists);
        request.setAttribute("configuration", getConfiguration());

        request.getRequestDispatcher("WEB-INF/jsp/index.jsp").forward(request, response);
    }

    public Configuration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(Configuration configuration) {
        this.configuration = configuration;
    }
}
