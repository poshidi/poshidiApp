package com.poshidi;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.poshidi.dao.RegionDao;
import com.poshidi.util.TreeHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
public class RestConstroller {
    public RestConstroller() {}
    private RegionDao dao;

    @Resource
    public void setDao(RegionDao dao) {
        this.dao = dao;
    }

    @RequestMapping(value = "/login/{user}", method = RequestMethod.GET)
    public ModelAndView myMethod(HttpServletRequest request,HttpServletResponse response,
                                 @PathVariable("user") String user, ModelMap modelMap) throws Exception {
        modelMap.put("loginUser", user);
        return new ModelAndView("/login/hello", modelMap);
    }
    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public String registPost() {
        return "/welcome";
    }

    @RequestMapping(value = "/treegrid", method = RequestMethod.GET)
    public String treegrid() {
        return "/demo/treegrid";
    }

    @ResponseBody
    @RequestMapping(value = "/getJsonTree", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public String getJsonTree() {
        List<Map> list;
        list = dao.getMapList();
        String jsonStr = TreeHelper.getAllChildrenJSONTrees(list, "0000");
        return "["+jsonStr+"]";
    }



}
