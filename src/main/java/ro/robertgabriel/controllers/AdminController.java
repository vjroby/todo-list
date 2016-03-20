package ro.robertgabriel.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ro.robertgabriel.entities.AccessLog;
import ro.robertgabriel.services.DefaultAccessLogService;


@Controller
public class AdminController extends BaseController {

    @Autowired
    public DefaultAccessLogService defaultAccessLogService;

    @RequestMapping(value = {"/admin/access_logs", "/admin/access_log/{page}"}, method = RequestMethod.GET)
    public ModelAndView getAccessLogs(@RequestParam(defaultValue = "0") Integer page) {
        ModelAndView modelAndView = new ModelAndView("accessLogsPage");
        modelAndView.addObject("user", getAuthenticatedUser());
        Page<AccessLog> logs =  defaultAccessLogService.getPaginated(managePageAndSort(page));
        modelAndView.addObject("access_logs", logs.getContent());
        setPageParamToModel(modelAndView, logs);
        return modelAndView;
    }

    private PageRequest managePageAndSort(Integer page) {
        int pageInt = page;
        Sort sort = new Sort(new Sort.Order(Sort.Direction.DESC, "created"));
        return new PageRequest(pageInt, itemsPerPage, sort);
    }
    private void setPageParamToModel(ModelAndView model, Page page) {
        model.addObject("totalPages",page.getTotalPages());
        model.addObject("totalItems", page.getTotalElements());
        model.addObject("hasNext", page.hasNext());
        model.addObject("hasPrevious", page.hasPrevious());
        model.addObject("currentPage", page.getNumber());
    }
}
