package ro.robertgabriel;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ro.robertgabriel.dao.MongoDBListDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class HomeController {


    @ResponseBody
    @RequestMapping("/")
    public void getHome(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MongoDBListDao mongoDBListDao = new MongoDBListDao();

        List lists = mongoDBListDao.readAllList() ;

        request.setAttribute("lists", lists);

        request.getRequestDispatcher("WEB-INF/jsp/index.jsp").forward(request, response);
    }
}
